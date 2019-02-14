import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Податоците за плати на вработените во една компанија привремено се чуваат во еднострано поврзана листа. 
 * Во секој јазол од листата се чува единствен ID на вработениот и неговата плата. Потребно е да се отстранат
 * сите вработени со помали плати од даден износ, а остатокот да се прикажат во опаѓачки редослед во однос на 
 * ID-то. Во првиот ред од влезот е даден бројот на вработени, потоа наизменично се дадени ID и плата за 
 * секој од вработените и во последниот ред е износот во однос на кој ќе се отстрануваат вработените.
 * На излез се печати листа (ID, плата) во опаѓачки редослед според ID на секој од вработените.
 * Доколку нема вработени со плата поголема од дадената да се испечати: nema
 * VLEZ:
3
1111
19000
2222
22000
1155
60000
30000
  * IZLEZ:
1155 60000*/
class Vraboteni{
	public int plata;
	public int ID;
	
	public Vraboteni(int id, int p) {
		plata = p;
		ID = id;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getPlata() {
		return plata;
	}
}
public class List16_Kompanija {
	
	public static void pecati(SLL<Vraboteni> list) {
		SLLNode<Vraboteni> node = list.getFirst();
		
		while(node != null) {
			System.out.println(node.element.ID+" "+node.element.plata);

			node = node.succ;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		SLL<Vraboteni> list = new SLL<Vraboteni>();
		
		for(int i = 0; i < n; i ++) {
			int id = Integer.parseInt(br.readLine());
			int plata = Integer.parseInt(br.readLine());
			
			Vraboteni ob = new Vraboteni(id,plata);
			list.insertLast(ob);
		}
		int iznos = Integer.parseInt(br.readLine());
		
		SLLNode<Vraboteni> node = list.getFirst();
		while(node != null) {
			
			if(node.element.plata < iznos) {
				list.delete(node);
			}
			node = node.succ;
		}
		
		SLLNode<Vraboteni> node1 = list.getFirst();   ///SORTIRANJE
		SLLNode<Vraboteni> node2 = list.getFirst();
		Vraboteni tmp = null;
		
		if(list.length() == 0) {
			System.out.println("nema");
		}
		else {
		while(node1.succ != null) {
			node2 = node1.succ;
			while(node2 != null) {
				if(node2.element.ID > node1.element.ID) {
					tmp = node2.element;
					node2.element = node1.element;
					node1.element = tmp;
				}
				node2 = node2.succ;
			}
			node1 = node1.succ;
		}
		pecati(list);
		}
	}

}
