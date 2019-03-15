package solutions;

import java.util.HashMap;
import java.util.Map;

/**
Given two sentences words1, words2 (each represented as an array of strings), 
and a list of similar word pairs pairs, determine if two sentences are similar.

For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, 
if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].

Note that the similarity relation is transitive. 
For example, if "great" and "good" are similar, and "fine" and "good" are similar, 
then "great" and "fine" are similar.

Similarity is also symmetric. 
For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.

Also, a word is always similar with itself. 
For example, the sentences words1 = ["great"], words2 = ["great"], 
pairs = [] are similar, even though there are no specified similar word pairs.

Finally, sentences can only be similar if they have the same number of words. 
So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].

Note:
1. The length of words1 and words2 will not exceed 1000.
2. The length of pairs will not exceed 2000.
3. The length of each pairs[i] will be 2.
4. The length of each words[i] and pairs[i][j] will be in the range [1, 20].
 */

public class SentenceSimilarityII {
    private Map<String,String> roots;
    
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length!=words2.length) {
            return false;
        }
        // union
        roots = new HashMap<>();
        for (String[] pair:pairs) {
            String r0 = findRoot(pair[0]);
            roots.put(pair[0], r0);
            String r1 = findRoot(pair[1]);
            roots.put(pair[1], r1);
            roots.put(r0,r1);
        }
        for (int i=0;i<words1.length;i++) {
            String r1 = findRoot(words1[i]);
            String r2 = findRoot(words2[i]);
            if (!r1.equals(r2)) {
                return false;
            }
        }
        return true;
    }
    private String findRoot(String w) {
        if (!roots.containsKey(w)) {
            roots.put(w,w);
            return w;
        }
        while (roots.get(w)!=w) {
            w = roots.get(w);
        }
        return w;
    }
}
