package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import conexion.Conexion;
import dao.AgendaDAO;
import vo.AgendaVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Vista1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTextField txtCodigo;
	private JTable table;
	private JButton btnModificar;
	private JButton btnGuardar;
	private JButton btnNuevo;
	private JButton btnEliminar;
	private JButton btnSalir;

	DefaultTableModel modelo;
	AgendaDAO dao;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista1 frame = new Vista1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista1() {
		
		inicializar();
		eventos();
		cargar("");
		
	}
	
	
	private void inicializar(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 727);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVista = new JLabel("Vista 1");
		lblVista.setBounds(219, 32, 46, 14);
		contentPane.add(lblVista);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombres.setBounds(118, 159, 84, 14);
		contentPane.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellidos.setBounds(118, 114, 84, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccin.setBounds(118, 208, 84, 14);
		contentPane.add(lblDireccin);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorreo.setBounds(124, 299, 78, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfono.setBounds(118, 254, 84, 14);
		contentPane.add(lblTelfono);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(241, 111, 86, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(241, 156, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(241, 205, 86, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(241, 251, 86, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(241, 296, 86, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCdigo.setBounds(118, 71, 84, 14);
		contentPane.add(lblCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(241, 68, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		
		btnGuardar.setBounds(45, 343, 89, 23);
		contentPane.add(btnGuardar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(155, 343, 89, 23);
		contentPane.add(btnNuevo);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(268, 343, 89, 23);
		contentPane.add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(379, 343, 89, 23);
		contentPane.add(btnModificar);
		
		btnSalir = new JButton("Salir");
		
		btnSalir.setBounds(219, 391, 89, 23);
		contentPane.add(btnSalir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 486, 445, 179);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		setLocationRelativeTo(null);
	}
	
	public void eventos(){
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int respuesta=JOptionPane.showConfirmDialog(null,"Desea Salir?","Salir",JOptionPane.YES_NO_OPTION);
				if (respuesta==0){
					dispose();
					JOptionPane.showMessageDialog(null,"Gracias por usar el programa","Saliendo",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertar();
				cargar("");
			}
		});
		
	}
	
	
	
	public void cargar(String valor){
		String[] titulos={"ID","APELLIDOS","NOMBRES","DIRECCIÓN","TELÉFONO","CORREO"};
		String[]filas=new String[6];
		String sql="Select * from contactos where id like '%"+valor+"%'";
		
		modelo=new DefaultTableModel(null, titulos);
		Conexion cox=new Conexion();
		Connection cn;
		Statement st;
		try{
			cn=cox.conectar();
			st=cn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				filas[0]=rs.getString("id");
				filas[1]=rs.getString("apellido");
				filas[2]=rs.getString("nombres");
				filas[3]=rs.getString("direccion");
				filas[4]=rs.getString("telefono");
				filas[5]=rs.getString("correo");
				modelo.addRow(filas);
			}
			table.setModel(modelo);
		}
		catch(NullPointerException z){
			JOptionPane.showMessageDialog(null,"Error al cargar los datos");
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void insertar(){
		int indice=Integer.parseInt(txtCodigo.getText());
		String apellidos=txtApellido.getText();
		String nombres=txtNombre.getText();
		String direccion=txtDireccion.getText();
		String telefono=txtTelefono.getText();
		String correo=txtCorreo.getText();
		
		AgendaVO vo=new AgendaVO();
		dao=new AgendaDAO();
		vo.setIndice(indice);
		vo.setApellido(apellidos);
		vo.setNombre(nombres);
		vo.setDireccion(direccion);
		vo.setTelefono(telefono);
		vo.setCorreo(correo);
		dao.insertarAgenda(vo);
	}
	
}
