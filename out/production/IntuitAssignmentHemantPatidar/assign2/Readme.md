# Assignment 2 – Sales CSV Analysis (Java Streams)

## Overview
This project reads a CSV file containing sales records and performs different analysis operations
using Java Streams. The CSV file is loaded into SalesRecord objects and processed to generate
summaries such as total revenue, revenue by region, units sold by product, and more.

## Data Format
The CSV file must contain the following columns:

region,product,quantity,price,date

Example row:
North,Phone,10,100.0,2024-01-10

Place the file as **sales.csv** in the project root directory.

## Features
- Load CSV into Java objects
- Total revenue calculation
- Revenue grouped by region
- Units sold by product
- Average price by region
- Top-selling products by revenue
- Monthly revenue summary
- JUnit tests provided

## Project Structure
assign2/
├── SalesRecord.java  
├── CsvReader.java  
├── Service.java  
├── Analysis.java  
└── ServiceTest.java

## How to Run
Navigate to the folder and compile the files:

When you want to use cvs file and run the ananlysis, Go to Analysis file and main method at there in edit configuration to take csv file as input from parameters or arguments and give the path src/assign2/sales.csv or if you want your own cvs then give the path of your cvs file.

Here is the sample output:
```

