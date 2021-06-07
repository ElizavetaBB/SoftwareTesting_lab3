package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SubscriptionsPage {
    private WebDriver webDriver;
    @FindBy(xpath = "/html/body/div[1]/section/div[2]/div/div/div[6]/div/div[2]/div[1]/ul") // //*[@id="all"]/section/div[2]/div/div/div[6]/div/div[2]/div[1]/ul
    private WebElement subscrButtonsHeader;
    private List<WebElement> subscrButtons;
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[2]/div/div/div[1]/div[4]/div") // //*[@id="all"]/section/div[2]/div/div/div[1]/div[4]/div
    private WebElement subsContentHeader;
    private List<WebElement> subsContent;

    public SubscriptionsPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
        this.webDriver=webDriver;
        subscrButtons=subscrButtonsHeader.findElements(By.tagName("li"));
        subsContent=subsContentHeader.findElements(By.className("subs_item"));
    }

    public void unsubscribe() throws NullPointerException{
        WebElement ele = webDriver.findElement(By.xpath("//*[@id=\"all\"]/section/div[2]/div/div/div[1]/div[4]/div/span[1]/a"));
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", ele);
    }

    public int getCountOfSubscr(boolean current){
        int k=0;
        if (!current) k=1;
        return Integer.parseInt(subscrButtons.get(k).getText().split("подписано: ")[1]);
    }
}
