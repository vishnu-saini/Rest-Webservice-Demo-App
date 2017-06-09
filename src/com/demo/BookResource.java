package com.demo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/book")
public class BookResource {

	private BookService dao=new BookServiceImp();
	
	// gettting all the book
	@GET
	//@Produces(MediaType.APPLICATION_JSON)
	@Produces({"application/xml", "application/json"})
	public List<Book> getAllBooks(){
		return dao.getAllBooks();
	}
	
	// getting a particular book
	@GET
	@Path("/{bookId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBookById(@PathParam("bookId") int bookId) throws BookNotFoundException{
		//return dao.getBookById(bookId);
		throw new BookNotFoundException("book not found");
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Book addBook(Book book){
		return dao.addBook(book);
		
	}
	
	// updating a book
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{bookId}")
	public Book updateBook(@PathParam("bookId") int bookId, Book book){
		book.setId(bookId);
		dao.updateBook(book);
		return book;
	}
	
	
	@DELETE
	@Path("/{bookId}")
	public void delete(@PathParam("bookId") int bookId){
		dao.removeBook(bookId);
	}
}
















