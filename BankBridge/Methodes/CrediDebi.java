package Methodes;


import CONTROLLER.BanquierController;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class CrediDebi extends JFrame {
    public CrediDebi(long Sen) {
        initComponents();
        setTitle("Opération");
        setSize(400, 350);
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
        Effectuer.addActionListener(ae -> this.Operation(Sen));
        setVisible(true);
    }

    public void Operation(long Sen) {
        if (montant.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Veuillez remplir tous les champs",
                    "Essayer à nouveau",
                    JOptionPane.ERROR_MESSAGE);
        } else if (!montant.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this,
                    "Veuillez saisir un montant valide",
                    "Essayer à nouveau",
                    JOptionPane.ERROR_MESSAGE);
        }else {
            int mo = Integer.parseInt(montant.getText());
            if (mo == 0) {
                JOptionPane.showMessageDialog(this,
                        "Veuillez saisir un montant valide",
                        "Essayer à nouveau",
                        JOptionPane.ERROR_MESSAGE);
            }else if (mo < 0) {
                JOptionPane.showMessageDialog(this,
                        "Veuillez saisir un montant positif",
                        "Essayer à nouveau",
                        JOptionPane.ERROR_MESSAGE);
            }else {
                if (comboBox1.getSelectedItem().equals("Créditer")) {
                    BanquierController.Crediter(Sen, mo);
                    dispose();
                } else {
                    BanquierController.Debiter(Sen, mo);
                    dispose();
                }
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        header = new JButton();
        var vSpacer2 = new Spacer();
        JLabel title = new JLabel();
        var hSpacer1 = new Spacer();
        comboBox1 = new JComboBox<>();
        var hSpacer2 = new Spacer();
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
            panel1.setLayout(new GridLayoutManager(10, 4, new Insets(0, 0, 0, 0), -1, -1));

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
            title.setText("Operation");
            title.setFont(new Font("Comfortaa", Font.BOLD, 24));
            panel1.add(title, new GridConstraints(2, 1, 1, 2,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
            panel1.add(hSpacer1, new GridConstraints(4, 0, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK,
                null, null, null));

            //---- comboBox1 ----
            comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                "Débiter",
                "Créditer"
            }));
            comboBox1.setSelectedIndex(0);
            panel1.add(comboBox1, new GridConstraints(4, 1, 1, 2,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
            panel1.add(hSpacer2, new GridConstraints(4, 3, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK,
                null, null, null));

            //---- label4 ----
            label4.setText("Montant :");
            label4.setFont(new Font("Comfortaa", Font.BOLD, 18));
            panel1.add(label4, new GridConstraints(5, 1, 1, 2,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
            panel1.add(montant, new GridConstraints(6, 1, 1, 2,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
            panel1.add(vSpacer3, new GridConstraints(7, 2, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK,
                GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                null, null, null));

            //---- Annuler ----
            Annuler.setText("Annuler");
            panel1.add(Annuler, new GridConstraints(8, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

            //---- Effectuer ----
            Effectuer.setText("Effectuer");
            panel1.add(Effectuer, new GridConstraints(8, 2, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
            panel1.add(vSpacer1, new GridConstraints(9, 2, 1, 1,
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
    private JComboBox<String> comboBox1;
    private JTextField montant;
    private JButton Annuler;
    private JButton Effectuer;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
