import java.util.Scanner;

public class PhoneBook {
	
	ContactLinkedListADT ContactList;
	EventLinkedList EventList;
	
	public void scheduleEvent() { //not done yet
		
	}

	public void PrintEventDetails (){//not done yet event need to be implemented first

	}
/*
	//printing all contacts that share an event
	public void printContact_event(Event e) { //need to be tested after implementing method schedule events
		Node current = ELL.head ;
		while (current != null) {
			if (  ((Event) current.data).getTitle().equals(e.getTitle())  )
				if ( ((Event) current.data).getDate().equals(e.getDate())  )
					if ( ((Event) current.data).getTime().equals(e.getTime()) )
						if ( ((Event) current.data).getTime().equals(e.getTime()) )
							if ( ((Event) current.data).getLocation().equals(e.getLocation()) )
								if ( ((Event) current.data).getContact().equals(e.getContact()) )
									System.out.println(current.toString());
			current=current.next;
		}
	}*/

	//printing all contacts that share the first name
	public void printContact_name( ContactLinkedListADT li, String name) { 
		Node<Contact> current=li.head;
		String ContactName , firstName;
		while(current!=null) {
			ContactName= ((Contact) current.data).getName();
			String[] fullName= ContactName.split(" ");
			firstName= fullName[0];

			if(firstName.equals(name)) {
				System.out.println("Contacts found!");
				System.out.println( current.data.toString());
			}
			current=current.next;
		}
	}
	public void API() {//CLI for the application
		int action;
		Scanner input = new Scanner(System.in) ;
		System.out.println("Welcome to theLinkedTreePhonebook!");
		do{
			System.out.println("\n Please choose an option:\n 1.Add a contact\n 2. Search for a contact\n 3.Delete a contact\n 4.Scheduleanevent\n 5.Printeventdetails\n 6.Printcontacts byfirstname\n 7. Print all events alphabetically\n 8.Exit");
			System.out.println("Enter your choice:");
			action = input.nextInt();

			switch (action){
				case 1:
					System.out.println("Enter the contact's name:");
					String name = input.nextLine();
					System.out.println("Enter the contact's phone number:");
					String  phoneNumber = input.nextLine();
					System.out.println("Enter the contact's email address:");
					String emailAddress = input.nextLine();
					System.out.println(" Enter the contact's address:");
					String address = input.nextLine();
					System.out.println("Enter the contact's birthday:");
					String birthday = input.nextLine();
					System.out.println("Enter any notes for the contact:");
					String notes = input.nextLine();
					this.ContactList.add(new Contact(name,phoneNumber,emailAddress,birthday,address,notes));
					break;
				case 2:
					System.out.println("Enter search criteria:\n 1.Name\n 2.Phone Number\n 3.Email Address\n 4.Address\n 5.Birthday");
					System.out.println("Enter your choice:");
					int criteria= input.nextInt();
					switch(criteria){
						case 1:
							System.out.println("Enter the contact's name:");
							System.out.println("Contact found!"+this.ContactList.SearchByName(input.nextLine()).toString()+);
							break;
						case 2:
							System.out.println("Enter the contact's Phone Number:");
							System.out.println("Contact found!"+this.ContactList.SearchByPhoneNumber(input.nextLine()).toString());
							break;
						case 3:
							System.out.println("Enter the contact's Email Address:");
//							System.out.println("Contact found!"+this.ContactList.SearchByEmailAddress(input.nextLine()).toString());// method should return contact
							break;
						case 4:
							System.out.println("Enter the contact's Address:");
//							System.out.println("Contact found!"+this.ContactList.SearchByAddress(input.nextLine()).toString());// method should return contact
							break;
						case 5:
							System.out.println("Enter the contact's Birthday:");
//							System.out.println("Contact found!"+this.ContactList.SearchByBirthday(input.nextLine()).toString());// method should return contact
							break;
					}
					break;
				case 3:
					System.out.println("Enter the contact's name:");
					this.ContactList.Delete(this.ContactList.SearchByName(input.nextLine()));
					System.out.println("Contact has been deleted successfully :)");
					break;
				case 4:
					Event eventToAdd = new Event();
					System.out.println("Enter event title:");
					String Title = input.nextLine();
					System.out.println("Enter contact name:");
					String name = input.nextLine();
					System.out.println("Enter event date and time ");
					String date_time = input.nextLine();
					System.out.println("Enter event location:");
					String location = input.nextLine();
					//required: seperating date and time +adding event method with contact
					System.out.println(eventToAdd.toString()+"Event scheduled successfully!");
					break;
				case 5:
					System.out.println("Enter search criteria:\n 1.contact name\n 2.Event title");
					System.out.println("Enter your choice");
					int criteria = input.nextInt
					switch(criteria){
						case 1:
							System.out.println("Enter the contact name:");
							String name = input.nextLine();
							//Printeventdetails by contactname method
							System.out.println("Event found!");
							break;
						case 2:
							System.out.println("Enter the event title:");
							String Title = input.nextLine();
							//Printeventdetails by event title method
							System.out.println("Event found!");
							break;
					}
					break;
				case 6:
					System.out.println("Enter the firstname:");
					String firstname = input.nextLine();
					PrintContactByFirstName(firstname);
					System.out.println("Contacts found!");
					break;
				case 7:
					//Print all events alphabetically method
					break;
			}
		}while (action != 8);
		System.exit(0);
	}

}//class
