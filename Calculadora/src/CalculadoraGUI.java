import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// aca estan los botones y campos de texto
public class CalculadoraGUI extends JFrame {
    private JTextField campo1;
    private JTextField campo2;
    private JButton botonsum;
    private JButton botonres;
    private JButton botonpro;
    private JButton botondiv;
    private JLabel resultado;

    //este es el constructor de la ventana  modifica el titulo,tamaño,que pasa alcerrarla,centrarla en la pantalla
    public CalculadoraGUI() {
        setTitle(" !! CALCULADORA !! ");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //aca se crean los componentes de los botones y campos de texto
        campo1 = new JTextField(10);
        campo2 = new JTextField(10);
        botondiv = new JButton("Division");
        botonpro = new JButton("Producto");
        botonres = new JButton("Resta");
        botonsum = new JButton("Sumar");
        resultado = new JLabel("Resultado");

        //Se crea un panel y agregan los componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 5, 5));
        panel.add(new JLabel("numero 1: "));
        panel.add(campo1);
        panel.add(new JLabel("numero 2: "));
        panel.add(campo2);
        panel.add(botonsum);
        panel.add(botonres);
        panel.add(botondiv);
        panel.add(botonpro);
        panel.add(resultado);
        add(panel); //se agrega todos los add al objeto de panel

        //Aca se programan todos los botones q agregamos

        botonsum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizaOperacion("+");
            }
        });

        botonres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizaOperacion("-");
            }
        });

        botondiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizaOperacion("/");
            }
        });

        botonpro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizaOperacion("*");
            }
        });
    }

    //aca armamos los metedos para las operaciones

    private void realizaOperacion(String operacion) {
        try {
            double num1 = Double.parseDouble(campo1.getText());
            double num2 = Double.parseDouble(campo2.getText());
            double resultados = switch (operacion) {
                case "+" -> num1 + num2;
                case "-" -> num1 - num2;
                case "/" -> num1 / num2;
                default -> num1 * num2;
            };
            resultado.setText("Resultado: "+ resultados);
        }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,"ingrese numeros validos","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    //aca esta el metodo que incia todoo
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            new CalculadoraGUI().setVisible(true);
        });
    }
}
