package com.hsbc.business;

import com.hsbc.dao.ImportUsersDao;
import com.hsbc.dao.ImportUsersDaoIntf;
import com.hsbc.exceptions.UploadNotSuccessfulException;

public class ImportUsersService implements ImportUsersServiceIntf {

	ImportUsersDaoIntf dao;

	public ImportUsersService() {
		dao = new ImportUsersDao();
	}

	@Override
	public void readFile() {

		try {
			dao.readFile();
		} catch (UploadNotSuccessfulException e) {

			e.printStackTrace();
		}

	}

}
