import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.*;
import java.util.concurrent.TimeUnit;

public class GroupsTest {
    protected static WebDriver driver;
    protected MainPage mainPage;
    protected String expected;
    protected GroupsPage groupsPage;
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

    @DisplayName("Test GroupsPage is visible")
    @Test
    public void testSeeGroupsPage(){
        mainPage.clickGroupsLink();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        groupsPage=new GroupsPage(driver);
        expected="КАТАЛОГ ГРУПП";
        Assertions.assertEquals(expected,groupsPage.getGroupsCatalogLink().getText().trim());
    }

    @DisplayName("Test create group without authentication")
    @Test
    public void testUnauthenticatedCreateGroup(){
        mainPage.clickGroupsLink();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        groupsPage=new GroupsPage(driver);
        groupsPage.clickCreateGroupButton();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        LoginPage loginPage=new LoginPage(driver);
        expected="Вход на сайт";
        Assertions.assertEquals(expected,loginPage.getAuthLink().getText().trim());
    }

    @Nested
    @DisplayName("GroupsTest with authentication")
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
            mainProfilePage.clickGroupsLink();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            groupsPage=new GroupsPage(driver);
        }

        @DisplayName("Test create group with authentication")
        @Test
        public void testAuthenticatedCreateGroup(){
            groupsPage.clickCreateGroupButton();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            NewGroupsPage newGroupsPage=new NewGroupsPage(driver);
            expected="Создание новой группы";
            Assertions.assertEquals(expected,newGroupsPage.getTitle().getText().trim());
        }

        @DisplayName("Test read a theme without following")
        @Test
        public void testUnfollowingReadingTheme(){
            mainPage.clickGroupsLink();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            groupsPage=new GroupsPage(driver);
            groupsPage.getGroupLink().click();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            groupsPage=new GroupsPage(driver);
            groupsPage.getThemeLink().click();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            groupsPage=new GroupsPage(driver);
            expected="Материалы группы доступны только ее участникам.";
            Assertions.assertEquals(expected,groupsPage.getWarningMessage().getText().trim());
        }

        @DisplayName("Test following a group and read a theme")
        @Test
        public void testFollowGroup(){
            mainPage.clickGroupsLink();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            String expectedGroup=groupsPage.getGroupLink().getText().trim();
            groupsPage=new GroupsPage(driver);
            groupsPage.getGroupLink().click();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            groupsPage=new GroupsPage(driver);
            groupsPage.clickFollowGroupButton();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            driver.get(driver.getCurrentUrl());
            driver.navigate().to(driver.getCurrentUrl());
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            groupsPage=new GroupsPage(driver);
            expected=groupsPage.getThemeLink().getText().trim();
            groupsPage.clickThemeLink();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            groupsPage=new GroupsPage(driver);
            Assertions.assertEquals(expected,groupsPage.getThemeTitle().getText().trim());
            groupsPage.clickMyGroupsLink();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            MyGroupsPage myGroupsPage=new MyGroupsPage(driver);
            Assertions.assertEquals(expectedGroup,myGroupsPage.getMyGroup().getText().trim());
            myGroupsPage.clickListForGroupSettings();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            myGroupsPage=new MyGroupsPage(driver);
            myGroupsPage.clickUnfollowLink();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            myGroupsPage=new MyGroupsPage(driver);
        }
    }
}
