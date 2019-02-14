/*10
Ana Anovska
0
1
1
Marko Markovski
1
0
1
Branka Brankovska
0
1
1
Jana Janevska
0
1
0
Petko Petkovski
1
1
0
Aleksandar Aleksandrovski
0
1
0
Trajko Trajkovski
0
0
1
Petre Petreski
1
0
1
Mite Mitevski
1
1
0
Maja Majevska
0
1
0
Jana Janevska
Aleksandar Aleksandrovski
Maja Majevska
Petko Petkovski
Mite Mitevski
Trajko Trajkovski
Marko Markovski
Petre Petreski
Ana Anovska
Branka Brankovska*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Graganin{
	public String ime;
	public int licna;
	public int pasos;
	public int vozacka;
	
	public Graganin(String name,int l,int p,int v) {
		ime = name;
		licna = l;
		pasos = p;
		vozacka = v;
	}
}
public class Red4_MVR {
	public static void pecati(ArrayQueue<Graganin> red) {
		while(!red.isEmpty()) {
			System.out.print(red.dequeue().ime+" ");
		}
	}

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int brLuge = Integer.parseInt(br.readLine());
		ArrayQueue<Graganin> redlicna = new ArrayQueue<Graganin>(100); 
		ArrayQueue<Graganin> redpasos = new ArrayQueue<Graganin>(100); 
		ArrayQueue<Graganin> redvozacka = new ArrayQueue<Graganin>(100); 

		for(int i = 0; i < brLuge; i ++) {
			String ime = br.readLine();
			int l = Integer.parseInt(br.readLine());
			int p = Integer.parseInt(br.readLine());
			int v = Integer.parseInt(br.readLine());
			Graganin obj = new Graganin(ime,l,p,v);
			
			if(obj.licna == 1) {
				redlicna.enqueue(obj);
				continue;
			}
			if(obj.pasos == 1) {
				redpasos.enqueue(obj);
				continue;
			}
			if(obj.vozacka == 1) {
				redvozacka.enqueue(obj);
				continue;
			}
			
		}
		//pecati(redlicna);
		//pecati(redpasos);
		//pecati(redvozacka);
		
		while(!redlicna.isEmpty()) {
			Graganin obj = redlicna.dequeue();
			if(obj.pasos==1) {
				redpasos.enqueue(obj);
				continue;
			}
			if(obj.vozacka==1) {
				redvozacka.enqueue(obj);
				continue;
			}
			System.out.println(obj.ime);
		}
		while(!redpasos.isEmpty()) {
			Graganin obj = redpasos.dequeue();
			if(obj.vozacka==1) {
				redvozacka.enqueue(obj);
				continue;
			}
			System.out.println(obj.ime);
		}
		while(!redvozacka.isEmpty()) {
			Graganin obj = redvozacka.dequeue();
			System.out.println(obj.ime);
		}

	}

}
