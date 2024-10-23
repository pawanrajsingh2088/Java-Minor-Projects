# Word Probability Calculator

This repository contains three implementations of a Word Probability Calculator in different programming languages: Java. The calculator analyzes a collection of text documents, calculates the probability of each word occurring, and displays the top 5 words with their probabilities and counts.

## Java Implementation

### Dependencies

- Java 8 or higher

### How to Run

1. Compile the Java code:
   ```bash
   javac WordProbabilityCalculator.java
   ```

2. Run the Java program:
   ```bash
   java WordProbabilityCalculator
   ```

## Stopwords

All implementations use a list of English stopwords to filter out common words. You can customize the list by modifying the `stopwords.txt` file.

## Directory Structure

- `documents`: Place your text documents in this directory for analysis.
- `stopwords.txt`: Customize the list of stopwords here.

## Output

All implementations will display the top 5 words across all documents, including each word's probability and count.


