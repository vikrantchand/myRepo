package training.impetus.tp.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author vikrant.chand
 */
public class DateTimeUtil {

    private static DateFormat timeFormat;

    static {
        timeFormat = new SimpleDateFormat("HH-mm");
    }

    public static long campareTime(TPTime time1, TPTime time2) {
         long timef=0;
         long times=0;
        try {
             timef=timeFormat.parse(time1.toString()).getTime();
             times=timeFormat.parse(time2.toString()).getTime();
            
        } catch (ParseException ex) {
            Logger.getLogger(DateTimeUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        long diff=timef-times;
        if(diff==0){
            return 0;
        }
        else if(diff<0){
            return -1;
        }
        else{
            return 1;
        }
        
        
    }
    public static long campareDate(Date date1, Date date2) {
         Date datef=null;
         Date dates=null;
        try {
             datef=timeFormat.parse(date1.toString());
             dates=timeFormat.parse(date2.toString());
           
            
        } catch (ParseException ex) {
            Logger.getLogger(DateTimeUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
       return datef.compareTo(dates);
        
        
    }
}

