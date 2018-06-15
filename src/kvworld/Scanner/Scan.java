package kvworld.Scanner;

import java.util.Scanner;

public class Scan {
	Scanner sc;
	int P1;
	String S2;
	
	public Scan() {
		sc = new Scanner(System.in);
	}
	
	public int getNum() {
	    P1 = sc.nextInt();
	    return P1;
	}
	
	public String getString() {
	    S2 = sc.nextLine();
	    return S2;
	}
}
