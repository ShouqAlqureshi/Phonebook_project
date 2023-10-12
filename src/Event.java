public class Event  {
    
    String title;
    String date;
    String time;
    String location;
    Contact contact ;
 

    public Event() {
        this.title = ""; //1
        this.date = null; //1
        this.time = ""; //1
        this.location = ""; //1
//        this.contact = new Contact();  1
        //5 >o(1)
    }
   
    public Event(String title, String date, String time, String location, Contact contact) {
        this.title = title; //1
        this.date = date; //1
        this.time = time; //1
        this.location = location; //1
        this.contact = contact ; //1
       // 5 > o(1)
    }

    public void setTitle(String title) {
        this.title = title; //1
        // o(1)
    }

    public void setDate(String date) {
        this.date = date; //1
        // o(1)
    }

    public void setTime(String time) {
        this.time = time; //1
        //o(1)
    }

    public void setLocation(String location) {
        this.location = location; //1
        // o(1)
    }

//    public void setContact(String contact) {
//        this.contact = contact;  
//    }

    public String getTitle() {
        return title; //1
        //o(1)
    }

    public String getDate() {
        return date; //1
        // o(1)
    }

    public String getTime() {
        return time; //1
        // o(1)
    }

    public String getLocation() {
        return location; //1
        // o(1)
    }

    public String getContact() {
        return contact.toString(); //1
        // o(1)
    }

        public int compareings(Event event) {//tested & done
    if (this.title.toUpperCase().charAt(0) > event.title.toUpperCase().charAt(0))//1
    return 1;//1
    else if (this.title.toUpperCase().charAt(0) == event.title.toUpperCase().charAt(0)){//1
        int limit;//0
        if(!this.title.equalsIgnoreCase(event.title)) {//n
            limit = Math.min(this.title.length(), event.title.length());//n
            for (int i = 1; i < limit; i++) {//l-1+1
               if (this.title.toUpperCase().charAt(i) > event.title.toUpperCase().charAt(i)) {//l-1(2)
                  return 1;//1                                   the only case I want to swap and change  so i will ignore -1
               } else if (this.title.toUpperCase().charAt(i) < event.title.toUpperCase().charAt(i)) {//l-1
                  return -1;//1
               }
            }
            if ( this.title.length() != event.title.length())//1+1
                return 2;//1
        } return 0;//1
    }else
        return-1;//1
}//10-2+2n+3l =8+2n+3l>> O (n+l)

    @Override
    public String toString() {
        return "Event{" + "title=" + title + ", date=" + date + ", time=" + time + ", location=" + location; /* + ", contact=" + contact + */ '}';
    }
/*
    public int compareTo(Event event) {//tested & done
        if (this.title.toUpperCase().charAt(0) > event.title.toUpperCase().charAt(0))//2n+2
        return 1;//1
        else if (this.title.toUpperCase().charAt(0) == event.title.toUpperCase().charAt(0)){//2n+2
            int limit;//0
            if(!this.title.equalsIgnoreCase(event.title)) {//n
                limit = Math.min(this.title.length(), event.title.length());//n
                for (int i = 1; i < limit; i++) {//n
                   if (this.title.toUpperCase().charAt(i) > event.title.toUpperCase().charAt(i)) {//n-1(2n+2)
                      return 1;//1                                   the only case I want to swap and change  so i will ignore -1
                   } else if (this.title.toUpperCase().charAt(i) < event.title.toUpperCase().charAt(i)) {//n-1(2n+2)
                      return -1;//1
                   }
                }
                if ( this.title.length() != event.title.length())//2
                    return 2;//1
            } return 0;//1
        }else
            return-1;//1
    }//10-2+2n+3l =8+2n+3l>> O (n+l)
    //2n+2+1+2n+2+3n+2[(n-1)(2n+2)]+7= 4n^2+7n+10 >>O(n^2)
    */
   
   


}
