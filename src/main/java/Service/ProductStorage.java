package Service;

import Entity.PartCache;
import Entity.SparePart;
import Filtration.Filterable;
import Store.Storage;

import java.util.*;

public class ProductStorage implements Storage{

    private static ProductStorage productStorage;
    private Map<SparePart, Integer> products = new HashMap<>();

    public static Storage getInctance() {
        if (productStorage == null) {
            productStorage = new ProductStorage();
        }
        StorageBuilder.build(productStorage);
        return productStorage;
    }

    public Set<Map.Entry<SparePart, Integer>> getProducts() {
        return products.entrySet();
    }

    @Override
    public Storage add(SparePart part, int count) {
        products.put(part, products.get(part) == null ? count : products.get(part) + count);
        return this;
    }

    public int getCountByID(long id) {
        int productQuantity = 0;
        for (Map.Entry<SparePart, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId() == id) {
                productQuantity = entry.getValue();
            }
        }
        return productQuantity;
    }

    public void clear() {
        this.products.clear();
    }

    public ProductStorage sort(Comparator comparator) {
        Map<SparePart, Integer> sorted = new TreeMap<>(comparator);
        sorted.putAll(products);
        products = sorted;
        return this;
    }

    @Override
    public Storage filter(Filterable<SparePart> condition) {
        ProductStorage filteredStorage = PartCache.inctance();
        filteredStorage.clear();
        for (Map.Entry<SparePart, Integer> entry : products.entrySet()) {
            if (condition.verify(entry.getKey())) {
                filteredStorage.add(entry.getKey(), entry.getValue());
            }
        }
        return filteredStorage;
    }

    @Override
    public String toString() {
        String description = "";
        for (Map.Entry<SparePart, Integer> entry : products.entrySet()) {
            SparePart part = entry.getKey();
            int count = entry.getValue();
            description += part.getName() + ", " + part.getPrice() + ", " + part.getBrand() + ", " + count + "\n";
        }
        return description;
    }

}
