package VIEW;

import MODEL.Admin;
import Methodes.*;
import CONTROLLER.AdminController;
import CONTROLLER.UserController;
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

public class AdminView extends JFrame {
    public AdminView() {
        initComponents();
        setTitle("BankBridge");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600, 900);
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("images/logo.png");
        setIconImage(icon.getImage());
        add(PanelP);
        ajoutUser.addActionListener(ae -> AdminController.AjouterClient());
        ajoutBanquaire.addActionListener(ae -> AdminController.AjouterCompte());
        consulterComptesButton.addActionListener(ae -> AdminController.loadBank(""));
        consulterComptesButton.setBorder(BorderFactory.createEmptyBorder());
        consulterComptesButton.setContentAreaFilled(false);
        consulterUser.addActionListener(ae -> AdminController.loadUser(""));
        consulterUser.setBorder(BorderFactory.createEmptyBorder());
        consulterUser.setContentAreaFilled(false);
        InfoAdmin.addActionListener(ae -> {
            UserController.ConsulterUser(TableUser, admin);
            cardLayout.show(panel3, "card2");
        });
        InfoAdmin.setBorder(BorderFactory.createEmptyBorder());
        InfoAdmin.setContentAreaFilled(false);
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
        fermer.addActionListener(e -> {
            int confirmed = JOptionPane.showConfirmDialog(null,
                    "Voulez-vous vraiment quitter le programme ?", "Confirmer Quitter",
                    JOptionPane.YES_NO_OPTION);

            if (confirmed == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        fermer.setBorder(BorderFactory.createEmptyBorder());
        fermer.setContentAreaFilled(false);
        RechercheBanquaire.addEventOptionSelected((option, index) -> RechercheBanquaire.setHint("Recherche par " + option.getName() + "..."));
        RechercheBanquaire.addOption(new SearchOption("RIB", new ImageIcon("images/search/rib.png")));
        RechercheBanquaire.addOption(new SearchOption("Nom Propriétaire", new ImageIcon("images/search/nom.png")));
        RechercheBanquaire.addOption(new SearchOption("Type de compte", new ImageIcon("images/search/type.png")));
        RechercheUser.addEventOptionSelected((option, index) -> RechercheUser.setHint("Recherche par " + option.getName() + "..."));
        RechercheUser.addOption(new SearchOption("Login", new ImageIcon("images/search/unom.png")));
        RechercheUser.addOption(new SearchOption("Nom Propriétaire", new ImageIcon("images/search/nom.png")));
        RechercheUser.addOption(new SearchOption("Addresse", new ImageIcon("images/search/address.png")));
        RechercheUser.addOption(new SearchOption("Tel", new ImageIcon("images/search/tel.png")));
        RechercheUser.addOption(new SearchOption("Email", new ImageIcon("images/search/email.png")));
        RechercheUser.addOption(new SearchOption("Type de compte", new ImageIcon("images/search/utype.png")));
        setVisible(true);
        UserController.ConsulterUser(TableUser, admin);
        cardLayout.show(panel3, "card2");
        TableCompte.getColumn("Save").setCellRenderer(new ButtonTableau.SaveBank());
        TableCompte.getColumn("Save").setCellEditor(new ButtonTableau.SaveBankEditor());
        TableCompte.getColumn("Delete").setCellRenderer(new ButtonTableau.DeleteBank());
        TableCompte.getColumn("Delete").setCellEditor(new ButtonTableau.DeleteBankEditor());
        TableUtilisateur.getColumn("Save").setCellRenderer(new ButtonTableau.SaveUser());
        TableUtilisateur.getColumn("Save").setCellEditor(new ButtonTableau.SaveUserEditor());
        TableUtilisateur.getColumn("Delete").setCellRenderer(new ButtonTableau.DeleteUser());
        TableUtilisateur.getColumn("Delete").setCellEditor(new ButtonTableau.DeleteUserEditor());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        PanelP = new JPanel();
        header = new JButton();
        var vSpacer2 = new Spacer();
        panel3 = new JPanel();
        JPanel donneeUser = new JPanel();
        var scrollPane2 = new JScrollPane();
        TableUser = new JTable();
        JPanel compteBank = new JPanel();
        var hSpacer1 = new Spacer();
        RechercheBanquaire = new TextFieldSearchOption();
        ajoutBanquaire = new JButton();
        var scrollPane1 = new raven.scroll.win11.ScrollPaneWin11();
        TableCompte = new JTable();
        var vSpacer1 = new Spacer();
        JPanel compteUser = new JPanel();
        var hSpacer2 = new Spacer();
        RechercheUser = new TextFieldSearchOption();
        ajoutUser = new JButton();
        var scrollPane3 = new raven.scroll.win11.ScrollPaneWin11();
        TableUtilisateur = new JTable();
        var vSpacer3 = new Spacer();
        InfoAdmin = new JButton();
        var vSpacer8 = new Spacer();
        consulterUser = new JButton();
        consulterComptesButton = new JButton();
        var vSpacer9 = new Spacer();
        logout = new JButton();
        fermer = new JButton();
        var vSpacer7 = new Spacer();

        //======== PanelP ========
        {
            PanelP.setMaximumSize(new Dimension(1600, 900));
            PanelP.setMinimumSize(new Dimension(1600, 900));
            PanelP.setPreferredSize(new Dimension(1600, 900));
            PanelP.setBackground(Color.white);
            PanelP.setLayout(new GridLayoutManager(10, 2, new Insets(0, 0, 0, 0), 0, 0));

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
                panel3.setBorder(new BevelBorder(BevelBorder.LOWERED));
                panel3.setLayout(cardLayout = new CardLayout());

                //======== DonneeUser ========
                {
                    donneeUser.setBackground(Color.white);
                    donneeUser.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), 0, 0));

                    //======== scrollPane2 ========
                    {

                        //---- TableUser ----
                        TableUser.setAlignmentX(0.0F);
                        TableUser.setAlignmentY(0.0F);
                        TableUser.setAutoCreateRowSorter(true);
                        TableUser.setFont(new Font("Comfortaa SemiBold", Font.BOLD, TableUser.getFont().getSize()));
                        TableUser.setRowHeight(40);
                        TableUser.setSelectionBackground(new Color(0x046b67));
                        TableUser.setSelectionForeground(Color.white);
                        TableUser.setShowHorizontalLines(true);
                        TableUser.setShowVerticalLines(true);
                        TableUser.setCellSelectionEnabled(true);
                        TableUser.setFillsViewportHeight(true);
                        TableUser.setModel(new DefaultTableModel(
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
                            TableColumnModel cm = TableUser.getColumnModel();
                            cm.getColumn(0).setResizable(false);
                            cm.getColumn(1).setResizable(false);
                            cm.getColumn(2).setResizable(false);
                            cm.getColumn(3).setResizable(false);
                        }
                        TableUser.setRowSorter(null);
                        scrollPane2.setViewportView(TableUser);
                    }
                    donneeUser.add(scrollPane2, new GridConstraints(0, 0, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));
                }
                panel3.add(donneeUser, "card2");

                //======== CompteBank ========
                {
                    compteBank.setLayout(new GridLayoutManager(3, 3, new Insets(0, 0, 0, 0), 0, 0));
                    compteBank.add(hSpacer1, new GridConstraints(0, 0, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                            GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK,
                            null, null, null));

                    //---- RechercheBanquaire ----
                    RechercheBanquaire.setColorOverlay1(new Color(0x17c6bf));
                    RechercheBanquaire.setHint("Recherche...");
                    RechercheBanquaire.setMaximumSize(new Dimension(64, 36));
                    RechercheBanquaire.setMargin(null);
                    RechercheBanquaire.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyReleased(KeyEvent e) {
                            Recherche.RechercheBanquaireKeyReleased(RechercheBanquaire);
                        }
                    });
                    compteBank.add(RechercheBanquaire, new GridConstraints(0, 0, 1, 2,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));

                    //---- ajoutBanquaire ----
                    ajoutBanquaire.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Normal/add-credit.png"))));
                    ajoutBanquaire.setHorizontalAlignment(SwingConstants.LEFT);
                    ajoutBanquaire.setMargin(null);
                    ajoutBanquaire.setMaximumSize(new Dimension(33, 33));
                    ajoutBanquaire.setMinimumSize(new Dimension(33, 33));
                    ajoutBanquaire.setPreferredSize(new Dimension(33, 33));
                    ajoutBanquaire.setFocusable(false);
                    ajoutBanquaire.setFocusPainted(false);
                    ajoutBanquaire.setRolloverIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/add-credit-h.png"))));
                    ajoutBanquaire.setRolloverSelectedIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/add-credit-h.png"))));
                    ajoutBanquaire.setBorder(null);
                    ajoutBanquaire.setBorderPainted(false);
                    compteBank.add(ajoutBanquaire, new GridConstraints(0, 2, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            new Dimension(33, 33), new Dimension(33, 33), new Dimension(33, 33)));

                    //======== scrollPane1 ========
                    {

                        //---- TableCompte ----
                        TableCompte.setAlignmentX(0.0F);
                        TableCompte.setAlignmentY(0.0F);
                        TableCompte.setAutoCreateRowSorter(true);
                        TableCompte.setFont(new Font("Comfortaa SemiBold", Font.BOLD, TableCompte.getFont().getSize()));
                        TableCompte.setRowHeight(40);
                        TableCompte.setSelectionBackground(new Color(0x046b67));
                        TableCompte.setSelectionForeground(Color.white);
                        TableCompte.setCellSelectionEnabled(true);
                        TableCompte.setFillsViewportHeight(true);
                        TableCompte.setModel(new DefaultTableModel(
                                new Object[][] {
                                },
                                new String[] {
                                        "RIB", "Solde (TND)", "Type de Compte", "Propriétaire","Bank Associée", "Save", "Delete"
                                }
                        ) {
                            final Class<?>[] columnTypes = new Class<?>[] {
                                    String.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
                            };
                            @Override
                            public Class<?> getColumnClass(int columnIndex) {
                                return columnTypes[columnIndex];
                            }
                        });
                        {
                            TableColumnModel cm = TableCompte.getColumnModel();
                            cm.getColumn(0).setResizable(false);
                            cm.getColumn(1).setResizable(false);
                            cm.getColumn(2).setResizable(false);
                            cm.getColumn(3).setResizable(false);
                            cm.getColumn(4).setResizable(false);
                            cm.getColumn(5).setResizable(false);
                            cm.getColumn(5).setMinWidth(40);
                            cm.getColumn(5).setMaxWidth(40);
                            cm.getColumn(5).setPreferredWidth(40);
                            cm.getColumn(6).setResizable(false);
                            cm.getColumn(6).setMinWidth(55);
                            cm.getColumn(6).setMaxWidth(55);
                            cm.getColumn(6).setPreferredWidth(55);
                        }
                        TableCompte.setRowSorter(null);
                        scrollPane1.setViewportView(TableCompte);
                    }
                    compteBank.add(scrollPane1, new GridConstraints(1, 0, 1, 3,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));
                    compteBank.add(vSpacer1, new GridConstraints(1, 1, 2, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK,
                            GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                            null, null, null));
                }
                panel3.add(compteBank, "card1");

