package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Gallery_ContactUsPage;
import utilities.ConfigReader;
import utilities.ReusableMethods;

public class Gallery_ContactUsStep {
    WebDriver driver = StepDefinitions.Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(Gallery_ContactUsStep.class);
    Gallery_ContactUsPage galleryPage = new Gallery_ContactUsPage();

    @Step("Kullanıcı contact_us sayfasına açıldığını doğrular")
    @Then("Kullanici contact_us sayfasina acildigini dogrular")
    public void kullaniciContact_usSayfasinaAcildiginiDogrular() {
        String expectedUrl = "https://qa.heallifehospital.com/page/contact-us";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        logger.info("Kullanıcı contact_us sayfasına açıldığını doğruladı.");

    }

    @Step("Kullanıcı contact_us linkine tıklar")
    @When("Kullanici contact_us linkine tiklar")
    public void kullaniciContact_usLinkineTiklar() {
        galleryPage.contactUsTabElementi.click();
        ReusableMethods.wait(2);
        logger.info("Kullanıcı contact_us linkine tıkladı.");
    }


    @Step("Ana sayfada Gallery menüsüne tıklayın")
    @When("Ana sayfada Gallery menüsüne tıklayın")
    public void ana_sayfada_gallery_menüsüne_tıklayın() {
        galleryPage.galleryLink.click();
        logger.info("Ana sayfada Gallery menüsüne tıklandı.");

    }

    @Step("Kullanıcının Gallery sayfasına yönlendirildiğini doğrulayın")
    @Then("Kullanıcının Gallery sayfasına yönlendirildiğini doğrulayın")
    public void kullanıcının_gallery_sayfasına_yönlendirildiğini_doğrulayın() {
        galleryPage.galleryPageHeader.isDisplayed();
        logger.info("Kullanıcının Gallery sayfasına yönlendirildiği doğrulandı.");

    }

    @Step("{string} bölümüne tıklayın ve ilgili resimlerin sayfada bulunduğunu doğrulayın")
    @When("{string} bölümüne tıklayın ve ilgili resimlerin sayfada bulunduğunu doğrulayın")
    public void bölümüne_tıklayın(String sectionName) {

        for (WebElement section : galleryPage.gallerySectionsList) {
            if (section.getText().startsWith(sectionName)) {
                section.click();
                ReusableMethods.bekle(1);
                Assert.assertFalse("Resimler bulunamadı!", galleryPage.galleryImagesList.isEmpty());
                break;
            }
        }

        driver.navigate().back();
        logger.info("İlgili galeri bölümü kontrol edildi ve resimler doğrulandı.");

    }

    @Step("Kullanıcı ismini girer")
    @And("Kullanıcı ismini girer")
    public void kullanıcıIsminiGirer() {
        galleryPage.Namecontact.sendKeys(ConfigReader.getProperty("Namegulnar"));
        {

        }
        logger.info("Kullanıcı ismini girdi.");

    }

    @Step("Kullanıcı email adresini girer")
    @And("Kullanıcı email adresini girer")
    public void kullanıcıEmailAdresiniGirer() {
        galleryPage.emailContact.sendKeys(ConfigReader.getProperty("gulnarPatName"));
        logger.info("Kullanıcı email adresini girdi.");

    }
    @Step("Kullanıcı subject alanını doldurur")
    @And("Kullanıcı subject alanını doldurur")
    public void kullanıcıSubjectAlanınıDoldurur() {
        galleryPage.Subject.sendKeys(ConfigReader.getProperty("subject"));
        logger.info("Kullanıcı subject alanını doldurdu.");

    }
    @Step("Kullanıcı description alanına mesaj yazar")
    @And("Kullanıcı description alanına mesaj yazar")
    public void kullanıcıDescriptionAlanınaMesajYazar() {
        galleryPage.Description.sendKeys(ConfigReader.getProperty("Description"));
        ReusableMethods.wait(2);
        logger.info("Kullanıcı description alanına mesaj yazdı.");

    }
    @Step("Kullanıcı formu gönderir")
    @Then("Kullanıcı formu gönderir")
    public void kullanıcıFormuGönderir() {
        galleryPage.submit.click();
        logger.info("Kullanıcı formu gönderdi.");

    }
    @Step("Kullanıcı doğrulama mesajını görür")
    @Then("Kulanici dogrulama mesajını görür")
    public void kulaniciDogrulamaMesajınıGörür() {
        galleryPage.dogrulama.isDisplayed();
        logger.info("Kullanıcı doğrulama mesajını gördü.");

    }
    @Step("Haritanın göründüğünü onaylar")
    @And("haritanin görundugunu onaylar")
    public void haritaninGörundugunuOnaylar() {
        galleryPage.Map.click();
        logger.info("Haritanın göründüğünü onayladı.");

    }
    @Step("Drop down ile sayfa aşağı iner")
    @When("drop down sayfa asagı iner")
    public void dropDownSayfaAsagıIner() throws InterruptedException {


        JavascriptExecutor js = (JavascriptExecutor) driver;
        long previousHeight = 0;
        while (true) {
            js.executeScript("window.scrollBy(0, 500);");
            Thread.sleep(100);
            long currentHeight = (Long) js.executeScript("return document.body.scrollHeight;");
            if (currentHeight == previousHeight) break;
            previousHeight = currentHeight;
        }
        logger.info("Sayfa aşağı doğru scroll edildi.");

    }

    @Step("Haritanın göründüğünü tekrar onaylar")
    @And("haritanin görundugununu onaylar")
    public void haritaninGörundugununuOnaylar() {
        galleryPage.Map.click();
        logger.info("Haritanın göründüğünü tekrar onayladı.");







    }
}



