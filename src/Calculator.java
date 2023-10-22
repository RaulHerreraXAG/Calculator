import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import javax.swing.UIManager;

/**
 * Esta es la clase Calculator que implementa una calculadora simple.
 */

public class Calculator {

    private double total1 = 0.0;
    private double total2 = 0.0;
    private boolean calculadoraEncendida = true;

    private char operaciones;
    private JPanel Calculadora;
    private JTextField Display;
    private JButton ACButton;
    private JButton suma;
    private JButton resta;
    private JButton multi;
    private JButton division;
    private JButton a7Button;
    private JButton a4Button;
    private JButton a3Button;
    private JButton a0Button1;
    private JButton ONButton;
    private JButton a8Button;
    private JButton a5Button;
    private JButton a2Button;
    private JButton coma;
    private JButton a9Button;
    private JButton a6Button;
    private JButton a1Button;
    private JButton igual;
    private JButton Back;
    private JButton Raiz;


    /**
     * Obtiene la operación seleccionada por el usuario.
     *
     * @param btntxt Texto del botón de operación (+, -, *, /)
     */

    public void getOperacion (String btntxt){
        operaciones = btntxt.charAt(0);
        total1 = total1 + Double.parseDouble(Display.getText());
        Display.setText("");
    }


    /**
     * Constructor de la calculadora.
     */


    public Calculator() {

        // Inicialización de los ActionListener y configuración de botones

        /**
         * ActionListener para el botón AC (Clear).
         * Reinicia el valor total y limpia el Display.
         */

        ACButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                total2 = 0;
                Display.setText("");
            }
        });

        /**
         * ActionListener para los botones numéricos (1 al 9).
         * Concatena el número presionado al texto actual en el Display.
         */

        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n1 = Display.getText() + a1Button.getText();
                Display.setText(n1);
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n2 = Display.getText() + a2Button.getText();
                Display.setText(n2);
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n3 = Display.getText() + a3Button.getText();
                Display.setText(n3);
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n6 = Display.getText() + a6Button.getText();
                Display.setText(n6);
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n5 = Display.getText() + a5Button.getText();
                Display.setText(n5);
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n4 = Display.getText() + a4Button.getText();
                Display.setText(n4);
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n9 = Display.getText() + a9Button.getText();
                Display.setText(n9);
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n8 = Display.getText() + a8Button.getText();
                Display.setText(n8);
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n7 = Display.getText() + a7Button.getText();
                Display.setText(n7);
            }
        });
        a0Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n0 = Display.getText() + a0Button1.getText();
                Display.setText(n0);
            }
        });

        /**
         * ActionListener para el botón coma (punto decimal).
         * Si el Display está vacío, agrega un "0.".
         * Si el Display ya contiene un punto decimal, deshabilita el botón.
         * En caso contrario, agrega un punto decimal al texto actual en el Display.
         * Luego, habilita nuevamente el botón coma.
         */

        coma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Display.getText().equals("")){
                    Display.setText("0.");
                } else if (Display.getText().contains(".")) {
                    coma.setEnabled(false);
                }else{
                    String btncoma = Display.getText() + coma.getText();
                    Display.setText(btncoma);
                }
                coma.setEnabled(true);
            }
        });

        /**
         * ActionListener para el botón igual (=).
         * Realiza la operación seleccionada (suma, resta, multiplicación o división)
         * entre total1 y el número actual en el Display.
         * Luego, muestra el resultado en el Display y reinicia total1.
         */

        igual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            switch (operaciones){
                case '+':
                    total2 = total1 + Double.parseDouble(Display.getText());
                    break;
                case '-':
                    total2 = total1 - Double.parseDouble(Display.getText());
                    break;
                case '/':
                    total2 = total1 / Double.parseDouble(Display.getText());
                    break;
                case 'x':
                    total2 = total1 * Double.parseDouble(Display.getText());
                    break;
            }
            Display.setText(Double.toString(total2));
            total1 = 0;
            }
        });
        Display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        /**
         * ActionListener para el botón ON/OFF.
         * Cambia el estado de encendido/apagado de la calculadora y actualiza la interfaz.
         */

        ONButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculadoraEncendida = !calculadoraEncendida;
                actualizarInterfaz();
            }
        });

        /**
         * ActionListener para el botón de división (/).
         * Obtiene la operación de división y realiza el cálculo correspondiente.
         */

        division.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtbtn = division.getText();
                getOperacion(txtbtn);
            }
        });

        /**
         * ActionListener para el botón de multiplicación (*).
         * Obtiene la operación de multiplicación y realiza el cálculo correspondiente.
         */

        multi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtbtn = multi.getText();
                getOperacion(txtbtn);
            }
        });

        /**
         * ActionListener para el botón de resta (-).
         * Obtiene la operación de resta y realiza el cálculo correspondiente.
         */

        resta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtbtn = resta.getText();
                getOperacion(txtbtn);
            }
        });


        /**
         * ActionListener para el botón de suma (+).
         * Obtiene la operación de suma y realiza el cálculo correspondiente.
         */

        suma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtbtn = suma.getText();
                getOperacion(txtbtn);

            }
        });
        /**
         * ActionListener para el botón de raíz cuadrada (√x).
         * Calcula la raíz cuadrada del número actual en el Display.
         */
        Raiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double numero = Double.parseDouble(Display.getText());
                double resultadoRaiz = Math.sqrt(numero);
                Display.setText(String.valueOf(resultadoRaiz));
            }
        });

        /**
         * ActionListener para el botón de retroceso (Back).
         * Elimina el último carácter del texto actual en el Display.
         */

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoActual = Display.getText();
                if (!textoActual.isEmpty()) {
                    String nuevoTexto = textoActual.substring(0, textoActual.length() - 1);
                    Display.setText(nuevoTexto);
                }
            }
        });
    }

    /**
     * Actualiza la interfaz de la calculadora según el estado de encendido/apagado.
     */
    private void actualizarInterfaz() {
        boolean habilitar = calculadoraEncendida;

        // Habilita/deshabilita los botones según el estado de la calculadora

        ACButton.setEnabled(habilitar);
        suma.setEnabled(habilitar);
        resta.setEnabled(habilitar);
        multi.setEnabled(habilitar);
        division.setEnabled(habilitar);
        a7Button.setEnabled(habilitar);
        a4Button.setEnabled(habilitar);
        a3Button.setEnabled(habilitar);
        a0Button1.setEnabled(habilitar);
        a8Button.setEnabled(habilitar);
        a5Button.setEnabled(habilitar);
        a2Button.setEnabled(habilitar);
        coma.setEnabled(habilitar);
        a9Button.setEnabled(habilitar);
        a6Button.setEnabled(habilitar);
        a1Button.setEnabled(habilitar);
        igual.setEnabled(habilitar);
        Back.setEnabled(habilitar);
        Raiz.setEnabled(habilitar);

        // Deshabilitar el botón ONButton y cambiar su texto a "Off"
        ONButton.setText(habilitar ? "On" : "Off");

        // Cambiar el color del botón ONButton a rojo cuando está deshabilitado
        if (!habilitar) {
            ONButton.setBackground(Color.RED);
        } else {
            ONButton.setBackground(Color.GREEN);
        }

       // Limpiar el Display cuando se apaga la calculadora
        Display.setText("");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().Calculadora);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,600 );
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
