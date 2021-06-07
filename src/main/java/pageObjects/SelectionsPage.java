package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectionsPage {
    private WebDriver webDriver;
    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/div[3]/div/div[2]/div/a/h1")
    private WebElement title;
    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/div[3]/div/div[3]/div[1]/a[2]")
    private WebElement articleLink;

    public SelectionsPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
        this.webDriver=webDriver;
    }

    public WebElement getTitle(){
        return title;
    }

    public WebElement getArticleLink(){
        return articleLink;
    }

    public void clickArticleLink(){
        WebElement ele = webDriver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[3]/div/div[3]/div[1]/a[2]"));
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", ele);
    }

}
