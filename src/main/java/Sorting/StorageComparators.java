package Sorting;

import Entity.SparePart;

import java.util.Comparator;

public class StorageComparators {

    public static Comparator<SparePart> byPrice(){
        return new Comparator<SparePart>() {
            @Override
            public int compare(SparePart part1, SparePart part2) {
                if (part1.getPrice().compareTo(part2.getPrice()) == 0) {
                    return 1;
                }
                return part1.getPrice().compareTo(part2.getPrice());
            }
        };
    }

    public static Comparator<SparePart> byName(){
        return new Comparator<SparePart>() {
            @Override
            public int compare(SparePart part1, SparePart part2) {
                return part1.getName().compareTo(part2.getName());
            }
        };
    }
}
