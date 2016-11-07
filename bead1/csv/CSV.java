package csv;

import java.util.Scanner;
import java.util.ArrayList;

public class CSV{
	private String[][] objs; 
	
	private CSV(String[][] tomb){
		objs = tomb;
	}
	
	public static CSV read(Scanner sc){
		String[][] tmp;
		ArrayList<String> array = new ArrayList<String>(); 
		while(sc.hasNextLine()){
			array.add(sc.nextLine());
		}
		tmp = new String[array.size()][];
		for(int i =0; i < array.size(); i++){
			tmp[i] = array.get(i).split(",");
			for(int j = 0; j < tmp[i].length; ++j){
				tmp[i][j]=tmp[i][j].trim();
			}
		}
		return new CSV(tmp);
	}
	
	public String[][] getContents(){
		String[][] newObj = new String[objs.length][];
		for (int i = 0; i < objs.length; ++i){
			newObj[i] = new String[objs[i].length];
			for(int j = 0; j < objs[i].length; ++j){
				newObj[i][j] = new String(objs[i][j]);
			}
		}
		return newObj;
	}
	
}