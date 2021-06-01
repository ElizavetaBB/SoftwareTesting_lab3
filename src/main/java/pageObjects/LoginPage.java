package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//*[@id=\"js_tab_auth\"]")
    private WebElement loginForm;
    @FindBy(xpath="//*[@id=\"credential_0\"]")
    private WebElement loginField;
    @FindBy(xpath="//*[@id=\"credential_1\"]")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"js_loginFormBut\"]")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"auth_msg\"]")
    private WebElement regErrorMes;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
        wait=new WebDriverWait(driver,30);
    }

    public void inputLogin(String login){
        loginField.sendKeys(login);
    }

    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public WebElement getRegErrorMes(){
        return regErrorMes;
    }
}