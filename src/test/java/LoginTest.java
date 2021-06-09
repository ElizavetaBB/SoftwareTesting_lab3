import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.MainProfilePage;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static MainPage mainPage;
    public static LoginPage loginPage;
    public static WebDriver driver;

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

    @BeforeEach
    public void setLoginPage(){
        driver.get(ConfProperties.getProperty("mainpage"));
        mainPage.clickLoginLink();
        loginPage=new LoginPage(driver);
    }

    @DisplayName("Test right login with password")
    @Test
    public void testPassedLogin(){
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        MainProfilePage mainProfilePage=new MainProfilePage(driver);
        mainProfilePage.clickProfileMenu();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String expected="Мой профиль";
        Assertions.assertEquals(expected,mainProfilePage.getMyProfileLink().getText());
    }

    @DisplayName("Test failed login")
    @Test
    public void testFailedLogin(){
        loginPage.inputLogin(ConfProperties.getProperty("failedLogin"));
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String expected="адрес не зарегистрирован";
        Assertions.assertEquals(expected,loginPage.getRegErrorMes().findElement(By.tagName("font")).getText());
    }

    @DisplayName("Test failed password")
    @Test
    public void testFailedPassword(){
        loginPage.inputLogin(ConfProperties.getProperty("failedPasswordLogin"));
        loginPage.inputPassword(ConfProperties.getProperty("failedPassword"));
        loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String expected="Вы ввели неверный пароль";
        Assertions.assertEquals(expected,loginPage.getRegErrorMes().findElement(By.tagName("font")).getText());
    }

    @DisplayName("Test authentication limit")
    @Test
    public void testAuthenticationLimit(){
        loginPage.inputLogin(ConfProperties.getProperty("limitLogin"));
        loginPage.inputPassword(ConfProperties.getProperty("failedPassword"));
        loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        loginPage=new LoginPage(driver);
        String expected="Исчерпан лимит неудачных попыток авторизации. Сервис будет доступен через час";
        Assertions.assertEquals(expected,loginPage.getRegErrorMes().findElement(By.tagName("font")).getText());
    }

}
