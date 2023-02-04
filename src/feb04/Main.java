//https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
package feb04;

import java.time.LocalDate;
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

	}

}

/*
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
