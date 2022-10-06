package ru.job4j.weather.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.job4j.weather.entity.Weather;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    private final Map<Integer, Weather> weathers = new ConcurrentHashMap<>();

    {
        weathers.put(1, new Weather(1, "Msc", 20));
        weathers.put(2, new Weather(2, "SPb", 15));
        weathers.put(3, new Weather(3, "Bryansk", 14));
        weathers.put(4, new Weather(4, "Smolensk", 13));
        weathers.put(5, new Weather(5, "Kiev", 28));
        weathers.put(6, new Weather(6, "Minsk", 15));
    }

    public Mono<Weather> findById(int id) {
        return Mono.justOrEmpty(weathers.get(id));
    }

    public Flux<Weather> all() {
        return Flux.fromIterable(weathers.values());
    }

    public Mono<Weather> getHottestCity() {
        Weather weather = null;
        Optional<Weather> result = weathers.values().stream()
                .max(Comparator.comparing(Weather::getTemperature));
        if (result.isPresent()) {
            weather = result.get();
        }
        return Mono.justOrEmpty(weather);
    }

    public Flux<Weather> getCityGreatThen(int temp) {
        List<Weather> list = weathers.values().stream().filter(x -> x.getTemperature() > temp)
                .collect(Collectors.toList());
        return Flux.fromIterable(list);
    }
}