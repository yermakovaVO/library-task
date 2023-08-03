package ru.filit.services;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoggingService {

	@Autowired
	private HttpServletRequest httpServletRequest;

	public void logIncomingRequest(String request) {
		String rq = httpServletRequest.getRequestURI();

		String BASE_LOG_MSG = "Вызван контроллер %s, входные параметры: ";

		log.info(String.format(BASE_LOG_MSG, rq) + request);


	}

}
