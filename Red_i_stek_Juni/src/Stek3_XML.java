import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Модифициран XML код Problem 2 (0 / 0)
Даден е некој модифициран XML код. Модифицираниот XML код ги користи симболите '[' и ']', за отварање и затворање на таг, соодветно, наместо стандардните '
' и '>'. Треба да се провери дали сите тагови во кодот се правилно вгнездени (дали кодот е валиден) т.е. дали секој отворен таг има соодветен затворен таг
 со истото име на соодветното место во кодот. За поедноставување, дадено е дека секој отворен таг мора да има свој затворен таг и дека таговите немаат атрибути.
На влез е даден бројот на редови во кодот и самиот XML со секој таг во посебен ред, а на излез треба да се испечати 1 или 0 за валиден или невалиден код, соодветно.
Објаснување: Во модифицираниот XML код секој отворен таг е во облик [imeNaTag], а соодветниот затворен таг е во облик [/imeNaTag].
Пример за правилно вгнездени тагови во XML e:
[tag1]
[tag2]
Podatok
[/tag2]
[/tag1]
Пример за неправилно вгнездени тагови во XML e:
[tag1]
[tag2]
Podatok
[/tag1]
[/tag2]
Име на класата (Java): CheckXML
 
Sample input:
20
[Korisnik]
[Ime]
Jana
[/Ime]
[Prezime]
[Korisnik]
[Ime]
Ivan
[/Ime]
[Prezime]
[/Prezime]
[MBR]
2807986455092
[/MBR]
[/Korisnik]
[/Prezime]
[MBR]
2908986455091
[/MBR]
[/Korisnik]
Sample output:
1
 
Sample input:
10
[Korisnik]
[Ime]
Jana
[/Ime]
[Prezime]
[/Ime]
[MBR]
2807986455092
[/MBR]
[/Korisnik]
Sample output:
0
 
Sample input:
10
[Korisnik]
[Ime]
Jana
[/Ime]
[Prezime]
[/Prezime]
[MBR]
2807986455092
[/MBR]
[/Kor]
Sample output:
0
 
Sample input:
10
[Korisnik]
[Ime]
Jana
[MBR]
[/Ime]
[MBR]
2807986455092
[/MBR]
[/MBR]
[/Korisnik]
Sample output:
0
 
Sample input:
2
[text]
[/text]
Sample output:
1
 
Sample input:
5
[Korisnik]
[/Ime]
Jana
[Ime]
[/Korisnik]
Sample output:
0
 
Sample input:
10
[MBR]
[Broj]
2807986455092
[/Broj]
[Ime]
[Broj]
Jana
[/Ime]
[/Broj]
[/MBR]
Sample output:
0
 
Sample input:
9
[Tabela]
[Red]
[Podatok]
[/Podatok]
[Podatok]
Primer
[/Podatok]
[/Red
[/Tabela]
Sample output:
0
 
Sample input:
12
[body]
[div]
[a]
[/a]
[/div]
[div]
[a]
[/a]
[/div]
[/body]
[p]
[/p]
Sample output:
1
 
Sample input:
11
[html]
[title]
goodbye
[/title]
[body]
h3]
[ul]
[/ul]
[/h3]
[/body]
[/html]
Sample output:
0
*/
public class Stek3_XML {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String [] red = new String[n];
		
		for(int i = 0; i < n; i ++) {
			red[i] = br.readLine();
		}
		
		ArrayStack<String> stack = new ArrayStack<String>(100);
		
		boolean flag = true;
		for(String a : red) {
			
			if(a.charAt(0) == '[') {
				if(a.charAt(1) == '/') {
					String filter = a.substring(2,a.length()-1);
					if(filter.equals(stack.pop())){
						flag = true;
					}
					else {
						flag = false;
						break;
					}
				}
				else {
					String filter = a.substring(1, a.length()-1);
					stack.push(filter);
				}
			}
			else {
				// ne e biten oti e obicen zbor
			}
			
		}
		if(flag) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}

	}

}
