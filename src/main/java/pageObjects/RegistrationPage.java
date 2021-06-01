package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//*[@id=\"js_tab_auth\"]")
    private WebElement loginForm;
    @FindBy(xpath="//*[@id=\"arfemail\"]")// //*[@id="arfemail"]
    private WebElement emailField;
    @FindBy(xpath="//*[@id=\"js_tap_panel_checkbox_terms\"]")// //*[@id="js_tap_panel_checkbox_terms"]
    private WebElement agreeField1;
    @FindBy(xpath = "//*[@id=\"js_tap_panel_checkbox_personal\"]")// //*[@id="js_tap_panel_checkbox_personal"]
    private WebElement agreeField2;
    @FindBy(xpath = "//*[@id=\"js_regFormBut\"]")// //*[@id="js_regFormBut"]
    private WebElement regButton;
    @FindBy(xpath = "//*[@id=\"reg_msg\"]") ////*[@id="reg_msg"]
    private WebElement errorMes1;
    @FindBy(xpath = "//*[@id=\"reg_msg2\"]") // //*[@id="reg_msg2"]
    private WebElement errorMes2;
    @FindBy(xpath = "//*[@id=\"js_tap_panel_auth\"]/p") // //*[@id="js_tap_panel_auth"]/p
    private WebElement regDescription;

    public RegistrationPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
        wait=new WebDriverWait(driver,30);
    }

    public void inputEmail(String login){
        emailField.sendKeys(login);
    }

    public void setAgreeField1(){
        agreeField1.click();
    }

    public void setAgreeField2(){
        agreeField2.click();
    }

    public void clickRegButton(){
        wait.until(ExpectedConditions.elementToBeClickable(regButton));
        regButton.click();
    }

    public WebElement getErrorMes1(){
        return errorMes1;
    }

    public WebElement getErrorMes2(){
        return errorMes2;
    }

    public WebElement getRegDescription(){
        return regDescription;
    }
}
