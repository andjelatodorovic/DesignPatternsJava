package nikola;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class MyBeginEndFilter implements Filter {

	// prihvatati samo one poruke koje sadrze tacno jednu rec
	// BEGIN, tacno jednu rec END (ostalo nebitno) i da je 
	// BEGIN pre END
	// ok: sdfsd BEGIN sdf  END, sdfsd sdf BEGIN END sdf
	// nije ok: BEGINEND, sdf END BEGIN,  sdfsdf BEGIN BEGIN END
	
	@Override
	public boolean isLoggable(LogRecord record) {
		String s = record.getMessage();
		String[] words = s.trim().split("\\s+");
		
		int b = -1, e = -1;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals("BEGIN")) {
				if (b != -1) 
					return false;
				b = i;
			}
			if (words[i].equals("END")) {
				if (e != -1) 
					return false;
				e = i;
			}
		}
		if (b == -1 || e == -1 || e < b)
			return false;
		
		return true;
	}

}
