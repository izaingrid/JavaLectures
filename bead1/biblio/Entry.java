package biblio;
import person.Author;

public class Entry{
	
	private Author author;
	private String title; 
	private int year;
	private String editor;
	private static int globalId =0;
	private int actualId=0;
	
	public final static int FORMAT_RAW = 0;
	public final static int FORMAT_AUTHOR_YEAR = 1;
	public final static int FORMAT_AUTHOR_YEAR_COMPACT = 2;
	
	private Entry(Author author, String title, int year, String editor){
		this.author = author;
		this.title = title;
		this.year = year;
		this.editor = editor;
		actualId = globalId++;
	}
	
	public static Entry make(Author author, String title, int year, String editor){
		
		if( author != null && title != null && editor != null && year >= 1500 && year <= 2016 && title.isEmpty() == false){
			return new Entry(author,title,year,editor);
		}
		return null;
	}
	
	public int getId(){
		return actualId;
	}
	
	public static void resetId(){
		globalId = 0;
	}
	
	public static int count(){
		return globalId;
	}
	
	public Author getAuthor(){
		return author;
	}
	
	public String getTitle(){
		return title;
	}
	
	public int getYear(){
		return year;
	}
	
	public String getPublisher(){
		return editor;
	}
	
	public String show(int parameter){
		String forma = "] "+author.show()+". "+title+", ";
		if (editor.equals(null) || editor.equals("")){
				forma +=year;
		}else{
			forma +=editor+", "+year;
		}
		switch(parameter){
			case FORMAT_RAW:
				return "["+actualId+forma;
			case FORMAT_AUTHOR_YEAR:
				return "["+author.getLastName()+year+forma;
			case FORMAT_AUTHOR_YEAR_COMPACT:
				return "["+author.show().charAt(0)+author.show().charAt(1)+year/10%10+""+year%10+forma;
		}
		return null;
	}
} 