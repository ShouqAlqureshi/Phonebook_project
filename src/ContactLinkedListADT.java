public class ContactLinkedListADT {

    Node<Contact> head;

    Node<Contact> current;

    public ContactLinkedListADT() {// O(1)
        this.head = null;
        this.current = null;
    }

    public void add(Contact contactToInsert) {//tested &done
        if (isUniqueContact(contactToInsert)) {
            if (this.head == null) {
                insertToSortedList(new Node<Contact>(contactToInsert));
                System.out.println(contactToInsert.toString() + "\n##has been added to the phonebook successfully ;)");
                return;
            }
            if (current.next == null) {// current will be last element,and it's next is null (last in first out)
                insertToSortedList(new Node<Contact>(contactToInsert));
            } else if (hasNext()) {//current will be the new element ,and it will be in the middle of the list
                insertToSortedList(new Node<Contact>(contactToInsert));
            }

            System.out.println(contactToInsert.toString() + "\n##has been added to the phonebook successfully ;)");
            return;
        }
        System.out.println(contactToInsert.toString() + "\n is already added to the phonebook :) ");
    }

    public void Delete(Contact contactToRemove) {//remove at current which is item
        current = findNode(contactToRemove);
        if (current == null) {
            return;
        }
        if (current == head) {
            head = head.next;
        } else {
            Node<Contact> temp = head;

            while (temp.next.data != current.data) {
                if (temp.next == null)
                    break;
                temp = temp.next;
            }

            temp.next = current.next;//current.next=null
        }
        if (current.next == null)
            current = head;
        else
            current = current.next;
    }

    public Node<Contact> findNode(Contact dataToFind) {
        current = head;
        while (!current.data.getName().equals(dataToFind.getName())) {

            if (current.next == null) {
                System.out.println(dataToFind.toString() + "\n##does n't exist in contact list");
                return null;
            }
            current = current.next;
        }
        return current;
    }

    public Contact SearchByName( String name ) {  //done and tested
      Node<Contact> tmp = head;
      while(tmp != null) {
        if (tmp.data.getName().equals(name)){
            System.out.println("Contact found!\t" + tmp.data.toString());
          return tmp.data;
        }
        tmp=tmp.next;
        }
        System.out.println("could n't found contact ");
        return null;
    }

    public Contact SearchByPhoneNumber( String PhoneNumber ){
    	Node<Contact> tmp = head;
    	while(tmp != null) {
    		if (tmp.data.getPhone_Number().equals(PhoneNumber)){
                System.out.println("Contact found!\t" + tmp.data.toString());
            return tmp.data;
            }
    		tmp=tmp.next;
    	}
        System.out.println("could n't found contact ");
    	return null;
    }

    public void SearchByEmailAddress(String EmailAddress ){// done
        if (head != null){
           current = head;
            while (current.next != null)
                {
                    if (current.data.getEmail_Address().equalsIgnoreCase(EmailAddress))
                    {
                        System.out.println("Contact found!\t" + current.retrieve().toString());
                    }
                    current = current.next;
                }
            if (current.data.getEmail_Address().equalsIgnoreCase(EmailAddress))
                    {
                        System.out.print(current.retrieve().toString());
                    }
        }else{
        System.out.println("could n't found contact ");
        }
    }

    public void SearchByAddress(String Address ) {// done
         if (head != null)
        {
           current = head;
            while (current.next != null)
                {
                    if (current.data.getAddress().equalsIgnoreCase(Address))
                    {
                        System.out.print("Contact found!\t" + current.retrieve().toString());
                    }
                    current = current.next;
                }
            if (current.data.getAddress().equalsIgnoreCase(Address))
                    {
                        System.out.print(current.retrieve().toString());
                    }
        }else{
             System.out.println("could n't found contact ");
         }
    }

    public void SearchByBirthday(String Birthday ) {// done
         if (head != null)
        {
           current = head;
            while (current.next != null) //
                {
                    if (current.data.getBirthday().equalsIgnoreCase(Birthday))
                    {
                        System.out.print("Contact found!\t" + current.retrieve().toString());
                    }
                    current = current.next;
                }
            if (current.data.getBirthday().equalsIgnoreCase(Birthday))
                    {
                        System.out.print(current.retrieve().toString());
                    }
        }else{
             System.out.println("could n't found contact ");
         }
    }

    public boolean hasNext() {
        return current.next != null;
    }

    public void insertToSortedList(Node<Contact> unsortedElement){
        if (head == null || head.data.compareTo(unsortedElement.data) == 1 || head.data.compareTo(unsortedElement.data) == 0) {//head.data >= unsortedElement.data
            unsortedElement.next = head;
            current = head;
            head = unsortedElement;
        }
        else {
            current = head;
            while (current.next != null && current.next.data.compareTo(unsortedElement.data) == -1 ){//current.next.data < unsortedElement.data
                current = current.next;
            }//the trick is to assign after looping
            unsortedElement.next = current.next;
            current.next = unsortedElement;
            current = current.next;
        }
    }

    public boolean isUniqueContact(Contact contact){//current position after method: current will be the last element
        if (this.head==null){
            return true;
        }
        this.current = this.head;
        while (current != null) {

            if (contact.compareTo(this.current.data) == 0){
                return false;
            }
            if(current.next == null)
                break;
            current = current.next;
        }
        return true;
    }

    public void PrintContactByFirstName(  String name) {//printing all contacts that share the first name
        Node<Contact> current = this.head;
        String ContactName , firstName;
        while(current != null) {
            ContactName = ((Contact) current.data).getName();
            String[] fullName = ContactName.split(" ");
            firstName = fullName[0];

            if(firstName.equals(name)) {//(m)n
                System.out.println("Contacts found!");
                System.out.println( current.data.toString());
            }
            current = current.next;
        }
    }


}//class
