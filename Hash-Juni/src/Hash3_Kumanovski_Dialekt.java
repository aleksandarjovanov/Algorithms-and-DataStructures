import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*Даден ви е речник на зборови на кумановски дијалект и како тие се пишуваат на македонски јазик. 
 * Потоа даден ви е текст којшто е напишан на кумановски дијалект. Потребно е да ги замените сите појавувања на 
 * зборовите на кумановскиот дијалект кои се дадени во речникот со соодветни зборови на македонски јазик.

Забелешка: Треба да се игнорираат интерпункциските знаци точка (.) , запирка (,), извичник(!) и прашалник (?). 
Исто така зборовите во текстот можат да се појават и со прва голема буква и во тој случај неговиот синоним на 
македонски јазик исто така треба да се отпечати со прва голема буква.

Име на класата (Java): KumanovskiDijalekt.*/
public class Hash3_Kumanovski_Dialekt {

	public static void main(String[] args)throws IOException {                           // ISTATA ZADACA JA IMA I SO          PROVERKA NA SPELUVANJE
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String,String> tabela = new HashMap<String,String>(2*n);
		
		for(int i = 0; i < n; i ++) {
			String [] prevod = br.readLine().split(" ");
			String ku = prevod[0];
			String mk = prevod[1];
			tabela.put(ku, mk);
		}
		//System.out.println(tabela.toString());
		
		String [] tekst = br.readLine().split(" ");
		
		for(int i = 0; i < tekst.length; i ++) {
			String zbor = tekst[i];
			
			if(Character.isUpperCase(zbor.charAt(0)) && !Character.isLetter(zbor.charAt(zbor.length()-1))) {
				
				char znak = zbor.charAt(zbor.length()-1);
				zbor = zbor.toLowerCase().substring(0,zbor.length()-1);
				String prevod = tabela.get(zbor);
				
				if(prevod != null) {
					prevod = Character.toUpperCase(prevod.charAt(0)) + prevod.substring(1) + znak;
					tekst[i] = prevod;
				}
				continue;
			}
			if(Character.isUpperCase(zbor.charAt(0)) && Character.isLetter(zbor.charAt(zbor.length()-1))) {
				
				zbor = zbor.toLowerCase();
				String prevod = tabela.get(zbor);
				if(prevod != null) {
				prevod = Character.toUpperCase(prevod.charAt(0)) + prevod.substring(1);
				tekst[i] = prevod;
				}
				continue;
			}
			if(Character.isLowerCase(zbor.charAt(0)) && !Character.isLetter(zbor.charAt(zbor.length()-1))) {
				
				char znak = zbor.charAt(zbor.length()-1);
				zbor = zbor.toLowerCase().substring(0,zbor.length()-1);
				String prevod = tabela.get(zbor);
				if(prevod != null) {
					prevod =  prevod + znak;
					tekst[i] = prevod;
				}
				continue;
				
			}
			if(Character.isLowerCase(zbor.charAt(0)) && Character.isLetter(zbor.charAt(zbor.length()-1))) {
				
				String prevod = tabela.get(zbor);
				if(prevod != null) {
				tekst[i] = prevod;
				}
				continue;
			}
			
		}
		
		for(String t : tekst) {
			System.out.print(t+" ");
		}
	}

}
