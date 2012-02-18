Random Pair
===========
Create randomize pair from a set of entities

Scenario
--------
You are facing foosball competition for more than one seasons. There are lots of people registering for all seasons and you don't want to manually shuffle them to create each team. That would be waste of time.

Solution
--------
Random Pair receive those people in a list as a text file and giving this input, it can (randomize) create the team automatically.

Usage
-----
Compile it:

	javac src/com/ksetyadi/randompair/RandomPair.java
	
and then run:

	java com.ksetyadi.randompair.RandomPair < people_list.txt
	
Example
-------

EXAMPLE 1

Everyone has the same level so you want to randomly form them directly into the team.

Example Input:
Satya
Armanto
Ksetyadi
Robby
Yanbul
Ary
Levady
Wandre

Example Output:
Team #1: Robby - Satya
Team #2: Ksetyadi - Wandre
Team #3: Ary - Levady
Team #4: Yanbul - Armanto


EXAMPLE 2

Some people have different level. You want to team up those people so there is no team with both member have the same level.

Example Input:
#Satya
Armanto
Ksetyadi
#Robby
#Yanbul
Ary
#Levady
Wandre

Example Output:
Team #1: Levady - Wandre
Team #2: Robby - Ksetyadi
Team #3: Armanto - Satya
Team #4: Ary - Yanbul
