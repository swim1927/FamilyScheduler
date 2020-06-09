package com.util;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * LocalDate�� ISO 8601 �� ��ȯ�� �ϴ� JAXB �����
 * String�� '2012-12-03' ���� ��¥�� ��Ÿ����.
 *
 * @author Marco Jakob
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

	@Override
	public LocalDate unmarshal(String v) throws Exception {
		return LocalDate.parse(v);
	}

	@Override
	public String marshal(LocalDate v) throws Exception {
		return v.toString();
	}
}