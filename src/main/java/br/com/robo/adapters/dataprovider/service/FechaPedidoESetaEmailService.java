package br.com.robo.adapters.dataprovider.service;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.inject.Named;
import java.io.File;
import java.util.List;

@Named
public class FechaPedidoESetaEmailService {

    private static final Logger logger = LogManager.getLogger(IdentificaBotaoCompraService.class);

    public WebDriver fechaPedidoESetaEmail(WebDriver webDriver, String email){

        try {

            logger.warn("Fechando pedido...");

            WebDriverWait wait = new WebDriverWait(webDriver, 5000);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("form[class*='form-page client-pre-email anim-death anim-current']")));

            JavascriptExecutor js = (JavascriptExecutor) webDriver;

            wait.until(ExpectedConditions.elementToBeClickable(By.id("cart-to-orderform")));

            js.executeScript("document.getElementsByClassName('form-page client-pre-email anim-death anim-current')[0].style.display='none';");

            List<WebElement> botaoFecharPedido = webDriver.findElements(By.id("cart-to-orderform"));

            botaoFecharPedido.get(0).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("client-email")));

            webDriver.findElement(By.id("client-email")).sendKeys(email);

            TakesScreenshot shot = (TakesScreenshot) webDriver;

            File srcFile = shot.getScreenshotAs(OutputType.FILE);

            File destFile = new File("C:\\Users\\vitho\\Documents\\fechando_pedido.jpg");

            FileUtils.copyFile(srcFile, destFile);

            return webDriver;

        } catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }

}
