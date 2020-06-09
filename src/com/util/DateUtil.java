package com.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * ��¥�� �����ϴ� ���� �Լ���
 *
 * @author Marco Jakob
 */
public class DateUtil {

	/** ��ȯ�� ���Ǵ� ��¥ �����̴�. ���ϴ� ��� �ٲ㵵 ����. */
	private static final String DATE_PATTERN = "dd.MM.yyyy";

	/** ��¥ ��ȯ�� */
	private static final DateTimeFormatter DATE_FORMATTER =
			DateTimeFormatter.ofPattern(DATE_PATTERN);

	/**
     * �־��� ��¥�� String Ÿ������ ��ȯ�Ѵ�. ������ ������
     * {@link DateUtil#DATE_PATTERN}�� ���ȴ�.
     *
     * @param date the date to be returned as a string
     * @return formatted string
     */
    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    /**
     * String�� {@link DateUtil#DATE_PATTERN}�� ������ ���
     * {@link LocalDate} ��ü�� ��ȯ�Ѵ�.
     *
     * String�� ��ȯ���� ������ null�� ��ȯ�Ѵ�.
     *
     * @param dateString the date as String
     * @return the date object or null if it could not be converted
     */
    public static LocalDate parse(String dateString) {
        try {
        	return DATE_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     * ��ȿ�� ��¥���� �˻��Ѵ�.
     *
     * @param dateString
     * @return true if the String is a valid date
     */
    public static boolean validDate(String dateString) {
    	// Try to parse the String.
    	return DateUtil.parse(dateString) != null;
    }
}