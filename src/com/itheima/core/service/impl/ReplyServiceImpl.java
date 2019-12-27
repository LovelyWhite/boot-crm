package com.itheima.core.service.impl;

import com.itheima.core.dao.ReplyDao;
import com.itheima.core.po.Reply;
import com.itheima.core.po.ReplyData;
import com.itheima.core.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("replyService")
@Transactional
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyDao replyDao;
	@Override
	public List<ReplyData> getReplies() {
		return replyDao.getReplies();
	}
}
