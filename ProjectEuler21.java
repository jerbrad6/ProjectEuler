import java.util.Arrays;

//Problem 21: Evaluate the sum of all the amicable numbers under 10000.
public class ProjectEuler21 {
	private static long startTime = System.currentTimeMillis();

	public static void main(String[] args) {
		//Generates Array of Primes
		int[] prime= new int[1229]; //only need primes up to 10000
		int n=1;
		int index=0;
		int test=0;
		for (int i=2; (i-n)<=1229; i++) {
			for (int j=2; j<=Math.sqrt(i); j++) {
				int k=i%j;
				if (k==0) {
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
		
		//use primes to find prime factorization and sum of divisors
		int [] divides= new int[1229]; //Number of times each prime divides a number
		int [] sumOfDivisors= new int[10000]; //Sum of divisors for i at index i
		int total=0;
		int sum=1;
		index=1;
		for (int i=2; i<=10000; i++) {
			int d=i;
			for (int j=0; j<1229; j++) {   //find prime factorization for i
				while (d%prime[j]==0 && d>1) {
					d=d/prime[j];
					divides[j]++;
				}	
			}
			for (int j=0; j<1229; j++) {  //use Number theory formula for sum of divisors
				sum*=(Math.pow(prime[j], divides[j]+1)-1)/(prime[j]-1);
			}
			if (sum-i<i) { //only check if sum of divisors of i is less than i
				if (sumOfDivisors[sum-i-1]==i) { //check if amicable pair
					total=total+i+sum-i; //add both to total (only happens once)
				}
			}
			Arrays.fill(divides,0); //reset divisors array
			sumOfDivisors[index]=sum-i; //store number of divisors
			sum=1;
			index++;
		}
		System.out.print("The sum of all amicable numbers less than 10000 is: ");
		System.out.println(total);
        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) + " milliseconds.");

	}

}
