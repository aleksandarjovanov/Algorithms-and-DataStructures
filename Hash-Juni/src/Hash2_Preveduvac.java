import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*Треба да изработите автоматски преведувач за зборови од анлиски јазик на македонски. Влезот се состои од парови од зборови 
 * разделени со празно место. Така прво е даден зборот на македонски, па има едно празно место, па преводот на зборот на англиски 
 * јазик Потоа на влез се добиваат странски зборови (секој во посебен ред). За излез треба да се преведат овие зборови. 
 * Доколку не е познат преводот на зборот на излез се печати "/"

Влез. Прво се дава број N на поими кои ќе ги содржи речникот. Потоа во наредните N реда се дадени поимите, прв на македонски, 
потоа на англиски. Потоа следуваат зборови на англиски (секој збор во посебен ред), кои треба да се преведат на македонски. 
За означување на крај во редицата се дава зборот KRAJ

Излез. За секој од дадените зборови на англиски во посебен ред е даден преводот на зборот на македонски. Доколку не е познат 
преводот на зборот се печати /

Забелешка. Работете со хеш табела со отворени кофички. Сами треба да го одредите бројот на кофички и хеш функцијата.

Име на класа: Preveduvac*/
public class Hash2_Preveduvac {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String,String> tabela = new HashMap<String,String>(2*n);
		
		for(int i = 0; i < n; i ++) {
			String [] prevod = br.readLine().split(" ");
			String mk = prevod[0];
			String en = prevod[1];
			tabela.put(en, mk);
		}
		
		String forTranslate = br.readLine();
		
		while(!forTranslate.equals("KRAJ")) {
				
			if(tabela.containsKey(forTranslate)) {
				System.out.println(tabela.get(forTranslate));
			}else {
				System.out.println("/");
			}
			
			forTranslate = br.readLine();
		}

	}

}
