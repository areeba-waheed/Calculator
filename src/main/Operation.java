package main;

import javax.swing.JTextField;

/**
 *  Areeba Waheed
 *  SEP 17, 2018
 *  Comp 585: GUI
 *  Project 1: Calculator
 *
 **/

public class Operation {
    private String operand1, operator, operand2;
    private JTextField textField;

    public Operation() {
        operand1 = operator = operand2 ="";
        textField = new JTextField(11);
    }

    public void updateTextField(String s, JTextField textField) {
        this.textField = textField;
        operate(s);
    }

    public void operate(String s){
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') { //checks for digits
            if (!operator.equals(""))
                operand2 = operand2 + s;
            else
                operand1 = operand1 + s;

            textField.setText(operand1 + operator + operand2);
        } else if (s.charAt(0) == 'C') { //clears everything
            operand1 = operator = operand2 = "";
            textField.setText(operand1 + operator + operand2);
        } else if (s.charAt(0) == '=') { //solves
            double temp = storeValue();
            textField.setText(operand1 + operator + operand2 + "=" + temp);
            operand1 = Double.toString(temp);
            operator = operand2 = "";
        } else {
            if (operator.equals("") || operand2.equals(""))
                operator = s;
            else {
                double temp = storeValue();
                operand1 = Double.toString(temp);
                operator = s;
                operand2 = "";
            }
            textField.setText(operand1 + operator + operand2);
        }
    }

    //getter for Junit
    public String getOperand1(){return this.operand1;}

    //checks for operators
    private double storeValue() {
        double temp =0.0;
        if (operator.equals("+"))
            temp = (Double.parseDouble(operand1) + Double.parseDouble(operand2));
        else if (operator.equals("-"))
            temp = (Double.parseDouble(operand1) - Double.parseDouble(operand2));
        else if (operator.equals("/"))
            temp = (Double.parseDouble(operand1) / Double.parseDouble(operand2));
        else if (operator.equals("*"))
            temp = (Double.parseDouble(operand1) * Double.parseDouble(operand2));
        else if(operator.equals("%"))
            temp = (Double.parseDouble(operand1) % Double.parseDouble(operand2));

        return temp;
    }
}
