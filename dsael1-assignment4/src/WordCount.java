import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 
 * @author David Saelee
 * @version
 */
public class WordCount {

    /**
     * @throws FileNotFoundException
     * 
     */

    public void run(final Scanner input, final int number) throws FileNotFoundException {

        List<String> list = readWords(input);

        WordWithCount[] res = null;

        long startTime;
        long endTime;
        long totalTime;

        long minTimeHash = -1;
        Map<String, Integer> hash = new HashMap<String, Integer>();

        for (int i = 0; i < 10; i++) {
            startTime = System.currentTimeMillis();
            hash.clear();
            getCount(list, hash);
            res = getTopN(number, hash);
            endTime = System.currentTimeMillis();
            totalTime = endTime - startTime;
            if (minTimeHash == -1 || totalTime < minTimeHash) {
                minTimeHash = totalTime;
            }
        }

        long minTimeTree = -1;
        Map<String, Integer> tree = new TreeMap<String, Integer>();

        for (int i = 0; i < 10; i++) {
            startTime = System.currentTimeMillis();
            tree.clear();
            getCount(list, tree);
            res = getTopN(number, tree);
            endTime = System.currentTimeMillis();
            totalTime = endTime - startTime;
            if (minTimeTree == -1 || totalTime < minTimeTree) {
                minTimeTree = totalTime;
            }
        }

        System.out.println("The total number of words in the text file: " + list.size());
        System.out.println();

        for (WordWithCount wc : res) {
            System.out.println(wc.getWord() + ", " + wc.getCount());
        }
        System.out.println();

        System.out.println("The results for HashMap:");
        System.out.println("Best time for 10 runs: " + minTimeHash + "ms");

        System.out.println("The results for TreeMap:");
        System.out.println("Best time for 10 runs: " + minTimeTree + "ms");

    }

    /**
     * 
     * @param theBookName
     * @return
     * @throws FileNotFoundException
     */
    public List<String> readWords(final Scanner input) throws FileNotFoundException {

        final ArrayList<String> listOfWords = new ArrayList<String>();
        
        input.useDelimiter("[^a-zA-Z]+");
        while (input.hasNext()) {
            String word = input.next();
            word = word.toLowerCase();
            listOfWords.add(word);

        }
        input.close();
        return listOfWords;
    }

    /**
     * 
     * @param theFileName
     * @return
     */
    public static void getCount(final List<String> list,
                                final Map<String, Integer> numberOfAppearances) {

        for (String word : list) {

            if (!numberOfAppearances.containsKey(word)) {

                numberOfAppearances.put(word, 0);
            }
            final int count = numberOfAppearances.get(word);
            numberOfAppearances.put(word, count + 1);

        }
    }

    public WordWithCount[] getTopN(int number, Map<String, Integer> allWords) {

        PriorityQueue<String> list =
                        new PriorityQueue<String>(number, new Comparator<String>() {

                            public int compare(String n1, String n2) {

                                return allWords.get(n2) - allWords.get(n1);

                            }
                        });

        for (String s : allWords.keySet()) {

            list.add(s);

        }

        WordWithCount[] topN = new WordWithCount[number];
        for (int i = 0; i < number; i++) {
            String word = list.remove();
            topN[i] = new WordWithCount(word, allWords.get(word));
        }

        return topN;

    }

    private class WordWithCount {

        private final String word;
        private final int count;

        public WordWithCount(final String theWord, final int theCount) {
            word = theWord;
            count = theCount;
        }

        public String getWord() {
            return word;
        }

        public int getCount() {
            return count;
        }
    }

}
