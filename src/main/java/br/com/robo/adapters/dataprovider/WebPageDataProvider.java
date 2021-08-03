package br.com.robo.adapters.dataprovider;

import br.com.robo.usecases.ports.WebPageGateway;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class WebPageDataProvider implements WebPageGateway {

    private WebDriver driver = new FirefoxDriver();

    @Override
    public void abreSite(Properties properties) {

        driver.get(properties.getProperty("url"));

        WebElement element = driver.findElement(By.className("name-produto"));

        System.out.println(element.getText());

    }
}
