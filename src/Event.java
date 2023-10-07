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
   
    public Event(String title, String date, String time, String location, String contact) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
//        this.contact = contact ;
       
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
   
   


}
