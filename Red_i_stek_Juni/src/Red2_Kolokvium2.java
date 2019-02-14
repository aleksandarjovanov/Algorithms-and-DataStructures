import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*Се организира колоквиумска недела на ФИНКИ и за таа цел асистентите се доделуваат за чување на испити. 
За таа цел се прави редица од асистентите во која на почеток се најмладите асистенти, а на крај се највозрасните. 
Потоа се даваат предметите и по колку асистенти се потребни за чување на секој предмет. 
Има некои асистенти кои се отсутни во тековната колоквиумска недела. 
Затоа дополнително се дава список кои од асистентите се отсутни.
Асистентите се доделуваат на следниот начин: Прво се доделуваат најмладите, а на крај најстарите, 
со тоа што ако некој асистент е отсутен тој се игнорира во редицата. 
После секое доделување на предмет асистентот се сместува на крај на редицата
(т.е. ако на секој асистент му се доделил за чување предмет, а има потреба од уште асистенти, 
повторно се започнува од најмладите).*/
/*Sample input
4
IlinkaIvanoska
IgorKulev
MagdalenaKostoska
HristinaMihajloska
3
APS 3
MIS 1
OOS 2
1
HristinaMihajloska

Sample output
APS
3
IlinkaIvanoska
IgorKulev
MagdalenaKostoska
MIS
1
IlinkaIvanoska
OOS
2
IgorKulev
MagdalenaKostoska*/
public class Red2_Kolokvium2 {
	public static void pecati(ArrayQueue<String> red) {
		while(!red.isEmpty()) {
			System.out.print(red.dequeue()+" ");
		}
	}

	public static void main(String[] args)throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		ArrayQueue<String> asistenti = new ArrayQueue<String>(100);
		ArrayQueue<String> predmeti = new ArrayQueue<String>(100);
		ArrayQueue<String> otsutni = new ArrayQueue<String>(100);
		ArrayQueue<String> tmp = new ArrayQueue<String>(100);
		
		int brA = Integer.parseInt(input.readLine());
		for(int i=0; i<brA; i++) {
			asistenti.enqueue(input.readLine());
		}
		int brP = Integer.parseInt(input.readLine());
		for(int i=0; i<brP; i++) {
			predmeti.enqueue(input.readLine());
		}
		
		int brO = Integer.parseInt(input.readLine());
		for(int i=0; i<brO; i++) {
			otsutni.enqueue(input.readLine());
		}
		
		while(!otsutni.isEmpty()) {
			String str = otsutni.dequeue();
			
			while(!asistenti.isEmpty()) {
				String asis = asistenti.dequeue();
				if(str.equals(asis)) {
					
				}
				else {
					tmp.enqueue(asis);
				}
			}
			while(!tmp.isEmpty()) {
				asistenti.enqueue(tmp.dequeue());
			}
		}
		//pecati(asistenti);
		
		while(!predmeti.isEmpty()) {
			String [] s = predmeti.dequeue().split(" ");
			String predmet = s[0];
			int brojAsis = Integer.parseInt(s[1]);
			
			System.out.println(predmet);
			System.out.println(brojAsis);
			for(int i = 0; i < brojAsis; i++) {
				String asistent = asistenti.dequeue();
				System.out.println(asistent);
				asistenti.enqueue(asistent);
			}
		}

	}

}
