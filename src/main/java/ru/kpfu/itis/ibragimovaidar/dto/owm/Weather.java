package ru.kpfu.itis.ibragimovaidar.dto.owm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

	private Integer id;
	private String main;
	private String description;
	private String icon;
}
