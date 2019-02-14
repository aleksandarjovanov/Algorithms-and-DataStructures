import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Пред командантот на војската наредени се сите војници и во двојно поврзана листа дадени се нивните ID-a. 
 * На командантот не му се допаѓа како се наредени војниците и решава да одбере два под-интервали од војници и да им 
 * ги замени местата, односно војниците што се наоѓаат во едниот под-интервал ќе ги смести во другиот, и обратно.
Влез: Во првиот ред даден е бројот на војници. Во вториот ред дадени се ID-то на секој од војниците. Во третиот ред 
дадени се два броеви, ID на првиот војник и ID на последниот војник од првиот интервал. Во четвртиот ред дадени се два 
броеви, ID на првиот војник и ID на последниот војник од вториот интервал.
Излез: Да се испечати новиот редослед на војниците (т.е. на нивните ID-a)
Забелешка 1: Интервалите никогаш нема да се преклопуваат и ќе содржат барем еден војник. 
Целата низа ќе содржи најмалку два војника. Забелешка 2: Обратете посебно внимание кога интервалите се еден до 
друг и кога некој од интервалите почнува од првиот војник или завршува со последниот војник.*/
public class List17_Vojska {
	public static void pecati(DLL<Integer> list){
		DLLNode<Integer> node = list.getFirst();
		while(node != null){
			System.out.print(node.element +" ");
			node = node.succ;
		}
	}

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = Integer.parseInt(s);
		
		DLL<Integer> list = new DLL<>();
		DLL<Integer> rezlist = new DLL<>();
		
		String s1 = br.readLine();
		String [] niza = s1.split(" ");
		for(int i = 0; i < n; i++){
			list.insertLast(Integer.parseInt(niza[i]));
		}
		String s2 = br.readLine();
		String s3 = br.readLine();
		String [] niza2 = s2.split(" ");
		String [] niza3 = s3.split(" ");
		int a = Integer.parseInt(niza2[0]);
		int b = Integer.parseInt(niza2[1]);
		int c = Integer.parseInt(niza3[0]);
		int d = Integer.parseInt(niza3[1]);
		
		DLLNode<Integer> node = list.getFirst();
		///////////////////////////////////////////////////////////////////////////////
		while(node != null){
			if(node.element == c){
				while(node.element != d){
					rezlist.insertLast(node.element);  //   C ----- D
					node = node.succ;
				}
				rezlist.insertLast(node.element);
			}
			node = node.succ;
		}
		///////////////////////////////////////////////////////////////////////////////
		node = list.getFirst();
		while(node != null){
			if(node.element == a){
				while(node.element != b){
					rezlist.insertLast(node.element);  //   A ----- B
					node = node.succ;
				}
				rezlist.insertLast(node.element);
			}
			node = node.succ;
		}
		//////////////////////////////////////////////////////////////////////////////
		DLLNode<Integer> nodeA = null;
		DLLNode<Integer> nodeB = null;
		DLLNode<Integer> nodeC = null;
		DLLNode<Integer> nodeD = null;
		node = rezlist.getFirst();
		while(node != null){
			if(node.element == a){
				nodeA = node;
			}
			node = node.succ;
		}
		node = rezlist.getFirst();
		while(node != null){
			if(node.element == b){
				nodeB = node;
			}
			node = node.succ;
		}
		node = rezlist.getFirst();
		while(node != null){
			if(node.element == c){
				nodeC = node;
			}
			node = node.succ;
		}
		node = rezlist.getFirst();
		while(node != null){
			if(node.element == d){
				nodeD = node;
			}
			node = node.succ;
		}
		
		
		//System.out.println(nodeA.element +" "+ nodeB.element +" "+ nodeC.element +" "+ nodeD.element);
		node = list.getFirst();
		while(node != null){
			while(node.element != a){
				rezlist.insertBefore(node.element, nodeC);
				node = node.succ;
			}
			
			while(node.element != b){
				node = node.succ;           ///////////////////////////////
			}
			node = node.succ;
			
			while(node.element != c){
				rezlist.insertBefore(node.element, nodeA);
				node = node.succ;
			}
			
			while(node.element != d){
				node = node.succ;           ///////////////////////////////
			}
            node = node.succ;
			
			while(node != null){
				rezlist.insertLast(node.element);
				node = node.succ;
			}
			
		}
		
		pecati(rezlist);
	}

}