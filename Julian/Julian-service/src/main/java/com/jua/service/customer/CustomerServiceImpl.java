package com.jua.service.customer;

import com.jua.dao.customer.CustomerDao;
import com.jua.original.customer.service.BaseCustomerServiceImpl;
import com.jua.referent.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * <br>
 * <b>功能：</b>CustomerService<br>
 */
@Service("customerService")
public class  CustomerServiceImpl  extends BaseCustomerServiceImpl implements CustomerService {

	

	@Autowired
    private CustomerDao dao;

	@Override
	public CustomerDao getDao() {
		return dao;
	}

	@Override
	public Customer test(String id) {

		return dao.Test(id);
	}
}
