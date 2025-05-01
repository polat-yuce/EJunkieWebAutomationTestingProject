package Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.print.Book;

public class US_301 extends BaseDriver {

    @Test
    public void EJunkieDemoSitesiEBookSepetiFunctionalityTesti() {

        driver.get("https://shopdemo.fatfreeshop.com/?");

        WebElement DemoEKitabıSepeteEkle = driver.findElement(By.xpath("(//button[@class='view_product'])[2]"));
        DemoEKitabıSepeteEkle.click();

        WebElement iframe = driver.findElement(By.cssSelector("[class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe);

        WebElement demoBooktext=driver.findElement(By.xpath("//h5[text()='Demo eBook']"));
        Assert.assertTrue("Hatalı işlem",demoBooktext.getText().contains("Demo eBook"));

        WebElement AddPromoCode = driver.findElement(By.xpath("//button[text()='Add Promo Code']"));
        wait.until(ExpectedConditions.elementToBeClickable(AddPromoCode));
        AddPromoCode.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Promo Code']")));
        WebElement promoCode = driver.findElement(By.xpath("//input[@placeholder='Promo Code']"));
        promoCode.sendKeys("geçersiz");

        WebElement apply = driver.findElement(By.xpath("//button[text()='Apply']"));
        apply.click();

        WebElement text = driver.findElement(By.xpath("//span[text()='Invalid promo code']"));
        Assert.assertTrue("Hatalı işlem.", text.getText().contains("Invalid"));

        BekleKapat();


    }
}
