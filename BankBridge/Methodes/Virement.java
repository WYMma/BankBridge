package Methodes;


import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Objects;

public class Virement extends JFrame {
    public Virement() {
        initComponents();
        setTitle("Virement");
        setSize(400, 450);
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("images/logo.png");
        setIconImage(icon.getImage());
        add(panel1);
        header.setBorder(BorderFactory.createEmptyBorder());
        header.setContentAreaFilled(false);
        Annuler.addActionListener(e -> {
            int confirmed = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir annuler?", "Confirmer l'Annulation", JOptionPane.YES_NO_OPTION);

            if (confirmed == JOptionPane.YES_OPTION) {
                Window window = SwingUtilities.windowForComponent((Component) e.getSource());
                window.dispose();
            }
        });
        Effectuer.addActionListener(ae -> this.transfer());
        setVisible(true);
    }

    public void transfer() {
        int i = 0;
        if (Objects.equals(sender.getText(), "") || Objects.equals(reciever.getText(), "") || Objects.equals(montant.getText(), "")) {
            JOptionPane.showMessageDialog(this,
                    "Veuillez remplir tous les champs",
                    "Essayer à nouveau",
                    JOptionPane.ERROR_MESSAGE);
        } else if ( !sender.getText().matches("[0-9]+") || !reciever.getText().matches("[0-9]+")){
            JOptionPane.showMessageDialog(this,
                    "Veuillez saisir un RIB valide",
                    "Essayer à nouveau",
                    JOptionPane.ERROR_MESSAGE);
        }else if (!montant.getText().matches("[0-9]+") || montant.getText().matches("0")) {
            JOptionPane.showMessageDialog(this,
                    "Veuillez saisir un montant valide",
                    "Essayer à nouveau",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            long sen = Long.parseLong(sender.getText());
            long rec = Long.parseLong(reciever.getText());
            int mo = Integer.parseInt(montant.getText());
            Connection conn = SingletonConnection.getInstance();
            try {
                    PreparedStatement ps;
                    ps = conn.prepareStatement("SELECT RIB FROM comptebanquaire WHERE RIB = ? OR RIB = ?;");
                    ps.setString(1, String.valueOf(sen));
                    ps.setString(2, String.valueOf(rec));
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        i++;
                    }

                    if (i > 1) {
                        try {
                            Statement stmt = conn.createStatement();
                            String sql = "UPDATE comptebanquaire SET Solde = Solde - ? WHERE RIB = ?";
                            PreparedStatement preparedStatement = conn.prepareStatement(sql);
                            preparedStatement.setString(1, String.valueOf(mo));
                            preparedStatement.setString(2, String.valueOf(sen));
                            preparedStatement.executeUpdate();
                            Statement stmt2 = conn.createStatement();
                            String sql2 = "UPDATE comptebanquaire SET Solde = Solde + ? WHERE RIB = ?";
                            preparedStatement = conn.prepareStatement(sql2);
                            preparedStatement.setString(1, String.valueOf(mo));
                            preparedStatement.setString(2, String.valueOf(rec));
                            preparedStatement.executeUpdate();
                            stmt2.close();
                            stmt.close();
                            JOptionPane.showMessageDialog(this, "Virement réussi", "Succès", JOptionPane.INFORMATION_MESSAGE);
                            dispose();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Vérifier Vos données", "Essayer à nouveau", JOptionPane.ERROR_MESSAGE);
                    }
                    rs.close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        header = new JButton();
        var vSpacer2 = new Spacer();
        JLabel title = new JLabel();
        var vSpacer4 = new Spacer();
        JLabel label2 = new JLabel();
        var hSpacer1 = new Spacer();
        sender = new JTextField();
        var hSpacer2 = new Spacer();
        JLabel label3 = new JLabel();
        reciever = new JTextField();
        JLabel label4 = new JLabel();
        montant = new JTextField();
        var vSpacer3 = new Spacer();
        Annuler = new JButton();
        Effectuer = new JButton();
        var vSpacer1 = new Spacer();

        //======== panel1 ========
        {
            panel1.setMinimumSize(new Dimension(405, 400));
            panel1.setMaximumSize(new Dimension(405, 400));
            panel1.setPreferredSize(new Dimension(405, 400));
            panel1.setLayout(new GridLayoutManager(13, 4, new Insets(0, 0, 0, 0), -1, -1));

            //---- header ----
            header.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/banners/header-v.png"))));
            header.setBackground(new Color(0x17c6bf));
            header.setMaximumSize(new Dimension(400, 100));
            header.setMinimumSize(new Dimension(400, 100));
            header.setPreferredSize(new Dimension(400, 100));
            header.setVerticalAlignment(SwingConstants.TOP);
            header.setHorizontalAlignment(SwingConstants.LEFT);
            header.setFocusPainted(false);
            header.setBorder(null);
            panel1.add(header, new GridConstraints(0, 0, 1, 4,
                GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_BOTH,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
            panel1.add(vSpacer2, new GridConstraints(1, 2, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK,
                GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                null, null, null));

            //---- title ----
            title.setText("Virement");
            title.setFont(new Font("Comfortaa", Font.BOLD, 24));
            panel1.add(title, new GridConstraints(2, 1, 1, 2,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
            panel1.add(vSpacer4, new GridConstraints(3, 2, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK,
                GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                null, null, null));

            //---- label2 ----
            label2.setText("De :");
            label2.setFont(new Font("Comfortaa", Font.BOLD, 18));
            label2.setHorizontalAlignment(SwingConstants.RIGHT);
            panel1.add(label2, new GridConstraints(4, 1, 1, 2,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
            panel1.add(hSpacer1, new GridConstraints(5, 0, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK,
                null, null, null));

            //---- sender ----
            sender.setMaximumSize(new Dimension(64, 22));
            sender.setMargin(null);
            panel1.add(sender, new GridConstraints(5, 1, 1, 2,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
            panel1.add(hSpacer2, new GridConstraints(5, 3, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK,
                null, null, null));

            //---- label3 ----
            label3.setText("à :");
            label3.setFont(new Font("Comfortaa", Font.BOLD, 18));
            panel1.add(label3, new GridConstraints(6, 1, 1, 2,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
            panel1.add(reciever, new GridConstraints(7, 1, 1, 2,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

            //---- label4 ----
            label4.setText("Montant :");
            label4.setFont(new Font("Comfortaa", Font.BOLD, 18));
            panel1.add(label4, new GridConstraints(8, 1, 1, 2,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
            panel1.add(montant, new GridConstraints(9, 1, 1, 2,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
            panel1.add(vSpacer3, new GridConstraints(10, 2, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK,
                GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                null, null, null));

            //---- Annuler ----
            Annuler.setText("Annuler");
            panel1.add(Annuler, new GridConstraints(11, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

            //---- Effectuer ----
            Effectuer.setText("Effectuer");
            panel1.add(Effectuer, new GridConstraints(11, 2, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
            panel1.add(vSpacer1, new GridConstraints(12, 2, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK,
                GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                null, null, null));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JButton header;
    private JTextField sender;
    private JTextField reciever;
    private JTextField montant;
    private JButton Annuler;
    private JButton Effectuer;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
