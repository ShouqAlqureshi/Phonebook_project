public class ContactLinkedListADT {
    Node<Contact> head;
    Node<Contact> current;

    public ContactLinkedListADT() {// O(1)
        this.head = null;
        this.current = null;
    }

    public void add(Contact contactToInsert) {//tested &done
        if (isUniqueContact(contactToInsert)) {//mln
            if (this.head == null) {//1
                insertToSortedList(new Node<Contact>(contactToInsert));// ln+m
                System.out.println(contactToInsert.toString() + "\n##has been added to the phonebook successfully ;)");//1
                return;//1
            }
            if (current.next == null) {// 1                     # current will be last element,and it's next is null (last in first out)
                insertToSortedList(new Node<Contact>(contactToInsert));//ln+m
            } else if (hasNext()) {// 1                          #current will be the new element ,and it will be in the middle of the list
                insertToSortedList(new Node<Contact>(contactToInsert));//ln+m
            }

            System.out.println(contactToInsert.toString() + "\n##has been added to the phonebook successfully ;)");//1
            return;//1
        }
        System.out.println(contactToInsert.toString() + "\n is already added to the phonebook :) ");//1
    }//8+mln+3[ln+m]= 8+mln+3ln+3m >> O(mln)

    public void Delete(Contact contactToRemove) {//remove at current which is item// done & tested
        current = findNode(contactToRemove);// n+m
        if (current == null) {//1
            return;//1
        }
        if (current == head) {//1
            head = head.next;//1
        } else {
            Node<Contact> temp = head;//1

            while (temp.next.data != current.data) {//m+1
                if (temp.next == null)//m
                    break;//1
                temp = temp.next;//m
            }

            temp.next = current.next;//1             #current.next=null
        }
        if (current.next == null)//1
            current = head;//1
        else
            current = current.next;//1
    }//11+n+m+m+m+m = 11+4m+n >> O(n+m)

    public Node<Contact> findNode(Contact dataTofind) {
        current = head;//1
        while (!current.data.getName().equals(dataTofind.getName())) {// (mn+n) *   n= char

            if (current.next == null) {//m
                System.out.println(dataTofind.toString() + "\n##does n't exist in contact list");//1
                return null;//1
            }
            current = current.next;//m
        }
        return current;//1
    }//4+n+m+m+nm= 4+2m+n+mn >> O(n+mn+m)
    public Contact SearchByName( String name ) {  //done and tested
      Node<Contact> tmp= head;//1
      while(tmp!=null) {// m+1
        if (tmp.data.getName().equals(name))//m
          return tmp.data;//1
        tmp=tmp.next;//m
        }
      return null;//1
    }//4+3m >> O(m)


    public Contact SearchByPhoneNumber( String PhoneNumber ){  //done and tested
    	Node<Contact> tmp= head;//1
    	while(tmp!=null) {//m+1
    		if (tmp.data.getPhone_Number().equals(PhoneNumber))//m(n)
    			return tmp.data;//1
    		tmp=tmp.next;//m
    	}
    	return null;//1
    }//4+2m+mn >> O(mn)

    public void SearchByEmailAddress(String EmailAddress ){// done
        if (head != null)//1
        {
           Node<Contact> tmp= head; //1
            while (tmp.next != null)//m+1-1* //-1 because last node is not reached
                {
                    if (tmp.data.getEmail_Address().equalsIgnoreCase(EmailAddress))//mn-n
                    {
                        System.out.print(tmp.retrieve().toString());//m-1
                    }
                    tmp = tmp.next;//m-1
                }
            if (tmp.data.getEmail_Address().equalsIgnoreCase(EmailAddress))//n
                    {
                        System.out.print(tmp.retrieve().toString());//1
                    }
        }
        
    }//3-2+mn-n+m+m+m+n= 1+3m+mn >> O(mn) *

    public void SearchByAddress(String Address ) {// done
         if (head != null)//1
        {
           Node<Contact> tmp= head; //1
            while (tmp.next != null)//m+1-1*
                {
                    if (tmp.data.getAddress().equalsIgnoreCase(Address))//(mn-n)
                    {
                        System.out.print(tmp.retrieve().toString());//(m-1)
                    }
                    tmp = tmp.next;//(m-1)
                }
            if (tmp.data.getAddress().equalsIgnoreCase(Address))//n
                    {
                        System.out.print(tmp.retrieve().toString());//1
                    }
        }
        
    }//1+m+mn-n+m+m+n = 1+3m+mn >> O(mn)*

    public void SearchByBirthday(String Birthday ) {// done
         if (head != null) //1
        {
           Node<Contact> tmp= head; //1
            while (tmp.next != null) //m+1-1
                {
                    if (tmp.data.getBirthday().equalsIgnoreCase(Birthday)) //(mn-n)
                    {
                        System.out.print(tmp.retrieve().toString()); //(m-1)
                    }
                    tmp = tmp.next; //(m-1)
                }
            if (tmp.data.getBirthday().equalsIgnoreCase(Birthday)) //n
                    {
                        System.out.print(tmp.retrieve().toString()); //1
                    }
        }
        
    }

    public boolean hasNext() {//1
        return current.next != null;
    }

    public void insertToSortedList(Node<Contact> unsortedElement){//last case where 2 is output
        if (head == null || head.data.compareTo(unsortedElement.data) == 1 || head.data.compareTo(unsortedElement.data) == 0) {// 2ln *              #head.data >= unsortedElement.data
            unsortedElement.next = head;// 1
            current = head;// 1
            head = unsortedElement;//1
        }
        else {
            current = head; //1
            while (current.next != null && current.next.data.compareTo(unsortedElement.data) == -1 ){// m+ln+1                #current.next.data < unsortedElement.data
                current = current.next;//m+ln **
            }//the trick is to assign after looping
            unsortedElement.next = current.next;//1
            current.next = unsortedElement;//1
            current = current.next;//1
        }
    }// 1+1+1+1+1+1+1+1+2ln+m+ln+m+ln= 8+4ln+2m >> O(ln+m) *

    public boolean isUniqueContact(Contact contact){//current position after method: current will be the last element+tested
        if (this.head==null){// 1
            return true;// 1
        }
        this.current = this.head;//1
        while (current != null) {// m+1 *

            if (contact.compareTo(this.current.data) == 0){// m(ln) *
                return false;//1
            }
            if(current.next == null) //m
                break;// 1
            current = current.next;//m
        }
        return true;// 1
    }// 1+1+1+1+1+1+m+1+m(ln)+2m = 7+ 3m + mln >> O(mln+m) m= nodes n= string characters *
    public void printAll(){
        this.current=this.head;//1
        while (current != null) {//m+1         first element is checked
            System.out.println("++++++++\n"+current.data.toString()+"\n_________\n");//m

            if(current.next==null)//m
                break;//1
            current=current.next;//m
        }
    }//3+4m >>O(m)

    public Contact retrieve () {
        return current.data;
    }//O(1)

    public static void printContact_name( ContactLinkedListADT li, String name) {//printing all contacts that share the first name
        Node<Contact> current = li.head;//1
        String ContactName , firstName;//0
        while(current != null) {//m+1
            ContactName = ((Contact) current.data).getName();//m
            String[] fullName = ContactName.split(" ");//m(n)
            firstName = fullName[0];//m

            if(firstName.equals(name)) {//(m)n
                System.out.println("Contacts found!");//m
                System.out.println( current.data.toString());//m
            }
            current=current.next;//m
        }
    }//2+6m+2mn >>O(mn+m)*
    public void PrintContactByFirstName(String firstname){//O(mn+n+m)*
        printContact_name(this,firstname);
    }//well be implemented soon
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
        cll.PrintContactByFirstName("Ahmad");
        // uniqueness checks each letter it will accept b11 with b1

    }

    }//class
