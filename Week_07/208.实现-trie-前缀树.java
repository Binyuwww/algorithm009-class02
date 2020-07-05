/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start

class TrieNode {
    TrieNode[] child;
    boolean isEnd;

    public TrieNode() {
        child = new TrieNode[26];
        isEnd = false;
    }
}


class Trie {
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); ++ i) {
            char c = word.charAt(i);

            if (node.child[c - 'a'] == null) {
                node.child[c - 'a'] = new TrieNode();
            }
            node = node.child[c - 'a'];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); ++ i) {
            char c = word.charAt(i);
            if (node.child[c - 'a'] == null) {
                return false;
            }
            node = node.child[c - 'a'];
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); ++ i){
            char c = prefix.charAt(i);
            if (node.child[c - 'a'] == null) {
                return false;
            }
            node = node.child[c - 'a'];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

