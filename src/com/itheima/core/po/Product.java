package com.itheima.core.po;


public class Product {

  private long product_id;
  private String product_name;
  private double product_price;
  private long product_num;
  private long product_sell_num;

  public long getProduct_id() {
    return product_id;
  }

  public void setProduct_id(long product_id) {
    this.product_id = product_id;
  }

  public String getProduct_name() {
    return product_name;
  }

  public void setProduct_name(String product_name) {
    this.product_name = product_name;
  }

  public double getProduct_price() {
    return product_price;
  }

  public void setProduct_price(double product_price) {
    this.product_price = product_price;
  }

  public long getProduct_num() {
    return product_num;
  }

  public void setProduct_num(long product_num) {
    this.product_num = product_num;
  }

  public long getProduct_sell_num() {
    return product_sell_num;
  }

  public void setProduct_sell_num(long product_sell_num) {
    this.product_sell_num = product_sell_num;
  }
}
