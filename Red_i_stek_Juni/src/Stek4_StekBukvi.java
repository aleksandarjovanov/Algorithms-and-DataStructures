/*Дадена е низа од големи букви, во која буквата S се појавува парен број пати. После секоја буква S буквата Т се 
 * појавува еднаш или повеќе пати.Користејќи стек да се одреди дали после секоја буква S (до следната буква S), 
 * буквата Т се појавува ист број на пати. На првиот ред од влезот се чита низа од карактери (стринг), на излез се печати 
 * 1 доколку буквата Т се појавува ист број на пати после секоја S, и нула доколку овој услов не е исполнет.*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Stek4_StekBukvi {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		LinkedStack<Character> stek = new LinkedStack<>();   //// NE MI E STAVENA NIAKDE LINKEDSTACK
		
		for(int i = s.length()-1; i >= 0; i --){
			stek.push(s.charAt(i));
		}
		//pecati(stek);
		
		ArrayList<Integer> niza = new ArrayList<>();
		int broj = 0;
		while(!stek.isEmpty()){
			char bukva = stek.pop();
			if(bukva == 'S'){
				broj = 0;
				while(!stek.isEmpty()){
					if(stek.peek() != 'S'){
					if(stek.pop() == 'T'){
						broj++;
						}
					}
				
				else
					break;
				}
                			niza.add(broj);

            }
		}
		
		int flag = 1;
		for(int i = 0; i < niza.size()-1; i ++){
			if(niza.get(i) != niza.get(i+1)){
				flag = 0;
				break;
			}
		}
		if(flag == 1){
			System.out.println("1");
		}
		else System.out.println("0");
	}

}
