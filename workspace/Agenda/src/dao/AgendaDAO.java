package dao;

import java.sql.Connection;
import vo.AgendaVO;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;



public class AgendaDAO {
	
	public void insertarAgenda(AgendaVO objAgendaVO){
		Conexion cc=new Conexion();
		Connection cn=cc.conectar();
		String sql="Insert into contactos (id, apellido, nombres, direccion, telefono, correo)"
				+ "values (?,?,?,?,?,?)";
		PreparedStatement ps;
		try{
			ps=cn.prepareCall(sql);
			ps.setInt(1, objAgendaVO.getIndice());
			ps.setString(2, objAgendaVO.getApellido());
			ps.setString(3, objAgendaVO.getNombre());
			ps.setString(4, objAgendaVO.getDireccion());
			ps.setString(5, objAgendaVO.getTelefono());
			ps.setString(6, objAgendaVO.getCorreo());
			ps.executeUpdate();
			ps.close();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		
	}
	
	public ArrayList<AgendaVO> listarAgendaVO(){
		ArrayList<AgendaVO> lista=new ArrayList<AgendaVO>();
		Conexion con=new Conexion();
		String sql="Select * from contactos";
		ResultSet rs=null;
		PreparedStatement ps=null;
		try{
			ps=con.conectar().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				AgendaVO vo=new AgendaVO();
				vo.setIndice(rs.getInt(1));
				vo.setApellido(rs.getString(2));
				vo.setNombre(rs.getString(3));
				vo.setDireccion(rs.getString(3));
				vo.setTelefono(rs.getString(4));
				vo.setCorreo(rs.getString(5));
				lista.add(vo);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public void modificarAgenda(AgendaVO objAgendaVO){
		Conexion cn=new Conexion();
		String sql="update contactos set apellido=?, nombres=?, "
				+"direccion=?, telefono=?, correo=? where id=?";
		PreparedStatement ps=null;
		try {
			ps=cn.conectar().prepareStatement(sql);
			ps.setString(1, objAgendaVO.getApellido());
			ps.setString(2, objAgendaVO.getNombre());
			ps.setString(3, objAgendaVO.getDireccion());
			ps.setString(4, objAgendaVO.getTelefono());
			ps.setString(5,objAgendaVO.getCorreo());
			ps.setInt(6,objAgendaVO.getIndice());
			ps.executeUpdate();
			ps.close();
			cn=null;
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void eliminarAgenda (AgendaVO objAgendaVO){
		Conexion con=new Conexion();
		String sql="delete from contactos where id=?";
		PreparedStatement ps=null;
		try{
			ps=con.conectar().prepareStatement(sql);
			ps.setInt(1,objAgendaVO.getIndice());
			ps.executeUpdate();
			ps.close();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		con=null;
	}
	
}
