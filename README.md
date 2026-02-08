🍽️ Restaurant Menu Builder

Description:A Java project implementing the Builder Design Pattern using a Fluent Builder and Progressive Interfaces to construct restaurant menus step by step. The system enforces the correct order of menu creation, prevents invalid combinations (such as adding both dessert and coffee), and follows SOLID principles to ensure clean, maintainable, and extensible code.

📌 Exercise Statement

The goal is to design and implement a flexible system for building restaurant menus using the Builder pattern. The system must:

Allow step‑by‑step construction of a menu.

Enforce the correct order of operations (e.g., dessert cannot be added before the main course).

Use progressive interfaces to restrict available methods depending on the current step.

Prevent adding both dessert and coffee in the same menu.

Support optional elements such as:

Appetizer

Main course (with optional supplement)

Drink

Dessert or coffee

Allow marking dishes as vegan or gluten‑free using expressive fluent methods.

Support different menu types (full menu, kids menu, half menu, menus without drinks, etc.).

✨ Features

✔️ Fluent Menu Construction

Example:

new MenuBuilder()
    .withEntrant("Mediterranean Salad")
        .isVegan()
        .isGlutenFree()
    .withMainCourse("Beef Tenderloin")
        .withSuplement("Extra garnish")
    .withDessert("Chocolate mousse")
    .withDrink("Red wine")
    .finish()
    .build();

✔️ Progressive Interfaces

Choosing dessert returns a DessertStep interface.

Choosing coffee returns a CoffeeStep interface.

Both interfaces only allow calling finish(), preventing invalid combinations.

✔️ Order Validation

The system throws clear English exceptions if:

A drink is added before the main course

Dessert or coffee is added before the main course

An appetizer is added after the main course

✔️ Dish Properties

Fluent configuration methods:

isVegan()

isGlutenFree()

isMainVegan()

isMainGlutenFree()

withSuplement("...")

✔️ Unit Tests

JUnit tests validate:

Correct menu order

Interface restrictions

JSON output

Error handling

🛠 Technologies

Backend: Java

Testing: JUnit 5

JSON Handling: org.json

🚀 Installation & Execution

Clone the repository

git clone <repository-url>

Run the applicationExecute Main.java from your IDE (IntelliJ, Eclipse, VS Code).

Run tests

mvn test

or run tests directly from your IDE.

📸 Demo

Executive Menu Example

{
  "entrant": {
    "name": "Mediterranean Salad",
    "vegan": true,
    "glutenFree": true
  },
  "mainCourse": {
    "name": "Beef Tenderloin",
    "suplement": "Extra garnish"
  },
  "dessert": {
    "name": "Chocolate mousse"
  },
  "drink": "Red wine"
}

🧩 Diagrams & Technical Decisions

✔️ Builder Pattern

Used to construct complex menu objects step by step.

✔️ Progressive Interfaces

Guarantee that only valid methods are available at each stage of construction.

✔️ Runtime Validations

Ensure logical consistency and prevent invalid menu configurations.

✔️ JSON Output

Provides a clean, structured representation of the final menu.
