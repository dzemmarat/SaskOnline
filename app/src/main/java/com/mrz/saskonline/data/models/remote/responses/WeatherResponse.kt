package com.mrz.saskonline.data.models.remote.responses

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    val main: Main,
    val weather: MutableList<Weather>,
    //"2022-02-12 21:00:00"
    val dt_txt: String
)

data class Main(
    val temp: Float,
)

data class Weather(
    val description: String
)

// {
//    "cod": "200",
//    "message": 0,
//    "cnt": 1,
//    "list": [
//        {
//            "dt": 1644688800,
//            "main": {
//                "temp": -3.6,
//                "feels_like": -7.13,
//                "temp_min": -4.96,
//                "temp_max": -3.6,
//                "pressure": 1015,
//                "sea_level": 1015,
//                "grnd_level": 1000,
//                "humidity": 83,
//                "temp_kf": 1.36
//            },
//            "weather": [
//                {
//                    "id": 804,
//                    "main": "Clouds",
//                    "description": "пасмурно",
//                    "icon": "04n"
//                }
//            ],
//            "clouds": {
//                "all": 100
//            },
//            "wind": {
//                "speed": 2.37,
//                "deg": 280,
//                "gust": 4.54
//            },
//            "visibility": 10000,
//            "pop": 0,
//            "sys": {
//                "pod": "n"
//            },
//            "dt_txt": "2022-02-12 18:00:00"
//        }
//    ],
//    "city": {
//        "id": 498677,
//        "name": "Саратов",
//        "coord": {
//            "lat": 51.5667,
//            "lon": 46.0333
//        },
//        "country": "RU",
//        "population": 863725,
//        "timezone": 14400,
//        "sunrise": 1644639376,
//        "sunset": 1644674647
//    }
//}