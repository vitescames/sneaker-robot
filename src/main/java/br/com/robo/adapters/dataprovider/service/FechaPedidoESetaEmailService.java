package br.com.robo.adapters.dataprovider.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FechaPedidoESetaEmailService {

    public WebDriver fechaPedidoESetaEmail(WebDriver webDriver, String email){

        List<WebElement> botaoFecharPedido = webDriver.findElements(By.id("cart-to-orderform"));

        botaoFecharPedido.get(0).click();

        WebDriverWait wait = new WebDriverWait(webDriver, 3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("client-pre-email")));

        webDriver.findElement(By.id("client-pre-email")).sendKeys(email);

        webDriver.findElement(By.id("btn-client-pre-email")).click();

        return webDriver;

    }

}
