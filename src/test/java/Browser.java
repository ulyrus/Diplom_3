import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
    public static WebDriver getWebBrowser(String browserName) {
        switch (browserName) {
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
                return new ChromeDriver();
            case YANDEX:
                throw new RuntimeException("");
        }
        throw new RuntimeException("not supported " + browserName);
    }

    public static final String CHROME = "chrome";
    public static final String YANDEX = "yandex";
}
