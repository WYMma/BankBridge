package CONTROLLER;

import MODEL.Client;
import MODEL.CompteBanquaire;
import Methodes.AjoutUser;
import Methodes.SingletonConnection;
import Methodes.TableauClient;
import VIEW.ClientView;
import Methodes.CustomTableCellRenderer;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientController {
    protected static Client client;
    public ClientController(String login) {
        client = newClient(login);
        client.setCompte(setCompte(client));
        ClientView.client = client;
        new ClientView();
    }

    public static void ConsulterSolde() {
        // TODO Auto-generated method stub
        Connection conn = SingletonConnection.getInstance();
        double soldeTotale = 0;
        try {
            PreparedStatement ps;
            ps = conn.prepareStatement("SELECT SUM(Solde) FROM comptebanquaire WHERE Prop = ?;");
            ps.setInt(1, client.getID());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soldeTotale = rs.getDouble("SUM(Solde)");
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Votre solde totale est: " + soldeTotale + "DT");
    }
    public static Client newClient(String login) {
        Client client = new Client();
        Connection conn = SingletonConnection.getInstance();
        try {
            PreparedStatement ps;
            ps = conn.prepareStatement("SELECT * FROM user WHERE Login = ?;");
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                client.setID(rs.getInt("ID"));
                client.setMDP(AjoutUser.decrypt(rs.getString("MDP")));
                client.setNom(rs.getString("Nom"));
                client.setPrenom(rs.getString("Prenom"));
                client.setAdr(rs.getString("Adr"));
                client.setTel(rs.getLong("Tel"));
                client.setEmail(rs.getString("Email"));
                client.setType(rs.getString("Type"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }
    public static ArrayList<CompteBanquaire> setCompte(Client client) {
        ArrayList<CompteBanquaire> Compte = new ArrayList<>();
        // TODO Auto-generated method stub
        Connection conn = SingletonConnection.getInstance();
        try {
            PreparedStatement ps;
            ps = conn.prepareStatement("SELECT RIB,Solde,Type,idBank FROM comptebanquaire WHERE Prop = ?;");
            ps.setInt(1, client.getID());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CompteBanquaire compt = new CompteBanquaire(rs.getString("RIB"), rs.getDouble("Solde"), client.getID(),rs.getString("Type"),rs.getInt("idBank"));
                Compte.add(compt);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Compte;

    }

    public static void ConsulterComptes(JTable table1) {
        TableauClient model = new TableauClient(client.getCompte());
        table1.setModel(model);
        table1.repaint();
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table1.setShowHorizontalLines(false);
        table1.setShowVerticalLines(false);
        table1.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        table1.setShowGrid(false);
        table1.setIntercellSpacing(new Dimension(2, 2));
    }

}