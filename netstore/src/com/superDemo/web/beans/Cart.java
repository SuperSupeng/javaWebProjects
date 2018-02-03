package com.superDemo.web.beans;

import com.superDemo.domain.Book;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Cart implements Serializable{
    //key:购物项对应的书籍的id，value：购物项
    private Map<String, CartItem> items = new HashMap<String, CartItem>();
    private int totalQuantity;
    private float amount;//总金额，付款额
    public Map<String, CartItem> getItems() {
        return items;
    }
    public void setItems(Map<String, CartItem> items) {
        this.items = items;
    }
    public int getTotalQuantity() {
        totalQuantity = 0;
        for(Map.Entry<String, CartItem> item:items.entrySet()){
            totalQuantity+=item.getValue().getQuantity();
        }
        return totalQuantity;
    }
    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
    public float getAmount() {
        amount=0;
        for(Map.Entry<String, CartItem> item:items.entrySet()){
            amount+=item.getValue().getTotalPrice();
        }
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
    //向购物车中添加一本书（添加一个购物项）
    public void addBook(Book book){
        if(items.containsKey(book.getId())){
            //书籍已经存在
            CartItem item = items.get(book.getId());
            item.setQuantity(item.getQuantity()+1);
        }else{
            CartItem item = new CartItem(book);
            item.setQuantity(1);
            items.put(book.getId(), item);
        }
    }
}
