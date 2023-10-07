import java.util.*;

public class Event /*implements Comparable<Event> */ {
    
    String title;
    String date;
    String time;
    String location;
    Contact contact ;
 

    public Event() {
        this.title = "";
        this.date = null;
        this.time = "";
        this.location = "";
//        this.contact = new Contact();
    }
   
    public Event(String title, String date, String time, String location, Contact contact) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.contact = contact ;
       
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

//    public void setContact(String contact) {
//        this.contact = contact;
//    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getContact() {
        return contact.toString();
    }

    @Override
    public String toString() {
//        return "Event{" + "title=" + title + ", date=" + date + ", time=" + time + ", location=" + location; /* + ", contact=" + contact + */ '}';
    return"";
    }

        public int compareTo(Event event) {//tested & done
        if (this.title.toUpperCase().charAt(0) > event.title.toUpperCase().charAt(0))
        return 1;
        else if (this.title.toUpperCase().charAt(0) == event.title.toUpperCase().charAt(0)){
            int limit;
            if(!this.title.equalsIgnoreCase(event.title)) {
                limit = Math.min(this.title.length(), event.title.length());
                for (int i = 1; i < limit; i++) {
                   if (this.title.toUpperCase().charAt(i) > event.title.toUpperCase().charAt(i)) {
                      return 1;//the only case I want to swap and change  so i will ignore -1
                   } else if (this.title.toUpperCase().charAt(i) < event.title.toUpperCase().charAt(i)) {
                      return -1;
                   }
                }
                if ( this.title.length() != event.title.length())
                    return 2;
            } return 0;
        }else
            return-1;
    }
   
   


}
