package ru.filit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class AuthorUpdateDto extends AuthorCreateDto {


	@NotEmpty
	private String id;


	public AuthorUpdateDto(String nickname, String name, String surname, String midname, String id) {
		super(nickname, name, surname, midname);
		this.id = id;
	}

	@Override
	public String toString() {
		return " AuthorUpdateDto{"
				+ " id: " + this.id
				+ " name: " + super.getName()
				+ " surname: " + super.getSurname()
				+ " midname: " + super.getMidname()
				+ " nickname: " + super.getNickname()

				+ '}';
	}


}
