# BlackjackProject

# Hi 👋, I'm Jacob Stuart
### Programming student with Skill Distillery

- I’m currently working on [BlackjackProject](https://github.com/VulcanMindForge/BlackjackProject)

- I’m currently learning **Java**

- All of my projects are available at [https://github.com/VulcanMindForge](https://github.com/VulcanMindForge)

# Description of this project
Simulate a friendly blackjack game with one deck between a dealer and a player. Dealer must follow Soft17 rules. 

# How to use this project
Program starts with one player and one dealer. The dealer passes out the natural cards, with both player cards showing and only one dealer card showing. The player is then prompted to hit or stand. Hit will get another card, Stand will proceed to the next player or the Dealers turn. The dealer is forced to hit if they are below 17 total. Any natural hand(the original two card hand), that equals 21 will be considered a blackjack. If a player goes over 21, they are considered to bust. They immediately lose. If the dealer busts, any player who did not bust is considered a winner. Winner pays their bet * 2. Blackjack winners pay out bet * 3. Card Values are listed below. 
2-10 value of card.
Jack, Queen, King are worth 10
Ace can be 11 or 1 as needed.

# Technologies Used
Overall I am learning and using Eclipse IDE to program in Java 1.8. Prior to this assignment we covered: Variables and Constants, Methods, Screen Output and Keyboard Input, Expressions, If/Else, Switch, While loops, For Loops, Cast Numerals, Packages, Stringbuilder, Objects, Classes, Superclasses, JUnit testing, TDD or Testing Driven Developement, UML class diagrams, Encapsulation, Inheritance in Java, Visibility, ASCII and Unicode Data. Abstract classes, Primitive Wrapper Classes, Interfaces, ArrayLists, Lists, Sets, Exceptions, Exceptions with JUnit, Input/Output Streams, Garbage Collection, Debugging Programs Overview.

**New since last project:** Regex(Regular Expressions). Map Interface. Sorting and Tuning Collections. Map Internal structure. Java Virtual Machine. More advanced Interfaces. Enumerated types.

# Current Progress
Initialized classes
Moved over reusable enums for a playing card deck. Includes:
Suit enum
Rank enum
Card class
Deck class
Created Repository and initial README
Finished creating abstract CardPlayer class
Created Blackjack Dealer and Player classes
Set methods for each class and implemented.
Implemented soft ace logic
Implemented Blackjack hand logic
Fixed loop
Added method for getting list of players from file. If list isn't created from file, single player is added.

# Next Steps
Implement method to veiw player name and bank.

# Lessons learned or reinforced on this project
When to use this() and this.
Calling methods of objectes initialized in a class field
ConcurrentModificationException error(first time seeing this one.)
Collections.
Class Encapsulation.


# Lessons to research
Other methods for storing initial variable value and recalling after the variable has been changed multiple times.
Further research JUNIT testing
Review and continue working on Error handling and debugging.
