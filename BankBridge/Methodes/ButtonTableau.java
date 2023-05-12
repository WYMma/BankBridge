package Methodes;

import CONTROLLER.AdminController;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import static Methodes.AjoutUser.encrypt;
import static CONTROLLER.AdminController.EnregistrerClient;
import static CONTROLLER.AdminController.EnregistrerCompte;

public class ButtonTableau {
    public static class OperationBanquaire extends JButton implements TableCellRenderer {
        public OperationBanquaire() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            setText("");
            setContentAreaFilled(false);
            setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Normal/operer.png"))));
            setBorderPainted(false);
            setBorder(null);
            setFocusPainted(false);
            return this;
        }
    }

    public static class OperationBanquaireEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
        JButton button;
        JTable table;
        int row;
        int column;

        public OperationBanquaireEditor() {
            button = new JButton();
            button.addActionListener(this);
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                                                     int column) {
            this.table = table;
            this.row = row;
            this.column = column;
            return button;
        }

        public Object getCellEditorValue() {
            return "";
        }

        public void actionPerformed(ActionEvent e) {
            long rib = (long) table.getValueAt(row, 0);
            new CrediDebi(rib);
            fireEditingStopped();
        }
    }

    public static class SaveUser extends JButton implements TableCellRenderer {
        public SaveUser() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            setText("");
            setContentAreaFilled(false);
            setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Normal/save.png"))));
            setBorderPainted(false);
            setBorder(null);
            setFocusPainted(false);
            return this;
        }
    }

    public static class SaveUserEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
        JButton button;
        JTable table;
        int row;
        int column;

        public SaveUserEditor() {
            button = new JButton();
            button.addActionListener(this);
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                                                     int column) {
            this.table = table;
            this.row = row;
            this.column = column;
            return button;
        }

        public Object getCellEditorValue() {
            return "";
        }

        public void actionPerformed(ActionEvent e) {
            String id = (String) table.getValueAt(row, 0);
            String nom = (String) table.getValueAt(row, 3);
            String pre = (String) table.getValueAt(row, 4);
            String email = (String) table.getValueAt(row, 7);
            String tel = (String) table.getValueAt(row, 6);
            String adr = (String) table.getValueAt(row, 5);
            String type = (String) table.getValueAt(row, 8);
            String log = (String) table.getValueAt(row, 1);
            String mdp = encrypt((String) table.getValueAt(row, 2));
            EnregistrerClient(id, log, mdp, nom, pre, email, tel, adr, type);
            fireEditingStopped();
        }
    }

    public static class SaveBank extends JButton implements TableCellRenderer {
        public SaveBank() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            setText("");
            setContentAreaFilled(false);
            setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Normal/save-b.png"))));
            setBorderPainted(false);
            setBorder(null);
            setFocusPainted(false);
            return this;
        }
    }

    public static class SaveBankEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
        JButton button;
        JTable table;
        int row;
        int column;

        public SaveBankEditor() {
            button = new JButton();
            button.addActionListener(this);
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                                                     int column) {
            this.table = table;
            this.row = row;
            this.column = column;
            return button;
        }

        public Object getCellEditorValue() {
            return "";
        }

        public void actionPerformed(ActionEvent e) {
            String rib = String.valueOf(table.getValueAt(row, 0));
            String solde = String.valueOf(table.getValueAt(row, 1));
            String type = String.valueOf(table.getValueAt(row, 2));
            String prop = String.valueOf(table.getValueAt(row, 3));
            String nomBank = String.valueOf(table.getValueAt(row, 4));
            EnregistrerCompte(rib, solde, type, prop, nomBank);
            fireEditingStopped();
        }
    }

    public static class DeleteUser extends JButton implements TableCellRenderer {
        public DeleteUser() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            setText("");
            setContentAreaFilled(false);
            setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Normal/delete.png"))));
            setBorderPainted(false);
            setBorder(null);
            setFocusPainted(false);
            return this;
        }
    }

    public static class DeleteUserEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
        JButton button;
        JTable table;
        int row;
        int column;

        public DeleteUserEditor() {
            button = new JButton();
            button.addActionListener(this);
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                                                     int column) {
            this.table = table;
            this.row = row;
            this.column = column;
            return button;
        }

        public Object getCellEditorValue() {
            return "";
        }

        public void actionPerformed(ActionEvent e) {
            int confirmed = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer cet utilisateur?", "Confirmer la Supression", JOptionPane.YES_NO_OPTION);

            if (confirmed == JOptionPane.YES_OPTION) {
                String id = table.getValueAt(row, 0).toString();
                AdminController.SuprimerClient(id);
            }
            fireEditingStopped();
            AdminController.loadUser("");
        }
    }

    public static class DeleteBank extends JButton implements TableCellRenderer {
        public DeleteBank() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            setText("");
            setContentAreaFilled(false);
            setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button/Normal/delete.png"))));
            setBorderPainted(false);
            setBorder(null);
            setFocusPainted(false);
            return this;
        }
    }

    public static class DeleteBankEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
        JButton button;
        JTable table;
        int row;
        int column;

        public DeleteBankEditor() {
            button = new JButton();
            button.addActionListener(this);
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                                                     int column) {
            this.table = table;
            this.row = row;
            this.column = column;
            return button;
        }

        public Object getCellEditorValue() {
            return "";
        }

        public void actionPerformed(ActionEvent e) {
            int confirmed = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer ce compte banquaire?", "Confirmer la Supression", JOptionPane.YES_NO_OPTION);

            if (confirmed == JOptionPane.YES_OPTION) {
                String rib = table.getValueAt(row, 0).toString();
                AdminController.SuprimerCompte(rib);
            }
            fireEditingStopped();
            AdminController.loadBank("");
        }
    }
}
