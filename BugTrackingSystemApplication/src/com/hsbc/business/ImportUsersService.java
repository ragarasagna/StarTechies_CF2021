package com.hsbc.business;

import com.hsbc.dao.ImportUsersDao;
import com.hsbc.dao.ImportUsersDaoIntf;
import com.hsbc.exceptions.UploadNotSuccessfulException;

public class ImportUsersService implements ImportUsersServiceIntf{

	ImportUsersDaoIntf dao;
	public ImportUsersService()
	{
		dao= new ImportUsersDao();
	}
	@Override
	public void readFile() {
		// TODO Auto-generated method stub
				
			try {
				dao.readFile();
			} catch (UploadNotSuccessfulException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
		
	}

}
