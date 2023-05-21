package ua.ItHilell.homework14;

import java.util.*;

public class CoffeeOrderBoard {

    private Deque<Order> orderQueue = new ArrayDeque<>();

    public void add(Order order) {
        orderQueue.offer(order);
        recalculateOrderNumbers();
    }

    public Order deliver() {
        Order order = orderQueue.poll();
        recalculateOrderNumbers();
        return order;
    }

    public Order deliver(int orderNo) {
        List<Order> listOrder = new ArrayList<>(orderQueue);
        Order order = listOrder.get(orderNo);
        orderQueue.remove(order);
        recalculateOrderNumbers();
        return order;
    }

    public void draw() {
        recalculateOrderNumbers();
        for (Order order : orderQueue
        ) {
            System.out.println(order);
        }
    }

    private void recalculateOrderNumbers() {
        List<Order> listOrder = new ArrayList<>(orderQueue);
        for (Order order : listOrder
        ) {
            order.setOrderNumber(listOrder.indexOf(order));
        }
    }

}
