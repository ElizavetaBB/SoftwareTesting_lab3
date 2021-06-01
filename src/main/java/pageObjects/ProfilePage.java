package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    @FindBy(xpath = "/html/body/div[1]/section/div[2]/div/div/div[3]/div/div[1]/div[1]/a")// //*[@id="all"]/section/div[2]/div/div/div[3]/div/div[1]/div[1]/a
    private WebElement subscriptionLink;


    public ProfilePage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }

}
