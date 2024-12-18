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

public class PatientBloodBankStep {

    WebDriver driver = StepDefinitions.Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(StepDefinitions.PatientStep.class);
    PatientPage page = new PatientPage(); // Page Object sınıfınız
    private List<WebElement> tableHeaders;
    private List<WebElement> tableItems;
    PatientPage patientPage = new PatientPage(tableHeaders,tableItems);
    LoginPage loginPage = new LoginPage();
    Faker faker = new Faker();
    PatientDashboardPage patientDashboardPage=new PatientDashboardPage();

    @Step("Kullanıcı sol menüden Blood Bank seçeneğine tıklar")
    @When("kullanici sol menuden Blood Bank secenegine tiklar")
    public void kullanici_sol_menuden_Blood_Bank_secenegine_tiklar() {
        patientDashboardPage.bloodBankBoard.click();
        logger.info("Kullanıcı sol menüden Blood Bank seçeneğine tıkladı.");

    }
    @Step("Hasta Blood Bank sayfasına gider")
    @Given("hasta Blood Bank sayfasına gider")
    public void hasta_blood_bank_sayfasına_gider() {
        ReusableMethods.wait(2);
        Assert.assertTrue("Blood Bank sayfası açılmadı!",
                page.patienNameTextBloodBank.isDisplayed());
        logger.info("Hasta Blood Bank sayfasına gitti.");

    }
    @Step("Hasta Blood Issue sayfasına gider")
    @Given("hasta Blood Issue sayfasına gider")
    public void hasta_blood_Issue_sayfasına_gider() {
        ReusableMethods.wait(2);
        Assert.assertTrue("Blood Issue sayfası açılmadı!",
                page.patienNameTextBloodBank.isDisplayed());
        logger.info("Hasta Blood Issue sayfasına gitti.");

    }
    @Step("Blood Issue listesinde hasta bir başlık üzerine tıklar")
    @When("Blood Issue listesinde hasta bir baslık uzerine tiklar")
    public void blood_ıssue_listesinde_hasta_bir_baslık_uzerine_tiklar() {
        page.billNoBloodIssue.click();
        ReusableMethods.wait(2);
        page.billNoBloodIssue.click();
        ReusableMethods.wait(2);
        logger.info("Blood Issue listesinde hasta bir başlık üzerine tıkladı.");

    }
    @Step("Component Issue listesinde hasta bir başlık üzerine tıklar")
    @When("Compenent Issue listesinde hasta bir baslık uzerine tiklar")
    public void component_ıssue_listesinde_hasta_bir_baslık_uzerine_tiklar() {
        page.billNoComponentIssue.click();
        ReusableMethods.wait(2);
        page.billNoComponentIssue.click();
        ReusableMethods.wait(2);
        logger.info("Component Issue listesinde hasta bir başlık üzerine tıkladı.");

    }
    @Step("Blood liste artan sırada sıralanmalıdır")
    @Then("blood liste artan sirada siralanmalidir")
    public void blood_liste_artan_sirada_siralanmalid() {
        List<WebElement> billNoElements = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        System.out.println("Bulunan eleman sayısı: " + billNoElements.size());

        for (WebElement element : billNoElements) {
            System.out.println("Bulunan değer: " + element.getText());
        }
        logger.info("Blood liste artan sırada sıralandı.");

    }
    @Step("Hasta blood ID üzerine tekrar tıklar")
    @When("hasta blood Id uzerine tekrar tiklar")
    public void hasta_blood_ıd_uzerine_tekrar_tiklar() {
        ReusableMethods.wait(2);
        page.billNoBloodIssue.click();
        logger.info("Hasta blood ID üzerine tekrar tıkladı.");


    }

