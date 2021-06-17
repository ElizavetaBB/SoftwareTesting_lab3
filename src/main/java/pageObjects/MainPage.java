package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage extends Page{
    @FindBy(xpath = "//*[@id=\"all\"]/header/ul/li[1]/a")
    private WebElement loginLink;
    @FindBy(xpath = "//*[@id=\"js_tab_reg\"]/a")
    private WebElement registrationLink;
    @FindBy(xpath = "/html/body/div[8]/div/div/ul")
    private List<WebElement> regMenu;
    @FindBy(xpath = "//*[@id=\"all\"]/header/div[1]/div/ul/li[1]/span/a")
    private WebElement issuesLink;
    @FindBy(xpath = "//*[@id=\"all\"]/header/div[1]/div/ul/li[2]/span/a")
    private WebElement groupsLink;
    @FindBy(xpath = "//*[@id=\"all\"]/header/div[1]/div/ul/li[3]/span/a")
    private WebElement selections;
    private JavascriptExecutor executor;

    public MainPage(WebDriver webDriver){
        super(webDriver);
        executor=(JavascriptExecutor) webDriver;
    }

    public void clickLoginLink(){
        //loginLink.click();
        WebElement ele = webDriver.findElement(By.xpath("//*[@id=\"all\"]/header/ul/li[1]/a"));
        //JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", ele);
    }

    public void clickRegistrationLink(){
        clickLoginLink();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement ele = webDriver.findElement(By.xpath("//*[@id=\"js_tab_reg\"]/a"));
        //avascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", ele);
        //registrationLink.click();
    }

    public void clickIssuesLink(){
        issuesLink.click();
    }

    public void clickGroupsLink(){
        groupsLink.click();
    }

    public void clickSelectionsLink(){
        //selections.click();
        WebElement ele = webDriver.findElement(By.xpath("//*[@id=\"all\"]/header/div[1]/div/ul/li[3]/span/a"));
        //JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", ele);
    }
}
