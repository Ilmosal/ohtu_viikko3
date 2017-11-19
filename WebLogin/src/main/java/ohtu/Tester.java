package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;

public class Tester {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "../../../../../Programs/chromedriver"); 
        WebDriver driver = new ChromeDriver();
		Random r = new Random();	

        driver.get("http://localhost:4567");
        
        sleep(2);

        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekkaaa"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("nakkis213");
		element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("nakkis213");

        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();

		element = driver.findElement(By.linkText("continue to application mainpage"));
        
        sleep(2);
		element.click();

		element = driver.findElement(By.linkText("logout"));
        sleep(3);

		element.click();
		sleep(2);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
