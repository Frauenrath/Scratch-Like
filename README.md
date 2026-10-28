# ScratchLike – Visual Programming Editor & Interpreter

## What is the application for?

**ScratchLike** is an educational programming application inspired by Scratch. It allows users to graphically compose sequences of instructions to visually control the movements and behavior of a "turtle" on a graphical canvas. Designed as a language interpreter, the system features a complete algorithmic engine capable of dynamically managing variables (declaration, assignment, incrementation), complex control structures like nested loops, and a real-time monitoring module to intercept and raise runtime errors (*Runtime Errors*).

---

## Key Features

1. ### Algorithmic Engine & Variable Management

- **Typed declaration:** Mandatory declaration area at the beginning of the program for integer variables (`VAR_DECLARATION`), natively initialized to `0`.
- **Data mutators:** Direct assignment actions (`VAR_ASSIGNMENT`) and increment/decrement actions (`INCREMENT_VARIABLE`) supporting literal values or other variables.
- **Control structures:** Implementation of repetitive loops (`REPEAT` ... `END_REPEAT`) supporting complex nesting and the use of variables as counters.

### 2. Graphical Interface & Execution (JavaFX)
- **Dynamic editor:** Ability to inject or insert a new instruction in the middle of an existing program, after the selected action.
- **Smart UI controls:** Contextual appearance of `+` / `-` increment buttons when configuring literal values, automatically disappearing in favor of a variable name.
- **Execution modes:** Switching between a Manual execution mode (step-by-step) and an Automatic mode managed by a variable speed slider (*Slider*).
- **Real-time monitoring area:** Display panel showing at each step the turtle's position (X, Y), orientation angle, drawing status (pen up/down), and symbol table (real-time values of all variables).

### 3. Persistence & Security (`.scr` Parsing)
- **Format:** Textual serialization and deserialization of program blocks in `.scr` format (e.g., `VAR_ASSIGNMENT;nb;45`, `REPEAT;nb`).
- **Runtime error management:** Immediate execution flow interruption and display of clear graphical exceptions if an uninitialized variable or corrupted value is called during movement.

---

## Technologies Used

- **Main language:** Java (Object-Oriented Design: abstract classes, polymorphism, state enumerations)
- **Graphical Interface:** JavaFX
- **Architectural Design Pattern:** **MVVM (Model-View-ViewModel)** ensuring strict decoupling between business logic, data models, and View Data Binding.
- **Data synchronization:** JavaFX events and `ObservableList` reactive structures for synchronous updates of the Canvas and State area.
- **Build & Development Tools:** IntelliJ IDEA, Git

---

## How to Use the Application?

### Prerequisites
- **Java Development Kit (JDK) 17** or higher.

### Launching the Project
1. **Download the project as a zip file and extract it**
2. **Run the executable LaunchApp.jar**

### Writing and Running a Program
1. **Declare variables:** Add the `VAR_DECLARATION` action at the very beginning of your script to configure your variables (e.g., `nb`, `step`).
2. **Assign values:** Use assignment blocks to configure your movement variables.
3. **Create loops:** Wrap your movements (`MOVE_FORWARD`, `TURN_LEFT`) between a `REPEAT` block and an `END_REPEAT` block.
4. **Control speed:** Adjust the speed slider (*Slider*), then click **Execute (Automatic Mode)** to observe the turtle's path in real time.
5. **Save:** Use the export menu to generate your `.scr` script file.

---

## Architectural Choices & Delivery Note

- **MVVM Pattern:** Entire business logic (calculating turtle trajectories, variable symbol table) is isolated from JavaFX graphical components. The ViewModel acts as a bridge through property binding (*Property Binding*).
- **Loop management:** To prevent side effects, a strict business rule prohibits modifying the value of a variable inside a loop if that same variable serves as a counter for said loop.

---
*Collaborative academic project carried out with two other peers at EPFC as part of the IT Applications Architecture module.*

## Screenshots

![main-menu.png](Screenshots/main-menu.png)
