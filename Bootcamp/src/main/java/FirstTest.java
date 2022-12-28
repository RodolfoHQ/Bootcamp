import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FirstTest {

    private static WebDriver driver;
    private WebElement Phones;
    private WebElement Categories;
    private WebElement Laptops;
    private WebElement Monitors;
    private WebElement Assertion;
    private WebElement Name;


    public static void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/rh0921/Desktop/Bootcamp/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpClass() { setUpDriver(); }

    @Test(
            testName = "Test DemoBlaze Categories "
    )
    @Description("This test verifies the SRS 12111:\n" +
                 "When opening home page  there must be three categories displayed in the left")
    public void TestDemoBlazeCategories() throws InterruptedException {

        Categories = driver.findElement(By.id("cat"));
        Phones = driver.findElement(By.xpath("//*[@id=\"itemc\"][1]"));
        Laptops =driver.findElement(By.xpath("//*[@id=\"itemc\"][2]"));
        Monitors= driver.findElement(By.xpath("//*[@id=\"itemc\"][3]"));
        Thread.sleep(2000);
        Assert.assertEquals("CATEGORIES", Categories.getText());
        Assert.assertEquals("Phones", Phones.getText());
        Assert.assertEquals("Laptops", Laptops.getText());
        Assert.assertEquals("Monitors", Monitors.getText());
    }

    @Test(
            testName = "Test Catalog Products"
    )
    @Description("This test verifies srs 12120 by validating all " +
                    "options that open when clicking on a product")
    public void TestCatalogProducts() throws InterruptedException{

        Categories = driver.findElement(By.id("cat"));
        Laptops= driver.findElement(By.xpath("//*[@id=\"itemc\"][2]"));
        Laptops.click();
        Thread.sleep(2000);
        Name = driver.findElement(By.linkText("Sony vaio i5"));
        Name.click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Add to cart"));
        driver.findElement(By.id("more-information"));
        driver.findElement(By.className("price-container"));
        driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h2"));
        driver.findElement(By.xpath("//*[@id=\"imgp\"]/div/img"));
        Thread.sleep(2000);
        Assert.assertEquals("Sony vaio i5", Name.getText());


    }

    @Test(
            testName = "Test Cart Button"
    )
    @Description("This test verifies the srs 12121 by validating " +
            "the options that appear when adding a product to the cart.")
    public void TestCartButton() throws InterruptedException{
        Categories = driver.findElement(By.id("cat"));
        driver.findElement(By.xpath("//*[@id=\"itemc\"][3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Apple monitor 24")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(2000);
        String PopUp = driver.switchTo().alert().getText();
        System.out.println(PopUp);
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

    }

    @Test(
            testName = "Test Cart Link"
    )
    @Description("This test verifies the srs 12130 by validating the " +
            "information displayed when you click on the cart.")
    public void TestCartLink() throws InterruptedException{
        driver.findElement(By.id("cat"));
        driver.findElement(By.xpath("//*[@id=\"itemc\"][1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Iphone 6 32gb")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(2000);
        String PopUp = driver.switchTo().alert().getText();
        System.out.println(PopUp);
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.findElement(By.linkText("Cart")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[1]/img"));
        driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr/td[2]"));
        driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[3]"));
        driver.findElement(By.linkText("Delete"));
        driver.findElement(By.id("totalp"));
        driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button")).click();
        Thread.sleep(2000);
    }

}

