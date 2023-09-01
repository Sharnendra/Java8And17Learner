package WordDictionary;

import java.util.ArrayList;
import java.util.List;

public class WordDictionary {

    private Word headNode;
        // initializes the WordDictionary
	    WordDictionary() {

        }

        // Inserts the word and corresponding definition into the dictionary,
        // if the word already exists, it will override the word and definition
        public void insertWord(String word, String definition) {
            Word currentNode = headNode;
            //if there is no node value.
            if (currentNode == null){
                currentNode = new Word(word.toUpperCase(), definition);
                currentNode.next = null;
                return;
            }
            while (currentNode.next != null) {
                //if the word is already present.
                if (currentNode.word.equalsIgnoreCase(word)) {
                    currentNode.definition = definition;
                    return;
                }
                currentNode = currentNode.next;
            }
            //Now the headNode is at a position where it is parsed to the end, and didn't find the word.
            //this current node is not compared as we have looped till the next as null. So, Comparison is needed.
            if(currentNode.word.equalsIgnoreCase(word)) {
                currentNode.definition = definition;
            }
            else {
                Word newNode = new Word(word.toUpperCase(), definition);
                newNode.next = null;
                currentNode.next = newNode;
            }
        }

        // Returns the definition for the word
        public String findDefinition(String word) {
            Word currentNode = headNode;
            //if there is no node value.
            if (currentNode == null) return "No Word/ Definition available in dictionary.";
            //Iterate for all the nodes available, even if it is one node
            while(currentNode!=null) {
                if(currentNode.word.equalsIgnoreCase(word)){
                    return currentNode.definition;
                }
                currentNode = currentNode.next;
            }
            return "Definition for the given word is not available in the dictionary.";
        }

        // Returns the definitions for the words that are matched partially
        public List<String> partialSearch(String partialWord) {
            Word currentNode = headNode;
            List<String> partialSearchDefinitions = new ArrayList<>();
            //if there is no node value.
            if (currentNode == null) return partialSearchDefinitions;
            //Iterate for all the nodes available, even if it is one node
            while(currentNode!=null) {
                if(currentNode.word.contains(partialWord.toUpperCase())){
                    partialSearchDefinitions.add(currentNode.definition);
                }
                currentNode = currentNode.next;
            }
            return partialSearchDefinitions;
        }

        // Removes the word with definition from the dictionary
        public void remove(String word) {
            Word leadNode = headNode;
            //if there is no node value.
            if (headNode == null) return;
            //if there is only one node with the value.
            if (headNode.word.equalsIgnoreCase(word) && headNode.next==null) {
                headNode = null;
                return;
            }
            //if there are multiple nodes, and you know that it's not the first node holding the value.
            Word previousNode = null;
            while(leadNode!=null) {
                if(leadNode.word.equalsIgnoreCase(word)){
                    previousNode.next = leadNode.next;
                    return;
                }
                //In first iteration previous will be holding the head and head will be moved to its next.
                previousNode = leadNode;
                leadNode = leadNode.next;
            }
        }

}

class Word {
    String word;
    String definition;
    Word next;

    Word(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }
}
