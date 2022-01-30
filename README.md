# CLEAN Architecture with MVVM and Jetpack-Compose.

## About the app
I have created this small app to showcase my skills. Launching screen in an app will show you the list of random animals and you will see the new random list if you do swipe to refresh into it.

## Code structuring approach

1. MVVM separates your view (i.e. Activitys and Composable) from your business logic. MVVM is enough for small projects, but when your codebase becomes huge, your ViewModels start bloating. Separating responsibilities becomes hard.

2. MVVM with Clean Architecture goes one step further in separating the responsibilities of your code base. It clearly abstracts the logic of the actions that can be performed in your app.

### CLEAN Architecture:

First of all the layers in CLEAN architecture has been separated into individual modules in a single Android project. For example android modules like `app`, `presentation`, `data` and `domain`. Notice the dependency of these modules, as per the depedency rule of CLEAN architecture, all the dependencies directly or indirectly point towards the the domain layer. The domain layer incorporates `Entities`, `Use-cases` and interfaces required to cross boundaries, `Repository` in this case. The `Data` layer handles data and communicates with data source `remote` in this case, to provides required data requested by the `presentation` layer. `View` layer will observe on the `presentation` layer's stateFlow object, to get the updated data on state change.

Having separate modules is not necessary, you can create all the layers in the app modules itself. Having separate modules and depending on the intended modules prevent accidental usage of a classes in unintended places. There are also couple of benefits mentioned below.


<img src="screenshot/Clean_Arch.png" alt="CLEAN Architecture in Android" style="float: left; margin-right: 10px;">

### Reason for using CLEAN architecture

- Your code will be even more easily testable than with plain MVVM
- Your code will be further decoupled
- The project will be even easier to maintain.
- Your team can add new features even more quickly.
- Inner layer module dont know about outer layer, hence, outer data formats can’t be used in inner layer
- Dependencies can only point inwards (from concretions towards abstractions)
- The project will point towards Stability
- Your code will point towards Abstractions

## Libraries

- **Jetpack-Compose: For view and design to give modern looks and feel.
- **Kotlin-Coroutine-Flow**:for asynchronous task, reactive programming, mapping, transformation.
- **Hilt**: for Dependency Injection
- **Compose-Navigation**: for switching between screens
- **Retrofit**: Netwoking Library
- **ViewModel**: For persisting data across configuration changes
- **Expresso, Mockk, Junit** - For testing
- **Coil** - for Image loading

## App screenshot

<img src="screenshot/Booking_List.png" width="250"/> <img src="screenshot/Booking_details.png" width="250"/><img src="screenshot/Parking_Location_On_Map.png" width="250"/>
