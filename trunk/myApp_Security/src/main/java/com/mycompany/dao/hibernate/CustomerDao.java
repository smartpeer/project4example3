/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.dao.hibernate;

import com.mycompany.dao.ICustomerDao;
import com.mycompany.entity.Customer;
import java.util.Collection;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.security.access.prepost.PreAuthorize;




/**
 *
 * @author abdelkafi_s
 */
public class CustomerDao extends HibernateDaoSupport implements ICustomerDao{

    public Collection<Customer> getAll() {
        return getHibernateTemplate().loadAll(Customer.class);
    }

    public Customer getById(Long id) {
         return (Customer) getHibernateTemplate().load(Customer.class, id);
    }

    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public void save(Customer customer) {
        getHibernateTemplate().save(customer);
    }

    public void delete(Customer customer) {
        getHibernateTemplate().delete(customer);
    }
}
