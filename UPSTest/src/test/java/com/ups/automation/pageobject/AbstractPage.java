package com.ups.automation.pageobject;
import java.util.List;

import java.util.concurrent.TimeUnit;

import com.ups.automation.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class AbstractPage {

    @Autowired
    DriverFactory driverFactory;

    public void fullScreen() {
        getDriver().manage().window().maximize();//setSize(new Dimension(1600, 900));
    }

    public void navigate(final String value) {
        getDriver().navigate().to(value);
    }

    protected String getCurrentPageUrl(){ return getDriver().getCurrentUrl();}

    protected boolean isThere(final String name) {
        final List<WebElement> listTitles = getDriver()
                .findElements(By.xpath("//*[contains(text(),  \" " + name + "\" )]"));
        return listTitles.size() == 1 && listTitles.get(0).isDisplayed();
    }

    public boolean isElementDisplayed(String xpath) {
        return getDriver().findElement(By.xpath(xpath)).isDisplayed();
    }

    protected void editText(final String id, final String value) {
        final WebElement element = (new FluentWait<>(getDriver())).withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(10, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        element.clear();
        element.sendKeys(value);
    }

    protected void clickId(final String id) {
        waitUntilElementWithIdPresent(id);
        getDriver().findElement(By.id(id)).click();
    }

    protected void clickElementWithText(final String value, String element) {
        getDriver().findElement(By.xpath("//" + element + "[text()='" + value + "']")).click();
    }


    public boolean isElementByXPathDisabled(String xpath) {
        WebElement ele = getDriver().findElement(By.xpath(xpath));
        return ele.getAttribute("disabled") != null;
    }


    protected WebDriver getDriver() {
        return driverFactory.getDriver();
    }

    protected boolean isElementPresentWithXPATH(String xpath) {
        final WebElement ele = getDriver().findElement(By.xpath(xpath));
        return ele != null;
    }

    protected void waitUntilElementWithXPathVisibleAndClick(String xpath) {

        List<WebElement> elementList = getDriver().findElements(By.xpath(xpath));
        boolean flag = false;
        for (WebElement element : elementList) {
            try {
                (new FluentWait<>(getDriver())).withTimeout(40, TimeUnit.SECONDS)
                        .pollingEvery(10, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
                        .until(ExpectedConditions.visibilityOf(element));
                flag = true;
                element.click();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                flag = false;
            }
        }
        if (!flag)
            Assert.fail("Element Not Visible" + xpath);
    }

    protected void waitUntilElementWithXPathPresent(String xpath, int sec) {
        (new WebDriverWait(getDriver(), sec)).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    protected void waitUntilElementWithIdPresent(String id) {
        waitUntilElementWithIdPresent(id, 30);
    }

    protected void waitUntilElementWithIdPresent(String id, int sec) {
        (new WebDriverWait(getDriver(), sec)).until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }

    public void clickElementWithXPath(String xpath) {
        isElementPresentWithXPATH(xpath);
        waitUntilElementWithXPathVisibleAndClick(xpath);
    }

    protected void editTextWithXPath(final String xpath, final String value) {
        final WebElement element = (new FluentWait<>(getDriver())).withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(10, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        element.clear();
        element.sendKeys(value);
    }

    protected String getElementTextWithXPath(String xpath, int sec) {
        WebElement element = (new WebDriverWait(getDriver(), sec))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        return element.getText();
    }
    protected void clickElementWithJs(final String xpath) {
        final WebElement element = getDriver().findElement(By.xpath(xpath));
        final JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public boolean isElementPresent(String xpath) {
        try {
            getDriver().findElement(By.xpath(xpath));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    protected void waitUntilTextPresent(String text, int sec) {
        (new WebDriverWait(getDriver(), 20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), '" + text + "')]")));
    }


}
