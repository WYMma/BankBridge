package VIEW;

import CONTROLLER.BanquierController;
import CONTROLLER.UserController;
import MODEL.Banquier;
import Methodes.Virement;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import Methodes.textfield.SearchOption;
import Methodes.textfield.TextFieldSearchOption;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

import static Methodes.Recherche.RechercheBanquierKeyReleased;

public class BanquierView extends JFrame {
    public BanquierView() {
        initComponents();
        setTitle("BankBridge");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600, 900);
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("images/logo.png");
        setIconImage(icon.getImage());
        add(PanelP);
        consulterComptesButton.addActionListener(ae -> BanquierController.loadData(""));
        consulterComptesButton.setBorder(BorderFactory.createEmptyBorder());
        consulterComptesButton.setContentAreaFilled(false);
        EffectVirement.addActionListener(ae -> new Virement());
        EffectVirement.setBorder(BorderFactory.createEmptyBorder());
        EffectVirement.setContentAreaFilled(false);
        InfoBanquier.addActionListener(ae -> {
            UserController.ConsulterUser(table2, banquier);
            cardLayout.show(panel3, "card2");
        });
        InfoBanquier.setBorder(BorderFactory.createEmptyBorder());
        InfoBanquier.setContentAreaFilled(false);
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
        txt.addEventOptionSelected((option, index) -> txt.setHint("Recherche par " + option.getName() + "..."));
        txt.addOption(new SearchOption("RIB", new ImageIcon("images/search/rib.png")));
        txt.addOption(new SearchOption("Nom Propriétaire", new ImageIcon("images/search/nom.png")));
        txt.addOption(new SearchOption("Type", new ImageIcon("images/search/type.png")));
        setVisible(true);
        UserController.ConsulterUser(table2, banquier);
        cardLayout.show(panel3, "card2");
        table1.getColumn("Opération").setCellRenderer(new Methodes.ButtonTableau.OperationBanquaire());
        table1.getColumn("Opération").setCellEditor(new Methodes.ButtonTableau.OperationBanquaireEditor());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        PanelP = new JPanel();
        header = new JButton();
        var vSpacer2 = new Spacer();
        panel3 = new JPanel();
        JPanel compteBank = new JPanel();
        txt = new TextFieldSearchOption();
        var scrollPane1 = new raven.scroll.win11.ScrollPaneWin11();
        table1 = new JTable();
        var vSpacer1 = new Spacer();
        JPanel compteUser = new JPanel();
        var scrollPane2 = new JScrollPane();
        table2 = new JTable();
        InfoBanquier = new JButton();
        var vSpacer8 = new Spacer();
        EffectVirement = new JButton();
        consulterComptesButton = new JButton();
        var vSpacer9 = new Spacer();
        logout = new JButton();
        var vSpacer7 = new Spacer();

        //======== PanelP ========
        {
            PanelP.setMaximumSize(new Dimension(1600, 900));
            PanelP.setMinimumSize(new Dimension(1600, 900));
            PanelP.setPreferredSize(new Dimension(1600, 900));
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
            PanelP.add(vSpacer2, new GridConstraints(1, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK,
                    GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                    null, null, null));

            //======== panel3 ========
            {
                cardLayout = new CardLayout();
                panel3.setBorder(new BevelBorder(BevelBorder.LOWERED));
                panel3.setLayout(cardLayout);

                //======== CompteBank ========
                {
                    compteBank.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), 0, 0));

