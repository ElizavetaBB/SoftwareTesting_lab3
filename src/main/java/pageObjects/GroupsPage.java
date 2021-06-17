package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class GroupsPage extends Page{
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[1]/div/ul/li[2]/a")
    private WebElement groupsCatalogLink;
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[1]/div/div/a")
    private WebElement createGroupButton;
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[4]/div/div[1]/div/div[2]/div[2]/h2/a")
    private WebElement groupLink;
    @FindBy(xpath = "//*[@id=\"groupsends\"]/div[6]/h2/a")
    private WebElement themeLink;
    @FindBy(xpath = "//*[@id=\"confirm_form_text\"]/b")
    private WebElement warningMessage;
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[3]/div/div[3]/a")
    private WebElement followGroupButton;
    @FindBy(xpath = "//*[@id=\"groupsends\"]/div/div[2]/h2/a")
    private WebElement themeTitle;
    @FindBy(xpath = "//*[@id=\"logged_list\"]/li[3]/a")
    private WebElement myGroupsLink;
    @FindBy(xpath = "//*[@id=\"all\"]/header/ul/li[1]/a")
    private WebElement loginLink;

    public GroupsPage(WebDriver webDriver){
        super(webDriver);
    }

    public WebElement getGroupsCatalogLink(){
        return groupsCatalogLink;
    }

    public void clickCreateGroupButton(){
        createGroupButton.click();
    }

    public WebElement getGroupLink(){
        return groupLink;
    }

    public WebElement getThemeLink(){
        return themeLink;
    }

    public void clickThemeLink(){
        WebElement ele = webDriver.findElement(By.xpath("//*[@id=\"groupsends\"]/div[6]/h2/a"));
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", ele);
    }

    public void clickFollowGroupButton(){
        followGroupButton.click();
    }

    public WebElement getWarningMessage() {
        return warningMessage;
    }

    public WebElement getThemeTitle(){
        return themeTitle;
    }

    public void clickMyGroupsLink(){
        loginLink.click();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        myGroupsLink.click();
    }
}
