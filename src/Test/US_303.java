package Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class US_303 extends BaseDriver {

    @Test
    public void BankaKartıileBaşarısızÖdemeKontrol() {

        driver.get("https://shopdemo.fatfreeshop.com/?");

        WebElement DemoEKitabıSepeteEkle = driver.findElement(By.xpath("(//button[@class='view_product'])[2]"));
        DemoEKitabıSepeteEkle.click();

        WebElement iframe = driver.findElement(By.cssSelector("[class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe);

        WebElement demoBooktext = driver.findElement(By.xpath("//h5[text()='Demo eBook']"));
        Assert.assertTrue("Hatalı işlem", demoBooktext.getText().contains("Demo eBook"));

        WebElement BankaCard = driver.findElement(By.xpath("(//div[@class='Payment-Options']/button)[3]"));
        BankaCard.click();

        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("jekkuputru@gufum.com");
        driver.findElement(By.xpath("//input[@placeholder='Confirm Email']")).sendKeys("jekkuputru@gufum.com");
        driver.findElement(By.xpath("//input[@placeholder='Name On Card']")).sendKeys("ronaldo");

//        WebElement frame=driver.findElement(By.xpath("[name='__privateStripeFrame7683']"));
//        driver.switchTo().frame(frame);
//        WebElement a = driver.findElement(By.xpath("[placeholder='Kart numarası']"));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("[placeholder='Kart numarası']")));
//        a.sendKeys("1111 1111 1111 1111");

//

        for (int i = 1; i < 5; i++) {
            new Actions(driver)
                    .keyDown(Keys.TAB)
                    .keyUp(Keys.TAB)
                    .build()
                    .perform();
        }

        new Actions(driver)
                .sendKeys("1111 1111 1111 1111")
                .build()
                .perform();

        WebElement text = driver.findElement(By.xpath("//*[text()='Pay 0.50 USD']"));
        text.click();
        WebElement kartNumarasiGeceriz = driver.findElement(By.xpath("//span[text()='Kart numaranız geçersiz.']"));
        System.out.println("kartNumarasiGeceriz.getText() = " + kartNumarasiGeceriz.getText());
        Assert.assertTrue("Hatalı işlem", kartNumarasiGeceriz.getText().contains("Kart numaranız geçersiz."));
        BekleKapat();
    }
}
