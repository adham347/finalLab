import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class guiTest {
    static WebDriver webDriver;
    static final String Website = "https://formy-project.herokuapp.com/form";

    @BeforeAll
    public static void SetUpAll() {
        WebDriverManager.edgedriver().setup();
        webDriver = new EdgeDriver();
        webDriver.get(Website);
    }

    @Test
    public void FirstNameTest(){
        WebElement firstName = webDriver.findElement(By.id("first-name"));
        firstName.sendKeys("Adham");
        assertEquals("Adham", firstName.getAttribute("value"));
    }
    @Test
    public void lastNameTest(){
        WebElement lastName = webDriver.findElement(By.id("last-name"));
        lastName.sendKeys("reda");
        assertEquals("reda", lastName.getAttribute("value"));
    }

    @Test
    public void jobTitleTest(){
        WebElement jobTitle = webDriver.findElement(By.id("job-title"));
        jobTitle.sendKeys("Student");
        assertEquals("Student",jobTitle.getAttribute("value"));
    }
    @Test
    public void educationTest(){
        WebElement highSchool = webDriver.findElement(By.id("radio-button-2"));
        highSchool.click();
        assertEquals(true,highSchool.isSelected());
    }
    @Test
    public void sexTest(){
        WebElement sex= webDriver.findElement((By.id("checkbox-1")));
        sex.click();
        assertEquals(true,sex.isSelected());
    }

    @AfterAll
    public static void afterAll(){
        WebElement btn = webDriver.findElement(By.className("btn"));
        btn.click();

    }
}
