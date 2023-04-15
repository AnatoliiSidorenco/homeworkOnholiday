package homework.check_word_spelling;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckWordSpelling {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\EducationProg\\seleniumchromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://suninjuly.github.io/registration1.html");
    }

    @Test
    public void checkAllWordsSpelling() {
        WebElement headerWordCheck = driver.findElement(By.tagName("h1")); //todo проверка текста Registration
        assertEquals("Registration", headerWordCheck.getText());

        WebElement paragraphWordCheck = driver.findElement(By.xpath("//p"));//todo проверка текста под Registration
        assertEquals("Please submit some information about you below:", paragraphWordCheck.getText());

        // todo -----------------------------------First name field------------------------------------------------------------------------------
        WebElement firstNameWordCheck = driver.findElement(By.xpath("(//div[contains(@class,'first_class')]/label)[1]"));
        assertTrue(firstNameWordCheck.getText().contains("*")); // todo проверка или содержит *
        assertEquals("First name*", firstNameWordCheck.getText());// todo проверка  First name*

        WebElement firstNameBackWordCheck = driver.findElement(By.xpath("//input[contains(@placeholder,'Input your first name')]"));//todo проверка текста подсказка
        assertTrue(firstNameBackWordCheck.getAttribute("placeholder").contains("Input your first name"));

        // todo -----------------------------------Last name field------------------------------------------------------------------------------
        WebElement lastNameWordCheck = driver.findElement(By.xpath("(//div[contains(@class,'second_class')]/label)[1]"));
        assertTrue(lastNameWordCheck.getText().contains("*")); // todo проверка или содержит *
        assertEquals("Last name*", lastNameWordCheck.getText());// todo проверка  Last name*

        WebElement lastNameBackWordCheck = driver.findElement(By.xpath("//input[contains(@placeholder,'Input your last name')]"));//todo проверка текста подсказка
        assertTrue(lastNameBackWordCheck.getAttribute("placeholder").contains("Input your last name"));

        // todo -----------------------------------Email field----------------------------------------------------------------------------------
        WebElement emailWordCheck = driver.findElement(By.xpath("(//div[contains(@class,'third_class')]/label)[1]"));
        assertTrue(emailWordCheck.getText().contains("*")); // todo проверка или содержит *
        assertEquals("Email*", emailWordCheck.getText());// todo проверка Email*

        WebElement emailBackWordCheck = driver.findElement(By.xpath("//input[contains(@placeholder,'Input your email')]"));//todo проверка текста подсказка
        assertTrue(emailBackWordCheck.getAttribute("placeholder").contains("Input your email"));

        // todo -----------------------------------Phone field----------------------------------------------------------------------------------
        WebElement phoneWordCheck = driver.findElement(By.xpath("(//div[contains(@class,'first_class')]/label)[2]"));
        assertTrue(phoneWordCheck.getText().contains(":")); // todo проверка или содержит :
        assertEquals("Phone:", phoneWordCheck.getText());// todo проверка  Phone:

        WebElement phoneBackWordCheck = driver.findElement(By.xpath("//input[contains(@placeholder,'Input your phone')]"));//todo проверка текста подсказка
        assertTrue(phoneBackWordCheck.getAttribute("placeholder").contains("Input your phone"));

        // todo -----------------------------------Address field----------------------------------------------------------------------------------
        WebElement addressWordCheck = driver.findElement(By.xpath("(//div[contains(@class,'second_class')]/label)[2]"));
        assertTrue(addressWordCheck.getText().contains(":")); // todo проверка или содержит :
        assertEquals("Address:", addressWordCheck.getText());// todo проверка  Address:

        WebElement addressBackWordCheck = driver.findElement(By.xpath("//input[contains(@placeholder,'Input your address')]"));//todo проверка текста подсказка
        assertTrue(addressBackWordCheck.getAttribute("placeholder").contains("Input your address"));

        // todo -----------------------------------button Submit----------------------------------------------------------------------------------
        WebElement buttonSubmitWordCheck = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        assertTrue(buttonSubmitWordCheck.getText().contains("Submit"));

    }

    @After
    public void tearDown() {
        driver.quit();

    }

}
