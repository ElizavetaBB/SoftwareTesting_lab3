package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
    protected WebDriver webDriver;

    public Page(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
        this.webDriver=webDriver;
    }
}
