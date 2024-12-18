package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DriverManager;
import utilities.ReusableMethods;

public class LoginStep {
    WebDriver driver = StepDefinitions.Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(LoginStep.class);
    LoginPage loginPage = new LoginPage();

    @Step("Kullanıcı Heal Life sitesine giriş yapar")
    @Given("Kullanıcı Heal Life sitesine giriş yapar")
    public void kullanici_heal_life_sitesine_giris_yapar() {
        DriverManager.getDriver().get(ConfigReader.getProperty("HLadminUrl"));
        logger.info("Kullanıcı contact_us sayfasına açıldığını doğruladı.");

    }

    @Then("Login sayfasinin sag tarafinda Admin Login penceresi görüntülenmeli")
    public void login_sayfasinin_sag_tarafinda_admin_login_penceresi_görüntülenmeli() {
        int adminLoginPanelX = loginPage.adminLoginPenceresi.getLocation().getX();
        Assert.assertTrue("Admin login penceresi sagda gorunuyor", adminLoginPanelX > 500);
        logger.info("Kullanıcı contact_us linkine tıkladı.");

    }

    @Step("Login sayfasının sağ tarafında Admin Login penceresi görüntülenmeli")
    @Then("Login sayfasinin sol tarafinda Latest New penceresi görüntülenmeli")
    public void login_sayfasinin_sol_tarafinda_latest_new_penceresi_görüntülenmeli() {
        int adminLatestNewX = loginPage.latestNewsPenceresi.getLocation().getY();
        Assert.assertTrue("Latest News Penceresi solda gorunuyor", adminLatestNewX < 500);
        logger.info("Login sayfasının sağ tarafında Admin Login penceresi görüntülendi.");

    }

    @Step("Username bölümüne doğru email girilir")
    @Then("username bolumune dogru email girilir")
    public void username_bolumune_dogru_email_girilir() {
        loginPage.email.sendKeys(ConfigReader.getProperty("DoctorMailLevent"));
        logger.info("Username bölümüne doğru email girildi.");

    }

    @Step("Password bölümüne doğru password girilir")
    @Then("password bolumune dogru password girilir")
    public void password_bolumune_dogru_password_girilir() {
        loginPage.password.sendKeys(ConfigReader.getProperty("Passwords"));
        logger.info("Password bölümüne doğru password girildi.");

    }

    @Step("Sign In butonuna tıklanır")
    @Then("sign in butonuna tiklanir")
    public void sign_in_butonuna_tiklanir() {
        loginPage.signInButton.click();
        logger.info("Sign In butonuna tıklandı.");

    }

    @Step("Heal Life logosu görüntülenir")
    @Then("heal life logosu görüntülenir")
    public void heal_life_logosu_görüntülenir() {
        Assert.assertTrue("Heal Life logosu görüntülendi", loginPage.adminLogo.isDisplayed());


        if (loginPage.adminLogo.isDisplayed()) {
            logger.info("Heal Life logosu başarılı bir şekilde görüntüleniyor.");
        } else {
            logger.error("Heal Life logosu görüntülenemedi.");
        }
        logger.info("Heal Life logosu görüntülendi.");

    }

    @Step("Username bölümüne yanlış data girilir")
    @Then("username bolumune yanlis data girilir")
    public void username_bolumune_yanlis_data_girilir() {
        loginPage.email.sendKeys("damla@gmail.com");
        logger.info("Username bölümüne yanlış data girildi.");

    }

    @Step("Password bölümüne yanlış data girilir")
    @Then("password bolumune yanlis data girilir")
    public void password_bolumune_yanlis_data_girilir() {
        loginPage.password.sendKeys("123456");
        logger.info("Password bölümüne yanlış data girildi.");


    }

    @Step("Sisteme giriş yapılamadığı ve admin penceresinin görünür olduğu doğrulanır.")
    @Then("sisteme giris yapilamadigi ve admin penceresinin gorunur oldugu dogrulanir.")
    public void sisteme_giris_yapilamadigi_ve_admin_penceresinin_gorunur_oldugu_dogrulanir() {
        Assert.assertTrue("Admin login penceresi görüntülenir, sisteme giriş yapilamadi", loginPage.adminLoginPenceresi.isDisplayed());
        logger.info("Sisteme giriş yapılamadığı ve admin penceresinin görünür olduğu doğrulandı.");

    }

