package dataFactory;

import pojo.ComponentePojo;
import pojo.ProdutoPojo;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDataFactory {
    public static ProdutoPojo criarProdComumValorIgualA(double valor){
        ProdutoPojo produto = new ProdutoPojo();
        produto.setProdutoNome("Play Station Automacao 5 ");
        produto.setProdutoValor(valor); //nao passo mais o 0.0

        List<String> cores = new ArrayList<>();
        cores.add("preto");
        cores.add("branco");

        produto.setProdutosCores(cores);
        produto.setProdutoUrlMock("");

        List<ComponentePojo> componentes = new ArrayList<>();

        ComponentePojo componente = new ComponentePojo();
        componente.setComponenteNome("Controle Automacao");
        componente.setComponenteQuantidade(1);
        componentes.add(componente);

        ComponentePojo segundoComponente = new ComponentePojo();
        segundoComponente.setComponenteNome("Memory card automacao");
        segundoComponente.setComponenteQuantidade(2);
        componentes.add(segundoComponente);

        produto.setComponentes(componentes);

        return produto;
    }
}
