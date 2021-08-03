package br.com.robo.usecases;

import br.com.robo.usecases.ports.AbreSiteCommand;
import br.com.robo.usecases.ports.WebPageGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class AbreSite implements AbreSiteCommand {

    @Autowired
    private WebPageGateway webPageGateway;

    @Override
    public void abreSite(Properties properties) {

        webPageGateway.abreSite(properties);

    }
}
