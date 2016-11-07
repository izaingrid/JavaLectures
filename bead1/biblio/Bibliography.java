package biblio;

import java.util.ArrayList;
import csv.CSV;
import person.Author;

public class Bibliography{

	private ArrayList<Entry> entries; 

	public Bibliography(CSV csv){
		String[][] tmp = csv.getContents();
		entries = new ArrayList<Entry>();
		Entry.resetId();
		for(int i =0; i < tmp.length; ++i){
			if(tmp[i].length == 4 ){
				Author au = Author.make(tmp[i][0]);
				if(au != null && tmp[i][3].chars().allMatch( Character::isDigit )){
					int n = Integer.parseInt(tmp[i][3]); // szam ellenorzes
					entries.add(Entry.make(au, tmp[i][1], n, tmp[i][2]));
				}
			}
		} 
		
	}
	
	public void filter(Query query){
		ArrayList<Entry> newEntries = new ArrayList<Entry>();
		for(Entry i : entries){
			if(query.accept(i)) {
				newEntries.add(i);
			}
		}
		entries = newEntries;
	}
	
	public String show(int n){
		String str = "";
		for(Entry e : entries){
			if(e != null) str += e.show(n)+"\n";
		}
		return str;
	}
}