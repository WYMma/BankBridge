package VIEW;

import CONTROLLER.AdminController;
import CONTROLLER.BanquierController;
import CONTROLLER.ClientController;
import Methodes.AjoutUser;
import Methodes.SingletonConnection;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class LoginPage extends JFrame {


    public LoginPage() {
        initComponents();
        setTitle("BankBridge");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(720, 540);
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("images/logo.png");
        setIconImage(icon.getImage());
        ImageIcon loginIcon = new ImageIcon("images/button/Normal/login.png");
        loginButton.setBorder(BorderFactory.createEmptyBorder());
        loginButton.setIcon(loginIcon);
        loginButton.setContentAreaFilled(false);
        add(Panel1);
        loginButton.addActionListener(ae -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            Connection conn = SingletonConnection.getInstance();
            try {
                PreparedStatement ps;
                ps = conn.prepareStatement("SELECT Type FROM user WHERE Login = ? AND MDP= ?;");
                ps.setString(1, username);
                ps.setString(2, AjoutUser.encrypt(password));
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String type = rs.getString("Type");
                    switch (type.toLowerCase()) {
                        case "admin" -> {
                            JOptionPane.showMessageDialog(LoginPage.this, "Bienvenue, Admin!");
                            new AdminController(username);
                            this.dispose();
                        }
                        case "client" -> {
                            JOptionPane.showMessageDialog(LoginPage.this, "Bienvenue, Client!");
                            new ClientController(username);
                            this.dispose();
                        }
                        case "banquier" -> {
                            JOptionPane.showMessageDialog(LoginPage.this, "Bienvenue, Banquier!");
                            new BanquierController(username);
                            this.dispose();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(LoginPage.this, "Invalid username or password!");
                }
                rs.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        reduire.addActionListener(e -> setState(JFrame.ICONIFIED));
        fermer.addActionListener(e -> {
            int confirmed = JOptionPane.showConfirmDialog(null,
                    "Voulez-vous vraiment quitter le programme ?", "Confirmer Quitter",
                    JOptionPane.YES_NO_OPTION);

            if (confirmed == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new LoginPage();
    }

    private void createUIComponents() {
        Panel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("images/banners/image.png");
                g.drawImage(icon.getImage(), 0, 0, null);
            }
        };
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        createUIComponents();

        reduire = new JButton();
        fermer = new JButton();
        var hSpacer1 = new Spacer();
        var vSpacer1 = new Spacer();
        var vSpacer2 = new Spacer();
        var label1 = new JLabel();
        userField = new JTextField();
        var label2 = new JLabel();
        var hSpacer2 = new Spacer();
        passField = new JPasswordField();
        var hSpacer3 = new Spacer();
        loginButton = new JButton();

        //======== Panel1 ========
        {
            Panel1.setMaximumSize(new Dimension(420, 540));
            Panel1.setMinimumSize(new Dimension(420, 540));
            Panel1.setPreferredSize(new Dimension(420, 540));
            Panel1.setLayout(new GridLayoutManager(9, 6, new Insets(0, 0, 0, 0), -1, -1));

            //---- reduire ----
            reduire.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Normal/-.png"))));
            reduire.setRolloverIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/-h.png"))));
            reduire.setRolloverSelectedIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/-h.png"))));
            reduire.setRequestFocusEnabled(false);
            reduire.setFocusPainted(false);
            reduire.setFocusable(false);
            Panel1.add(reduire, new GridConstraints(0, 4, 1, 1,
                GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                new Dimension(20, 20), new Dimension(20, 20), new Dimension(20, 20)));

            //---- fermer ----
            fermer.setRolloverIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/x-h.png"))));
            fermer.setRolloverSelectedIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/x-h.png"))));
            fermer.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Normal/x.png"))));
            fermer.setFocusable(false);
            fermer.setFocusPainted(false);
            fermer.setRequestFocusEnabled(false);
            Panel1.add(fermer, new GridConstraints(0, 5, 1, 1,
                GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                new Dimension(20, 20), new Dimension(20, 20), new Dimension(20, 20)));
            Panel1.add(hSpacer1, new GridConstraints(1, 0, 7, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_FIXED,
                GridConstraints.SIZEPOLICY_CAN_SHRINK,
                new Dimension(420, 540), new Dimension(212, 540), new Dimension(420, 540)));
            Panel1.add(vSpacer1, new GridConstraints(1, 3, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK,
                GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                null, null, null));
            Panel1.add(vSpacer2, new GridConstraints(7, 3, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK,
                GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                null, null, null));

            //---- label1 ----
            label1.setAlignmentX(1.0F);
            label1.setFont(new Font("Comfortaa SemiBold", Font.BOLD, label1.getFont().getSize()));
            label1.setText("Login");
            Panel1.add(label1, new GridConstraints(2, 3, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_FIXED,
                GridConstraints.SIZEPOLICY_FIXED,
                null, null, null));

            //---- userField ----
            userField.setFont(new Font("Comfortaa SemiBold", Font.BOLD, userField.getFont().getSize()));
            Panel1.add(userField, new GridConstraints(3, 3, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                GridConstraints.SIZEPOLICY_FIXED,
                null, new Dimension(150, 20), null));

            //---- label2 ----
            label2.setAlignmentX(0.5F);
            label2.setFont(new Font("Comfortaa SemiBold", Font.BOLD, label2.getFont().getSize()));
            label2.setText("Mot de Passe");
            Panel1.add(label2, new GridConstraints(4, 3, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_FIXED,
                GridConstraints.SIZEPOLICY_FIXED,
                null, null, null));
            Panel1.add(hSpacer2, new GridConstraints(5, 1, 1, 2,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK,
                null, null, null));
            Panel1.add(passField, new GridConstraints(5, 3, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
            Panel1.add(hSpacer3, new GridConstraints(5, 4, 1, 2,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK,
                null, null, null));

            //---- loginButton ----
            loginButton.setText("");
            loginButton.setFocusable(false);
            loginButton.setFocusPainted(false);
            loginButton.setRolloverIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/login-h.png"))));
            loginButton.setRolloverSelectedIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/login-h.png"))));
            loginButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Normal/login.png"))));
            Panel1.add(loginButton, new GridConstraints(6, 3, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_FIXED,
                null, null, null));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel Panel1;
    private JButton reduire;
    private JButton fermer;
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}


