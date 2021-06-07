import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.EditProfilePage;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.MainProfilePage;
import java.util.concurrent.TimeUnit;

public class EditProfileTest {
    public static MainPage mainPage;
    public static LoginPage loginPage;
    public static MainProfilePage mainProfilePage;
    public static EditProfilePage editProfilePage;
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
        loginPage.getLoginField().sendKeys(ConfProperties.getProperty("login"));//inputLogin(ConfProperties.getProperty("login"));
        loginPage.getPasswordField().sendKeys(ConfProperties.getProperty("password"));//inputPassword(ConfProperties.getProperty("password"));
        loginPage.getLoginButton().click();//clickLoginButton();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        mainProfilePage=new MainProfilePage(driver);
        mainProfilePage.clickProfileMenu();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        mainProfilePage.getMyProfileLink().click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        editProfilePage=new EditProfilePage(driver);
    }

    @AfterAll
    public static void close(){
        driver.close();
    }

   @DisplayName("Test change name")
    @Test
    public void testChangeName(){
        String previous=editProfilePage.getName().getAttribute("value");
        String expected=previous+ConfProperties.getProperty("changeName");
        editProfilePage.getName().sendKeys(ConfProperties.getProperty("changeName"));//inputName(ConfProperties.getProperty("changeName"));
        editProfilePage.getSaveButton().click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Assertions.assertEquals(expected,editProfilePage.getName().getAttribute("value"));
    }
}