                    //---- txt ----
                    txt.setColorOverlay1(new Color(0x17c6bf));
                    txt.setHint("Recherche...");
                    txt.setMaximumSize(new Dimension(64, 36));
                    txt.setMargin(null);
                    txt.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyReleased(KeyEvent e) {
                            RechercheBanquierKeyReleased(txt);
                        }
                    });
                    compteBank.add(txt, new GridConstraints(0, 0, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));

                    //======== scrollPane1 ========
                    {

                        //---- table1 ----
                        table1.setAlignmentX(0.0F);
                        table1.setAlignmentY(0.0F);
                        table1.setAutoCreateRowSorter(true);
                        table1.setFont(new Font("Comfortaa SemiBold", Font.BOLD, table1.getFont().getSize()));
                        table1.setRowHeight(40);
                        table1.setSelectionBackground(new Color(0x046b67));
                        table1.setSelectionForeground(Color.white);
                        table1.setShowHorizontalLines(true);
                        table1.setShowVerticalLines(true);
                        table1.setCellSelectionEnabled(true);
                        table1.setFillsViewportHeight(true);
                        table1.setModel(new DefaultTableModel(
                                new Object[][] {
                                },
                                new String[] {
                                        "RIB", "Solde (TND)", "Type de Compte", "Propriétaire","Bank Associée", "Opération"
                                }
                        ) {
                            final Class<?>[] columnTypes = new Class<?>[] {
                                    String.class, Object.class, Object.class, Object.class, Object.class, Object.class
                            };
                            final boolean[] columnEditable = new boolean[] {
                                    false, false, false, false, false, true
                            };
                            @Override
                            public Class<?> getColumnClass(int columnIndex) {
                                return columnTypes[columnIndex];
                            }
                            @Override
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return columnEditable[columnIndex];
                            }
                        });
                        {
                            TableColumnModel cm = table1.getColumnModel();
                            cm.getColumn(0).setResizable(false);
                            cm.getColumn(1).setResizable(false);
                            cm.getColumn(2).setResizable(false);
                            cm.getColumn(3).setResizable(false);
                            cm.getColumn(4).setResizable(false);
                            cm.getColumn(5).setResizable(false);
                            cm.getColumn(5).setMinWidth(105);
                            cm.getColumn(5).setMaxWidth(105);
                            cm.getColumn(5).setPreferredWidth(105);
                        }
                        scrollPane1.setViewportView(table1);
                    }
                    compteBank.add(scrollPane1, new GridConstraints(1, 0, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));
                    compteBank.add(vSpacer1, new GridConstraints(1, 0, 2, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK,
                            GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                            null, null, null));
                }
                panel3.add(compteBank, "card1");

                //======== CompteUser ========
                {
                    compteUser.setBackground(Color.white);
                    compteUser.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), 0, 0));

                    //======== scrollPane2 ========
                    {

                        //---- table2 ----
                        table2.setAlignmentX(0.0F);
                        table2.setAlignmentY(0.0F);
                        table2.setAutoCreateRowSorter(false);
                        table2.setFont(new Font("Comfortaa SemiBold", Font.BOLD, table2.getFont().getSize()));
                        table2.setRowHeight(40);
                        table2.setSelectionBackground(new Color(0x046b67));
                        table2.setSelectionForeground(Color.white);
                        table2.setShowHorizontalLines(true);
                        table2.setShowVerticalLines(true);
                        table2.setCellSelectionEnabled(true);
                        table2.setFillsViewportHeight(true);
                        table2.setModel(new DefaultTableModel(
                                new Object[][] {
                                },
                                new String[] {
                                        "RIB", "Solde (TND)", "Type de Compte", "Propriétaire"
                                }
                        ) {
                            final boolean[] columnEditable = new boolean[] {
                                    false, false, false, false
                            };
                            @Override
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return columnEditable[columnIndex];
                            }
                        });
                        {
                            TableColumnModel cm = table2.getColumnModel();
                            cm.getColumn(0).setResizable(false);
                            cm.getColumn(1).setResizable(false);
                            cm.getColumn(2).setResizable(false);
                            cm.getColumn(3).setResizable(false);
                        }
                        scrollPane2.setViewportView(table2);
                    }
                    compteUser.add(scrollPane2, new GridConstraints(0, 0, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));
                }
                panel3.add(compteUser, "card2");
            }
            PanelP.add(panel3, new GridConstraints(1, 1, 8, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //---- InfoBanquier ----
            InfoBanquier.setFont(new Font("Comfortaa SemiBold", Font.BOLD, InfoBanquier.getFont().getSize()));
            InfoBanquier.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Normal/user.png"))));
            InfoBanquier.setMargin(new Insets(0, 0, 0, 0));
            InfoBanquier.setText("");
            InfoBanquier.setMinimumSize(new Dimension(200, 200));
            InfoBanquier.setMaximumSize(new Dimension(200, 200));
            InfoBanquier.setBorderPainted(false);
            InfoBanquier.setBorder(null);
            InfoBanquier.setFocusPainted(false);
            InfoBanquier.setRolloverIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/user-h.png"))));
            InfoBanquier.setRolloverSelectedIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/user-h.png"))));
            PanelP.add(InfoBanquier, new GridConstraints(2, 0, 1, 1,
                    GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK,
                    null, null, null));
            PanelP.add(vSpacer8, new GridConstraints(3, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK,
                    GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                    null, null, null));

            //---- EffectVirement ----
            EffectVirement.setFont(new Font("Comfortaa SemiBold", Font.BOLD, EffectVirement.getFont().getSize()));
            EffectVirement.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Normal/FV.png"))));
            EffectVirement.setMargin(new Insets(0, 0, 0, 0));
            EffectVirement.setText("");
            EffectVirement.setBorderPainted(false);
            EffectVirement.setBorder(null);
            EffectVirement.setFocusPainted(false);
            EffectVirement.setRolloverIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/FV-H.png"))));
            EffectVirement.setRolloverSelectedIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/FV-H.png"))));
            PanelP.add(EffectVirement, new GridConstraints(4, 0, 1, 1,
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
    public static JPanel PanelP;
    public static JButton header;
    public static JPanel panel3;
    public static TextFieldSearchOption txt;
    public static JTable table1;
    public static JTable table2;
    public static JButton InfoBanquier;
    public static JButton EffectVirement;
    public static JButton consulterComptesButton;
    public static JButton logout;
    public static CardLayout cardLayout;
    public static Banquier banquier;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

