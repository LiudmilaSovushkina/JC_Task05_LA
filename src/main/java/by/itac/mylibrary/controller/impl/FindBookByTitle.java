package by.itac.mylibrary.controller.impl;

import java.util.List;

import by.itac.mylibrary.controller.impl.*;

import by.itac.mylibrary.controller.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;

public class FindBookByTitle implements Command {


	public String execute(String request) {
		ServiceProvider service = ServiceProvider.getInstance();
		BookService bookService = service.getBookService();
		
		String response = null;
		
		try {
			String title = request;
			List<Book> book = bookService.findByTitle(title);
			if (book.isEmpty()) {
				response = "No book with such title";
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
