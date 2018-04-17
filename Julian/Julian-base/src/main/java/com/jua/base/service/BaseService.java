package com.jua.base.service;


import com.jua.base.criteria.Criteria;
import com.jua.base.dao.BaseDao;
import com.jua.base.entity.BaseEntity;

import java.util.List;

public interface  BaseService{
	
	public abstract BaseDao getDao();

	
	public <T extends BaseEntity> void add(T t)  throws Exception;
	
	public <T extends BaseEntity> void update(T t)  throws Exception;

	public <T extends BaseEntity> void updateBySelective(T t);
	
	public void delete(Object... ids) throws Exception;
	
	public int queryByCount(Criteria criteria)throws Exception;
	
	public <T extends BaseEntity> List<T> queryByList(Criteria criteria) throws Exception;

	public <T extends BaseEntity> T queryBySingle(Criteria criteria) throws Exception;

	public <T extends BaseEntity> T queryById(Object id) throws Exception;



}
