package telas;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class TelaInicial extends JFrame {

	private JPanel painel;
	protected Point mousePosition;
	private Window[] frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		setUndecorated(true); // remove a barra superior com os botoes fechar, minimizar e maximizar
		painel = new JPanel();
		painel.setBackground(new Color(97, 94, 169));
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painel);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConvertForce convertforce = new TelaConvertForce();
				convertforce.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(36, 151, 125, 177);
		btnNewButton.setIcon(new ImageIcon(TelaInicial.class.getResource("/IMGs/force.png")));

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(207, 151, 126, 177);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaConvertBrix telaconvertebrix = new TelaConvertBrix();
				telaconvertebrix.setVisible(true);
				dispose();

			}
		});
		btnNewButton_1.setIcon(new ImageIcon(TelaInicial.class.getResource("/IMGs/hop3.png")));

		JFrame frame = this;
		JButton btncurrency = new JButton("");
		btncurrency.setBounds(36, 358, 125, 176);
		btncurrency.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConvertMoeda telaconversormoeda = new TelaConvertMoeda();
				telaconversormoeda.setVisible(true);
				frame.dispose();
			}
		});
		btncurrency.setIcon(new ImageIcon(TelaInicial.class.getResource("/IMGs/currency.png")));

		JButton btnfile = new JButton("");
		btnfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConvertFile telaconvertfile = new TelaConvertFile();
				telaconvertfile.setVisible(true);
				dispose();
			}
		});
		btnfile.setBounds(207, 358, 126, 176);
		btnfile.setIcon(new ImageIcon(TelaInicial.class.getResource("/IMGs/file.png")));
		painel.setLayout(null);
		painel.add(btnNewButton);
		painel.add(btncurrency);
		painel.add(btnfile);
		painel.add(btnNewButton_1);

		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point newPosition = e.getLocationOnScreen();
				newPosition.translate(-mousePosition.x, -mousePosition.y);
				setLocation(newPosition);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// Mantém a posição do mouse quando ele é pressionado
				mousePosition = e.getPoint();
			}
		});

		panel.setBackground(new Color(114, 144, 255));
		panel.setBounds(0, 0, 400, 80);
		painel.add(panel);
		panel.setLayout(null);

		JButton btnClose = new JButton("");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnClose.setBackground(new Color(255, 28, 25));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnClose.setBackground(new Color(114, 144, 255));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		btnClose.setIcon(new ImageIcon(TelaInicial.class.getResource("/imgs/close.png")));
		btnClose.setForeground(new Color(114, 144, 255));
		btnClose.setBorder(null);
		btnClose.setBackground(new Color(114, 144, 255));
		btnClose.setBounds(353, 11, 37, 37);
		panel.add(btnClose);
		
		JButton btnDow = new JButton("");
		
		btnDow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDow.setBackground(new Color(148, 171, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnDow.setBackground(new Color(114, 144, 255));
			}

			public void mouseClicked(MouseEvent e) {
				Component component = (Component) e.getSource();
				JFrame frame = (JFrame) SwingUtilities.getRoot(component);
				frame.setState(JFrame.ICONIFIED);
			}
		});
		
		btnDow.setIcon(new ImageIcon(TelaInicial.class.getResource("/imgs/dow.png")));
		btnDow.setForeground(new Color(114, 144, 255));
		btnDow.setBorder(null);
		btnDow.setBackground(new Color(114, 144, 255));
		btnDow.setBounds(306, 11, 37, 37);
		panel.add(btnDow);
		
		
		// Adiciona um WindowListener ao frame
		frame.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        // Fecha a janela atual
		        frame.dispose();
		    }
		});
		
		JLabel lblNomePrograma = new JLabel("ConvertPro");
		lblNomePrograma.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomePrograma.setForeground(new Color(102, 51, 153));
		lblNomePrograma.setFont(new Font("Candara Light", Font.BOLD, 30));
		lblNomePrograma.setBounds(107, 20, 177, 28);
		panel.add(lblNomePrograma);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaInicial.class.getResource("/imgs/logoIni.png")));
		lblNewLabel.setBounds(10, 11, 45, 45);
		panel.add(lblNewLabel);
		this.setVisible(true);

	}
}
