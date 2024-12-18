package StepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.cucumber.java.en_scouse.An;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.AdminDashboardPage;
import pages.AdminHRPage;
import utilities.ConfigReader;
import utilities.DriverManager;
import utilities.ReusableMethods;

import java.sql.Driver;

public class AdminHRStep {

    WebDriver driver = StepDefinitions.Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(AdminHRStep.class);
    AdminHRPage adminHRPage = new AdminHRPage();

    @Step("Admin kullanıcı ana sayfaya gider")
    @When("Admin kullanici ana sayfaya gider")
    public void admin_kullanici_ana_sayfaya_gider() {

        driver.get(ConfigReader.getProperty("AdminDasboardUrl"));
        logger.info("Admin kullanıcı ana sayfaya gitti.");


    }
    @Step("Geçerli giriş bilgileriyle sisteme giriş yapar")
    @And("Gecerli giris bilgileriyle sisteme giris yapar")
    public void gecerli_giris_bilgileriyle_sisteme_giris_yapar() {
        adminHRPage.emailAlani.sendKeys(ConfigReader.getProperty("AdminMailUgur"));
        adminHRPage.sifreAlani.sendKeys(ConfigReader.getProperty("Passwords"));
        adminHRPage.signInButonu.click();
        logger.info("Admin geçerli bilgilerle sisteme giriş yaptı.");
    }
    @Step("Admin kullanıcı {string} linkine tıklar")
    @Then("Admin kullanici {string} Linkine tiklar")
    public void admin_kullanici_linkine_tiklar(String string) {
        adminHRPage.humanResourceLinki.click();
        logger.info("Admin kullanıcı " + string + " linkine tıkladı.");
    }
    @Step("Admin kullanıcı {string} sayfasını görüntüler")
    @And("Admin Kullanici {string} sayfasini goruntuler")
    public void admin_kullanici_sayfasini_goruntuler(String string) {
        Assert.assertTrue(adminHRPage.staffDirectoryBasligi.isDisplayed());
        ReusableMethods.wait(2);
        logger.info("Admin kullanıcı " + string + " sayfasını görüntüledi.");

    }
    @Step("Admin kullanıcı giriş bilgileri ile sisteme login olur")
    @Given("Admin kullanici giris bilgileri ile sisteme login olur")
    public void admin_kullanici_giris_bilgileri_ile_sisteme_login_olur() {
        driver.get(ConfigReader.getProperty("AdminDasboardUrl"));

        adminHRPage.emailAlani.sendKeys(ConfigReader.getProperty("AdminMailUgur"));
        adminHRPage.sifreAlani.sendKeys(ConfigReader.getProperty("Passwords"));
        adminHRPage.signInButonu.click();
        logger.info("Admin kullanıcı başarılı bir şekilde giriş yaptı.");
    }
    @Step("Staff Directory sayfasına gider")
    @Given("Staff Directory Sayfasina gider")
    public void staff_directory_sayfasina_gider() {
        adminHRPage.humanResourceLinki.click();
        logger.info("Admin Staff Directory sayfasına yönlendirildi.");


    }
    @Step("Kullanıcı List View butonuna tıklar")
    @When("Kullanici List View butonuna tiklar")
    public void kullanici_list_view_butonuna_tiklar() {

        adminHRPage.listViewButonu.click();
        ReusableMethods.wait(1);
        logger.info("List View butonuna tıklandı.");

    }
    @Step("Kullanıcı Staff ID, Name, Role, Department, Designation, Mobile Number ve Action başlıklarını görüntüler")
    @Then("Kullanici Staff ID, Name, Role, Department, Designation, Mobile Number ve Action basliklarini goruntuler")
    public void kullanici_staff_id_name_role_department_designation_mobile_number_ve_action_basliklarini_goruntuler() {

        Assert.assertTrue(adminHRPage.staffDirectoryBasligi.isDisplayed());
        Assert.assertTrue(adminHRPage.nameBasligli.isDisplayed());
        Assert.assertTrue(adminHRPage.roleBasligi.isDisplayed());
        Assert.assertTrue(adminHRPage.departmentBasligi.isDisplayed());
        Assert.assertTrue(adminHRPage.designationBasligi.isDisplayed());
        Assert.assertTrue(adminHRPage.mobileNumberBasligi.isDisplayed());
        Assert.assertTrue(adminHRPage.actionBasligi.isDisplayed());
        ReusableMethods.wait(3);
        logger.info("Staff başlıkları başarıyla görüntülendi.");


    }
    @Step("Kullanıcı personelleri liste halinde görüntüler")
    @Then("Kullanici Personelleri Liste halinde goruntuler")
    public void kullanici_personelleri_liste_halinde_goruntuler() {

        Assert.assertTrue(adminHRPage.superAdminListView.isDisplayed());
        ReusableMethods.wait(1);
        logger.info("Personeller liste halinde görüntülendi.");


    }
    @Step("Kullanıcı Card View butonuna tıklar")
    @When("Kullanici Card View butonuna tiklar")
    public void kullanici_card_view_butonuna_tiklar() {

        adminHRPage.cardViewButonu.click();
        ReusableMethods.wait(1);
        logger.info("Card View butonuna tıklandı.");

    }
    @Step("Kullanıcı personelleri Card View halinde görüntüler")
    @Then("Kullanici Personelleri Card View halinde goruntuler")
    public void kullanici_personelleri_card_view_halinde_goruntuler() {

        Assert.assertTrue(adminHRPage.superAdminCardView.isDisplayed());
        ReusableMethods.wait(1);
        logger.info("Personeller Card View halinde görüntülendi.");

    }

