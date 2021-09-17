package br.com.robo.adapters.dataprovider.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Service;

public class AbreSiteService {

    public WebDriver abreSite(WebDriver webDriver, String url){

        webDriver = new FirefoxDriver();

        webDriver.get(url);

        return webDriver;

    }

}
