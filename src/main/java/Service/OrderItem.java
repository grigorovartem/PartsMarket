//package Service;
//
//import Entity.SparePart;
//import Store.Storage;
//
//import java.math.BigDecimal;
//
//public class OrderItem {
//    private Storage productStorage = ProductStorage.getInctance();
//    private int countOrder;
//    private SparePart sparePart;
//
//
//    public OrderItem(SparePart sparePart, int countOrder) {
//        chekSize(countOrder);
//        this.countOrder = countOrder;
//        this.sparePart = sparePart;
//    }
//
//    public int getCountOrder() {
//        return countOrder;
//    }
//
//    public SparePart getSparePart() {
//        return sparePart;
//    }
//
//    public void addCountOrder() {
//        countOrder += 1;
//    }
//
//    public void addCountOrder(int countOrder) {
//        chekSize(countOrder);
//        this.countOrder += countOrder;
//    }
//
//    public void deleteCountOrder(int countOrder) {
//        chekSize(countOrder);
//        if (this.countOrder > 0 && this.countOrder > countOrder) {
//            this.countOrder -= countOrder;
//        }
//    }
//
//    public void changeCountOrder(int i) {
//    }
//
//    public int deleteAllOrder() {
//        return countOrder = 0;
//    }
//
//    private void chekSize(int size) {
//        if (size <= 0) {
//            throw new IllegalArgumentException("not positive count of commodity: " + size);
//        }
//    }
//
//    public void checkCount(int countOrder) {
//        chekSize(this.countOrder);
//        if (this.countOrder > productStorage.getCountByID(sparePart.getId())) {
//            throw new IllegalArgumentException("not enough goods in stock ");
//        }
//    }
//
//    public BigDecimal getPrice() {
//
//        BigDecimal price = sparePart.getPrice();
//        return price.multiply(new BigDecimal(countOrder));
//    }
//}
