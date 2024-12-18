package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import pages.AdminDashboardPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AdminDashboardStep {
    WebDriver driver = StepDefinitions.Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(AdminDashboardStep.class);
    LoginPage loginPage = new LoginPage();
    AdminDashboardPage adminDashboardPage = new AdminDashboardPage();

    @Step("Admin mail {userName} ve password {password} ile giriş yapar")
    @When("Admin mail {string}  ve password {string} ile sign in olur")
    public void admin_mail_ve_password_ile_sign_in_olur(String userName, String password) {
        loginPage.accesAdmin(userName, password);
        logger.info("Admin mail " + userName + " ve password ile giriş yaptı.");


    }

    @Step("Heal Life Hospital & Research yazısının solundaki sidebar ikonuna tıklar")
    @Then("Heal Life Hospital & Research yazisinin solundaki sidebar iconuna tiklar")
    public void heal_life_hospital_research_yazisinin_solundaki_sidebar_iconuna_tiklar() {
        adminDashboardPage.clickSidebarIconIfDashboardNotVisible();
        logger.info("Sidebar ikonuna tıklandı.");

    }

    @Step("Sidbarda {string} yazısının görünürlüğünü doğrular")
    @Then("Sidbarda {string} yazisini gorunurlugunu dogrular")
    public void sidbarda_yazisini_gorunurlugunu_dogrular(String string) {
        Assert.assertTrue(adminDashboardPage.dashboardText.isDisplayed());
        logger.info("Sidbarda " + string + " yazısının görünürlüğü doğrulandı.");

    }

    @Step("Dashboard yazısına tıklar")
    @Then("Dashboard yazisina tiklar")
    public void dashboard_yazisina_tiklar() {
        adminDashboardPage.dashboardText.click();
        logger.info("Dashboard yazısına tıklandı.");

    }

    @Step("Sayfanın yenilendiğini doğrular")
    @Then("Sayfanin yenilendigini dogrular")
    public void sayfanin_yenilendigini_dogrular() {

        String actualUrl = ConfigReader.getProperty("AdminDasboardUrl");
        //  driver.navigate().refresh();
        String newUrl = driver.getCurrentUrl();
        assertEquals("Sayfa yenilendikten sonra Url ayni kalmali", actualUrl, newUrl);
        logger.info("Sayfanın yenilendiği doğrulandı.");

    }
    @Step("Yan menüde aşağıdaki başlıkların mevcut olduğunu doğrular")
    @Then("Yan menude asagidaki basliklarin mevcut oldugunu dogrular:")
    public void yan_menüde_aşağıdaki_linklerin_mevcut_olduğunu_doğrula(io.cucumber.datatable.DataTable dataTable) {
        logger.info("Yan menüde başlıkların mevcut olduğu doğrulandı.");
         List<String> expectedMenuItems = dataTable.asList();
        List<WebElement> menuItems = new ArrayList<>();
        menuItems.add(adminDashboardPage.DashboardMenu);
        menuItems.add(adminDashboardPage.BillingMenu);
        menuItems.add(adminDashboardPage.AppointmentMenu);
        menuItems.add(adminDashboardPage.OPDMenu);
        menuItems.add(adminDashboardPage.IPDMenu);
        menuItems.add(adminDashboardPage.PharmacyMenu);
        menuItems.add(adminDashboardPage.PathologyMenu);
        menuItems.add(adminDashboardPage.RadiologyMenu);
        menuItems.add(adminDashboardPage.BloodBankMenu);
        menuItems.add(adminDashboardPage.AmbulanceMenu);
        menuItems.add(adminDashboardPage.BirthDeathRecordMenu);
        menuItems.add(adminDashboardPage.HumanResourceMenu);
        List<String> menuString = ReusableMethods.getStringList(menuItems);
        Assert.assertEquals(expectedMenuItems, menuString);
        logger.info("Yan menüde başlıkların mevcut olduğu doğrulandı.");

    }

    @Step("Kullanıcı admin sayfasında olduğunu doğrular")
    @And("Kullanici admin sayfasinda oldugunu dogrular")
    public void kullaniciAdminSayfasindaOldugunuDogrular() {
        ReusableMethods.wait(2);
        String expectedUrl = "https://qa.heallifehospital.com/admin/admin/dashboard";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        logger.info("Kullanıcı admin sayfasında olduğu doğrulandı.");

    }
    @Step("Kullanıcı side navigation'da yer alan Radiology tab'ine tıklar")
    @And("Kullanici side navigation yer alan Radiology tab'ine tiklar")
    public void kullaniciSideNavigationYerAlanRadiologyTabIneTiklar() {
        adminDashboardPage.radiologyButton.click();
        logger.info("Radiology tab'ine tıklandı.");


    }
    @Step("Kullanıcı Radiology sayfasının açıldığını doğrular")
    @And("Kullanici Radiology sayfasinin acildigini dogrular")
    public void kullaniciRadiologySayfasininAcildiginiDogrular() {
        ReusableMethods.wait(2);
        String expectedUrl = "https://qa.heallifehospital.com/admin/radio/gettestreportbatch";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        logger.info("Radiology sayfasının açıldığı doğrulandı.");


    }
    @Step("Sayfayı Setup'a kadar kaydırır ve yan menüde aşağıdaki başlıkların mevcut olduğunu doğrular")
    @Then("sayfayi Setup a kadar kaydirir ve yan menude asagidaki basliklarin mevcut oldugunu dogrular:")
    public void sayfayiSetupAKadarKaydirirVeYanMenudeAsagidakiBasliklarinMevcutOldugunuDogrular(io.cucumber.datatable.DataTable dataTable) {
        JSUtilities.scrollToElement(driver, adminDashboardPage.SetupMenu);
        // Feature dosyasından gelen menü başlıkları
        List<String> expectedMenuItems = dataTable.asList();
        List<WebElement> menuItems = new ArrayList<>();
        menuItems.add(adminDashboardPage.TPAManagementMenu);
        menuItems.add(adminDashboardPage.MessagingMenu);
        menuItems.add(adminDashboardPage.LiveConsultationMenu);
        menuItems.add(adminDashboardPage.SetupMenu);
        List<String> menuString = ReusableMethods.getStringList(menuItems);
        Assert.assertEquals(expectedMenuItems, menuString);
        logger.info("Sayfa Setup'a kadar kaydırıldı ve başlıklar doğrulandı.");

    }
    @Step("{menuItem} başlığına tıklar")
    @Then("{string} basligina tikladigimda")
    public void basligina_tikladigimda(String menuItem) {
        WebElement menuElement = driver.findElement(By.xpath("//span[normalize-space()='" + menuItem + "']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", menuElement);
        logger.info(menuItem + " başlığına tıklandı.");

    }
    @Step("{ExpectedPageUrl} başlığına yönlendirilir")
    @Then("{string} basligina yonlendirilmeliyim")
    public void basligina_yonlendirilmeliyim(String ExpectedPageUrl) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(ExpectedPageUrl));
        logger.info("Kullanıcı " + ExpectedPageUrl + " başlığına yönlendirildi.");

    }
    @Step("Dashboard yan menüsünden TPA Management bağlantısını tıklar")
     @When("Dashboard yan menüsünden {string} bağlantısını tıkla")
    public void dashboard_yan_menüsünden_bağlantısını_tıkla(String string) {
        adminDashboardPage.tpaManagementLink.click(); // TPA Management bağlantısına tıkla
        logger.info("TPA Management bağlantısı tıklandı.");

    }
    @Step("TPA Management sayfasına yönlendirildiğini doğrular")
    @Then("TPA Management sayfasına yönlendirildiğini doğrular")
    public void tpa_management_sayfasına_yönlendirildiğini_doğrular() {
        Assert.assertTrue(adminDashboardPage.tpaManagementPageTitle.isDisplayed()); // Başlık görünürlüğünü kontrol et
        logger.info("TPA Management sayfasına yönlendirildiği doğrulandı.");

    }
    @Step("TPA Yönetim Listesinde {name}, {code}, {phone}, {address}, {contactPersonName} ve {contactPersonPhone} sütunlarının görüntülendiğini doğrular")
    @Then("TPA Yönetim Listesinde {string}, {string}, {string}, {string}, {string} ve {string} sütunlarının görüntülendiğini doğrular")
    public void tpa_yönetim_listesinde_ve_sütunlarının_görüntülendiğini_doğrular(String name, String code, String phone, String address, String contactPersonName, String contactPersonPhone) {
        Assert.assertTrue(name + " sütunu görüntülenmiyor.", adminDashboardPage.nameButton.isDisplayed());
        Assert.assertTrue(code + " sütunu görüntülenmiyor.", adminDashboardPage.codeButton.isDisplayed());
        Assert.assertTrue(phone + " sütunu görüntülenmiyor.", adminDashboardPage.phoneButton.isDisplayed());
        Assert.assertTrue(address + " sütunu görüntülenmiyor.", adminDashboardPage.addressButton.isDisplayed());
        Assert.assertTrue(contactPersonName + " sütunu görüntülenmiyor.", adminDashboardPage.contactPersonNameButton.isDisplayed());
        Assert.assertTrue(contactPersonPhone + " sütunu görüntülenmiyor.", adminDashboardPage.contactPersonPhoneButton.isDisplayed());
        logger.info("TPA Yönetim Listesindeki sütunlar doğrulandı.");

    }
    @Step("Kayıtları filtrelemek için bir arama kutusunun bulunduğunu doğrular")
    @Then("Kayıtları filtrelemek için bir arama kutusunun bulunduğunu doğrular")
    public void kayıtları_filtrelemek_için_bir_arama_kutusunun_bulunduğunu_doğrular() {
        Assert.assertTrue("Arama kutusu bulunamadı.", adminDashboardPage.searchBox.isDisplayed());
        logger.info("Arama kutusunun bulunduğu doğrulandı.");

    }
    @Step("Görüntülenen kayıt sayısını değiştirmek için yüz ve all seçeneklerinin mevcut olduğunu doğrular")
    @Then("Görüntülenen kayıt sayısını değiştirmek için yuz ve all seçeneklerinin mevcut olduğunu doğrular")
    public void görüntülenenKayıtSayısınıDeğiştirmekIçinYuzVeAllSeçeneklerininMevcutOlduğunuDoğrular() {

         adminDashboardPage.allYuzButton.click();
         ReusableMethods.selectByVisibleText(adminDashboardPage.allYuzButton, "100");
         String selectedOption = adminDashboardPage.allYuzButton.getAttribute("value");
         Assert.assertEquals("100 seçeneği seçilemedi.", selectedOption, "100");
         ReusableMethods.selectByVisibleText(adminDashboardPage.allYuzButton, "All");
         selectedOption = adminDashboardPage.allYuzButton.getAttribute("value");
         Assert.assertEquals("All seçeneği seçilemedi.", selectedOption, "-1");
         logger.info("Yüz ve All seçeneklerinin mevcut olduğu doğrulandı.");

    }
    @Step("Her bir sütun başlığına tıklayarak listenin sıralanabildiğini doğrular")
    @Then("Her bir sütun başlığına tıklayarak listenin sıralanabildiğini doğrular")
    public void her_bir_sütun_başlığına_tıklayarak_listenin_sıralanabildiğini_doğrular() {

        adminDashboardPage.areWebElementTextsSorted(adminDashboardPage.nameColumnCells);
        adminDashboardPage.areWebElementTextsSorted(adminDashboardPage.codeColumnCells);
        adminDashboardPage.areWebElementTextsSorted(adminDashboardPage.phoneColumnCells);
        adminDashboardPage.areWebElementTextsSorted(adminDashboardPage.addressColumnCells);
        adminDashboardPage.areWebElementTextsSorted(adminDashboardPage.contactPersonNameColumnCells);
        adminDashboardPage.areWebElementTextsSorted(adminDashboardPage.contactPersonPhoneColumnCells);
        logger.info("Her bir sütun başlığına tıklanarak listenin sıralanabildiği doğrulandı.");

    }
    @Step("TPA Add penceresinde Name, Code, Contact No, Address, Contact Person Name ve Contact Person Phone giriş alanlarının mevcut olduğunu doğrular")
    @Then("TPA Add penceresinde Name,Code,Contact No,Address,Contact Person Name ve Contact Person Phone  giriş alanlarının mevcut olduğunu doğrular")
    public void tpaAddPenceresindeNameCodeContactNoAddressContactPersonNameVeContactPersonPhoneGirişAlanlarınınMevcutOlduğunuDoğrular() {

        adminDashboardPage.addButton.click();
        ReusableMethods.wait(3);
        Assert.assertTrue("Name giriş alanı bulunamadı!", adminDashboardPage.nameField.isDisplayed());
        Assert.assertTrue("Code giriş alanı bulunamadı!", adminDashboardPage.codeField.isDisplayed());
        Assert.assertTrue("Contact No giriş alanı bulunamadı!", adminDashboardPage.contactNoField.isDisplayed());
        Assert.assertTrue("Address giriş alanı bulunamadı!", adminDashboardPage.addressField.isDisplayed());
        Assert.assertTrue("Contact Person Name giriş alanı bulunamadı!", adminDashboardPage.contactPersonNameField.isDisplayed());
        Assert.assertTrue("Contact Person Phone giriş alanı bulunamadı!", adminDashboardPage.contactPersonPhoneField.isDisplayed());
        logger.info("TPA Add penceresindeki giriş alanlarının mevcut olduğu doğrulandı.");

    }
    @Step("TPA Ekleme penceresindeki tüm alanlara geçerli veriler girer ve Save düğmesine tıklar")
    @When("TPA Ekleme penceresindeki tüm alanlara geçerli veriler girer ve Save düğmesine tıklar")
    public void tpa_ekleme_penceresindeki_tüm_alanlara_geçerli_veriler_girer() {
        adminDashboardPage.nameField.sendKeys("Hurrem");
        adminDashboardPage.codeField.sendKeys("16");
        adminDashboardPage.contactNoField.sendKeys("54387542");
        adminDashboardPage.addressField.sendKeys("Bursa");
        adminDashboardPage.contactPersonNameField.sendKeys("Ali");
        adminDashboardPage.contactPersonPhoneField.sendKeys("875785");
        ReusableMethods.wait(2);
        adminDashboardPage.addSaveSubmit.click();
        logger.info("TPA Ekleme penceresindeki tüm alanlara geçerli veriler girildi ve Save düğmesine tıklandı.");

    }
    @Step("Yeni kaydın TPA Yönetim Listesinde görüntülendiğini doğrular")
    @Then("Yeni kaydın TPA Yönetim Listesinde görüntülendiğini doğrular")
    public void yeni_kaydın_tpa_yönetim_listesinde_görüntülendiğini_doğrular() {
        ReusableMethods.wait(2);
        Assert.assertTrue(adminDashboardPage.nameColumnCells.get(0).getText().equalsIgnoreCase("Hurrem"));
        logger.info("Yeni kaydın TPA Yönetim Listesinde görüntülendiği doğrulandı.");

    }

    @Step("TPA Yönetim Listesinde {string} sütununun altındaki bir ismin üzerine gelinir")
    @Given("TPA Yönetim Listesinde {string} sütununun altındaki bir ismin uzerine gelirim")
    public void tpa_yönetim_listesinde_sütununun_altındaki_bir_kaydı_bulurum(String string) {
        ReusableMethods.hover(adminDashboardPage.contactPersonPhoneColumnCells.get(0));
        ReusableMethods.wait(1);
        logger.info("TPA Yönetim Listesinde " + string + " sütununun altındaki bir ismin üzerine gelindi.");

    }
    @Step("Edit işlemiyle kaydın detaylarını günceller")
    @When("Edit işlemiyle kaydın detaylarını güncellenir")
    public void edit_işlemiyle_kaydın_detaylarını_güncellerim() {
        adminDashboardPage.editbutton.click();
        adminDashboardPage.editfield(adminDashboardPage.nameFieldEdit, "Yeni");
        adminDashboardPage.editfield(adminDashboardPage.codeFieldEdit, "Yeni");
        adminDashboardPage.editfield(adminDashboardPage.contactNoFieldEdit, "Yeni");
        adminDashboardPage.editfield(adminDashboardPage.addressFieldEdit, "Yeni");
        adminDashboardPage.editfield(adminDashboardPage.contactPersonNameFieldEdit, "Yeni");
        adminDashboardPage.editfield(adminDashboardPage.contactPersonPhoneFieldEdit, "Yeni");
        adminDashboardPage.saveButtonEdit.click();
        logger.info("Edit işlemiyle kaydın detayları güncellendi.");
    }

    @Step("Silme işlemi gerçekleştirilir")
    @When("Silme işlemi gerçekleştirilir")
    public void silme_işlemini_gerçekleştiririm() {
        ReusableMethods.hover(adminDashboardPage.contactPersonPhoneColumnCells.get(0));
        ReusableMethods.wait(3);
        adminDashboardPage.deleteButton.click();
        // Alert popup'ını bekleme ve kabul etme
        Alert alert = driver.switchTo().alert();
        alert.accept();
        logger.info("Silme işlemi gerçekleştirildi.");

    }
    @Step("Organization butonunu kontrol eder")
    @When("Organization butonu kontrol edilir")
    public void organization_butonunu_kontrol_ederim() {
        ReusableMethods.hover(adminDashboardPage.contactPersonPhoneColumnCells.get(0));
        ReusableMethods.wait(3);
        adminDashboardPage.organizationButton.click();
        Assert.assertTrue(adminDashboardPage.TPAName.isDisplayed());
        logger.info("Organization butonunun çalıştığı doğrulandı.");


    }


}
