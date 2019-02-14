import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*На влез се прима листа и таа листа треба да се модифицира на начин што помеѓу секои 2 броја ќе се вметне
 *број што е аритметичка средина на тие 2 броја. Да не се користи помошна листа туку да се вметнат во веќе
 *дадената.*/
public class List7_Megu_2_Jazli_add_aritmetik {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String [] s = br.readLine().split(" ");
		SLL<Float> list = new SLL<Float>();

		for(int i = 0; i < n; i++) {
			list.insertLast(Float.parseFloat(s[i]));
		}
		
		SLLNode<Float> node = list.getFirst();
		
		while(node.succ.succ != null) {
			float art = (float)(node.element + node.succ.element) / 2;
			list.insertAfter(art, node);
			node = node.succ.succ;
		}
		/*while(node != null) {
			if(node.succ == null) {
				break;
			}
			 else {
			float as = (node.element + node.succ.element)/2;
			lista.insertAfter(as, node);
			}
			
			node = node.succ.succ;
			
		}*/
		
		System.out.println(list.toString());
	}

}
