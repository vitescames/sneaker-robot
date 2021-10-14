package br.com.robo.adapters.dataprovider.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import javax.inject.Named;

@Named
public class AbreSiteService {

    public WebDriver abreSite(WebDriver webDriver, String url){

        FirefoxOptions options = new FirefoxOptions();
        //options.setHeadless(true);
        options.addPreference("profile.default_content_setting_values.notifications", 2);

        webDriver = new FirefoxDriver(options);

        webDriver.get(url);

        return webDriver;

    }

}
