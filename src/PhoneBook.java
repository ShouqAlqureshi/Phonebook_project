
import java.util.Scanner;


public class PhoneBook {
	
	ContactLinkedListADT ContactList = new ContactLinkedListADT();
	EventLinkedList EventList = new EventLinkedList();
	
	Scanner input = new Scanner(System.in);
	
	public void scheduleEvent() { //not done yet
		
		String eventDate, eventTime; //0
        Contact con ; //0
        System.out.print("Enter event title"); //1
        String ETitle = input.nextLine(); //1
        System.out.print("Enter contact name"); //1
        String CName = input.nextLine(); //1
        if(ContactList.SearchByName(CName)!= null){ //m
            con = ContactList.SearchByName(CName) ; //m

            
            System.out.print("Enter event date and time MM/DD/YYYY HH:MM"); //1
            String eventTandD= input.nextLine(); //1
            String[] timeAndDate = eventTandD.split(" "); //n
             eventDate= timeAndDate[0]; //1
             eventTime= timeAndDate[1]; //1
            if(conflict(con ,eventTime,eventDate)){ //mn+m
                System.out.println("Date and time are not available"); //1
                return; //1
            }
            System.out.print("Enter event location"); //1
                  String Elocation= input.nextLine(); //1
                  Event EventToBeSchedule = new Event(ETitle ,eventDate ,eventTime , Elocation , con ) ; //1
                  EventList.insertToSortedList (EventToBeSchedule ); //n^2+m
                  con.scheduledEvents.insertToSortedList(EventToBeSchedule); //n^2+m

            System.out.println("\nEvent scheduled successfully!"); //1
        }
        else {
        System.out.println("Contact doesn't exist"); //1
            return; //1
            }//16+5m+n+2n^2+mn >> o(m+n^2+mn)
}

   
    public boolean conflict(Contact c , String time , String Date){
    	
    	Node<Event> tmp = EventList.head; //1
    	while(tmp!= null) { //m+1
    		if(tmp.data.getDate().equals(Date) && tmp.data.getTime().equals(time)) //m(n)
    			return true; //1
    	}
    	return false; //1
    }//4 + m+mn >> o(mn+m)
		
	


	//printing all contacts that share an event
	public void printContactShareEvent(Event e) { //need to be tested after implementing method schedule events
		Node current = EventList.head ; //1
		while (current != null) { //m+1
			if (  ((Event) current.data).getTitle().equals(e.getTitle())  ) //m(n)
				if ( ((Event) current.data).getDate().equals(e.getDate())  ) //m(n)
					if ( ((Event) current.data).getTime().equals(e.getTime()) ) //m(n)
						if ( ((Event) current.data).getLocation().equals(e.getLocation()) ) //m(n)
								System.out.println(((Event) current.data).getContact().toString()); //m
			current=current.next; //m
		}
	} // 2+3m+4mn >> o(mn+m)
	
	

	//printing all contacts that share the first name
	public void printContactShareName( String name) { 
		Node<Contact> current=ContactList.head; //1
		String ContactName , firstName; //0
		while(current!=null) { //m+1
			ContactName= ((Contact) current.data).getName(); //m
			String[] fullName= ContactName.split(" "); //mn
			firstName= fullName[0]; //m

			if(firstName.equals(name)) { //mn
				System.out.println("Contacts found!"); //m
				System.out.println( current.data.toString()); //m
			}
			current=current.next;//m
		}
	}//2+6m+2mn >> o(mn+m)
	
	

	//printEventsAlphabetically and insertToSortedList not yet tested, need scheduleEvent to be implemented
      //print all events ordered alphabetically by event title
        public void printEventsAlphabetically() {
            Node current = EventList.head; //1
            while (current != null) { //m+1
                System.out.println(current.data.toString()); //m
                current = current.next; //m
            }
        }//3m+2 >> o(m)

	//printing all contacts that share the first name
	public void printContactShareName( String name) { 
		Node<Contact> current=ContactList.head;
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

	//printEventsAlphabetically and insertToSortedList not yet tested, need scheduleEvent to be implemented
      //print all events ordered alphabetically by event title
        public void printEventsAlphabetically() {

            Node current = EventList.head;
            while (current != null) {
                System.out.println(current.data.toString());
                current = current.next;
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
							System.out.println("Contact found!"+this.ContactList.SearchByName(input.nextLine()).toString());
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
					String ContactName = input.nextLine();
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
					int criteriaToSearch = input.nextInt();
					switch(criteriaToSearch){
						case 1:
							System.out.println("Enter the contact name:");
							String contactName = input.nextLine();
							//Printeventdetails by contactname method
							System.out.println("Event found!");
							break;
						case 2:
							System.out.println("Enter the event title:");
							String title = input.nextLine();
							//Printeventdetails by event title method
							System.out.println("Event found!");
							break;
					}
					break;
				case 6:
					System.out.println("Enter the firstname:");
					String firstname = input.nextLine();
					ContactList.PrintContactByFirstName(firstname);
					System.out.println("Contacts found!");
					break;
				case 7:
					//Print all events alphabetically method
					break;
			}
		}while (action != 8);
		System.exit(0);
	}
	
    public static void main(String[] args) {//testing area 
    	
        Contact c1 = new Contact("Ahmad AlSaud", "05937636532", "jnjnjnj", "nnk222", "299","299");
        Contact c2 = new Contact("Ahmad Alzaid", "7968867456", "njnjnj", "mmkmkm", "klll","299");
        Contact c3 = new Contact("Ahmad", "7968867456", "njnjnj", "mmkmkm", "klll","299");
        Contact c4 = new Contact("b2", "7968867456", "njnjnj", "mmkmkm", "klll","299");
        Contact c5 = new Contact("b6", "7968867456", "njnjnj", "mmkmkm", "klll","299");
        Contact c6 = new Contact("b4", "7968867456", "njnjnj", "mmkmkm", "klll","299");
        Contact c7 = new Contact("b3", "7968867456", "njnjnj", "mmkmkm", "klll","299");

        
        Event e1 = new Event("title", "MM/DD/YYYY" , "HH:MM", "location" , c1);
        
        PhoneBook testing = new PhoneBook();
        
        ContactLinkedListADT cll=new ContactLinkedListADT();
        testing.ContactList.add(c1);
        testing.scheduleEvent();
        testing.scheduleEvent();
        testing.printEventsAlphabetically();
        /*
        testing.ContactList.add(c2);
        testing.ContactList.add(c3);
        testing.ContactList.add(c4);
        testing.ContactList.add(c5);
        testing.ContactList.add(c6);
        testing.ContactList.add(c7);
        */

        // uniqueness checks each letter it will accept b11 with b1

    }
    


}//class
