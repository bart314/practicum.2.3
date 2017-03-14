package memoryleaks;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@SuppressWarnings("unused")
public class BabyBoomer {
	private final Date birthDate;
	
	public BabyBoomer(Date d) {
		this.birthDate = d;
	}

	// avoid creating unnecessary objects.
	// mow many objects are created in this method? And what is the 
	// effect on its execution time?
	protected boolean isBabyBoomer() {
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomStart = gmtCal.getTime();	
		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		
		Date boomEnd = gmtCal.getTime();
		return birthDate.compareTo(boomStart) >= 0 &&
		       birthDate.compareTo(boomEnd)   <  0;
	}

	public static void main(String[] args) {
		String bd = "1950-08-23"; //ISO8602
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDay = null;
		
		try {	
			birthDay = df.parse(bd);
		} catch(ParseException e) {
			System.out.println("error parsing date " + bd);
			e.printStackTrace();
		}

		BabyBoomer foo = new BabyBoomer(birthDay);
		BabyBoomerBetter bar = new BabyBoomerBetter(birthDay);
		
		boolean check = false;
		long startTime = System.currentTimeMillis();
		for (int i=0;i<10000000; i++) {
			check = foo.isBabyBoomer();
		}
		long exTime = System.currentTimeMillis()-startTime;
		System.out.println("Execution took " +exTime+ " milliseconds.");
	}
}
