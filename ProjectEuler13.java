import java.util.*;
import java.io.*;
public class ProjectEuler13 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		File numbers=new File("50dignumbers.txt");
		Scanner fileScan= new Scanner(numbers);
		String[] s= new String[100];
		for (int i=0; i<s.length; i++) {
			s[i]=fileScan.nextLine();
		}
		int [][] nums=new int[100][50];
		for (int i=0; i<100; i++) {
			String t= s[i];
			for (int j=0; j<50; j++) {
				nums[i][j]= (int)t.charAt(j)-48;
			}
		}
		
		for (int i = 0; i < 100; i++) {
		    for (int j = 0; j < 50; j++) {
		        System.out.print(nums[i][j] + " ");
		    }
		    System.out.print("\n");
		}
		
		
		int [] sums= new int[100];
		for (int i=49; i>=0; i--) {
			for (int j=0; j<100; j++) {
				sums[49-i]+=nums[j][i];
			}
		}
		System.out.println(Arrays.toString(sums));
		for (int i=0; i<100; i++) {
			if (sums[i]>9) {
				sums[i+1]+=sums[i]/10;
				sums[i]=sums[i]%10;
			}
		}
		System.out.println(Arrays.toString(sums));
		int max=0;
		for (int i=99; i>=0; i--) {
			if (sums[i]!=0) {
				max=i;
				break;
			}
		}
		for (int i=0; i<10; i++) {
			System.out.print(sums[max-i]);
		}

	}

}