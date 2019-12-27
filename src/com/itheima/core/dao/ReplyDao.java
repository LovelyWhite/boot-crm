package com.itheima.core.dao;

import com.itheima.core.po.ReplyData;

import java.util.List;

/**
 * 回复DAO层接口
 */
public interface ReplyDao {

	public List<ReplyData> getReplies();
}
