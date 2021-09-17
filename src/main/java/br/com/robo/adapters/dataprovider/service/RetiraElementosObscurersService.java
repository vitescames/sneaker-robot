package br.com.robo.adapters.dataprovider.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RetiraElementosObscurersService {

    public WebDriver retiraElementos(WebDriver webDriver){

        List<WebElement> elementObscure = webDriver.findElements(By.className("shoppush-prompt-close"));
        WebDriverWait wait = null;

        if(!elementObscure.isEmpty()) {

            wait = new WebDriverWait(webDriver, 20);
            wait.until(ExpectedConditions.visibilityOf(elementObscure.get(0)));
            elementObscure.get(0).click();
        }

        elementObscure = webDriver.findElements(By.className("acept-close"));

        if(!elementObscure.isEmpty()) {

            wait = new WebDriverWait(webDriver, 20);
            wait.until(ExpectedConditions.visibilityOf(elementObscure.get(0)));
            elementObscure.get(0).click();
        }

        elementObscure = webDriver.findElements(By.id("ModalAlterarLocalizacaoFechar"));

        if(!elementObscure.isEmpty()) {

            wait = new WebDriverWait(webDriver, 20);
            wait.until(ExpectedConditions.visibilityOf(elementObscure.get(0)));
            elementObscure.get(0).click();
        }

        elementObscure = webDriver.findElements(By.className("shoppush-prompt-btn"));

        if(!elementObscure.isEmpty()) {

            wait = new WebDriverWait(webDriver, 20);
            wait.until(ExpectedConditions.visibilityOf(elementObscure.get(0)));
            elementObscure.get(0).click();
        }

        return webDriver;

    }

}
