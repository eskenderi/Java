# Java Thread Synchronization Using Semaphores
In this project I provided a solution to a given Thread synchronization problem using the Semaphore class. 
To synchronize the threads I used binary and counting semaphores.

## Problem Specification
### The Adventurers and the Green Dragon 
 
**There** is a town, famous for its magical jewelry shop and for the green-dragon that lives on a nearby mountain.  
Many adventurers come to the shop and bring various items (stones, rings, necklaces, earrings) that can be combined together into more powerful objects.  
A precious stone can be combined with a ring to make a magical ring, or with a chain to make a magical necklace, or with an earring to make a magical earring.
An adventurer may have a number of items that result in one or more magical jewels (the number of each item is randomly generated as an integer number between 0 and 3).
Every adventurer has the goal of leaving the town once he has accumulated a small fortune in magical rings, earrings and necklaces of size fortune_size.
If an adventurer has enough items to make a complete magical ring, or necklace, or pair of earrings (at least one precious stone and ring, or one precious stone and chain, or two precious stones and two earrings), he goes directly to the jewelry shop (simulate the trip to the shop by using sleep(random_time).
At the shop door the adventurer sets his variable need_assistance(i) to true and busy waits until a clerk is ready to serve him.   
There are num_clerks but one line of adventurers. 
A clerk should pick the next waiting adventurer in a mutual exclusion fashion (this can be done from inside of a synchronized method) and in a FCFS order.     
Any adventurer that doesn’t have enough items to create a complete magical jewel, or that didn’t accumulate his fortune yet, goes to the mountain to battle the dragon.
Adventurers gather at the dragon’s cave and wait (simulated by a sleep of a very long time) for the dragon to be available. 
The dragon randomly interrupts one of the adventurers. The dragon loves to play dice.
The dragon’s game of dice is a simple one – the most points win.If the dragon loses to an adventurer, it has to give up a random item (precious stone, or ring, or chain, or earring).  If the adventurer doesn’t get the item that he needs for a complete magical jewel, he will wait again for another chance to fight the dragon.  When the adventurer has the right items to create a magical jewel, he must go back to the jewelry shop. 
If the adventurer loses, the dragon, being very happy about his victory, will allow the adventurer to increase his priority for a very short time and play one more game. After the game the adventurer will immediately reset his priority back to the default value and will allow another adventurer to fight the dragon.
Once the adventurer achieves his goal by collecting the desired number of magical jewels, he is ready to go home with his treasure.
However each adventurer must join the previous adventurer in sequence.The clerks will terminate as well. 
Using Java programming, synchronize the three types of threads: adventurer, clerk, dragon in the context of the problem.  
The number of adventurers (num_adv) and fortune size (fortune_size) must be entered as command line arguments. 
Default values:  
```
num_adv = 6 
fortune_size = 5 
num_clerk = 2 
```
### Prerequisites

For this project to execute you will need to install Java in your machine.


### Running
The project was originally build using Eclipse IDE. The project can be directly imported to eclipse through the ".project" file.
In case eclipse isn't available on your machine you can start a Command Prompt on Windows (Terminal in Linux). Make sure the path is set to the "src" folder and execute the following
commands:

```
javac *.java
java Main.class
```
## Running the tests
An output example is available inside the *OutputExample.txt* file

### License

See the LICENSE file for details
