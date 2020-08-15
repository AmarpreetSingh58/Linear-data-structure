package hashTable;
import java.util.Random;
import java.util.Scanner;

public class test {
	
	// Function to generate n random strings of length 10
	public static String randomStringGen(int len) {
		String pattern = "abcdefghijklmnopqurstuvwxyz";
		String s = "";
		
		Random r = new Random();
		for (int i = 0; i <len;i++)
		s =s+pattern.charAt(r.nextInt(pattern.length()));
		return s;
	}
	
	// Function to perform cuckoo hashing: insertion, searching and deletion
	public static void runCuckoo(int n) {
		
		System.out.println("Running Cuckoo");
		
		CuckooHashTable<String> H = new CuckooHashTable<>( new StringHashFamily( 3 ),n);
		
		int j;
		long start,end, avgTime;
		
		start = System.nanoTime();//System.currentTimeMillis();
		for (j = 0;j<n;j++) {
			H.insert(randomStringGen(10));
		}
		
		end = System.nanoTime();//System.currentTimeMillis();
		avgTime = (end - start)/n;
		
		System.out.println("Average Time taken for insertion = "+avgTime);
		
		String s;
		start = System.nanoTime();
		for (j =0;j<n;j++) {
			s  = randomStringGen(10);
			if(H.contains(s))
				H.remove(s);
		}
		end = System.nanoTime();
		
		avgTime = (end - start)/n;
		
		System.out.println("Average Time taken for Searching and deleting the particular item = "+avgTime+"\n");
		
		
	}
	
	//Function to perform Quadratic Probing: insertion, searching and deletion
	public static void runQuadProbing(int n){
		System.out.println("Running Quadratic Probing");
		int j;
				
		QuadraticProbingHashTable<String> H = new QuadraticProbingHashTable<>( );
		
		long start,end,avgTime;
		
		start = System.nanoTime();
		for(j = 0;j<=n;j++)
			H.insert(randomStringGen(10));
		end = System.nanoTime();
		avgTime = (end - start)/n;
		
		System.out.println("Average Time taken for each insertion : "+avgTime);
		
		String s;
		start = System.nanoTime();
		for (j =0;j<=n;j++) {
			s = randomStringGen(10);
			if(H.contains(s))
				H.remove(s);
		}
			
		end = System.nanoTime();
		avgTime = (end - start)/n;
		
		System.out.println("Avergae time taken for each search and deletion : "+avgTime+"\n");
	}
	
	//Function to perform Separate chaining Probing: insertion, searching and deletion
	public static void runseparateChainingProbe(int n) {
		
		System.out.println("Running Separate Chaining Probing");
		
		int j;
		
		SeparateChainingHashTable<String> H = new SeparateChainingHashTable<>( );
		
		long start,end,avgTime;
		
		start = System.nanoTime();
		for(j=0;j<=n;j++)
			H.insert(randomStringGen(10));
		end = System.nanoTime();
		avgTime = (end-start)/n;
		System.out.println("Average Time taken for each insertion : "+avgTime);
		
		String s;
		
		start = System.nanoTime();
		for(j=0;j<=n;j++) {
			s = randomStringGen(10);
			if(H.contains(s))
				H.remove(s);
		}
		end = System.nanoTime();
		avgTime = (end - start)/n;
		
		System.out.println("Avergae time taken for each search and deletion : "+avgTime+"\n");
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 for(int i =1;i<=20;i++) {
			 int n = (int)Math.pow(2, i);
			 
			 System.out.println("Value of n : "+n);
			 runCuckoo(n);
			 runQuadProbing(n);
			 runseparateChainingProbe(n);
			 System.out.println('\n');
		 }

	}

}
