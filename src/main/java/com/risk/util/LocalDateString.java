package com.risk.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class LocalDateString {
	public String localDateToString(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return (date).format(formatter);

	}

	public LocalDate stringToLocalDate(String date) {
		return LocalDate.parse(date);

	}
}
