import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.*;
import java.util.concurrent.TimeUnit;

public class IssuesTest {
    private static WebDriver driver;
    private static MainPage mainPage;
    private String expected;
    private static IssuesPage issuesPage;
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

    @DisplayName("Test IssuesPage is visible")
    @Test
    public void testChangeName(){
       mainPage.clickIssuesLink();
       issuesPage=new IssuesPage(driver);
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       expected="ВЫПУСКИ РАССЫЛОК";
       Assertions.assertEquals(expected,issuesPage.getMainMenuLink().getText().trim());
    }

    @DisplayName("Test see issues on a theme")
    @Test
    public void testSeeThemeIssues(){
        mainPage.clickIssuesLink();
        issuesPage=new IssuesPage(driver);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        issuesPage.clickThemeLink();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        issuesPage=new IssuesPage(driver);
        expected="Subscribe. Авто";
        Assertions.assertEquals(expected,issuesPage.getGroupLink().getText().trim());
    }

    @DisplayName("Test create a new mailing without authentication")
    @Test
    public void testCreateNewMailing(){
        mainPage.clickIssuesLink();
        issuesPage=new IssuesPage(driver);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        issuesPage.clickCreateMailingButton();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        LoginPage loginPage=new LoginPage(driver);
        expected="Вход на сайт";
        Assertions.assertEquals(expected,loginPage.getAuthLink().getText().trim());
    }

    @DisplayName("Test see a mailing catalog")
    @Test
    public void testSeeMailingCatalog(){
        mainPage.clickIssuesLink();
        issuesPage=new IssuesPage(driver);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        issuesPage.clickMailingCatalogLink();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        issuesPage=new IssuesPage(driver);
        expected="Золотые рассылки";
        Assertions.assertEquals(expected,issuesPage.getMailingGoldCategory().getText().trim());
    }

    @DisplayName("Test range a mailing catalog by activity")
    @Test
    public void testRangeCatalogByActivity(){
        mainPage.clickIssuesLink();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        issuesPage=new IssuesPage(driver);
        issuesPage.clickMailingCatalogLink();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        issuesPage=new IssuesPage(driver);
        issuesPage.clickActivityLing();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        issuesPage=new IssuesPage(driver);
        int[] indic=issuesPage.getActivityIndicators();
        Assertions.assertTrue(indic[0]>=indic[1]);
    }

    @DisplayName("Test read an article")
    @Test
    public void testReadArticle(){
        mainPage.clickIssuesLink();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        issuesPage=new IssuesPage(driver);
        String expected=issuesPage.getArticleLink().getText().trim();
        issuesPage.getArticleLink().click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        issuesPage=new IssuesPage(driver);
        Assertions.assertEquals(expected, issuesPage.getArticleHeader().getText().trim());
    }
}
