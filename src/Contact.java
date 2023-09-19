public class Contact implements Comparable<Contact>{
    private String Name,Phone_Number,Email_Address,Birthday,Address;
    String note;

    public Contact(String name, String phone_Number, String email_Address, String birthday, String note) {
        setName( name);
        setPhone_Number(phone_Number);
        setEmail_Address(email_Address);
        setBirthday(birthday);
        this.note = note;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }

    public void setEmail_Address(String email_Address) {
        Email_Address = email_Address;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAddress() {
        return Address;
    }

    public String getName() {
        return Name;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public String getEmail_Address() {
        return Email_Address;
    }

    public String getBirthday() {
        return Birthday;
    }

    @Override
    public int compareTo(Contact o) {
        if (this.Name.charAt(0) > o.getName().charAt(0))
        return 1;
        else if (this.Name.charAt(0) == o.getName().charAt(0)){
            int limit;
            if(!this.Name.equalsIgnoreCase(o.getName())) {
                limit = Math.min(this.Name.length(), o.getName().length());
                for (int i = 1; i < limit; i++) {
                    if (this.Name.charAt(i) > o.getName().charAt(i));
                        return 1;//the only case i want to swap and change  so i will ignore -1
                }
            } return 0;
        }else
            return-1;//ascii is arranged alphabetically starting with small num الترتيب تصاعدي
    }

    public void sort(ContactLinkedListADT list) {//not done yet
        Contact temp;
        if (list.head.next == null){
            System.out.println("only one element in list ");
            return;
        }else{
           list.head=list.current;
           while(list.hasNext()){
             Contact pre = list.current.data;
             Contact cur = list.current.next.data;
             if (pre.compareTo(cur) == 1){//shifting
                temp=pre;
                pre=cur;
                cur=temp;
             }
             list.current = list.current.next;
           }

       }
    }
}//class
