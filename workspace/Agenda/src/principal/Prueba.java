package principal;
import conexion.Conexion;
import java.sql.Connection;
public class Prueba {
	
	public static void main (String[]args){
		Connection cn=null;
		Conexion cc=new Conexion();
		cn=cc.conectar();
		
	}
	
	
	
}
