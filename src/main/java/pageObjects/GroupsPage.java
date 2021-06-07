package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GroupsPage {
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[1]/div/ul/li[2]/a")
    private WebElement groupsCatalogLink;
    @FindBy(xpath = "//*[@id=\"all\"]/section/div[1]/div/div/a")
    private WebElement createGroupButton;

    public GroupsPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }

    public WebElement getGroupsCatalogLink(){
        return groupsCatalogLink;
    }

    public void clickCreateGroupButton(){
        createGroupButton.click();
    }

}
