package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfilePage extends Page{
    @FindBy(xpath = "/html/body/div[1]/section/div[2]/div/div/div[3]/div/div[2]/div/form/div[1]/input")
    private WebElement name;
    @FindBy(xpath = "/html/body/div[1]/section/div[2]/div/div/div[3]/div/div[2]/div/form/p[2]/input")
    private WebElement saveButton;

    public EditProfilePage(WebDriver webDriver){
        super(webDriver);
    }

    public WebElement getSaveButton(){
        return saveButton;
    }

    public WebElement getName(){
        return name;
    }
}
