package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AdminBillingAppointmentPage;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.util.List;


public class AdminBillingAppointmentStep {
    WebDriver driver = StepDefinitions.Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(AdminBillingAppointmentStep.class);
    AdminBillingAppointmentPage adminBillingAppointmentPage = new AdminBillingAppointmentPage();


    @Step("Sidebar'da {string} menüsüne tıklandı")
    @Given("Sidbarda {string} a tiklar")
    public void sidbarda_a_tiklar(String menu) {
        adminBillingAppointmentPage.AppointmentMenu.click();
        logger.info(menu + " menüsüne tıklandı.");

    }
    @Step("Appointment sayfasına yönlendirildiğini doğruladı")
    @When("Appoinment sayfasina yonlendirildigini dogrular")
    public void appoinment_sayfasina_yonlendirildigini_dogrular() {
        String expectedUrl = ConfigReader.getProperty("AdminAppoinmentUrl");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        logger.info("Appointment sayfasına başarıyla yönlendirildi.");

    }

    @Step("Tablo başlıklarının doğru olduğunu doğruladı")
    @When("Tablo baslıklarının oldugunu dogrular")
    public void tablo_baslıklarının_oldugunu_dogrular(io.cucumber.datatable.DataTable expectedHeadersTable) {
        List<String> expectedHeaders = expectedHeadersTable.asList();

        // Get actual headers from the web page
        List<String> actualHeaders = adminBillingAppointmentPage.getTableHeaders();
        System.out.println("Expected Headers: " + expectedHeaders);
        System.out.println("Actual Headers: " + actualHeaders);
        Assert.assertEquals(expectedHeaders, actualHeaders);
        logger.info("Tablo başlıkları doğrulandı.");


    }
    @Step("{string} sütun başlığına tıklandı")
    @When("{string} sütun basligina tiklar")
    public void sütun_basligina_tiklar(String string) {
        adminBillingAppointmentPage.patientNameHeader.click();
        logger.info(string + " sütun başlığına tıklandı.");

    }
    @Step("{string} sütununun alfabetik sırada olduğunu doğruladı")
    @When("{string} sütunun alfebetik sirada oldugunu dogrular")
    public void sütunun_alfebetik_sirada_oldugunu_dogrular(String sutunBasligi) {

        adminBillingAppointmentPage.siralamayiDogrulama(sutunBasligi);
        logger.info(sutunBasligi + " sütunu alfabetik sırada doğrulandı.");

    }
    @Step("Search Box'ın görünürlüğünü doğruladı")
    @When("Search Box oldugunu dogrular")
    public void search_box_oldugunu_dogrular() {

        Assert.assertTrue(adminBillingAppointmentPage.appoinenmentDetailSearchBox.isDisplayed());
        logger.info("Search Box görünür olarak doğrulandı.");

    }
    @Step("Search Box'a {string} yazıldı")
    @Then("Search Box'a {string} yazar")
    public void search_box_a_yazar(String gonderilenIsim) {
        adminBillingAppointmentPage.appoinenmentDetailSearchBox.sendKeys(gonderilenIsim);
        logger.info("Search Box'a " + gonderilenIsim + " yazıldı.");

    }
    @Step("Hasta adı sütununda {string} içeren sonuçları doğruladı")
    @Then("Hasta adı sütununda {string} iceren sonucları gorundugunu dogrular")
    public void hasta_adı_sütununda_iceren_sonucları_gorundugunu_dogrular(String arananIsim) {
        adminBillingAppointmentPage.sutundaIsimMevcutMu(arananIsim);
        logger.info("Hasta adı sütununda " + arananIsim + " içeren sonuçlar doğrulandı.");

    }
    @Step("Status altında {string} başlığını doğruladı")
    @When("Status altinda {string} basliginin gorundugunu dogrular")
    public void statusAltındaBasligininGorundugunuDogrular(String aranacakHeaderText) {
        boolean isActionFound = adminBillingAppointmentPage.baslikGorunuyorMu(aranacakHeaderText);
        Assert.assertTrue("Action basligi satus basligi altinda goruntulenemedi", isActionFound);
        logger.info("Status altında " + aranacakHeaderText + " başlığı doğrulandı.");

    }
    @Step("Queue'nin solunda {string} görünürlüğünü doğruladı")
    @When("Queue'nin solunda {string} gorunurlugunu dogrular")
    public void queue_nin_solunda_gorunurlugunu_dogrular(String string) {
        Assert.assertTrue(adminBillingAppointmentPage.doctorWiseButton.isDisplayed());
        logger.info("Queue'nin solunda " + string + " görünürlüğü doğrulandı.");

    }
    @Step("{string} butonuna tıklandı")
    @Then("{string} butonuna tiklar")
    public void butonuna_tiklar(String string) {
        adminBillingAppointmentPage.doctorWiseButton.click();
        logger.info(string + " butonuna tıklandı.");

    }
    @Step("Doctor Wise randevu sayfasına yönlendirildiğini doğruladı")
    @Then("Doctor Wise randevu sayfasina yonlendirildigini dogrular")
    public void doctor_wise_randevu_sayfasina_yonlendirildigini_dogrular() {
        String expectedUrl = ConfigReader.getProperty("DoctorWiseUrl");//QueueUrl
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        logger.info("Doctor Wise randevu sayfasına başarıyla yönlendirildi.");

    }
    @Step("Doctor Wise sağında {string} görünürlüğünü doğruladı")
    @When("Doctor Wise saginda {string} gorunurlugunu dogrular")
    public void doctor_wise_saginda_gorunurlugunu_dogrular(String string) {
        Assert.assertTrue(adminBillingAppointmentPage.QueueButton.isDisplayed());
        logger.info("Doctor Wise sağında " + string + " görünürlüğü doğrulandı.");

    }
    @Step("Queue butonuna tıklandı")
    @Then("Queue butonuna tiklar")
    public void queue_butonuna_tiklar() {
        adminBillingAppointmentPage.QueueButton.click();
        logger.info("Queue butonuna tıklandı.");

    }

