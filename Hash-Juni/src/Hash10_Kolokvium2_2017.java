import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/*2
root/a/ xy.txt (abv)
root/a/b/ cx.txt (xyz)
3
add root/a/c/ xy2.txt (abv)
delete root/a/ xy.txt (abv)
find root/a/ xy.txt (abv)
abv

Aj vaka ke probam da ja objasnam nekako. Prvata brojka kazuva kolku datoteki ima i koja im 
e patekata root/a/b e patekata kaj sto se naoga fajlot cx.txt a (xyz) ako dobro pamtam bese sodrzinata vo 
cx.txt. Sodrzinata vo primerov xyz treba da bide klucot.
Vtorata brojka (3) go oznacuva brojot na komandi.
Na raspolaganje bea add, delete i find. Add dodava fajl vo posocenata pateka, delete go brise fajlot vo
posocenata datoteka (dokolku postoi istiot), find vraka true ili false vo zavisnsot od toa dali pod odredeniot
kluc ima fajl so dadenoto ime vo posocenata pateka.
Na kraj abv treba da ispecati sto se cuva klucot (vo slucajov abv), vo slucajov ke ispecati
 root/a/c/ xy2.txt bidejki xy.txt koj go zadavam vo vtorata linija podocna se brise so delete opcijata. 
 Dokolku go imavme istiot primer samo bez delete abv ke ni vratese root/a/ xy.txt root/a/c/ xy2.txt*/

public class Hash10_Kolokvium2_2017 {
	public static void main (String [] args)throws IOException {                           
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String,ArrayList<String>> tabela = new HashMap<String,ArrayList<String>>();
		
		
		for(int i = 0; i < n; i ++) {
			String [] vlez = br.readLine().split(" ");
			String pateka = vlez[0];
			String ime = vlez[1];
			String pateka_ime = vlez[0]+" "+vlez[1];
			
			String sodrzina = vlez[2];
			sodrzina = sodrzina.substring(1, sodrzina.length()-1);
			
			if(tabela.containsKey(sodrzina)) {
				tabela.get(sodrzina).add(pateka_ime);
			}
			else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(pateka_ime);
				tabela.put(sodrzina, list);
				
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i ++) {
			String [] vlez = br.readLine().split(" ");
			String komanda = vlez[0];
			String pateka = vlez[1];
			String ime = vlez[2];
			String pateka_ime = vlez[1]+" "+vlez[2];
			
			String sodrzina = vlez[3];
			sodrzina = sodrzina.substring(1, sodrzina.length()-1);
			
			if(komanda.equals("add")) {
				if(tabela.containsKey(sodrzina)) {
					tabela.get(sodrzina).add(pateka_ime);
				}
				else {
					ArrayList<String> list = new ArrayList<String>();
					list.add(pateka_ime);
					tabela.put(sodrzina, list);
				}
			}
			
			if(komanda.equals("delete")) {
				if(tabela.containsKey(sodrzina)) {
					ArrayList<String> list = tabela.get(sodrzina);
					for(int j = 0; j < list.size(); j++) {
						if(list.get(j).equals(pateka_ime)) {
							list.remove(j);
						}
					}
				}
			}
			
			if(komanda.equals("find")) {
				if(tabela.containsKey(sodrzina)) {
					boolean flag = false;
					ArrayList<String> list = tabela.get(sodrzina);
					for(int j = 0; j < list.size(); j++) {
						if(list.get(j).equals(pateka_ime)) {
							flag = true;
							break;
						}
					}
						System.out.println(flag);	
				}
				System.out.println("nema kluc false");	
			}
			
		}
		
		String sodrzina = br.readLine();
		
		if(tabela.containsKey(sodrzina)) {
			System.out.println(tabela.get(sodrzina).toString());
		}
		
	}
}
