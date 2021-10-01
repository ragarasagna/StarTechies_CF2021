package com.hsbc.dao;

import com.hsbc.exceptions.UploadNotSuccessfulException;

public interface ImportUsersDaoIntf {
	public void readFile() throws UploadNotSuccessfulException;
}
