package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import codigos.BotaoHome;
import codigos.CodigoBarraMenu;
import codigos.ConversorBrixDensidade;
import javax.swing.ImageIcon;

public class TelaConvertBrix extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField valorConverter;

	ConversorBrixDensidade conversorbrixdensidade = new ConversorBrixDensidade();
	private JTextField textFieldDensity;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConvertBrix frame = new TelaConvertBrix();
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
	public TelaConvertBrix() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		setUndecorated(true); // remove a barra superior com os botoes fechar, minimizar e maximizar
		contentPane = new JPanel();
		contentPane.setBackground(new Color(97, 94, 169));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		valorConverter = new JTextField();
		valorConverter.setHorizontalAlignment(SwingConstants.CENTER);
		valorConverter.setForeground(new Color(102, 51, 153));
		valorConverter.setFont(new Font("Tahoma", Font.PLAIN, 30));
		valorConverter.setBackground(new Color(157, 156, 199));
		valorConverter.setBounds(10, 251, 152, 33);
		contentPane.add(valorConverter);
		valorConverter.setColumns(10);
		setVisible(true);
		setVisible(true);

//fim do menu escolher moeda

//inicio do botão que convert       
		JButton btnConvert = new JButton("Converter");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String valorconverter = valorConverter.getText();
				Double douvalor = Double.parseDouble(valorconverter);
				Double resultvalor = conversorbrixdensidade.calculabrix(douvalor);
				textFieldDensity.setText(String.format("%.3f", resultvalor));
			}
		});

		btnConvert.setBorder(null);
		btnConvert.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnConvert.setForeground(new Color(86, 84, 148));
		btnConvert.setBackground(new Color(157, 156, 199));
		btnConvert.setBounds(139, 431, 123, 23);
		contentPane.add(btnConvert);

		JLabel lblNewLabel = new JLabel("BRIXs");
		lblNewLabel.setForeground(new Color(157, 156, 199));
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 29));
		lblNewLabel.setBounds(157, 125, 74, 28);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Density");
		lblNewLabel_1.setForeground(new Color(157, 156, 199));
		lblNewLabel_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(270, 217, 89, 23);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Brix");
		lblNewLabel_1_1.setForeground(new Color(157, 156, 199));
		lblNewLabel_1_1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(54, 217, 52, 23);
		contentPane.add(lblNewLabel_1_1);

		textFieldDensity = new JTextField();
		textFieldDensity.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDensity.setForeground(new Color(102, 51, 153));
		textFieldDensity.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textFieldDensity.setColumns(10);
		textFieldDensity.setBackground(new Color(157, 156, 199));
		textFieldDensity.setBounds(238, 251, 152, 33);
		contentPane.add(textFieldDensity);
		this.setVisible(true);
		
//inicio barra personalizada       
				CodigoBarraMenu painel = new CodigoBarraMenu();
				getContentPane().add(painel);
//fim barra personalizada    

//botao home        
		BotaoHome home1 = new BotaoHome(painel, this);
		
		JLabel lblLogoHup = new JLabel("");
		lblLogoHup.setIcon(new ImageIcon(TelaConvertBrix.class.getResource("/imgs/hop-45x45.png")));
		lblLogoHup.setBounds(10, 11, 45, 45);
		painel.add(lblLogoHup);
		home1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial telainicial = new TelaInicial();
				telainicial.setVisible(true);
				dispose();
			};

		});
//botao home        

	}
}

		