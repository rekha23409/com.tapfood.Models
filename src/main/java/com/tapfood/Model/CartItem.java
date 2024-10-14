package com.tapfood.Model;

public class CartItem {
    private int itemid;
    private int restaurantid;
    private String name;
    private float price;
    private int quantity;
    private float totalprice;

    public CartItem() {
        super();
    }

    public CartItem(int itemid, int restaurantid, String name, float price, float totalprice) {
        this.itemid = itemid;
        this.restaurantid = restaurantid;
        this.name = name;
        this.price = price;
        this.totalprice= totalprice;
    }

    

	public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public int getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(int restaurantid) {
        this.restaurantid = restaurantid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.totalprice = this.price * quantity; // Update subtotal
    }

    public float getSubtotal() {
        return totalprice;
    }

    public void setSubtotal(float totalprice) {
        this.totalprice = totalprice;
    }

    @Override
    public String toString() {
        return "CartItem [itemid=" + itemid + ", restaurantid=" + restaurantid + ", name=" + name + ", price=" + price
                + ", quantity=" + quantity + ", subtotal=" + totalprice + "]";
    }
}
