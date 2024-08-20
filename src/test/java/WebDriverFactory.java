import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class WebDriverFactory {
    private static WebDriver getWebDriver(String browserName) {
        switch (browserName) {
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                System.setProperty("webdriver.chrome.driver", "/bin/chromedriver");
                options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
                return new ChromeDriver(options);
            case YANDEX:
                System.setProperty("webdriver.chrome.driver", "/bin/yandexdriver");
                ChromeOptions yOptions = new ChromeOptions();
                yOptions.setBinary(new File("/bin/yandex-browser-stable"));
                yOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
                return new ChromeDriver(yOptions);
        }
        throw new RuntimeException("not supported " + browserName);
    }

    public static WebDriver getWebDriver() {
        String property = System.getProperty("RUN_TESTS_IN_YANDEX");
        if (property == null || property.equals("1")) {
            return getWebDriver(CHROME);
        }
        return getWebDriver(YANDEX);
    }

    public static final String CHROME = "chrome";
    public static final String YANDEX = "yandex";
}
