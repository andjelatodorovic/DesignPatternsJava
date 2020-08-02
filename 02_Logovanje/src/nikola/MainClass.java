package nikola;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainClass {

	private static final Logger logger 
		= Logger.getLogger(MainClass.class.getName());
	
	public static void main(String[] args) throws SecurityException, IOException {
		
		logger.setUseParentHandlers(false); // iskljuciti default ispis u konzoli
		logger.setFilter(new MyFilter()); // MyFilter propusa samo poruke koje nisu nivoa INFO
		
		Handler handler1 = new ConsoleHandler();
		handler1.setFormatter(new MyFormatter());
		Handler handler2 = new FileHandler("fajl.txt");
		handler2.setFormatter(new MyFormatter());
		handler2.setFilter(new MyBeginEndFilter());
		Handler handler3 = new FileHandler("fajl.html");
		handler3.setFormatter(new MyTableFormatter());
		
		// handler1 ispisuje u konzoli u formatu "Vreme: dd-MM-yyyy hh:mm:ss, Poruka: ..."
		// handler2 ispisuje u fajl.txt u gore-pomenutom formatu; njegov filter propusta samo
		// 	   poruke u kojima postoji tacno jedna rec BEGIN, tacno jedna rec END i to u tom redosledu
		// handler3 ispisuje u fajl.html u tabelarnom formatu
		
		logger.addHandler(handler1);
		logger.addHandler(handler2);
		logger.addHandler(handler3);
		
		// ispisujemo sve handlere zakacene za logger
		for (Handler handler : logger.getHandlers()) {
			System.out.println(handler.toString());
		}
		
		logger.log(Level.INFO, "zdravo"); // isto kao i logger.info("zdravo");
		logger.log(Level.WARNING, "upozorenje");
		logger.log(Level.SEVERE, "ozbiljan problem");
		logger.log(Level.WARNING, "ASDF  X BEGIN A BC END SDF");
		logger.log(Level.WARNING, "ASDF END X BEGIN A BC SDF");
	}
	
}
