import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

/*Да се напише алгоритам кој ќе пресметува (евалуира) математички израз составен од броеви и
 операциите за собирање (+) и множење ().

Забелешка: Операцијата множење има предност пред операцијата собирање.*/
// 2+4*7*5+2*3+1
interface Stack<E> {

    // Elementi na stekot se objekti od proizvolen tip.

    // Metodi za pristap:

    public boolean isEmpty ();
    	// Vrakja true ako i samo ako stekot e prazen.

    public E peek ();
    	// Go vrakja elementot na vrvot od stekot.

    // Metodi za transformacija:

    public void clear ();
    	// Go prazni stekot.

    public void push (E x);
    	// Go dodava x na vrvot na stekot.

    public E pop ();
    	// Go otstranuva i vrakja elementot shto e na vrvot na stekot.
}
class ArrayStack<E> implements Stack<E> {

    // Stekot e pretstaven na sledniot nacin: 
	//depth e dlabochinata na stekot, a 
    // elems[0...depth-1] se negovite elementi.
    private E[] elems;
    private int depth;

    @SuppressWarnings("unchecked")
    public ArrayStack (int maxDepth) {
        // Konstrukcija na nov, prazen stek.
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }


    public boolean isEmpty () {
        // Vrakja true ako i samo ako stekot e prazen.
        return (depth == 0);
    }


    public E peek () {
        // Go vrakja elementot na vrvot od stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth-1];
    }


    public void clear () {
        // Go prazni stekot.
        for (int i = 0; i < depth; i++)  elems[i] = null;
        depth = 0;
    }


    public void push (E x) {
        // Go dodava x na vrvot na stekot.
        elems[depth++] = x;
    }


    public E pop () {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}

public class Stek1_Matematicki_izraz {
	public static void print(ArrayStack<Integer> stack) {
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String [] s = br.readLine().split("\\+");
		
		ArrayStack<String> stack1 = new ArrayStack<String>(100);
		ArrayStack<Integer> stack2 = new ArrayStack<Integer>(100);
		
		
		for(int i = 0; i < s.length; i++) {
			stack1.push(s[i]);
		}
		
		while(!stack1.isEmpty()) {
			String a = stack1.pop();
			int proizvod = 1;
			if(a.contains("*")) {
				String [] tmp = a.split("\\*");
				for(int i=0; i < tmp.length; i++) {
					 proizvod *= Integer.parseInt(tmp[i]);
				}
				stack2.push(proizvod);
			}else {
				stack2.push(Integer.parseInt(a));
			}
		}
		
		
			int sum = 0;
		
		while(!stack2.isEmpty()){
			sum += stack2.pop();
		}
		System.out.println(sum);
	}

}





