package ru.filit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ListDataDto {


	@JsonProperty("offset")
	private int offset;

	@JsonProperty("limit")
	private int limit;

}
