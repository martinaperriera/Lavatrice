package org.gen.italy;

import java.util.Scanner;

import org.gen.italy.model.Lavaggio;
import org.gen.italy.model.Lavatrice;
import org.gen.italy.model.Operazione;
import org.gen.italy.model.Programma;

public class Main {

	public static void main(String[] args) {
		
		Lavatrice l;
		try {
			l = new Lavatrice();
			
			
		} catch (Exception e) {
			System.err.println("Impossibile creare la lavatrice: "+ e.getMessage());			
			return;	//esci dal programma
		}
		
		
		
		Scanner sc = new Scanner(System.in);
		String scelta;	
		
		
		do{
			System.out.println("\n\n\n\n\n\n\nGestione lavatrice:");
			System.out.println("1. Accendi");
			System.out.println("2. Spegni");
			System.out.println("3. Apri sportello");
			System.out.println("4. Chiudi sportello");
			System.out.println("5. Aggiungi detersivo");
			System.out.println("6. Imposta programma");
			System.out.println("7. Avvia programma");
			System.out.println("8. Termina programma");
			System.out.println("0. Esci\n");

			
			System.out.println(l.toString());	//mostra lo stato della lavatrice
		

			System.out.print("\nInserisci la tua scelta:");
			scelta = sc.nextLine();

			switch (scelta) {
			case "1":		
				l.accendi();				
				break;
			case "2":
				l.spegni();					
				break;
			case "3":
				l.apriSportello();
				break;
			case "4":
				l.chiudiSportello();
				break;
			case "5":
				l.aggiungiDetersivo();
				break;
			case "6":
				System.out.println("Elenco programmi:");
				for (int i=0; i<l.getElencoProgrammi().length;i++) {
					Programma p=l.getElencoProgrammi()[i];
					
					System.out.print(i+ " - " +p.getNome());
					// se il programma p è "di tipo Lavaggio" mostra un'informazione,
					// altrimenti se il programma p è "di tipo Operazione" mostrane un'altra					
					
					if (p instanceof Lavaggio)	//p è di tipo Lavaggio
						System.out.println(" (Lavaggio)"
							+ " - Temperatura: "+((Lavaggio)p).getTemperatura());	//casting: tratta l'oggetto p (di tipo Programma) come se fosse di tipo Lavaggio
					else	//p è di tipo Operazione
						System.out.println(" (Operazione)"
							+ " - Presenza acqua: "+((Operazione)p).isPresenzaAcqua()); //casting: tratta l'oggetto p (di tipo Programma) come se fosse di tipo Operazione
					
				}
					
				System.out.print("Inserisci il nr del programma:");
				try {
					int nrProgramma = Integer.parseInt(sc.nextLine());
					l.setProgrammaCorrente(nrProgramma);
				} catch (NumberFormatException e) {
					System.err.println("Programma non valido");
				}
				break;
			case "7":
				l.avviaProgramma();
				break;
			case "8":
				l.terminaProgramma();
				break;
			
			case "0":
				System.out.println("Arrivederci!");
				break;
			default:
				System.out.println("Scelta non valida. Riprova.");
				break;
				
			}
			System.out.println("\nPremi invio per continuare...");
			sc.nextLine();
		} while (!scelta.equals("0"));
		sc.close();
		
		

	}

}