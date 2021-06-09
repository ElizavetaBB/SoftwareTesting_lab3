import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SelectionsTest {
    private static WebDriver driver;
    private MainPage mainPage;
    private String expected;
    private SelectionsPage selectionsPage;
    @BeforeEach
    public void init(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("webdriver"));
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("mainpage"));
        mainPage=new MainPage(driver);
    }

    @AfterEach
    public void close(){
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
        driver.close();
        driver.switchTo().window(newTab.get(0));
    }


    @Nested
    @DisplayName("IssuesTest with authentication")
    class AuthenticatedGroupsTest{

        @BeforeEach
        public void init(){
            driver.get(ConfProperties.getProperty("mainpage"));
            mainPage.clickLoginLink();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            LoginPage loginPage=new LoginPage(driver);
            loginPage.inputLogin(ConfProperties.getProperty("login"));
            loginPage.inputPassword(ConfProperties.getProperty("password"));
            loginPage.clickLoginButton();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            MainProfilePage mainProfilePage=new MainProfilePage(driver);
            mainProfilePage.clickSelectionsLink();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            selectionsPage=new SelectionsPage(driver);
        }

        @DisplayName("Test create an issue with authentication")
        @Test
        public void testAuthenticatedCreateGroup(){
            selectionsPage.clickCreateButton();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            NewSelectionsPage newSelectionsPage=new NewSelectionsPage(driver);
            expected="Создание новой подборки";
            Assertions.assertEquals(expected,newSelectionsPage.getTitle().getText().trim());
        }

        @DisplayName("Test add to a selection and like")
        @Test
        public void testAddToSelection(){
            selectionsPage.clickFirstSelection();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            expected=selectionsPage.getNewsTitle().getText().trim();
            selectionsPage=new SelectionsPage(driver);
            selectionsPage.clickAddToSelectionLink();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            selectionsPage.clickSelectionContainerLink();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            selectionsPage.clickAddToSelectionButton();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            selectionsPage.getLike().click();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            selectionsPage=new SelectionsPage(driver);
            selectionsPage.clickMySelection();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            selectionsPage=new SelectionsPage(driver);
            Assertions.assertEquals(expected,selectionsPage.getNewsTitle().getText().trim());
            selectionsPage.clickMyFavorite();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            selectionsPage=new SelectionsPage(driver);
            Assertions.assertEquals(expected,selectionsPage.getNewsTitle().getText().trim());
        }
    }
}
