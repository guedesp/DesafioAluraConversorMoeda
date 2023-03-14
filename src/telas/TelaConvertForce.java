package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import codigos.BotaoHome;
import codigos.CodigoBarraMenu;

public class TelaConvertForce extends JFrame {

    private JPanel contentPane;
    private JTextField textResultado;
    private JTextField textResult;
    private JTextField textValorDigitadoI;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaConvertForce frame = new TelaConvertForce();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Classe para converter unidades de tamanho de arquivo
    public class ConversorDeTamanho {

        // Método para converter o tamanho de arquivo
        public double converter(double tamanho, String de, String para) {
            // Fator de conversão para newton
            final double tonelada = 10000.0;

            // Tabela de conversão de unidades para newton
            double[] fatores = {1.0, tonelada, Math.pow(10000, 1), Math.pow(10000, 2), Math.pow(100000, 3), Math.pow(10000, 4)};

            // Índice da unidade de medida de origem e destino
            int deIndex = getIndex(de);
            int paraIndex = getIndex(para);

            // Converter para bits
            double tamanhoEmBits = tamanho / fatores[deIndex];

            // Converter para unidade de destino
            double tamanhoConvertido = tamanhoEmBits * fatores[paraIndex];

            return tamanhoConvertido;
        }

        // Método para obter o índice da unidade de medida
        private int getIndex(String unidade) {
            switch (unidade) {
                case "Tonelada":
                    return 0;
                case "Newton":
                    return 1;
                default:
                    return -1;
            }
        }
    }

    public TelaConvertForce() {
        setUndecorated(true); // remove a barra superior com os botões fechar, minimizar e maximizar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(97, 94, 169));
        contentPane.setBorder(null);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Adicionar barra personalizada
        CodigoBarraMenu painel = new CodigoBarraMenu();
        getContentPane().add(painel);

        // Adicionar botão Home
        BotaoHome home1 = new BotaoHome(painel, this);
        JLabel lblLogoPrograma = new JLabel("");
        lblLogoPrograma.setIcon(new ImageIcon(TelaConvertForce.class.getResource("/imgs/civil-engineering-45x45.png")));
        lblLogoPrograma.setBackground(new Color(114, 144, 255));
        lblLogoPrograma.setBounds(10, 11, 45, 45);
        painel.add(lblLogoPrograma);

        // Adicionar comboboxes de seleção de unidades
       
        JComboBox fileFromI = new JComboBox();
        fileFromI.addItem("Tonelada");
        fileFromI.addItem("Newton");
        fileFromI.setBackground(new Color(114, 144, 255));
        fileFromI.setBounds(10, 389, 159, 29);
        contentPane.add(fileFromI);
        
        JComboBox fileToI = new JComboBox();
        fileToI.addItem("Tonelada");
        fileToI.addItem("Newton");
        fileToI.setBackground(new Color(114, 144, 255));
        fileToI.setBounds(231, 389, 159, 29);
        contentPane.add(fileToI);
        
        JFormattedTextField textResultI = new JFormattedTextField(new DecimalFormat("#.###"));
        textResultI.setHorizontalAlignment(SwingConstants.CENTER);
        textResultI.setBorder(null);
        textResultI.setForeground(new Color(0, 0, 0));
        textResultI.setEditable(false);
        textResultI.setFont(new Font("Tahoma", Font.BOLD, 18));
        textResultI.setBackground(new Color(114, 144, 255));
        textResultI.setBounds(10, 146, 380, 179);
        contentPane.add(textResultI);
        textResultI.setColumns(10);
        
        textValorDigitadoI = new JTextField();
        textValorDigitadoI.setHorizontalAlignment(SwingConstants.CENTER);
        textValorDigitadoI.setFont(new Font("Tahoma", Font.BOLD, 12));
        textValorDigitadoI.setBackground(new Color(114, 144, 255));
        textValorDigitadoI.setBounds(88, 455, 214, 47);
        contentPane.add(textValorDigitadoI);
        textValorDigitadoI.setColumns(10);
        
        JButton btnConvertI = new JButton("Convert");
        btnConvertI.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String de = (String) fileFromI.getSelectedItem();
        	    String para = (String) fileToI.getSelectedItem();
        	    double tamanho = Double.parseDouble(textValorDigitadoI.getText());
        	    ConversorDeTamanho conversor = new ConversorDeTamanho();
        	    double tamanhoConvertido = conversor.converter(tamanho, de, para);
        	    textResultI.setText(String.format("%.2f %s =\n                        %.5f %s", tamanho, de, tamanhoConvertido, para));
        	}
        });
        
        btnConvertI.setBounds(139, 540, 89, 23);
        contentPane.add(btnConvertI);
        
       
        
        
    }
}
       
