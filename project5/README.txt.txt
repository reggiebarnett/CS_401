Traveling Salesman Problem
Reggie Barnett
November 2012

INTRODUCTION

This program attempts to find near-optimal tours for Euclicdean
Traveling Salesman problems.  Specifically, it starts with a random
tour of cities, then searches through 2-exchanges, stopping when it
finds a 2-optimal tour.

INSTALLATION

The following files should be present:

     City.java - Implements cities and their coordinates in the plane.
     Tour.java - Implements tours, tour lengths, and exchanges.
     Map.java  - Creates a JPanel to show a tour.
     TSP.java - Top-level program

USAGE

The file TSP.java has an example that creates a set of
cities with random locations and searches for a 2-optimal tour.
Compile and run with:

     javac TSP.java
     java TSP


PROBLEMS

No known problems.