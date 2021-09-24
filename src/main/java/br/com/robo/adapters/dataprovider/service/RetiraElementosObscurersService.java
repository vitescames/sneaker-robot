package br.com.robo.adapters.dataprovider.service;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

public class RetiraElementosObscurersService {

    private static final Logger logger = LogManager.getLogger(IdentificaBotaoCompraService.class);

    public WebDriver retiraElementos(WebDriver webDriver){

        try {

            logger.warn("Retirando elementos da frente...");

            TakesScreenshot shot = (TakesScreenshot) webDriver;

            WebDriverWait wait = new WebDriverWait(webDriver, 3000);
            wait.until(ExpectedConditions.elementToBeClickable(By.className("shoppush-prompt-close")));

            File srcFile = shot.getScreenshotAs(OutputType.FILE);

            File destFile = new File("C:\\Users\\vitho\\Documents\\site_aberto.jpg");

            FileUtils.copyFile(srcFile, destFile);

            List<WebElement> elementObscure = webDriver.findElements(By.className("shoppush-prompt-close"));

            if (!elementObscure.isEmpty()) {
                elementObscure.get(0).click();
            }

            elementObscure = webDriver.findElements(By.className("acept-close"));

            if (!elementObscure.isEmpty()) {

                wait = new WebDriverWait(webDriver, 20);
                wait.until(ExpectedConditions.visibilityOf(elementObscure.get(0)));
                elementObscure.get(0).click();
            }

            elementObscure = webDriver.findElements(By.id("ModalAlterarLocalizacaoFechar"));

            if (!elementObscure.isEmpty()) {
                elementObscure.get(0).click();
            }

            elementObscure = webDriver.findElements(By.className("shoppush-prompt-btn"));

            if (!elementObscure.isEmpty()) {

                wait = new WebDriverWait(webDriver, 20);
                wait.until(ExpectedConditions.visibilityOf(elementObscure.get(0)));
                elementObscure.get(0).click();
            }

            srcFile = shot.getScreenshotAs(OutputType.FILE);

            destFile = new File("C:\\Users\\vitho\\Documents\\elementos_retirados.jpg");

            FileUtils.copyFile(srcFile, destFile);

        } catch (Exception e){
            e.printStackTrace();
        }

        return webDriver;

    }

}
