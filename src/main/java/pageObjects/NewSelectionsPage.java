package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewSelectionsPage {
    private WebDriver webDriver;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[1]/div/form/div[1]/h1")
    private WebElement title;

    public NewSelectionsPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
        this.webDriver=webDriver;
    }

    public WebElement getTitle(){
        return title;
    }


}
