package pages.AppPage;

import com.google.j2objc.annotations.Weak;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;
import utils.ReusableMethods;

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

    @FindBy(xpath = "//*[@text='Başarıyla giriş yapıldı.']")
    public MobileElement girisBasariliText;

    @FindBy(xpath = "(//*[@class='android.widget.ImageView'])[1]")
    public MobileElement solUstMenu;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    public MobileElement isimKutusu;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    public MobileElement soyisimKutusu;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[3]")
    public MobileElement sehirKutusu;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[4]")
    public MobileElement yasKutusu;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[5]")
    public MobileElement meslekKutusu;

    public void hesabimBilgiDegisikligi(String isim,String soyisim,String sehir,String yas,String meslek){
        isimKutusu.clear();
        isimKutusu.sendKeys(isim);

        soyisimKutusu.clear();
        soyisimKutusu.sendKeys(soyisim);

        sehirKutusu.clear();
        sehirKutusu.sendKeys(sehir);

        yasKutusu.clear();
        yasKutusu.sendKeys(yas);

        meslekKutusu.clear();
        meslekKutusu.sendKeys(meslek);

        ReusableMethods.scrollWithUiScrollable("Kaydet");
    }

    public void hesapBilgiDegisikligiAssert(){

        String actualIsim=isimKutusu.getText();
        String expectedIsim= ConfigReader.getProperty("isim");
        Assert.assertEquals("Isim ilgileri uyusmuyor",expectedIsim,actualIsim);

        String actualSoyisim=soyisimKutusu.getText();
        String expectedSoyisim= ConfigReader.getProperty("soyisim");
        Assert.assertEquals("Soyisim bilgileri uyusmuyor",expectedSoyisim,actualSoyisim);

        String actualSehir=sehirKutusu.getText();
        String expectedSehir=ConfigReader.getProperty("sehir");
        Assert.assertEquals("Sehir bilgileri uyusmuyor",expectedSehir,actualSehir);

        String actualYas=yasKutusu.getText();
        String expectedYas=ConfigReader.getProperty("yas");
        Assert.assertEquals("Yas bilgileri uyusmuyor",expectedYas,actualYas);

        String actualMeslek=meslekKutusu.getText();
        String expectedMeslek=ConfigReader.getProperty("meslek");
        Assert.assertEquals("Meslek bilgileri uyusmuyor",expectedMeslek,actualMeslek);


    }

    public void girisBasariliMethodu(){
        String actual=girisBasariliText.getText();
        String expected="Başarıyla giriş yapıldı.";
        Assert.assertEquals("Giris basarisiz",expected,actual);
    }
}