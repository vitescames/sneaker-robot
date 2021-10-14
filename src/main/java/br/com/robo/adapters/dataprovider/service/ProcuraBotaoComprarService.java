package br.com.robo.adapters.dataprovider.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import javax.inject.Named;
import java.util.List;

@Named
public class ProcuraBotaoComprarService {

    private static final Logger logger = LogManager.getLogger(ProcuraBotaoComprarService.class);

    public void procura(String url) {

        try{

            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            options.addPreference("profile.default_content_setting_values.notifications", 2);

            WebDriver webDriver = new FirefoxDriver(options);
            webDriver.get(url);

            logger.info("Buscando o botão de comprar na URL definida...");
            List<WebElement> elementCompra = webDriver.findElements(By.className("buy-btn-calendar"));

            if(elementCompra.isEmpty()){
                elementCompra = webDriver.findElements(By.className("buy-in-page-button"));
            }

            while (elementCompra.isEmpty()){
                logger.info("Buscando o botão de comprar na URL definida...");
                webDriver.navigate().refresh();
                elementCompra = webDriver.findElements(By.className("buy-btn-calendar"));
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
