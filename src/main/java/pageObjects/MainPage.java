package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage {
    private WebDriver webDriver;
    private WebDriverWait wait;
    @FindBy(xpath = "/html/body/div[2]/header/ul/li[1]/a")
    private WebElement loginLink;
    @FindBy(xpath = "//*[@id=\"js_tab_reg\"]")//
    private WebElement registrationLink;
    @FindBy(xpath = "/html/body/div[8]/div/div/ul")// //*[@id="loginForm"]/div/ul
    private List<WebElement> regMenu;
    @FindBy(xpath = "//*[@id=\"all\"]/header/div[1]/div/ul/li[1]/span/a")
    private WebElement issuesLink;
    @FindBy(xpath = "//*[@id=\"all\"]/header/div[1]/div/ul/li[2]/span/a")
    private WebElement groupsLink;
    @FindBy(xpath = "//*[@id=\"all\"]/header/div[1]/div/ul/li[3]/span/a")
    private WebElement selections;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        webDriver=driver;
        wait=new WebDriverWait(driver,30);
    }

    public void clickLoginLink(){
        loginLink.click();
    }

    public void clickRegistrationLink(){
        clickLoginLink();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*WebElement ele = webDriver.findElement(By.xpath("//*[@id=\"js_tab_reg\"]"));
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", ele);*/
        registrationLink.click();
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
}
