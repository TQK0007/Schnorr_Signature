package model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class taoChuKy {

	private String m;
	private long r;
	private Random rand = new Random();
	
	public taoChuKy(String m, long r) {
		super();
		this.m = m;
		this.r = r;
	}
	public taoChuKy() {
		super();
	}
	public String getM() {
		return m;
	}
	public void setM(String m) {
		this.m = m;
	}
	public long getR() {
		return r;
	}
	public void setR(long r) {
		this.r = r;
	}
	
	public long randomR()
	{
		return r = rand.nextLong(10000L)+1000L;
	}
	
	public BigInteger S1(long e1, long p)
	{
		BigInteger E1,P,R,S1, Du;
		E1 = new BigInteger(String.valueOf(e1));
		P = new BigInteger(String.valueOf(p));
		R = new BigInteger(String.valueOf(r));
		Du = E1.modPow(R, P);
		String text = m + Du.longValue();
		StringBuffer sb = new StringBuffer();
        try {
            // Create SHA-1 Hash
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(text.getBytes());
            byte[] byteData = md.digest();
            
            // Convert byte array to hexadecimal format
            
            for (int i = 0; i < byteData.length; i++) {
                String hex = Integer.toHexString(0xff & byteData[i]);
                if (hex.length() == 1) sb.append('0');
                sb.append(hex);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        S1 = new BigInteger(sb.toString(),16);
        return S1;
	}
	
	public BigInteger S2(long d, long q, BigInteger s1)
	{
		BigInteger R, D, Q, Tong, Du;
		R = new BigInteger(String.valueOf(r));
		D = new BigInteger(String.valueOf(d));
		Q = new BigInteger(String.valueOf(q));
		Du = D.multiply(s1).mod(Q);
		Tong = R.add(Du);
		return Tong;
	}
	
}
