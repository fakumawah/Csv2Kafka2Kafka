package de.ri.reader.service;

import de.ri.reader.model.SupermarketData;

public interface InMemoryRepository {
    public SupermarketData findById(String id);

    public void save(SupermarketData supermarketData);

    public void delete(String id);
}
