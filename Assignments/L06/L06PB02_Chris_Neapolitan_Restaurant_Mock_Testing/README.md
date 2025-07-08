# Chris' Neapolitan Restaurant

Ever since the opening of Aniruddh’s restaurant (FoodPalace), the food and beverage market in Artemis City has been disrupted. The existing best place in town, Chris’ restaurant (PizzaHeaven), has seen huge fluctuations in the number of pizzas they sold, mainly because more and more people now want curry, etc.

Luckily, the management of PizzaHeaven consists of stellar and excellent employees (they graduated from TUM nonetheless…) and they devised a new plan to reassure market dominance in Artemis City. Their plan consists of two major steps:

1. **Increase the quality of PizzaHeaven's food:** Customers have been complaining about takeaway orders not coming boxed and sometimes getting the wrong type of pizza. For that, we want you to implement tests to help Chris increase the quality of his joint.

2. **Decrease the quality of Aniruddh's food:** Their second step is a rather dirty one. The management plans on infiltrating Aniruddh’s FoodPalace. Luckily, because of Covid-19, there is a huge demand for employees in food and beverages and PizzaHeaven can easily send an employee to sabotage Aniruddh’s curry production. Chris has now asked you to send a malicious employee to Food Palace to sabotage the curry production.

## Part 1: Background

The PizzaHeaven management team wants to start as soon as possible and hired you as an expert to help them implement their strategy. Since they don’t want to waste precious days of not being able to sell pizza, they provided you with a quick overview of your most important tools for the job:

- [JUnit](https://www.baeldung.com/junit-5)
    - `assertEquals()`: This method is used to check whether two values are equal. It's a static method in the Assert class, accepting two arguments (expected value and actual value), and it asserts that both are equal. If they are not, the test fails. There is an optional third argument where you can specify a message that will be printed if the test fails.
    - `assertThrows()`: This is a method used to assert if a specific exception is thrown. It accepts two parameters: the type of exception class expected, and an executable (typically a lambda) where the exception is expected to be thrown. If the specified exception is not thrown in the executable, the test fails.
    - `@Test`: This is an annotation used to mark a method as a test method. When the JUnit test runner encounters a method annotated with @Test, it executes that method as a test case. You can optionally specify parameters such as expected exceptions and timeouts.
- [EasyMock](https://www.baeldung.com/easymock)
    - `@Mock`: This is an annotation used to create a mock object of a class or an interface. The object created can then be used to define expectations and verify the behavior of the class under test. It simplifies the mock object creation process by eliminating the need to manually create mock objects.
    - `@TestSubject`: This annotation is used to identify the class that is going to be tested. The class marked with this annotation will have its dependencies (fields marked with @Mock or @InjectMocks annotations) automatically injected by EasyMock.
    - `expect()`: This method is used to set up expected behavior of a mock object. It takes as a parameter the method call you're setting the expectation for. It's often used in a chain with a method like andReturn() or andThrow() to define what should happen when the method is called.
    - `replay()`: This method is used to change the state of the mock object from record state to replay state. In the record state, we can record the expected behavior of mock objects, and once all the expected behavior is recorded, we switch the mock object to replay state. Now, the mock object can be used in the test scenario and it will behave as per the expectations recorded earlier

## Part 2: Increase the quality of food

To increase the quality of their pizzas, the management of Chris’ Neapolitan Pizza tasked you to provide the following two quality assurance tests:

1. **Ensure that the correct type of pizza gets baked within testThatTheCorrectTypeOfPizzaIsCreated**

2. **Make sure that pizzas for delivery get boxed in testThatTakeawayPizzasAreBoxed**

## Part 3: Infiltrate the FoodPalace

For the last task to ensure the market dominance of Chris’ Neapolitan Pizza, you have the following task:

1. Look into the `FoodPalace` class to realize how unqualified employees won’t be able to prepare curry.

2. **Now, find a way using EasyMock to pretend that an employee is qualified in the infiltrateAniruddhsRestaurant method within the PizzaHeavenTest class. Make sure that the mock behaves exactly as the  class expects.**