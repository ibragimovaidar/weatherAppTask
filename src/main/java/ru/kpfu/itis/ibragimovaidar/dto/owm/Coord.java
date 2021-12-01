package ru.kpfu.itis.ibragimovaidar.dto.owm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.ibragimovaidar.util.FlexibleFloatDeserializer;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coord {

	@JsonDeserialize(using = FlexibleFloatDeserializer.class)
	private Float lon;
	@JsonDeserialize(using = FlexibleFloatDeserializer.class)
	private Float lat;
}
