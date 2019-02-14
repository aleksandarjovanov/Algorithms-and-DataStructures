import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Дадена е еднострано поврзана листа чии што јазли содржат по еден природен број.
 *  Листата треба да се подели на две резултантни листи, т.ш. во првата листа треба
 *   да се сместат сите јазли кои содржат броеви помали или еднакви на просекот на листата 
 *   (просек на листа претставува математички просек од сите природни броеви кои се јавуваат
 *    во листата), а во втората сите јазли кои содржат броеви поголеми од просекот на листата.
 *     Јазлите во резултантните листи се додаваат според редоследот по кој се појавуваат во
 *      дадената листа.
/*Во првиот ред од влезот е даден бројот на јазли во листата, а во вториот ред се дадени броевите
 *  од кои се составени јазлите по редослед во листата. Во првиот ред од излезот треба да се 
 *  испечатат јазлите по редослед од првата резултантна листа (броеви помали или еднакви на
 *   просекот на листата), во вториот ред од втората (броеви поголеми од просекот на листата) .
 */
/*Име на класа (за Java): PodeliSporedProsek
/*Делумно решение: Задачата се смета за делумно решена доколку се поминати 7 тест примери.
/*Забелешка: При реализација на задачите МОРА да се користат дадените структури, а не да користат 
 *помошни структури како низи или сл.*/
public class List3_Podeli_Po_Prosek {

	public static float avrg(SLL<Integer> list) {
		
		SLLNode<Integer> node = list.getFirst();
		float sum = 0;
		while(node != null) {
			sum += node.element;
			node = node.succ;
		}
		return sum/list.length();
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String [] s = br.readLine().split(" ");
		SLL<Integer> list = new SLL<Integer>();
		SLL<Integer> result_list = new SLL<Integer>();

		
		for(int i = 0; i < n; i++) {
			list.insertLast(Integer.parseInt(s[i]));
		}
		System.out.println(avrg(list));
		float mid = avrg(list);
		SLLNode<Integer> node = list.getFirst();
		while(node != null) {
			if(node.element >= mid){
				result_list.insertLast(node.element);
				list.delete(node);
			}
			node = node.succ;
		}
		
		System.out.println(list.toString());
		System.out.println(result_list.toString());

	}

}
