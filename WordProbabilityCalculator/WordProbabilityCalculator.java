import java.io.*;
import java.util.*;

public class WordProbabilityCalculator {

    public static List<String> calculateWordProbabilities(String text, HashSet<String> stopWords) {
        String[] words = text.toLowerCase().split("\\s+");
        List<String> filteredWords = new ArrayList<>();

        for (String word : words) {
            if (word.matches("[A-Za-z0-9]+") && !stopWords.contains(word)) {
                filteredWords.add(word);
            }
        }
        return filteredWords;
    }

    public static void main(String[] args) {

        String folderPath = "documents";
        String stopwordsFilePath = "stopwords.txt";

        try {
            HashSet<String> stopWords = new HashSet<>(loadStopWords(stopwordsFilePath));
            Map<String, Integer> allWordCounts = new HashMap<>();

            File folder = new File(folderPath);
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader(file));
                            StringBuilder documentText = new StringBuilder();
                            String line;

                            while ((line = reader.readLine()) != null) {
                                documentText.append(line).append(" ");
                            }

                            List<String> filteredWords = calculateWordProbabilities(
                                    documentText.toString(), stopWords);

                            for (String word : filteredWords) {
                                allWordCounts.put(word, allWordCounts.getOrDefault(word, 0) + 1);
                            }

                            reader.close();
                        } catch (IOException e) {
                            System.err.println("Error reading file: " + e.getMessage());
                        }
                    }
                }

                int totalWords = allWordCounts.values().stream().mapToInt(Integer::intValue).sum();

                List<Map.Entry<String, Integer>> sortedWordCounts = new ArrayList<>(allWordCounts.entrySet());
                sortedWordCounts.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

                List<Map.Entry<String, Integer>> topWords = sortedWordCounts.subList(0,
                        Math.min(5, sortedWordCounts.size()));

                System.out.println("Top 5 words across all documents:");
                for (Map.Entry<String, Integer> entry : topWords) {
                    String word = entry.getKey();
                    int count = entry.getValue();
                    double probability = (double) count / totalWords;
                    System.out.printf("  Word: %s, Probability: %.4f, Count: %d%n", word, probability, count);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading stopwords file: " + e.getMessage());
        }
    }

    public static List<String> loadStopWords(String filePath) throws IOException {
        List<String> stopWords = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            stopWords.add(line.trim());
        }

        reader.close();
        return stopWords;
    }
}