    @Step("Queue randevu sayfasına yönlendirildiğini doğruladı")
    @And("Queue randevu sayfasina yonlendirildigini dogrular")
    public void queueRandevuSayfasinaYonlendirildiginiDogrular() {
        String expectedUrl = ConfigReader.getProperty("QueueUrl");//QueueUrl
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        logger.info("Queue randevu sayfasına başarıyla yönlendirildi.");

    }
    @Step("Doctor butonuna tıklandı")
    @Then("Doctor butonuna tiklar")
    public void doctor_butonuna_tiklar() {
        adminBillingAppointmentPage.doctorBoxDoctorWise.click();
        logger.info("Doctor butonuna tıklandı.");

    }
    @Step("Doktor olarak {string} seçildi")
    @Then("Doktor olarak {string} secer")
    public void doktor_olarak_secer(String string) {
        ReusableMethods.wait(2);
        adminBillingAppointmentPage.chosenPeople.click();
        logger.info("Doktor olarak " + string + " seçildi.");

    }
    @Step("Tarih butonuna tıklandı")
    @Then("Tarih butonuna tiklar")
    public void tarih_butonuna_tiklar() {
        adminBillingAppointmentPage.dateBox.click();
        logger.info("Tarih butonuna tıklandı.");

    }
    @Step("Tarih olarak {double}.{int} seçildi")
    @Then("Tarih olarak\"{double}.{int}\" secer")
    public void tarih_olarak_secer(Double double1, Integer int1) {
        adminBillingAppointmentPage.chosenDate.click();
        logger.info("Tarih olarak " + double1 + "." + int1 + " seçildi.");

    }
    @Step("Search butonuna tıklandı")
    @Then("Search butonuna tiklar")
    public void search_butonuna_tiklar() {
        adminBillingAppointmentPage.searchBox.click();
        logger.info("Search butonuna tıklandı.");

    }
    @Step("Aşağıdaki hasta bilgilerini doğruladı")
    @Then("Asagidaki hasta bilgilerinin gorundugunu dogrular")
    public void asagidaki_hasta_bilgilerinin_gorundugunu_dogrular(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> expectedData = dataTable.asLists(String.class);

        // WebElement table = driver.findElement(By.id("DataTables_Table_0")); // Tablo ID'sini kontrol edin
        WebElement table = driver.findElement(By.xpath("//div[@class='table-responsive mailbox-messages']"));
        adminBillingAppointmentPage.verifyTableContent(table, expectedData);
        logger.info("Hasta bilgileri başarıyla doğrulandı.");

    }
    @Step("Doktor olarak Amit Singh ({int}) seçildi")
    @Then("Doktor olarak Amit Singh \\({int}) secer")
    public void doktor_olarak_amit_singh_secer(Integer int1) {
        adminBillingAppointmentPage.queueDoctorBox.click();
        adminBillingAppointmentPage.QueueChosenDoctor.click();
        logger.info("Doktor olarak Amit Singh (" + int1 + ") seçildi.");

    }
    @Step("Shift butonuna tıklandı")
    @Then("Shift butonuna tiklar")
    public void shift_butonuna_tiklar() {
        adminBillingAppointmentPage.shiftBox.click();
        logger.info("Shift butonuna tıklandı.");

    }
    @Step("Morning seçildi")
    @Then("Morning secer")
    public void morning_secer() {
        adminBillingAppointmentPage.selectedShift.click();
        logger.info("Morning seçildi.");

    }
    @Step("Tarih olarak {string} seçildi")
    @Then("Tarih olarak {string} secer")
    public void tarih_olarak_secer(String string) {
        adminBillingAppointmentPage.dateBox.click();
        adminBillingAppointmentPage.chosenDate.click();
        logger.info("Tarih olarak " + string + " seçildi.");

    }

    @And("Slot butonuna tiklar")
    public void slotButonunaTiklar() {

        adminBillingAppointmentPage.slotBox.click();
    }
    @Step("Slot butonuna tıklandı")
    @Then("Slot olarak {string} secer")
    public void secer(String string) {
        adminBillingAppointmentPage.selectedSlot.click();
        ReusableMethods.wait(3);
        logger.info("Slot butonuna tıklandı.");

    }


}
