package br.com.robo.core.ports;

import java.util.HashMap;

public interface ArtwalkWebPageGateway {

    public void realizaCompra(HashMap<String, String> params);

    void procuraBotaoComprar(String url);
}
