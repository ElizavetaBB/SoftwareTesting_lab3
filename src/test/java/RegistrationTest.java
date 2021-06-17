import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.MainPage;
import pageObjects.RegistrationPage;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {
    public MainPage mainPage;
    public RegistrationPage registrationPage;
    public static WebDriver driver;

    @BeforeEach
    public void init(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("webdriver"));
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("mainpage"));
        mainPage=new MainPage(driver);
        mainPage.clickRegistrationLink();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registrationPage=new RegistrationPage(driver);
    }

    @AfterEach
    public void close(){
        driver.close();
    }

    @DisplayName("Test right registration")
    @Test
    public void testPassedRegistration(){
        registrationPage.inputEmail(ConfProperties.getProperty("rightRegistrationLogin"));
        registrationPage.setAgreeField1();
        registrationPage.setAgreeField2();
        registrationPage.clickRegButton();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String expected="Пожалуйста, подтвердите ваш адрес.";
        Assertions.assertEquals(expected,registrationPage.getRegDescription().findElement(By.tagName("strong")).getText());
    }

    @DisplayName("Test failed checkboxes")
    @Test
    public void testFailedCheckBoxes(){
        registrationPage.inputEmail(ConfProperties.getProperty("rightRegistrationLogin"));
        registrationPage.clickRegButton();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Assertions.assertNotNull(registrationPage.getErrorMes1().findElement(By.tagName("font")).getText());
        Assertions.assertNotNull(registrationPage.getErrorMes2().findElement(By.tagName("font")).getText());
    }

    @DisplayName("Test email already exists")
    @Test
    public void testFailedEmail(){
        registrationPage.inputEmail(ConfProperties.getProperty("login"));
        registrationPage.setAgreeField1();
        registrationPage.setAgreeField2();
        registrationPage.clickRegButton();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String expected="адрес уже зарегистрирован";
        Assertions.assertEquals(expected,registrationPage.getErrorMes1().findElement(By.tagName("font")).getText());
    }

}
