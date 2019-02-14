import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Кај асистентот Игор се одржуваат консултации по два предмети АСП и ММС во еден термин.
 * Бидејќи по АПС колоквиумот е следниот ден, Игор им рекол на студентите кои што чекаат дека 
 * прво ќе ги услужи студентите по АПС, а после студентите по ММС. 
 * Студентите се подготвиле со прашања и прашањата за АПС можат да бидат од тип А, B, C или D. 
 * Асистентот им напоменал на студентите по АПС, ако дојде некој студент и праша прашање од 
 * тип X (X e A,B,C или D) и веднаш после него дојде студент со прашање од тип X 
 * (т.е. со прашање од ист тип), вториот студент ќе биде ставен на крајот од редот и истовремено ќе биде пуштен 
 * еден студент од другата редица за ММС (ако таа редица не е празна). 
 * Генерално, ако последното одговорено прашање по АПС е од тип X, и дојде студент со прашање од тип X, 
 * тој се преместува на крајот од редот и се пушта еден студент од другата редица за ММС (ако таа редица не е празна).
 * Кој ќе биде конечниот распоред за влегување? 
 * 
 * Влез: Се дава прво бројот на студенти кои се пријавиле за консултации АПС, 
 * а потоа се наведуваат студентите според редоследот на пријавување и се дава за кој тип прашање се 
 * пријавиле (A, B, C или D). 
 * Следно се дава бројот на студенти кои се пријавиле за консултации ММС,
 * а потоа се наведуваат студентите според редоследот на пријавување. 
 * Sample input
3
IlinkaIvanoska A
MagdalenaKostoska A
HristinaMihajloska B
1
IgorKulev
Sample output
IlinkaIvanoska
IgorKulev
HristinaMihajloska
MagdalenaKostoska
 * На излез се печатат студентите според редоследот по кој влегле на консултации.*/
class Ucenik{
	public String ime;
	public String prasanje;
	
	public Ucenik(String ime,String prasanje) {
		this.ime = ime;
		this.prasanje = prasanje;
	}
}
public class Red3_KonsultaciIgor {
	public static void pecati(ArrayQueue<Ucenik> red) {
		while(!red.isEmpty()) {
			System.out.print(red.dequeue().ime+" ");
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int brStudenti = Integer.parseInt(br.readLine());
		ArrayQueue<Ucenik> redAps = new ArrayQueue<Ucenik>(100);
		ArrayQueue<String> redMms = new ArrayQueue<String>(100);
		
		for(int i = 0; i < brStudenti; i++) {
			String [] s = br.readLine().split(" ");
			redAps.enqueue(new Ucenik(s[0],s[1]));
		}
		int brStudentiMMS = Integer.parseInt(br.readLine());
		for(int i = 0; i < brStudentiMMS; i++) {
			String s = br.readLine();
			redMms.enqueue(s);
		}
		
		//pecati(redAps);
		boolean flag = false;
		String tip = "";
		while(!redAps.isEmpty()) {
			
			if(flag) {
				flag = false;
				tip = "";
				redAps.enqueue(redAps.dequeue());
				if(!redMms.isEmpty())
					System.out.println(redMms.dequeue());
			}
			else {
				Ucenik obj = redAps.dequeue();
				tip = obj.prasanje;
				System.out.println(obj.ime);
			}
			if(!redAps.isEmpty() && tip.equals(redAps.peek().prasanje)) {
				flag = true;
			}
		}

	}

}
