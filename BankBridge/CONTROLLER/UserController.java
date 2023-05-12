package CONTROLLER;

import MODEL.User;
import Methodes.AjoutUser;
import Methodes.PersonTableModel;
import Methodes.SingletonConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserController extends JFrame {
    protected User user;
    public UserController(String login) {
        this.user = newUser(login);
    }
    public static User newUser(String login) {
        User user = new User();
        Connection conn = SingletonConnection.getInstance();
        try {
            PreparedStatement ps;
            ps = conn.prepareStatement("SELECT * FROM user WHERE Login = ?;");
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setID(rs.getInt("ID"));
                user.setMDP(AjoutUser.decrypt(rs.getString("MDP")));
                user.setNom(rs.getString("Nom"));
                user.setPrenom(rs.getString("Prenom"));
                user.setAdr(rs.getString("Adr"));
                user.setTel(rs.getLong("Tel"));
                user.setEmail(rs.getString("Email"));
                user.setType(rs.getString("Type"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void ConsulterUser(JTable table1, User user) {
        PersonTableModel model = new PersonTableModel(user);
        table1.setModel(model);
        table1.repaint();
        table1.setShowGrid(false);
        table1.setShowHorizontalLines(false);
        table1.setShowVerticalLines(false);
        table1.setIntercellSpacing(new Dimension(0, 0));
    }

}