package com.capgemini.advertisement.service;

import java.util.List;

import javax.persistence.PersistenceException;

import com.capgemini.advertisement.dao.StaffDAO;
import com.capgemini.advertisement.dao.StaffDAOImpl;
import com.capgemini.advertisement.entity.Staff;
import com.capgemini.advertisement.exception.StaffException;

public class StaffServiceImpl implements StaffService
{

	private StaffDAO staffDAO=new StaffDAOImpl();
	@Override
	public void addStaff(Staff staff) throws StaffException 
	{
		try 
		{
			staffDAO.addStaff(staff);			
		}
		catch(PersistenceException e) 
		{
			throw new StaffException(e.getMessage(),e);
		}
	}

	@Override
	public Staff getStaffById(Integer staffId) throws StaffException 
	{
		try
		{			
			Staff staff= staffDAO.getStaffById(staffId);
			return staff;
		}
		catch(PersistenceException e) 
		{
			throw new StaffException(e.getMessage(),e);
		}
	}

	@Override
	public Integer deleteStaff(Integer staffId) throws StaffException 
	{
		try 
		{			
			Integer id= staffDAO.deleteStaff(staffId);
			return id;
		}
		catch(PersistenceException e) 
		{
			throw new StaffException(e.getMessage(),e);
		}
	}

	@Override
	public List<Staff> getAllStaff() throws StaffException
	{
		try 
		{			
			List<Staff> staffList= 	staffDAO.getAllStaff();
			return staffList;
		}
		catch(PersistenceException e) 
		{
			throw new StaffException(e.getMessage(),e);
		}
	}

	@Override
	public Staff updateStaff(Staff staff) throws StaffException 
	{
		try 
		{			
			Staff updatedStaff= staffDAO.updateStaff(staff);	
			return updatedStaff;
		}
		catch(PersistenceException e) 
		{
			throw new StaffException(e.getMessage(),e);
		}
	}

}
