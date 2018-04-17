package com.jua.original.customer.service;


import com.jua.base.dao.BaseDao;
import com.jua.base.service.BaseService;

/**
 * 
 * <br>
 * <b>功能：</b>CustomerService<br>
 */
public interface BaseCustomerService extends BaseService {
    public abstract BaseDao getDao();

}
