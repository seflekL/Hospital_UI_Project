package StepDefinitions;

import io.cucumber.java.en.*;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.AppointmentPage;
import pages.PatientPage;
import utilities.ConfigReader;
import utilities.DriverManager;
import utilities.ReusableMethods;

public class DemoSenaryoStep {

    private static final Logger logger = LogManager.getLogger(StepDefinitions.AdminOPDStep.class);
    PatientPage page = new PatientPage();
    AppointmentPage dashboardPage = new AppointmentPage();
    Actions actions = new Actions(DriverManager.getDriver());


    @Given("John {string} sitesine gider")
    public void john_sitesine_gider(String url) {
        DriverManager.getDriver().get(ConfigReader.getProperty(url));
        logger.info("John HealLife sitesine gider.");
        ReusableMethods.wait(2);
    }
    @Step("John {string} sitesine gider")
    @When("John {string} sayfasına gider")
    public void john_sayfasına_gider(String menü) {
        ReusableMethods.wait(2);
        ReusableMethods.HeaderAccessibility(menü, logger);
    }
    @Step("John Specialist olarak {string} girer")
    @Then("John Specialist olarak {string} girer")
    public void john_specialist_olarak_girer(String specialist) {
        ReusableMethods.wait(2);
        Select select = new Select(page.specialistDDM);
        select.selectByVisibleText(specialist);
        logger.info("John Specialist olarak " + specialist + " secildi.");
    }
    @Step("Doctor olarak {string} girer")
    @Then("Doctor olarak {string} girer")
    public void doctor_olarak_girer(String doctor) {
        ReusableMethods.wait(2);
        Select select = new Select(page.doctorDDM);
        select.selectByVisibleText(doctor);
        logger.info("John Doctor olarak " + doctor + " secildi.");
    }
    @Step("Shift {string} girer")
    @Then("Shift {string} girer")
    public void shift_girer(String shift) {
        ReusableMethods.wait(2);
        Select select = new Select(dashboardPage.shiftSelect);
        select.selectByVisibleText(shift);
        logger.info("John Shift olarak " + shift + " secildi.");
    }
    @Step("Date olarak {string} girer")
    @Then("Date olarak {string} girer")
    public void date_olarak_girer(String date) {
        page.datebox.sendKeys(Keys.DELETE);
        dashboardPage.dateBox.sendKeys(date);
        logger.info("John Date olarak " + date + " secildi.");
    }
    @Step("Message olarak'ta {string} girer")
    @Then("Message olarak'ta {string} girer")
    public void message_olarak_ta_girer(String string) {
        ReusableMethods.wait(2);
        page.messageBoxElementi.sendKeys(string);
        logger.info("John Message olarak " + string + " secildi.");
        ReusableMethods.wait(3);
    }
    @Step("John Randevu ödemesi için Pay butonuna basar")
    @Then("John Randevu ödemesi için Pay butonuna basar")
    public void john_randevu_ödemesi_için_pay_butonuna_basar() {
        ReusableMethods.wait(5);
        page.payButton.click();
        logger.info("John Pay butonuna basildi.");
    }
    @Step("John ödeme için Pay with card butonuna basar")
    @Then("John ödeme için Pay with card butonuna basar")
    public void john_ödeme_için_pay_with_card_butonuna_basar() {
        ReusableMethods.wait(2);
        page.payWithCard.click();
        logger.info("John Pay with card butonuna basildi.");
    }
    @Step("John Email olarak {string}")
    @Then("John Email olarak {string}")
    public void john_email_olarak(String email) {
        ReusableMethods.wait(2);
        page.emailBox.sendKeys(email);
        logger.info("John Email olarak " + email + " secildi.");
    }
    @Step("Card Number olarak {string} girer")
    @Then("Card Number olarak {string} girer")
    public void card_number_olarak_girer(String number) {
        ReusableMethods.wait(2);
        actions.sendKeys(Keys.TAB).sendKeys(number).perform();
        logger.info("John Card Number olarak " + number + " secildi.");
    }
    @Step("MM_YY olarak {string} girer")
    @Then("MM_YY olarak {string} girer")
    public void mm_yy_olarak_girer(String tarih) {
        ReusableMethods.wait(2);
        actions.sendKeys(Keys.TAB).sendKeys(tarih).perform();
        logger.info("John MM_YY olarak " + tarih + " secildi.");
    }
    @Step("CVC olarak'ta {string} girer")
    @Then("CVC olarak'ta {string} girer")
    public void cvc_olarak_ta_girer(String cvc) {
        ReusableMethods.wait(2);
        actions.sendKeys(Keys.TAB).sendKeys(cvc).perform();
        logger.info("John CVC olarak " + cvc + " secildi.");
    }
    @Step("John ödemeyi tamamlamak için Pay butonuna basar")
    @Then("John ödemeyi tamamlamak için Pay butonuna basar")
    public void john_ödemeyi_tamamlamak_için_pay_butonuna_basar() {
        ReusableMethods.wait(2);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        logger.info("John Pay butonuna basildi.");
    }
    @Step("John işlemin doğru olduğundan emin olmak için Success mesajını doğrular")
    @Then("John işlemin doğru olduğundan emin olmak için Success mesajını doğrular")
    public void john_işlemin_doğru_olduğundan_emin_olmak_için_success_mesajını_doğrular() {
        ReusableMethods.wait(2);
        if (page.successMessage.isDisplayed()) {
            logger.info("John Success mesajı görüldü.");
        }else {
            logger.info("John Success mesajı görülmüyor.");
        }
        ReusableMethods.wait(3);
    }
    @Step("John Go To Home butonuna basarak dashboard'a geri döner")
    @Then("John Go To Home butonuna basarak dashboard'a geri döner")
    public void john_go_to_home_butonuna_basarak_anasayfaya_yönlendirilir() {

        page.goToHomeButton.click();
        logger.info("John Go To Home butonuna basıldı.");
    }
    @Step("John Approved yazısını görüp randevunun onaylandığını teyit eder")
    @Then("John Approved yazısını görüp randevunun onaylandığını teyit eder")
    public void john_approved_yazısını_görüp_randevunun_onaylandığını_teyit_eder() {
        ReusableMethods.wait(5);
        if (page.approved.isDisplayed()) {
            logger.info("John Approved yazısı görüldü.");
        }else {
            logger.info("John Approved yazısı görülmüyor.");
        }
    }
    @Step("John kendi profil fotoğrafına basar")
    @Then("John kendi profil fotoğrafına basar")
    public void john_kendi_profil_fotoğrafına_basar() {
        ReusableMethods.wait(2);
        page.profileButton.click();
        logger.info("John Profil fotografına basildi.");
    }
    @Step("John ardından Logout butonuna basarak randevu alma işlemini tamamlar")
    @Then("John ardından Logout butonuna basarak randevu alma işlemini tamamlar")
    public void john_ardından_logout_butonuna_basarak_randevu_alma_işlemini_tamamlar() {
        ReusableMethods.wait(2);
        page.logoutButton.click();
        logger.info("John Logout butonuna basildi.");
    }
    @Step("John Browseri kapatır ve randevu tarihini bekler...")
    @Then("John Browseri kapatır ve randevu tarihini bekler...")
    public void john_browseri_kapatır_ve_randevu_tarihini_bekler() {
        DriverManager.quitDriver();
        logger.info("Browser kapatıldı.");
    }
    @Step("Slot olarak'ta 05:12 PM girer")
    @And("Slot olarak'ta 05:12 PM girer")
    public void slotOlarakTaPMGirer() {
        page.slot7_00.click();
        logger.info("John Slot olarak 05:00 PM secildi.");
        ReusableMethods.wait(4);
    }
    @Step("Slot seçimi için Slot butonuna basar")
    @And("Slot seçimi için Slot butonuna basar")
    public void slotSeçimiIçinSlotButonunaBasar() {
        page.slotButton.click();
        logger.info("John Slot belirleme butonuna basildi.");
    }
    @Step("Patient Name olarak {string} girer")
    @Then("Patient Name olarak {string} girer")
    public void patient_name_olarak_girer(String isim) {
        page.patientNameBox.sendKeys(isim);
        ReusableMethods.wait(1);
    }
    @Step("Email olarak {string} girer")
    @Then("Email olarak {string} girer")
    public void email_olarak_girer(String email) {
        page.Emaileboxelementi.sendKeys(email);
        ReusableMethods.wait(1);
    }
    @Step("Phone olarak {string} girer")
    @Then("Phone olarak {string} girer")
    public void phone_olarak_girer(String phone) {
        page.phoneboxElementi.sendKeys(phone);
        ReusableMethods.getFullScreenshot(DriverManager.getDriver());
    }
    @Step("John Email olarak {string} girer")
    @And("John Email olarak {string} girer")
    public void johnEmailOlarakGirer(String email) {
        ReusableMethods.wait(2);
        actions.sendKeys(email).perform();
        logger.info("John Email olarak " + email + " secildi.");
    }
    @Step("John randevu talebi için Submit butonuna basar")
    @And("John randevu talebi için Submit butonuna basar")
    public void johnRandevuTalebiIçinSubmitButonunaBasar() {
        page.SubmitButtonElementi.click();
        logger.info("John Submit butonuna basildi.");
        ReusableMethods.wait(3);
    }
    @Step("Zip Code olarak'ta {string} girer")
    @And("Zip Code olarak'ta {string} girer")
    public void zipCodeOlarakTaGirer(String zipCode) {
        ReusableMethods.wait(2);
        actions.sendKeys(Keys.TAB).sendKeys(zipCode).perform();
        logger.info("John Zip Code olarak " + zipCode + " secildi.");
    }

    @And("Doctor olarak Levent S girer")
    public void doctorOlarakLeventSGirer() {

    }
}
