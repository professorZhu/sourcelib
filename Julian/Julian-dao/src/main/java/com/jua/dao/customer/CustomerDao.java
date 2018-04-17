package com.jua.dao.customer;

import com.jua.original.customer.dao.BaseCustomerDao;
import com.jua.referent.entity.Customer;
import org.springframework.stereotype.Repository;

/**
 * 2018/4/11
 * <p/>
 * Created by zhuqiang3
 */
@Repository("customerDao")
public interface CustomerDao extends BaseCustomerDao {

    public Customer Test(String id);
}