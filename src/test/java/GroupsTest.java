import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.GroupsPage;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import java.util.concurrent.TimeUnit;

public class GroupsTest {
    private static WebDriver driver;
    private static MainPage mainPage;
    private String expected;
    private static GroupsPage groupsPage;
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

    @DisplayName("Test GroupsPage is visible")
    @Test
    public void testChangeName(){
        mainPage.clickGroupsLink();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        groupsPage=new GroupsPage(driver);
        expected="КАТАЛОГ ГРУПП";
        Assertions.assertEquals(expected,groupsPage.getGroupsCatalogLink().getText().trim());
    }

    @DisplayName("Test create group without authentication")
    @Test
    public void testCreateGroup(){
        mainPage.clickGroupsLink();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        groupsPage=new GroupsPage(driver);
        groupsPage.clickCreateGroupButton();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        LoginPage loginPage=new LoginPage(driver);
        expected="Вход на сайт";
        Assertions.assertEquals(expected,loginPage.getAuthLink().getText().trim());
    }
}
