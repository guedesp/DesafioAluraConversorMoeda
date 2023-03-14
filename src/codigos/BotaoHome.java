package codigos;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import telas.TelaInicial;

public class BotaoHome extends JButton {

    private JPanel painel;
    private JFrame frame;

    public BotaoHome(JPanel painel, JFrame frame) {
        this.painel = painel;
        this.frame = frame;
        setBounds(259, 11, 37, 37);
        setForeground(new Color(114, 144, 255));
        setBackground(new Color(114, 144, 255));
        setIcon(new ImageIcon(TelaInicial.class.getResource("/imgs/home.png")));
        painel.add(this);
        setVisible(true);
        setBorder(null);

        this.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(148, 171, 255));
            }

            public void mouseExited(MouseEvent e) {
                setBackground(new Color(114, 144, 255));
            }

            public void mouseClicked(MouseEvent e) {
                frame.dispose(); // fecha a janela atual
                TelaInicial telaInicial = new TelaInicial();
                telaInicial.setVisible(true);
            }
        });
    }
}

