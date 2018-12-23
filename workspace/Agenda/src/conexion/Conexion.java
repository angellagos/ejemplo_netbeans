package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	Connection cn=null;
	public Connection conectar(){
	try {
		Class.forName("com.mysql.jdbc.Driver");
		cn=DriverManager.getConnection("jdbc:mysql://localhost/agenda","root","");
		JOptionPane.showMessageDialog(null,"Se conecto");
	}
	catch (ClassNotFoundException | SQLException e){
		JOptionPane.showMessageDialog(null, "No se pudo conectar","Error",JOptionPane.ERROR_MESSAGE);
	}
	return cn;
	
}
	
	
}
