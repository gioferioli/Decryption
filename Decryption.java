import java.util.Scanner;
public class decryption {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String message = sc.nextLine();
		String LCmessage= message.toLowerCase();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int[] counter1 = new int[26];
		int[] counter2 = new int[26];
		int shift1 = 0;
		int shift2 = 0;
		for(int i = 0;i<LCmessage.length();i=i+2) {
			int index1 = alphabet.indexOf(LCmessage.charAt(i));
			if(index1!=-1) {
			char character1 = LCmessage.charAt(i);    
			int ascii1 = (int)character1;
			counter1[ascii1-97]+=1;
			}
		}
		
		for(int k = 1;k<LCmessage.length();k+=2) {
			int index2 = alphabet.indexOf(LCmessage.charAt(k));
			if(index2 != -1) {
			char character2 =  LCmessage.charAt(k);    
			int ascii2 = (int)character2;
			counter2[ascii2-97]+=1;
			}
		}
		int efreq1= frequency1(counter1) ;
		int efreq2= frequency2(counter2) ;
		
		for(int w = 0;w<LCmessage.length();w+=2) {
			if(efreq1>4) {
				shift1 = efreq1-4;
		}
			shift1 = 4-efreq1;
			int t1= (int)LCmessage.charAt(w);
			int NL2 = shift1+t1;
			char h1 = (char)NL2;
			LCmessage = LCmessage.substring(0,w)+ h1 + LCmessage.substring(w+1); 
			}
		for(int f = 1;f<LCmessage.length();f+=2) {
			if(efreq2>4) {
				shift2 = efreq2-4;
		}
			shift2 = 4-efreq2;
			int t2= (int)LCmessage.charAt(f);
			int NL2 = shift2+t2;
			char h2 = (char)NL2;
			LCmessage = LCmessage.substring(0,f)+ h2 + LCmessage.substring(f+1); 
			}
		System.out.print(LCmessage);
		}
	


	public static int frequency1(int[] a) {
		int k = 0;
		for(int i = 0;i<a.length;i++) {
				if(a[i]>k) {
					k = i;
				}
				
		}
		return k;
	}
	public static int frequency2(int[] a) {
		int e = 0;
		for(int i = 0;i<a.length;i++) {
				if(a[i]>e) {
					e = i;
				}
		}
		return e;
	}
}
