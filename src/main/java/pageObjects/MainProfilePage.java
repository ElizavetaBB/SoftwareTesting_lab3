package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainProfilePage {
    private WebDriver webDriver;
    private WebDriverWait wait;
    @FindBy(xpath = "/html/body/div[1]/header/ul/li[1]/a")// //*[@id="all"]/header/ul/li[1]/a
    private WebElement profileMenu;
    @FindBy(xpath = "/html/body/div[1]/header/div[4]/ul")// //*[@id="logged_list"]
    private List<WebElement> loggedList;
    private List<WebElement> loggedItems;

    public MainProfilePage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
        this.webDriver=webDriver;
        wait=new WebDriverWait(webDriver,30);
        loggedItems=loggedList.get(0).findElements(By.tagName("li"));
    }

    public void clickProfileMenu(){
        profileMenu.click();
    }

    public WebElement getMyProfileLink(){
        return loggedItems.get(0).findElement(By.tagName("a"));
    }

    public void clickMySubscriptionsLink(){
        loggedItems.get(1).findElement(By.tagName("a")).click();
    }

}
