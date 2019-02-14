import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* sll mora da e i mora so edno vrtenje i so edna lista samo da se rese. Zimas go poslednio stavas go pomegu prvio i vtorio posle predposlednio pomegu 3 i 4 ...
 * Vlez:
 * 2 4 1 0 6 5 3 9 2 
 * Izlez:
 * 2 2 4 9 1 3 0 5 6 */

public class List12_Kol_2017 {
	public static SLLNode<Integer> getLast(SLL<Integer> list){
		
		SLLNode<Integer> node = list.getFirst();
		while(node.succ != null) {
			node = node.succ;
		}
		return node;
	}

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String [] s = br.readLine().split(" ");
		SLL<Integer> list = new SLL<Integer>();

		for(int i = 0; i < n; i++) {
			list.insertLast(Integer.parseInt(s[i]));
		}
		
		SLLNode<Integer> node = list.getFirst();
		SLLNode<Integer> last = getLast(list);
		
		while(node != null) {
			last = getLast(list);
			
			list.insertAfter(last.element, node);
			list.delete(last);
			
			
			if(node.succ.succ != null)
				node = node.succ.succ;
			else
				break;
			
		}
		
		System.out.println(list.toString());
		
	}

}
