package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class MainProfilePage extends Page{
    @FindBy(xpath = "/html/body/div[1]/header/ul/li[1]/a")
    private WebElement profileMenu;
    @FindBy(xpath = "/html/body/div[1]/header/div[4]/ul")
    private List<WebElement> loggedList;
    private List<WebElement> loggedItems;
    @FindBy(xpath = "//*[@id=\"all\"]/header/div[1]/div/ul/li[1]/span/a")
    private WebElement issuesLink;
    @FindBy(xpath = "//*[@id=\"all\"]/header/div[1]/div/ul/li[2]/span/a")
    private WebElement groupsLink;
    @FindBy(xpath = "//*[@id=\"all\"]/header/div[1]/div/ul/li[3]/span/a")
    private WebElement selections;
    @FindBy(xpath = "//*[@id=\"all\"]/header/ul/li[1]/a")
    private WebElement loginLink;
    @FindBy(xpath = "//*[@id=\"logged_list\"]/li[9]/a")
    private WebElement exitLink;

    public MainProfilePage(WebDriver webDriver){
        super(webDriver);
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

    public void clickIssuesLink(){
        issuesLink.click();
    }

    public void clickGroupsLink(){
        groupsLink.click();
    }

    public void clickSelectionsLink(){
        selections.click();
    }

    public void clickExitLink(){
        exitLink.click();
    }

    public void clickLoginLink(){
        loginLink.click();
    }
}
