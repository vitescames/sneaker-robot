package br.com.robo.adapters.dataprovider;

import br.com.robo.adapters.dataprovider.service.*;
import br.com.robo.domain.ports.ArtwalkWebPageGateway;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ArtwalkGatewayImpl implements ArtwalkWebPageGateway {

    @Autowired
    private AbreSiteService abreSiteService;

    @Autowired
    private IdentificaBotaoCompraService identificaBotaoCompraService;

    @Autowired
    private RetiraElementosObscurersService retiraElementosObscurersService;

    @Autowired
    private SelecionaTamanhoEVaiCarrinhoService selecionaTamanhoECompraService;

    @Autowired
    private ProcuraBotaoComprarService procuraBotaoComprarService;

    @Autowired
    private FechaPedidoESetaEmailService fechaPedidoESetaEmailService;

    @Autowired
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
