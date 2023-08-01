package com.ys.sbbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ys.sbbs.db.ReplyDaoOracle;
import com.ys.sbbs.entity.Reply;

@Primary
@Service
public class ReplyServiceOracleImpl implements ReplyService{

	@Autowired ReplyDaoOracle replyDao;
	
	@Override
	public List<Reply> getReplyList(int bid) {

		return replyDao.getReplyList(bid);
	}

	@Override
	public void insertReply(Reply reply) {
		replyDao.insertReply(reply);		
	}

}
