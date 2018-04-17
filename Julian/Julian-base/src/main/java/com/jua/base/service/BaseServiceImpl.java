package com.jua.base.service;


import com.jua.base.criteria.Criteria;
import com.jua.base.dao.BaseDao;
import com.jua.base.entity.BaseEntity;

import java.util.List;

public abstract class BaseServiceImpl implements BaseService {

    public abstract BaseDao getDao();


    public <T extends BaseEntity> void add(T t) throws Exception {
       getDao().add(t);
    }

    public <T extends BaseEntity> void update(T t) throws Exception {
        getDao().update(t);
    }


    public <T extends BaseEntity> void updateBySelective(T t) {
        getDao().updateBySelective(t);
    }

    public void delete(Object... ids) throws Exception {
        if (ids == null || ids.length < 1) {
            return;
        }
        for (Object id : ids) {
            getDao().delete(id);
        }
    }

    public int queryByCount(Criteria criteria) throws Exception {

        return getDao().queryByCount(criteria);

    }

    public <T extends BaseEntity> List<T> queryByList(Criteria criteria) throws Exception {

        int size = queryByCount(criteria);

        if (size > 0) {

            criteria.setTotalCount(size);

            return getDao().queryByList(criteria);
        }

        return null;
    }

    public <T extends BaseEntity> T queryBySingle(Criteria criteria) throws Exception {

        List<T> list = queryByList(criteria);

        if (list != null && list.size() > 0) return list.get(0);

        return null;
    }

    public <T extends BaseEntity> T queryById(Object id) throws Exception {

        return getDao().queryById(id);

    }
}
