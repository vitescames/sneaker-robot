package br.com.robo.adapters.dataprovider.config;


import br.com.robo.adapters.dataprovider.ArtwalkGatewayImpl;
import br.com.robo.adapters.dataprovider.service.*;
import br.com.robo.domain.usecases.ProcuraBotaoComprar;
import br.com.robo.domain.ports.ArtwalkWebPageGateway;
import br.com.robo.domain.ports.ProcuraBotaoComprarCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class BeanConfig {

    @Value("${driver.location}")
    private String driverLocation;

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
    public ProcuraBotaoComprarCommand procuraBotaoComprarCommand(){
        return new ProcuraBotaoComprar();
    }

    @PostConstruct
    public void setDriverLocation(){
        System.setProperty("webdriver.gecko.driver", driverLocation);
    }

}
