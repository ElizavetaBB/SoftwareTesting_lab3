package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul")
    private List<WebElement> topmenu;
    @FindBy(xpath = "/html/body/div[2]/div[4]/ul")
    private List<WebElement> leftMenu;
    @FindBy(xpath = "/html/body/div[2]/section/div[1]/div/ul")////*[@id="all"]/section/div[1]/div/ul
    private List<WebElement> catmenu;
    @FindBy(xpath = "/html/body/div[2]/section/div[1]/div/div")// //*[@id="all"]/section/div[1]/div/div
    private WebElement catmenuButtons;
    @FindBy(xpath = "/html/body/div[1]/section/div[4]/div/div[2]/div[3]/ul") ////*[@id="all"]/section/div[4]/div/div[2]/div[3]/ul
    private List<WebElement> filtres;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        webDriver=driver;
        wait=new WebDriverWait(driver,30);
    }

    public void clickLoginLink(){
        loginLink.click();
    }

    public void clickRegistartionLink(){
        clickLoginLink();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registrationLink.click();
    }

}
