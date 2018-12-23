package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Vista2 extends JFrame {

	private JPanel contentPane;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista2 frame = new Vista2();
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
	public Vista2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgenda = new JLabel("Agenda");
		lblAgenda.setBounds(180, 40, 46, 14);
		contentPane.add(lblAgenda);
		
		button = new JButton("<<");
		button.setBounds(24, 433, 66, 23);
		contentPane.add(button);
		
		button_1 = new JButton("<");
		button_1.setBounds(110, 433, 66, 23);
		contentPane.add(button_1);
		
		button_2 = new JButton(">");
		button_2.setBounds(203, 433, 66, 23);
		contentPane.add(button_2);
		
		button_3 = new JButton(">>");
		button_3.setBounds(298, 433, 66, 23);
		contentPane.add(button_3);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 86, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setBounds(24, 129, 123, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(24, 173, 46, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblTelefonoFijo = new JLabel("Telefono Fijo:");
		lblTelefonoFijo.setBounds(24, 209, 76, 14);
		contentPane.add(lblTelefonoFijo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(148, 126, 28, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(186, 126, 28, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(224, 126, 28, 20);
		contentPane.add(comboBox_2);
		
		JLabel lblPginaWeb = new JLabel("P\u00E1gina web:");
		lblPginaWeb.setBounds(24, 242, 91, 14);
		contentPane.add(lblPginaWeb);
		
		JLabel lblFoto = new JLabel("FOTO");
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setBounds(284, 70, 91, 92);
		contentPane.add(lblFoto);
		
		textField = new JTextField();
		textField.setBounds(148, 206, 103, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(148, 239, 170, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(148, 170, 170, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(148, 83, 170, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(24, 290, 66, 14);
		contentPane.add(lblDescripcin);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(148, 290, 187, 106);
		contentPane.add(textPane);
	}
}
