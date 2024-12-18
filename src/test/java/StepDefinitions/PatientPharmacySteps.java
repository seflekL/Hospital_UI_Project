package StepDefinitions;

import io.cucumber.java.en.*;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import pages.PatientDashboardPage;
import pages.PatientPharmacyPage;
import utilities.ReusableMethods;

import java.util.List;


public class PatientPharmacySteps {

    WebDriver driver = StepDefinitions.Hooks.getDriver();
    private List<WebElement> tableHeaders;
    private List<WebElement> tableItems;
    PatientPharmacyPage patientPharmacyPage = new PatientPharmacyPage(tableHeaders,tableItems);
    PatientDashboardPage patientDashboardPage = new PatientDashboardPage();
    private static final Logger logger = LogManager.getLogger(StepDefinitions.PatientStep.class);

    @Step("Kullanıcı sol menüden Pharmacy seçeneğine tıklar")
    @When("kullanici sol menuden Pharmacy secenegine tiklar")
    public void kullanici_sol_menuden_secenegine_tiklar() {
        patientDashboardPage.PharmacySideBarButton.click();
        logger.info("Kullanıcı sol menüden Pharmacy seçeneğine tıkladı.");

    }
    @Step("Pharmacy sayfasının düzgün bir şekilde görüntülendiğini doğrular")
    @Then("Pharmacy sayfasinin duzgun bir sekilde goruntulendigini dogrular")
    public void pharmacy_sayfasinin_duzgun_bir_sekilde_goruntulendigini_dogrular() {
        Assert.assertTrue(driver.getCurrentUrl().contains("pharmacy"));
        logger.info("Pharmacy sayfasının düzgün bir şekilde görüntülendiği doğrulandı.");

    }
    @Step("Kullanıcı aşağıdaki tablo başlıklarının görüntülendiğini doğrular: {expectedHeaders}")
    @Then("kullanici aşagidaki tablo basliklarinin goruntulendigini dogrular:")
    public void kullanici_asagidaki_tablo_basliklarinin_goruntulendigini_dogrular(List<String> expectedHeaders) {
        List<String> actualHeaders = patientPharmacyPage.getTableHeaders();
        Assertions.assertEquals(expectedHeaders, actualHeaders, "Column headers do not match!");
        logger.info("Kullanıcı aşağıdaki tablo başlıklarının görüntülendiğini doğruladı: {expectedHeaders}");

    }
    @Step("Kullanıcı arama çubuğuna bir öğenin içeriğinin ilk 3 harfini yazar")
    @When("kullanici arama cubuguna bir ogenin iceriginin ilk 3 harfini yazar")
    public void kullanici_arama_cubuguna_bir_ogenin_ilk_harfini_yazar() {
        patientPharmacyPage.searchBar.sendKeys("PAT");
        ReusableMethods.bekle(2);
        logger.info("Kullanıcı arama çubuğuna bir öğenin içeriğinin ilk 3 harfini yazdı.");

    }
    @Step("Arama sonuçlarının doğru bir şekilde görüntülendiğini doğrular")
    @Then("arama sonuçlarinin dogru bir sekilde goruntulendigini dogrular")
    public void arama_sonuclarinin_dogru_bir_sekilde_goruntulendigini_dogrular() {
        Assert.assertTrue(patientPharmacyPage.getTableBodies().contains("PAT"));
        logger.info("Arama sonuçlarının doğru bir şekilde görüntülendiği doğrulandı.");

    }
    @Step("Kullanıcı Actions sütunundaki View Payments butonuna tıklar")
    @When("kullanici Actions sutunundaki View Payments butonuna tiklar")
    public void kullanici_Actions_sutunundaki_View_Payments_butonuna_tiklar() {
            patientPharmacyPage.viewPaymentsButton.click();
            ReusableMethods.waitForClickablility(patientPharmacyPage.viewPaymentsWindowTitle, 10);
        logger.info("Kullanıcı Actions sütunundaki View Payments butonuna tıkladı.");

    }
    @Step("View Payments butonunun düzgün çalıştığını doğrular")
    @When("View Payments butonunun duzgun calistigini dogrular")
    public void View_Payments_butonun_duzgun_calistigini_dogrular() {
        Assertions.assertTrue(patientPharmacyPage.viewPaymentsWindowTitle.isDisplayed());
        patientPharmacyPage.viewPaymentsXbutton.click();

        logger.info("View Payments butonunun düzgün çalıştığı doğrulandı.");

    }
    @Step("Kullanıcı Actions sütunundaki Show butonuna tıklar")
    @When("kullanici Actions sutunundaki Show butonlarina butonuna tiklar")
    public void kullanici_Actions_sutunundaki_Show_butonuna_tiklar() {
        patientPharmacyPage.showButton.click();
        ReusableMethods.waitForClickablility(patientPharmacyPage.showWindowTitle, 10);
        logger.info("Kullanıcı Actions sütunundaki Show butonuna tıkladı.");

    }
    @Step("Show butonunun düzgün çalıştığını doğrular")
    @When("Show butonunun duzgun calistigini dogrular")
    public void show_butonun_duzgun_calistigini_dogrular() {
        Assertions.assertTrue(patientPharmacyPage.showWindowTitle.isDisplayed());
        logger.info("Show butonunun düzgün çalıştığı doğrulandı.");

    }
    @Step("Kullanıcı bir öğenin Pay düğmesine tıklar")
    @When("kullanici bir ogenin Pay dugmesine tiklar")
    public void kullanici_bir_ogenin_dugmesine_tiklar() {
            patientPharmacyPage.firstPayButton.click();
            logger.info("Kullanıcı bir öğenin Pay düğmesine tıkladı.");

    }
    @Step("Ödeme penceresine negatif bir miktar girer ve Add düğmesine tıklar")
    @And("odeme penceresine negatif bir miktar girer ve Add dugmesine tiklar")
    public void odeme_penceresine_negatif_bir_miktar_girer_ve_dugmesine_tiklar() {
        patientPharmacyPage.paymentInput.clear();
        patientPharmacyPage.paymentInput.sendKeys("-10");
        patientPharmacyPage.addButton.click();
        logger.info("Ödeme penceresine negatif bir miktar girip Add düğmesine tıkladı.");

    }
    @Step("Sayfanın bu girişimi reddettiğini ve sağ üst köşede hata mesajı çıktığını doğrular")
    @Then("sayfanin bu girisimi reddettigini ve sag ust kosede error mesaji ciktigini dogrular")
    public void sayfanin_bu_girisimi_reddettigini_ve_sag_ust_kosede_mesaji_ciktigini_dogrular() {
        Assert.assertTrue(patientPharmacyPage.errorMessage.isDisplayed());
        logger.info("Sayfanın bu girişimi reddettiğini ve sağ üst köşede hata mesajı çıktığını doğruladı.");

    }
    @Step("Ödeme penceresine rakam olmayan bir karakter girer ve Add düğmesine tıklar")
    @When("odeme penceresine rakam olmayan bir karakter girer ve Add dugmesine tiklar")
    public void odeme_penceresine_rakam_olmayan_bir_karakter_girer_ve_Add_dugmesine_tiklar() {
        patientPharmacyPage.paymentInput.clear();
        patientPharmacyPage.paymentInput.sendKeys("*");
        patientPharmacyPage.addButton.click();
        logger.info("Ödeme penceresine rakam olmayan bir karakter girip Add düğmesine tıkladı.");

    }
    @Step("Ödeme penceresine miktar olarak 0 girer ve Add düğmesine tıklar")
    @When("odeme penceresine miktar olarak 0 girer ve Add dugmesine tiklar")
    public void odemePenceresineMiktarOlarakGirerVeAddDugmesineTiklar() {
        patientPharmacyPage.paymentInput.clear();
        patientPharmacyPage.paymentInput.sendKeys("0");
        patientPharmacyPage.addButton.click();
        logger.info("Ödeme penceresine miktar olarak 0 girip Add düğmesine tıkladı.");

    }
    @Step("Ödeme penceresine bakiye miktarından daha büyük bir miktar olarak {arg0} girer ve Add düğmesine tıklar")
    @When("odeme penceresine bakiye miktarindan daha buyuk bir miktar olarak {int} girer ve Add dugmesine tiklar")
    public void odemePenceresineBakiyeMiktarindanDahaBuyukBirMiktarOlarakGirerVeAddDugmesineTiklar(int arg0) {
        patientPharmacyPage.paymentInput.clear();
        patientPharmacyPage.paymentInput.sendKeys(String.valueOf(arg0));
        patientPharmacyPage.addButton.click();
        logger.info("Ödeme penceresine bakiye miktarından daha büyük bir miktar olarak {arg0} girip Add düğmesine tıkladı.");

    }
    @Step("Ödeme penceresini boş bırakır ve Add düğmesine tıklar")
    @When("odeme penceresini bos birakir ve Add dugmesine tiklar")
    public void odemePenceresiniBosBirakirVeAddDugmesineTiklar() {
        patientPharmacyPage.addButton.click();
        logger.info("Ödeme penceresini boş bırakıp Add düğmesine tıkladı.");

    }
    @Step("Ödeme penceresine miktar girer (full or partial amount) ve Add'e tıklar")
    @And("odeme penceresine miktar girer \\(full or partial amount) ve Add e tiklar")
    public void odeme_penceresine_miktar_girer_ve_e_tiklar() {
       // patientPharmacyPage.paymentInput.sendKeys("50"); //boş kalsın
        patientPharmacyPage.addButton.click();
        ReusableMethods.wait(2);
        logger.info("Ödeme penceresine miktar girip Add'e tıkladı.");

    }
    @Step("Ödeme detayları sayfasının açıldığını doğrular")
    @Then("odeme detaylari sayfasinin acildigini dogrular")
    public void odemeDetaylariSayfasininAcildiginiDogrular() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/patient/payment/stripe"));
        logger.info("Ödeme detayları sayfasının açıldığını doğruladı.");



    }
}
