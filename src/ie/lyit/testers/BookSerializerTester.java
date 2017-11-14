package ie.lyit.testers;

import ie.lyit.book.Menu;
import ie.lyit.serialize.BookSerializer;

public class BookSerializerTester {

	public static void main(String[] args) {
		
		BookSerializer bookSerializer = new BookSerializer();
		
		bookSerializer.readRecordsFromFile();
		
		Menu menuObj  = new Menu();
		
		do {
			menuObj.display();
			menuObj.readOption();
			
			switch(menuObj.getOption()) {
			case 1: bookSerializer.add(); break;
			case 2: bookSerializer.list(); break;
			case 3: bookSerializer.view(); break;
			case 4: bookSerializer.edit(); break;
			case 5: bookSerializer.delete(); break;
			case 6: break;
			default: System.out.println("invalid option"); 
			}
			
		}while(menuObj.getOption() != 6);
		
		
		bookSerializer.writeRecordsToFile();
		
		//bookSerializer.add();
		//bookSerializer.add();
		
		//bookSerializer.writeRecordsToFile();
		
	//	bookSerializer.readRecordsFromFile();
		
	//	bookSerializer.list();

	}

}
