# scala-exercises

A collection of exercises I produced while trying to learn the Scala language

# How-to

## Prerequisites

- All the examples have been tested with **Scala 2.11.8**
- to build and run the examples you will need [SBT - The interactive build tool](http://www.scala-sbt.org/)

## Run the examples

To try out the examples:

- open a terminal in the project folder
- open SBT by entering `sbt` command
- the **`run`** command:
    - compiles the sources
    - opens a prompt asking which example you want to run

In the following example session we'll execute `Ex1_Collections` exercise:

```
$ sbt
[info] Loading project definition from /home/ddefranciscis/scala-exercises/project
[info] Set current project to scala-exercises (in build file:/home/ddefranciscis/scala-exercises/)
> run
[warn] Multiple main classes detected.  Run 'show discoveredMainClasses' to see the list

Multiple main classes detected, select one to run:

 [1] Ex1_Collections
 [2] Ex2_Collections

Enter number: 1

[info] Running Ex1_Collections 
======================================================================
List Basics

List of strings:
List(GOOGL, MSFT, ORCL, IBM, AAPL)
List manipulation:
List(orcl, msft, ibm, googl, aapl)
======================================================================
Find top closing title - sequential version

Retrieving quotes for symbol GOOGL...
...done (GOOGL)
Retrieving quotes for symbol MSFT...
...done (MSFT)
Retrieving quotes for symbol ORCL...
...done (ORCL)
Retrieving quotes for symbol IBM...
...done (IBM)
Retrieving quotes for symbol AAPL...
...done (AAPL)
Top closing value by "Alphabet Inc." (GOOGL): $ 717.78
======================================================================
Find top closing title - parallel version

Retrieving quotes for symbol GOOGL...
Retrieving quotes for symbol MSFT...
Retrieving quotes for symbol ORCL...
Retrieving quotes for symbol IBM...
Retrieving quotes for symbol AAPL...
...done (GOOGL)
...done (ORCL)
...done (MSFT)
...done (AAPL)
...done (IBM)
Top closing value by "Alphabet Inc." (GOOGL): $ 717.78
[success] Total time: 10 s, completed 11-lug-2016 17.32.21 
```
