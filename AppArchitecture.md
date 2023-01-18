# App Lifecycle


# App Architecture
## MVC (Model-View-Controller)
* Model - data that we needs to retrieve
* View - UI to display
* Controller - query and retrieve data from model to view

## MVP (Model-View-Presenter)
* Model - data that we needs to retrieve
* View - UI to display
* Presenter - interacts with view and model

## Difference between MVC and MVP
* Coupling: view and the model are tightly coupled in MVC but loosely coupled in MVP
* Communication: In MVP, communication between View-Presenter and Presenter-Model happens via an Interface. However, the controller and view layers falls in the same activity/fragment in MVC
* User Input: In MVC, user inputs are handled by the controller that instructs the model for further operations. But in MVP, user inputs are handled by the view that instructs the presenter to call appropriate functions
* Type of Relation: A Many-to-One relationships exists between the controller and view. One controller can select different views based upon required operations in MVC. On the other hand, the presenter and view have a One-to-One relationship in MVP, where one presenter class manages one view at a time
* Main Component: In MVC, the controller is in charge. It creates the appropriate view and interacts with the model according to the user's request. On the contrary, in MVP, the view is in charge. The view call methods on the presenter, which further directs the model
* Unit Testing: Due to tight coupling, MVC has limited support for unit testing, but in MVP, unit testing is well supported

## MVVM (Model-View-ViewModel)
* Model - data that we needs to retrieve
* View - UI to display
* View-Model - view binds to a VM, VM responsible to do logic based on view requests and get it from model.
