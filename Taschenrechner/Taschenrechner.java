import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Taschenrechner extends JFrame implements ActionListener {

    double num1, num2, sum;
    String sumString = "", operatorString = "", inputString1 = "", inputString2 = "";
    boolean changeinputString = false, inputtingcurrentNumbers = true;

    JButton number0Button, number1Button, number2Button, number3Button, number4Button,
            number5Button, number6Button, number7Button, number8Button, number9Button;
    JButton addButton, subtractButton, multiplyButton, divideButton, clearButton, equalsButton; // dotButton

    JPanel numpadPanel;

    JTextField currentNumbersField, sumField;
    Box outputBox, outputBoxleft, outputBoxright;

    // Konstruktor
    public Taschenrechner() {
        setTitle("Taschenrechner");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // number
        number0Button = new JButton("0");
        number0Button.addActionListener(this);
        number0Button.setActionCommand("0");
        number1Button = new JButton("1");
        number1Button.addActionListener(this);
        number1Button.setActionCommand("1");
        number2Button = new JButton("2");
        number2Button.addActionListener(this);
        number2Button.setActionCommand("2");
        number3Button = new JButton("3");
        number3Button.addActionListener(this);
        number3Button.setActionCommand("3");
        number4Button = new JButton("4");
        number4Button.addActionListener(this);
        number4Button.setActionCommand("4");
        number5Button = new JButton("5");
        number5Button.addActionListener(this);
        number5Button.setActionCommand("5");
        number6Button = new JButton("6");
        number6Button.addActionListener(this);
        number6Button.setActionCommand("6");
        number7Button = new JButton("7");
        number7Button.addActionListener(this);
        number7Button.setActionCommand("7");
        number8Button = new JButton("8");
        number8Button.addActionListener(this);
        number8Button.setActionCommand("8");
        number9Button = new JButton("9");
        number9Button.addActionListener(this);
        number9Button.setActionCommand("9");

        // operators
        addButton = new JButton("+");
        addButton.addActionListener(this);
        addButton.setActionCommand("+");
        subtractButton = new JButton("-");
        subtractButton.addActionListener(this);
        subtractButton.setActionCommand("-");
        multiplyButton = new JButton("*");
        multiplyButton.addActionListener(this);
        multiplyButton.setActionCommand("*");
        divideButton = new JButton("/");
        divideButton.addActionListener(this);
        divideButton.setActionCommand("/");
        clearButton = new JButton("C");
        clearButton.addActionListener(this);
        clearButton.setActionCommand("C");
        // dotButton = new JButton(".");
        // dotButton.addActionListener(this);
        // dotButton.setActionCommand(".");
        equalsButton = new JButton("=");
        equalsButton.addActionListener(this);
        equalsButton.setActionCommand("=");

        // numpad-Panel
        numpadPanel = new JPanel();
        numpadPanel.setLayout(new GridLayout(4, 4));

        numpadPanel.add(number7Button);
        numpadPanel.add(number8Button);
        numpadPanel.add(number9Button);
        numpadPanel.add(divideButton);
        numpadPanel.add(number4Button);
        numpadPanel.add(number5Button);
        numpadPanel.add(number6Button);
        numpadPanel.add(multiplyButton);
        numpadPanel.add(number1Button);
        numpadPanel.add(number2Button);
        numpadPanel.add(number3Button);
        numpadPanel.add(subtractButton);
        numpadPanel.add(clearButton);
        numpadPanel.add(number0Button);
        numpadPanel.add(equalsButton);
        numpadPanel.add(addButton);
        // numpadPanel.add(dotButton);

        // output-Box
        currentNumbersField = new JTextField(30);
        currentNumbersField.setEditable(false);
        sumField = new JTextField(30);
        sumField.setEditable(false);

        outputBoxleft = new Box(BoxLayout.Y_AXIS);
        outputBoxleft.add(Box.createRigidArea(new Dimension(1, 16)));
        outputBoxleft.add(currentNumbersField);
        outputBoxleft.add(Box.createRigidArea(new Dimension(1, 16)));

        outputBoxright = new Box(BoxLayout.Y_AXIS);
        outputBoxright.add(new JLabel("Sum:"));
        outputBoxright.add(sumField);
        outputBoxleft.add(Box.createRigidArea(new Dimension(1, 16)));

        outputBox = new Box(BoxLayout.X_AXIS);
        outputBox.add(outputBoxleft);
        outputBox.add(Box.createRigidArea(new Dimension(10, 1)));
        outputBox.add(outputBoxright);

        // Frame
        add(outputBox, BorderLayout.NORTH);
        add(numpadPanel, BorderLayout.CENTER);

    }

    // Mthods
    public void clear_method() {
        inputString1 = "";
        inputString2 = "";
        operatorString = "";
        sumString = "";

        changeinputString = false;
        inputtingcurrentNumbers = true;
    }

    public void equals_method() {
        inputtingcurrentNumbers = false;
        num1 = Double.parseDouble(inputString1);
        num2 = Double.parseDouble(inputString2);

        if (operatorString.equals("/")) {
            sum = num1 / num2;
        }
        if (operatorString.equals("*")) {
            sum = num1 * num2;
        }
        if (operatorString.equals("-")) {
            sum = num1 - num2;
        }
        if (operatorString.equals("+")) {
            sum = num1 + num2;
        }

        sumString = sum + "";
    }

    public void dooperatorString(ActionEvent e) {

        if (e.getActionCommand().equals("/")) {
            changeinputString = true;
            operatorString = "/";
        }
        if (e.getActionCommand().equals("*")) {
            changeinputString = true;
            operatorString = "*";
        }
        if (e.getActionCommand().equals("-")) {
            changeinputString = true;
            operatorString = "-";
        }
        if (e.getActionCommand().equals("+")) {
            changeinputString = true;
            operatorString = "+";
        }
    }

    public void doinputString1(ActionEvent e) {

        if (e.getActionCommand().equals("0")) {
            inputString1 += "0";
        }
        if (e.getActionCommand().equals("1")) {
            inputString1 += "1";
        }
        if (e.getActionCommand().equals("2")) {
            inputString1 += "2";
        }
        if (e.getActionCommand().equals("3")) {
            inputString1 += "3";
        }
        if (e.getActionCommand().equals("4")) {
            inputString1 += "4";
        }
        if (e.getActionCommand().equals("5")) {
            inputString1 += "5";
        }
        if (e.getActionCommand().equals("6")) {
            inputString1 += "6";
        }
        if (e.getActionCommand().equals("7")) {
            inputString1 += "7";
        }
        if (e.getActionCommand().equals("8")) {
            inputString1 += "8";
        }
        if (e.getActionCommand().equals("9")) {
            inputString1 += "9";
        }
    }

    public void doinputString2(ActionEvent e) {
        if (e.getActionCommand().equals("0")) {
            inputString2 += "0";
        }
        if (e.getActionCommand().equals("1")) {
            inputString2 += "1";
        }
        if (e.getActionCommand().equals("2")) {
            inputString2 += "2";
        }
        if (e.getActionCommand().equals("3")) {
            inputString2 += "3";
        }
        if (e.getActionCommand().equals("4")) {
            inputString2 += "4";
        }
        if (e.getActionCommand().equals("5")) {
            inputString2 += "5";
        }
        if (e.getActionCommand().equals("6")) {
            inputString2 += "6";
        }
        if (e.getActionCommand().equals("7")) {
            inputString2 += "7";
        }
        if (e.getActionCommand().equals("8")) {
            inputString2 += "8";
        }
        if (e.getActionCommand().equals("9")) {
            inputString2 += "9";
        }
    }

    // Programm ablauf
    public void actionPerformed(ActionEvent e) {

        // Clear
        if (e.getActionCommand().equals("C")) {
            clear_method();
        }

        // equals
        if (!inputString1.isBlank() && !inputString2.isBlank() && !operatorString.isBlank()) {
            if (e.getActionCommand().equals("=")) {
                equals_method();
            }
        }

        if (inputtingcurrentNumbers = true) {
            // operator-Strings
            dooperatorString(e);

            // input-Strings
            if (changeinputString == false) {
                doinputString1(e);
            } else if (changeinputString == true) {
                doinputString2(e);
            }
        }

        currentNumbersField.setText(inputString1 + " " + operatorString + " " + inputString2);
        sumField.setText(sumString);
        repaint();
    }

    public static void main(String[] args) {
        Taschenrechner App = new Taschenrechner();
        App.setSize(500, 500);
        App.setVisible(true);
    }
}
