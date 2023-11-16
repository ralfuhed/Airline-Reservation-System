// User.java
import java.util.*;

public class User {
	private String firstName;
	private String lastName;
	private String ID;
	private String username;
	private String password;

	// set to protected to have access to Reservation class
	protected boolean isAdmin;

	// Make a constructor that take strings
	public User(String userName, String passWord, String fName, String lName, String id, boolean admin) {
		super();
		this.username = userName;
		this.password = passWord;
		this.firstName = fName;
		this.lastName = lName;
		this.ID = id;
		this.isAdmin = admin;
	} // end User

	public String getUsername(){
                return username;
        } // end username getter

        public void setUsername(String tName) {
                this.username = tName;
        } // end username setter

        public String getPassword() {
                return password;
        } // end password getter

        public void setPassword(String tPassword) {
                this.password = tPassword;
        } // end password setter
	
	public String getFirstName() {
		return firstName;
	} // end firstName getter
	
	public void setFirstName(String f) {
		this.firstName = f;
	} // end firstName setter
	
	public String getLastName() {
		return lastName;
	} // end lastName getter
	
	public void setLastName(String l) {
		this.lastName = l;
	} // end lastName setter
	
	public String getID() {
		return ID;
	} // end ID getter
	
	public void setID(String tempID) {
		this.ID = tempID;
	} // end ID setter
	
	public boolean getAdmin() {
		return isAdmin;
	} // end admin getter
	
	public void setAdmin(boolean tAdmin) {
		this.isAdmin = tAdmin;
	} // end isAdmin setter
	
	public String userMenu() {
		Scanner input = new Scanner(System.in);
		System.out.println("1) Book a flight ticket");
		System.out.println("2) Cancel a ticket");
		System.out.println("3) Show Profile");
		System.out.println("4) Edit your ticket");
		System.out.println("5) Log out");
		System.out.print("Please enter your choice: ");
		
		String userResponse = input.nextLine();
		return userResponse;
	} // end userMenu()
	
	public String adminMenu() {
		Scanner input = new Scanner(System.in);
                System.out.println("1) List all customers");
                System.out.println("2) Show customers' record");
                System.out.println("3) Add new customer");
		System.out.println("4) Remove customer");
		System.out.println("5) Show your profile");
                System.out.println("6) Log out");
		System.out.print("Please enter your choice: ");
		
                String adminResponse = input.nextLine();
                return adminResponse;
	} // end adminMenu()
} // end class def
