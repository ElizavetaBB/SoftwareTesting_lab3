import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.*;
import java.util.concurrent.TimeUnit;

public class IssuesTest {
    private static WebDriver driver;
    private MainPage mainPage;
    private String expected;
    private IssuesPage issuesPage;

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
        issuesPage=new IssuesPage(driver);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        issuesPage.clickMailingCatalogLink();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        issuesPage=new IssuesPage(driver);
        issuesPage.clickActivityLink();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
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
            mainProfilePage.clickIssuesLink();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            issuesPage=new IssuesPage(driver);
        }

        @DisplayName("Test create an issue with authentication")
        @Test
        public void testAuthenticatedCreateGroup(){
            issuesPage.clickCreateMailingButton();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            NewIssuesPage newIssuesPage=new NewIssuesPage(driver);
            expected="Выберите тип создаваемой рассылки";
            Assertions.assertEquals(expected,newIssuesPage.getTitle().getText().trim());
        }

        @DisplayName("Test subscribe an issue")
        @Test
        public void testSubscribeIssue(){
            issuesPage.clickAllIssuesLink();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            expected=issuesPage.getSubscribeLinkHeader().getText().trim();
            issuesPage.clickSubscribeLink();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            issuesPage=new IssuesPage(driver);
            issuesPage.clickLoginLink();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            issuesPage.clickMyIssuesLink();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            SubscriptionsPage subscriptionsPage=new SubscriptionsPage(driver);
            Assertions.assertTrue(subscriptionsPage.getNewIssueLink().getText().contains(expected));
        }

    }
}
