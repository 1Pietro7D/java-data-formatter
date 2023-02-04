package feb04;
//https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/LocalDate.html
import java.time.LocalDate;
//https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/Month.html
import java.time.Month;
//https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate now = LocalDate.now(); // yyyy-MM-dd

// Da LocalDate a Stringa formattata
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("d MMMM yyyy");
		DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("EEE, dd MMMM yyyy"); 
		// "E" or "EE" or "EEE" ritorna sempre il giorno abbreviato
		DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("EEEE, dd MMMM yy");//"sabato, 01 gennaio 23"
		// "EEEE" ritorna il giorno completo
		DateTimeFormatter formatter6 = DateTimeFormatter.ofPattern("EEEEE, dd MMMM y"); //"s, 01 gennaio 2023
		// "EEEEE" ritorna solo l'iniziale ED è il MASSIMO di E
		// "y" = "yyy" = "yyyy" ovvero anno completo AL CONTRO "yy" = due cifre

		System.out.println(now.format(formatter1));
		System.out.println(now.format(formatter2));
		System.out.println(now.format(formatter3));
		System.out.println(now.format(formatter4));
		System.out.println(now.format(formatter5));
		System.out.println(now.format(formatter6));

		System.out.println("---");

// Da Stringa formattata a LocalDate 
		DateTimeFormatter reFormatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//ERR	// LocalDate localDate = LocalDate.parse(now.format(formatter4), reFormatter1); //SE IL FORMATTATORE NON è CORRETTO DA ERRORE
		LocalDate localDate1 = LocalDate.parse(now.format(formatter1), reFormatter1);
		System.out.println(localDate1); // yyyy-MM-dd

		DateTimeFormatter reFormatter2 = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDate localDate2 = LocalDate.parse(now.format(formatter2), reFormatter2);
		System.out.println(localDate2); // yyyy-MM-dd

		DateTimeFormatter reFormatter3 = DateTimeFormatter.ofPattern("EEEE, dd MMMM yy");
		LocalDate localDate3 = LocalDate.parse(now.format(formatter5), reFormatter3);
		System.out.println(localDate3); // yyyy-MM-dd
		
		System.out.println("---"); 

		LocalDate date1 = LocalDate.of(2023, 1, 1); // dd=07 OK, dd=08 NO (fuori range O.o)
		System.out.println(date1); // yyyy-MM-dd
		LocalDate date2 = LocalDate.of(2023, Month.DECEMBER, 1); // overloading di LocalDate.of(), evita problemi di parsing 
		System.out.println(date2); 
		System.out.println(date2.isAfter(date1)); //return Boolean
		
		int comparisonResult = date1.compareTo(date2); // 11 mesi di differenza = -11
		//return int se Negativo, il valore comparato è maggiore, e ritorna la differenza di anni, o se non c'è dei mesi, o dei giorni.. ecc...
		
		if (comparisonResult < 0) {
		    System.out.println("date1 is before date2");
		    System.out.println(comparisonResult);
		} else if (comparisonResult == 0) {
		    System.out.println("date1 is the same as date2");
		    System.out.println(comparisonResult);
		} else {
		    System.out.println("date1 is after date2");
		    System.out.println(comparisonResult);
		}

	}

}

