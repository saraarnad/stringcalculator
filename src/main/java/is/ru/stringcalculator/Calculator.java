package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",") || text.contains("\n")){
			if(checkIfDelim(text)){
				return sum(splitDelim(text));
			}
			return sum(splitNumbers(text));
		}
		else
			return toInt(text);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    	return numbers.split("[,\n]");
	}
     	 
    	private static int sum(String[] numbers){
 	    	int total = 0;
        	for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    	}

	private static boolean checkIfDelim(String text){
		if(text.length() >= 2){
			if(text.substring(0,2).equals("//")){
			return true;
			}
		}
		return false;
	}

	private static String[] splitDelim(String text){
            	String delim = text.substring(2, text.indexOf("\n"));
            	text = text.substring(text.indexOf("\n") + 1);
		
		return text.split(delim);
	} 
}
