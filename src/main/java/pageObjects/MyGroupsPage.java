package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyGroupsPage extends Page{
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[2]/div/div/div[3]/div/div[4]/div[2]/ul/li[1]/a")
    private WebElement newGroup;
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[2]/div/div/div[3]/div/div[4]/div[2]/ul/li[1]/div")
    private WebElement listForGroupSettings;
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[2]/div/div/div[3]/div/div[4]/div[2]/ul/li[1]/div/div[3]/a")
    private WebElement unfollowLink;


    public MyGroupsPage(WebDriver webDriver){
        super(webDriver);
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
