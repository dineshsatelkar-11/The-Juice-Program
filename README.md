# The-Juice-Program
You decide to throw a party for your best friends.
But your friends are very particular about their fitness, and each of them has exact calorie intake limits.  Nothing more and nothing less. And, Since you want to be an excellent host , you plan to make sure they each get their exact limit!
You decide to make a specific fruit juice-mix for each of your friends using the different freshly squeezed fruit juices you have in your cupboard. The completed fruit juice-mix for your friend will have total calorie content value equal to the sum of the calorie contents of the individual fruit juices. 
To make a fruit juice-mix, you decide to use any of the fruit juices that appear in you cupboard shelf. The same fruit juice can appear multiple times and can also be used as many times as it appears. 
Though there are multiple ways to choose these juices to make the fruit juice-mix following the rules given above, you just want to pick one particular combination. So you decide to choose only the set of fruit juices that must appear IN AN ALPHABETICALLY ORDERED list of fruit juices which satisfy the calorie constraints. 
Input:
````
The inputs for your algorithm appear in the following lines:
•	LINE 1 - The first line has the number of friends you have invited for the cocktail party. (Maximum is 200 friends you could invite.)
•	LINE 2 - The first variable is an integer, say ‘m’ between 1 and 26 which denotes the number of unique fruit juices on the shelf.  This variable is separated by a space followed by positive integers from the set {1, 2, 3, 4…….100} describing the calorie content for each fruit juice in an alphabetically sorted list of unique fruit juices. For example, the first value corresponds to calories for Fruit A, the second to Fruit B and so on.
•	LINE 3 - contains a sequence of lower case English alphabets which signify the NAME of the fruit juice that is actually on the cupboard (you can have multiple bottles of the same juice and in any order)
•	LINE 4 - contains a positive integer which specifies the exact calorie intake requirement of your friend.
````

#### Input Type is File
````Select Input Type
1 for File
2 for User Input
1
***********************************
Friend No 1 Juice content:-
SORRY, YOU JUST HAVE WATER
Friend No 2 Juice content:-
{3,  4}
Fruit Combination : ab
Friend No 3 Juice content:-
{5,  5,  5}
Fruit Combination : aaa

````
#### Input Type is User Input
````Select Input Type
1 for File
2 for User Input
2
Enter No of Friends
1
Enter No of unique fruit juices 
2
Enter calorie content each unique fruit juices separated by comma
3,4
Enter sequence for fruit juice in cupboard
baba
***********************************
Friend No 1 Juice content:-
7
{3,  4}
Fruit Combination : ab
````
