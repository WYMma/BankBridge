package Methodes;

import MODEL.User;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Base64;

import static CONTROLLER.UserController.newUser;

public class AjoutUser extends JDialog {
    private final JTextField tfName;
    private final JTextField tfEmail;
    private final JTextField tfPhone;
    private final JTextField tfAddress;
    private final JTextField tfLogin;
    private final JComboBox<String> cbType;
    private final JTextField tfPnom;
    private final JPasswordField pfPassword;
    private final JPasswordField pfConfirmPassword;

    public static String getKey() {
        return "5a1f63f8d568876d85e3f6bafec6d63c";
    }

    public AjoutUser(JFrame parent) {
        super(parent);
        setTitle("Ajouter un nouveau utilisateur");
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new GridLayout(10, 2, 10, 40));
        registerPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
        ImageIcon icon = new ImageIcon("images/logo.png");
        setIconImage(icon.getImage());
        registerPanel.add(new JLabel("Name:"));
        tfName = new JTextField();
        registerPanel.add(tfName);
        registerPanel.add(new JLabel("Prénom:"));
        tfPnom = new JTextField();
        registerPanel.add(tfPnom);
        registerPanel.add(new JLabel("Login:"));
        tfLogin = new JTextField();
        registerPanel.add(tfLogin);
        registerPanel.add(new JLabel("Email:"));
        tfEmail = new JTextField();
        registerPanel.add(tfEmail);
        registerPanel.add(new JLabel("Num Tél:"));
        tfPhone = new JTextField();
        registerPanel.add(tfPhone);
        registerPanel.add(new JLabel("Addresse:"));
        tfAddress = new JTextField();
        registerPanel.add(tfAddress);
        registerPanel.add(new JLabel("Type:"));
        cbType = new JComboBox<>();
        cbType.setModel(new DefaultComboBoxModel<>(new String[] {
                "Client",
                "Banquier",
                "Admin"
        }));
        cbType.setSelectedIndex(0);
        registerPanel.add(cbType);
        registerPanel.add(new JLabel("Mot de Passe:"));
        pfPassword = new JPasswordField();
        registerPanel.add(pfPassword);
        registerPanel.add(new JLabel("Confirmer Mot de Passe:"));
        pfConfirmPassword = new JPasswordField();
        registerPanel.add(pfConfirmPassword);
        JButton btnRegister = new JButton("Ajouter");
        JButton btnCancel = new JButton("Annuler");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(btnRegister);
        buttonPanel.add(btnCancel);
        registerPanel.add(buttonPanel);
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(400, 750));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btnRegister.addActionListener(e -> registerUser());
        btnCancel.addActionListener(e -> dispose());
        setVisible(true);
    }
    private void registerUser() {
        String name = tfName.getText();
        String pname = tfPnom.getText();
        String login = tfLogin.getText();
        String type = cbType.getSelectedItem().toString();
        String email = tfEmail.getText();
        String phone = tfPhone.getText();
        String address = tfAddress.getText();
        String password = String.valueOf(pfPassword.getPassword());
        String confirmPassword = String.valueOf(pfConfirmPassword.getPassword());

        if (name.isEmpty() || pname.isEmpty() || login.isEmpty() || type.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Veuillez remplir tous les champs",
                    "Essayer à nouveau",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this,
                    "Les mots de passe ne correspondent pas",
                    "Essayer à nouveau",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!phone.matches("[0-9]+") || phone.length() != 8) {
            JOptionPane.showMessageDialog(this,
                    "Numéro de téléphone invalide",
                    "Essayer à nouveau",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            JOptionPane.showMessageDialog(this,
                    "Email invalide",
                    "Essayer à nouveau",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (password.length() < 8) {
            JOptionPane.showMessageDialog(this,
                    "Le mot de passe doit contenir au moins 8 caractères",
                    "Essayer à nouveau",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (login.length() < 4) {
            JOptionPane.showMessageDialog(this,
                    "Le login doit contenir au moins 4 caractères",
                    "Essayer à nouveau",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        Connection connection = SingletonConnection.getInstance();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM user WHERE Login = '" + login + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                JOptionPane.showMessageDialog(this,
                        "Ce login est déjà utilisé",
                        "Essayer à nouveau",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        user = addUserToDatabase(name, pname, login, type, email, phone, address, password);
        dispose();
    }

    public User user;
    private User addUserToDatabase(String name, String pname, String login, String type, String email, String phone, String address, String password) {
        User user = new User();
        Connection conn = SingletonConnection.getInstance();
        try{
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO user (Login, Nom, Prenom, Adr, Tel, Email, Type, MDP) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, pname);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, phone);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, type);
            preparedStatement.setString(8, encrypt(password));
            int addedRows = preparedStatement.executeUpdate();
            if (addedRows > 0) {
                user = newUser(login);
            }
            stmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return user;
    }
    public static String encrypt(String plaintext) {
        String key = getKey();
        try {
            byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte[] plaintextBytes = plaintext.getBytes(StandardCharsets.UTF_8);
            byte[] ciphertextBytes = cipher.doFinal(plaintextBytes);

            return Base64.getEncoder().encodeToString(ciphertextBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String decrypt(String ciphertext) {
        String key = getKey();
        try {
            byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

            byte[] ciphertextBytes = Base64.getDecoder().decode(ciphertext);
            byte[] plaintextBytes = cipher.doFinal(ciphertextBytes);

            return new String(plaintextBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}