package training.impetus.tp.util;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;



/**
 *
 * @author vikrant.chand
 */
@Component
public class TPTime implements Serializable{
    private static final long serialVersionUID = 7523967970034938905L;
    private String fastTime;
    public String getFastTime() {
        return fastTime;
    }
      static DateFormat timeFormat;
    static {
        timeFormat = new SimpleDateFormat("HH-mm");
    }
    
     public TPTime() {
        this(System.currentTimeMillis());
    }

    public TPTime(Long date) {
     
        fastTime = timeFormat.format(date);
    }

    public TPTime(Date date) {
      
        fastTime = timeFormat.format(date);
    }

    public TPTime(String timeAsString) {
       Date time = null;
        try {
            if(timeAsString.length()>5){
         throw new ParseException("Unparseable time: \"" + timeAsString,5);      
         }
            time = (Date) timeFormat.parse(timeAsString);
        } catch (ParseException ex) {
            Logger.getLogger(Date.class.getName()).log(Level.SEVERE, null, ex);
        }
        fastTime = timeFormat.format(time);
    }

  
     public void setTime(String time) {
        /*Date date = null;
        try {
            date = (Date) timeFormat.parse(time);
        } catch (ParseException ex) {
            Logger.getLogger(Date.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        fastTime = timeFormat.format(time);


    }
       @Override
    public String toString() {
        return  fastTime;
    }
       
     
    
    
}
