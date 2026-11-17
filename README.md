# StudyProjectTwo

**StudyProjectTwo** — Android-приложение для просмотра прогноза погоды, построенное на современном стеке Android-разработки с применением принципов чистой архитектуры (Clean Architecture).

Приложение получает данные о погоде из открытого API [Open-Meteo](https://open-meteo.com/) для города Челябинск (55.4636°N, 65.3431°E) и предоставляет прогнозы на 16 дней вперёд.

## Основные возможности

- **Прогноз на 16 дней** — отображение максимальной температуры на каждый день
- **Детальный просмотр дня** — температура и условия погоды по периодам: утро, день, вечер, ночь
- **Информация о ветре** — средняя скорость ветра (м/с) для каждого периода
- **Анимированный лоадер** — кастомная анимация дождевого облака при загрузке данных
- **Автоматическое обновление** — данные автоматически обновляются каждые 20 минут через WorkManager
- **Виджет на экран** — виджет Android Glance с текущим прогнозом на домашнем экране
- **Оффлайн-доступ** — данные кэшируются в локальную базу Room

## Архитектура

Проект следует **Clean Architecture** с тремя слоями:

```
com.example.studyprojecttwo
├── presentation/          # UI слой (MVVM)
│   ├── MainActivity.kt
│   ├── dailyWeatherForecast/
│   └── detailedWeatherForecast/
├── domain/                # Бизнес-логика (Use Cases)
│   ├── модели
│   └── use cases
├── data/                  # Слой данных
│   ├── Repository
│   ├── Worker (WorkManager)
│   └── dataSource/
│       ├── Retrofit API
│       └── Room Database
├── widget/                # Android Glance Widget
└── ui/theme/              # Jetpack Compose Theme
```

### Слой Presentation (MVVM)
- **MainActivity** — точка входа, навигация через Jetpack Navigation Compose
- **ViewModel** — управление состоянием через `StateFlow`, Hilt-инъекция зависимостей
- **Compose-экраны** — `DailyWeatherForecastScreen` и `DetailedWeatherForecastScreen`

### Слой Domain
- Чистые бизнес-объекты без Android-зависимостей
- Use Cases: получение детального прогноза, наблюдение за данными, обновление, периодическое обновление

### Слой Data
- **Repository** — единая точка доступа к данным, оркестрация remote/local
- **Retrofit** — REST-клиент для Open-Meteo API
- **Room** — локальное хранилище с двумя сущностями (daily и detailed forecast)
- **WorkManager** — фоновое обновление данных с требованием сетевого подключения

## Стек технологий

| Технология | Версия | Назначение |
|---|---|---|
| **Kotlin** | 2.2.10 | Язык разработки |
| **AGP** | 8.9.1 | Android Gradle Plugin |
| **Jetpack Compose** | BOM 2026.02.01 | Современный UI-фреймворк |
| **Material 3** | — | UI-компоненты |
| **Hilt** | 2.57.2 | Dependency Injection |
| **KSP** | 2.2.10-2.0.2 | Kotlin Symbol Processing |
| **Room** | 2.8.4 | Локальная база данных |
| **Retrofit** | 2.9.0 | HTTP-клиент |
| **kotlinx.serialization** | 1.7.3 | JSON-сериализация |
| **WorkManager** | 2.11.2 | Фоновые задачи |
| **Jetpack Glance** | 1.1.0 | Home Screen Widget |
| **Navigation Compose** | 2.9.0 | Навигация между экранами |

## Структура проекта

```
app/src/main/java/com/example/studyprojecttwo/
├── WeatherApplication.kt          # Application class, Hilt setup
├── presentation/
│   ├── MainActivity.kt             # Навигационный хост
│   ├── dailyWeatherForecast/
│   │   ├── DailyWeatherForecastViewModel.kt
│   │   ├── DailyWeatherForecastScreen.kt
│   │   ├── DailyWeatherForecastItem.kt
│   │   └── dailyWeatherForecastLoader/
│   │       ├── Loader.kt
│   │       ├── RainCloud.kt
│   │       └── RainDrop.kt
│   └── detailedWeatherForecast/
│       ├── DetailedWeatherForecastViewModel.kt
│       ├── DetailedWeatherForecastScreen.kt
│       ├── DetailedWeatherForecastTemperatureItem.kt
│       ├── WindForecastItem.kt
│       └── AdvertisingBannerItem.kt
├── domain/
│   ├── DailyWeatherForecast.kt
│   ├── DetailedWeatherForecast.kt
│   ├── WeatherInfoShort.kt
│   ├── WeatherInfoAdvanced.kt
│   ├── Precipitation.kt
│   ├── GetDetailedWeatherForecastUseCase.kt
│   ├── ObserveDailyWeatherForecastUseCase.kt
│   ├── UpdateWeatherForecastUseCase.kt
│   └── StartPeriodicUpdateWeatherForecastUseCase.kt
├── data/
│   ├── WeatherForecastRepository.kt
│   ├── WeatherForecastWorker.kt
│   └── dataSource/
│       ├── WeatherForecastRemoteDataSource.kt
│       ├── WeatherForecastService.kt
│       ├── WeatherForecastResponse.kt
│       ├── WeatherForecastMapper.kt
│       └── dataBase/
│           ├── WeatherForecastDataBase.kt
│           ├── Converters.kt
│           ├── EntityDailyWeatherForecast.kt
│           ├── EntityDetailedWeatherForecast.kt
│           ├── EntityWeatherInfoShort.kt
│           ├── EntityWeatherInfoAdvanced.kt
│           ├── EntityPrecipitation.kt
│           ├── DailyWeatherForecastDao.kt
│           └── DetailedWeatherForecastDao.kt
├── widget/
│   ├── CurrentWeatherWidget.kt
│   ├── CurrentWeatherWidgetContent.kt
│   ├── CurrentWeatherWidgetReceiver.kt
│   ├── CurrentWetherAction.kt
│   └── CurrentWidgetWorker.kt
└── ui/theme/
    ├── Color.kt
    ├── Theme.kt
    └── Type.kt
```

## Лицензия

Учебный проект.
