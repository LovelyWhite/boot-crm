package com.itheima.core.web.controller;

import com.itheima.common.utils.ReturnValue;
import com.itheima.core.po.Product;
import com.itheima.core.po.Reply;
import com.itheima.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/getproducts.do", method = RequestMethod.POST)
    String getProducts(HttpServletResponse response) throws IOException {
        List<Product> products =  productService.getProducts();
        if(products.size()>0)
        {
            response.getWriter().write(new ReturnValue(1,"获取产品信息成功",products).toString());
        }
        else {
            response.getWriter().write(new ReturnValue(0,"无产品信息",null).toString());
        }
        return null;
    }

}
