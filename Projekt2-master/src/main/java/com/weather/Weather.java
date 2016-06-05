package com.weather;

import com.eclipsesource.json.JsonObject;
import com.github.dvdme.ForecastIOLib.ForecastIO;

import java.util.Date;

/**
 * Created by szymon.wolak on 2016-05-27.
 */
public class Weather {


    /**
     * This is the method which is connecting to API and downloading the current weather for selected place.
     * We are choosing place by providing the Coordinates.
     * @return generatedWeather
     */
    public JsonObject getWeather(){
        ForecastIO fio = new ForecastIO("afa3723b72070e1425fe75005493ec93"); //instantiate the class with the API key.
        fio.setUnits(ForecastIO.UNITS_SI);             //sets the units as SI - optional
        fio.setExcludeURL("minutely");             //excluded the minutely and hourly reports from the reply

        String firstCord = "52.229676";
        String secondCord = "21.012228999999934";
        fio.getForecast(firstCord, secondCord);

        System.out.println(fio.getCurrently());
        JsonObject generatedWeather  = fio.getCurrently();


        return generatedWeather;
    }


    /**
     * This is the method which is filling entities with downloaded data.
     * @param generatedWeather
     * @param weatherEntity
     * @return weatherEntity
     */
    public WeatherEntity fillFieldsForDB(JsonObject generatedWeather, WeatherEntity weatherEntity) {
        Date data = new Date();
        String currentData = data.toString();
        String summary = generatedWeather.get("summary").toString();
        String precipIntensity = generatedWeather.get("precipIntensity").toString();
        String precipProbability = generatedWeather.get("precipProbability").toString();
        String temperature = generatedWeather.get("temperature").toString();
        String dewPoint = generatedWeather.get("dewPoint").toString();
        String humidity = generatedWeather.get("humidity").toString();
        String windSpeed = generatedWeather.get("windSpeed").toString();
        String windBearing = generatedWeather.get("windBearing").toString();
        String visibility = generatedWeather.get("visibility").toString();
        String pressure = generatedWeather.get("pressure").toString();
        String ozone = generatedWeather.get("ozone").toString();

        weatherEntity.setLogin("User15");
        weatherEntity.setDate(currentData);
        weatherEntity.setCord1("52.229676");
        weatherEntity.setCord2("21.012228999999934");
        weatherEntity.setSummary(summary);
        weatherEntity.setPrecipIntensity(precipIntensity);
        weatherEntity.setPrecipProbability(precipProbability);
        weatherEntity.setTemperature(temperature);
        weatherEntity.setDewPoint(dewPoint);
        weatherEntity.setHumidity(humidity);
        weatherEntity.setWindSpeed(windSpeed);
        weatherEntity.setWindBearing(windBearing);
        weatherEntity.setVisibility(visibility);
        weatherEntity.setPressure(pressure);
        weatherEntity.setOzone(ozone);
        return weatherEntity;
    }


    public static void main(String[] args) {
            Weather ab = new Weather();
            ab.getWeather();
        }
    }
