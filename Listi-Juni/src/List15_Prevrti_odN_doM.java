import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Dadena e ednostrana povrzana lista i pozicii m i n. Prevrt+	i ja listata od pozicija m do pozicija n.
 * Vo prviot red e br na jazli na vleznata lista.
 * vo vtortiot red se dadeni cifrite od koi se sostaveni jazlite so prazno mesto
 * vo tretiot red se dadeni broevite m i n so prazno mesto
 * Ne se dozvoleni pomosni strukturi i ne e dozvoleno menuvanje na vrednostite na jazlite
 * na raspolaganje ima samo EDNA ednostrana povrzana lista
 * pr:
 * 10 20 30 40 50 60 70 
 * 3 6 
 * izlez:
 * 10 20 60 50 40 30 70*/
public class List15_Prevrti_odN_doM {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String [] s = br.readLine().split(" ");
		SLL<Integer> list = new SLL<Integer>();

		for(int i = 0; i < n; i++) {
			list.insertLast(Integer.parseInt(s[i]));
		}
		int f_position = Integer.parseInt(br.readLine());
		int s_position = Integer.parseInt(br.readLine());
		
		SLLNode<Integer> node = list.getFirst();
		SLLNode<Integer> first = list.getFirst();
		SLLNode<Integer> secound = list.getFirst();
		int count = 0;
		while(node != null) {
			count++;
			if(count == f_position) {
				first = node;
			}
			if(count == s_position) {
				secound = node;
			}
			
			node = node.succ;
		}
		
		while(first != secound) {
			list.insertAfter(first.element, secound);
			list.delete(first);
			first = first.succ;
		}
		
		System.out.println(list.toString());
		
	}

}
