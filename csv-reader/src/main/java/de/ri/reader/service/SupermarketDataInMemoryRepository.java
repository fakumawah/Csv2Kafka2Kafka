package de.ri.reader.service;

import de.ri.reader.model.SupermarketData;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class SupermarketDataInMemoryRepository implements InMemoryRepository{
    private Map<String, SupermarketData> internalStore = new HashMap<>();

    @Override
    public SupermarketData findById(String id) { return internalStore.get(id);}

    @Override
    public void save(SupermarketData supermarketData) {
        internalStore.put(supermarketData.getId(), supermarketData);
    }

    @Override
    public void delete(String id) {
        internalStore.remove(id);
    }
}
