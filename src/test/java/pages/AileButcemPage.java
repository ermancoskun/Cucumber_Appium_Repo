package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.security.cert.X509Certificate;
import java.time.Duration;

public class AileButcemPage {
    public AileButcemPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAndroidDriver(), Duration.ofSeconds(15)), this);
    }

    @FindBy(xpath = "//*[@text='E-mail Adresi']")
    public MobileElement mailBox;

    @FindBy(xpath = "//*[@text='Şifre']")
    public MobileElement passwordBox;

    @FindBy(id = "text2")
    public MobileElement girisBasariliText;

    public void girisBasariliMethodu(){
        String actual=girisBasariliText.getText();
        String expected="Başarıyla giriş yapıldı.";
        Assert.assertEquals("Giris basarisiz",expected,actual);
    }
}