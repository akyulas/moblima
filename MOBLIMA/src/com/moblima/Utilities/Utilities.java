package com.moblima.Utilities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilities {
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public static String breakLines(String input, int maxLineLength) {
        String SPLIT_REGEXP= "\\s+";
        String SPACE_SEPARATOR = " ";
        String NEWLINE = "\n";
        String[] tokens = input.split(SPLIT_REGEXP);
        StringBuilder output = new StringBuilder(input.length());
        int lineLen = 0;
        for (int i = 0; i < tokens.length; i++) {
            String word = tokens[i];

            if (lineLen + (SPACE_SEPARATOR + word).length() > maxLineLength) {
                if (i > 0) {
                    output.append(NEWLINE);
                }
                lineLen = 0;
            }
            if (i < tokens.length - 1 && (lineLen + (word + SPACE_SEPARATOR).length() + tokens[i + 1].length() <=
                    maxLineLength)) {
                word += SPACE_SEPARATOR;
            }
            output.append(word);
            lineLen += word.length();
        }
        return output.toString();
    }
	
	public static String timeToString(LocalDateTime localDateTime) {
		return localDateTime.format(formatter);
	}
	
	public static String dateToString(LocalDate localDate) {
		return localDate.format(dateFormatter);
	}
	
	public static DateTimeFormatter getDateFormatter() {
	    return dateFormatter;
    }

    public static DateTimeFormatter getDateTimeFormatter() {
	    return formatter;
    }
	
}
