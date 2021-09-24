package br.com.robo.config;

import br.com.robo.adapters.dataprovider.*;
import br.com.robo.adapters.dataprovider.service.*;
import br.com.robo.adapters.entrypoint.config.ControllerConfig;
import br.com.robo.adapters.entrypoint.controllers.ControllerInterface;
import br.com.robo.adapters.entrypoint.controllers.RoboArtwalkController;
import br.com.robo.usecases.ExecutaRoboArtwalk;
import br.com.robo.usecases.ProcuraBotaoComprar;
import br.com.robo.usecases.ports.ExecutaRoboArtwalkCommand;
import br.com.robo.usecases.ports.ArtwalkWebPageGateway;
import br.com.robo.usecases.ports.ProcuraBotaoComprarCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class SpringConfig {

    @Value("${driver.location}")
    private String driverLocation;

    @Bean
    public ControllerConfig controllerConfig(){
        return new ControllerConfig();
    }

    @Bean
    public ExecutaRoboArtwalkCommand abreSiteCommand() {
        return new ExecutaRoboArtwalk();
    }

    @Bean
    public ArtwalkWebPageGateway webPageGateway() {
        return new ArtwalkGatewayImpl();
    }

    @Bean("artwalk")
    public ControllerInterface artwalkController() {
        return new RoboArtwalkController();
    }

    @Bean
    public AbreSiteService abreSiteService(){
        return new AbreSiteService();
    }

    @Bean
    public IdentificaBotaoCompraService identificaBotaoCompraService(){
        return new IdentificaBotaoCompraService();
    }

    @Bean
    public SelecionaTamanhoEVaiCarrinhoService selecionaTamanhoECompraService(){
        return new SelecionaTamanhoEVaiCarrinhoService();
    }

    @Bean
    public FechaPedidoESetaEmailService fechaPedidoESetaEmailService(){
        return new FechaPedidoESetaEmailService();
    }

    @Bean
    public RetiraElementosObscurersService retiraElementosObscurersService(){
        return new RetiraElementosObscurersService();
    }

    @Bean
    public SetaInformacoesService setaInformacoesService(){
        return new SetaInformacoesService();
    }

    @Bean
    public ProcuraBotaoComprarService procuraBotaoComprarService(){
        return new ProcuraBotaoComprarService();
    }

    @Bean
    public ProcuraBotaoComprarCommand procuraBotaoComprarCommand(){
        return new ProcuraBotaoComprar();
    }

    @PostConstruct
    public void setDriverLocation(){
        System.setProperty("webdriver.gecko.driver", driverLocation);
    }

}
