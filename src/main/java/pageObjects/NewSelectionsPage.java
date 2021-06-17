package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewSelectionsPage extends Page{
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[1]/div/form/div[1]/h1")
    private WebElement title;

    public NewSelectionsPage(WebDriver webDriver){
        super(webDriver);
    }

    public WebElement getTitle(){
        return title;
    }


}
