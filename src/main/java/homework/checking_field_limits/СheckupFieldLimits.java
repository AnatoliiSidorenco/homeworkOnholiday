package homework.checking_field_limits;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class СheckupFieldLimits {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\EducationProg\\seleniumchromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://suninjuly.github.io/registration1.html");
    }

    // todo- в Properties появляются данные после нажатия на конкретное поле ввода
//-todo--- ввожу 33 символа, система должна пропустить только 32
//-todo-- проверку по атрибуту value в Properties сделал "ОТДЕЛЬНО" по каждому полю (можно сделать вместе, так как ограничения одинаковые для всех)
    @Test
    public void firstNameCheckUpProperties() throws InterruptedException {
        WebElement firstNameInputField = driver.findElement(By.cssSelector(".first_block .form-group:nth-child(1) input"));
        firstNameInputField.sendKeys("Abcdefghijklmnopqrstuvwxyzabcdefg");  //-todo--- ввожу 33 символа, система должна пропустить только 32
        sleep(1500);
        assertEquals("Abcdefghijklmnopqrstuvwxyzabcdef", firstNameInputField.getAttribute("value"));//-todo- в expected result ввожу 32 символа и сверяю
                                                                                                                  //-todo- c тем что в value(тоже должно быть 32)

    }

    @Test
    public void lastNameCheckUpProperties() throws InterruptedException {
        WebElement lastNameInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control second']"));
        lastNameInputField.sendKeys("Abcdefghijklmnopqrstuvwxyzabcdefg");
        sleep(1500);
        assertEquals("Abcdefghijklmnopqrstuvwxyzabcdef", lastNameInputField.getAttribute("value"));//g не входит

    }

    @Test
    public void EmailCheckUpProperties() throws InterruptedException {
        WebElement emailInputField = driver.findElement(By.xpath("// div[@class='first_block']//input[@class='form-control third']"));
        emailInputField.sendKeys("Abcdefghijklmnopqrstuvwxyzabcdefg");
        sleep(1500);
        assertEquals("Abcdefghijklmnopqrstuvwxyzabcdef", emailInputField.getAttribute("value"));//g не входит

    }

    @Test
    public void phoneCheckUpProperties() throws InterruptedException {
        WebElement phoneInputField = driver.findElement(By.xpath("// div[@class='second_block']//input[@class='form-control first']"));
        phoneInputField.sendKeys("+12345678912345678912345678912345"); // 33 цифры
        sleep(1500);
        assertEquals("+1234567891234567891234567891234", phoneInputField.getAttribute("value")); // 5 не входит

    }

    @Test
    public void addressCheckUpProperties() throws InterruptedException {
        WebElement addressInputField = driver.findElement(By.xpath("// div[@class='second_block']//input[@class='form-control second']"));
        addressInputField.sendKeys("Abcdefghijklmnopqrstuvwxyzabcdefg");//33 буквы
        sleep(1500);
        assertEquals("Abcdefghijklmnopqrstuvwxyzabcdef", addressInputField.getAttribute("value"));// g не входит

    }

    //-todo---Проверяю что в dev Tools по каждому полю стоит ограничение (атрибут - maxlength, ограничение - 32 )- один тест на все поля
    @Test
    public void checkUpAllFieldsByElementLocator() {
        WebElement firstNameLimit = driver.findElement(By.xpath("(//div[contains(@class,'first_class')]//input[@maxlength='32'])[1]"));
        assertTrue(firstNameLimit.getAttribute("maxlength").contains("32"));
        WebElement lastNameLimit = driver.findElement(By.xpath("(//div[contains(@class,'second_class')]//input[@maxlength='32'])[1]"));
        assertTrue(lastNameLimit.getAttribute("maxlength").contains("32"));
        WebElement emailLimit = driver.findElement(By.xpath("//div[contains(@class,'third_class')]//input[@maxlength='32']"));
        assertTrue(emailLimit.getAttribute("maxlength").contains("32"));
        WebElement phoneLimit = driver.findElement(By.xpath("(//div[contains(@class,'first_class')][1]//input[@maxlength='32'])[2]"));
        assertTrue(phoneLimit.getAttribute("maxlength").contains("32"));
        WebElement addressLimit = driver.findElement(By.xpath("(//div[contains(@class,'second_class')][1]//input[@maxlength='32'])[2]"));
        assertTrue(addressLimit.getAttribute("maxlength").contains("32"));

    }

    @After
    public void tearDown() {
        driver.quit();

    }
}
