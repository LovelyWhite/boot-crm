package com.itheima.core.po;


import java.sql.Timestamp;

public class Reply {

  private long reply_id;
  private long cust_id;
  private long product_id;
  private String reply_comment;
  private java.sql.Timestamp reply_time;

  public long getReply_id() {
    return reply_id;
  }

  public void setReply_id(long reply_id) {
    this.reply_id = reply_id;
  }

  public long getCust_id() {
    return cust_id;
  }

  public void setCust_id(long cust_id) {
    this.cust_id = cust_id;
  }

  public long getProduct_id() {
    return product_id;
  }

  public void setProduct_id(long product_id) {
    this.product_id = product_id;
  }

  public String getReply_comment() {
    return reply_comment;
  }

  public void setReply_comment(String reply_comment) {
    this.reply_comment = reply_comment;
  }

  public Timestamp getReply_time() {
    return reply_time;
  }

  public void setReply_time(Timestamp reply_time) {
    this.reply_time = reply_time;
  }
}
