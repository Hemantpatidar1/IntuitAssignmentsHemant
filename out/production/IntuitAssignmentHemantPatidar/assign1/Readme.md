# Assignment 1 – Producer Consumer (Java)

## Overview
This assignment implements the Producer–Consumer problem using a bounded shared buffer.
A producer thread adds items to the buffer and a consumer thread removes them. The buffer
uses wait() and notifyAll() for thread coordination.

## Features
- Bounded shared buffer using synchronized, wait, notifyAll
- Producer thread adding items from a source list
- Consumer thread removing items and storing them in a destination list
- Stop signal ("END") used to terminate the consumer safely
- JUnit tests included

## Project Structure
assign1/
├── Share.java
├── Producer.java
├── Consumer.java
├── Main.java
└── ProducerConsumerTest.java

## How the Program Works
- Producer reads values and puts them in the shared buffer
- Consumer takes values from the buffer
- If the buffer is full, producer waits
- If the buffer is empty, consumer waits
- When producer finishes, it sends “END” to stop the consumer

## How to Run
Go to Main file in assign1 package and run the main method.

Here is a sample output:
```[Producer] Producing: M
[Producer] Producing: N
[Producer] Producing: O
[Producer] Producing: P
[Producer] Producing: Q
[Consumer] Consumed: M
[Consumer] Consumed: N
[Consumer] Consumed: O
[Consumer] Consumed: P
[Producer] Sent stop signal.
[Consumer] Consumed: Q
[Consumer] Consumed: END
[Consumer] Received stop signal. Exiting.
Final destination content: [M, N, O, P, Q]
Buffer size after completion: 0

```