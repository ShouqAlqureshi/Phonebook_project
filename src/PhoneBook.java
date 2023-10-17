import java.util.Scanner;

public class PhoneBook {
	
	ContactLinkedListADT ContactList = new ContactLinkedListADT();

	EventLinkedList EventList = new EventLinkedList();
	
	Scanner input = new Scanner(System.in);
	
	public void scheduleEvent() {
		String eventDate, eventTime;
        Contact eventContact ;
        System.out.print("Enter event title");
        String eventTitle = input.nextLine();
        System.out.print("Enter contact name");
        String contactName = input.nextLine();
		eventContact = ContactList.SearchByName(contactName);
        if( eventContact != null ){
            System.out.print("Enter event date and time MM/DD/YYYY HH:MM");
            String eventTime_Date = input.nextLine();
			input.nextLine();
            String[] Time_Date = eventTime_Date.split(" ");
			eventDate= Time_Date[0];
			eventTime= Time_Date[1];
            if( checkConflict(eventContact ,eventTime,eventDate) ){
                System.out.println("Date and time are not available");
                return;
            }
            System.out.print("Enter event location");
            String eventLocation= input.nextLine();
            Event EventToBeSchedule = new Event(eventTitle ,eventDate ,eventTime , eventLocation , eventContact ) ;
            EventList.insertToSortedList (EventToBeSchedule );
            eventContact.scheduledEvents.insertToSortedList(EventToBeSchedule);
            System.out.println("\nEvent scheduled successfully!");
        }
        else {
        System.out.println("Contact doesn't exist");
            return;
		}
	}
   
    public boolean checkConflict(Contact c , String time , String Date){
    	Node<Event> tmp = c.scheduledEvents.head;
    	while(tmp != null) {
    		if(tmp.data.getDate().equals(Date) && tmp.data.getTime().equals(time))
    			return true;
			tmp = tmp.next;
    	}
    	return false;
    }

    public void deleteEvents(EventLinkedList contactEventList) {
    	Node<Event> nodeContactEvents = contactEventList.head;
    	Node<Event> nodeAllEvents;
    	while (nodeContactEvents != null) {
			nodeAllEvents = EventList.head;
    		while ( nodeAllEvents != null) {
    			if ( nodeContactEvents.data.title.equals(nodeAllEvents.data.title) && nodeContactEvents.data.time.equals(nodeAllEvents.data.time) && nodeContactEvents.data.date.equals(nodeAllEvents.data.date) && nodeContactEvents.data.location.equals(nodeAllEvents.data.location) ) {
    				if (nodeAllEvents == EventList.head) {
    					EventList.head = EventList.head.next;
    					break;
    				}
    				else {
    					Node<Event> tmp = EventList.head;
    					while (tmp.next != nodeAllEvents)
    						tmp = tmp.next;
    					tmp.next = nodeAllEvents.next;
    				}
    				if (nodeAllEvents != null) {
        				if (nodeAllEvents.next == null)
        					nodeAllEvents = EventList.head;
        				else
        					nodeAllEvents = nodeAllEvents.next;
    				}
    				else
    					break;
    			}
    			nodeAllEvents = nodeAllEvents.next;
    			}
    		nodeContactEvents = nodeContactEvents.next;
		}
	}

	public void printContactShareEvent(Event e) {
		Node<Event> current = EventList.head ;
		while (current != null) {
			if (  current.data.getTitle().equals(e.getTitle())  )
				if (  current.data.getDate().equals(e.getDate())  )
					if (  current.data.getTime().equals(e.getTime()) )
						if (  current.data.getLocation().equals(e.getLocation()) )
								System.out.println( current.data.getContact().toString());
			current=current.next;
		}
	}

	public void printContactShareName( String name) {
		Node<Contact> current = ContactList.head;
		String ContactName , firstName;
		while(current != null) {
			ContactName = ((Contact) current.data).getName();
			String[] fullName = ContactName.split(" ");
			firstName = fullName[0];

			if(firstName.equals(name)) {
				System.out.println("Contacts found!");
				System.out.println( current.data.toString());
			}
			current = current.next;
		}
	}

