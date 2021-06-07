import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.MainPage;
import pageObjects.SelectionsPage;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SelectionsTest {
    private static WebDriver driver;
    private static MainPage mainPage;
    private String expected;
    private static SelectionsPage selectionsPage;
    @BeforeAll
    public static void init(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("webdriver"));
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("mainpage"));
        mainPage=new MainPage(driver);
    }

    @AfterAll
    public static void close(){
        driver.close();
    }

    @DisplayName("Test SelectionsPage is visible")
    @Test
    public void testSeeSelectionsPage(){
        mainPage.clickSelectionsLink();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        selectionsPage=new SelectionsPage(driver);
        expected="Моя лента";
        Assertions.assertEquals(expected,selectionsPage.getTitle().getText().trim());
    }

    @DisplayName("Test following a link")
    @Test
    public void testFollowLink(){
        mainPage.clickSelectionsLink();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        selectionsPage=new SelectionsPage(driver);
        expected=selectionsPage.getArticleLink().getAttribute("href");
        selectionsPage.clickArticleLink();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        selectionsPage=new SelectionsPage(driver);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Assertions.assertEquals(expected, driver.getCurrentUrl());
    }

}
