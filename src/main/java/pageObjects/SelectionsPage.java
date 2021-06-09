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
    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/div[2]/div/div/div/div/div[1]/a")
    private WebElement createButton;
    @FindBy(xpath = "//*[@id=\"tree_box\"]/div/div[2]/ul/li[1]/div/a")
    private WebElement firstSelection;
    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/div[3]/div/div[3]/div[1]/div[6]/div[1]")
    private WebElement addToSelectionLink;
    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/div[3]/div/div[3]/div[1]/div[6]/div[6]/div[1]/div/form/div/a[1]")
    private WebElement selectionContainerLink;
    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/div[3]/div/div[4]/div[1]/div[1]/div/form/div[2]/button[2]")
    private WebElement addToSelectionButton;
    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/div[2]/div/div/div/div/div[3]/div/div/ul/li[1]/div/a")
    private WebElement mySelection;
    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/div[3]/div/div[3]/div[1]/a[2]/h1[1]")
    private WebElement newsTitle;
    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/div[3]/div/div[3]/div[1]/div[6]/div[5]")
    private WebElement like;
    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/div[2]/div/div/div/div/div[3]/div/div/ul/li[2]/div/a")
    private WebElement myFavorite;


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

    public void clickCreateButton(){
        createButton.click();
    }

    public void clickFirstSelection(){
        firstSelection.click();
    }

    public void clickAddToSelectionLink(){
        addToSelectionLink.click();
    }

    public void clickSelectionContainerLink(){
        selectionContainerLink.click();
    }

    public void clickAddToSelectionButton(){
        addToSelectionButton.click();
    }

    public void clickMySelection(){
        mySelection.click();
    }

    public WebElement getNewsTitle(){
        return newsTitle;
    }

    public WebElement getLike(){
        return like;
    }

    public void clickMyFavorite(){
        myFavorite.click();
    }
}
