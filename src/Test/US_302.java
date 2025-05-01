package Test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class US_302 extends BaseDriver {

    @Test
    public void BankaKartıileÖdemeİşlemiHatalıÖdemeSenaryosu() {

        driver.get("https://shopdemo.fatfreeshop.com/?");

        WebElement DemoEKitabıSepeteEkle = driver.findElement(By.xpath("(//button[@class='view_product'])[2]"));
        DemoEKitabıSepeteEkle.click();

        WebElement iframe = driver.findElement(By.cssSelector("[class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe);

        WebElement demoBooktext = driver.findElement(By.xpath("//h5[text()='Demo eBook']"));
        Assert.assertTrue("Hatalı işlem", demoBooktext.getText().contains("Demo eBook"));

        WebElement BankaCard = driver.findElement(By.xpath("(//div[@class='Payment-Options']/button)[3]"));
        BankaCard.click();

        WebElement text = driver.findElement(By.xpath("//*[text()='Pay 0.50 USD']"));
        text.click();

        WebElement uyarıMesajı = driver.findElement(By.xpath("//span[text()='Invalid Email']"));
        System.out.println("uyarıMesajı.getText() = " + uyarıMesajı.getText());

        Assert.assertTrue("Hatalı işlem", uyarıMesajı.getText().contains("Invalid"));


        BekleKapat();
    }
}
