import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
/*Квалитет на воздух Problem 1 (0 / 0)
Дадени се мерења на PM10 честички за населбите во Скопје. Ваша задача е за дадена населба да се најде просечната концентрација на PM10 честички.
Влез: Во првиот ред од влезот е даден бројот на мерења N (N<=10 000), а во секој нареден ред е прво дадена населбата и концентрацијата на PM10 разделени со празно место. 
Во последниот ред е дадена населбата за која треба да најдете просечна концентрација на PM10 честички.
Излез: Просечната концентрација на PM10 честички за дадената населба (заокружена на 2 децимали).
Делумно решение: Задачата се смета за делумно решена доколку се поминати 7 тест примери.
Забелешка: При реализација на задачите не е дозволено да се користат помошни структури како низи или сл. На располагање од структурите имате само хеш структура.
Sample input
8
Centar 319.61
Karposh 296.74
Centar 531.98
Karposh 316.44
GaziBaba 384.05
GaziBaba 319.3
Karposh 393.18								///-------->>>>>>     ***** SLEDNA ZADACA E HASH10_KOLOKVIM ***** <<<<<<<------------////
GaziBaba 326.42
Karposh
 
Sample output
335.45*/
public class Hash7_PM10 {

	public static void main(String[] args)throws IOException {                           
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String,ArrayList<Float>> tabela = new HashMap<String,ArrayList<Float>>();
		DecimalFormat df = new DecimalFormat("####.##");
	
		for(int i = 0; i < n; i ++) {
			String [] vlez = br.readLine().split(" ");
			String grad = vlez[0];
			Float pm = Float.parseFloat(vlez[1]);
			
			if(tabela.containsKey(grad)) {
				ArrayList<Float> list = tabela.get(grad);
				list.add(pm);
				tabela.put(grad, list);
			}
			else {
				ArrayList<Float> list = new ArrayList<Float>();
				list.add(pm);
				tabela.put(grad, list);
			}
		}
		
		String opstina = br.readLine();
		ArrayList<Float> pom = tabela.get(opstina);
		float sum = 0;
		for(int i = 0; i < pom.size(); i++) {
			sum += pom.get(i);
		}
		System.out.println(df.format(sum/pom.size()));

	}

}
