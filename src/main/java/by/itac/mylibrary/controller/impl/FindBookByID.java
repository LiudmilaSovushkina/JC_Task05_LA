package by.itac.mylibrary.controller.impl;

import by.itac.mylibrary.controller.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.*;
import by.itac.mylibrary.service.exception.ServiceException;


public class FindBookByID implements Command{

	public String execute (String request) {
		ServiceProvider service = ServiceProvider.getInstance();
		BookService bookService = service.getBookService();
		
		String response = null;
		
		try {
			Long id = Long.parseLong(request);
			Book book = bookService.findByID(id);
			if (book == null) {
				response = "The book with this ID is missing";
			} else {
			response = book.toString();
			}
		} catch (ServiceException e) {
			response = "Book not found";
		}
		
		return response;
	}

}
