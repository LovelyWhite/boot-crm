package com.itheima.core.service;


import com.itheima.core.po.Reply;
import com.itheima.core.po.ReplyData;

import java.util.List;

/**
 * 回复Service层接口
 */
public interface ReplyService {

	public List<ReplyData> getReplies();
}
