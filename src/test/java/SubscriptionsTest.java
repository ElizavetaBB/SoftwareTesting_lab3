import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.*;

import java.util.concurrent.TimeUnit;

public class SubscriptionsTest {
    public static MainPage mainPage;
    public static LoginPage loginPage;
    public static MainProfilePage mainProfilePage;
    public static SubscriptionsPage subscriptionsPage;
    public static WebDriver driver;

    @BeforeAll
    public static void init(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("webdriver"));
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("mainpage"));
        mainPage=new MainPage(driver);
        driver.get(ConfProperties.getProperty("mainpage"));
        mainPage.clickLoginLink();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage=new LoginPage(driver);
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        mainProfilePage=new MainProfilePage(driver);
        mainProfilePage.clickProfileMenu();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        mainProfilePage.clickMySubscriptionsLink();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        subscriptionsPage=new SubscriptionsPage(driver);
    }

    @AfterAll
    public static void close(){
        driver.close();
    }

    @DisplayName("Test unsubscribe")
    @Test
    public void testUnsubscribe(){
        int current=subscriptionsPage.getCountOfSubscr(true);
        int previous=subscriptionsPage.getCountOfSubscr(false);
        subscriptionsPage.unsubscribe();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://subscribe.ru/member/issue");
        driver.navigate().to(driver.getCurrentUrl());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        subscriptionsPage = new SubscriptionsPage(driver);
        Assertions.assertEquals(current - 1, subscriptionsPage.getCountOfSubscr(true));
        Assertions.assertEquals(previous + 1, subscriptionsPage.getCountOfSubscr(false));
    }
}
