public class ContactLinkedListADT{
    Node<Contact> head;
    Node<Contact> current;
    public ContactLinkedListADT() {
        this.head = null;
        this.current = null;
    }

    public void add(Contact contactToInsert){//tested &done
        if(isUniqueContact(contactToInsert)) {
            if(this.head == null) {
                insertToSortedList(new Node<Contact>(contactToInsert) );
                System.out.println(contactToInsert.toString()+"\n##has been added to the phonebook successfully ;)");
                return;
            } if (current.next==null){// current will be last element,and it's next is null (last in first out)
                insertToSortedList(new Node<Contact>(contactToInsert) );
            } else if (hasNext()) {//current will be the new element ,and it will be in the middle of the list
                insertToSortedList(new Node<Contact>(contactToInsert) );
            }

            System.out.println(contactToInsert.toString()+"\n##has been added to the phonebook successfully ;)");
            return;
        }
        System.out.println(contactToInsert.toString()+"\n is already added to the phonebook :) ");
    }

    public void remove (Node<Contact> contactToRemove) {//remove at current which is item//not done yet
        current = contactToRemove;
        if (current == head) {
            head = head.next;
        }
        else {
            Node<Contact> temp = head;

            while (temp.next != current)
                temp = temp.next;

            temp.next = current.next;
        }
        if (current.next == null)
            current = head;
        else
            current = current.next;
    }

    public Contact SearchByName( String name ) {  //done and tested
    	Node<Contact> tmp= head;
    	while(tmp!=null) {
    		if (tmp.data.getName().equals(name))
    			return tmp.data;
    		tmp=tmp.next;
    	}
    	return null;
    }

    public Contact SearchByPhoneNumber( String PhoneNumber ){  //done and tested
    	Node<Contact> tmp= head;
    	while(tmp!=null) {
    		if (tmp.data.getPhone_Number().equals(PhoneNumber))
    			return tmp.data;
    		tmp=tmp.next;
    	}
    	return null;
    }

    public void SearchByEmailAddress(String EmailAddress ){//not done yet
    }

    public void SearchByAddress(String Address ) {//not done yet
    }

    public Contact getElement(){
        return current.data;
    }

    public boolean hasNext() {
        return current.next != null;
    }

   /* public void sort(ContactLinkedListADT list) {//not done yet  didn't work
        Contact temp;
        if ( list.head.next == null){
            System.out.println("**only one element in list**");//for testing
            return;
        }else{
            this.current=this.head;
            while(list.hasNext()){//for
                if (list.current.data.compareTo(list.current.next.data) == 1){//shifting current > next
                    temp=list.current.data;
                    list.current.data= list.current.next.data;
                    list.current.next.data=temp;
                }

                list.current = list.current.next;
            }

        }
    }

    public void sort(ContactLinkedListADT list) {//not done yet didn't work
        ContactLinkedListADT sortedList= new ContactLinkedListADT();
        sortedList.current= sortedList.head;
        Node<Contact> temp;
        list.current=list.head;
        while(list.current != null){//for
            temp = list.current.next;
            insertToSortedList(list.current,sortedList);
            list.current = temp;
        }
        this.head=sortedList.head;
        this.current=sortedList.current;

    }
    public void insertToSortedList(Node<Contact> unsortedElement,ContactLinkedListADT sortedList ){
        Node<Contact> temp;
        if (sortedList.current == null || sortedList.current.data.compareTo(unsortedElement.data) == 1 || sortedList.current.data.compareTo(unsortedElement.data) == 0)//sortedList.current.data >= unsortedElement.data
        {
            if (sortedList.head == null) {
                unsortedElement.next = sortedList.current;// bigger will be added before current of sorted list (changing the link)
                sortedList.head = unsortedElement;
                sortedList.current = sortedList.head;
            } else if (sortedList.head != null)  {//assigning prob in pre
                temp= sortedList.head;
                while(temp.next != sortedList.current){
                    if (temp.next == null)
                        break;
                    temp=temp.next;
                }
                unsortedElement.next = sortedList.current;// bigger will be added before current of sorted list (changing the link)
                sortedList.current = unsortedElement;//(adding to the sortedlist)
                temp.next=unsortedElement;
            }
        } else {
            Node<Contact> tempCurrent = sortedList.current;//عشان ما احوس اللست القديمه
            while (tempCurrent.next != null && tempCurrent.next.data.compareTo(unsortedElement.data) == -1 )// current.next.data < unsortedElement.data
            {
                tempCurrent = tempCurrent.next;
            }
            unsortedElement.next = tempCurrent.next;//=null
            sortedList.current.next = unsortedElement;//add as last element
            sortedList.current=unsortedElement;//move current to last element
        }
        this.head=sortedList.head;
        this.current=sortedList.current;
    }
*/

    public void insertToSortedList(Node<Contact> unsortedElement){//last case where 2 is output
        if (head == null || head.data.compareTo(unsortedElement.data) == 1 || head.data.compareTo(unsortedElement.data) == 0) {//head.data >= unsortedElement.data
            unsortedElement.next = head;
            current = head;
            head = unsortedElement;
        }
        else {
            current = head;
            while (current.next != null && current.next.data.compareTo(unsortedElement.data) == -1 ){//current.next.data < unsortedElement.data
                current = current.next;//to check sorting
            }//trick to assign after looping
            unsortedElement.next = current.next;
            current.next = unsortedElement;
            current = current.next;
        }
    }



    public boolean isUniqueContact(Contact contact){//current position after method: current will be the last element+tested
        if (this.head==null){
            return true;
        }
        this.current=this.head;
        while (current != null) {//first element is checked

            if (contact.compareTo(this.current.data)==0){
                return false;
            }
            if(current.next==null)
                break;
            current=current.next;
        }
        return true;
    }
    public void printAll(){
        this.current=this.head;
        while (current != null) {//first element is checked
            System.out.println("++++++++\n"+current.data.toString()+"\n_________\n");

            if(current.next==null)
                break;
            current=current.next;
        }
    }

    public static void main(String[] args) {//testing area
        Contact c1 = new Contact("Ahmad AlSaud", "05937636532", "jnjnjnj", "nnk222", "299","299");
        Contact c2 = new Contact("Ahmad Alzaid", "7968867456", "njnjnj", "mmkmkm", "klll","299");
        Contact c3 = new Contact("Ahmad", "7968867456", "njnjnj", "mmkmkm", "klll","299");
        Contact c4 = new Contact("b2", "7968867456", "njnjnj", "mmkmkm", "klll","299");
        Contact c5 = new Contact("b6", "7968867456", "njnjnj", "mmkmkm", "klll","299");
        Contact c6 = new Contact("b4", "7968867456", "njnjnj", "mmkmkm", "klll","299");
        Contact c7 = new Contact("b3", "7968867456", "njnjnj", "mmkmkm", "klll","299");

        ContactLinkedListADT cll=new ContactLinkedListADT();
        cll.add(c1);
        cll.add(c2);
        cll.add(c3);
        cll.add(c4);
        cll.add(c5);
        cll.add(c6);
        cll.add(c7);
        cll.printAll();
        // uniqueness checks each letter it will accept b11 with b1

    }

    }//class
