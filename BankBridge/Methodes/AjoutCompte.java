package Methodes;

import CONTROLLER.BankController;
import MODEL.Bank;
import MODEL.CompteBanquaire;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AjoutCompte extends JDialog {
    private final JComboBox<String> cbBanque;
    private final JTextField tfProp;
    private final JComboBox<String> cbType;

    public AjoutCompte(JFrame parent) {
        super(parent);
        setTitle("Ajouter un nouveau Compte");
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new GridLayout(4, 2, 10, 10));
        registerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        ImageIcon icon = new ImageIcon("images/logo.png");
        setIconImage(icon.getImage());
        registerPanel.add(new JLabel("Nom de Propriétaire:"));
        tfProp = new JTextField();
        registerPanel.add(tfProp);
        registerPanel.add(new JLabel("Identifiant Bank:"));
        cbBanque = new JComboBox<>();
        Connection conn = SingletonConnection.getInstance();
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT nomBank FROM banks";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<String> names = new ArrayList<>();
            while (rs.next()) {
                names.add(rs.getString("nomBank"));
            }
            cbBanque.setModel(new DefaultComboBoxModel<>(names.toArray(new String[0])));
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        cbBanque.setSelectedIndex(0);
        registerPanel.add(cbBanque);
        registerPanel.add(new JLabel("Type:"));
        cbType = new JComboBox<>();
        cbType.setModel(new DefaultComboBoxModel<>(new String[] {
                "Compte Courant",
                "Compte Epargne",
                "Compte Joint"
        }));
        cbType.setSelectedIndex(0);
        registerPanel.add(cbType);
        JButton btnRegister = new JButton("Ajouter");
        JButton btnCancel = new JButton("Annuler");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(btnRegister);
        buttonPanel.add(btnCancel);
        registerPanel.add(buttonPanel);
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(400, 200));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btnRegister.addActionListener(e -> ajouterCompte());
        btnCancel.addActionListener(e -> dispose());
        setVisible(true);
    }
    private void ajouterCompte() {
        Bank ban = BankController.newBANK(cbBanque.getSelectedItem().toString());
        String prop = tfProp.getText();
        int idProp;
        String type = cbType.getSelectedItem().toString();

        if (prop.isEmpty() || type.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Veuillez remplir tous les champs",
                    "Essayer à nouveau",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!prop.matches("^[a-zA-Z]+(\\s[a-zA-Z]+)?$")) {
            JOptionPane.showMessageDialog(this,
                    "Nom de Propriétaire doit être une chaine de caractères",
                    "Essayer à nouveau",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        Connection conn = SingletonConnection.getInstance();
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM user WHERE  CONCAT(user.Nom, ' ' ,user.Prenom) = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, prop);
            ResultSet rs = pstmt.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this,
                        "Propriétaire n'existe pas",
                        "Essayer à nouveau",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }else {
                idProp = rs.getInt("ID");
                compte = ajoutCompteTDB(ban, idProp, type);
                dispose();
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CompteBanquaire compte;
    private CompteBanquaire ajoutCompteTDB(Bank ban, int prop, String type) {
        CompteBanquaire compte = new CompteBanquaire(ban, prop, type);
        Connection conn = SingletonConnection.getInstance();
        try{
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO comptebanquaire (RIB, Solde, Prop, Type, idBank) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, compte.getRIB());
            preparedStatement.setDouble(2, compte.getSolde());
            preparedStatement.setInt(3, compte.getProp());
            preparedStatement.setString(4, compte.getTypeCompte());
            preparedStatement.setInt(5, ban.getIDBank());
            preparedStatement.executeUpdate();
            stmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return compte;
    }
}