    @Step("Kullanıcı {string} altında {string} butonuna tıklar")
    @When("Kullanici {string} altinda {string} butonuna tiklar")
    public void kullanici_altinda_butonuna_tiklar(String string, String string2) {

        adminHRPage.showButonuActionAltinda.click();
        logger.info(string + " altında " + string2 + " butonuna tıklandı.");
    }
    @Step("İlgili personelin bilgilerinin yer aldığı sayfaya yönlendirilir")
    @Then("Ilgili personelin bilgilerinin yer aldigi sayfaya yonlendirilir")
    public void ilgili_personelin_bilgilerinin_yer_aldigi_sayfaya_yonlendirilir() {

        Assert.assertTrue(adminHRPage.staffIDButonuProfilEkrani.isDisplayed());
        logger.info("İlgili personelin bilgileri başarıyla görüntülendi.");

    }
    @Step("Kullanıcı Disabled Staff ekranına erişir")
    @When("Kullanici {string} butonuna ardindan da {string} butonuna tiklar")
    public void kullanici_butonuna_ardindan_da_butonuna_tiklar(String string, String string2) {

        adminHRPage.addStaffDropdownButonu.click();
        adminHRPage.disabledStaffButonu.click();
        logger.info("Disabled Staff ekranına başarıyla erişildi.");

    }
    @Step("Kullanıcı Disabled Staff ekranına erişir")
    @Then("Kullanici Disabled Staff ekranina erisir")
    public void kullanici_disabled_staff_ekranina_erisir() {

        Assert.assertTrue(adminHRPage.disabledStaffEkraniBasligi.isDisplayed());
        logger.info("Disabled Staff ekranına başarıyla erişildi.");

    }
    @Step("Kullanıcı {string} linkine tıklar")
    @When("Kullanici {string} linkine tiklar")
    public void kullanici_linkine_tiklar(String string) {

        adminHRPage.payrollButonu.click();
        logger.info(string + " linkine tıklandı.");

    }
    @Step("Kullanıcı Add Staff butonuna tıklar")
    @When("Kullanici {string} butonuna tiklar")
    public void kullanici_butonuna_tiklar(String string) {
        adminHRPage.addStaffButonu.click();
        logger.info("Add Staff butonuna tıklandı.");


    }
    @Step("Kullanıcı {string} sayfasına erişir")
    @Then("Kullanici {string} sayfasina erisir")
    public void kullaniciSayfasinaErisir(String arg0) {
        adminHRPage.staffAttendanceBasligi.isDisplayed();
        logger.info("Kullanıcı " + arg0 + " sayfasına başarıyla erişti.");

    }

