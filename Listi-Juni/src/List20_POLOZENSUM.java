import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class List20_POLOZENSUM {

	public static void main(String[] args) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int el = Integer.parseInt(input.readLine());
		String [] s = input.readLine().split(" ");
		
		SLL<Integer> lista = new SLL<Integer>();
		for(int i = 0; i < el; i ++) {
			lista.insertLast(Integer.parseInt(s[i]));
		}
		SLLNode<Integer> node = lista.getFirst();
		
		int n = Integer.parseInt(input.readLine());
		
		for(int i = 0; i < n; i ++) {
			node = lista.getFirst();
			float br = 0;
			while(node != null) {
				br += 1;
				float dol = (float)lista.length()/2;
				
				if(br == dol) {
					lista.delete(node);
					break;
				}
				
				dol = dol + (float)0.5;
				if(dol == br) {
					if(node.succ != null) {
						lista.delete(node);
						break;
					}
				}
				node = node.succ;
			}
		}
		System.out.println(lista.toString());
	}

}
