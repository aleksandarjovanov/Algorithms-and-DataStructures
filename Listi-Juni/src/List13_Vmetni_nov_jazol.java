import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Дадена е линеарно поврзана листа. Да се напише функција која пред секој елемент кој
во info полето има вредност x ќе вметне нов јазел со информација y. Како резултат
функцијата да врати колку нови јазли биле вметнати.
Пр. →3→4→7→6→4→7→3→2; 3; 1
→1→3→4→7→6→4→7→1→3→2; вметнати 2 нови јазли*/

public class List13_Vmetni_nov_jazol {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String [] s = br.readLine().split(" ");
		SLL<Integer> list = new SLL<Integer>();

		for(int i = 0; i < n; i++) {
			list.insertLast(Integer.parseInt(s[i]));
		}
		
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		
		SLLNode<Integer> node = list.getFirst();
		int count = 0;
		
		while(node != null) {
			if(node.element == x) {
				list.insertBefore(y, node);
				count++;
			}
			node = node.succ;
		}
		
		System.out.println(list.toString());
		System.out.println(count);
	}

}
