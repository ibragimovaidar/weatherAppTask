package ru.kpfu.itis.ibragimovaidar.dto.owm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.ibragimovaidar.util.FlexibleFloatDeserializer;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {

	@JsonDeserialize(using = FlexibleFloatDeserializer.class)
	private Float temp;

	@JsonDeserialize(using = FlexibleFloatDeserializer.class)
	@JsonProperty("feels_like")
	private Float feelsLike;

	@JsonDeserialize(using = FlexibleFloatDeserializer.class)
	@JsonProperty("temp_min")
	private Float tempMin;

	@JsonDeserialize(using = FlexibleFloatDeserializer.class)
	@JsonProperty("temp_max")
	private Float tempMax;

	private Integer pressure;

	private Integer humidity;

}
