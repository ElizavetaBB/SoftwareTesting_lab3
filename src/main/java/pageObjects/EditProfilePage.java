package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProfilePage {
    private WebDriver driver;
    @FindBy(xpath = "/html/body/div[1]/section/div[2]/div/div/div[3]/div/div[2]/div/form/div[1]/input")
    private WebElement name;
    @FindBy(xpath = "/html/body/div[1]/section/div[2]/div/div/div[3]/div/div[2]/div/form/p[2]/input")
    private WebElement saveButton;

    public EditProfilePage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
        driver=webDriver;

    }

    public WebElement getSaveButton(){
        return saveButton;
    }

    public WebElement getName(){
        return name;
    }
}
