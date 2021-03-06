package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{
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
    @FindBy(xpath = "/html/body/div[7]/div/div/ul/li[1]/a")
    private WebElement authLink;

    public LoginPage(WebDriver webDriver){
        super(webDriver);
    }

    public WebElement getLoginField(){
        return loginField;
    }

    public WebElement getPasswordField(){
        return passwordField;
    }

    public WebElement getLoginButton(){
        return loginButton;
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

    public WebElement getAuthLink(){
        return authLink;
    }

}
