
import java.util.Scanner;


public class PhoneBook {
	
	ContactLinkedListADT ContactList = new ContactLinkedListADT();
	EventLinkedList EventList = new EventLinkedList();
	
	Scanner input = new Scanner(System.in);
	
	public void scheduleEvent() { //not done yet
		
		String eventDate, eventTime;
        Contact con ;
        System.out.print("Enter event title");
        String ETitle = input.nextLine();
        System.out.print("Enter contact name");
        String CName = input.nextLine();
        if(ContactList.SearchByName(CName)!= null){
            con = ContactList.SearchByName(CName) ;

            
            System.out.print("Enter event date and time MM/DD/YYYY HH:MM");
            String eventTandD= input.nextLine();
            String[] timeAndDate = eventTandD.split(" ");
             eventDate= timeAndDate[0];
             eventTime= timeAndDate[1];
            if(conflict(con ,eventTime,eventDate)){
                System.out.println("Date and time are not available");
                return;
            }
            System.out.print("Enter event location");
                    String Elocation= input.nextLine();
                  Event EventToBeSchedule = new Event(ETitle ,eventDate ,eventTime , Elocation , con ) ;
                  EventList.insertToSortedList (EventToBeSchedule );
                  con.scheduledEvents.insertToSortedList(EventToBeSchedule);

            System.out.println("\nEvent scheduled successfully!");
        }
        else {
        System.out.println("Contact doesn't exist");
            return;
            }
}

   
    public boolean conflict(Contact c , String time , String Date){
    	
    	Node<Event> tmp = EventList.head;
    	while(tmp!= null) {
    		if(tmp.data.getDate().equals(Date) && tmp.data.getTime().equals(time))
    			return true;
    	}
    	return false;
    }

	//printing all contacts that share an event
	public void printContactShareEvent(Event e) { //need to be tested after implementing method schedule events
		Node current = EventList.head ;
		while (current != null) {
			if (  ((Event) current.data).getTitle().equals(e.getTitle())  )
				if ( ((Event) current.data).getDate().equals(e.getDate())  )
					if ( ((Event) current.data).getTime().equals(e.getTime()) )
						if ( ((Event) current.data).getTime().equals(e.getTime()) )
							if ( ((Event) current.data).getLocation().equals(e.getLocation()) )
									System.out.println(((Event) current.data).getContact().toString());
			current=current.next;
		}
	}

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




        
        public void printEventByContactName(String contactName) {
        	Contact contactToFind = ContactList.SearchByName(contactName); //m
        	Node<Event> temp = contactToFind.scheduledEvents.head; //1
        	while (temp!=null) { //m+1
        		System.out.println(temp.data.toString());//m
        		temp=temp.next;//m
        	}
        }//4m+2 >> o(m)
        
        
        
