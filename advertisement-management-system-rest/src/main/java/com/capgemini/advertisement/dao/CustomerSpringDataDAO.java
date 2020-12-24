package com.capgemini.advertisement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.advertisement.entity.CustomerMaster;



//Spring Data JPA

@Repository
public interface CustomerSpringDataDAO
				extends JpaRepository<CustomerMaster,Integer>{
	
//	@Query("From Product p where p.productPrice BETWEEN :p1 AND :p2")
//	List<CustomerMaster> getProductsBetweenPrice(@Param("p1") Double p1,
//												@Param("p2") Double p2);
	
}

