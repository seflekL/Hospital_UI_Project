package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.DoctorOPDPage;
import pages.DoctorPage;
import pages.LoginPage;
import utilities.ReusableMethods;

public class DoctorOPDStep {
    WebDriver driver = StepDefinitions.Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(DoctorOPDStep.class);
    DoctorPage doctorPage = new DoctorPage();
    LoginPage loginPage = new LoginPage();
    DoctorOPDPage doctorOPDPage = new DoctorOPDPage();

    @Step("Doktor sidebar'da OPD linkine tıklar")
    @Given("doktor sidebar da OPD linkine tiklanir")
    public void doktor_sidebar_da_opd_linkine_tiklanir() {
        ReusableMethods.bekle(2);
        doctorOPDPage.doctorSidebarOpd.click();
        ReusableMethods.bekle(2);
        doctorOPDPage.OPDpatientBoxDogrulama.isDisplayed();

        logger.info("Doktor sidebar'da OPD linkine tıklandı.");

    }
    @Step("OPD Patient list başlıkları görüntülenmelidir")
    @When("OPD Patient list başlıklari goruntulenmelidir")
    public void opd_patient_list_başlıklari_goruntulenmelidir() {
        logger.info("başlıyor...");
        Assert.assertTrue("name başlığı görüntülendi",doctorOPDPage.OpdName.isDisplayed());
        Assert.assertTrue("patient id başlığı görüntülendi",doctorOPDPage.OpdPatientId.isDisplayed());
        Assert.assertTrue("guardian başlığı görüntülendi",doctorOPDPage.OpdGuardianName.isDisplayed());
        Assert.assertTrue("gender başlığı görüntülendi",doctorOPDPage.OpdGender.isDisplayed());
        Assert.assertTrue("phone başlığı görüntülendi",doctorOPDPage.OpdPhone.isDisplayed());
        Assert.assertTrue("consultant başlığı görüntülendi",doctorOPDPage.OpdConsultant.isDisplayed());
        Assert.assertTrue("last visit başlığı görüntülendi",doctorOPDPage.OpdLastVisit.isDisplayed());
        Assert.assertTrue("total recheckup başlığı görüntülendi",doctorOPDPage.OpdTotalRecheckup.isDisplayed());

        logger.info("OPD Patient list başlıklarının görüntülenmesi doğrulandı.");


        }
    @Step("OPD Patient list sayfasında Search Box olmalı")
    @Then("Opd patient list sayfasida search box olmali")
    public void opd_patient_list_sayfasida_search_box_olmali() {
       Assert.assertTrue("checkbox görünüyor",doctorOPDPage.OpdPatientSearchBox.isDisplayed());
        logger.info("OPD Patient list sayfasında Search Box'ın mevcut olduğu doğrulandı.");

    }
    @Step("Searchbox'a isim girilip arama yapılabilmeli")
    @Then("searchbox a isim girilip arama yapilabilmeli")
    public void searchbox_a_isim_girilip_arama_yapilabilmeli() {
     doctorOPDPage.OpdPatientSearchBox.sendKeys("damla");
     Assert.assertTrue("Hasta bulundu",doctorOPDPage.OpdBulunanHasta.isDisplayed());
        logger.info("Searchbox'a isim girildi ve arama yapıldı.");

    }
    @Step("Patient ID'ye tıklanır ve bir numaralı hasta geldiği doğrulanır")
    @When("patient id e tiklanir ve bir numaralı hasta geldigi dogrulanir")
    public void patient_id_e_tiklanir_ve_bir_numaralı_hasta_geldigi_dogrulanir() {
        doctorOPDPage.OpdPatientId.click();
        Assert.assertTrue("Olivier Thomas bulundu",doctorOPDPage.patientIdBulunanHasta.isDisplayed());
        logger.info("Patient ID'ye tıklandı ve bir numaralı hasta doğrulandı.");

    }
    @Step("Görüntülenecek hasta sayısı seçilir")
    @Then("goruntulenecek hasta sayisi secilir")
    public void goruntulenecek_hasta_sayisi_secilir() {
        doctorOPDPage.OpdGoruntulenecekHastaSayisi.click();
        doctorOPDPage.allHastaSayisi.click();
        logger.info("Görüntülenecek hasta sayısı seçildi.");


    }
    @Step("Show butonuna tıklanır")
    @When("show butonuna tiklanir")
    public void show_butonuna_tiklanir() {
        ReusableMethods.bekle(2);
        Actions actions=new Actions(driver);
        actions.moveToElement(doctorOPDPage.OpdPatientShowButton).click().perform();
        logger.info("show butonuna tiklandi");


    }
    @Step("Overview sayfası görüntülenir")
    @Then("overview sayfasi goruntulenir")
    public void overview_sayfasi_goruntulenir() {
       Assert.assertTrue("Overview sayfasi goruntulendi",doctorOPDPage.doctorOpdOverviewNav.isDisplayed());
        logger.info("Overview sayfasının görüntülendiği doğrulandı.");

    }
    @Step("Visits butonuna tıklanır")
    @Then("visits butonuna tiklanir")
    public void visits_butonuna_tiklanir() {
        doctorOPDPage.doctorOpdVisitButton.click();
        logger.info("Visits butonuna tıklandı.");

    }
    @Then("visits sayfasi acilir")
    public void visits_sayfasi_acilir() {
       Assert.assertTrue("Visits sayfasi acildi",doctorOPDPage.visitTextBox.isDisplayed());
        logger.info("Visits sayfasının açıldığı doğrulandı.");

    }
    @Step("New Visit butonuna tıklanır")
    @Then("new visit butonuna tiklanir")
    public void new_visit_butonuna_tiklanir() {
        doctorOPDPage.newVisitsButton.click();
        logger.info("New Visit butonuna tıklandı.");






    }


}
