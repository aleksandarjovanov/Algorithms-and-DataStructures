import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1. Постфикс нотација - Java Задача 3 (0 / 0)
Да се напише алгоритам кој ќе врши евалуација на израз во постфикс нотација. На влез се чита низа од знаци за изразот (стринг), а на излез се печати вредноста на изразот по евалуацијата. Име на класата: PostFixEvaluation
Вашето решение:
Програмски јазик: Java
 
Тест случај#  Влез                        Излез
1               1 2 +                       3
2               7 4 -                       3
3               0 3 /                       0
4               5 2 *                       10
5               100 20 -                    80
6               1 2 3 * + 5 -               2
7               28 72 * 13 + 20 67 * +      3369
8               1 1 1 - - 1 + 1 +           3
9               60 80 * 20 40 * /           6
10              8 9 * 4 3 - + 2 3 6 * + -   53
 
*/
public class Stek2_Postfiks {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] s = br.readLine().split(" ");
		
		ArrayStack<Integer> stack = new ArrayStack<Integer>(100);
		
		for(int i = 0; i < s.length; i++ ) {
			
			if(s[i].equals("+") ||  s[i].equals("/") || s[i].equals("*") || s[i].equals("-")) {
				
				if(s[i].equals("+")) {
					int a = stack.pop();
					int b = stack.pop();
					int rez = b + a;
					stack.push(rez);
				}
				if(s[i].equals("-")) {
					int a = stack.pop();
					int b = stack.pop();
					int rez = b - a;	
					stack.push(rez);
				}
				if(s[i].equals("*")) {
					int a = stack.pop();
					int b = stack.pop();
					int rez = b * a;
					stack.push(rez);
				}
				if(s[i].equals("/")) {
					int a = stack.pop();
					int b = stack.pop();
					int rez = b / a;
					stack.push(rez);
				}
				
			}
			else {
				stack.push(Integer.parseInt(s[i]));
			}
		}
		int kraj = stack.peek();
		System.out.println(kraj);
	}

}