    @Step("Forgot Password linkine tıklanır")
    @Then("forgot password linkine tiklanir")
    public void forgot_password_linkine_tiklanir() {
        loginPage.adminForgotPassword.click();
        logger.info("Forgot Password linkine tıklandı.");

    }
    @Step("Email alanına doğru data girilir")
    @Then("email alanina dogru data girilir")
    public void email_alanina_dogru_data_girilir() {
        loginPage.adminForgotPasswordEmail.sendKeys("levent@gmail.com");
        logger.info("Email alanına doğru data girildi.");

    }
    @Step("Submit butonuna tıklanır")
    @Then("submit butonuna tiklanir")
    public void submit_butonuna_tiklanir() {
        loginPage.adminForgotPasswordSubmitButton.click();
        logger.info("Submit butonuna tıklandı.");

    }
    @Step("Textbox'a girilen mail adresine şifre geldiği üstteki bilgi kutucuğu ile doğrulanır")
    @Then("textbox a girilen mail adresine sifre geldigi ustteki bilgi kutucugu ile dogrulanir")
    public void textbox_a_girilen_mail_adresine_sifre_geldigi_ustteki_bilgi_kutucugu_ile_dogrulanir() {
        Assert.assertTrue("Bilgi kutusu görüntülenir.", loginPage.forgotPasswordAlert.isDisplayed());
        logger.info("Textbox'a girilen mail adresine şifre geldiği üstteki bilgi kutucuğu ile doğrulandı.");

    }
    @Step("Admin login linkine tıklanır")
     public void admin_login_linkine_tiklanir() {
        loginPage.adminLoginLink.click();
        logger.info("Admin login linkine tıklandı.");

    }
    @Step("Admin ana sayfasında olduğu doğrulanır")
    @Then("admin anasayfasinda oldugu dogrulanir")
    public void admin_anasayfasinda_oldugu_dogrulanir() {
        Assert.assertTrue("Anasayfaya geri dönüş sağlandi", loginPage.adminLoginPenceresi.isDisplayed());
        logger.info("Admin ana sayfasında olduğu doğrulandı.");

    }
    @Step("Kullanıcı Heal Life {string} girer")
    @Given("Kullanici Heal Life {string}  girer")
    public void kullanici_heal_life_girer(String adminUrlKey) {
        String adminUrl = ConfigReader.getProperty(adminUrlKey);
        driver.get(adminUrl);
        logger.info("Kullanıcı Heal Life adresine gitti.");

    }
    @Step("Login sayfasının sağ tarafında Admin Login penceresi görüntülendiğini doğrular")
    @Then("Login sayfasinin sag tarafinda Admin Login penceresi görüntülendigini dogrular")
    public void login_sayfasinin_sag_tarafinda_admin_login_penceresi_görüntülendigini_dogrular() {

        loginPage.verifySectionVisibilityAndPosition("//div[@class='form-bottom']", "Admin Giriş bölümü", "sağ"
        );
        logger.info("Login sayfasının sağ tarafında Admin Login penceresi görüntülendi.");

    }
    @Step("Login sayfasının sol tarafında Latest New penceresi görüntülendiğini doğrular")
    @Then("Login sayfasinin sol tarafinda Latest New penceresi görüntülendigini dogrular")
    public void login_sayfasinin_sol_tarafinda_latest_new_penceresi_görüntülendigini_dogrular() {


        loginPage.verifySectionVisibilityAndPosition("//div[@class='col-lg-6 col-sm-6 col-sm-6']", "Latest Nes", "sol");
        logger.info("Login sayfasının sol tarafında Latest New penceresi görüntülendi.");

    }
    @Step("User Name Box'a tıklar")
    @When("User Name Box tiklar")
    public void user_name_box_tiklar() {

        loginPage.email.click();
        logger.info("User Name Box'a tıklandı.");

    }
    @Step("Geçerli User Name {string} girer")
    @Then("Gecerli User Name {string} Girer")
    public void gecerli_user_name_girer(String gecerliMail) {
        loginPage.email.sendKeys(gecerliMail);
        logger.info("Geçerli User Name girildi.");

    }
    @Step("Password Box'a tıklar")
    @Then("Password Box tiklar")
    public void password_box_tiklar() {
        loginPage.password.click();
        logger.info("Password Box'a tıklandı.");

    }
    @Step("Geçerli password {string} girer")
    @Then("Gecerli password {string} girer")
    public void gecerli_password_girer(String gecerliPassword) {
        loginPage.password.sendKeys(gecerliPassword);
        logger.info("Geçerli password girildi.");

    }
    @Step("Admin paneline yönlendirildiğini doğrular")
    @Then("Admin paneline yonlendirildigini dogrular")
    public void admin_paneline_yonlendirildigini_dogrular() {
        String expectedUrl = ConfigReader.getProperty("AdminDasboardUrl");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        logger.info("Admin paneline yönlendirildiği doğrulandı.");

    }
    @Step("Admin paneline giriş yapılamadığını doğrular")
    @Then("Admin paneline giris yapilamadigini dogrular")
    public void admin_paneline_giris_yapilamadigini_dogrular() {

        loginPage.forgotPasswordAlert.isDisplayed();
        logger.info("Admin paneline giriş yapılamadığı doğrulandı.");

    }

