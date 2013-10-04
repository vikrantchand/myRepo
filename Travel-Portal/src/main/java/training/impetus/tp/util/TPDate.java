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
 * Date utility class for Travel-Portal's specific date format
 *
 * @author vikrant.chand
 *
 */
@Component
public class TPDate implements Serializable{

    private static final long serialVersionUID = 7523967970034938905L;
    private String fastDate;
    

  
    static DateFormat dateFormat;
  

    static {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
    }

    public TPDate() {
        this(System.currentTimeMillis());
    }

    public TPDate(Long date) {
        fastDate = dateFormat.format(date);

    }

    public TPDate(TPDate date) {
        fastDate = dateFormat.format(date);

    }

    public TPDate(String dateAsString) {
        /*Date date = null;
        try {
            date = (Date) dateFormat.parse(dateAsString);
        } catch (ParseException ex) {
            Logger.getLogger(TPDate.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        fastDate = dateFormat.format(dateAsString);
    
    }


    public String getDate() {
        return fastDate;
    }

   

    public void setDate(String date) {
        this.fastDate = date;
    }

    @Override
    public String toString() {
        return fastDate;
    }
}

