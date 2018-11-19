package RSA;

import java.math.BigInteger;

public class RSA {
    public static void main(String[] args) {

        int p = 43, q = 61, n = p * q, f = (p - 1) * (q - 1), e = 11, d=2291;
        StringBuilder array = new StringBuilder();
        // e,n - for encode
        // d,n - for decode
        String example = "Дарова";
        System.out.println("Original text: " + example);
        //ENCODING
        for (char symbol: example.toCharArray()){
            BigInteger z = BigInteger.valueOf(symbol).pow(e).mod(BigInteger.valueOf(n));
            array.append(z).append(" ");
        }
        System.out.println(array);

        //DECODING
        StringBuilder dearr = new StringBuilder();
        for (String c : array.toString().split(" ")) {
            BigInteger h = new BigInteger(c);
            h = h.pow(d).mod(BigInteger.valueOf(n));
            dearr.append((char) h.intValue());
        }
        System.out.println("Decode result: " + dearr);

    }
}
