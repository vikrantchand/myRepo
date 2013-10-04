package training.impetus.tp.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
		public static Date getFormattedDate(String date) {
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			Date formattedDate=null;
			try {
				formattedDate = (Date) format.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return formattedDate;
			
		}
}
