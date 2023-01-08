import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField text;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton add, sub, mul, div, dec, equ, del, clr, neg;
    JPanel panel;

    Font myFont = new Font("aqua", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {

        frame = new JFrame("CALCULATOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(null);

        text = new JTextField();
        text.setBounds(25, 25, 420, 50);
        text.setFont(myFont);
        text.setEditable(false);

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        dec = new JButton(".");
        equ = new JButton("=");
        del = new JButton("DEL");
        clr = new JButton("CLR");
        neg = new JButton("(-)");

        functionButtons[0] = add;
        functionButtons[1] = sub;
        functionButtons[2] = mul;
        functionButtons[3] = div;
        functionButtons[4] = dec;
        functionButtons[5] = equ;
        functionButtons[6] = del;
        functionButtons[7] = clr;
        functionButtons[8] = neg;


        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        del.setBounds(60, 500, 100, 50);
        clr.setBounds(190, 500, 100, 50);
        neg.setBounds(320, 500, 100, 50);

        panel = new JPanel();
        panel.setBounds(33, 100, 400, 380);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(add);
        panel.add(sub);
        panel.add(mul);
        panel.add(div);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(equ);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(dec);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(numberButtons[0]);

        frame.add(text);
        frame.add(del);
        frame.add(clr);
        frame.add(neg);
        frame.add(panel);


        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                text.setText((text.getText().concat(String.valueOf(i))));
            }
        }
        if (e.getSource() == dec) {
            text.setText(text.getText().concat("."));
        }
        if (e.getSource() == add) {
            num1 = Double.parseDouble(text.getText());
            operator = '+';
            text.setText("");
        }
        if (e.getSource() == sub) {
            num1 = Double.parseDouble(text.getText());
            operator = '-';
            text.setText("");
        }
        if (e.getSource() == mul) {
            num1 = Double.parseDouble(text.getText());
            operator = '*';
            text.setText("");
        }
        if (e.getSource() == div) {
            num1 = Double.parseDouble(text.getText());
            operator = '/';
            text.setText("");
        }
        if (e.getSource() == equ) {
            num2 = Double.parseDouble(text.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if(num2 != 0)
                    result = num1 / num2;
                    else throw new RuntimeException("dont divide by 0");
                    break;
            }
            text.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clr) {
            text.setText("");
        }
        if (e.getSource() == del) {
            String string = text.getText();
            text.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                text.setText(text.getText() + string.charAt(i));
            }
        }
        if(e.getSource() == neg){
            double temp = Double.parseDouble(text.getText());
            temp *= -1;
            text.setText(String.valueOf(temp));
        }
    }
}
