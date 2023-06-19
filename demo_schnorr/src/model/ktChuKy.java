package model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ktChuKy {

	public BigInteger V(String m, long e1, long e2, BigInteger s1, BigInteger s2, long p)
	{
		BigInteger E1, E2, P, Du, Tich1, Tich2, V;
		E1 = new BigInteger(String.valueOf(e1));
		E2 = new BigInteger(String.valueOf(e2));
		P = new BigInteger(String.valueOf(p));
		Tich1 = E1.modPow(s1, P);
		Tich2 = E2.pow(s2.intValue()).modInverse(P);
		Du = Tich1.multiply(Tich2).mod(P);
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
        
        V = new BigInteger(sb.toString(),16);
        return V;
		
	}
	
	public void kt(BigInteger s1, BigInteger v)
	{
		if(s1.compareTo(v) == 0)
		{
			System.out.println("chu ky hop le");
		}
		else
		{
			System.out.println("chu ky khong hop le");
		}
	}
	
}