    @Then("Forgot Password yazisinin gorunurlugunu dogrular")
    public void forgot_password_yazisinin_gorunurlugunu_dogrular() {
        Assert.assertTrue(loginPage.adminForgotPassword.isDisplayed());
    }
    @Step("Forgot Password yazısının görünürlüğünü doğrular")
    @Then("Forgot Password'a tiklar")
    public void forgot_password_a_tiklar() {

        loginPage.adminForgotPassword.click();
        logger.info("Forgot Password yazısının görünürlüğü doğrulandı.");

    }
    @Step("Forgot Password'a tıklar")
    @Then("Forgot Password sayfasina yonlendirildigini dogrular")
    public void forgot_password_sayfasina_yonlendirildigini_dogrular() {

        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("forgotpassword"));
        logger.info("Forgot Password'a tıklandı.");

    }
    @Step("E-mail box'ına {string} girer")
    @Then("E mail box'ina {string} girer")
    public void e_mail_box_ina_girer(String email) {
        loginPage.adminForgotPasswordEmail.sendKeys(email);
         logger.info("E-mail box'ına bilgi girildi.");

    }
    @Step("Submit butonuna tıklar")
    @Then("Submit butonuna tıklar")
    public void submit_butonuna_tıklar() {
        loginPage.adminForgotPasswordSubmitButton.click();
        logger.info("Submit butonuna tıklandı.");

    }
    @Step("Admin Login linkinin görünürlüğünü doğrular")
    @Then("Admin Login linkinin gorunurlugunu dogrular")
    public void admin_login_linkinin_gorunurlugunu_dogrular() {
        Assert.assertTrue(loginPage.adminLoginLink.isDisplayed());
        logger.info("Admin Login linkinin görünürlüğü doğrulandı.");

    }

    @Step("Kullanıcı {string} adresine gider")
    @Given("kullanici {string} adresine gider")
    public void kullanici_adresine_gider(String url) {
        driver.get(ConfigReader.getProperty(url));
        logger.info("Kullanıcı adresine gitti.");

    }
    @Step("Geçerli bir email adresi {string} ve şifre {string} girer")
    @And("geçerli bir email adresi {string} ve sifre {string} girer")
    public void gecerli_bir_email_adresi_ve_sifre_girer(String email, String sifre) {
        loginPage.email.sendKeys(ConfigReader.getProperty(email));
        loginPage.password.sendKeys(ConfigReader.getProperty(sifre));
        logger.info("Geçerli bir email adresi ve şifre girildi.");


    }
    @Step("Sign In butonuna tıklar")
    @When("Sign In butonuna tıklar")
    public void giris_butonuna_tiklar() {
        loginPage.signInButton.click();
        logger.info("Sign In butonuna tıklandı.");

    }
    @Step("Dashboard düzgün bir şekilde görüntülenir")
    @Then("dashboard duzgun bir şekilde goruntulenir")
    public void ana_sayfa_duzgun_bir_sekilde_goruntulenir() {
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        logger.info("Dashboard düzgün bir şekilde görüntülendi.");

    }

    @Step("Kullanıcı Heal Life sitesine giriş yapar")
    @Then("Kullanıcı Heal Life sitesine giris yapar")
    public void kullanıcıHealLifeSitesineGirisYapar() {
        driver.manage().deleteAllCookies();
        driver.get("https://qa.heallifehospital.com/site/login");
        logger.info("Kullanıcı Heal Life sitesine giriş yaptı.");

    }
    @Step("Kullanıcı Username Box içine admin adını giriş yapar")
    @And("Kulllanci Username bax icine admin adini giris yapar")
    public void kulllanciUsernameBaxIcineAdminAdiniGirisYapar() {
        loginPage.email.sendKeys(ConfigReader.getProperty("AdminMailLevent"));
        logger.info("Kullanıcı Username Box içine admin adını giriş yaptı.");

    }
    @Step("Kullanıcı Password bölümüne admin password giriş yapar")
    @And("Kullanici password bolumune admin password girsi yapar")
    public void kullaniciPasswordBolumuneAdminPasswordGirsiYapar() {
        loginPage.password.sendKeys(ConfigReader.getProperty("Passwords"));
        logger.info("Kullanıcı Password bölümüne admin password giriş yaptı.");

    }
    @Step("Kullanıcı Sign In Button'una tıklar")
    @And("Kullanici Signin Buttonu tiklar")
    public void kullaniciSigninButtonuTiklar() {
        loginPage.signInButton.click();
        logger.info("Kullanıcı Sign In Button'una tıklandı.");

    }

    @Step("Login Button'una tıklayarak kullanıcı adı ve şifre ile giriş yapar")
    @And("loginButton'una tıklayarak ve kullanııc adı ve şifre ile giriş yapar")
    public void loginbuttonUnaTıklayarakVeKullanııcAdıVeŞifreIleGirişYapar() {
        loginPage.email.click();
        loginPage.email.sendKeys(ConfigReader.getProperty("pat116"));
        loginPage.password.click();
        loginPage.password.sendKeys(ConfigReader.getProperty("4bwui5"));
        logger.info("Login Button'una tıklayarak kullanıcı adı ve şifre ile giriş yaptı.");






    }

    @And("geçerli bir email adresi \\{string} ve sifre \\{string} girer")
    public void geçerliBirEmailAdresiStringVeSifreStringGirer() {
        loginPage.email.click();
        loginPage.email.sendKeys(ConfigReader.getProperty("pat116"));
        ReusableMethods.bekle(100);
        loginPage.password.click();
        loginPage.password.sendKeys(ConfigReader.getProperty("4bwui5"));
    }
}



