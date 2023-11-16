// Reservation.java

import java.util.*;
import java.io.*;

class Reservation implements AirlineSystem {
	ArrayList<User> users = new ArrayList<>();
	ArrayList<Flight> flightArray = new ArrayList<>();
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
                new Reservation();
        } // end main

	public Reservation() {	
	
		// The admin's gate
		users.add(new User("xawoods", "1234", "Xavier", "Woods", "20001212", true));

		// the customer's gate
		users.add(new User("rollo2020", "2580", "Rollo", "Lothbrok", "20002840", false));
		users.add(new User("the_monster1068", "9110", "Rashed", "Alyami", "20009410", false));


		System.out.print("Please enter your username: ");
		String username = input.nextLine();
		System.out.print("Please enter your password: ");
		String password = input.nextLine();
		
		boolean keepGoing = true;
		while(keepGoing) {
			int logIn = 0;
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)) {
					
					// Set the logIn switch to 1 if the condition is true
					logIn = 1;
					if (users.get(i).getAdmin()) {
		
						// Display admin's menu
						String adminResponse = users.get(i).adminMenu();
				
						if (adminResponse.equals("1")) {
							for(int j = 0; j < users.size(); j++) {

								// Show only customers' info
								if (users.get(j).isAdmin == false) {
									System.out.println("User: " + users.get(j).getLastName() + ", " + users.get(j).getFirstName());
									System.out.println("");
								} else {	
									// Print out an empty string because we don't want to show the admin's info :)
									System.out.println("");
								} // end if
							} // end for

						} else if (adminResponse.equals("2")) {
							for(int k = 0; k < users.size(); k++) {
								if (users.get(k).isAdmin == false) {
									System.out.println(" Username: " + users.get(k).getUsername());
									System.out.println(" ID: " + users.get(k).getID());
									System.out.println(" Name: " + (users.get(k).getFirstName()) + " " + users.get(k).getLastName());
									System.out.println(" -------------------------------------\n");
								} else {
									System.out.println("");
								} // end if
							} // end for
						} else if (adminResponse.equals("3")) {
							System.out.print("Please enter the username: ");
							String newUser = input.nextLine();
							System.out.print("Enter the password: ");
							String newPassword = input.nextLine();
							System.out.print("Enter the user's ID: ");
							String newID = input.nextLine();
							System.out.print("Enter the user's first name: ");
							String newFirst = input.nextLine();
							System.out.print("Enter the user's last name: ");
							String newLast = input.nextLine();
							
							users.add(new User(newUser, newPassword, newFirst, newLast, newID, false));
							System.out.println("User has been added successfully!");
						
						} else if (adminResponse.equals("4")) {
							System.out.print("Please enter the user's username required to be removed: ");
							String user1 = input.nextLine();
							
							// Set the flag to integer for errors
							int flag = 0;
							// Iterate the users to find the one required to be removed
							Iterator<User> user = users.iterator();
							while(user.hasNext()) {
								// The admin will remove users by their username
								if (user.next().getUsername().equals(user1)) {
									flag = 1;
									user.remove();
								} // end if
							} // end while
							
							if (flag == 1) {
								System.out.println("User has been removed!");

							} else {
								System.out.println("User, " + (user1) + ", not found!");
							} // end if
						
						} else if (adminResponse.equals("5")) {
							for (int x = 0; x < users.size(); x++) {
								if (users.get(x).isAdmin == true) {
									System.out.println("");
									System.out.println(" Username: " + users.get(x).getUsername());
                                                                        System.out.println(" ID: " + users.get(x).getID());
                                                                        System.out.println(" Name: " + (users.get(x).getFirstName()) + " " + users.get(x).getLastName());
									System.out.println("");
								} else {
									System.out.print("");
								} // end if
							} // end for
						} else if (adminResponse.equals("6")) {
							System.out.println("Logged out...");
							keepGoing = false;
							return;
						
						} else {
							System.out.println("Invalid input. Please choose one of the following options!");
						} // end if 

					} else {
						// Display customer's menu
						String userResponse = users.get(i).userMenu();
						
						if (userResponse.equals("1")) {
							System.out.print("From: ");
							String source = input.nextLine();
							System.out.print("To: ");
							String departure = input.nextLine();
							System.out.print("Please choose the airline you want to travel with: ");
							String airline = input.nextLine();
							System.out.print("Reservation complete! Your ticket number is: ");

							// This is a random number generator for the ticket number, 
							// and it will be 6 digits only to be easier for the user
							// to cancel or save it
							Random rnd = new Random();
							int ticketNum = rnd.nextInt(999999);
							System.out.print(ticketNum);

							// Add the inputed info to the ArrayList
							flightArray.add(new Flight(source, departure, airline, ticketNum));
							
							System.out.println("");

							// And then print ticket
							printTicket();
							saveTicket();
							
							// Spacer
							System.out.println("");
						} else if (userResponse.equals("2")) {
							System.out.print("Please enter the ticket number you want to cancel: ");
							int ticketNum1 = input.nextInt();

							// Find the ticket you want to cancel
							int shout = 0;
							Iterator<Flight> ticket = flightArray.iterator();
							while(ticket.hasNext()) {
								if (ticket.next().getTicketNum() == (ticketNum1)) {
									shout = 1;
									ticket.remove();
								} // end if
							} // end while

							if (shout == 1) {
								System.out.println("Ticket has been canceled successfully!");
							} else {
								System.out.println("Ticket number " + (ticketNum1) + " Not found!");
							} // end if
						} else if (userResponse.equals("3")) {
							System.out.print("Please enter your password again for security purposes: ");
							String pin = input.nextLine();
							for (int l = 0; l < users.size(); l++) {
								if (users.get(l).getPassword().equals(pin)) {
									System.out.println("Name: " + users.get(l).getFirstName() + " " + users.get(l).getLastName());
									System.out.println("Username: " + users.get(l).getUsername());
									System.out.println("ID: " + users.get(l).getID());
								} // end if
							} // end for
						
						} else if (userResponse.equals("4")) {
							// load the ticket to edit it
							loadTicket();
							editTicket();
						} else if (userResponse.equals("5")) {
							System.out.println("Logged out...");
							keepGoing = false;
							return;
						} else {
							System.out.println("Invalid input. Please choose one of the following options!");
						} // end if
					} // end nested if
				} // end if
			} // end for
			
			// A condition for the log in errors
			if (logIn == 0) {
				System.out.println("The username or password entered is incorrect!");
				keepGoing = false;
				return;
			} // end if
		} // end while
	} // end constructor
		
	public void editTicket() {
		System.out.println("From: ");
                String source2 = input.nextLine();
               	System.out.println("To: ");
                String departure2 = input.nextLine();
                System.out.println("Please choose the airline you want to travel with: ");
                String airline2 = input.nextLine();
                System.out.println("Reservation complete! Your new ticket number is: ");

                Random rnd = new Random();
                int ticketNum2 = rnd.nextInt(999999);
                System.out.print(ticketNum2);

          	flightArray.add(new Flight(source2, departure2, airline2, ticketNum2));

               	printTicket();
                saveTicket();
              	System.out.println("\n\n");
	} // end if
	
	public void printTicket() {
	try {
		FileWriter outFile = new FileWriter("Ticket.txt", false);
		PrintWriter output = new PrintWriter(outFile);

		// This is a special type of ticket generator, this is not only printing one ticket
		// but also printing all of your tickets. It's more like a wallet, tickets wallet :)
		for (int h = 0; h < flightArray.size(); h++) {
			output.println("Ticket Number: " + flightArray.get(h).getTicketNum());
                        output.println("Source: " + flightArray.get(h).getSource());
                 	output.println("Departure: " + flightArray.get(h).getDeparture());
                       	output.println("Airline: " + flightArray.get(h).getAirline());
                	output.println("-------------------------------");
                } // end for

		outFile.close();
		output.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} // end try
	} // end printTicket()
	
	public void saveTicket() {
		this.serial();
	} // end saveTicket

	public void loadTicket() {
		try {
			FileInputStream inFile = new FileInputStream("Ticket.ser");
                        ObjectInputStream obIn = new ObjectInputStream(inFile);
                        User user = (User)obIn.readObject();
                        obIn.close();
                        inFile.close();

                        } catch (IOException e) {
				System.out.print("");
                        } catch (ClassNotFoundException c) {
                                System.out.println(c.getMessage());
                        } // end try
	} // end loadTicket
	
	public void serial() {
		try {
                        FileOutputStream fo = new FileOutputStream("Ticket.ser");
                        ObjectOutputStream obOut = new ObjectOutputStream(fo);
                        obOut.writeObject(this);
                        obOut.close();
                        fo.close();
                } catch(IOException e) {
                        System.out.println("");
                } // end try
	} // end serial
	
} // end Reservation
