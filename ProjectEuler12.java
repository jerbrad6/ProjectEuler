import java.util.Arrays;


public class ProjectEuler12 {


	public static void main(String[] args) {
		int[] triNum= new int[100000];
		for (int i=1; i<=100000; i++) {
			int x=i*(i+1)/2;
			triNum[i-1]=x;
		}
		//System.out.println(triNum[15]);
		int[] prime= new int[10000];
		int[] divides= new int[10000];
		int n=1;
		int index=0;
		int test=0;
		for (int i=2; (i-n)<=10000; i++) {
			for (int j=2; j<=Math.sqrt(i); j++) {
				int k=i%j;
				if (k<=0) {
					n++;
					test++;
					j=(int)Math.sqrt(i);
				} 
			}
			if (test==0) {
				prime[index]=i;
				index++;
			}
			test=0;
		}
		//System.out.println(prime[1]);
		int divisors=1;
		for (int i=0; i<100000; i++) {
			int d=triNum[i];
			for (int j=0; j<10000; j++) {
				while (d%prime[j]==0 && d>0) {
					d=d/prime[j];
					divides[j]++;
				}
				divisors = divisors*(divides[j]+1);
				}
			//System.out.println(divisors);
			if (divisors>500) {
				System.out.println(triNum[i]);
				break;
			} else {
				divisors=1;
				Arrays.fill(divides, 0);
			}
				
		}

	}

}
