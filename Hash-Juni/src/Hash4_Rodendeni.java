import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/*Во заводот на статистика се прави ново истражување каде што се открива зависноста на месецот на раѓање 
 *со имињата на луѓето родени во тој месец. Ваша задача е за даден месец да ги прикажете сите различни имиња 
 *на луѓе родени во тој месец.

Влез: Во првиот ред од влезот е даден бројот на луѓе N (N<=10 000), а во секој нареден ред се дадени името
 	  на човекот и датумот на неговото раѓање разделени со празно место. Во последниот ред е даден месецот
 	  за кој треба да се прикажат сите различни имиња на луѓето родени во тој месец.

Излез: Листа со различни имиња на луѓе родени во дадениот месец. Доколку нема луѓе родени во тој месец да 
	   се испечати Nema.

Делумно решение: Задачата се смета за делумно решена доколку се поминати 3 тест примери.

Забелешка: При реализација на задачите не е дозволено да се користат помошни структури како низи или сл.
 		   На располагање од структурите имате само една хеш структура.
Пример:
4 
Ivan 20.7.1976 
Ivan 16.7.1988
Ana 18.7.1966
Ivan 5.6.1988
7
Ivan Ana*/
public class Hash4_Rodendeni {

	public static void main(String[] args) throws IOException {                           
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String,ArrayList<String>> tabela = new HashMap<String,ArrayList<String>>();
		
		
		for(int i = 0; i < n; i ++) {
			String [] vlez = br.readLine().split(" ");
			String ime = vlez[0]; /////////<<<<<<<<<<<<<<<----------------------------------------------------------
			
			String datum = vlez[1];
			String [] pom = datum.split("\\.");
			
			String mesec = pom[1];/////////<<<<<<<<<<<<<<<----------------------------------------------------------
			
			if(tabela.containsKey(mesec)) {
				ArrayList<String> lista = tabela.get(mesec);
				
				if(!lista.contains(ime)) {            // OVAJ IF E ZA POTREBITE NA ZADACATA AKO GO IMA IMETO DA NE GO STAVA OSTE 1 INACE NE TREBA
				lista.add(ime);
				tabela.put(mesec, lista);
				}
			}
			else {
				ArrayList<String> lista = new ArrayList<String>();
				lista.add(ime);
				tabela.put(mesec, lista);
			}
		}
		
		String broj = br.readLine();          
		if(tabela.containsKey(broj)) {                  // NEJKE GLUPACATA PROSTA SO TOSTRING DA SE PECATE ZATOA JA VR
			
			ArrayList<String> list = tabela.get(broj);
			for(int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i)+" ");
			}
		}
		else {
			System.out.println("Nema");
		}


	}

}
