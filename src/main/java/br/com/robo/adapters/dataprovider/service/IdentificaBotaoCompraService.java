package br.com.robo.adapters.dataprovider.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class IdentificaBotaoCompraService {

    private static final Logger logger = LogManager.getLogger(IdentificaBotaoCompraService.class);

    public List<Object> identificaBotao(WebDriver webDriver){

        logger.info("Botão de comprar detectado!!");

        List<WebElement> elementCompra = webDriver.findElements(By.className("buy-btn-calendar"));

        if(elementCompra.isEmpty()){
            elementCompra = webDriver.findElements(By.className("buy-in-page-button"));
        }

        List<Object> retorno = new ArrayList<>();
        retorno.add(webDriver);
        retorno.add(elementCompra);

        return retorno;

    }

}
