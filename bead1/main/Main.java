package main;

import person.*;
import csv.*;
import biblio.*;
import java.util.Scanner;

public class Main{
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		CSV csv = CSV.read(in);
		Bibliography bib = new Bibliography(csv);
		Query query ; 
		if((args.length == 0)){
			System.out.print(bib.show(Entry.FORMAT_RAW));
		}else{
			String format="", name="", author = "";
			for(int i =0; i< args.length; i++){
				if(args[i].equals("format=")){
					format = args[i+1];
				}else if(args[i].equals("publisher=")){
					name = args[i+1]; 
					author = "";
				}else if(args[i].equals("author=")){
					author = args[i+1]; 
					name = "";
				}
			}
			
			if(!name.equals("")){
				query = Query.byPublisher(name);
				bib.filter(query);
			}
			if(!author.equals("")){
				query = Query.byAuthor(Author.make(author));
				bib.filter(query);
			}
			
			if(!format.equals("")){
				if(format.equals("raw")){
					System.out.print(bib.show(Entry.FORMAT_RAW));
				}else if(format.equals("authorYear")){
					System.out.print(bib.show(Entry.FORMAT_AUTHOR_YEAR));
				}else{
					System.out.print(bib.show(Entry.FORMAT_AUTHOR_YEAR_COMPACT));
				}
			}else{
				System.out.print(bib.show(Entry.FORMAT_RAW));
			}
		}
		in.close();
	}
	
}