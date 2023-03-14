package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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

import codigos.BotaoHome;
import codigos.CodigoBarraMenu;
import javax.swing.SwingConstants;

public class TelaConvertFile extends JFrame {

    private JPanel contentPane;
    private JTextField textResultado;
    private JTextField textResult;
    private JTextField textValorDigitado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaConvertFile frame = new TelaConvertFile();
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
            // Fator de conversão para bits
            final double BITS = 8.0;

            // Tabela de conversão de unidades para bits
            double[] fatores = {1.0, BITS, Math.pow(1024, 1), Math.pow(1024, 2), Math.pow(1024, 3), Math.pow(1024, 4)};

            // Índice da unidade de medida de origem e destino
            int deIndex = getIndex(de);
            int paraIndex = getIndex(para);

            // Converter para bits
            double tamanhoEmBits = tamanho * fatores[deIndex];

            // Converter para unidade de destino
            double tamanhoConvertido = tamanhoEmBits / fatores[paraIndex];

            return tamanhoConvertido;
        }

        // Método para obter o índice da unidade de medida
        private int getIndex(String unidade) {
            switch (unidade) {
                case "Bit":
                    return 0;
                case "Byte":
                    return 1;
                case "Kilobyte":
                    return 2;
                case "Megabyte":
                    return 3;
                case "Gigabyte":
                    return 4;
                case "Terabyte":
                    return 5;
                default:
                    return -1;
            }
        }
    }

    public TelaConvertFile() {
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
        lblLogoPrograma.setIcon(new ImageIcon(TelaConvertFile.class.getResource("/imgs/file-45x45.png")));
        lblLogoPrograma.setBackground(new Color(114, 144, 255));
        lblLogoPrograma.setBounds(10, 11, 45, 45);
        painel.add(lblLogoPrograma);

        // Adicionar comboboxes de seleção de unidades
        JComboBox fileFrom = new JComboBox();
        fileFrom.addItem("Bit");
        fileFrom.addItem("Byte");
        fileFrom.addItem("Kilobyte");
        fileFrom.addItem("Megabyte");
        fileFrom.addItem("Gigabyte");
        fileFrom.addItem("Terabyte");
        fileFrom.setBackground(new Color(114, 144, 255));
        fileFrom.setBounds(10, 389, 159, 29);
        contentPane.add(fileFrom);
        
        JComboBox fileTo = new JComboBox();
        fileTo.addItem("Bit");
        fileTo.addItem("Byte");
        fileTo.addItem("Kilobyte");
        fileTo.addItem("Megabyte");
        fileTo.addItem("Gigabyte");
        fileTo.addItem("Terabyte");
        fileTo.setBackground(new Color(114, 144, 255));
        fileTo.setBounds(231, 389, 159, 29);
        contentPane.add(fileTo);
        
        
        JFormattedTextField textResult = new JFormattedTextField(new DecimalFormat("#.###"));
        textResult.setHorizontalAlignment(SwingConstants.CENTER);
        textResult.setBorder(null);
        textResult.setForeground(new Color(0, 0, 0));
        textResult.setEditable(false);
        textResult.setFont(new Font("Tahoma", Font.BOLD, 18));
        textResult.setBackground(new Color(114, 144, 255));
        textResult.setBounds(10, 146, 380, 179);
        contentPane.add(textResult);
        textResult.setColumns(10);
        
        textValorDigitado = new JTextField();
        textValorDigitado.setHorizontalAlignment(SwingConstants.CENTER);
        textValorDigitado.setFont(new Font("Tahoma", Font.BOLD, 12));
        textValorDigitado.setBackground(new Color(114, 144, 255));
        textValorDigitado.setBounds(88, 455, 214, 47);
        contentPane.add(textValorDigitado);
        textValorDigitado.setColumns(10);
        
        
        
        JButton btnConvert = new JButton("Convert");
        btnConvert.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String de = (String) fileFrom.getSelectedItem();
        	    String para = (String) fileTo.getSelectedItem();
        	    double tamanho = Double.parseDouble(textValorDigitado.getText());
        	    ConversorDeTamanho conversor = new ConversorDeTamanho();
        	    double tamanhoConvertido = conversor.converter(tamanho, de, para);
        	    textResult.setText(String.format("%.2f %s = %.2f %s", tamanho, de, tamanhoConvertido, para));
        	}
        });
        btnConvert.setBounds(139, 540, 89, 23);
        contentPane.add(btnConvert);
        
        
    }
}
       
