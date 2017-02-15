package Entity;

import Service.ProductStorage;
import Service.StorageBuilder;
import Store.JdbcStorage;

import java.util.HashMap;
import java.util.Map;

public class PartCache extends ProductStorage {

    private static ProductStorage partCache;
    private Map<SparePart, Integer> products = new HashMap<>();

    public static ProductStorage inctance() {
        if (partCache == null) {
            partCache = new PartCache();
            StorageBuilder.build(new JdbcStorage());
            return partCache;
        }
        return partCache;
    }
}
