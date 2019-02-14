import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Dadena e linearno povrzana lista. Da se napise funkcija koja vo listata kje go pronajde posledniot jazol so informacija*/
/* x i kje go prefrli na celo na listata. Kako rezultat funkcijata da ja vrakja pozicijata(broeno od pocetokot na listata)*/
/* na koja bil pronajden baraniot jazol ili -1 ako takov jazol ne bil pronajden vo listata.
 * Pr:  3->4->7->6->4->7->3->2;    x=7 
 *      7->3->4->7->6->4->3->2;    pozicija 6;*/
public class Lista4_Posleden_jazol_pa_prv {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String [] s = br.readLine().split(" ");
		
		SLL<Integer> list = new SLL<Integer>();
		for(int i =0; i < n; i++) {
			list.insertLast(Integer.parseInt(s[i]));
		}
		
		int x = Integer.parseInt(br.readLine());
		SLLNode<Integer> node =  list.getFirst();
		SLLNode<Integer> tmp_node =  list.getFirst();
		int position = 0;
		int count = 0;
		
		while(node != null) {
			count++;
			if(node.element == x) {
				tmp_node = node;
				position = count;
			}
			node = node.succ;
		}
		
		list.insertFirst(tmp_node.element);            // prv insertiram ELEMENT
		list.delete(tmp_node);							// posle brisam JAZOL
		System.out.println(list.toString() +" "+ position);
		
	}

}
