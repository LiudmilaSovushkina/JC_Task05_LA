package by.itac.mylibrary.controller.impl;


import java.util.List;

import by.itac.mylibrary.controller.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;

public class FindBookByAuthor implements Command {
	


	public String execute(String request) {
		ServiceProvider service = ServiceProvider.getInstance();
		BookService bookService = service.getBookService();
		
		String response = null;
		
		try {
			String author = request;
			List<Book> book = bookService.findByAuthor(author);
			if (book.isEmpty()) {
				response = "The books of this author are missing.";
			} else {
				for (Book b : book) {
				response = response + b.toString() + '\n';
				}
			}
		} catch (ServiceException e) {
			response = "An error occurred while searching for the book";
		}
		
		return response;
	}

}
