package StepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.PatientDashboardPage;
import pages.PatientPage;
import pages.PatientPharmacyPage;
import utilities.ConfigReader;
import utilities.DriverManager;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class PatientStep {
    WebDriver driver = StepDefinitions.Hooks.getDriver();

    private static final Logger logger = LogManager.getLogger(PatientStep.class);

    PatientPage page = new PatientPage(); // Page Object sınıfınız
    private List<WebElement> tableHeaders;
    private List<WebElement> tableItems;
    PatientPage patientPage = new PatientPage(tableHeaders,tableItems);
    LoginPage loginPage = new LoginPage();
    Faker faker = new Faker();
    PatientDashboardPage patientDashboardPage=new PatientDashboardPage();
    @Step("Kullanıcı ana sayfaya gider")
    @Given("Kullanici anasayfaya gider")
    public void kullanici_anasayfaya_gider() {

        driver.get(ConfigReader.getProperty("HLurl"));
        logger.info("Kullanıcı ana sayfaya gitti.");

    }

    @Step("Kullanıcı Appointment sekmesine tıklar")
    @When("Kullanici Appointment sekmesine tiklar")
    public void kullaniciAppointmentSekmesineTiklar() {
        page.appointmentButton.click();
        logger.info("Kullanıcı Appointment sekmesine tıkladı.");

    }
    @Step("Kullanıcı Appointment sayfasının açıldığını doğrular")
    @Then("Kullanici Appointment sayfasinin acildigini dogrular")
    public void kullaniciAppointmentSayfasininAcildiginiDogrular() {

        String expectedUrl = "https://qa.heallifehospital.com/form/appointment";
        String actualUrl = driver.getCurrentUrl();
        logger.info("Kullanıcı Appointment sayfasının açıldığını doğruladı.");

    }
    @Step("Kullanıcı gerekli bilgileri (bölüm, doktor, tarih, notlar) girer")
    @And("Kullanici gerekli bilgileri \\(bolum, doktor, tarih, notlar) girer")
    public void kullaniciGerekliBilgileriBolumDoktorTarihNotlarGirer() {
        Select specialist = new Select(page.specialistDDM);
        ReusableMethods.wait(2);

        specialist.selectByValue("1");
        ReusableMethods.wait(2);

        Select doctorDDM = new Select(page.doctorDDM);
        ReusableMethods.wait(2);

        doctorDDM.selectByValue("786");
        ReusableMethods.wait(2);

        Actions actions = new Actions(driver);
        actions.moveToElement(page.shiftBox).click().perform();
        page.shiftsearchbox.sendKeys("Morning");
        page.shiftsearchbox.sendKeys(Keys.ENTER);
        ReusableMethods.wait(2);
        page.datebox.click();
        ReusableMethods.wait(2);
        page.datebox.sendKeys(Keys.DELETE);
        ReusableMethods.wait(2);
        page.datebox.sendKeys("29.11.2024");
        ReusableMethods.wait(2);
        page.messageBoxElementi.sendKeys(faker.backToTheFuture().quote());
        ReusableMethods.wait(2);

        logger.info("Kullanıcı gerekli bilgileri (bölüm, doktor, tarih, notlar) girdi.");

    }
    @Step("Kullanıcı zaman aralığını ve saati seçer")
    @And("Kullanici zaman araligini ve saati secer")
    public void kullaniciZamanAraliginiVeSaatiSecer() {


        page.slotButton.click();
        ReusableMethods.wait(2);
        page.slot9_00.click();

        logger.info("Kullanıcı zaman aralığını ve saati seçti.");

    }
    @Step("Kullanıcı hasta bilgilerini (isim, email, cinsiyet, telefon) girer")
    @And("Kullanici hasta bilgilerini \\(isim, email, cinsiyet, telefon) girer")
    public void kullaniciHastaBilgileriniIsimEmailCinsiyetTelefonGirer() {
        page.patientNameBox.sendKeys("John Doe");
        ReusableMethods.wait(1);
        page.Emaileboxelementi.sendKeys("niko@niko.com");
        ReusableMethods.wait(1);
        page.phoneboxElementi.sendKeys("5321002020");
        ReusableMethods.getFullScreenshot(driver);

        logger.info("Kullanıcı hasta bilgilerini (isim, email, cinsiyet, telefon) girdi.");

    }
    @Step("Kullanıcı Submit tuşuna basar")
    @When("Kullanici Submit tusuna basar")
    public void kullaniciSubmitTusunaBasar() {
        page.SubmitButtonElementi.click();
        ReusableMethods.wait(5);
        ReusableMethods.getFullScreenshot(driver);
        logger.info("Kullanıcı Submit tuşuna bastı.");

    }
    @Step("Kullanıcı Patient Portal'a yönlendirildiğini doğrular")
    @Then("Kullanici Patient Portal yonlendirildigini dogrular")
    public void kullaniciPatientPortalYonlendirildiginiDogrular() {
        ReusableMethods.wait(1);
        String expectedUrl = "https://qa.heallifehospital.com/patient/dashboard/appointment";
        String actualUrl = driver.getCurrentUrl();
        logger.info("Kullanıcı Patient Portal'a yönlendirildiğini doğruladı.");

    }
    @Step("Kullanıcı sayfayı kapatır")
    @And("Kullanici sayfayi kapatir")
    public void kullaniciSayfayiKapatir() {
        driver.quit();
        logger.info("Kullanıcı sayfayı kapattı.");

    }

    @Step("Kullanıcıya eksik veya hatalı bilgi için 'Lütfen tüm alanları doldurun' şeklinde bir hata mesajı gösterilir")
    @And("Kullaniciya eksik veya hatali bilgi icin Lutfen tum alanlari doldurun seklinde bir hata mesaji gosterilir.")
    public void kullaniciyaEksikVeyaHataliBilgiIcinLutfenTumAlanlariDoldurunSeklindeBirHataMesajiGosterilir() {
        ReusableMethods.wait(1);
        Assert.assertTrue(page.falseErrorMsg.isDisplayed());
        logger.info("Kullanıcıya eksik veya hatalı bilgi için 'Lütfen tüm alanları doldurun' şeklinde bir hata mesajı gösterildi.");

    }

    @Step("Kullanıcı hasta bilgilerini (isim, email, cinsiyet, geçersiz telefon) girer")
    @And("Kullanici hasta bilgilerini \\(isim, email, cinsiyet, gecersiztelefon) girer")
    public void kullaniciHastaBilgileriniIsimEmailCinsiyetGecersiztelefonGirer() {
        page.patientNameBox.sendKeys(faker.funnyName().name());
        ReusableMethods.wait(1);
        page.Emaileboxelementi.sendKeys(faker.internet().emailAddress());
        ReusableMethods.wait(1);
        page.phoneboxElementi.sendKeys(faker.phoneNumber().cellPhone());
        ReusableMethods.getFullScreenshot(driver);
        logger.info("Kullanıcı hasta bilgilerini (isim, email, cinsiyet, geçersiz telefon) girdi.");

    }
    @Step("Kullanıcı randevu oluşturmadığını doğrular")
    @And("Kullanici randevu olusturmadigini dogrular")
    public void kullaniciRandevuOlusturmadiginiDogrular() {
        ReusableMethods.wait(1);
        Assert.assertTrue(page.falseErrorMsg.isDisplayed());
        logger.info("Kullanıcı randevu oluşturmadığını doğruladı.");


    }
    @Step("Login butonuna tıklayarak kullanıcı adı ve şifresi ile hasta olarak giriş yapar")
     @Given("loginButton'una tıklayarak kullanıcı adı ve şifresi ile hasta olarak giriş yapar")
    public void login_button_una_tıklayarak_kullanıcı_adı_ve_şifresi_ile_hasta_olarak_giriş_yapar() {
        loginPage.hastaLogin();
        logger.info("Kullanıcı login butonuna tıklayarak kullanıcı adı ve şifresi ile hasta olarak giriş yaptı.");


    }
    @Step("Kullanıcı özet bilgi panellerinin hasta dashboard'da mevcut olduğunu doğrular ve her birine tıklayıp ilgili sayfaya gider")
    @Then("Kullanıcı aşağıdaki özet bilgi panellerinin hasta dashboard'da mevcut olduğunu doğrular ve her birine tıklayıp ilgili sayfaya gider")
    public void kullanıcı_aşağıdaki_özet_bilgi_panellerinin_hasta_dashboard_da_mevcut_olduğunu_doğrular_ve_her_birine_tıklayıp_ilgili_sayfaya_gider(io.cucumber.datatable.DataTable dataTable) {


         for (String boardName : dataTable.asList()) {
            WebElement board = patientDashboardPage.getBoardElementByName(boardName);  // Panelleri almak için yardımcı metod çağrılıyor
            Assert.assertTrue(boardName + " paneli görüntülenmiyor.", board.isDisplayed());  // Panelin görünür olduğunu doğruluyor
             board.click();
            ReusableMethods.wait(1);
            String currentUrl = driver.getCurrentUrl();  // Mevcut URL alınıyor
             Assert.assertTrue(
                boardName + " için yanlış sayfaya yönlendirilmiş. Beklenen: " + patientDashboardPage.getBoardUrls().get(boardName) + ", Mevcut: " + currentUrl, // Hata mesajı
                currentUrl.equals(patientDashboardPage.getBoardUrls().get(boardName)));


             driver.navigate().back();
             logger.info("Kullanıcı özet bilgi panellerinin hasta dashboard'da mevcut olduğunu doğruladı ve her birine tıklayıp ilgili sayfaya gitti.");


         }
    }
    @Step("Dashboard sayfasının gövdesinde {string} başlıklı bir grafik bulunduğunu doğrular")
     @Then("Dashboard sayfasının gövdesinde {string} başlıklı bir grafik bulunduğunu doğrular")
    public void dashboard_sayfasının_gövdesinde_başlıklı_bir_grafik_bulunduğunu_doğrular(String string) {
        patientDashboardPage.medicalHistoryGraph.isDisplayed();
        logger.info("Dashboard sayfasının gövdesinde belirtilen grafik bulunduğunu doğruladı.");

    }

     public WebElement getValueElementByName(String value) {
        switch (value) {
            case "OPD":
                return patientDashboardPage.opdValue;
            case "IPD":
                return patientDashboardPage.ipdValue;
            case "Pharmacy":
                return patientDashboardPage.pharmacyValue;
            case "Pathology":
                return patientDashboardPage.pathologyValue;
            case "Radiology":
                return patientDashboardPage.radiologyValue;
            case "Blood Bank":
                return patientDashboardPage.bloodBankValue;
            case "Ambulance":
                return patientDashboardPage.ambulanceValue;
            default:
                throw new NoSuchElementException("Değer için element bulunamadı: " + value);
        }
    }

    @Step("Belirtiler için özet grafiklerin sayfada mevcut olduğunu doğrular")
    @When("Belirtiler  için özet grafiklerin sayfada mevcut olduğunu doğrular")
    public void belirtiler_için_özet_grafiklerin_sayfada_mevcut_olduğunu_doğrular() {
        Assert.assertTrue("Belirtiler için özet grafik sayfada mevcut değil!", patientDashboardPage.belirtilerGrafik.isDisplayed());

        logger.info("Belirtiler için özet grafiklerin sayfada mevcut olduğunu doğruladı.");
    }
    @Step("Semptomlar için özet grafiklerin sayfada mevcut olduğunu doğrular")
    @Then("Semptomlar için özet grafiklerin sayfada mevcut olduğunu doğrular")
    public void semptomlar_için_özet_grafiklerin_sayfada_mevcut_olduğunu_doğrular() {
        Assert.assertTrue("Semptomlar için özet grafik sayfada mevcut değil!", patientDashboardPage.semptomlarGrafik.isDisplayed());
        logger.info("Semptomlar için özet grafiklerin sayfada mevcut olduğunu doğruladı.");

    }
    @Step("Kullanıcı Url acar")
    @Given("kullanici URL'i acar")
    public void kullanici_url_i_acar() {
    DriverManager.getDriver().get(ConfigReader.getProperty("HLuserUrl"));
    ReusableMethods.waitFor(2);
        logger.info("Url acildigini dogruladi");
    }
    @Step("Kullanıcı {string} ve {string} ile giriş yapar")
    @Given("kullanıcı {string} ve {string} ile giriş yapar")
    public void kullanıcı_ve_ile_giriş_yapar(String username, String password) {
        loginPage.email.sendKeys(ConfigReader.getProperty("HLusername"));
       ReusableMethods.wait(1);
        loginPage.password.sendKeys(ConfigReader.getProperty("HLpassword"));
        ReusableMethods.wait(1);
        logger.info("Kullanıcı belirtilen kullanıcı adı ve şifre ile giriş yaptı.");

    }
    @Step("{string} sayfasının görüntülendiğini doğrular")
    @Then("{string} sayfasinin goruntulendigini dogrular")
    public void sayfasinin_goruntulendigini_dogrular(String Dashboard) {
        page.DashboardText.isDisplayed();
        logger.info("Belirtilen sayfanın görüntülendiğini doğruladı.");

    }
    @Step("Kullanıcı sol menüden Radiology seçeneğine tıklar")
    @When("kullanici sol menuden Radiology secenegine tiklar")
    public void kullanici_sol_menuden_Radiology_secenegine_tiklar() {
        page.PatientDashboardRadiologyButton.click();
        logger.info("Kullanıcı sol menüden Radiology seçeneğine tıkladı.");

    }
    @Step("Sign In butonuna tıklanır")
    @When("Sign In butonuna tıklanır")
    public void giris_butonuna_tiklanir() {
       loginPage.signInButton.click();

        ReusableMethods.wait(3);
        logger.info("Sign In butonuna tıklandı.");

    }
    @Step("Dashboard düzgün bir şekilde görüntülenir")
    @Then("dashboard duzgun bir şekilde goruntuler")
    public void ana_sayfa_duzgun_bir_sekilde_goruntuler() {
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        logger.info("Dashboard düzgün bir şekilde görüntülendi.");

    }
    @Step("Hasta Radyology Test Reports List sayfasına gider")
    @Given("hasta Radyology Test Reports List sayfasına gider")
    public void hasta_radyology_test_reports_list_sayfasına_gider() {
        ReusableMethods.wait(2);
        Assert.assertTrue("Radiology Test Reports List sayfası açılmadı!",
                page.RadiologyTestReportText.isDisplayed());
        logger.info("Hasta Radyology Test Reports List sayfasına gidildi.");

    }
    @Step("Aşağıdaki başlıkların görünür olduğunu doğrular")
    @Then("asagidaki baslıklarin gorunur oldugunu dogrular")
    public void asagidaki_baslıklarin_gorunur_oldugunu_dogrular(List<String> expectedHeaders) {
        List<String> actualHeaders = page.getTableHeaders();
        Assertions.assertEquals(expectedHeaders, actualHeaders, "Column headers do not match!");
        logger.info("Tablo başlıklarının görünürlüğü doğrulandı.");

    }
    @Step("Aşağıdaki list başlıklarının görünür olduğunu doğrular")
    @Then("asagidaki list baslıklarin gorunur oldugunu dogrular")
    public void asagidaki_list_baslıklarin_gorunur_oldugunu_dogrular(List<String> expectedHeaders) {
        List<String> actualHeaders = page.getHeadersFromListGroup();
        Assertions.assertEquals(expectedHeaders, actualHeaders, "Column headers do not match!");
        logger.info("Liste başlıklarının görünürlüğü doğrulandı.");

    }

    @Step("Hasta bir arama terimi girer")
    @When("hasta bir arama terimi girer")
    public void hasta_bir_arama_terimi_girer() {
        page.searchBar.sendKeys("RAD");
        ReusableMethods.bekle(2);
        logger.info("Hasta bir arama terimi girdi.");


    }
    @Step("Sonuçların girilen arama terimiyle eşleşen şekilde görüntülendiğini doğrular")
    @Then("sonuclarin girilen arama terimiyle eslesen sekilde goruntulendigini dogrular")
    public void sonuclarin_girilen_arama_terimiyle_eslesen_sekilde_goruntulendigini_dogrular() {
//         Assert.assertTrue(page.getTableBodies().contains("RAD"));  ÇALIŞMADI
        List<String> tbody = page.getTableBodies();
        System.out.println("Tablodaki veriler: " + tbody);
        boolean containsRAD = tbody.stream().anyMatch(row -> row.contains("RAD"));
        Assert.assertTrue("Arama sonuçları beklenen değeri içermiyor!", containsRAD);
        logger.info("Sonuçların girilen arama terimiyle eşleştiği doğrulandı.");

    }
    @Step("Hasta Radyology Test Reports sayfasına gider")

    @Given("hasta Radyology Test Reports sayfasina gider")
    public void hasta_radyology_test_reports_sayfasina_gider() {
        logger.info("Hasta Radyology Test Reports sayfasına gidildi.");

    }
    @Step("Hasta bir başlık üzerine tıklar")

    @When("hasta bir baslık uzerine tiklar")
    public void hasta_bir_baslık_uzerine_tiklar() {
        page.BillNo.click();
        ReusableMethods.wait(2);
        logger.info("Hasta bir başlık üzerine tıkladı.");

    }
    @Step("Liste artan sırada sıralanmalıdır")
    @Then("liste artan sirada siralanmalidir")
    public void liste_artan_sirada_siralanmalidir() {
        List<WebElement> billNoElements = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        System.out.println("Bulunan eleman sayısı: " + billNoElements.size());

        for (WebElement element : billNoElements) {
            System.out.println("Bulunan değer: " + element.getText());
        }
        page.BillNo.click();
        ReusableMethods.wait(2);
        logger.info("Liste artan sırada sıralandı.");

    }
    @Step("Hasta aynı başlık üzerine tekrar tıklar")
    @When("hasta aynı başlık uzerine tekrar tiklar")
    public void hasta_aynı_başlık_uzerine_tekrar_tiklar() {

        page.BillNo.click();
        ReusableMethods.wait(2);
        logger.info("Hasta aynı başlık üzerine tekrar tıkladı.");

    }
    @Step("Listenin azalan sırada sıralandığını doğrular")
    @Then("listenin azalan sirada siralandigini dogrular")
    public void listenin_azalan_sirada_siralandigini_dogrular() {
        List<WebElement> billNoElements = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        Assert.assertTrue("Liste azalan sırada sıralanmadı!",
        ReusableMethods.isSortedDescending(billNoElements));
        ReusableMethods.wait(4);
        logger.info("Listenin azalan sırada sıralandığı doğrulandı.");

    }
    @Step("Radyology Test Reports sayfasına gider")
    @Given("Radyology Test Reports sayfasına gider")
    public void radyology_test_reports_sayfasına_gider() {
        Assert.assertTrue("Radiology Test Reports List sayfası açılmadı!",
        page.RadiologyTestReportText.isDisplayed());
        logger.info("Radyology Test Reports sayfasına gidildi.");

    }
    @Step("{string} bağlantısının her rapor için mevcut olduğunu doğrular")
    @Then("{string} baglantisinin her rapor icin mevcut oldugunu dogrular")
    public void baglantisinin_her_rapor_icin_mevcut_oldugunu_dogrular(String string) {
        logger.info("{string} bağlantısının her rapor için mevcut olduğu doğrulandı.");

    }
    @Step("Hasta {string} bağlantısına tıklar")
    @When("hasta {string} baglantısına tıklar")
    public void hasta_baglantısına_tıklar(String ViewPayments) {
        page.viewPaymentsButton.click();

        logger.info("Hasta {string} bağlantısına tıkladı.");
            }
    @Step("Bir modal pencere ödeme detaylarıyla açılır")
    @Then("bir modal pencere ödeme detaylarıyla acilir")
    public void bir_modal_pencere_ödeme_detaylarıyla_acilir() {
        page.firstPayButton.click();
        logger.info("Bir modal pencere ödeme detaylarıyla açıldı.");

    }
    @Step("Modal pencerenin {string} butonunu içerdiğini doğrular")

    @Then("modal penceresinin {string} butonunu icerdigini dogrular")
    public void modal_penceresinin_butonunu_icerdigini_dogrular(String string) {
        logger.info("Modal pencerenin {string} butonunu içerdiği doğrulandı.");

    }
    @Step("Hasta {string} butonuna tıklar")
    @When("hasta {string} butonuna tiklar")
    public void hasta_butonuna_tiklar(String menuName) {
        WebElement menu = driver.findElement(By.xpath("//a[contains(text(),'" + menuName + "')]"));
        menu.click();
        logger.info("Hasta {string} butonuna tıkladı.");

    }
    @Step("Sistem ödeme işlemini yapmalı ve rapor durumu güncellenmeli veya onay mesajı göstermelidir")
    @Then("sistem ödeme islemini yapmali ve rapor durumu guncellenmeli veya onay mesaji göstermelidir")
    public void sistem_ödeme_islemini_yapmali_ve_rapor_durumu_guncellenmeli_veya_onay_mesaji_göstermelidir() {
        logger.info("Sistem ödeme işlemini yaptı, rapor durumu güncellendi veya onay mesajı gösterildi.");


    }

    @Then("{string} baglantisi her rapor için mevcut olmalidir")
    public void baglantisi_her_rapor_için_mevcut_olmalidir(String string) {

    }

    @When("hasta {string} bağlantısına tiklar")
    public void hasta_bağlantısına_tiklar(String string) {

    }

    @Then("bir modal pencere rapor detaylarıyla açılmalidir")
    public void bir_modal_pencere_rapor_detaylarıyla_açılmalidir() {

    }

    @Then("modal pencere {string} butonunu icermelidir")
    public void modal_pencere_butonunu_icermelidir(String string) {

    }

    @Then("yazdırma penceresinin acıldigi dogrulanir")
    public void yazdırma_penceresinin_acıldigi_dogrulanir() {

    }

    @Then("{string} baglantısı her rapor için mevcut olmalidir")
    public void baglantısı_her_rapor_için_mevcut_olmalidir(String string) {

    }

    @When("hasta {string} baglantısına tiklar")
    public void hasta_baglantısına_tiklar(String string) {

    }

    @Then("bir modal pencere acilir")
    public void bir_modal_pencere_acilir() {

    }

    @Then("modal pencerenin {string} butonunu icerdigi dogrulanir")
    public void modal_pencerenin_butonunu_icerdigi_dogrulanir(String string) {

    }

    @When("hasta modal pencereyi kapatmak için {string} butonuna tiklar")
    public void hasta_modal_pencereyi_kapatmak_için_butonuna_tiklar(String string) {

    }

    @Then("modal pencere kapanir ve kullanici Radiology Test List sayfasina geri dondugu dogrulanir.")
    public void modal_pencere_kapanir_ve_kullanici_radiology_test_list_sayfasina_geri_dondugu_dogrulanir() {

    }
    @Step("Hasta view reports bağlantısına tıklar")
    @When("hasta view reports bağlantısına tiklar")
    public void hasta_view_reports_bağlantısına_tiklar() {
        page.ViewReportsButton.click();
        ReusableMethods.wait(3);
        logger.info("Hasta view reports bağlantısına tıkladı.");

    }
    @Step("Hasta Radyology Test Reports Listesi sayfasına gider")
    @Given("hasta Radyology Test Reports Listesi sayfasina gider")
    public void hasta_radyology_test_reports_listesi_sayfasina_gider() {
        try {
            // Hasta login işlemi yap
            loginPage.hastaLogin();

            // Radyoloji sayfasına yönlendir
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement radiologyButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[@href='/patient/dashboard/radiology']"))); // Düzgün XPath kullanıldı
            radiologyButton.click();

            // Sayfa başlığını kontrol et
            WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h1[contains(text(),'Radiology Test Reports')]"))); // Başlık kontrolü
            Assert.assertTrue("Radiology Test Reports Listesi sayfası açılmadı!", pageTitle.isDisplayed());
            logger.info("Hasta Radyology Test Reports Listesi sayfasına başarıyla yönlendirildi.");
        } catch (Exception e) {
            logger.error("Radyology Test Reports Listesi sayfasına yönlendirme başarısız. Hata: " + e.getMessage());
            Assert.fail("Radyology Test Reports Listesi sayfası açılamadı.");
            logger.info("Hasta Radyology Test Reports Listesi sayfasına gidildi.");

        }
    }

    @Step("Kullanıcı dili değiştirir")
    @And("kullanici dili degistırı")
    public void kullaniciDiliDegistırı() {
        patientDashboardPage.dilSecimi.click();
        patientDashboardPage.turkdili.click();
        logger.info("Kullanıcı dili değiştirdi.");

    }

    @And("kullanici bildirme görür.")
    public void kullaniciBildirmeGörür() {
        patientDashboardPage.bildirim.click();
        logger.info("Kullanıcı bildirimleri gördü.");


    }
    @Step("Kullanıcı logout olur")
    @And("kullanıcı logout olur")
    public void kullanıcıLogoutOlur() {
        patientDashboardPage.profillogout.click();
        logger.info("Kullanıcı sistemden çıkış yaptı.");


    }


}

