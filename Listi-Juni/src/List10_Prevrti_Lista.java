import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Преврти ја листата Problem 1 (0 / 0)`
Дадена е двострано поврзана листа чии што јазли содржат по еден природен број. 
Листата треба да се преврти т.ш. прво се превртуваат јазлите
кои содржат парни броеви, а потоа јазлите со непарни броеви. Листата се разгледува од назад. 
Право на користење имате само една дополнителна помошна двострано поврзана листа.
 
Во првиот ред од влезот е даден бројот на јазли во листа, потоа во вториот ред се дадени броевите 
од кои се составени јазлите по редослед во листата. На излез треба да се испечатат јазлите по редослед во превртената листа.
 
Забелешка: При реализација на задачите МОРА да се користат дадените структури, а не да се користат 
помошни структури како низи или сл.
 
Делумно решение: Задачата се смета за делумно решена доколку се поминати 7 тест примери.*/

/*
20
2 2 4 6 2 4 6 8 0 1 1 1 1 3 1 1 3 5 7 9
 
0 8 6 4 2 6 4 2 2 9 7 5 3 1 1 3 1 1 1 1
*/
public class List10_Prevrti_Lista {

	public static void main(String[] args)throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String [] s = br.readLine().split(" ");
		
		DLL<Integer> list = new DLL<Integer>();
		DLL<Integer> result_list = new DLL<Integer>();
		
		for(int i = 0; i < n; i ++) {
			list.insertLast(Integer.parseInt(s[i]));
		}
		
		DLLNode<Integer> node = list.getLast();
		DLLNode<Integer> tmp = result_list.getLast();
		boolean isFirst = true;
		
		while(node != null) {
			
			if(node.element % 2 != 0){
				result_list.insertLast(node.element);
			}
			
			else {
				
				if(node.element % 2 == 0 && isFirst) {
					result_list.insertFirst(node.element);
					isFirst = false;
					tmp = result_list.getFirst();
				}
				else{
					result_list.insertAfter(node.element, tmp);
					tmp = tmp.succ;
					//System.out.println("asdsad");
				}
			}
			node = node.pred;
		}
		
		System.out.println(result_list.toString());
		
	}

}






