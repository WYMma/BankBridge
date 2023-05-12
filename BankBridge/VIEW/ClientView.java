package VIEW;

import MODEL.Client;
import CONTROLLER.ClientController;
import CONTROLLER.UserController;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ClientView extends JFrame{
    public ClientView() {
        initComponents();
        setTitle("BankBridge");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 740);
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("images/logo.png");
        setIconImage(icon.getImage());
        add(PanelP);
        consulterComptesButton.addActionListener(ae -> ClientController.ConsulterComptes(table1));
        consulterComptesButton.setBorder(BorderFactory.createEmptyBorder());
        consulterComptesButton.setContentAreaFilled(false);
        conculterSoldeButton.addActionListener(ae -> ClientController.ConsulterSolde());
        conculterSoldeButton.setBorder(BorderFactory.createEmptyBorder());
        conculterSoldeButton.setContentAreaFilled(false);
        InfoClient.addActionListener(ae -> UserController.ConsulterUser(table1,client));
        InfoClient.setBorder(BorderFactory.createEmptyBorder());
        InfoClient.setContentAreaFilled(false);
        header.setBorder(BorderFactory.createEmptyBorder());
        logout.addActionListener(e -> {
            int confirmed = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir vous déconnecter?", "Confirmer la Déconnexion", JOptionPane.YES_NO_OPTION);

            if (confirmed == JOptionPane.YES_OPTION) {
                Window window = SwingUtilities.windowForComponent((Component) e.getSource());
                window.dispose();
                new LoginPage();
            }
        });
        logout.setBorder(BorderFactory.createEmptyBorder());
        logout.setContentAreaFilled(false);
        setVisible(true);
        UserController.ConsulterUser(table1, client);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        PanelP = new JPanel();
        header = new JButton();
        var vSpacer1 = new Spacer();
        var scrollPane1 = new JScrollPane();
        table1 = new JTable();
        InfoClient = new JButton();
        var vSpacer8 = new Spacer();
        conculterSoldeButton = new JButton();
        consulterComptesButton = new JButton();
        var vSpacer9 = new Spacer();
        logout = new JButton();
        var vSpacer7 = new Spacer();

        //======== PanelP ========
        {
            PanelP.setMaximumSize(new Dimension(900, 740));
            PanelP.setMinimumSize(new Dimension(900, 740));
            PanelP.setPreferredSize(new Dimension(900, 740));
            PanelP.setBackground(Color.white);
            PanelP.setLayout(new GridLayoutManager(9, 2, new Insets(0, 0, 0, 0), 0, 0));

            //---- header ----
            header.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/banners/header.png"))));
            header.setText("");
            header.setBorderPainted(false);
            header.setHorizontalAlignment(SwingConstants.LEFT);
            header.setBorder(null);
            header.setFocusPainted(false);
            header.setBackground(new Color(0x17c6bf));
            PanelP.add(header, new GridConstraints(0, 0, 1, 2,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_FIXED,
                    null, null, null, 0, true));
            PanelP.add(vSpacer1, new GridConstraints(1, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK,
                    GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                    null, null, null));

            //======== scrollPane1 ========
            {

                //---- table1 ----
                table1.setAlignmentX(0.0F);
                table1.setAlignmentY(0.0F);
                table1.setAutoCreateRowSorter(false);
                table1.setFont(new Font("Comfortaa SemiBold", Font.BOLD, table1.getFont().getSize()));
                table1.setRowHeight(40);
                table1.setSelectionBackground(new Color(0x046b67));
                table1.setCellSelectionEnabled(true);
                table1.setSelectionForeground(Color.white);
                table1.setShowHorizontalLines(true);
                table1.setShowVerticalLines(true);
                scrollPane1.setViewportView(table1);
            }
            PanelP.add(scrollPane1, new GridConstraints(1, 1, 8, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //---- InfoClient ----
            InfoClient.setFont(new Font("Comfortaa SemiBold", Font.BOLD, InfoClient.getFont().getSize()));
            InfoClient.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Normal/user.png"))));
            InfoClient.setMargin(new Insets(0, 0, 0, 0));
            InfoClient.setText("");
            InfoClient.setMinimumSize(new Dimension(200, 200));
            InfoClient.setMaximumSize(new Dimension(200, 200));
            InfoClient.setBorderPainted(false);
            InfoClient.setBorder(null);
            InfoClient.setFocusPainted(false);
            InfoClient.setRolloverIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/user-h.png"))));
            InfoClient.setRolloverSelectedIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/user-h.png"))));
            PanelP.add(InfoClient, new GridConstraints(2, 0, 1, 1,
                    GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK,
                    null, null, null));
            PanelP.add(vSpacer8, new GridConstraints(3, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK,
                    GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                    null, null, null));

            //---- conculterSoldeButton ----
            conculterSoldeButton.setFont(new Font("Comfortaa SemiBold", Font.BOLD, conculterSoldeButton.getFont().getSize()));
            conculterSoldeButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Normal/cs.png"))));
            conculterSoldeButton.setMargin(new Insets(0, 0, 0, 0));
            conculterSoldeButton.setText("");
            conculterSoldeButton.setBorderPainted(false);
            conculterSoldeButton.setBorder(null);
            conculterSoldeButton.setFocusPainted(false);
            conculterSoldeButton.setRolloverIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/cs-h.png"))));
            conculterSoldeButton.setRolloverSelectedIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/cs-h.png"))));
            PanelP.add(conculterSoldeButton, new GridConstraints(4, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                    GridConstraints.SIZEPOLICY_FIXED,
                    GridConstraints.SIZEPOLICY_FIXED,
                    null, null, null));

            //---- consulterComptesButton ----
            consulterComptesButton.setFont(new Font("Comfortaa SemiBold", Font.BOLD, consulterComptesButton.getFont().getSize()));
            consulterComptesButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Normal/cc.png"))));
            consulterComptesButton.setMargin(new Insets(0, 0, 0, 0));
            consulterComptesButton.setText("");
            consulterComptesButton.setBorderPainted(false);
            consulterComptesButton.setBorder(null);
            consulterComptesButton.setIconTextGap(0);
            consulterComptesButton.setFocusPainted(false);
            consulterComptesButton.setRolloverIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/cc-h.png"))));
            consulterComptesButton.setRolloverSelectedIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/cc-h.png"))));
            PanelP.add(consulterComptesButton, new GridConstraints(5, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK,
                    null, null, null));
            PanelP.add(vSpacer9, new GridConstraints(6, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK,
                    GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                    null, null, null));

            //---- logout ----
            logout.setFont(new Font("Comfortaa SemiBold", Font.BOLD, logout.getFont().getSize()));
            logout.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Normal/logout.png"))));
            logout.setMargin(new Insets(0, 0, 200, 0));
            logout.setText("");
            logout.setAlignmentY(0.0F);
            logout.setMaximumSize(new Dimension(87, 100));
            logout.setMinimumSize(new Dimension(87, 100));
            logout.setPreferredSize(new Dimension(87, 100));
            logout.setBorderPainted(false);
            logout.setBorder(null);
            logout.setRequestFocusEnabled(false);
            logout.setFocusPainted(false);
            logout.setRolloverIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/logout-h.png"))));
            logout.setRolloverSelectedIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/logout-h.png"))));
            PanelP.add(logout, new GridConstraints(7, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                    GridConstraints.SIZEPOLICY_FIXED,
                    GridConstraints.SIZEPOLICY_FIXED,
                    new Dimension(119, 45), new Dimension(119, 45), new Dimension(119, 45)));
            PanelP.add(vSpacer7, new GridConstraints(8, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK,
                    GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                    null, null, null));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel PanelP;
    private JButton header;
    private JTable table1;
    private JButton InfoClient;
    private JButton conculterSoldeButton;
    private JButton consulterComptesButton;
    private JButton logout;
    public static Client client;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