	public void printEventsAlphabetically() {
		Node current = EventList.head;
		while (current != null) {
			System.out.println(current.data.toString());
			current = current.next;
		}
	}

    public void printEventByContactName(String contactName) {
        Contact contactToFind = ContactList.SearchByName(contactName);
        Node<Event> temp = contactToFind.scheduledEvents.head;
        while (temp != null) {
        	System.out.println(temp.data.toString());
			temp=temp.next;
        }
    }
        
    public void printEventSharingE_title(String EventTitle) {
       	Node<Event> tmpEvents = this.EventList.head;
        while(tmpEvents != null) {
        	if (tmpEvents.data.title.equalsIgnoreCase(EventTitle))
        		System.out.println(tmpEvents.data.toString());
        	tmpEvents=tmpEvents.next;
       }

	}

	public void API() {
		int action;
		Scanner input = new Scanner(System.in) ;
		System.out.println("Welcome to theLinkedTreePhonebook!");
		do{
			System.out.println("\n Please choose an option:\n 1.Add a contact\n 2. Search for a contact\n 3.Delete a contact\n 4.Scheduleanevent\n 5.Printeventdetails\n 6.Printcontacts byfirstname\n 7. Print all events alphabetically\n 8.Exit");
			System.out.println("Enter your choice:");
			action = Integer.parseInt(input.nextLine());
			switch (action){
				case 1:
					System.out.println("Enter the contact's name:");
					String name = input.nextLine();
					System.out.println("Enter the contact's phone number:");
					String  phoneNumber = input.nextLine();
					System.out.println("*******");
					System.out.println("Enter the contact's email address:");
					String emailAddress = input.nextLine();
					System.out.println("*******");
					System.out.println(" Enter the contact's address:");
					String address = input.nextLine();
					System.out.println("*******");
					System.out.println("Enter the contact's birthday:");
					String birthday = input.nextLine();
					System.out.println("*******");
					System.out.println("Enter any notes for the contact:");
					String notes = input.nextLine();
					System.out.println("*******");
					this.ContactList.add(new Contact(name,phoneNumber,emailAddress,birthday,address,notes));
					break;
				case 2:
					System.out.println("Enter search criteria:\n 1.Name\n 2.Phone Number\n 3.Email Address\n 4.Address\n 5.Birthday");
					System.out.println("Enter your choice:");
					int criteria= Integer.parseInt(input.nextLine());
					switch(criteria){
						case 1:
							System.out.println("Enter the contact's name:");
							this.ContactList.SearchByName(input.nextLine());
							break;
						case 2:
							System.out.println("Enter the contact's Phone Number:");
							this.ContactList.SearchByPhoneNumber(input.nextLine());
							break;
						case 3:
							System.out.println("Enter the contact's Email Address:");
							this.ContactList.SearchByEmailAddress(input.nextLine());
							break;
						case 4:
							System.out.println("Enter the contact's Address:");
							this.ContactList.SearchByAddress(input.nextLine());
							break;
						case 5:
							System.out.println("Enter the contact's Birthday:");
							this.ContactList.SearchByBirthday(input.nextLine());
							break;
					}
					break;
				case 3:
					System.out.println("Enter the contact's name:");
					Contact contactToDelete = this.ContactList.SearchByName(input.nextLine());
					this.deleteEvents(contactToDelete.scheduledEvents);
					this.ContactList.Delete(contactToDelete);
					System.out.println("Contact has been deleted successfully :)");
					break;
				case 4:
					this.scheduleEvent();
					break;
				case 5:
					System.out.println("Enter search criteria:\n 1.contact name\n 2.Event title");
					System.out.println("Enter your choice");
					int criteriaToSearch = Integer.parseInt(input.nextLine());
					switch(criteriaToSearch){ 
						case 1:
							System.out.println("Enter the contact name:");
							String contactName = input.nextLine();
							printEventByContactName(contactName);
							System.out.println("Event found!");
							break;
						case 2:
							System.out.println("Enter the event title:");
							String title = input.nextLine();
							printEventSharingE_title(title);
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
					printEventsAlphabetically();
					break;
			}
		}while (action != 8); 
		System.exit(0);
	}

}//class