package com.rizstien.algos;

public class ModularExponentiation {
    public static int Mod(int A, int B, int C) {
        if(A==0) return 0;
        if(B==0) return 1;
        long y;
        if(B%2==0){
            y = Mod(A,B/2,C);
            y = (y*y)%C;
        }else{
            y = A%C;
            y = (y*(Mod(A,B-1,C))%C)%C;
        }
        return (int)(y+C)%C;
    }
	public static void main(String[] args) {
		System.out.println(Mod(71045970,41535484,64735492));
	}

}
