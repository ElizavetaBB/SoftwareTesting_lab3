package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IssuesPage {
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[1]/div/ul/li[1]/a")
    private WebElement mainMenuLink;
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[1]/div/div/a")
    private WebElement createMailingButton;
    @FindBy(xpath = "//*[@id=\"all\"]/div[4]/ul/li[2]/a")
    private WebElement themeLink;
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[4]/div/div[1]/div[1]/div[1]/span/a")
    private WebElement groupLink;
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[1]/div/ul/li[2]/a")
    private WebElement mailingCatalogLink;
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[3]/ul/li[1]/a")
    private WebElement mailingGoldCategory;
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[4]/div/div[2]/div[3]/ul/li[5]/a")
    private WebElement activityLink;
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[4]/div/div[1]/div[1]/div/div[4]/span")
    private WebElement topActivityElement;
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[4]/div/div[1]/div[2]/div/div[4]/span")
    private WebElement secondActivityElement;
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[4]/div/div[1]/div[1]/div[2]/a[1]")
    private WebElement articleLink;
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[2]/div/div[2]/div[2]/div[2]/h2")
    private WebElement articleHeader;


    public IssuesPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }

    public WebElement getMainMenuLink(){
        return mainMenuLink;
    }

    public void clickCreateMailingButton(){
        createMailingButton.click();
    }

    public void clickThemeLink(){
        themeLink.click();
    }

    public WebElement getGroupLink(){
        return groupLink;
    }

    public void clickMailingCatalogLink(){
        mailingCatalogLink.click();
    }

    public WebElement getMailingGoldCategory(){
        return mailingGoldCategory;
    }

    public void clickActivityLing(){
        activityLink.click();
    }

    public int[] getActivityIndicators() {
        int topActivity=Integer.parseInt(topActivityElement.getText().split(" ")[1]);
        int secondActivity=Integer.parseInt(secondActivityElement.getText().split(" ")[1]);
        return new int[]{topActivity,secondActivity};
    }

    public WebElement getArticleLink(){
        return articleLink;
    }

    public WebElement getArticleHeader(){
        return articleHeader;
    }
}