/*		FORMATTER
 * 
 * 		Symbol		Meaning						Presentation	Examples
		G			era							text			AD; Anno Domini; A
		u			year						year			2004; 04
		y			year-of-era					year			2004; 04
		D			day-of-year					number			189
		M/L			month-of-year				number/text		7; 07; Jul; July; J
		d			day-of-month				number			10
		g			modified-julian-day			number			2451334
		Q/q			quarter-of-year				number/text		3; 03; Q3; 3rd quarter
		Y			week-based-year				year			1996; 96
		w			week-of-week-based-year		number			27
		W			week-of-month				number			4
		E			day-of-week					text			Tue; Tuesday; T
		e/c			localized day-of-week		number/text		2; 02; Tue; Tuesday; T
		F			day-of-week-in-month		number			3
		a			am-pm-of-day				text			PM
		B			period-of-day				text			in the morning
		h			clock-hour-of-am-pm (1-12)	number			12
		K			hour-of-am-pm (0-11)		number			0
		k			clock-hour-of-day (1-24)	number			24	
		H			hour-of-day (0-23)			number			0
		m			minute-of-hour				number			30
		s			second-of-minute			number			55
		S			fraction-of-second			fraction		978
		A			milli-of-day				number			1234
		n			nano-of-second				number			987654321
		N			nano-of-day					number			1234000000
		V			time-zone ID				zone-id			America/Los_Angeles; Z; -08:30
		v			generic time-zone name		zone-name		Pacific Time; PT
		z			time-zone name				zone-name		Pacific Standard Time; PST
		O			localized zone-offset		offset-O		GMT+8; GMT+08:00; UTC-08:00
		X			zone-offset 'Z' for zero	offset-X		Z; -08; -0830; -08:30; -083015; -08:30:15
		x			zone-offset					offset-x		+0000; -08; -0830; -08:30; -083015; -08:30:15
		Z			zone-offset					offset-Z		+0000; -0800; -08:00
		p			pad next					pad modifier	1
		'			escape for text	delimiter	
		''			single quote	literal	'
		[			optional section start		
		]			optional section end		
		#			reserved for future use		
		{			reserved for future use		
		}			reserved for future use	
*/


/* LocalDate() 23 principal Methods
 * 
 1 getYear(): restituisce l'anno della data.
 2 getMonth(): restituisce il mese della data come un oggetto Month.
 3 getMonthValue(): restituisce il mese della data come un intero (1 per gennaio, 2 per febbraio, e così via).
 4 getDayOfMonth(): restituisce il giorno del mese della data.
 5 plusDays(long daysToAdd): restituisce una nuova data che è daysToAdd giorni successivi alla data corrente.
 6 plusMonths(long monthsToAdd): restituisce una nuova data che è monthsToAdd mesi successivi alla data corrente.
 7 plusYears(long yearsToAdd): restituisce una nuova data che è yearsToAdd anni successivi alla data corrente.
 8 minusDays(long daysToSubtract): restituisce una nuova data che è daysToSubtract giorni precedenti alla data corrente.
 9 minusMonths(long monthsToSubtract): restituisce una nuova data che è monthsToSubtract mesi precedenti alla data corrente.
 10 minusYears(long yearsToSubtract): restituisce una nuova data che è yearsToSubtract anni precedenti alla data corrente.
 11 withDayOfMonth(int dayOfMonth): restituisce una nuova data con il giorno del mese specificato.
 12 withMonth(int month): restituisce una nuova data con il mese specificato come un intero (1 per gennaio, 2 per febbraio, e così via).
 13 withYear(int year): restituisce una nuova data con l'anno specificato.
 14 isBefore(LocalDate other): restituisce true se la data corrente è prima della data specificata in other, false altrimenti.
 15 isAfter(LocalDate other): restituisce true se la data corrente è dopo la data specificata in other, false altrimenti.
 16 isEqual(LocalDate other): restituisce true se la data corrente è uguale alla data specificata in other, false altrimenti.
 17 now(): questo metodo restituisce la data corrente.
 18 of(int year, Month month, int dayOfMonth): questo metodo restituisce un'istanza di LocalDate con l'anno, il mese e il giorno specificati.
 19 of(int year, int month, int dayOfMonth): questo metodo restituisce un'istanza di LocalDate con l'anno, il mese (espresso come numero intero) e il giorno specificati.
 20 parse(CharSequence text, DateTimeFormatter formatter): questo metodo restituisce un'istanza di LocalDate basata sul testo e sul formato specificati.
 21 getDayOfWeek(): questo metodo restituisce il giorno della settimana
 22 isLeapYear(): verifica se l'anno del LocalDate è bisestile
 23 lengthOfMonth(): restituisce il numero di giorni del mese del LocalDate
 * 
 * */
