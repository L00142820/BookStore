package ie.lyit.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import ie.lyit.book.Book;;

public class BookSerializer {
	
	private static ArrayList <Book> bookList;
	
	// Default Constructor
	public BookSerializer () {
		// Cunstruct bookList ArrayList
		bookList = new ArrayList<Book>();
	}
	
	//Method Name: 
	//Retrun type:
	//Parameter:
	//purpose:
	
	public void add () {
		
		Book book = new Book();
		book.read();
		bookList.add(book);
	}
	
	public void writeRecordsToFile() {
		ObjectOutputStream os = null;
		
		try {
			FileOutputStream fileStream = new FileOutputStream("books.bin");
			
			os = new ObjectOutputStream(fileStream);
			
			os.writeObject(bookList);
			
		}catch (FileNotFoundException ex) {
			System.out.println("Cannot create file to store books");
		}catch ( Exception ex) {
			System.out.println(ex.getMessage());
		}finally {
			try {
				os.close();	
			}catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	
	
	public void readRecordsFromFile() {
		ObjectInputStream is = null;
		
		try {
			FileInputStream fileStream = new FileInputStream("books.bin");
			
			is = new ObjectInputStream(fileStream);
			
			bookList = (ArrayList<Book>) is.readObject();
			
		}catch (FileNotFoundException ex) {
			System.out.println("Cannot find books.bin file");
		}catch ( Exception ex) {
			System.out.println(ex.getMessage());
		}finally {
			try {
				is.close();	
			}catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	
	public void list() {
		for (Book tmpBook:bookList) {
			System.out.println(tmpBook);
		}
	}
	
	public Book view() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter library number of book: ");
		
		int bookToView = keyboard.nextInt();
		
		for ( Book tmpBook:bookList) {
			if(tmpBook.getLibraryNumber() == bookToView) {
				System.out.println(tmpBook);
				keyboard.close();
				return tmpBook;
			}
		}
		keyboard.close();
		return null;
	}
	
	public void delete() {
		Book tmpBook = view();
		
		if (tmpBook != null) {
			bookList.remove(tmpBook);
		}
		
	}
	
	
	public void edit () {
		Book tmpBook = view();
		
		if (tmpBook != null) {
			int index = bookList.indexOf(tmpBook);
			tmpBook.read();
			bookList.set(index, tmpBook);
		}
	}

}
