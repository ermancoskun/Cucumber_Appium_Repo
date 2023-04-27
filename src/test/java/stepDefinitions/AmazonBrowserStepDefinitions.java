package stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.BrowserPage.AmazonPage;
import utils.BrowserDriver;
import utils.Driver;

import java.security.Key;

public class AmazonBrowserStepDefinitions {
    AmazonPage amazonPage=new AmazonPage();
    @Given("Kullanici {string} adresine gider")
    public void kullanici_adresine_gider(String url) {
        BrowserDriver.getBrowserDriver().get(url);
    }

    @Given("Kullanici arama kutusunda {string} aratir")
    public void kullanici_arama_kutusunda_aratir(String aranacakKelime) {
        amazonPage.amazonAramaKutusu.sendKeys(aranacakKelime+ Keys.ENTER);


    }


}