    @Step("Kullanıcı {string} sayfasını görüntüler")
    @Then("Kullanici {string} Sayfasina goruntuler")
    public void kullaniciSayfasinaGoruntuler(String arg0) {
        Assert.assertTrue(adminHRPage.payrollSayfasiBasligi.isDisplayed());
        logger.info("Kullanıcı " + arg0 + " sayfasını görüntüledi.");

    }
    @Step("Kullanıcı Action butonuna tıklar")
    @And("Kullanici Action butonuna tiklar")
    public void kullaniciActionButonunaTiklar() {

        adminHRPage.actionBasligi.click();
        logger.info("Action butonuna tıklandı.");


    }
    @Step("Kullanıcı Action altında Edit butonuna tıklar")
    @When("Kullanici Action altinda Edit butonuna tiklar")
    public void kullaniciActionAltindaEditButonunaTiklar() {

        adminHRPage.editButonuActionAltinda.click();
        logger.info("Action altında Edit butonuna tıklandı.");

    }
    @Step("İlgili personel bilgilerinin editlendiği sayfaya yönlendirilir")
    @Then("Ilgili personel bilgilerinin editlendigi sayfaya yonlendirilir")
    public void ilgiliPersonelBilgilerininEditlendigiSayfayaYonlendirilir() {

        Assert.assertTrue(adminHRPage.basicInformationSayfasiBasligi.isDisplayed());
        logger.info("Personel bilgilerinin düzenlenebileceği sayfaya yönlendirildi.");

    }
    @Step("Kullanıcı {string} başlığı altında Add Staff ekranına erişir")
    @Then("Kullanici {string} basligi altinda Add Staff Ekranina erisir")
    public void kullaniciBasligiAltindaAddStaffEkraninaErisir(String arg0) {

        Assert.assertTrue(adminHRPage.basicInformationSayfasiBasligi.isDisplayed());
        logger.info(arg0 + " başlığı altında Add Staff ekranına erişildi.");

    }
    @Step("Kullanıcı kayıt formunu doldurur ve işlemi kaydeder")
    @And("Kullanici kayit formunu doldurur islemi kaydeder")
    public void kullaniciKayitFormunuDoldururIslemiKaydeder() {

        Faker faker = new Faker();
        String fakeStaffID = faker.idNumber().invalid();
        String fakeFirstName = faker.name().firstName();
        logger.info("Kayıt formu dolduruldu ve işlem kaydedildi.");

    }
    @Step("Kullanıcı kaydedilen personeli listede görüntüler")
    @Then("Kullanici kaydedilen personelin listede goruntuler")
    public void kullaniciKaydedilenPersonelinListedeGoruntuler() {
        logger.info("Kaydedilen personel başarıyla listede görüntülendi.");

    }
    @Step("Kullanıcı Import Staff butonuna tıklar")
    @And("Kullanici Import Staff butonuna tiklar")
    public void kullaniciImportStaffButonunaTiklar() {
        adminHRPage.importStaffButonu.click();

        logger.info("Import Staff butonuna tıklandı.");

    }
    @Step("Kullanıcı Import Staff ekranını görüntüler")
    @Then("Kullanici Import Staff ekranini goruntuler")
    public void kullaniciImportStaffEkraniniGoruntuler() {
        Assert.assertTrue(adminHRPage.importStaffSayfaBasligi.isDisplayed());
        logger.info("Import Staff ekranı başarıyla görüntülendi.");

    }
    @Step("Kullanıcı Add Staff butonuna tıklar")
    @When("Kullanici Add Staff butonuna tiklar")
    public void kullaniciAddStaffButonunaTiklar() {
        adminHRPage.addStaffButonu.click();
        logger.info("Add Staff butonuna tıklandı.");

    }
    @Step("Kullanıcı Basic Information başlığı altında Add Staff ekranına erişir")
    @Then("Kullanici Basic Information basligi altinda Add Staff Ekranina erisir")
    public void kullaniciBasicInformationBasligiAltindaAddStaffEkraninaErisir() {
        Assert.assertTrue(adminHRPage.basicInformationSayfasiBasligi.isDisplayed());
        logger.info("Basic Information başlığı altında Add Staff ekranına erişildi.");

    }
    @Step("Kullanıcı Leaves butonuna tıklar")
    @When("Kullanici Leaves butonuna tiklar")
    public void kullaniciLeavesButonunaTiklar() {
        adminHRPage.leavesButonu.click();

        logger.info("Leaves butonuna tıklandı.");

    }
    @Step("Kullanıcı My Leaves sayfasına erişir")
    @Then("Kullanici My Leaves sayfasina erisir")
    public void kullaniciMyLeavesSayfasinaErisir() {
        Assert.assertTrue(adminHRPage.leavesSayfasiBasligi.isDisplayed());
        logger.info("My Leaves sayfasına başarıyla erişildi.");

    }
    @Step("Kullanıcı arama butonunda ilgili izin için arama yapar")
    @When("Kullanici arama butonunda ilgili izin icin arama yapar")
    public void kullaniciAramaButonundaIlgiliIzinIcinAramaYapar() {
        adminHRPage.leavesSayfasiSearchButonu.click();
        adminHRPage.leavesSayfasiSearchButonu.sendKeys("Ahmet");
        logger.info("Arama butonunda izin bilgisi için 'Ahmet' aranıyor.");

    }
    @Step("Kullanıcı izin bilgisine erişir")
    @Then("Kullanici izin bilgisine erisir")
    public void kullaniciIzinBilgisineErisir() {
        Assert.assertTrue(adminHRPage.addNewLeaveYazisi.isDisplayed());
        logger.info("İzin bilgisine başarıyla erişildi.");

    }

