package by.itac.mylibrary.start;

import by.itac.mylibrary.controller.Controller;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;

public class Main {

	public static void main(String[] args) {
		
		
		ServiceProvider provider = ServiceProvider.getInstance();
		
		BookService service = provider.getBookService();
		
		Book b1 = new Book(4, "Портрет Дориана Грея",  "Оскар Уальд", 1977, "available");
		
		
		try {
			service.save(b1);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

}
