package CONTROLLER;

import MODEL.Bank;
import Methodes.SingletonConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankController {
    public static Bank newBANK(String nom) {
        Bank bank = new Bank();
        Connection conn = SingletonConnection.getInstance();
        try {
            PreparedStatement ps;
            ps = conn.prepareStatement("SELECT * FROM banks WHERE nomBank = ?;");
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bank.setIDBank(rs.getInt("idbanks"));
                bank.setLenRIB(rs.getInt("lenRIB"));
                bank.setNomBank(rs.getString("nomBank"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bank;
    }
}
