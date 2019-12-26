package com.itheima.core.service.impl;

import com.itheima.core.dao.ProductDao;
import com.itheima.core.po.Product;
import com.itheima.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 产品Service接口实现类
 */
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
	// 注入ProductDao
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getProducts() {
		return productDao.getProducts();
	}
}
