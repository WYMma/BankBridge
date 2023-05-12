package CONTROLLER;

import MODEL.Admin;
import MODEL.CompteBanquaire;
import MODEL.User;
import Methodes.AjoutCompte;
import Methodes.AjoutUser;
import Methodes.CustomTableCellRenderer;
import Methodes.SingletonConnection;
import VIEW.AdminView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminController {
    public AdminController(String login) {
        AdminView.admin = newAdmin(login);
        new AdminView();
    }

    public static void AjouterClient() {
        AjoutUser myForm = new AjoutUser(null);
        User user = myForm.user;
        if (user != null) {
            JOptionPane.showMessageDialog(null, "Enregistrement réussi de :" + user.getNom());
        } else {
            JOptionPane.showMessageDialog(null, "Inscription annulée");
        }
    }

    public static void AjouterCompte() {
        AjoutCompte myForm = new AjoutCompte(null);
        CompteBanquaire compte = myForm.compte;
        if (compte != null) {
            JOptionPane.showMessageDialog(null, "Enregistrement réussi de :" + compte.getRIB());
        } else {
            JOptionPane.showMessageDialog(null, "Création annulée");
        }
    }
    public static Admin newAdmin(String login) {
        Admin admin = new Admin();
        Connection conn = SingletonConnection.getInstance();
        try {
            PreparedStatement ps;
            ps = conn.prepareStatement("SELECT * FROM user WHERE Login = ?;");
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                admin.setID(rs.getInt("ID"));
                admin.setMDP(AjoutUser.decrypt(rs.getString("MDP")));
                admin.setNom(rs.getString("Nom"));
                admin.setPrenom(rs.getString("Prenom"));
                admin.setAdr(rs.getString("Adr"));
                admin.setTel(rs.getLong("Tel"));
                admin.setEmail(rs.getString("Email"));
                admin.setType(rs.getString("Type"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
    public static void SuprimerCompte(String rib) {
        Connection conn = SingletonConnection.getInstance();
        try {
            PreparedStatement ps;
            ps = conn.prepareStatement("DELETE FROM comptebanquaire WHERE RIB = ?");
            ps.setString(1, rib);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Supression réussi");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void SuprimerClient(String id) {
        Connection conn = SingletonConnection.getInstance();
        try {
            PreparedStatement ps;
            ps = conn.prepareStatement("DELETE FROM user  WHERE ID = ?");
            ps.setString(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Supression réussi");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void EnregistrerCompte(String rib, String solde, String type, String prop, String nomBank) {
        try {
            PreparedStatement vp = SingletonConnection.getInstance().prepareStatement("SELECT comptebanquaire.Prop FROM comptebanquaire INNER JOIN user ON comptebanquaire.Prop = user.ID WHERE CONCAT(user.Nom, ' ' ,user.Prenom) = ?;");
            vp.setString(1, prop);
            ResultSet vs = vp.executeQuery();
            if (vs.next()) {
                PreparedStatement vp2 = SingletonConnection.getInstance().prepareStatement("SELECT idbanks FROM banks WHERE banks.nomBank = ?;");
                vp2.setString(1, nomBank);
                ResultSet vs2 = vp2.executeQuery();
                if (vs2.next()){
                    Connection conn = SingletonConnection.getInstance();
                    try {
                        PreparedStatement ps;
                        ps = conn.prepareStatement("UPDATE comptebanquaire SET RIB = ?, Solde = ?, Type = ?, Prop = ?, idBank = ? WHERE RIB = ?");
                        ps.setString(1, String.valueOf(rib));
                        ps.setString(2, String.valueOf(solde));
                        ps.setString(3, String.valueOf(type));
                        ps.setString(4, String.valueOf(vs.getInt("Prop")));
                        ps.setString(5, String.valueOf(vs2.getInt("idbanks")));
                        ps.setString(6, String.valueOf(rib));
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Operation réussi");
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Données invalide");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Données invalide");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void EnregistrerClient(String id, String log, String mdp, String nom, String pre, String email, String tel, String adr, String type) {
        Connection conn = SingletonConnection.getInstance();
        try {
            PreparedStatement ps;
            ps = conn.prepareStatement("UPDATE user SET Login=?, MDP=?, Nom = ?, Prenom = ?, Email = ?, Tel = ?, Adr = ?, Type = ? WHERE ID = ?");
            ps.setString(1, String.valueOf(log));
            ps.setString(2, String.valueOf(mdp));
            ps.setString(3, String.valueOf(nom));
            ps.setString(4, String.valueOf(pre));
            ps.setString(5, String.valueOf(email));
            ps.setString(6, String.valueOf(tel));
            ps.setString(7, String.valueOf(adr));
            ps.setString(8, String.valueOf(type));
            ps.setString(9, String.valueOf(id));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Operation réussi");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void loadBank(String where, Object... search) {
        try {
            DefaultTableModel model = (DefaultTableModel) AdminView.TableCompte.getModel();
            model.setRowCount(0);
            PreparedStatement ps = SingletonConnection.getInstance().prepareStatement("SELECT comptebanquaire.RIB, comptebanquaire.Solde, comptebanquaire.Type, user.Nom, user.Prenom, banks.nomBank FROM comptebanquaire INNER JOIN user ON comptebanquaire.Prop = user.ID inner join banks on banks.idbanks = comptebanquaire.idBank " + where);
            for (int i = 0; i < search.length; i++) {
                ps.setObject(i + 1, search[i]);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{rs.getLong("RIB"), rs.getDouble("Solde"), rs.getString("Type"), rs.getString("Nom") + " " + rs.getString("Prenom"), rs.getString("nomBank")});
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        AdminView.TableCompte.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        AdminView.TableCompte.setShowGrid(false);
        AdminView.TableCompte.setIntercellSpacing(new Dimension(2, 2));
        AdminView.cardLayout.show(AdminView.panel3, "card1");
    }

    public static void loadUser(String where, Object... search) {
        try {
            DefaultTableModel model = (DefaultTableModel) AdminView.TableUtilisateur.getModel();
            model.setRowCount(0);
            PreparedStatement ps = SingletonConnection.getInstance().prepareStatement("SELECT * FROM user " + where);
            for (int i = 0; i < search.length; i++) {
                ps.setObject(i + 1, search[i]);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("ID"), rs.getString("Login"), AjoutUser.decrypt(rs.getString("MDP")), rs.getString("Nom"), rs.getString("Prenom"), rs.getString("Adr"), rs.getString("Tel"), rs.getString("Email"), rs.getString("Type").toLowerCase()});
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        AdminView.TableUtilisateur.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        AdminView.TableUtilisateur.setShowGrid(false);
        AdminView.TableUtilisateur.setIntercellSpacing(new Dimension(2, 2));
        AdminView.cardLayout.show(AdminView.panel3, "card3");
    }
}