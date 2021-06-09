package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyGroupsPage {
    private WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[2]/div/div/div[3]/div/div[4]/div[2]/ul/li[1]/a")
    private WebElement newGroup;
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[2]/div/div/div[3]/div/div[4]/div[2]/ul/li[1]/div")
    private WebElement listForGroupSettings;
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[2]/div/div/div[3]/div/div[4]/div[2]/ul/li[1]/div/div[3]/a")
    private WebElement unfollowLink;


    public MyGroupsPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
        this.webDriver=webDriver;
    }

    public WebElement getMyGroup(){
        return newGroup;
    }

    public void clickListForGroupSettings(){
        listForGroupSettings.click();
    }

    public void clickUnfollowLink(){
        unfollowLink.click();
    }
}
