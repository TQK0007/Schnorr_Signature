package model;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		taoKhoa taoKhoa = new taoKhoa();
		long p,q,d,e1,e2;
		p = taoKhoa.randomP();
		q = taoKhoa.randomQ();
		d = taoKhoa.randomD();
		e1 = taoKhoa.randomE1();
		e2 = taoKhoa.E2();
		
		taoChuKy taoChuKy = new taoChuKy();
		System.out.println("Nhap thong diep: ");
		String m = sc.nextLine();
		taoChuKy.setM(m);
		long r = taoChuKy.randomR();
		BigInteger s1 = taoChuKy.S1(e1, p);
		BigInteger s2 = taoChuKy.S2(d, q, s1);
		
		ktChuKy kt = new ktChuKy();
		BigInteger v = kt.V(m, e1, e2, s1, s2, p);
		kt.kt(s1, v);
		System.out.println("p = "+p);
		System.out.println("q = "+q);
		System.out.println("d = "+d);
		System.out.println("e1 = "+e1);
		System.out.println("e2 = "+e2);
		System.out.println("r = "+r);
		System.out.println("s1 = "+s1);
		System.out.println("s2 = "+s2);
		System.out.println("v = "+v);
		
	}

}
