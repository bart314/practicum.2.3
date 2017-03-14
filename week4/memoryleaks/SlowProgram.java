package memoryleaks;

public class SlowProgram {
	// prefer primitives to boxes primitives (which are objects)
	// watch out for unintentional autoboxing.
	
	public static void main (String[] args) {
//		ArrayList<Long>
//		long[] 
		
		Long sum = 0L;
		long startTime = System.currentTimeMillis();
		for (int i=0; i<Integer.MAX_VALUE;i++) {
			sum+=i;
		}
		long exTime = System.currentTimeMillis() - startTime;
		System.out.println(sum);
		System.out.println("Execution took " +exTime+ " milliseconds.");
	}

}
