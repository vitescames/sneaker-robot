package br.com.robo.adapters.dataprovider.gateway.artwalkintegration;

import br.com.robo.adapters.dataprovider.gateway.artwalkintegration.service.*;
import br.com.robo.core.ports.ArtwalkWebPageGateway;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.List;

@Named
public class ArtwalkGatewayImpl implements ArtwalkWebPageGateway {

    @Inject
    private AbreSiteService abreSiteService;

    @Inject
    private IdentificaBotaoCompraService identificaBotaoCompraService;

    @Inject
    private RetiraElementosObscurersService retiraElementosObscurersService;

    @Inject
    private SelecionaTamanhoEVaiCarrinhoService selecionaTamanhoECompraService;

    @Inject
    private ProcuraBotaoComprarService procuraBotaoComprarService;

    @Inject
    private FechaPedidoESetaEmailService fechaPedidoESetaEmailService;

    @Inject
    private SetaInformacoesService setaInformacoesService;

    private WebDriver webDriver;

    @Override
    public void realizaCompra(HashMap<String, String> params) {

        webDriver = abreSiteService.abreSite(webDriver, params.get("url"));

        List<Object> retorno = identificaBotaoCompraService.identificaBotao(webDriver);

        List<WebElement> botaoCompra = (List<WebElement>) retorno.get(1);

        retiraElementosObscurersService.retiraElementos(webDriver);

        selecionaTamanhoECompraService.selecionaTamanhoEVaiCarrinho(webDriver, botaoCompra);

        fechaPedidoESetaEmailService.fechaPedidoESetaEmail(webDriver, params.get("email"));

        setaInformacoesService.setaInformacoes(webDriver, params);

    }

    @Override
    public void procuraBotaoComprar(String url) {

        procuraBotaoComprarService.procura(url);

    }
}
