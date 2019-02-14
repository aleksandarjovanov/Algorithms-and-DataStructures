import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Дадени се две еднострано поврзани листи чии што јазли содржат по еден природен број. 
 * Треба да се спојат двете листи во една резултантна на тој начин што наизменично прво ќе се додаваат
 * првите два јазли од првата листа во резултантната, па првите два од втората листа, па следните два
 * од првата, па следните два од втората итн. Јазлите што ќе останат треба да се додадат на крај во 
 * резултантната листа, прво оние што останале од првата листа, потоа оние што останале од втората листа.
 * Во првиот ред од влезот се дадени броевите од кои се составени јазлите по редослед во првата листа, 
 * а во вториот ред броевите од кои се составени јазлите по редослед во втората листа. На излез треба да
 * се испечатат јазлите по редослед во резултантната споена листа.
 * Забелешка: Да се креира податочна структура еднострано поврзана листа и истата да се искористи во задачата.*/
public class List5_Spoj_Listi_Naizmenicno {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n1 = Integer.parseInt(br.readLine()); ////////////////////////// punam ja prvata
		String [] s1 = br.readLine().split(" ");
		
		SLL<Integer> list1 = new SLL<Integer>();
		for(int i =0; i < n1; i++) {
			list1.insertLast(Integer.parseInt(s1[i]));
		}
		
		int n2 = Integer.parseInt(br.readLine()); //////////////////////////// punam ja vtorata
		String [] s2 = br.readLine().split(" ");
		
		SLL<Integer> list2 = new SLL<Integer>();
		for(int i =0; i < n2; i++) {
			list2.insertLast(Integer.parseInt(s2[i]));
		}
		SLL<Integer> result_list = new SLL<Integer>();
		boolean flag1 = false;
		boolean flag2 = false;
		
		
		SLLNode<Integer> node1 = list1.getFirst();   // jazol od prvata
		SLLNode<Integer> node2 = list2.getFirst();	// jazol od vtorata
		while(node1.succ != null  &&  node2.succ != null) {
			result_list.insertLast(node1.element);
			result_list.insertLast(node1.succ.element);
			
			result_list.insertLast(node2.element);
			result_list.insertLast(node2.succ.element);
			
			if(node1.succ.succ == null) {
				flag1 = true;
				break;
			}
			else {
				node1 = node1.succ.succ;
			}
			if(node2.succ.succ == null) {
				flag2 = true;
				break;
			}
			else {
				node2 = node2.succ.succ;
			}
		}
		if(flag1) {
			node1 = null;
		}
		while(node1 != null) {
			result_list.insertLast(node1.element);
			node1 = node1.succ;
			}
		
		
		if(flag2) {
			node2 = null;
		}
		while(node2 != null) {
			result_list.insertLast(node2.element);
			node2 = node2.succ;
			}
		
		
		System.out.println(result_list.toString());

	}

}
