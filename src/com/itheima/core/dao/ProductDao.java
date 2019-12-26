package com.itheima.core.dao;

import com.itheima.core.po.Product;

import java.util.List;

/**
 * 产品DAO层接口
 */
public interface ProductDao {

	public List<Product> getProducts();
}
