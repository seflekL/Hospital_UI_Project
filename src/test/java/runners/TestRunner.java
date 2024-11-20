package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features", // Feature dosyalarının yolu
		glue = "stepdefinitions",                // Step Definitions'ın yolu
		plugin = {
				"pretty",                         // Konsolda okunabilir loglar
				"html:target/cucumber-reports/cucumber.html", // Cucumber HTML raporu
				"json:target/cucumber-reports/cucumber.json", // JSON raporu (Cucumber HTML için gerekli)
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" // Allure raporları için plugin
		},
		monochrome = true,                         // Konsol çıktısını daha okunabilir hale getirir
		tags = "@google"                           // Yalnızca belirtilen etiketli senaryolar çalıştırılır
)
public class TestRunner {
	private static final Logger logger = LogManager.getLogger(TestRunner.class);

	@BeforeClass
	public static void setup() {
		// Test çalışmaya başlamadan önce loglama yapılır
		logger.info("Cucumber Test Runner başlatılıyor...");
	}
}