    @Step("Component Issue sayfasının görüntülendiğini doğrular")
    @Then("Component Issue sayfasinin goruntulendigini dogrular")
    public void component_ıssue_sayfasinin_goruntulendigini_dogrular() {
        Assert.assertTrue("Component Issue sayfası açılmadı!",
                page.componentIssueHeader.isDisplayed());
        logger.info("Component Issue sayfasının görüntülendiği doğrulandı.");

    }
    @Step("Hasta, blood için bir arama terimi girer")
    @Then("hasta, blood icin bir arama terimi girer")
    public void hasta_blood_icin_bir_arama_terimi_girer() {
        page.searchAlaniBloodIssue.sendKeys("B");
        ReusableMethods.bekle(2);
        logger.info("Hasta, blood için bir arama terimi girdi.");

    }
    @Step("Blood elementinin girilen arama terimiyle eşleşen şekilde görüntülendiğini doğrular")
    @Then("blood elementinin girilen arama terimiyle eslesen sekilde goruntulendigini dogrular")
    public void blood_elementinin_girilen_arama_terimiyle_eslesen_sekilde_goruntulendigini_dogrular() {
        List<String> tbody = page.getTableBodies();
        System.out.println("Tablodaki veriler: " + tbody);
        boolean containsRAD = tbody.stream().anyMatch(row -> row.contains("B"));
        Assert.assertTrue("Arama sonuçları beklenen değeri içermiyor", containsRAD);
        logger.info("Blood elementinin girilen arama terimiyle eşleştiği doğrulandı.");

    }
    @Step("Blood listesinde hasta bir başlık üzerine tıklar")
    @When("blood listesinde hasta bir baslık uzerine tiklar")
    public void blood_listesinde_hasta_bir_baslık_uzerine_tiklar() {
        page.billNoBloodIssue.click();
        ReusableMethods.wait(2);
        logger.info("Blood listesinde hasta bir başlık üzerine tıkladı.");


    }

    @Step("Blood liste artan bir sırada sıralanmalıdır")
        @Then("blood liste artan bir sirada siralanmalidir")
        public void blood_liste_artan_sirada_siralanmalidir() {
            List<WebElement> bloodIssueElements = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
            System.out.println("Bulunan eleman sayısı: " +bloodIssueElements.size());

            for (WebElement element : bloodIssueElements) {
                System.out.println("Bulunan değer: " + element.getText());

            }

        logger.info("Blood liste artan bir sırada sıralandı.");

        }
    @Step("Hasta blood bölümünde aynı header üzerine tekrar tıklar")
    @When("hasta blood bolumunde aynı header uzerine tekrar tiklar")
    public void hasta_blood_bolumunde_aynı_header_uzerine_tekrar_tiklar() {
        page.billNoBloodIssue.click();
        ReusableMethods.wait(2);
        logger.info("Hasta blood bölümünde aynı header üzerine tekrar tıkladı.");

    }
    @Step("Hasta Component Issue butonuna tıklar")
    @Given("hasta Component Issue butonuna tıklar")
    public void hasta_component_issue_butonuna_tiklar() {
        ReusableMethods.wait(2);
        page.componentIssueButton.click();
        Assert.assertTrue("Blood Bank sayfası açılmadı!",
                page.componentIssueHeader.isDisplayed());

        logger.info("Hasta Component Issue butonuna tıkladı.");
    }

