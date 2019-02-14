import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * N deca sedat vo krug i se igra slednava igra. Se pocnuva od deteto X i se
 * brojat deca vo nasoka na casovnikot, koga kje se dojde do brojot M, deteto
 * kaj koe sto zastanalo broenjeto ispagja od igra. Slednata runda se pocnuva
 * od deteto koe bi bilo broj M+1, megjutoa se menja nasokata na broenje.
 * Se igra N-1 rundi, se dodeka ne ostane samo edno dete. Na vlez se vnesuvaat:
 * iminjata na decata, imeto na deteto od koe pocnuva igrata vo prvata runda
 * i broevite N i M. Da se odredi koe dete pobeduva vo igrata.
 */
public class List19_Mizorka {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //br deca
		int m = Integer.parseInt(br.readLine()); //br na broenje
		
		DLL<String> list = new DLL<String>();
		
		for(int i = 0; i < n; i ++) {
			String dete = br.readLine();
			list.insertLast(dete);
		}
		
		DLLNode<String> node = list.getFirst();
		DLLNode<String> startnode = list.getFirst();
		
		String prvoDete = br.readLine();
		while(node != null) {
			if(node.element.equals(prvoDete)) {
				startnode = node;
				break;
			}
			node = node.succ;
		}
		boolean flag = true;
		while(list.length()!=1) {
			
			if(flag) {
				for(int i = 0; i < m; i ++) {
					if(startnode.succ != null) {
						startnode = startnode.succ;
					}
					else {
						startnode = list.getFirst();
					}
				}
				list.delete(startnode);
				flag = false;
				if(startnode.pred != null)
					startnode = startnode.pred;
				else
					startnode = list.getLast();
			}
			else {
				for(int i = 0; i < m; i ++) {
					if(startnode.pred != null) {
						startnode = startnode.pred;
					}
					else {
						startnode = list.getLast();
					}
				}
				list.delete(startnode);
				flag = true;
				if(startnode.succ != null)
					startnode = startnode.succ;
				else
					startnode = list.getFirst();
			}
			
		}
		
		System.out.println(list.toString());
		
	}

}
