
public class PhoneBook {
	
	ContactLinkedListADT list;
	Contact CLL;
	EventLinkedList ELL;
	
	public void scheduleEvent() { //not done yet
		
	}

	public void PrintEventDetails (){//not done yet event need to be implemented first

	}

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
	}

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

}
