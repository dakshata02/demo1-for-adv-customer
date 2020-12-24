package com.capgemini.advertisement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.advertisement.dao.CustomerSpringDataDAO;
import com.capgemini.advertisement.entity.CustomerMaster;
import com.capgemini.advertisement.exception.CustomerException;

@Primary
@Service( value = "customerServiceSpringData")
@Transactional
public class CustomerServiceSpringDataImpl implements CustomerService{
	@Autowired
	private CustomerSpringDataDAO customerSpringDataDaoImpl;
	
	@Override
	public Integer addCustomer(CustomerMaster customer) throws CustomerException {
			try {
				
				CustomerMaster c= 
						customerSpringDataDaoImpl.save(customer);
				System.out.println(c);
			//	System.out.println(c.getCustId());
				
				return 1;
			}catch(DataAccessException dataAccessException) {
				throw new CustomerException(dataAccessException.getMessage(),dataAccessException);
			}catch(Exception exception) {
				throw new CustomerException(exception.getMessage(),exception);
			}
	}

	@Override
	public CustomerMaster getCustomerById(Integer customerId) throws CustomerException {
		try {
			Optional<CustomerMaster> optional= 
					customerSpringDataDaoImpl.findById(customerId);
			if(optional.isPresent()) {
				System.out.println(optional.get());
				return optional.get();
			}else {
				return null;
			}			
		}catch(DataAccessException dataAccessException) {
			throw new CustomerException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new CustomerException(exception.getMessage(),exception);
		}
	}

	@Override
	public Integer deleteCustomer(Integer customerId) throws CustomerException {
		try {
			customerSpringDataDaoImpl.deleteById(customerId);
			return 1;
		}catch(DataAccessException dataAccessException) {
			throw new CustomerException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new CustomerException(exception.getMessage(),exception);
		}
	}

	@Override
	public List<CustomerMaster> getAllCustomer() throws CustomerException {
		try {
			List<CustomerMaster> customerList=
					customerSpringDataDaoImpl.findAll();
			return customerList;
		}catch(DataAccessException dataAccessException) {
			throw new CustomerException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new CustomerException(exception.getMessage(),exception);
		}
	}

	@Override
	public CustomerMaster updateCustomer(CustomerMaster customer) throws CustomerException {
		try {
			CustomerMaster c= 
					customerSpringDataDaoImpl.save(customer);
			return c;
		}catch(DataAccessException dataAccessException) {
			throw new CustomerException(dataAccessException.getMessage(),dataAccessException);
		}catch(Exception exception) {
			throw new CustomerException(exception.getMessage(),exception);
		}
	}

//	@Override
//	public List<Product> getProductsBetweenPrice(Double p1, Double p2) throws ProductException{
//		try {
//			List<Product> productList=
//					productSpringDataDaoImpl.getProductsBetweenPrice(p1, p2);
//			return productList;
//		}catch(DataAccessException e) {
//			throw new ProductException(e.getMessage(),e);
//		}catch(Exception e) {
//			throw new ProductException(e.getMessage(),e);
//		}
//	}

}