                //======== CompteUser ========
                {
                    compteUser.setLayout(new GridLayoutManager(2, 3, new Insets(0, 0, 0, 0), 0, 0));
                    compteUser.add(hSpacer2, new GridConstraints(0, 0, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                            GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK,
                            null, null, null));

                    //---- RechercheUser ----
                    RechercheUser.setColorOverlay1(new Color(0x17c6bf));
                    RechercheUser.setHint("Recherche...");
                    RechercheUser.setMaximumSize(new Dimension(64, 36));
                    RechercheUser.setMargin(null);
                    RechercheUser.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyReleased(KeyEvent e) {
                            Recherche.RechercheUserKeyReleased(RechercheUser);
                        }
                    });
                    compteUser.add(RechercheUser, new GridConstraints(0, 0, 1, 2,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));

                    //---- ajoutUser ----
                    ajoutUser.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Normal/add-user.png"))));
                    ajoutUser.setHorizontalAlignment(SwingConstants.LEFT);
                    ajoutUser.setMargin(null);
                    ajoutUser.setMaximumSize(new Dimension(33, 33));
                    ajoutUser.setMinimumSize(new Dimension(33, 33));
                    ajoutUser.setPreferredSize(new Dimension(33, 33));
                    ajoutUser.setFocusable(false);
                    ajoutUser.setFocusPainted(false);
                    ajoutUser.setRolloverIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/add-user-h.png"))));
                    ajoutUser.setRolloverSelectedIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/add-user-h.png"))));
                    ajoutUser.setBorder(null);
                    ajoutUser.setBorderPainted(false);
                    compteUser.add(ajoutUser, new GridConstraints(0, 2, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            new Dimension(33, 33), new Dimension(33, 33), new Dimension(33, 33)));

                    //======== scrollPane3 ========
                    {

                        //---- TableUtilisateur ----
                        TableUtilisateur.setAlignmentX(0.0F);
                        TableUtilisateur.setAlignmentY(0.0F);
                        TableUtilisateur.setAutoCreateRowSorter(true);
                        TableUtilisateur.setFont(new Font("Comfortaa SemiBold", Font.BOLD, TableUtilisateur.getFont().getSize()));
                        TableUtilisateur.setRowHeight(40);
                        TableUtilisateur.setSelectionBackground(new Color(0x046b67));
                        TableUtilisateur.setSelectionForeground(Color.white);
                        TableUtilisateur.setCellSelectionEnabled(true);
                        TableUtilisateur.setFillsViewportHeight(true);
                        TableUtilisateur.setModel(new DefaultTableModel(
                                new Object[][] {
                                },
                                new String[] {
                                        "ID", "Login", "MDP", "Nom", "Prenom", "Addresse", "Num Tél", "E-mail", "Type", "Save", "Delete"
                                }
                        ) {
                            final Class<?>[] columnTypes = new Class<?>[] {
                                    String.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
                            };
                            final boolean[] columnEditable = new boolean[] {
                                    false, true, true, true, true, true, true, true, true, true, true
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
                            TableColumnModel cm = TableUtilisateur.getColumnModel();
                            cm.getColumn(0).setResizable(false);
                            cm.getColumn(0).setMinWidth(30);
                            cm.getColumn(0).setMaxWidth(30);
                            cm.getColumn(0).setPreferredWidth(30);
                            cm.getColumn(1).setResizable(false);
                            cm.getColumn(2).setResizable(false);
                            cm.getColumn(3).setResizable(false);
                            cm.getColumn(4).setResizable(false);
                            cm.getColumn(4).setMinWidth(85);
                            cm.getColumn(4).setMaxWidth(85);
                            cm.getColumn(4).setPreferredWidth(85);
                            cm.getColumn(5).setResizable(false);
                            cm.getColumn(6).setResizable(false);
                            cm.getColumn(7).setResizable(false);
                            cm.getColumn(8).setResizable(false);
                            cm.getColumn(9).setMinWidth(40);
                            cm.getColumn(9).setMaxWidth(40);
                            cm.getColumn(9).setPreferredWidth(40);
                            cm.getColumn(10).setMinWidth(55);
                            cm.getColumn(10).setMaxWidth(55);
                            cm.getColumn(10).setPreferredWidth(55);
                        }
                        TableUtilisateur.setRowSorter(null);
                        scrollPane3.setViewportView(TableUtilisateur);
                    }
                    compteUser.add(scrollPane3, new GridConstraints(1, 0, 1, 3,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                            null, null, null));
                    compteUser.add(vSpacer3, new GridConstraints(1, 1, 1, 1,
                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                            GridConstraints.SIZEPOLICY_CAN_SHRINK,
                            GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                            null, null, null));
                }
                panel3.add(compteUser, "card3");
            }
            PanelP.add(panel3, new GridConstraints(1, 1, 9, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //---- InfoAdmin ----
            InfoAdmin.setFont(new Font("Comfortaa SemiBold", Font.BOLD, InfoAdmin.getFont().getSize()));
            InfoAdmin.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Normal/user.png"))));
            InfoAdmin.setMargin(new Insets(0, 0, 0, 0));
            InfoAdmin.setText("");
            InfoAdmin.setMinimumSize(new Dimension(200, 200));
            InfoAdmin.setMaximumSize(new Dimension(200, 200));
            InfoAdmin.setBorderPainted(false);
            InfoAdmin.setBorder(null);
            InfoAdmin.setFocusPainted(false);
            InfoAdmin.setRolloverIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/user-h.png"))));
            InfoAdmin.setRolloverSelectedIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/user-h.png"))));
            PanelP.add(InfoAdmin, new GridConstraints(2, 0, 1, 1,
                    GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK,
                    null, null, null));
            PanelP.add(vSpacer8, new GridConstraints(3, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK,
                    GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                    null, null, null));

            //---- consulterUser ----
            consulterUser.setFont(new Font("Comfortaa SemiBold", Font.BOLD, consulterUser.getFont().getSize()));
            consulterUser.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Normal/cu.png"))));
            consulterUser.setMargin(new Insets(0, 0, 0, 0));
            consulterUser.setText("");
            consulterUser.setBorderPainted(false);
            consulterUser.setBorder(null);
            consulterUser.setFocusPainted(false);
            consulterUser.setRolloverIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/cu-h.png"))));
            consulterUser.setRolloverSelectedIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/cu-h.png"))));
            PanelP.add(consulterUser, new GridConstraints(4, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                    GridConstraints.SIZEPOLICY_FIXED,
                    GridConstraints.SIZEPOLICY_FIXED,
                    null, null, null));

            //---- consulterComptesButton ----
            consulterComptesButton.setFont(new Font("Comfortaa SemiBold", Font.BOLD, consulterComptesButton.getFont().getSize()));
            consulterComptesButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Normal/cb.png"))));
            consulterComptesButton.setMargin(new Insets(0, 0, 0, 0));
            consulterComptesButton.setText("");
            consulterComptesButton.setBorderPainted(false);
            consulterComptesButton.setBorder(null);
            consulterComptesButton.setIconTextGap(0);
            consulterComptesButton.setFocusPainted(false);
            consulterComptesButton.setRolloverIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/cb-h.png"))));
            consulterComptesButton.setRolloverSelectedIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/cb-h.png"))));
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

            //---- fermer ----
            fermer.setFont(new Font("Comfortaa SemiBold", Font.BOLD, fermer.getFont().getSize()));
            fermer.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Normal/fermer.png"))));
            fermer.setMargin(new Insets(0, 0, 200, 0));
            fermer.setText("");
            fermer.setAlignmentY(0.0F);
            fermer.setMaximumSize(new Dimension(87, 100));
            fermer.setMinimumSize(new Dimension(87, 100));
            fermer.setPreferredSize(new Dimension(87, 100));
            fermer.setBorderPainted(false);
            fermer.setBorder(null);
            fermer.setRequestFocusEnabled(false);
            fermer.setFocusPainted(false);
            fermer.setRolloverIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/fermer-h.png"))));
            fermer.setRolloverSelectedIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Hovered/fermer-h.png"))));
            PanelP.add(fermer, new GridConstraints(8, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                    GridConstraints.SIZEPOLICY_FIXED,
                    GridConstraints.SIZEPOLICY_FIXED,
                    new Dimension(119, 45), new Dimension(119, 45), new Dimension(119, 45)));
            PanelP.add(vSpacer7, new GridConstraints(9, 0, 1, 1,
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
    public static  JPanel panel3;
    public static  JTable TableUser;
    public static  TextFieldSearchOption RechercheBanquaire;
    public static  JButton ajoutBanquaire;
    public static  JTable TableCompte;
    public static  TextFieldSearchOption RechercheUser;
    public static  JButton ajoutUser;
    public static  JTable TableUtilisateur;
    public static  JButton InfoAdmin;
    public static  JButton consulterUser;
    public static  JButton consulterComptesButton;
    public static  JButton logout;
    public static  JButton fermer;
    public static  CardLayout cardLayout;
    public static Admin admin;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
