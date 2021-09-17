package br.com.robo.usecases.ports;

import java.util.HashMap;

public interface ArtwalkWebPageGateway {

    public void realizaCompra(HashMap<String, String> params);

    void procuraBotaoComprar(String url);
}