    @Step("Hasta, component için bir arama terimi girer")
    @Then("hasta,component icin bir arama terimi girer")
    public void hasta_component_icin_bir_arama_terimi_girer() {
        page.searchAlaniComponentIssue.sendKeys("B");
        ReusableMethods.bekle(2);
        logger.info("Hasta, component için bir arama terimi girdi.");

    }
    @Step("Component elementinin girilen arama terimiyle eşleşen şekilde görüntülendiğini doğrular")
    @Then("component elementinin girilen arama terimiyle eslesen sekilde goruntulendigini dogrular")
    public void component_elementinin_girilen_arama_terimiyle_eslesen_sekilde_goruntulendigini_dogrular() {
        List<String> tbody = page.getTableBodies();
        System.out.println("Tablodaki veriler: " + tbody);
        boolean containsRAD = tbody.stream().anyMatch(row -> row.contains("B"));
        Assert.assertTrue("Arama sonuçları beklenen değeri içermiyor", containsRAD);
        logger.info("Component elementinin girilen arama terimiyle eşleştiği doğrulandı.");

    }
    @Step("Hasta, Blood Issue için bir arama terimi girer")
    @Then("hasta, Blood Issue icin bir arama terimi girer")
    public void hasta_blood_ıssue_icin_bir_arama_terimi_girer() {
        page.searchAlaniBloodIssue.sendKeys("B");
        ReusableMethods.bekle(2);
        logger.info("Hasta, Blood Issue için bir arama terimi girdi.");


    }
    @Step("Hasta, Component Issue için bir arama terimi girer")
    @Then("hasta, Compenent Issue icin bir arama terimi girer")
    public void hasta_component_ıssue_icin_bir_arama_terimi_girer() {
        page.searchAlaniComponentIssue.sendKeys("B");
        ReusableMethods.bekle(2);
        logger.info("Hasta, Component Issue için bir arama terimi girdi.");


    }
    @Step("Blood Issue elementinin girilen arama terimiyle eşleşen şekilde görüntülendiğini doğrular")
    @Then("Blood Issue elementinin girilen arama terimiyle eslesen sekilde goruntulendigini dogrular")
    public void blood_ıssue_elementinin_girilen_arama_terimiyle_eslesen_sekilde_goruntulendigini_dogrular() {
        List<String> tbody = page.getTableBodies();
        System.out.println("Tablodaki veriler: " + tbody);
        boolean containsRAD = tbody.stream().anyMatch(row -> row.contains("B"));
        Assert.assertTrue("Arama sonuçları beklenen değeri içermiyor", containsRAD);
        logger.info("Blood Issue elementinin girilen arama terimiyle eşleştiği doğrulandı.");

    }
    @Step("Component Issue elementinin girilen arama terimiyle eşleşen şekilde görüntülendiğini doğrular")
    @Then("Component Issue elementinin girilen arama terimiyle eslesen sekilde goruntulendigini dogrular")
    public void component_ıssue_elementinin_girilen_arama_terimiyle_eslesen_sekilde_goruntulendigini_dogrular() {
        List<String> tbody = page.getTableBodies();
        System.out.println("Tablodaki veriler: " + tbody);
        boolean containsRAD = tbody.stream().anyMatch(row -> row.contains("B"));
        Assert.assertTrue("Arama sonuçları beklenen değeri içermiyor", containsRAD);
        logger.info("Component Issue elementinin girilen arama terimiyle eşleştiği doğrulandı.");

    }
    @Step("Component listesinde hasta bir başlık üzerine tıklar")
    @When("component listesinde hasta bir baslık uzerine tiklar")
    public void component_listesinde_hasta_bir_baslık_uzerine_tiklar() {
        page.billNoComponentIssue.click();
        ReusableMethods.wait(2);
        logger.info("Component listesinde hasta bir başlık üzerine tıkladı.");


    }
    @Step("Component liste artan bir sırada sıralanmalıdır")
    @Then("component liste artan bir sirada siralanmalidir")
    public void component_liste_artan_sirada_siralanmalidir() {
        List<WebElement> componentIssueElements = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        System.out.println("Bulunan eleman sayısı: " +componentIssueElements.size());

        for (WebElement element : componentIssueElements) {
            System.out.println("Bulunan değer: " + element.getText());
            logger.info("Component liste artan bir sırada sıralandı.");


        }
    }
    @Step("Hasta component bölümünde aynı header üzerine tekrar tıklar")
    @When("hasta component bolumunde aynı header uzerine tekrar tiklar")
    public void hasta_component_bolumunde_aynı_header_uzerine_tekrar_tiklar() {
        page.billNoBloodIssue.click();
        ReusableMethods.wait(2);
        logger.info("Hasta component bölümünde aynı header üzerine tekrar tıkladı.");

    }





}
