package com.weatherAPI.weatherAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//
@SpringBootApplication
public class WeatherApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApiApplication.class, args);
	}

}
@RestController
class WeatherController {

	private final String apiKey = "17b8c85f4fb181c92144e3807877a2d1";
	private final String baseUrl = "https://api.openweathermap.org/data/2.5/weather";

	private final RestTemplate restTemplate;

	public WeatherController() {
		this.restTemplate = new RestTemplate();
	}

	@GetMapping("/weather")
	public Weather getWeatherByCity(@RequestParam String city) {
		String apiUrl = baseUrl + "?q=" + city + "&appid=" + apiKey;
		return restTemplate.getForObject(apiUrl, Weather.class);
	}
}

class Weather {
	private String name;
	private Main main;

	public String getName() {
		return name;

	}

	public void setName(String name) {
		this.name = name;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}


	public class Main {
		private double temp;
		private double feelslike;
		private double mintemp;
		private double maxtemp;

		public double getTemp() {
			return temp;

		}

		public void settemp(double temp) {
			this.temp = temp;
		}

		public double getFeelslike() {
			return feelslike;
		}

		public void setFeelslike(double feelslike) {
			this.feelslike = feelslike;
		}

		public double getMintemp() {
			return mintemp;

		}

		public void setMintemp(double mintemp) {
			this.mintemp = mintemp;
		}

		public double getMaxtemp() {
			return maxtemp;
		}

		public void setMaxtemp(double maxtemp) {
			this.maxtemp = maxtemp;
		}
	}
}
