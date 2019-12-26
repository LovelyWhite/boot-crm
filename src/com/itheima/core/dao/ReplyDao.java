package com.itheima.core.dao;

import com.itheima.core.po.Reply;
import com.itheima.core.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 回复DAO层接口
 */
public interface ReplyDao {

	public List<Reply> getReplies();
}
