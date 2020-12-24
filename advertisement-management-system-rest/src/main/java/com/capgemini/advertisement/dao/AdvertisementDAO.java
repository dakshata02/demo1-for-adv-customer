package com.capgemini.advertisement.dao;


import java.util.List;

import javax.persistence.PersistenceException;

import com.capgemini.advertisement.entity.AdvertisementDetails;

public interface AdvertisementDAO {
	public void addAdvertisement(AdvertisementDetails advertisement) throws PersistenceException;
	public AdvertisementDetails getAdvertisementById(Integer id) throws PersistenceException;
	public Integer deleteAdvertisement(Integer id) throws PersistenceException;
	public List<AdvertisementDetails> getAllAdvertisement() throws PersistenceException;
	public AdvertisementDetails updateAdvertisement(AdvertisementDetails advertisement) throws PersistenceException;
	
}
