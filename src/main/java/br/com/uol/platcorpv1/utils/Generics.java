package br.com.uol.platcorpv1.utils;

import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Generics {

	public String removeAccents(String str) {	
	    return Normalizer.normalize(str.toLowerCase(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");	    
	}
	
	public String removeWhiteSpace(String string) {
		String patternStr = "\\s+";
		String replaceStr = "";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(string);
		string = matcher.replaceAll(replaceStr);		 
		return string;
	}
	
    public Date convertToDate(String pattern, String date) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public  String convertToPattern(String pattern, Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }
    
    public String convertToLocalDate(String pattern, LocalDate date) {
    	return DateTimeFormatter.ofPattern(pattern).format(date);
    }
}
