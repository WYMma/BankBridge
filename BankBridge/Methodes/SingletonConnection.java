package Methodes;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SingletonConnection {
    Properties props = new Properties();
	//Objet Connection
    private static Connection connect;

    //Constructeur privé
    private SingletonConnection() {
        try {

            props.load(new FileInputStream("conf.properties"));
			String url = props.getProperty("jdbc.url");
			String user = props.getProperty("jdbc.user");
			String password = props.getProperty("jdbc.password");
            connect = DriverManager.getConnection(url, user, password);
            System.out.println("connecte");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    //Méthode qui retourne l’instance et la créer si elle n'existe pas
    public static Connection getInstance() {
        if (connect == null) {

            new SingletonConnection();
        }
        return connect;
    }


}
