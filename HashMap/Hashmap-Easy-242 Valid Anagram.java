class Solution {
    public boolean isAnagram(String s, String t) {

       if(s.length()!=t.length()){
        return false;
       }

        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++; 
        }
        for(char c: t.toCharArray()){
            freq[c-'a']--;
        }

        for(int v:freq){
            if(v!=0){
                return false;
            }
        }

        return true;

        
    }
}

/// below using HashMap + 2 hashmaps & compare equals 
/// TC O(n)
/// SC O(n)

class Solution {
    public boolean isAnagram(String s, String t) {

       if(s.length()!=t.length()){
        return false;
       }

        HashMap<Character,Integer> checkAnagram = new HashMap<>();

        for(char c:s.toCharArray()){
            checkAnagram.put(c, checkAnagram.getOrDefault(c,0)+1);
        }

        for(char c:t.toCharArray()){
            checkAnagram.put(c, checkAnagram.getOrDefault(c,0)-1);
        }

        for(Integer i:checkAnagram.values()){
            if(i!=0){
                return false;
            }
        }

        return true;
    }
}