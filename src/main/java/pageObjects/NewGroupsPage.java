package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewGroupsPage {
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[2]/div/h3")
    private WebElement title;

    public NewGroupsPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }

    public WebElement getTitle(){
        return title;
    }
}
