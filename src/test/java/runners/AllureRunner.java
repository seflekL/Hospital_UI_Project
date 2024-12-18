package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Feature dosyalarının yolu
        glue = "StepDefinitions",                 // Step Definitions'ın yolu
        plugin = {
                "pretty",                                    // Konsolda daha okunabilir loglar
                "html:target/cucumber-reports.html",         // HTML raporu oluşturur
                "json:target/cucumber-reports/cucumber.json", // JSON raporu oluşturur
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" // Allure raporları için plugin
        },
        monochrome = true,                       // Konsol çıktısını okunabilir hale getirir
        tags = "@Allure",                        // Sadece belirtilen etiketle çalışır
        dryRun = false                           // Adım tanımlamalarının eksik olup olmadığını kontrol eder
)
public class AllureRunner {
 }