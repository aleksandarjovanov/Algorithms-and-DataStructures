import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/*Помошниците на Дедо Мраз направиле компјутерски систем во кој се чуваа список на сите добри деца и
 нивната желба за подарок за Нова Година, 
само што за македонските деца употребиле стара транскрипција на специфичните македонски букви, па така буквата ч ја чуваат како c, 
буквата ж како z и ш како s. Но, кога треба да проверат дали некое дете било добро, неговото име го добиваат според новата транскрипција 
каде буквата ч се преставува како ch, буквата ж како zh и ш како sh. Помогнете им на помошниците на Дедо Мраз да проверат дали детете било добро , 
и доколку било, кој подарок треба да го добие.

Влез: Во првата линија е даден број N на деца кои биле добри. Во наредните N линии се дадени името на детете и поклонот кој го сака. 
Во последниот ред е дадено името на детете кое треба да се провери.

Излез: Ако даденото дете не било добро (т.е. го нема во списокот на добри деца) да се испечати Nema poklon, а ако било добро да се испечати кој подарок го сакало.

Име на класа: DedoMrazPomoshnici

Делумно решение: Задачата се смета за делумно решена доколку се поминати 7 тест примери.

Забелешка: При реализација на задачите МОРА да се користат дадените структури, а не да користат помошни структури како низи или сл.*/
/*5
JohnDoe dog
JaneDoe cat
TomceZarkovski bike
MartaMartevska sonyplaystation
EstebanPerez brother
TomcheZharkovski

Пример излез
bike*/
public class Hash5_Dedo_mraz_pomosnici {

	public static void main(String[] args)throws IOException {                           
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String,String> tabela = new HashMap<String,String>();
		
		
		for(int i = 0; i < n; i ++) {
			String [] vlez = br.readLine().split(" ");
			String ime = vlez[0];
			String podarok = vlez[1];
			
			tabela.put(ime, podarok);
		}
		
		String dete = br.readLine();
		
		if(tabela.containsKey(dete)) {
			System.out.println(tabela.get(dete));
		}
		else {
			for(int i =0; i < dete.length(); i++) {
				if(dete.charAt(i) == 'h') {
					if(dete.charAt(i-1) == 'z' || dete.charAt(i-1) == 'Z' || dete.charAt(i-1) == 'c' || dete.charAt(i-1) == 'C' || dete.charAt(i-1) == 's' || dete.charAt(i-1) == 'S') {
						dete = dete.substring(0, i) + dete.substring(i+1, dete.length());
					}
				}
			}
			if(tabela.containsKey(dete)) {
				System.out.println(tabela.get(dete));
			}
			else {
				System.out.println("nepostoi takvo dete");
			}
		}
	

	}

}
