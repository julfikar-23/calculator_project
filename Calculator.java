package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[20];
    JButton addButton, subButton, mulButton, divButton, decimalButton, equalButton, deleteButton, clearButton, negativeButton;
    JButton sinB, cosB, tanB, lnB, logB, percentB, expB, factorialB, openB, closeB, valueOfeB;
    JPanel panel;
    Font myFont = new Font("Lato Italic", Font.ITALIC, 16);

    Calculator() {
        frame = new JFrame("JULFIKAR's CALCULATOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(365, 490);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(15, 15, 320, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decimalButton = new JButton(".");
        equalButton = new JButton("=");
        deleteButton = new JButton("Del");
        clearButton = new JButton("AC");
        negativeButton = new JButton("(-)");
        sinB = new JButton("sin");
        cosB = new JButton("cos");
        tanB = new JButton("tan");
        lnB = new JButton("ln");
        logB = new JButton("log");
        factorialB = new JButton("x!");
        openB = new JButton("(");
        closeB = new JButton(")");
        percentB = new JButton("%");
        expB = new JButton("^");
        valueOfeB = new JButton("e");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = clearButton;
        functionButtons[8] = negativeButton;
        functionButtons[9] = sinB;
        functionButtons[10] = cosB;
        functionButtons[11] = tanB;
        functionButtons[12] = lnB;
        functionButtons[13] = logB;
        functionButtons[14] = factorialB;
        functionButtons[15] = openB;
        functionButtons[16] = closeB;
        functionButtons[17] = percentB;
        functionButtons[18] = expB;
        functionButtons[19] = valueOfeB;

        for (int i = 0; i < 20; ++i) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; ++i) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        panel = new JPanel();
        panel.setBounds(15, 75, 320, 365);
        panel.setLayout(new GridLayout(6, 5, 5, 5));
        panel.setBackground(Color.cyan);
        panel.add(clearButton);
        panel.add(deleteButton);
        panel.add(negativeButton);
        panel.add(percentB);
        panel.add(expB);
        panel.add(sinB);
        panel.add(factorialB);
        panel.add(openB);
        panel.add(closeB);
        panel.add(divButton);
        panel.add(cosB);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(tanB);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(lnB);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(logB);
        panel.add(valueOfeB);
        panel.add(numberButtons[0]);
        panel.add(decimalButton);
        panel.add(equalButton);

        frame.add(panel);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; ++i) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decimalButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            textField.setText(textField.getText().concat(" + "));
        }
        if (e.getSource() == subButton) {
            textField.setText(textField.getText().concat(" - "));
        }
        if (e.getSource() == mulButton) {
            textField.setText(textField.getText().concat(" * "));
        }
        if (e.getSource() == divButton) {
            textField.setText(textField.getText().concat(" / "));
        }
        if (e.getSource() == sinB) {
            textField.setText(textField.getText().concat("sin("));
        }
        if (e.getSource() == cosB) {
            textField.setText(textField.getText().concat("cos("));
        }
        if (e.getSource() == tanB) {
            textField.setText(textField.getText().concat("tan("));
        }
        if (e.getSource() == lnB) {
            textField.setText(textField.getText().concat("ln("));
        }
        if (e.getSource() == logB) {
            textField.setText(textField.getText().concat("log("));
        }
        if (e.getSource() == factorialB) {
            int temp = Integer.parseInt(textField.getText());
            textField.setText(String.valueOf(factorial(temp)));
        }
        if (e.getSource() == expB) {
            textField.setText(textField.getText().concat(" ^ "));
        }
        if (e.getSource() == percentB) {
            double temp = Double.parseDouble(textField.getText());
            temp = temp / 100;
            textField.setText(String.valueOf(temp));
        }
        if (e.getSource() == valueOfeB) {
            textField.setText(textField.getText().concat(String.valueOf(Math.E)));
        }
        if (e.getSource() == openB) {
            textField.setText(textField.getText().concat("("));
        }
        if (e.getSource() == closeB) {
            textField.setText(textField.getText().concat(")"));
        }
        if (e.getSource() == equalButton) {
            String expression = textField.getText();
            try {
                double result = evaluateExpression(expression);
                textField.setText(String.valueOf(result));
            } catch (Exception ex) {
                textField.setText("Error");
            }
        }
        if (e.getSource() == clearButton) {
            textField.setText("");
        }
        if (e.getSource() == deleteButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; ++i) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        if(e.getSource()==negativeButton){
            double temp=Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }

    }

    private double evaluateExpression(String expression) {
        String postfix = infixToPostfix(expression);
        return evaluatePostfix(postfix);
    }

    private String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();
        boolean lastWasOperator = true;

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                result.append(c);
                lastWasOperator = false;
            } else if (c == '(') {
                stack.push(String.valueOf(c));
                lastWasOperator = true;
            } else if (c == ')') {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    result.append(' ').append(stack.pop());
                }
                stack.pop();
                lastWasOperator = false;
            } else if (isOperator(c)) {
                result.append(' ');
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek().charAt(0))) {
                    result.append(stack.pop()).append(' ');
                }
                stack.push(String.valueOf(c));
                lastWasOperator = true;
            } else if (Character.isLetter(c)) {
                StringBuilder func = new StringBuilder();
                while (i < expression.length() && Character.isLetter(expression.charAt(i))) {
                    func.append(expression.charAt(i));
                    i++;
                }
                i--;
                stack.push(func.toString());
                lastWasOperator = true;
            }
        }
        while (!stack.isEmpty()) {
            result.append(' ').append(stack.pop());
        }
        return result.toString();
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c=='!';
    }

    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    private double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = postfix.split("\\s+");

        for (String token : tokens) {
            if (token.isEmpty()) continue;
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token.charAt(0)) && token.length() == 1) {
                double b = stack.pop();
                double a = stack.pop();
                switch (token.charAt(0)) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                    case '^':
                        stack.push(Math.pow(a, b));
                        break;
                    case '!':
                        stack.push((double) factorial((int) a));
                        break;
                }
            } else if (token.equals("sin")) {
                stack.push(Math.sin(Math.toRadians(stack.pop())));
            } else if (token.equals("cos")) {
                stack.push(Math.cos(Math.toRadians(stack.pop())));
            } else if (token.equals("tan")) {
                stack.push(Math.tan(Math.toRadians(stack.pop())));
            } else if (token.equals("ln")) {
                stack.push(Math.log(stack.pop()));
            } else if (token.equals("log")) {
                stack.push(Math.log10(stack.pop()));
            }
        }
        return stack.pop();
    }

    private int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
