import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Дадена е двојно поврзана листа со N јазли каде секој јазел содржи по еден карактер (буква). 
 * Да се провери дали двојно поврзаната листа е палиндром: односно ако ја изминете од почеток до крај 
 * и од крај до почеток, дали ќе добиете ист збор. Во првиот ред од влезот даден е бројот на јазли во
 * листата N, а во вториот ред се дадени броевите. На излез треба да се испечати 1 ако листата е палиндром,
 * -1 ако не е.*/
/*vlez:  
 * 5 
 * 1 2 3 1 2
 * izlez: -1 */
public class List8_Palindrom {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String [] s = br.readLine().split(" ");
		DLL<Character> list = new DLL<Character>();

		for(int i = 0; i < n; i++) {
			list.insertLast(s[i].charAt(0));
		}
		
		DLLNode<Character> node = list.getFirst();
		DLLNode<Character> pr_node = list.getLast();
		boolean flag = true;
	
		while(node != null) {
			
			if(!node.element.equals(pr_node.element)){
				
				flag = false;
				break;
			}
			node = node.succ;
			pr_node = pr_node.pred;
		}
		
		System.out.println(flag);
	}

}
