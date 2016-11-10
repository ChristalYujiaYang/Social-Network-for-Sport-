/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.Customer;
import Bean.Customer;

/**
 *
 * @author wyh1
 */
public interface ICustomerDAO {
    public boolean findCustomer(Customer customer) throws Exception;
    public boolean findLogin(Customer customer) throws Exception;
}
