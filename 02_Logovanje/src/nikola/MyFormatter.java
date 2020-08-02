package nikola;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MyFormatter extends Formatter {

	@Override
	public String format(LogRecord record) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(record.getMillis());
		SimpleDateFormat date 
			= new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		return "Vreme: " + date.format(calendar.getTime())
						 + ", Poruka: " + record.getMessage() + "\n";
		
	}

}
