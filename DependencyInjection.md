# Dependency Injection (DI)
* DI is part of the SOLID [D], Dependency Inversion, principle from OOP design patterns.
* It is used to implement inverse of control, where the flow of an application is inverted.
* We create the dependent object outside of the class and provide those objects to the class in different ways.
* DI moves the creation and binding of the dependent objects outside of the class that depends on them.

## Why?
- Reusability of code and decoupling of dependencies
  - It's easier to swap out implementations of a dependency. Code reuse is improved because of inversion of control, and classes no longer control how their dependencies are created, but instead work with any configuration.
- Ease of refactoring
  - The dependencies become a verifiable part of the API surface, so they can be checked at object-creation time or at compile time rather than being hidden as implementation details.
- Ease of testing
  - A class doesn't manage its dependencies, so when you're testing it, you can pass in different implementations to test all of your different cases.


## Fundamentals of DI
* DI allows the objects to be loosely coupled in a way that objects (B,C,D) are injected from outside of another object (A) that requires it, instead of constructing the object within object (A)


## Two major ways to do manual DI
1. Constructor Injection
   * pass the dependencies of a class to its contructor
2. Field Injection (Setter Injection)
   * dependencies are instantiated after the class is created


## Automated dependency injection
* Dagger
* Hilt


## Alternatives to dependency injection
* Service Locator design pattern


## Hilt
* Hilt is built on top of Dagger

### Hilt Application Class
* All apps that use Hilt must contant an Application class that is annotated with **@HiltAndroidApp**
  
>       @HiltAndroidApp
> 
>       public class ExampleApplication extends Application { ... }
>

### Inject dependencies into Android classes
* Once Hilt is setup in the **Application** class and an application level component is available, Hilt can provide dependencies to other Android classes that have the **@AndroidEntryPoint** annotation:

>       @AndroidEntryPoint
>
>       public class ExmapleActivity extends AppCompatActivity{ ... }
>

* Hilt currently supports the following Android classes:
  * Application
  * ViewModel
  * Activity (Hilt only supports activities that extend ComponentActivity, ex: AppCompatActivity)
  * Fragment (Hilt only supports fragments that extend androidx.Fragment)
  * View
  * Service
  * BroadcastReceiver

* If you annotate an Android class with **@AndroidEntryPoint**, then you also must annotate Android classes that depend on it. For instance, if you annotate a fragment, then you must also annotate any activities where you use that fragment.

* To obtain dependencies from a component, use the **@Inject** annotation to perform field injection:
  >         @AndroidEntryPoint
  > 
  >         public class ExampleActivity extends AppCompatActivity {
  >
  >             @Inject
  >             AnalyticsAdapter analytics;
  > 
  >             ...
  > 
  >         }
* This tells the Hilt that an AnalyticsAdapter will be field injected by the bindings/provides in Hilt's **@Module**.

### Hilt Dagger Modules
* Dagger module is a class that is annotated with **@Module**, this module tells Dagger how to provide an instance of a class:

>       @Module
> 
>       public class NetworkModule {
> 
>            @Provides
>            public LoginRetrofitService provideLoginRetrofitService() {
>   
>                   return new RetrofitBuilder().baseUrl("https://example.com").build().create(LoginService.class);
> 
>               }
> 
>       }



# Reference
* https://developer.android.com/training/dependency-injection/hilt-android#java