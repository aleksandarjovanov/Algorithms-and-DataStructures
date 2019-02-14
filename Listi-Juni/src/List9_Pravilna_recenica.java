import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Ddena e ednostrano povrzana lista cii sto jazli sodrzat po eden karakter
 *a site jazli zaedno formiraat recenica. Pri pisuvanjeto na recenicata
 *nastanala greska pri sto prvata bukva od sekoj zbor e stavena na kraj na zborot.
 *Vasa zadaca e da ja napisete recenicata pravilno, odnosno da ja 
 *postavite poslednata bukva od sekoj zbor na pocetok na zborot.
 *Zborovite se oddeleni so jazli cija vrednost e mrazno mesto.
 *Recenicata sekogas zavrsuva so "."
 *Vlez: na vlez e dadena pogresna recenica
 *Izlez: na izlez treba da se ispecatat jazlite na rezultantnata lista(transformiranata recenica)
 *Zabeleska: Dozvolena e samo EDNA ednostrano povrzana lista.
 *pr: "remetoV e oncevos."   na izlez:  "Vremeto e soncevo"*/
public class List9_Pravilna_recenica {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		char [] bukvi = s.toCharArray();
		SLL<Character> list = new SLL<Character>();   

		for(int i = 0; i < bukvi.length; i++) {
			list.insertLast(bukvi[i]);    
		}
		//System.out.println(list.toString());
		
		SLLNode<Character> node = list.getFirst();
		SLLNode<Character> prva;
		char posledna = 'a';
		while(!node.element.equals('.')) {
			
			prva = node;
			System.out.println(prva.element);
			while(true){
				
				if(node.succ.element.equals(' ') || node.succ.element.equals('.')){
					
					if(node.succ.element.equals('.')) {              // ovaa tuka e za poslednio pat koga fleva u if
						posledna = node.element;
						list.insertBefore(posledna, prva);			// razlikata od dole e toa so dole* ima node = node.succ 
						list.delete(node);                      
						break;
					}
					
					posledna = node.element;					
					list.insertBefore(posledna, prva);				//KOGA BRISAM TEKOVEN NODE POKAZUVACO SI OSTANUVA NA NEGO NE SE MRDA NI NAPRED NI NAZAD
					list.delete(node);
					
					node = node.succ;								// *
					break;
					
				}
				node = node.succ;
			}
			
			node = node.succ;
		}
		
		System.out.println(list.toString());
	}

}
