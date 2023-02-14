import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EANcheck extends JFrame implements ActionListener {

    // EAN Code decoder
    JTextField inputOutputEANcode;
    JPanel EANchecker;

    // check-nummer-berechnung
    JTextField inputUncompleteEAN, outputCompleteEAN;
    JPanel checknumbercalc;

    // Gui
    public EANcheck() {
        setTitle("EAN Codierungs Job");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // EAN Code checker
        inputOutputEANcode = new JTextField(13);
        inputOutputEANcode.addActionListener(this);
        inputOutputEANcode.setActionCommand("input");

        EANchecker = new JPanel();
        EANchecker.add(new JLabel("Your EAN-Code:"));
        EANchecker.add(inputOutputEANcode);

        // check-nummer-berechner
        inputUncompleteEAN = new JTextField(13);
        inputUncompleteEAN.addActionListener(this);
        inputUncompleteEAN.setActionCommand("inputUncomplete");
        outputCompleteEAN = new JTextField(13);
        outputCompleteEAN.setEditable(false);

        checknumbercalc = new JPanel();
        checknumbercalc.add(new JLabel("Your unfinished EAN-Code"));
        checknumbercalc.add(inputUncompleteEAN);
        checknumbercalc.add(new JLabel("Your EAN-Code with check-number:"));
        checknumbercalc.add(outputCompleteEAN);

        // Frame
        add(EANchecker, BorderLayout.NORTH);
        add(checknumbercalc, BorderLayout.CENTER);
    }

    private int sumWhithoutCheckNumber(String strin) {

        int sumWhithoutCheckNumber = 0;
        String str = strin;
        int codeLength = str.length();
        char[] EANnumbers = new char[codeLength];

        if (strin.equals(inputUncompleteEAN.getText()))
            str += "0";

        for (int i = 0; i < codeLength; i++)
            EANnumbers[codeLength - 1 - i] = str.charAt(i);

        for (int i = 0; i < codeLength; i++) {
            if (i % 2 == 0)
                sumWhithoutCheckNumber += Character.getNumericValue(EANnumbers[i]) * 1;
            else
                sumWhithoutCheckNumber += Character.getNumericValue(EANnumbers[i]) * 3;
        }
        return sumWhithoutCheckNumber;
    }

    // checking the EAN code
    public void EANcodecheck() {
        int checkNumber;
        boolean error = false;
        String str = inputOutputEANcode.getText();

        try {
            Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            inputOutputEANcode.setText("Nur Zahlen");
            error = true;
        }

        if (error == false) {
            // checknumber
            checkNumber = Character.getNumericValue(str.charAt(str.length() - 1));

            // check if EAN-Code correct
            if (((sumWhithoutCheckNumber(inputOutputEANcode.getText())
                    - Character.getNumericValue(str.charAt(str.length() - 1))) + checkNumber) % 10 == 0)
                inputOutputEANcode.setText("The Code is correct!");
            else
                inputOutputEANcode.setText("The Code is false!");
        }
    }

    // calculating the check number
    private void checkNumbercalculator() {
        int checkNumber;
        boolean error = false;

        try {
            Integer.parseInt(inputUncompleteEAN.getText());
        } catch (NumberFormatException ex) {
            inputUncompleteEAN.setText("Nur Zahlen");
            error = true;
        }

        if (error == false) {
            checkNumber = 10 - (sumWhithoutCheckNumber(inputUncompleteEAN.getText()) % 10);

            outputCompleteEAN.setText(inputUncompleteEAN.getText() + checkNumber);
            inputUncompleteEAN.setText("");
        }
    }

    // control
    public void actionPerformed(ActionEvent e) {

        // EAN Code checker
        if (e.getActionCommand().equals("input"))
            EANcodecheck();

        if (e.getActionCommand().equals("inputUncomplete"))
            checkNumbercalculator();
    }

    public static void main(String[] args) {
        EANcheck App = new EANcheck();
        App.setVisible(true);
        App.setSize(500, 500);
    }
}