package Methodes;

import MODEL.User;

import javax.swing.table.AbstractTableModel;

public class PersonTableModel extends AbstractTableModel {

    // Define the column names
    private final String[] columnNames = {"Donnée Personnel", ""};

    // Define the data as a two-dimensional object array
    private final Object[][] data = {
            {"Nom", ""},
            {"Prénom", ""},
            {"Addresse", ""},
            {"Numéro Téléphone", ""},
            {"Couriel Electronique", ""}
    };

    public PersonTableModel(User cli) {
        // Update the data array with the Person object's attributes
        data[0][1] = ": " + cli.getNom();
        data[1][1] = ": " + cli.getPrenom();
        data[2][1] = ": " + cli.getAdr();
        data[3][1] = ": " + cli.getTel();
        data[4][1] = ": " + cli.getEmail();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        return data[row][column];
    }
}
