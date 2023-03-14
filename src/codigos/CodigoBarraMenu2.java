package codigos;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class CodigoBarraMenu2 extends JPanel  {

	private int initialX, initialY;
	private Window[] frame;
	
	public CodigoBarraMenu2() {

		 addMouseListener(new MouseAdapter() {
	            @Override
	            public void mousePressed(MouseEvent e) {
	                // Salva a posição inicial do rato!
	                initialX = e.getX();
	                initialY = e.getY();
			Frame window = (JFrame) SwingUtilities.getWindowAncestor(CodigoBarraMenu2.this);
 			Point windowPosition = window.getLocationOnScreen();
	            }
	        });
		 

	        addMouseMotionListener(new MouseAdapter() {
	            @Override
	            public void mouseDragged(MouseEvent e) {
	                // calcule a nova posição do painel com base no movimento do mouse
	                int deltaX = e.getX() - initialX;
	                int deltaY = e.getY() - initialY;
			JFrame window = (JFrame) SwingUtilities.getWindowAncestor(CodigoBarraMenu2.this);
 			Point windowPosition = window.getLocationOnScreen();
			window.setLocation(windowPosition.x + deltaX, windowPosition.y + deltaY);	                

	            }
	        });
	    
		setBackground(new Color(114, 144, 255));
		setSize(new Dimension(400, 80));
		
		JButton btnClose = new JButton("");
		btnClose.setBounds(353, 11, 37, 37);
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnClose.setBackground(new Color(148, 171, 255));
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
		setLayout(null);
		btnClose.setIcon(new ImageIcon(CodigoBarraMenu2.class.getResource("/imgs/close.png")));
		btnClose.setForeground(new Color(114, 144, 255));
		btnClose.setBackground(new Color(114, 144, 255));
		btnClose.setBorder(null);
		this.add(btnClose);

		JButton btnDow = new JButton("");
		btnDow.setBounds(306, 11, 37, 37);
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
		btnDow.setForeground(new Color(114, 144, 255));
		btnDow.setBackground(new Color(114, 144, 255));
		btnDow.setBorder(null);
		btnDow.setIcon(new ImageIcon(CodigoBarraMenu2.class.getResource("/imgs/dow.png")));
		this.add(btnDow);

		JLabel lblNomePrograma = new JLabel("ConvertPro");
		lblNomePrograma.setBounds(75, 20, 177, 28);
		lblNomePrograma.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomePrograma.setForeground(new Color(102, 51, 153));
		lblNomePrograma.setFont(new Font("Candara Light", Font.BOLD, 30));
		add(lblNomePrograma);

		
    }
}
	
