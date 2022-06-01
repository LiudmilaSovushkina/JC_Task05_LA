package by.itac.mylibrary.dao;

import by.itac.mylibrary.dao.impl.FileCRUDBookDAO;
import by.itac.mylibrary.dao.impl.FileFindBookDAO;
import by.itac.mylibrary.dao.impl.LibraryInitialization;

public final class DAOProvider {
	private static final DAOProvider instance = new DAOProvider();

	private CRUDBookDAO bookDAO = new FileCRUDBookDAO();
	private FindBookDAO findDAO = new FileFindBookDAO();
	private LibraryInitialization libraryInitialized = new LibraryInitialization ();

	public DAOProvider() {

	}

	public CRUDBookDAO getBookDAO() {
		return bookDAO;
	}

	public FindBookDAO getFindDAO() {
		return findDAO;
	}

	public static DAOProvider getInstance() {
		return instance;
	}
	
	public LibraryInitialization getLibraryInitialized () {
		return libraryInitialized;
	}

}
