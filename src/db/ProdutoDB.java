package db;

import models.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProdutoDB {

    private Map<Integer> produtoMap = new HashMap();

    public List<Produto> getProdutoList() {
        List <Produto> produtos = new ArrayList<>();
        for(Map.entry<Integer,Produto> produto : produtoMap.entrySet()){
            produtos.add(produto.getValue());
        }
        return produtos;
    }

    public void addNovoProduto (Produto produto){
        produtoList.add(produto);
    public Produto getProdutoPorId(int id);{

        }
    }
}
