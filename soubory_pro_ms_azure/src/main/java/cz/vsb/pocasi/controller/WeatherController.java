package cz.vsb.pocasi.controller;

import java.util.Collection;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.vsb.pocasi.City;
import cz.vsb.pocasi.connector.WeatherstackConnector;
import cz.vsb.pocasi.dto.WeatherDto;
import cz.vsb.pocasi.service.WeatherService;
@RestController
public class WeatherController {
	WeatherService service;
	@RequestMapping("/weather")
	public Collection<WeatherDto> getWeather() {
		ArrayList<WeatherDto> wdtos = new ArrayList<WeatherDto>();
		service = new WeatherService();
		for(City city: City.values())
		{
			WeatherDto weathewerDto = service.getWeatherForCity(city);
			wdtos.add(weathewerDto);
		}
		return wdtos;
	}
	
	@RequestMapping("/weather/{city}")
	@CrossOrigin
	public WeatherDto getWeatherForCity(@PathVariable String city) {
		City cityEnum = City.valueOf(city.toUpperCase());
		WeatherService service = new WeatherService();
		return service.getWeatherForCity(cityEnum);
	}
	@RequestMapping("/weather/bruntal")
	public String getWeatherForCity()
	{
		return "<h1>Bruntál nenalezen</h1> <img src='http://www.zubatezaby.cz/files/IMG_24.jpg' />";
	}
	
	@RequestMapping("/")
	public String home()
	{
		return "<h1>home sweet home</h1>";
	}
	
	
}
