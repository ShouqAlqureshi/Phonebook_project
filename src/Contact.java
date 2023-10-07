import java.util.LinkedList;

public class Contact implements Comparable<Contact> {
    private String Name,Phone_Number,Email_Address,Birthday,Address;
    String note;
    Contact[] events=new Contact[10];//for events to add composition relation prob is that it's fixed + type of array

    public Contact(String name, String phone_Number, String email_Address, String birthday,String address, String note) {
        setName( name);
        setPhone_Number(phone_Number);
        setEmail_Address(email_Address);
        setBirthday(birthday);
        setAddress(address);
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
    public int compareTo(Contact contact) {//tested & done
        if (this.Name.toUpperCase().charAt(0) > contact.getName().toUpperCase().charAt(0))
        return 1;
        else if (this.Name.toUpperCase().charAt(0) == contact.getName().toUpperCase().charAt(0)){
            int limit;
            if(!this.Name.equalsIgnoreCase(contact.getName())) {
                limit = Math.min(this.Name.length(), contact.getName().length());
                for (int i = 1; i < limit; i++) {
                   if (this.Name.toUpperCase().charAt(i) > contact.getName().toUpperCase().charAt(i)) {
                      return 1;//the only case I want to swap and change  so i will ignore -1
                   } else if (this.Name.toUpperCase().charAt(i) < contact.getName().toUpperCase().charAt(i)) {
                      return -1;
                   }
                }
                if ( this.Name.length() != contact.getName().length())
                    return 2;
            } return 0;
        }else
            return-1;//ascii is arranged alphabetically starting with small num الترتيب تصاعدي
    }

    public String toString(){
        return getClass().getName()+"name: "+getName()+"\tPhone Number:"+getPhone_Number()+"\tAddress: "+getAddress()+"\nEmail_Address: "+getEmail_Address()+"\tBirthday: "+ getBirthday()+"\n note: "+note+"";
    }

    public static void main(String[] args) {//testing area
        Contact c1=new Contact("bb", "05937636532","jnjnjnj","nnk222","299","njnj");
        Contact c2=new Contact("bb", "7968867456","njnjnj","mmkmkm","klll","njnj");
       int i= c1.compareTo(c2);
        System.out.println(i);
        LinkedList list=new LinkedList();
        list.add(c1);
    }
}//class
