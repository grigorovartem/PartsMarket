//package Service;
//
//import Entity.SparePart;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Basket {
//
//    private List<OrderItem> orderItems = new ArrayList<>();
//
//    public Basket addOrder(OrderItem orderItem) {
//        orderItems.add(orderItem);
//        return this;
//    }
//
//    public BigDecimal getPrice() {
//        BigDecimal sumBasket = new BigDecimal(0);
//        for (OrderItem orderItem : orderItems) {
//            sumBasket = sumBasket.add(orderItem.getPrice());
//        }
//        return sumBasket;
//    }
//
//    public void deleteOrder(SparePart product) {
//        for (int i = 0; i < orderItems.size(); i++) {
//            if (orderItems.get(i).getSparePart().equals(product)) {
//                orderItems.remove(i);
//            }
//        }
//    }
//}
