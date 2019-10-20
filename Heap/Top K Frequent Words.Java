
/*
67. Top K Frequent Words
Given a composition with different kinds of words, return a list of the top K most frequent words in the composition.

Assumptions

the composition is not null and is not guaranteed to be sorted
K >= 1 and K could be larger than the number of distinct words in the composition, in this case, just return all the distinct words
Return

a list of words ordered from most frequent one to least frequent one (the list could be of size K or smaller than K)
Examples

Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [“b”, “c”]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are [“b”, “c”, "a", "d"]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are [“b”, “c”, "a", "d"]
*/


public class Solution {
  public String[] topKFrequent(String[] combo, int k) {
    // Write your solution here
    if(combo.length == 0) {
      return new String[0];
    }
    HashMap<String, Integer> words = new HashMap<>();
    for(int i = 0; i < combo.length; i++) {
      Integer count = words.get(combo[i]);
      if(count == null) {
        count = 1;
      }
      else {
        count++;
      }
      words.put(combo[i], count);
    }

    if(words.size() < k) {
      k = words.size();
    }

    PriorityQueue<Element> minHeap = new PriorityQueue<>(k, new Comparator<Element>() {
      public int compare(Element e1, Element e2) {
        if(e1.count == e2.count) {
          return 0;
        }
        return e1.count < e2.count ? -1 : 1;
      }
    });
    
    int i = 0;
    for(Map.Entry<String, Integer> entry: words.entrySet()) {
      Element curr = new Element(entry.getKey(), entry.getValue());
      if(i < k) {
        minHeap.offer(curr);
      }
      else {
        if(curr.count > minHeap.peek().count) {
          minHeap.poll();
          minHeap.offer(curr);
        }
      }
      i++;
    }
    String[] result = new String[k];
    for(int j = k - 1; j >= 0; j--) {
      // System.out.println(result.length);
      result[j] = minHeap.poll().word;
    }
    return result;
  }

  public class Element {
    String word;
    int count;
    public Element(String word, int count) {
      this.word = word;
      this.count = count;
    }
  }
}
