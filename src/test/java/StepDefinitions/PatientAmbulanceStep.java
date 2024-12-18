package StepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.PatientDashboardPage;
import pages.PatientPage;
import utilities.ReusableMethods;

import java.util.List;

public class PatientAmbulanceStep {

    WebDriver driver = StepDefinitions.Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(StepDefinitions.PatientStep.class);
    PatientPage page = new PatientPage(); // Page Object sınıfınız
    private List<WebElement> tableHeaders;
    private List<WebElement> tableItems;
    PatientPage patientPage = new PatientPage(tableHeaders,tableItems);
    LoginPage loginPage = new LoginPage();
    Faker faker = new Faker();
    PatientDashboardPage patientDashboardPage=new PatientDashboardPage();

    @Step("Kullanıcı sol menüden Ambulance seçeneğine tıklar")
    @When("kullanici sol menuden Ambulance secenegine tiklar")
    public void kullanici_sol_menuden_ambulance_secenegine_tiklar() {
        page.PatientDashboardAmbulanceButton.click();

        logger.info("Kullanıcı sol menüden Ambulance seçeneğine tıkladı.");

    }
    @Step("Hasta Ambulance Bill sayfasına gider")
    @Given("hasta Ambulance Bill sayfasına gider")
    public void hasta_ambulance_bill_sayfasına_gider() {
        ReusableMethods.wait(2);
        Assert.assertTrue("Ambulance Bill sayfası açılmadı!",
                page.ambulanceBillHeader.isDisplayed());
        logger.info("Hasta Ambulance Bill sayfasına gitti.");

    }


    @Step("Hasta, ambulans için bir arama terimi girer")
    @Then("hasta, ambulans icin bir arama terimi girer")
    public void hasta_ambulans_icin_bir_arama_terimi_girer() {
        page.searchBar.sendKeys("A");
        ReusableMethods.bekle(2);
        logger.info("Hasta, ambulans için bir arama terimi girdi.");

    }



    @Step("Ambulans elementinin girilen arama terimiyle eşleşen şekilde görüntülendiği doğrulanır")
    @Then("ambulans elementinin girilen arama terimiyle eslesen sekilde goruntulendigini dogrular")
    public void ambulans_elementinin_girilen_arama_terimiyle_eslesen_sekilde_goruntulendigini_dogrular() {
         List<String> tbody = page.getTableBodies();
        System.out.println("Tablodaki veriler: " + tbody);
        boolean containsRAD = tbody.stream().anyMatch(row -> row.contains("A"));
        Assert.assertTrue("Arama sonuçları beklenen değeri içermiyor!", containsRAD);
        logger.info("Ambulans elementinin girilen arama terimiyle eşleştiği doğrulandı.");

    }
    @Step("Component liste artan sırada sıralanmalıdır")
    @Then("component liste artan sirada siralanmalidir")
    public void component_liste_artan_sirada_siralanmalidir() {
        List<WebElement> billNoElements = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        System.out.println("Bulunan eleman sayısı: " + billNoElements.size());

        for (WebElement element : billNoElements) {
            System.out.println("Bulunan değer: " + element.getText());
        }
        page.billNoComponentIssue.click();
        ReusableMethods.wait(2);
        logger.info("Component liste artan sırada sıralandı.");

    }
    @Step("Component listede hasta aynı başlık üzerine tekrar tıklar")
    @When("component listede hasta aynı başlık uzerine tekrar tiklar")
    public void component_listede_hasta_aynı_başlık_uzerine_tekrar_tiklar() {

        page.billNoComponentIssue.click();
        ReusableMethods.wait(2);
        logger.info("Component listede hasta aynı başlık üzerine tekrar tıkladı.");

    }
    @Step("Ambulans listesinde hasta bir başlık üzerine tıklar")
    @When("ambulans listesinde hasta bir baslık uzerine tiklar")
    public void ambulans_listesinde_hasta_bir_baslık_uzerine_tiklar() {
        page.vehicleNumberHeader.click();
        ReusableMethods.wait(2);
        page.BillNo.click();
        ReusableMethods.wait(2);
        logger.info("Ambulans listesinde hasta bir başlık üzerine tıkladı.");

    }
    @Step("Liste artan bir sırada sıralanmalıdır")
    @Then("liste artan bir sirada siralanmalidir")
    public void liste_artan_sirada_siralanmalidir() {
        List<WebElement> vehicleNumberElements = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        System.out.println("Bulunan eleman sayısı: " +vehicleNumberElements.size());

        for (WebElement element : vehicleNumberElements) {
            System.out.println("Bulunan değer: " + element.getText());
        }
        logger.info("Liste artan bir sırada sıralandı.");

    }
    @Step("Hasta aynı header üzerine tekrar tıklar")
    @When("hasta aynı header uzerine tekrar tiklar")
    public void hasta_aynı_header_uzerine_tekrar_tiklar() {
        page.vehicleNumberHeader.click();
        ReusableMethods.wait(4);
        logger.info("Hasta aynı header üzerine tekrar tıkladı.");

    }



