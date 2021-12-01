package ru.kpfu.itis.ibragimovaidar.dto.owm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.ibragimovaidar.util.FlexibleFloatDeserializer;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {

	@JsonDeserialize(using = FlexibleFloatDeserializer.class)
	private Float speed;

	@JsonProperty("deg")
	private Integer degrees;
}
