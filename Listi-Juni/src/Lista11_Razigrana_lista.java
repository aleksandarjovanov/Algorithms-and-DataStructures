import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Dvostrano povrzana lista od karakteri. Pocnuva od napred i se brise 2,4,6... jazol
 * Potoa pocnuva od nazad pa se brise pretposledniot, pret-pretposledniot itn. Se dodeka ne ostane
 * 1 jazol vo listata. Pomosni listi ne se dozvoleni.
 * Primer: a b c d e f g
 * posle prvo brisenje: a c e g
 * posle vtoro brisenje: c g
 * finalno brisenje(od napred): c
 * da se ispecati: f
 * 
There is a double linked list containing characters (each node contains one character).
You should do the following until there is only one node left in the list: starting from
the beginning of the list each second node should be deleted (ie. 2nd, 4th, 6th, etc),
then starting from the end of the list each second node should be deleted (ie. the one
before the last, 2 nodes before that, etc). You should repeat this (deleting from the
beginning, then from the end) in each iteration, until there is only one node in the list
left.
Input: One line of input containing the elements of the list (characters separated by a
blank space).
Output: You should print the value of the remaining node.*/
public class Lista11_Razigrana_lista {

	public static void main(String[] args)throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		char [] c = s.toCharArray();
		
		DLL<Character> list = new DLL<Character>();
		
		
		for(int i = 0; i < n; i ++) {
			list.insertLast(c[i]);
		}
		
		DLLNode<Character> node = list.getFirst();
		
		while(list.length() != 1) {
			
			node = list.getFirst();
			
			while(node != null) {
				if(node.succ != null) {
					list.delete(node.succ);
				}
				node = node.succ;
			}
			
			node = list.getLast();
			
			while(node != null) {
				if(node.pred != null) {
					list.delete(node.pred);
				}
				node = node.pred;
			}
			
		}
		
		System.out.println(list.toString());
	}

}
