package com.epam.lab.android.BO;

import com.epam.lab.android.PO.CalculatorPO;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorBO {
    private CalculatorPO calculatorPO;

    public CalculatorBO(AndroidDriver driver){
        calculatorPO = new CalculatorPO(driver);
    }

    public CalculatorBO typeNumber(int number){
        String numberString = String.valueOf(number);
        for(char digit: numberString.toCharArray()){
            calculatorPO.clickDigit(digit);
        }
        return this;
    }

    public CalculatorBO add(int number){
        calculatorPO.clickPlus();
        typeNumber(number);
        calculatorPO.clickEquals();
        return this;
    }

    public CalculatorBO subtract(int number){
        calculatorPO.clickMinus();
        typeNumber(number);
        calculatorPO.clickEquals();
        return this;
    }

    public CalculatorBO divide(int number){
        calculatorPO.clickDivide();
        typeNumber(number);
        calculatorPO.clickEquals();
        return this;
    }

    public CalculatorBO multiply(int number){
        calculatorPO.clickMultiply();
        typeNumber(number);
        calculatorPO.clickEquals();
        return this;
    }

    public String getResult(){
        //calculatorPO.clickEquals();
        return calculatorPO.getResultValue();
    }
}