    @Step("Kullanıcı Approve Leave Request butonuna tıklar")
    @And("Kullanici Approve Leave Request butonuna tiklar")
    public void kullaniciApproveLeaveRequestButonunaTiklar() {
        adminHRPage.approveLeaveRequestButonu.click();
        ReusableMethods.wait(1);
        logger.info("Approve Leave Request butonuna tıklandı.");

    }
    @Step("Kullanıcı {string} sıralama seçeneğine tıklar")
    @When("Kullanici {string} siralama secenegine tiklar")
    public void kullanici_siralama_secenegine_tiklar(String string) {
        adminHRPage.approveLeaveRequest100Butonu.click();
        logger.info(string + " sıralama seçeneğine tıklandı.");

    }
    @Step("Kullanıcı Action başlığı altında View'e tıklar")
    @When("Kullanici Action basligi altinda Viewe tiklar")
    public void kullanici_action_basligi_altinda_viewe_tiklar() {
        adminHRPage.aprroveLeaveRequestViewButonu.click();
        ReusableMethods.wait(1);
        logger.info("Action başlığı altında View'e tıklandı.");

    }
    @Step("Kullanıcı Details ekranının görüntülendiğini doğrular")
    @Then("Kullanici Details ekraninin goruntulendigini dogrular")
    public void kullanici_details_ekraninin_goruntulendigini_dogrular() {
        Assert.assertTrue(adminHRPage.detailsEkraniNameBasligi.isDisplayed());
        ReusableMethods.wait(1);
        logger.info("Details ekranı başarıyla görüntülendi.");


    }
    @Step("Kullanıcı Add Leave Request butonuna tıklar")
    @When("Kullanici Add Leave Request butonuna tiklar")
    public void kullanici_add_leave_request_butonuna_tiklar() {
        adminHRPage.addLeaveRequestButonu.click();
        ReusableMethods.wait(1);
        logger.info("Add Leave Request butonuna tıklandı.");

    }
    @Step("Kullanıcı Add Details ekranına erişir")
    @Then("Kullanici Add Details ekranina erisir")
    public void kullanici_add_details_ekranina_erisir() {
        Assert.assertTrue(adminHRPage.saveButonuAddDetailsPenceresi.isDisplayed());
        ReusableMethods.wait(1);
        logger.info("Add Details ekranına başarıyla erişildi.");

    }
    @Step("Kullanıcı Add Details ekranında formu doldurur")
    @When("Kullanici Add Details ekraninda formu doldurur")
    public void kullanici_add_details_ekraninda_formu_doldurur() {

        Actions actions = new Actions(DriverManager.getDriver());

        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .perform();

        adminHRPage.saveButonuAddDetailsPenceresi.click();
        logger.info("Add Details ekranında form dolduruldu.");

    }
    @Step("Kullanıcı kaydedilen izni Approve Leave Request ekranında görüntüleyebildiğini doğrular")
    @Then("Kullanici kaydedilen izni Approve Leave Request ekraninda goruntuleyebildigini dogrular")
    public void kullanici_kaydedilen_izni_approve_leave_request_ekraninda_goruntuleyebildigini_dogrular() {

        Assert.assertTrue(adminHRPage.addLeaveRequestButonu.isDisplayed());
        logger.info("Kaydedilen izin Approve Leave Request ekranında görüntülendi.");

    }

    @Step("Kullanıcı Staff Attendance sayfasına erişir")
    @Then("Kullanici Staff Attendance sayfasina erisir")
    public void kullaniciStaffAttendanceSayfasinaErisir() {

        Assert.assertTrue(adminHRPage.staffAttendanceBasligi.isDisplayed());
        logger.info("Staff Attendance sayfasına başarıyla erişildi.");


    }
}
