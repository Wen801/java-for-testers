package com.serenitydojo.calculator;



import com.google.common.base.Splitter;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class Calculator {


    public double evaluate(String expression) {
        if (expression.isEmpty()) {
            return 0;
        }

        List<String> inputs = Splitter.on(" ").splitToList(expression);

        double result = 0;
        String operator = "+";

        for(String input :inputs){
         //   System.out.println("input is "+ input);
            if (!isNumeric(input)){
                operator= input;
            }
            else {
                result = process(result, operator, input);
            }
        }

        return result;
    }

    private double process(double result, String operator, String input) {
        switch (operator){
            case "+":
                //System.out.println(input);
                return result+Integer.parseInt(input);
            case "-":
              //  System.out.println(input);
                return result-Integer.parseInt(input);
            case "*":
                return result*Integer.parseInt(input);
            case "/":
                if (Integer.parseInt(input) == 0){
                    throw new IllegalMathsOperationException("0 cannot be divided");
                }else
                return result/(Integer.parseInt(input));
            default:
                throw new IllegalMathsOperationException("Operator " + operator+ " is invalid");
        }
    }


}




