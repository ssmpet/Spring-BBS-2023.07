package com.ys.sbbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ys.sbbs.dbo.AnniversaryDaoMySQL;
import com.ys.sbbs.entity.Anniversary;


@Service
public class AnniversaryServiceMySQLImpl implements AnniversaryService{

	@Autowired private AnniversaryDaoMySQL annivDao;
	
	@Override
	public List<Anniversary> getDayAnnivList(String sdate) {
		return annivDao.getAnnivList(sdate, sdate);
	}

	@Override
	public List<Anniversary> getAnnivDays(String start, String end) {
		return annivDao.getAnnivList(start, end);
	}

	@Override
	public void insert(Anniversary anniversary) {
		annivDao.insert(anniversary);		
	}

}
