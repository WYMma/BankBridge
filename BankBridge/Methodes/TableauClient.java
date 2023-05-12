package Methodes;

import MODEL.CompteBanquaire;

import javax.swing.table.AbstractTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class TableauClient extends AbstractTableModel {

	ArrayList<CompteBanquaire> data;
	String[] columnNames = {"RIB", "Solde (TND)","Type de Compte","Bank associée"};

	public TableauClient(ArrayList<CompteBanquaire> Compte) {
		data = Compte;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		CompteBanquaire compte = data.get(rowIndex);
		Connection conn = SingletonConnection.getInstance();
		try{
			Statement stmt = conn.createStatement();
			PreparedStatement ps = conn.prepareStatement("Select nomBank from banks inner join comptebanquaire on comptebanquaire.idBank = banks.idbanks where idBank = ?;");
			ps.setString(1, String.valueOf(compte.getIdBank()));
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				return switch (columnIndex) {
					case 0 -> compte.getRIB();
					case 1 -> compte.getSolde();
					case 2 -> compte.getTypeCompte();
					case 3 -> rs.getString("nomBank");
					default -> null;
				};
			}
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}