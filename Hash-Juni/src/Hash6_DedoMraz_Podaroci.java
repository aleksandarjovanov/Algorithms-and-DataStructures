import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*Дедо Мраз преку целата година води список од деца кои биле добри и нивните адреси за да им достави подароци. 
 *Така е и со децата од Скопје, арно ама градот Скопје решил да менува називи на улици и Дедо Мраз во последен 
 *момент добива листа од изменети називи на улици за Скопје, Македонија. Проверете за дадено дете дали Дедо Мраз 
 *треба да му достави подарок (дали го има детето во списокот на добри деца) и ако треба на која адреса ќе му го 
 *достави. Дополнително за децата од Скопје да се испечати новата адреса доколку името на улицата е променето.

Влез: Во првата линија е даден број N на деца кои биле добри. Во наредните N линии се дадени името на детете и 
	  неговата адреса во посебни редови (Адресата е во формат ИмеНаУлица Број Град Држава).
	  Потоа е даден број M на улици од Скопје кои го промениле своите име. Во наредните M линии дадени прво
	  старите па новите имиња на улици разделени со празно место. Во последниот ред е дадено името на детете кое 
	  треба да се провери.
	  
Излез: Ако даденото дете не било добро (т.е. го нема во списокот на добри деца) да се испечати Nema poklon,
       а ако било добро да се испечати валидната адреса на која ќе се достави поклонот (т.е. ако името на 
       улицата е од Скопје, Македонија и се променило, да се испечати адресата со новиот назив на улицата).

Забелешка: При реализација на задачите МОРА да се користат дадените структури, а не да користат помошни 
           структури како низи или сл.*/
/*Пример влез
5
JohnDoe
DriveAvenue 231 NewYork USA
JaneDoe
GreenStreet 821 Chicago USA
PecePecevski
Vodnjanska 30 Skopje Macedonia
MartaMartevska
Vostanichka 81 Prilep Macedonia
EstebanPerez
InsurgentesSur 7325 MexicoCity Mexico
5
MarshalTito Makedonija
Vodnjanska MajkaTereza
Leninova Aminta3
MajkaTereza AdolfCiborovski
Vojvodina KiroGligorov
PecePecevski
Пример излез
MajkaTereza 30 Skopje Macedonia*/
class Adresa{
	public String ulica;
	public String broj;
	public String grad;
	public String drzava;
	
	public Adresa(String u, String b, String g, String d) {
		ulica = u;
		broj = b;
		grad = g;
		drzava = d;
	}
	
}
public class Hash6_DedoMraz_Podaroci {

	public static void main(String[] args)throws IOException {                           
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String,Adresa> tabela = new HashMap<String,Adresa>();
		HashMap<String,String> tabela2 = new HashMap<String,String>();
		
		for(int i = 0; i < n; i ++) {
			String ime = br.readLine();
			String [] tmp = br.readLine().split(" ");
			Adresa obj = new Adresa(tmp[0],tmp[1],tmp[2],tmp[3]);
			tabela.put(ime, obj);
		}
		
		int m = Integer.parseInt(br.readLine());

		for(int i = 0; i < m; i ++) {
			String [] smena = br.readLine().split(" ");
			String stara = smena[0];
			String nova = smena[1];
			tabela2.put(stara, nova);
		}
		String dete = br.readLine();
		//StringBuilder sb = new StringBuilder();
		if(tabela.containsKey(dete)) {
			Adresa adr = tabela.get(dete);
			if(tabela2.containsKey(adr.ulica)) {
				String nova = tabela2.get(adr.ulica);
				System.out.println(nova+" "+adr.broj+" "+adr.grad+" "+adr.drzava);
				//sb.append(nova);
			}
			else {
				System.out.println(adr.ulica+" "+adr.broj+" "+adr.grad+" "+adr.drzava);
				//sb.append(adr.ulica);
			}
		}
		else {
			System.out.println("nema poklon");
		}
		
		
	}

}
