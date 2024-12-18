package StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AboutUsPage;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class AboutUsStep {
    WebDriver driver = StepDefinitions.Hooks.getDriver();
    private static final Logger logger = LogManager.getLogger(AboutUsStep.class);
    AboutUsPage page = new AboutUsPage();


    @Step("Kullanıcı header bölümünde yer alan AboutUs'a tıklar")
    @When("Kullanici header bolumunde yer alan AboutUs tiklar")

    public void kullanici_header_bolumunde_yer_alan_about_us_tiklar() {
        page.aboutUsButton.click();
        ReusableMethods.wait(4);
        logger.info("Kullanıcı header bölümünde yer alan AboutUs'a tıkladı.");

    }

    @Step("Kullanıcı aşağıdaki seçeneklerin alt About menüsünde olduğunu doğrular")
    @Then("Kullanici asagidaki seceklerin alt About menusunde oldugunu dogrular")
    public void kullanici_asagidaki_seceklerin_alt_about_menusunde_oldugunu_dogrular(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedOptions = dataTable.asList();

        WebElement aboutMenu = page.aboutUsButton;
        aboutMenu.click();

        List<WebElement> actualOptionsElements = page.aboutUsMenuDMM2; // XPath'i uygulamaya göre düzenle
        List<String> actualOptions = new ArrayList<>();
        for (WebElement option : actualOptionsElements) {
            actualOptions.add(option.getText());
            logger.info("Kullanıcı, alt About menüsündeki seçenekleri doğruluyor.");

        }
        System.out.println(expectedOptions);
        System.out.println(actualOptions);
        Assert.assertEquals(expectedOptions, actualOptions);
    }

    @Step("Kullanıcı About Hospitals başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular")
    @When("Ana sayfanın üst kısmında {string} menüsünün üzerine gelir")
    public void ana_sayfanın_üst_kısmında_menüsünün_üzerine_gelir(String menuName) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement aboutUsMenu = page.aboutUsDropdownMenu;
        actions.moveToElement(aboutUsMenu).perform();
        //aboutUsMenu.click();
        logger.info("{menuName} menüsünün üzerine gelindi.");
    }

    @Step("Kullanıcı About Hospitals başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular")
    @When("Kullanıcı About Hospitals başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular")
    public void kullanıcı_about_hospitals_başlığına_tıkladığında_ilgili_sayfaya_yönlendirildiğini_doğrular() {
        page.aboutHospitalsLink.click();
        // Sayfa URL'sinin doğruluğunu kontrol et
        String expectedUrl = "https://qa.heallifehospital.com/page/about-hospitals";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("Kullanıcı About Hospitals sayfasına yönlendirilemedi", expectedUrl, actualUrl);
        logger.info("Kullanıcı, About Hospitals sayfasına yönlendirildiğini doğruladı.");

    }

    @Step("Kullanıcı Meet Our Doctors başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular")
    @When("Kullanıcı Meet Our Doctors başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular")
    public void kullanıcı_meet_our_doctors_başlığına_tıkladığında_ilgili_sayfaya_yönlendirildiğini_doğrular() {
        page.Home.click();
        page.aboutUsDropdownMenu.click();
        page.meetOurDoctorsLink.click();

        String expectedUrl = "https://qa.heallifehospital.com/page/meet-our-doctors";
        String actualUrl = driver.getCurrentUrl();


        Assert.assertEquals("Kullanıcı Meet Our Doctors sayfasına yönlendirilemedi", expectedUrl, actualUrl);
        logger.info("Kullanıcı, Meet Our Doctors sayfasına yönlendirildiğini doğruladı.");

    }

    @Step("Kullanıcı FAQ's başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular")
    @When("Kullanıcı FAQ's başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular")
    public void kullanıcı_faq_s_başlığına_tıkladığında_ilgili_sayfaya_yönlendirildiğini_doğrular() {
        // İlk olarak Home sayfasına tıklanır
        page.Home.click();

        page.aboutUsDropdownMenu.click();

        page.faqsLink.click();

        String expectedUrl = "https://qa.heallifehospital.com/page/faq";  // FAQ's sayfasının URL'si
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("Kullanıcı FAQ's sayfasına yönlendirilemedi", expectedUrl, actualUrl);
        logger.info("Kullanıcı, FAQ's sayfasına yönlendirildiğini doğruladı.");

    }

    @Step("Kullanıcı Departments başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular")
    @When("Kullanıcı Departments başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular")
    public void kullanıcı_departments_başlığına_tıkladığında_ilgili_sayfaya_yönlendirildiğini_doğrular() {
        page.Home.click();

        page.aboutUsDropdownMenu.click();

        page.departmentsLink.click();

        String expectedUrl = "https://qa.heallifehospital.com/page/departments";  // Departments sayfasının URL'si
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("Kullanıcı Departments sayfasına yönlendirilemedi", expectedUrl, actualUrl);
        logger.info("Kullanıcı, Departments sayfasına yönlendirildiğini doğruladı.");

    }

    @Step("Kullanıcı Testimonials başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular")
    @When("Kullanıcı Testimonials başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular")
    public void kullanıcı_testimonials_başlığına_tıkladığında_ilgili_sayfaya_yönlendirildiğini_doğrular() {
        page.Home.click();

        page.aboutUsDropdownMenu.click();

        page.testimonialsLink.click();

        String expectedUrl = "https://qa.heallifehospital.com/page/testimonials";  // Testimonials sayfasının URL'si
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("Kullanıcı Testimonials sayfasına yönlendirilemedi", expectedUrl, actualUrl);
        logger.info("Kullanıcı, Testimonials sayfasına yönlendirildiğini doğruladı.");

    }

    @Step("Some Words About Us başlığının sayfada göründüğünü doğrulayın")
    @Then("Some Words About Us başlığının sayfada göründüğünü doğrulayın")
    public void some_words_about_us_başlığının_sayfada_göründüğünü_doğrulayın() {
        // "Some Words About Us" başlığının sayfada görünüp görünmediğini kontrol et
        Assert.assertTrue("Some Words About Us başlığı sayfada görünmüyor", page.someWordsAboutUsTitle.isDisplayed());
        logger.info("Some Words About Us başlığının sayfada göründüğü doğrulandı.");

    }

    @Step("Our Mission başlığının sayfada göründüğünü doğrulayın")
    @Then("Our Mission başlığının sayfada göründüğünü doğrulayın")
    public void our_mission_başlığının_sayfada_göründüğünü_doğrulayın() {
        // "Our Mission" başlığının sayfada görünüp görünmediğini kontrol et
        Assert.assertTrue("Our Mission başlığı sayfada görünmüyor", page.ourMissionTitle.isDisplayed());
        logger.info("Our Mission başlığının sayfada göründüğü doğrulandı.");

    }

    @Step("Opening Hours bilgisinin sayfada göründüğünü doğrulayın")
    @Then("Opening Hours bilgisinin sayfada göründüğünü doğrulayın")
    public void opening_hours_bilgisinin_sayfada_göründüğünü_doğrulayın() {
        // "Opening Hours" bilgisinin sayfada görünüp görünmediğini kontrol et
        Assert.assertTrue("OPENING HOURS bilgisi sayfada görünmüyor", page.openingHoursInfo.isDisplayed());
        logger.info("Opening Hours bilgisinin sayfada göründüğü doğrulandı.");

    }

    @Step("Our Specialist başlığının sayfada göründüğünü doğrulayın")
    @Then("Our Specialist başlığının sayfada göründüğünü doğrulayın")
    public void our_specialist_başlığının_sayfada_göründüğünü_doğrulayın() {
        Assert.assertTrue("Our Specialist başlığı sayfada görünmüyor", page.ourSpecialistHeading.isDisplayed());
        logger.info("Our Specialist başlığının sayfada göründüğü doğrulandı.");

    }

    @Step("Heidi Prather'in resmi, isim ve unvanının Our Specialist başlığı altında olduğunu doğrulayın")
    @Then("Heidi Prather'in resmi, İsim ve Unvan'ının Our Specialist başlığı altında olduğunu doğrulayın")
    public void heidi_prather_in_resmi_i̇sim_ve_unvan_ının_our_specialist_başlığı_altında_olduğunu_doğrulayın() {
        WebElement doctor = page.doctorsList.get(0);  // Heidi Prather ilk sırada
        Assert.assertTrue("Heidi Prather'in resmi görünmüyor", doctor.findElement(By.xpath(".//img")).isDisplayed());
        Assert.assertTrue("Heidi Prather'in ismi görünmüyor", doctor.findElement(By.xpath(".//h4[contains(text(), 'Heidi Prather')]")).isDisplayed());
        Assert.assertTrue("Heidi Prather'in unvanı görünmüyor", doctor.findElement(By.xpath(".//p[contains(text(), 'Professor')]")).isDisplayed());
        logger.info("Heidi Prather'in resmi, isim ve unvanının Our Specialist başlığı altında olduğu doğrulandı.");

    }

    @Step("Alexander M. Simotas'ın resmi, isim ve unvanının Our Specialist başlığı altında olduğunu doğrulayın")
    @Then("Alexander M. Simotas'ın resmi, İsim ve Unvan'ının Our Specialist başlığı altında olduğunu doğrulayın")
    public void alexander_m_simotas_ın_resmi_i̇sim_ve_unvan_ının_our_specialist_başlığı_altında_olduğunu_doğrulayın() {
        WebElement doctor = page.doctorsList.get(1);  // Alexander M. Simotas ikinci sırada
        Assert.assertTrue("Alexander M. Simotas'ın resmi görünmüyor", doctor.findElement(By.xpath(".//img")).isDisplayed());
        Assert.assertTrue("Alexander M. Simotas'ın ismi görünmüyor", doctor.findElement(By.xpath(".//h4[contains(text(), 'Alexander C. Simotas')]")).isDisplayed());
        Assert.assertTrue("Alexander M. Simotas'ın unvanı görünmüyor", doctor.findElement(By.xpath(".//p[contains(text(), 'Professor')]")).isDisplayed());
        logger.info("Alexander M. Simotas'ın resmi, isim ve unvanının Our Specialist başlığı altında olduğu doğrulandı.");

    }

    @Step("Jesse N. Charnoff'ın resmi, isim ve unvanının Our Specialist başlığı altında olduğunu doğrulayın")
    @Then("Jesse N. Charnoff'ın resmi, İsim ve Unvan'ının Our Specialist başlığı altında olduğunu doğrulayın")
    public void jesse_n_charnoff_ın_resmi_i̇sim_ve_unvan_ının_our_specialist_başlığı_altında_olduğunu_doğrulayın() {
        WebElement doctor = page.doctorsList.get(2);  // Jesse N. Charnoff üçüncü sırada
        Assert.assertTrue("Jesse N. Charnoff'ın resmi görünmüyor", doctor.findElement(By.xpath(".//img")).isDisplayed());
        Assert.assertTrue("Jesse N. Charnoff'ın ismi görünmüyor", doctor.findElement(By.xpath(".//h4[contains(text(), 'Jesse N. Charnoff')]")).isDisplayed());
        // Güncellenmiş unvan kontrolü
        Assert.assertTrue("Jesse N. Charnoff'ın unvanı görünmüyor", doctor.findElement(By.xpath(".//p[contains(text(), 'Professor')]")).isDisplayed());
        logger.info("Jesse N. Charnoff'ın resmi, isim ve unvanının Our Specialist başlığı altında olduğu doğrulandı.");

    }

    @Step("George Cyril'in resmi, isim ve unvanının Our Specialist başlığı altında olduğunu doğrulayın")
    @Then("George Cyril'in resmi, İsim ve Unvan'ının Our Specialist başlığı altında olduğunu doğrulayın")
    public void george_cyril_in_resmi_i̇sim_ve_unvan_ının_our_specialist_başlığı_altında_olduğunu_doğrulayın() {
        WebElement doctor = page.doctorsList.get(3);  // George Cyril dördüncü sırada
        Assert.assertTrue("George Cyril'in resmi görünmüyor", doctor.findElement(By.xpath(".//img")).isDisplayed());
        Assert.assertTrue("George Cyril'in ismi görünmüyor", doctor.findElement(By.xpath(".//h4[contains(text(), 'George Cyril')]")).isDisplayed());
        Assert.assertTrue("George Cyril'in unvanı görünmüyor", doctor.findElement(By.xpath(".//p[contains(text(), 'Professor')]")).isDisplayed());
        logger.info("George Cyril'in resmi, isim ve unvanının Our Specialist başlığı altında olduğu doğrulandı.");

    }


    @Step("Kullanıcı doktorların uzmanlık alanlarına göre gruplandığı menüyü görür")
    @When("Kullanıcı doktorların uzmanlık alanlarına göre gruplandığı menüyü görür")
    public void kullanıcı_doktorların_uzmanlık_alanlarına_göre_gruplandığı_menüyü_görür() {
        Assert.assertTrue(page.uzmanlikAlanlariMenu.isDisplayed());
        logger.info("Kullanıcı, doktorların uzmanlık alanlarına göre gruplandığı menüyü gördü.");

    }
    @Step("Menüde aşağıdaki uzmanlık alanları olmalıdır")
    @When("Menüde aşağıdaki uzmanlık alanları olmalıdır:")
    public void menüde_aşağıdaki_uzmanlık_alanları_olmalıdır(io.cucumber.datatable.DataTable dataTable) {
        // Menu'deki uzmanlık alanlarının doğruluğunu kontrol et
        List<String> expectedSpecializations = dataTable.asList(String.class);

        // Her bir uzmanlık alanının menüde olup olmadığını kontrol ediyoruz
        for (String specialization : expectedSpecializations) {
            WebElement specializationElement = driver.findElement(By.xpath("//a[text()='" + specialization + "']"));
            Assert.assertTrue("Menüde " + specialization + " bulunamadı", specializationElement.isDisplayed());
        }
        logger.info("Menüdeki uzmanlık alanları kontrol ediliyor.");

    }
    @Step("Kullanıcı General Practitioner uzmanlık alanına tıkladığında doktor isimlerini, unvanlarını ve resimlerini görür")
    @When("Kullanıcı General Practitioner uzmanlık alanına tıkladığında doktor isimlerini, unvanlarını ve resimlerini görür")
    public void kullanıcı_general_practitioner_uzmanlık_alanına_tıkladığında_doktor_isimlerini_unvanlarını_ve_resimlerini_görür() {
        page.generalPractitioner.click();
        for (int i = 0; i < 3; i++) {
            WebElement doctor = page.teamMembers.get(i);
            page.validateDoctorDetails(doctor);
            logger.info("Kullanıcı, General Practitioner uzmanlık alanındaki doktorların isimlerini, unvanlarını ve resimlerini gördü.");

        }
    }
    @Step("Kullanıcı Ophthalmologist uzmanlık alanına tıkladığında doktor isimlerini, unvanlarını ve resimlerini görür")
    @When("Kullanıcı Ophthalmologist uzmanlık alanına tıkladığında doktor isimlerini, unvanlarını ve resimlerini görür")
    public void kullanıcı_ophthalmologist_uzmanlık_alanına_tıkladığında_doktor_isimlerini_unvanlarını_ve_resimlerini_görür() {
        page.ophthalmologist.click(); // Ophthalmologist'e tıklıyoruz
        for (int i = 3; i < 9; i++) {
            WebElement doctor = page.teamMembers.get(i); // 4-9 arasındaki doktorları alıyoruz
            page.validateDoctorDetails(doctor);
            logger.info("Kullanıcı, Ophthalmologist uzmanlık alanındaki doktorların isimlerini, unvanlarını ve resimlerini gördü.");

        }
    }
    @Step("Kullanıcı Paediatrician uzmanlık alanına tıkladığında doktor isimlerini, unvanlarını ve resimlerini görür")
    @When("Kullanıcı Paediatrician uzmanlık alanına tıkladığında doktor isimlerini, unvanlarını ve resimlerini görür")
    public void kullanıcı_paediatrician_uzmanlık_alanına_tıkladığında_doktor_isimlerini_unvanlarını_ve_resimlerini_görür() {
        page.paediatrician.click(); // Paediatrician'a tıklıyoruz
        for (int i = 9; i < 12; i++) {
            WebElement doctor = page.teamMembers.get(i); // 10-12 arasındaki doktorları alıyoruz
            page.validateDoctorDetails(doctor);
            logger.info("Kullanıcı, Paediatrician uzmanlık alanındaki doktorların isimlerini, unvanlarını ve resimlerini gördü.");

        }
    }
    @Step("Kullanıcı Cardiologist uzmanlık alanına tıkladığında doktor isimlerini, unvanlarını ve resimlerini görür")
    @When("Kullanıcı Cardiologist uzmanlık alanına tıkladığında doktor isimlerini, unvanlarını ve resimlerini görür")
    public void kullanıcı_cardiologist_uzmanlık_alanına_tıkladığında_doktor_isimlerini_unvanlarını_ve_resimlerini_görür() {
        page.cardiologist.click(); // Cardiologist'e tıklıyoruz
        for (int i = 12; i < 18; i++) {
            WebElement doctor = page.teamMembers.get(i); // 13-18 arasındaki doktorları alıyoruz
            page.validateDoctorDetails(doctor);
            logger.info("Kullanıcı, Cardiologist uzmanlık alanındaki doktorların isimlerini, unvanlarını ve resimlerini gördü.");

        }
    }
    @Step("Kullanıcı Gynaecologist uzmanlık alanına tıkladığında doktor isimlerini, unvanlarını ve resimlerini görür")
    @When("Kullanıcı Gynaecologist uzmanlık alanına tıkladığında doktor isimlerini, unvanlarını ve resimlerini görür")
    public void kullanıcı_gynaecologist_uzmanlık_alanına_tıkladığında_doktor_isimlerini_unvanlarını_ve_resimlerini_görür() {
        page.gynaecologist.click();
        for (int i = 18; i < 22; i++) {
            WebElement doctor = page.teamMembers.get(i);
            page.validateDoctorDetails(doctor);
            logger.info("Kullanıcı, Gynaecologist uzmanlık alanındaki doktorların isimlerini, unvanlarını ve resimlerini gördü.");

        }
    }
    @Step("Kullanıcı Neurologist uzmanlık alanına tıkladığında doktor isimlerini, unvanlarını ve resimlerini görür")
    @When("Kullanıcı Neurologist uzmanlık alanına tıkladığında doktor isimlerini, unvanlarını ve resimlerini görür    And sayfayı kapatır")
    public void kullanıcı_neurologist_uzmanlık_alanına_tıkladığında_doktor_isimlerini_unvanlarını_ve_resimlerini_görür_and_sayfayı_kapatır() {
        page.neurologist.click(); // Neurologist'e tıklıyoruz
        for (int i = 22; i < 28; i++) {
            WebElement doctor = page.teamMembers.get(i); // 23-28 arasındaki doktorları alıyoruz
            page.validateDoctorDetails(doctor);
        }
        logger.info("Kullanıcı, Neurologist uzmanlık alanındaki doktorların isimlerini, unvanlarını ve resimlerini gördü.");


    }

    @Step("Sayfada What Our Clients Say başlığının göründüğünü doğrulayın")
    @When("Sayfada What Our Clients Say başlığının göründüğünü doğrulayın")
    public void sayfada_what_our_clients_say_başlığının_göründüğünü_doğrulayın() {
         Assert.assertTrue("What Our Clients Say başlığı görünür değil", page.whatOurClientsSay.isDisplayed());
    }

    @Step("Sayfada What Our Doctor Say başlığının göründüğünü doğrulayın")
    public void sayfada_what_our_doctor_say_başlığının_göründüğünü_doğrulayın() {
         Assert.assertTrue("What Our Doctor Say başlığı görünür değil", page.whatOurDoctorsSay.isDisplayed());
        logger.info("Sayfada 'What Our Doctor Say' başlığının göründüğü doğrulandı.");

    }
    @Step("FAQ's sayfasında {int} tane soru olduğunu doğrulayın")
    @When("FAQ's sayfasinda {int} tane soru olduğunu doğrulayın")
    public void what_our_clients_say_başlığı_altında_tane_soru_olduğunu_doğrulayın(Integer int1) {
        int actualCount = page.allQuestions.size();
        int expectedCount = 9;
        Assert.assertEquals("What Our Clients Say başlığı altında soru sayısı yanlış", expectedCount, actualCount);
        logger.info("FAQ's sayfasında verilen sayıda soru bulunduğu doğrulandı.");

    }
    @Step("Her bir soru üzerine tıklayın ve altlarında cevabın göründüğünü doğrulayın")
    @When("Her bir soru üzerine tıklayın ve altlarında cevabın göründüğünü doğrulayın")
    public void her_bir_soru_üzerine_tıklayın_ve_altlarında_cevabın_göründüğünü_doğrulayın() {
        ReusableMethods.wait(5);
        for (int i = 0; i < page.allQuestions.size(); i++) {
            WebElement question = page.allQuestions.get(i);
            question.click();


            WebElement answer = page.allAnswers.get(i);
            ReusableMethods.waitForVisibility(answer, 10);
            Assert.assertTrue("Cevap görünür değil: " + answer.getText(), answer.isDisplayed());
            System.out.println("Soru: " + question.getText());
            System.out.println("Cevap: " + answer.getText());
            logger.info("Her bir soru üzerine tıklanıp altlarında cevabın göründüğü doğrulandı.");

        }

    }


    @Step("Sayfada aşağıdaki departmanların başlık ve açıklama metinlerinin yer aldığını doğrulayın")
    @Then("Sayfada aşağıdaki departmanların başlık ve açıklama metinlerinin yer aldığını doğrulayın:")
    public void sayfada_aşağıdaki_departmanların_başlık_ve_açıklama_metinlerinin_yer_aldığını_doğrulayın(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedDepartments = dataTable.asList(String.class);

        for (int i = 0; i < expectedDepartments.size(); i++) {
            String expectedDepartment = expectedDepartments.get(i);

            WebElement titleElement = page.departmentTitles.get(i);
            WebElement descriptionElement = page.departmentDescriptions.get(i);
            JSUtilities.scrollToElement(driver, titleElement);
            String actualTitle = titleElement.getText();
            String actualDescription = descriptionElement.getText();
            Assert.assertTrue("Başlık eşleşmiyor: " + actualTitle, actualTitle.equalsIgnoreCase(expectedDepartment));
            Assert.assertFalse("Açıklama metni boş: " + actualTitle, actualDescription.isEmpty());
            System.out.println("Başlık: " + actualTitle);
            System.out.println("Açıklama: " + actualDescription);
            logger.info("Sayfada verilen departmanların başlık ve açıklama metinlerinin yer aldığı doğrulandı.");

        }
    }

    @Step("Sayfada aşağıdaki kişilerin yorumlarının, resimleri ile birlikte yer aldığını doğrulayın")
    @Then("Sayfada aşağıdaki kişilerin yorumlarının, resimleri ile birlikte yer aldığını doğrulayın:")
    public void sayfada_aşağıdaki_kişilerin_yorumlarının_resimleri_ile_birlikte_yer_aldığını_doğrulayın(io.cucumber.datatable.DataTable dataTable) {
         List<String> expectedNames = dataTable.asList(String.class);
         for (int i = 0; i < expectedNames.size(); i++) {
            String expectedName = expectedNames.get(i);
            WebElement testimonial = page.testimonialList.get(i);
            String testimonialName = page.testimonialNames.get(i).getText().trim();
            String testimonialComment = page.testimonialComments.get(i).getText().trim();
            WebElement testimonialImage = page.testimonialImages.get(i);
            Assert.assertEquals("İsim eşleşmiyor: " + testimonialName, expectedName, testimonialName);
            Assert.assertTrue("Yorum görünür değil: " + testimonialComment, testimonialComment.length() > 0);
            Assert.assertTrue("Resim görünür değil: " + testimonialImage.getAttribute("src"), testimonialImage.isDisplayed());
            System.out.println("Testimonial " + (i + 1) + ":");
            System.out.println("Adı: " + testimonialName);
            System.out.println("Yorum: " + testimonialComment);
            System.out.println("Resim: " + testimonialImage.getAttribute("src"));
            logger.info("Sayfada verilen kişilerin yorumlarının ve resimlerinin yer aldığı doğrulandı.");

         }
    }
}