package Store;

import Entity.PartCache;
import Entity.SparePart;
import Filtration.Filterable;
import Filtration.PartVerificator;

public interface Storage {

    Storage add(SparePart sparePart, int count);

    Storage filter(Filterable<SparePart> condition);
}
