package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewIssuesPage {
    private WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[1]/div/h3")
    private WebElement title;

    public NewIssuesPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
        this.webDriver=webDriver;
    }

    public WebElement getTitle(){
        return title;
    }
}
