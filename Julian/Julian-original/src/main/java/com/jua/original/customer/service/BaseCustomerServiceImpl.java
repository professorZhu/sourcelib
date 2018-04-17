package com.jua.original.customer.service;

import com.jua.base.dao.BaseDao;
import com.jua.base.service.BaseServiceImpl;

/**
 * 
 * <br>
 * <b>功能：</b>CustomerService<br>
 */
public abstract class BaseCustomerServiceImpl extends BaseServiceImpl implements BaseCustomerService {

	public abstract BaseDao getDao();

}
