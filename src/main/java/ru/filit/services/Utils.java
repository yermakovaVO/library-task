package ru.filit.services;

import lombok.extern.slf4j.Slf4j;

@Slf4j

public class Utils {

	public static String ERR = "Не удалось обработать запрос, в случае повтора ошибки обратитесь к администратору";




	public static Long processStringInput(String id) {
		try {
			Long idLong = Long.valueOf(id);
			return idLong;

		} catch (Exception e) {
			throw new RuntimeException(ERR);
		}
	}

}
