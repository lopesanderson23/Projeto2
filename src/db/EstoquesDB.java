package db;

import models.Estoque;

import java.util.HashMap;
import java.util.Map;

public class EstoquesDB {

    private Map <String, Estoque> estoquesDBMap = new HashMap<>();

    public Map<String, Estoque> getEstoquesDBMap() {
        return estoquesDBMap;
    }

    public void addNovoEstoque (Estoque estoque){

        estoquesDBMap.put(estoque.getId(), estoque);

    }
}

