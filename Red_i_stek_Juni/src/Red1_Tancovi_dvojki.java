import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Stack;
/*Да се напише алгоритам со кој ќе се изврши креирање на танцови парови по соодветни танц-групи во една танцова школа. 
 *Танцов пар се формира од машко и женско запишани на иста танцова група. Во школата за танци на располагање има
 *групи за основни танци О, стандардни танци S и латино танци L. Има уписен рок така што заинтересираните кандидати
 *може да се упишат. Со завршување на уписниот рок се врши формирање на танцови двојки. Ваша задача е од добиениот
 *список на сите запишани кандидати да направите соодветни парови и да кажете колку, од каков тип на
 *кандидати (машко или женско) и за која танцова група фалат за да сите добијат свој партнер.

Влез: Листа од упишаните кандидати по редослед: прв дојден, прв запишан и тоа во облик: танцова група, пол
Име на класата (Java): TancovKlub
Забелешка: При реализација на задачите МОРА да се користат дадените структури, а не да се користат помошни структури 
           како низи или сл.

Пример влез:
LM OZ OM OM LM SZ SM LZ OM LZ SZ SM SM LM
Парови кои може да се формираат од овој список се:

(LM,LZ); (SM, SZ); (SZ SM); (LM, LZ); (OZ, OM); (LM, LZ)

Остануваат без партнер: OM, OM, SM, LM
Излез:
4
LZ SZ OZ OZ*/
interface Queue<E> {

	// Elementi na redicata se objekti od proizvolen tip.

    // Metodi za pristap:

    public boolean isEmpty ();
    	// Vrakja true ako i samo ako redicata e prazena.

    public int size ();
    	// Ja vrakja dolzinata na redicata.

    public E peek ();
    	// Go vrakja elementot na vrvot t.e. pocetokot od redicata.

    // Metodi za transformacija:

    public void clear ();
    	// Ja prazni redicata.

    public void enqueue (E x);
    	// Go dodava x na kraj od redicata.

    public E dequeue ();
    	// Go otstranuva i vrakja pochetniot element na redicata.

}
class ArrayQueue<E> implements Queue<E> {

    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Ako length > 0, togash elementite na redicata se zachuvani vo elems[front...rear-1]
    // Ako rear > front, togash vo  elems[front...maxlength-1] i elems[0...rear-1]
    E[] elems;
    int length, front, rear;

    // Konstruktor ...

    @SuppressWarnings("unchecked")
    public ArrayQueue (int maxlength) {
        elems = (E[]) new Object[maxlength];
        clear();
    }

    public boolean isEmpty () {
    	// Vrakja true ako i samo ako redicata e prazena.
        return (length == 0);
    }

    public int size () {
    	// Ja vrakja dolzinata na redicata.
        return length;
    }

    public E peek () {
    	// Go vrakja elementot na vrvot t.e. pocetokot od redicata.
        if (length > 0)
            return elems[front];
        else
            throw new NoSuchElementException();
    }

    public void clear () {
    	// Ja prazni redicata.
        length = 0;
        front = rear = 0;  // arbitrary
    }

    public void enqueue (E x) {
    	// Go dodava x na kraj od redicata.
        elems[rear++] = x;
        if (rear == elems.length)  rear = 0;
        length++;
    }

    public E dequeue () {
    	// Go otstranuva i vrakja pochetniot element na redicata.
        if (length > 0) {
            E frontmost = elems[front];
            elems[front++] = null;
            if (front == elems.length)  front = 0;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }
}

public class Red1_Tancovi_dvojki {
	public static void pecati(ArrayQueue<String> red) {
		while(!red.isEmpty()) {
			System.out.print(red.dequeue()+" ");
		}
	}

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] s = br.readLine().split(" ");
		
		ArrayQueue<String> standard = new ArrayQueue<String>(100);
		ArrayQueue<String> latino = new ArrayQueue<String>(100);
		ArrayQueue<String> osnovni = new ArrayQueue<String>(100);
		Stack<String> stack = new Stack<String>();
		for(int i = 0; i < s.length; i++) {
			if(s[i].charAt(0) == 'S') {
				standard.enqueue(s[i]);
			}
			if(s[i].charAt(0) == 'O') {
				osnovni.enqueue(s[i]);
			}
			if(s[i].charAt(0) == 'L') {
				latino.enqueue(s[i]);
			}
		}
		/*pecati(standard);
		System.out.println();
		pecati(osnovni);
		System.out.println();
		pecati(latino);*/
		
		while(!standard.isEmpty()) {
			
			String str = standard.dequeue();
			if(stack.isEmpty()) {
				stack.push(str);
				continue;
			}
			
			if(str.equals(stack.peek())) {
				stack.push(str);
			}
			else {
				stack.pop();
			}
			
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		
		while(!latino.isEmpty()) {
			
			String str = latino.dequeue();
			if(stack.isEmpty()) {
				stack.push(str);
				continue;
			}
			
			if(str.equals(stack.peek())) {
				stack.push(str);
			}
			else {
				stack.pop();
			}
			
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		
		while(!osnovni.isEmpty()) {
			
			String str = osnovni.dequeue();
			if(stack.isEmpty()) {
				stack.push(str);
				continue;
			}
			
			if(str.equals(stack.peek())) {
				stack.push(str);
			}
			else {
				stack.pop();
			}
			
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}

}
