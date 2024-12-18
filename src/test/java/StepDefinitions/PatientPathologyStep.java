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
import pages.PatientDashboardPage;
import pages.PatientPharmacyPage;

import java.util.List;

public class PatientPathologyStep {

    WebDriver driver = StepDefinitions.Hooks.getDriver();
    private List<WebElement> tableHeaders;
    private List<WebElement> tableItems;
    PatientPharmacyPage patientPharmacyPage = new PatientPharmacyPage(tableHeaders,tableItems);
    PatientDashboardPage patientDashboardPage = new PatientDashboardPage();
    private static final Logger logger = LogManager.getLogger(StepDefinitions.PatientStep.class);

    @Step("Kullanıcı sol menüden Pathology seçeneğine tıklar")
    @When("kullanici sol menuden Pathology secenegine tiklar")
    public void kullanici_sol_menuden_secenegine_tiklar() {
        patientDashboardPage.pathologyBoard.click();
        logger.info("Kullanıcı sol menüden Pathology seçeneğine tıkladı.");


    }
    @Step("Kullanıcı listeden bir öğenin Pay düğmesine tıklar")
    @When("kullanici listeden bir ogenin Pay dugmesine tiklar")
    public void kullanici_bir_ogenin_dugmesine_tiklar() {

        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-xs']")).click();
        logger.info("Kullanıcı listeden bir öğenin Pay düğmesine tıkladı.");

    }
    @Step("Pathology sayfasının düzgün bir şekilde görüntülendiğini doğrular")
    @Then("Pathology sayfasinin duzgun bir sekilde goruntulendigini dogrular")
    public void pharmacy_sayfasinin_duzgun_bir_sekilde_goruntulendigini_dogrular() {
        Assert.assertTrue(driver.getCurrentUrl().contains("pathology"));
        logger.info("Pathology sayfasının düzgün bir şekilde görüntülendiği doğrulandı.");

    }


}
