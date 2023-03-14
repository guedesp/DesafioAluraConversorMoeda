package codigos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class CodigoOpcao extends JButton {

	 	private JPanel painel;
	    private JFrame frame;
	    
	public CodigoOpcao (JPanel painel, JFrame frame) {
		
		this.painel = painel;
	    this.frame = frame;
		setRequestFocusEnabled(false);
		setLayout(null);
		
		JButton btnMenu = new JButton("");
		btnMenu.setBorder(null);
		btnMenu.setBackground(new Color(114, 144, 255));
		btnMenu.setIcon(new ImageIcon(CodigoBarraMenu.class.getResource("/imgs/setting-2.png")));
		add(btnMenu);
		btnMenu.setBounds(10, 11, 45, 45);
		btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPopupMenu popupMenu = new JPopupMenu();

                // submenu Idiomas
                JMenu menuIdiomas = new JMenu("Idiomas");

                JMenuItem itemPortugues = new JMenuItem("Português");
                itemPortugues.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // lógica para mudar o idioma para português
                        System.out.println("Idioma Português");
                    }
                });
                menuIdiomas.add(itemPortugues);

                JMenuItem itemIngles = new JMenuItem("Inglês");
                itemIngles.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // lógica para mudar o idioma para inglês
                        System.out.println("Idioma Inglês");
                    }
                });
                menuIdiomas.add(itemIngles);

                popupMenu.add(menuIdiomas);

                // submenu Themes
                JMenu menuThemes = new JMenu("Themes");

                
                JMenuItem itemDark = new JMenuItem("Dark");
                menuThemes.add(itemDark);

                JMenuItem itemLight = new JMenuItem("Light");
                itemLight.addActionListener(new ActionListener() {
                    
                    public void actionPerformed(ActionEvent e) {
                        // lógica para mudar para o tema light
                        System.out.println("Tema Light");
                    }
                });
                menuThemes.add(itemLight);

                popupMenu.add(menuThemes);

                // exibe o popup menu
                popupMenu.show(btnMenu, 0, btnMenu.getHeight());
            }
        });

         add(btnMenu);
    }	
		

}


