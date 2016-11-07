package person;

public class Author{
	
	String lastName;
	String firstName;
	
	private Author(String firstName, String lastName){
		this.lastName = lastName;
		this.firstName = firstName;		
	}
	
	public static Author make(String name){ 
		if (name == null) return null;
		String[] parts = name.split(" ");
		if(parts.length == 2 && parts[0].length() >= 1 && parts[1].length() >=1){
			String fName = parts[0];
			String lName = parts[1];
			if(fName.charAt(0)>='A' && fName.charAt(0)<='Z' && lName.charAt(0)>='A' && lName.charAt(0)<='Z'){
				return new Author(fName,lName);				
			}
		}
		return null;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public Author(Author obj){
		if(obj == null) return; 
		lastName = obj.getLastName();
		firstName = obj.getFirstName();
	}

	public boolean equals(Author obj){
		if(obj == null) return false;
		if(lastName.equals(obj.getLastName()) && firstName.equals(obj.getFirstName())) return true;
		return false;
	}
	
	public String show(){
		return lastName + ", "+firstName.charAt(0);
	}
}