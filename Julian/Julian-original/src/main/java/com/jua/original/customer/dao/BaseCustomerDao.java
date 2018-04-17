package com.jua.original.customer.dao;


import com.jua.base.criteria.Criteria;
import com.jua.base.dao.BaseDao;
import com.jua.base.entity.BaseEntity;

import java.util.List;

/**
 * 
 * <br>
 * <b>功能：</b>CustomerDao<br>
 */
public interface BaseCustomerDao extends BaseDao {
    public <T extends BaseEntity> void add(T t);

    public <T extends BaseEntity> void update(T t);

    public <T extends BaseEntity> void updateBySelective(T t);

    public void delete(Object id);

    public int queryByCount(Criteria criteria);

    public <T extends BaseEntity> List<T> queryByList(Criteria criteria);

    public <T extends BaseEntity> T queryById(Object id);
}
