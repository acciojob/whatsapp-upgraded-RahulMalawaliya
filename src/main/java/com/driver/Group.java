package com.driver;

public class Group {
    private String name;
    private int numberOfParticipants;
    private User Admin;
	public User getAdmin() {
		return Admin;
	}
	public void setAdmin(User admin) {
		Admin = admin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfParticipants() {
		return numberOfParticipants;
	}
	public void setNumberOfParticipants(int numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}
	
    public Group(String name,int numberOfParticipants){
        setName(name);
        setNumberOfParticipants(numberOfParticipants);
    }
	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
