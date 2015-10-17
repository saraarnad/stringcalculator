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
		if(number.equals("")){
			return 0;
		}
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    	return numbers.split("[,\n]");
	}
     	 
    	private static int sum(String[] numbers){
 	    	int total = 0;
		String negNum = "";
        	for(String number : numbers){
			int numb = toInt(number);
			if(numb < 1001){
		    		total += numb;
			}
			if(numb < 0) {
				negNum = negNum + number;
			}
			if(negNum.length() > 0){
				throw new IllegalArgumentException("Negatives not allowed: " + negNum){};
			} 
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
            	String delim = text;
		if(delim.substring(0, 3).equals("//[")){
			delim = delim.substring(3, delim.indexOf("]"));
		} else{
			delim = delim.substring(2, delim.indexOf("\n"));
            	}
		text = text.substring(text.indexOf("\n") + 1);
		text = text.replace(delim, ",");
		return text.split(",");
	} 

}







