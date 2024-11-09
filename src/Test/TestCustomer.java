/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import DAOImpl.CustomerDAOImpl;
import Entity.Customer;
import java.util.List;

/**
 *
 * @author Shreck
 */
public class TestCustomer {
    public static void main(String[] args) {
        CustomerDAOImpl DAO = new CustomerDAOImpl();
//        Customer cust = DAO.Ge;
        List<Customer> list = DAO.getAllData();
        for (Customer o : list) {
            System.out.println(o.getIdCustomer());
            System.out.println(o.getCustomerName());
            System.out.println(o.getPoint());
            System.out.println(o.getPhone());
            System.out.println(o.isStatus());
            System.out.println(o.getDescription());
        }
        
    }
    
}
