package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewGroupsPage extends Page{
    @FindBy(xpath = "/html/body/div[1]/section/div[2]/div/h3")
    private WebElement title;

    public NewGroupsPage(WebDriver webDriver){
        super(webDriver);
    }

    public WebElement getTitle(){
        //return title;
        return webDriver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div/h3"));
    }
}