        public void printcontactSharingE_title(String EventTitle) {
        	Node<Contact> tmpContacts = ContactList.head; //1
        	while (tmpContacts!=null) { //m+1
        		Node<Event> tmpEvents = tmpContacts.data.scheduledEvents.head; //m
        		while(tmpEvents!=null) {
        			if (tmpEvents.data.title.equalsIgnoreCase(EventTitle))
        				System.out.println(tmpContacts.data.toString());
        			tmpEvents=tmpEvents.next;
        		}
        		tmpContacts=tmpContacts.next;
        	}
        }
        
        


	
	public void API() {//CLI for the application
		int action; //0
		Scanner input = new Scanner(System.in) ; //1
		System.out.println("Welcome to theLinkedTreePhonebook!"); //1
		do{ //0
			System.out.println("\n Please choose an option:\n 1.Add a contact\n 2. Search for a contact\n 3.Delete a contact\n 4.Scheduleanevent\n 5.Printeventdetails\n 6.Printcontacts byfirstname\n 7. Print all events alphabetically\n 8.Exit"); //1
			System.out.println("Enter your choice:"); //1
			action = input.nextInt() ; //1

			switch (action){
				case 1:
					System.out.println("Enter the contact's name:"); //1
					String name = input.nextLine(); //1
					System.out.println("Enter the contact's phone number:"); //1
					String  phoneNumber = input.nextLine(); //1
					System.out.println("Enter the contact's email address:"); //1
					String emailAddress = input.nextLine(); //1
					System.out.println(" Enter the contact's address:"); //1
					String address = input.nextLine(); //1
					System.out.println("Enter the contact's birthday:"); //1
					String birthday = input.nextLine(); //1
					System.out.println("Enter any notes for the contact:"); //1
					String notes = input.nextLine(); //1
					this.ContactList.add(new Contact(name,phoneNumber,emailAddress,birthday,address,notes)); //mln
					break; //1
					// 18+mln
				case 2:
					System.out.println("Enter search criteria:\n 1.Name\n 2.Phone Number\n 3.Email Address\n 4.Address\n 5.Birthday"); //1
					System.out.println("Enter your choice:"); //1
					int criteria= input.nextInt(); //1
					switch(criteria){
						case 1:
							System.out.println("Enter the contact's name:"); //1
							System.out.println("Contact found!"+this.ContactList.SearchByName(input.nextLine()).toString()); //m
							break; //1
						case 2:
							System.out.println("Enter the contact's Phone Number:"); //1
							System.out.println("Contact found!"+this.ContactList.SearchByPhoneNumber(input.nextLine()).toString()); //mn
							break; //1
						case 3:
							System.out.println("Enter the contact's Email Address:"); //1
//							System.out.println("Contact found!"+this.ContactList.SearchByEmailAddress(input.nextLine()).toString());// mn		 method should return contact
							break;
						case 4:
							System.out.println("Enter the contact's Address:"); //1
//							System.out.println("Contact found!"+this.ContactList.SearchByAddress(input.nextLine()).toString());//mn			 method should return contact
							break;
						case 5:
							System.out.println("Enter the contact's Birthday:"); //1
//							System.out.println("Contact found!"+this.ContactList.SearchByBirthday(input.nextLine()).toString());//mn+m		 method should return contact
							break; //1
					}
					break; //1
					
					//  10+4mn+2m 
				case 3:
					System.out.println("Enter the contact's name:"); //1
					this.ContactList.Delete(this.ContactList.SearchByName(input.nextLine()));// m+(m+n)
					System.out.println("Contact has been deleted successfully :)"); //1
					break;//1
				case 4:
					this.scheduleEvent(); //m+n^2+mn
					break; //1
				case 5:
					System.out.println("Enter search criteria:\n 1.contact name\n 2.Event title"); //1
					System.out.println("Enter your choice"); //1
					int criteriaToSearch = input.nextInt(); //1
					switch(criteriaToSearch){ 
						case 1:
							System.out.println("Enter the contact name:"); //1
							String contactName = input.nextLine();
							printEventByContactName(contactName); //m
							System.out.println("Event found!"); //1
							break; //1
						case 2:
							System.out.println("Enter the event title:"); //1
							String title = input.nextLine(); //1
							printcontactSharingE_title(title);
							System.out.println("Event found!"); //1
							break; //1
					}
					break; //1
					
					//  15 + m + (m+n) + m+ n^2 +mn + m = 15+4m+n+mn+n^2
				case 6:
					System.out.println("Enter the firstname:"); //1
					String firstname = input.nextLine(); //1
					ContactList.PrintContactByFirstName(firstname); //mn+n+m
					System.out.println("Contacts found!"); //1
					break; //1
				case 7:
					printEventsAlphabetically(); //m
					break; //1
			}
			
			//5+mn+n+2m
		}while (action != 8); 
		System.exit(0); //1 
		// 18+mln + 10+4mn+2m  + 5+mn+n+2m  + 15+4m+n+mn+n^2= mln +6mn +n^2+8m+2n+48 >>o(mln +mn +n^2+m+n )
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
