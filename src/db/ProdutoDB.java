package db;

import models.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDB {

    private List<Produto> produtoList = new ArrayList<>();

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void addNovoProduto (Produto produto){
        produtoList.add(produto);

    }
}
