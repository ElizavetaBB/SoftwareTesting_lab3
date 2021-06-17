package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewIssuesPage extends Page{
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[1]/div/h3")
    private WebElement title;

    public NewIssuesPage(WebDriver webDriver){
        super(webDriver);
    }

    public WebElement getTitle(){
        return title;
    }
}
