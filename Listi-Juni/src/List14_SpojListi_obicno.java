/*
Дадени се две еднострано поврзани листи чии јазли содржат по еден природен број.
Листите се сортирани во растечки редослед. Треба да се спојат двете листи во
една така што резултантната листа да е сортирана. Сортирањето е подредување со
слевање. Јазлите кои се јавуваат како дупликати (од иста листа или од различна)
да се отстранат.
Во првиот ред од влезот е даден бројот на јазли во првата листа,
потоа во вториот ред се дадени броевите од кои се составени јазлите по редослед
во првата листа, па во третиот ред е даден бројот на јазли во втората листа,
и на крај во четвртиот ред броевите од кои се составени јазлите по редослед во
втората листа. На излез треба да се испечатат јазлите по редослед во
резултантната споена листа.
Име на класата (Java): SLLJoinLists
Забелешка: Да се креира податочна структура еднострано поврзана листа и истата
да се искористи во задачата.
 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.soap.Node;

public class List14_SpojListi_obicno {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String [] s = br.readLine().split(" ");
		SLL<Integer> list = new SLL<Integer>();
		SLL<Integer> result_list = new SLL<Integer>();

		for(int i = 0; i < n; i++) {
			list.insertLast(Integer.parseInt(s[i]));
		}
		SLLNode<Integer> node = list.getFirst();
		int m = Integer.parseInt(br.readLine());
		String [] k = br.readLine().split(" ");
		SLL<Integer> secound = new SLL<Integer>();

		for(int i = 0; i < m; i++) {
			secound.insertLast(Integer.parseInt(k[i]));
		}
		SLLNode<Integer> sec_node = secound.getFirst();
		
		while(node != null) {
			result_list.insertLast(node.element);
			node = node.succ;
		}
		while(sec_node != null) {
			result_list.insertLast(sec_node.element);
			sec_node = sec_node.succ;
		}
		
		SLLNode<Integer> rez_node1 = result_list.getFirst();
		SLLNode<Integer> rez_node2 = result_list.getFirst();
		int tmp = 0;
		while(rez_node1.succ != null) {
			
			rez_node2 = rez_node1.succ;
			while(rez_node2 != null) {
				if(rez_node1.element == rez_node2.element) {
					result_list.delete(rez_node2);
				}
				
				if(rez_node1.element > rez_node2.element){
					tmp = rez_node1.element;
					rez_node1.element = rez_node2.element;
					rez_node2.element = tmp;
				}
				rez_node2 = rez_node2.succ;
			}
			rez_node1 = rez_node1.succ;
		}
		
		
		System.out.println(list.toString());
		System.out.println(secound.toString());
		System.out.println(result_list.toString());
		
	}

}
