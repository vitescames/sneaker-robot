package br.com.robo.adapters.dataprovider.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SelecionaTamanhoEVaiCarrinhoService {

    private static final Logger logger = LogManager.getLogger(IdentificaBotaoCompraService.class);

    public List<WebElement> selecionaTamanhoEVaiCarrinho(WebDriver webDriver, List<WebElement> elementCompra){

        logger.warn("Selecionando tamanho...");

        List<WebElement> tamanho = webDriver.findElements(By.xpath("//button[contains(@title,'40')]"));

        Boolean botaoDefault = false;

        if(tamanho.isEmpty()){
            tamanho = webDriver.findElements(By.className("skuespec_Tamanho_opcao_40"));

            if(!tamanho.isEmpty()){
                elementCompra = webDriver.findElements(By.id("btn-seller-default"));
                botaoDefault = true;
            }
        }

        tamanho.get(0).click();

        elementCompra.get(0).click();

        logger.warn("Indo pro carrinho...");

        if(botaoDefault){
            WebDriverWait wait = new WebDriverWait(webDriver, 3000);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'/checkout#/cart')]")));
            List<WebElement> botaoCarrinho = webDriver.findElements(By.xpath("//a[contains(@href,'/checkout#/cart')]"));
            botaoCarrinho.get(0).click();
        }

        return elementCompra;

    }
}
