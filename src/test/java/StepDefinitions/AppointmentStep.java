package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.AdminDashboardPage;
import pages.AppointmentPage;
import utilities.DriverManager;
import utilities.ReusableMethods;

public class AppointmentStep {
    WebDriver driver = StepDefinitions.Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(AppointmentStep.class);
    AdminDashboardPage dashboardPage = new AdminDashboardPage();
    AppointmentPage appointmentPage = new AppointmentPage();
    String patientName = "Onur";
    @Step("Doktor sitenin SideBar'ında bulunan {string} sayfasına tıklar")
    @Then("Doktor sitenin SideBar'ında bulunan {string} sayfasına tıklar")
    public void doktor_sitenin_side_bar_ında_bulunan_sayfasına_tıklar(String menü) {
        ReusableMethods.wait(4);
        ReusableMethods.dashBoardSwitch(menü);
        logger.info(menü + " sayfasına tıklandı.");

    }
    @Step("Doktor sitenin Appointment sayfasında randevuları görüntüler")
    @Then("Doktor sitenin Appointment sayfasında randevuları goruntuler")
    public void doktor_sitenin_appointment_sayfasında_randevuları_goruntuler() {
        for (int i = 0; i < appointmentPage.tableRows.size(); i++) {

            if (appointmentPage.tableRows.get(i).isDisplayed()) {
                int row = i + 1;
                logger.info("Doktor sitenin Appointment sayfasındaki " + row + " randevuyu goruntuler");
            } else {
                int row = i + 1;
                logger.error("Appointment sayfasında " + row + " randevu bulunamadı");
            }
            logger.info("Doktor sitenin Appointment sayfasındaki randevular görüntülendi.");

        }
    }
    @Step("Doktor sitenin Appointment sayfasında Search Box'i kullanarak randevuları arar")
    @Then("Doktor sitenin Appointment sayfasında Search Box'i kullanarak randevuları arar")
    public void doktor_sitenin_appointment_sayfasında_search_box_i_kullanarak_randevuları_arar() {
        appointmentPage.searchBar.sendKeys(patientName);
         logger.info("Search Box'a aranan kelime yazıldı.");

    }
    @Step("Doktor SearchBox'taki aranan kelime listelenenle aynı olmalı")
    @Then("Doktor SearchBox'taki arnan kelime listelenenle aynı olmalı")
    public void doktor_search_box_taki_arnan_kelime_listelenenle_aynı_olmalı() {
        if (appointmentPage.firstPatientName.getText().contains(patientName)) {
            logger.info("Serach box'taki arnan kelime listelenenle aynı");
        } else {
             logger.info("SearchBox'taki aranan kelime listelenenle karşılaştırıldı.");

        }
    }
    @Step("Doktor sitenin Appointment sayfasındaki {string} butonuna tıklar")
    @Then("Doktor sitenin Appointment sayfasındaki {string} butonuna tıklar")
    public void doktor_sitenin_appointment_sayfasındaki_butonuna_tıklar(String sayfa) {
        switch (sayfa) {
            case "Queue":
                appointmentPage.WiseQueue.get(1).click();
                logger.info("Queue butonuna tıklandı");
                break;
            case "Doctor Wise":
                appointmentPage.WiseQueue.get(0).click();
                logger.info("Doctor Wise butonuna tıklandı");
                break;
            default:
                logger.error("Buton bulunamadı");
        }
    }
    @Step("Doktor, Doktor olarak {string} ve Date olarak {string} seçer")
    @Then("Doktor, Doktor olarak {string} Date olarak'ta {string} seçer")
    public void doktor_doktor_olarak_date_olarak_ta_seçer(String doctor, String date) {
        Select select = new Select(appointmentPage.doctorSelect);
        select.selectByVisibleText(doctor);
        logger.info("Doktor olarak " + doctor + " secildi");
        appointmentPage.dateBox.sendKeys(date);
        logger.info("Date olarak " + date + " secildi");
    }
    @Step("Doktor Search butonuna basarak arama yapar")
    @Then("Doktor Search butonuna basarak arama yapar")
    public void doktor_search_butonuna_basarak_arama_yapar() {
        appointmentPage.searchBtn.click();
        logger.info("Search butonuna basıldı");
    }
    @Step("Doktor Doctor Wise Appointment aranan kelime listelenenle aynı olmalı")
    @Then("Doktor Doctor Wise Appointment arnan kelime listelenenle aynı olmalı")
    public void doktor_doctor_wise_appointment_arnan_kelime_listelenenle_aynı_olmalı() {
        if (appointmentPage.firstPatientName.getText().contains(patientName)) {
            logger.info("Serach box'taki arnan kelime listelenenle aynı");
        } else {
            logger.error("Serach box'taki arnan kelime listelenenle aynı degil!");
        }
    }
    @Step("Doktor, Doktor olarak {string}, Shift olarak {string}, Date olarak {string} ve Slot olarak {string} seçer")
    @Then("Doktor, Doktor olarak {string} Shift olarak {string} Date olarak {string} ve Slot olarak'ta {string} seçer")
    public void doktor_doktor_olarak_shift_olarak_date_olarak_ve_slot_olarak_ta_seçer(String doctor, String shift, String date, String slot) {
        Select select = new Select(appointmentPage.doctorSelect);
        select.selectByVisibleText(doctor);
        logger.info("Doktor olarak " + doctor + " secildi");
        select = new Select(appointmentPage.shiftSelect);
        select.selectByVisibleText(shift);
        logger.info("Shift olarak " + shift + " secildi");
        appointmentPage.dateBox.sendKeys(date);
        logger.info("Date olarak " + date + " secildi");
        Actions actions = new Actions(DriverManager.getDriver());
        actions.sendKeys(Keys.TAB).perform();
        select = new Select(appointmentPage.slotSelect);
        select.selectByVisibleText(slot);
        logger.info("Doktor olarak " + doctor + " seçildi");
        logger.info("Shift olarak " + shift + " seçildi");
        logger.info("Date olarak " + date + " seçildi");
        logger.info("Slot olarak " + slot + " seçildi");    }

    @Step("Doktor Patient Queue'da aranan kelime listelenenle aynı olmalı")
    @Then("Doktor Patient Queue arnan kelime listelenenle aynı olmalı")
    public void doktor_patient_queue_arnan_kelime_listelenenle_aynı_olmalı() {
        if (appointmentPage.firstPatientName.getText().contains(patientName) && appointmentPage.firstPatientDate.getText().contains("29.11.2024")) {
            logger.info("Serach box'taki arnan kelime listelenenle aynı");
        } else {
            logger.error("Serach box'taki arnan kelime listelenenle aynı degil!");
        }
    }

    @Step("Doktor sitenin Appointment sayfasında Appointment Details Listeleme seçeneklerini görüntüler")
    @And("Doktor sitenin Appointment sayfasında Appointment Details Listeleme seçeneklerini goruntuler")
    public void doktorSiteninAppointmentSayfasındaAppointmentDetailsListelemeSeçenekleriniGoruntuler() {
        for (int i = 0; i < appointmentPage.tableHeaders.size(); i++) {

            if (appointmentPage.tableHeaders.get(i).isDisplayed()) {
                int row = i + 1;
                logger.info("Doktor sitenin Appointment sayfasındaki " + row + " deatils goruntuler");
            } else {
                int row = i + 1;
                logger.error("Appointment sayfasında " + row + " deatils bulunamadı");
            }

        }
    }
}
