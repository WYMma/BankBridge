package CONTROLLER;

import MODEL.Banquier;
import Methodes.AjoutUser;
import Methodes.SingletonConnection;
import VIEW.BanquierView;
import Methodes.CustomTableCellRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BanquierController {
    public BanquierController(String login) {
        BanquierView.banquier = newBanquier(login);
        new BanquierView();

    }
    public static Banquier newBanquier(String login) {
        Banquier banquier = new Banquier();
        Connection conn = SingletonConnection.getInstance();
        try {
            PreparedStatement ps;
            ps = conn.prepareStatement("SELECT * FROM user WHERE Login = ?;");
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                banquier.setID(rs.getInt("ID"));
                banquier.setMDP(AjoutUser.decrypt(rs.getString("MDP")));
                banquier.setNom(rs.getString("Nom"));
                banquier.setPrenom(rs.getString("Prenom"));
                banquier.setAdr(rs.getString("Adr"));
                banquier.setTel(rs.getLong("Tel"));
                banquier.setEmail(rs.getString("Email"));
                banquier.setType(rs.getString("Type"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return banquier;
    }
    public static void Debiter(long sen, int mo) {
        Connection conn = SingletonConnection.getInstance();
        try {
            PreparedStatement ps;
            ps = conn.prepareStatement("UPDATE comptebanquaire SET Solde = Solde - ? WHERE RIB = ?");
            ps.setString(1, String.valueOf(mo));
            ps.setString(2, String.valueOf(sen));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Operation réussi");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BanquierController.loadData("");
    }

    public static void Crediter(long sen, int mo) {
        Connection conn = SingletonConnection.getInstance();
        try {
            PreparedStatement ps;
            ps = conn.prepareStatement("UPDATE comptebanquaire SET Solde = Solde + ? WHERE RIB = ?");
            ps.setString(1, String.valueOf(mo));
            ps.setString(2, String.valueOf(sen));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Operation réussi");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BanquierController.loadData("");
    }
    public static void loadData(String where, Object... search) {
        try {
            DefaultTableModel model = (DefaultTableModel) BanquierView.table1.getModel();
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
        BanquierView.table1.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        BanquierView.table1.setShowGrid(false);
        BanquierView.table1.setIntercellSpacing(new Dimension(2, 2));
        BanquierView.cardLayout.show(BanquierView.panel3, "card1");
    }
}