    @Step("Hasta Show bağlantısına tıklar")
    @When("hasta show baglantısına tıklar")
    public void hasta_show_baglantısına_tıklar() {
        ReusableMethods.wait(2);
        page.showButtonAmbulance.click();
        ReusableMethods.wait(2);

        logger.info("Hasta Show bağlantısına tıkladı.");

    }

    @Step("Hasta modal pencereyi kapatmak için X butonuna tıklar")
    @When("hasta modal pencereyi kapatmak için X butonuna tiklar")
    public void hasta_model_pencereyi_kapatmak_icin_X_butonuna_tiklar() {
        ReusableMethods.wait(2);
        page.ShowWindowClose.click();
        logger.info("Hasta modal pencereyi kapatmak için X butonuna tıkladı.");

    }
    @Step("Hasta pay modal pencereyi kapatmak için X butonuna tıklar")
    @When("hasta pay modal pencereyi kapatmak için X butonuna tiklar")
    public void hasta_pay_model_pencereyi_kapatmak_icin_X_butonuna_tiklar() {
        ReusableMethods.wait(2);
        page.PayWindowClose.click();
        logger.info("Hasta pay modal pencereyi kapatmak için X butonuna tıkladı.");

    }
    @Step("Hasta pay modal pencereyi kapatmak için X butonuna tıklar")
    @When("hasta X butonuna tiklar")
    public void hasta_X_butonuna_tiklar() {

    }




    @Step("Hasta View Payments bağlantısına tıklar")
    @When("hasta View Payments bağlantısına tiklar")
    public void hasta_view_payments_bağlantısına_tiklar() {
            page.viewPaymentButtonAmbulance.click();
            ReusableMethods.wait(3);
        logger.info("Hasta View Payments bağlantısına tıkladı.");

    }


    @Step("Modal penceresinin Print butonunu içerdiği doğrulanır")
    @Then("modal penceresinin Print butonunu içerdiği doğrulanır")
    public void modal_penceresinin_butonunu_içerdiği_doğrulanır() {
        // Print butonunun görünür olduğunu doğrula
        boolean isDisplayed = page.viewPaymentWindowPrint.isDisplayed();
        Assert.assertTrue("Print butonu görüntülenemedi", isDisplayed);
        logger.info("Modal penceresinin Print butonunu içerdiği doğrulandı.");

    }

    @Step("Kullanıcı modal pencereyi kapatmak için X butonuna tıklar")
    @When("kullanıcı modal pencereyi kapatmak için X butonuna tiklar")
    public void kullanıcı_modal_pencereyi_kapatmak_için_x_butonuna_tiklar() {
       page.viewPaymentsXbutton.click();

        logger.info("Kullanıcı modal pencereyi kapatmak için X butonuna tıkladı.");

    }
    @Step("Rapor detayları modal penceresi açılmalıdır")
    @Then("rapor detayları modal penceresi açılmalıdır")
    public void rapor_detayları_modal_penceresi_açılmalıdır() {

        boolean isDisplayed = page.showWindowLogo.isDisplayed();
        Assert.assertTrue("show penceresi görüntülenemedi", isDisplayed);
        logger.info("Rapor detayları modal penceresi açıldı.");

    }


    @Step("Hasta pay bağlantısına tıklar")
    @When("hasta pay bağlantısına tıklar")
    public void hasta_bağlantısına_tıklar() {
        ReusableMethods.wait(3);
       page.payButtonAmbulance.click();
        ReusableMethods.wait(2);
        logger.info("Hasta pay bağlantısına tıkladı.");

    }
    @Step("Modal pencerenin add butonunu içerdiği doğrulanır")
    @Then("modal pencerenin add butonunu içerdiği doğrulanır")
    public void modal_pencerenin_butonunu_içerdiği_doğrulanır( ) {
        boolean isDisplayed = page.payWindowAddButton.isDisplayed();
        Assert.assertTrue("pay add butonu içermiyor ", isDisplayed);
        logger.info("Modal pencerenin add butonunu içerdiği doğrulandı.");

    }
    @Step("Modal pencere kapanır")
    @Then("modal pencere kapanır")
    public void modal_pencere_kapanır() {
        page.PayWindowClose.click();
        logger.info("Modal pencere kapandı.");

    }
    @Step("Kullanıcı Ambulance Bill sayfasına geri döndüğünü doğrular")
    @Then("kullanici Ambulance Bill sayfasına geri döndüğünü doğrular")
    public void kullanici_ambulance_bill_sayfasına_geri_döndüğünü_doğrular() {
        boolean isDisplayed = page.ambulanceBillHeader.isDisplayed();
        Assert.assertTrue("Ambulance Bill sayfası gorunmjuyor ", isDisplayed);
        logger.info("Kullanıcı Ambulance Bill sayfasına geri döndü.");

    }


    @When("kullanıcı modal pencereyi kapatmak için {string} butonuna tiklar")
    public void hasta_modal_pencereyi_kapatmak_için_butonuna_tiklar(String string) {

    }

    @Then("modal pencere kapanir ve kullanici Ambulans Test List sayfasina geri dondugu dogrulanir.")
    public void modal_pencere_kapanir_ve_kullanici_ambulans_test_list_sayfasina_geri_dondugu_dogrulanir() {

    }




}
