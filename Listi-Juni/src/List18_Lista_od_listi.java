import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Дадена е двојно поврзана листа од двојно поврзани листи. Да се најде сума на секоја од подлистите, а потоа производ на овие суми

Влез: Број N кој кажува колку листи има Број М кој кажува колку елементи има во секоја листа Во следните М линии се податоците 1<=A<=1000за секоја од листите

Излез: Еден број што е производот на сумите од низите. Со седум децимали.

Пример влез: 3 4 1 2 3 4 2 3 4 5 6 7 8 9

Излез: 1400*/
public class List18_Lista_od_listi {
	
	public static void pecati(DLL<DLL<Integer>> list) {
		DLLNode<DLL<Integer>> node = list.getFirst();
		
		while(node != null) {
			DLLNode<Integer> subnode = node.element.getFirst();
			while(subnode != null) {
				System.out.print(subnode.element);
				subnode = subnode.succ;
			}
			System.out.println();
			node = node.succ;
		}
	}

	public static void main(String[] args)throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		DLL<DLL<Integer>> list = new DLL<DLL<Integer>>();
		
		for(int i = 0; i < n; i ++) {
			DLL<Integer> sublist = new DLL<Integer>();
			String [] s = br.readLine().split(" ");
			for(int j = 0; j < m; j++) {
				sublist.insertLast(Integer.parseInt(s[j]));
			}
			list.insertLast(sublist);
		}	
		
		DLLNode<DLL<Integer>> node = list.getFirst();
		long proizvod = 1;
		while(node != null) {
			int sum = 0;
			DLLNode<Integer> subnode = node.element.getFirst();
			while(subnode != null) {
				sum += subnode.element;
				subnode = subnode.succ;
			}
			proizvod *= sum;
			node = node.succ;
		}
		
		System.out.println(proizvod);
		
		
	}

}
