package com.moblima.Utilities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utilities is a class that is used to provide utilities that other classes can use.
 */
public class Utilities {

    /**
     * The date and time formatter for local date time in the format yyyy-MM-dd HH:mm:ss.
     */
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * The date and time formatter for local date in the format yyyy-MM-dd.
     */
	private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * This is used to break lines if the output is too long.
     * @param input The input string.
     * @param maxLineLength The max length of a sentence.
     * @return The output string that has been modified to be easier to read.
     */
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

    /**
     * Returns a string from a given Local Date Time.
     * @param localDateTime The local date time that needs to be converted to a string.
     * @return String from a given Local Date Time.
     */
	public static String timeToString(LocalDateTime localDateTime) {
		return localDateTime.format(formatter);
	}

    /**
     * Returns a string from a given Local Date Time.
     * @param localDate The local date that needs to be converted to a string.
     * @return String from a given Local Date Time.
     */
	public static String dateToString(LocalDate localDate) {
		return localDate.format(dateFormatter);
	}

    /**
     * Returns the local date formatter.
     * @return Local date formatter.
     */
	public static DateTimeFormatter getDateFormatter() {
	    return dateFormatter;
    }

    /**
     * Returns the local date time formatter.
     * @return Local date time formatter.
     */
    public static DateTimeFormatter getDateTimeFormatter() {
	    return formatter;
    }
	
}
