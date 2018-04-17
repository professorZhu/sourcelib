package com.jua.base.dao;


import com.jua.base.criteria.Criteria;
import com.jua.base.entity.BaseEntity;

import java.util.List;

public interface BaseDao {

	public <T extends BaseEntity> void add(T t);

	public <T extends BaseEntity> void update(T t);
	
	public <T extends BaseEntity> void updateBySelective(T t);
	
	public void delete(Object id);

	public int queryByCount(Criteria criteria);
	
	public <T extends BaseEntity> List<T> queryByList(Criteria criteria);
	
	public <T extends BaseEntity> T queryById(Object id);
}
