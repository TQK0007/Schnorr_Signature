package model;

import java.math.BigInteger;
import java.util.Random;

public class taoKhoa {

	private long p;
	private long q;
	private long d;
	private long e1;
	private static Random rand = new Random();
	public taoKhoa() {
		
	}
	public taoKhoa(long p, long q, long d, long e1) {
		this.p = p;
		this.q = q;
		this.d = d;
		this.e1 = e1;
	}
	public long getP() {
		return p;
	}
	public void setP(long p) {
		this.p = p;
	}
	public long getQ() {
		return q;
	}
	public void setQ(long q) {
		this.q = q;
	}
	public long getD() {
		return d;
	}
	public void setD(long d) {
		this.d = d;
	}
	public long getE1() {
		return e1;
	}
	public void setE1(long e1) {
		this.e1 = e1;
	}
	
	public boolean soNguyenTo(long number)
	{
		if(number < 2) return false;
		for(int i=2;i<=Math.sqrt(number);i++)
		{
			if(number % i == 0)
			{
				return false;
			}
		}
		return true;
	}
	
	public long randomP()
	{
		while(true)
		{
			p = rand.nextLong(900000L)+10000L;
			if(soNguyenTo(p)) break;
		}
		return p;
	}
	
	public long randomQ()
	{
		while(true)
		{
			q = rand.nextLong(90000L)+1000L;
			if(soNguyenTo(q)) break;
		}
		return q;
	}
	
	public long randomD()
	{
		return d = rand.nextLong(q-1)+1000L;
	}
	
	public long randomE1()
	{
		while(true)
		{
			e1 = rand.nextLong(p+1)+50001L;
			BigInteger E1, P;
			E1 = new BigInteger(String.valueOf(e1));
			P = new BigInteger(String.valueOf(p));
			if(E1.modPow(P, P).intValue() == 1) break;
		}
		return e1;
	}
	
	public long E2()
	{
		BigInteger E1, D, P;
		E1 = new BigInteger(String.valueOf(e1));
		D = new BigInteger(String.valueOf(d));
		P = new BigInteger(String.valueOf(p));
		return E1.modPow(D, P).longValue();
	}
}
