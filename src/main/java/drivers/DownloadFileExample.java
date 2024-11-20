package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class DownloadFileExample {
    public static void main(String[] args) {
        // Define the download path
        String downloadFilePath = System.getProperty("user.dir") + "\\downloads";

        // Set Chrome preferences
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadFilePath);

        // Configure ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--incognito"); // Optional argument, enable incognito mode

        // Setup WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup(); // Automatically handles driver versioning
        WebDriver driver = new ChromeDriver(options);

        // Now you can use the driver for your tests
        driver.get("https://example.com");

        // Cleanup after the test
        driver.quit();
    }
}
