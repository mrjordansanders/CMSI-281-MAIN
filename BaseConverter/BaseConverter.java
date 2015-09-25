import java.util.*;

public class BaseConverter {
	
	public static boolean validArgs(String[] args){
		long targetBase = 0;
		
		//makes sure args is correct length
		if(args.length < 2 || args.length > 4) {
			throw new IllegalArgumentException();
		}

		// checks targetBase and originalBase are able to become longs
		try{
			long testOriginalBase = Long.parseLong(args[1]);
			if(args.length == 3){
				long testTargetBase = Long.parseLong(args[2]);
			}
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException();
		}
		
		//gets target base value and checks if its above 0, checks originalBase is above 0 as well
		long originalBase = Long.parseLong(args[1]);
		
		if(args.length == 2){
			targetBase = 10;
		} else if(args.length == 3){
			targetBase = Long.parseLong(args[2]);
		}
		
		//takes inputted numbers as strings, and puts them into an array of integers
		//tests if array of inputted numbers contains invalid values (less than 0, above base we're trying to convert to)
		String strInput = args[0].replaceAll("\\[","");
		String finalInput = strInput.replaceAll("\\]", " ");
		String[] parts = finalInput.split(" ");
		long[] numbers = new long[parts.length];
		
		for(int n = 0; n < parts.length; n++) {
			try{
				numbers[n] = Long.parseLong(parts[n]);
			} catch(NumberFormatException e) {
				throw new IllegalArgumentException();
			}
			if(numbers[n] < 0){
				throw new IllegalArgumentException();
			}
		}
		
		return true;
    }
	
	public static void main (String[] args) {
		
        if (!validArgs (args)){
            throw new IllegalArgumentException();
        } else {
			//to remake values from the above method
			long targetBase = 0;
			long toBaseTen = 0;
			long placeCounter = 0;
			double d = 0;
			
			if(args.length == 2){
				targetBase = 10;
			} else if(args.length == 3){
				targetBase = Long.parseLong(args[2]);
			}
			
			long originalBase = Long.parseLong(args[1]);
			
			String strInput = args[0].replaceAll("\\[","");
			String finalInput = strInput.replaceAll("\\]", " ");
			String[] parts = finalInput.split(" ");
			long[] numbers = new long[parts.length];
			
			for(int n = 0; n < parts.length; n++) {
				numbers[n] = Long.parseLong(parts[n]);
			}
			
			//conversion of input to base 10
			for(int z = numbers.length - 1; z >= 0; z--){
				d = Math.pow(originalBase, placeCounter);
				long multiplier = (new Double(d)).longValue();
				toBaseTen = toBaseTen + (numbers[z] * multiplier);
				placeCounter++;
			}

			//conversion of base 10 to desired base
            String remainder = "";
			String prelimRemainder = "";
			if(toBaseTen != 0){
				while(toBaseTen != 0) {
					prelimRemainder = new StringBuilder(Long.toString(toBaseTen % targetBase)).reverse().toString();
					remainder = remainder + "]" + prelimRemainder + "[";
					toBaseTen = (toBaseTen / targetBase);
				}
				System.out.println(new StringBuilder(remainder).reverse().toString());
			} else {
			System.out.println("[0]");
			}
        }
    }
}
