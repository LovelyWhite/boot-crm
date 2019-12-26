package com.itheima.core.web.controller;

import com.itheima.common.utils.ReturnValue;
import com.itheima.core.po.Reply;
import com.itheima.core.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ReplyController {
    @Autowired
    ReplyService replyService;

    @RequestMapping(value = "/getreplies.do", method = RequestMethod.POST)
    String getProducts(HttpServletResponse response) throws IOException {
        List<Reply> replies =  replyService.getReplies();
        if(replies.size()>0)
        {
            response.getWriter().write(new ReturnValue(1,"获取评论信息成功",replies).toString());
        }
        else {
            response.getWriter().write(new ReturnValue(0,"无评论信息",null).toString());
        }
        return null;
    }

}
