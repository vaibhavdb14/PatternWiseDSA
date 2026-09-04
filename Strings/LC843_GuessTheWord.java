import java.util.ArrayList;
// import java.util.Arrays;

public class LC843_GuessTheWord {

    // My logic: Calculate exact character and position matches.
    public static int calculateMatch(String sample, String target) {
        int count = 0;

        for (int i = 0; i < sample.length(); i++) {
            if (sample.charAt(i) == target.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    // Suggested by ChatGPT: Use Minimax to find the best possible guess.
    public static String findBestGuess(String[] words) {

        int minMax = Integer.MAX_VALUE;
        String bestWord = "";

        // Try every word as a possible guess.
        for (String sample : words) {

            // Match can be from 0 to 6.
            int[] groups = new int[7];

            // Group all words according to their match count
            // with the current sample.
            for (String target : words) {

                int match = calculateMatch(sample, target);

                groups[match]++;
            }

            // Find the largest group.
            // This is the worst-case number of candidates
            // that can remain after this guess.
            int maxGroup = 0;

            for (int i = 0; i < 7; i++) {
                maxGroup = Math.max(maxGroup, groups[i]);
            }

            // Suggested by ChatGPT: Minimize the worst-case group.
            if (maxGroup < minMax) {
                minMax = maxGroup;
                bestWord = sample;
            }
        }

        return bestWord;
    }

    public static void findSecretWord(String[] words, Master master) {

        ArrayList<String> candidate = new ArrayList<>();

        // Suggested by ChatGPT: Select the best first guess.
        String sample = findBestGuess(words);

        // Ask Master how many positions match.
        int match = master.guess(sample);

        // If all 6 positions match, we found the secret.
        if (match == 6) {
            return;
        }

        // My logic: Build a candidate list containing only
        // words having the same match count as Master returned.
        for (String i : words) {

            int count = calculateMatch(sample, i);

            if (count == match) {
                candidate.add(i);
            }
        }

        while (match != 6) {

            // My logic: Select the next sample from the
            // current candidate list.
            sample = findBestGuess(
                candidate.toArray(new String[0])
            );

            // Ask Master about the new sample.
            match = master.guess(sample);

            if (match == 6) {
                return;
            }

            // My logic: Iterate backwards while removing
            // invalid candidates so indexes do not shift.
            for (int j = candidate.size() - 1; j >= 0; j--) {

                int count = calculateMatch(
                    sample,
                    candidate.get(j)
                );

                // Remove words that cannot be the secret.
                if (count != match) {
                    candidate.remove(j);
                }
            }
        }
    }

    // Local Master class for testing.
    // LeetCode provides this API itself.
    static class Master {

        private String secret;
        private String[] words;
        private int allowedGuesses;
        private int guessCount;

        public Master(String secret, String[] words, int allowedGuesses) {
            this.secret = secret;
            this.words = words;
            this.allowedGuesses = allowedGuesses;
            this.guessCount = 0;
        }

        // Simulates LeetCode's Master.guess().
        public int guess(String word) {

            guessCount++;

            // Check whether the guessed word exists in words.
            boolean validWord = false;

            for (String w : words) {
                if (w.equals(word)) {
                    validWord = true;
                    break;
                }
            }

            if (!validWord) {
                return -1;
            }

            int count = 0;

            // Count exact character-position matches.
            for (int i = 0; i < 6; i++) {
                if (word.charAt(i) == secret.charAt(i)) {
                    count++;
                }
            }

            System.out.println(
                "Guess " + guessCount +
                ": " + word +
                " -> " + count + " matches"
            );

            return count;
        }

        public int getGuessCount() {
            return guessCount;
        }

        public int getAllowedGuesses() {
            return allowedGuesses;
        }
    }

    public static void main(String[] args) {

        // Test Case 1
        String[] words1 = {
            "acckzz",
            "ccbazz",
            "eiowzz",
            "abcczz"
        };

        String secret1 = "acckzz";
        int allowedGuesses1 = 10;

        System.out.println("Test Case 1");
        System.out.println("Secret: " + secret1);

        Master master1 = new Master(
            secret1,
            words1,
            allowedGuesses1
        );

        findSecretWord(words1, master1);

        System.out.println(
            "Guesses used: " + master1.getGuessCount()
        );

        System.out.println(
            "Allowed guesses: " + master1.getAllowedGuesses()
        );

        System.out.println();


        // Test Case 2
        String[] words2 = {
            "hamada",
            "khaled"
        };

        String secret2 = "hamada";
        int allowedGuesses2 = 10;

        System.out.println("Test Case 2");
        System.out.println("Secret: " + secret2);

        Master master2 = new Master(
            secret2,
            words2,
            allowedGuesses2
        );

        findSecretWord(words2, master2);

        System.out.println(
            "Guesses used: " + master2.getGuessCount()
        );

        System.out.println(
            "Allowed guesses: " + master2.getAllowedGuesses()
        );
    }
}

/*
Approach:

// My logic:
// Maintain a candidate list containing words that can still be
// the secret. After every Master.guess(), remove words whose
// matching count does not equal the returned match count.

// Suggested by ChatGPT:
// Use the Minimax strategy to select the next best word.
// For every possible guess, divide the current words into groups
// based on their number of matching positions. Find the largest
// group for each guess and choose the guess with the smallest
// largest group.

// Repeat the process until Master.guess() returns 6.
*/