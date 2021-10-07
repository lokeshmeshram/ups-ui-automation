	package com.ups.automation;

    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.apache.commons.lang3.StringUtils;
    import org.openqa.selenium.Dimension;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.chrome.ChromeOptions;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.openqa.selenium.ie.InternetExplorerDriver;
    import org.openqa.selenium.remote.DesiredCapabilities;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.stereotype.Component;

    import java.util.concurrent.TimeUnit;

    @Component
    public class DriverFactory {

        Logger logger = LoggerFactory.getLogger(DriverFactory.class);

        @Value("${com.ups.common.browser}")
        String browser;


        public enum Browsers {
            Chrome, Firefox, IE
        }


        // thread local driver object for webdriver
        ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() {
            @Override
            protected WebDriver initialValue() {
                return initiateDriver();
            }
        };

        public WebDriver initiateDriver() {
            String browserEnv = System.getenv("BROWSER");
            if (StringUtils.isEmpty(browserEnv)) {
                browserEnv = browser;
            }
            logger.info("Loading driver for browser: " + browserEnv + " " + this.browser);
            Browsers browser = Browsers.valueOf(browserEnv);


            WebDriver webDriver = null;
            switch (browser) {
            case Chrome:
                WebDriverManager.chromedriver().setup();
                // Create object of DesiredCapabilities class
                DesiredCapabilities cap=DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("ignore-certificate-errors","ignore-urlfetcher-cert-requests","--no-sandbox","--disable-dev-shm-usage");
                cap.setCapability(ChromeOptions.CAPABILITY, options);
                webDriver  = new ChromeDriver(cap);
                webDriver.manage().window().setSize(new Dimension(1600,900));
                break;

            case IE:
                WebDriverManager.iedriver().setup();
                webDriver = new InternetExplorerDriver();
                webDriver.manage().window().maximize();
                break;
            case Firefox:
                webDriver  = new FirefoxDriver();
                webDriver.manage().window().maximize();
                break;

            default:
                break;
            }
            webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            return webDriver; // or other browser drivers
        }

        public WebDriver getDriver() {
            return driver.get();
        }

        public void removeDriver() {
            driver.get().quit();
            driver.remove();
        }
    }
