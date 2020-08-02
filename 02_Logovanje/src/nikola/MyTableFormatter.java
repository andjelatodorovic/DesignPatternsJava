package nikola;

import java.sql.Time;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MyTableFormatter extends Formatter {
	
	@Override
	public String getHead(Handler h) {
		return "<table border='1'>\n";
	}

	@Override
	public String getTail(Handler h) {
		return "</table>\n";
	}

	@Override
	public String format(LogRecord record) {
		Time time = new Time(record.getMillis());
		return "<tr>"
				+ "<td>" + record.getLevel() + "</td>"
				+ "<td>" + time.toString() + "</td>"
				+ "<td>" + record.getMessage() + "</td>"
				+ "</tr>\n";
	}

}
