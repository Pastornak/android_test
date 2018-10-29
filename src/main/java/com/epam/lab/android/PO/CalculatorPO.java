package com.epam.lab.android.PO;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPO {
    @FindBy(xpath = "//*[@resource-id='com.android.calculator2:id/result']")
    private WebElement result;
    @FindBy(xpath = "//*[@resource-id='com.android.calculator2:id/eq']")
    private WebElement equals;
    @FindBy(xpath = "//*[@resource-id='com.android.calculator2:id/op_add']")
    private WebElement plus;
    @FindBy(xpath = "//*[@resource-id='com.android.calculator2:id/op_sub']")
    private WebElement minus;
    @FindBy(xpath = "//*[@resource-id='com.android.calculator2:id/op_mul']")
    private WebElement multiply;
    @FindBy(xpath = "//*[@resource-id='com.android.calculator2:id/op_div']")
    private WebElement divide;
    @FindBy(xpath = "//*[@resource-id='com.android.calculator2:id/dec_point']")
    private WebElement coma;
    @FindBy(xpath = "//*[@resource-id='com.android.calculator2:id/del']")
    private WebElement delete;
    @FindBy(xpath = "//*[@resource-id='com.android.calculator2:id/digit_0']")
    private WebElement zero;
    @FindBy(xpath = "//*[@resource-id='com.android.calculator2:id/digit_1']")
    private WebElement one;
    @FindBy(xpath = "//*[@resource-id='com.android.calculator2:id/digit_2']")
    private WebElement two;
    @FindBy(xpath = "//*[@resource-id='com.android.calculator2:id/digit_3']")
    private WebElement three;
    @FindBy(xpath = "//*[@resource-id='com.android.calculator2:id/digit_4']")
    private WebElement four;
    @FindBy(xpath = "//*[@resource-id='com.android.calculator2:id/digit_5']")
    private WebElement five;
    @FindBy(xpath = "//*[@resource-id='com.android.calculator2:id/digit_6']")
    private WebElement six;
    @FindBy(xpath = "//*[@resource-id='com.android.calculator2:id/digit_7']")
    private WebElement seven;
    @FindBy(xpath = "//*[@resource-id='com.android.calculator2:id/digit_8']")
    private WebElement eight;
    @FindBy(xpath = "//*[@resource-id='com.android.calculator2:id/digit_9']")
    private WebElement nine;

    public CalculatorPO(AndroidDriver driver){
        PageFactory.initElements(driver, this);
    }

    public CalculatorPO clickDigit(int digit){
        switch (digit) {
            case 0:
                zero.click();
                break;
            case 1:
                one.click();
                break;
            case 2:
                two.click();
                break;
            case 3:
                three.click();
                break;
            case 4:
                four.click();
                break;
            case 5:
                five.click();
                break;
            case 6:
                six.click();
                break;
            case 7:
                seven.click();
                break;
            case 8:
                eight.click();
                break;
            case 9:
                nine.click();
                break;
            default:
                break;
        }
        return this;
    }

    public CalculatorPO clickDigit(char digit){
        clickDigit(Character.getNumericValue(digit));
        return this;
    }

    public CalculatorPO clickPlus(){
        plus.click();
        return this;
    }

    public CalculatorPO clickMinus(){
        minus.click();
        return this;
    }

    public CalculatorPO clickMultiply(){
        multiply.click();
        return this;
    }

    public CalculatorPO clickDivide(){
        divide.click();
        return this;
    }

    public CalculatorPO clickDelete(){
        delete.click();
        return this;
    }

    public CalculatorPO clickComa(){
        coma.click();
        return this;
    }

    public WebElement getResultField(){
        return result;
    }

    public String getResultValue(){
        return result.getText();
    }

    public CalculatorPO clickEquals(){
        equals.click();
        return this;
    }
}
