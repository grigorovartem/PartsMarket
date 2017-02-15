package Service;

import Entity.Brand;
import Entity.PartCache;
import Entity.SparePart;
import Store.Storage;

public class StorageBuilder {

    public static Storage build(Storage productStorage){

        productStorage.add(new SparePart("filter", Brand.VOLVO, 906.), 6)
                .add(new SparePart("fan belt", Brand.VOLVO, 906.), 6)
                .add(new SparePart("lamp", Brand.DAF, 86.), 90)
                .add(new SparePart("alternator", Brand.MERSEDES, 86.), 10)
                .add(new SparePart("molding", Brand.IVECO, 45.), 40)
                .add(new SparePart("bearing", Brand.IVECO, 86.), 40)
                .add(new SparePart("carburetor", Brand.IVECO, 86.), 40)
                .add(new SparePart("accelerator", Brand.MERSEDES, 78.), 12)
                .add(new SparePart("axle", Brand.MERSEDES, 10.), 11);
        return productStorage;
    }
}
