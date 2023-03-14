package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import codigos.BotaoHome;
import codigos.CodigoBarraMenu;
import codigos.ConversorMoeda;

public class TelaConvertMoeda extends JFrame {

	private JPanel contentPane;
	private JTextField valorConverter;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConvertMoeda frame = new TelaConvertMoeda();
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
	public TelaConvertMoeda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		setUndecorated(true); // remove a barra superior com os botoes fechar, minimizar e maximizar
		contentPane = new JPanel();
		contentPane.setBackground(new Color(97, 94, 169));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelResultado = new JLabel("");
		labelResultado.setBorder(new LineBorder(new Color(183, 179, 242)));
		labelResultado.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelResultado.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultado.setBackground(new Color(119, 117, 176));
		labelResultado.setBounds(25, 175, 352, 128);
		contentPane.add(labelResultado);

		valorConverter = new JTextField();
		valorConverter.setHorizontalAlignment(SwingConstants.CENTER);
		valorConverter.setForeground(new Color(102, 51, 153));
		valorConverter.setFont(new Font("Tahoma", Font.PLAIN, 30));
		valorConverter.setBackground(new Color(157, 156, 199));
		valorConverter.setBounds(10, 421, 380, 98);
		contentPane.add(valorConverter);
		valorConverter.setColumns(10);

//inicio menu escolher moeda 	    
		JComboBox<String> toMoeda = new JComboBox<String>();
		toMoeda.addItem("BRL");
		toMoeda.addItem("USD");
		toMoeda.addItem("EUR");
		toMoeda.addItem("GBP");
		toMoeda.addItem("ARS");
		toMoeda.addItem("CLP");
		toMoeda.setBounds(239, 376, 151, 23);
		contentPane.add(toMoeda);
		setVisible(true);

		JComboBox<String> fromMoeda = new JComboBox<String>();
		fromMoeda.addItem("BRL");
		fromMoeda.addItem("USD");
		fromMoeda.addItem("EUR");
		fromMoeda.addItem("GBP");
		fromMoeda.addItem("ARS");
		fromMoeda.addItem("CLP");
		fromMoeda.setBounds(10, 376, 151, 23);
		contentPane.add(fromMoeda);
		setVisible(true);

//fim do menu escolher moeda

//inicio do botão que convert        
		JButton btnConvert = new JButton("Converter");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String from = (String) fromMoeda.getSelectedItem();
					String to = (String) toMoeda.getSelectedItem();
					double valor = Double.parseDouble(valorConverter.getText());

					double resultado = ConversorMoeda.converter(from, to, valor);
					labelResultado.setText(String.format("%.2f", resultado));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao converter moeda: " + ex.getMessage());
				}
			}
		});

		btnConvert.setBorder(null);
		btnConvert.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnConvert.setForeground(new Color(86, 84, 148));
		btnConvert.setBackground(new Color(157, 156, 199));
		btnConvert.setBounds(133, 554, 123, 23);
		contentPane.add(btnConvert);
//fim do botão que convert  	    

		JButton btnInvert = new JButton("");
		btnInvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String from = (String) fromMoeda.getSelectedItem();
				String to = (String) toMoeda.getSelectedItem();
				fromMoeda.setSelectedItem(to);
				toMoeda.setSelectedItem(from);
			}
		});

		btnInvert.setBorder(null);
		btnInvert.setBackground(new Color(97, 94, 169));
		btnInvert.setIcon(new ImageIcon(TelaConvertMoeda.class.getResource("/imgs/Vector.png")));
		btnInvert.setBounds(184, 365, 45, 45);
		contentPane.add(btnInvert);

		JLabel lblCurrency = new JLabel("Currency");
		lblCurrency.setForeground(new Color(157, 156, 199));
		lblCurrency.setFont(new Font("Calibri Light", Font.PLAIN, 29));
		lblCurrency.setBounds(139, 120, 117, 28);
		contentPane.add(lblCurrency);
		this.setVisible(true);

		CodigoBarraMenu painel = new CodigoBarraMenu();
		getContentPane().add(painel);

		BotaoHome home = new BotaoHome(painel, this);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaConvertMoeda.class.getResource("/imgs/exchange-V1 2.png")));
		lblNewLabel.setBackground(new Color(114, 144, 255));
		lblNewLabel.setBounds(10, 11, 45, 45);
		painel.add(lblNewLabel);
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaInicial telainicial = new TelaInicial();
				telainicial.setVisible(true);
				dispose();
			};

		});

	}
}
