class Solution {
    public boolean detectCapitalUse(String word) {
        int upperCase = 0;
        for(char el:word.toCharArray()){
            if(Character.isUpperCase(el)){
                upperCase++;
            }
        }
        if(upperCase==0)
            return true;
        else if(upperCase==1)
            return Character.isUpperCase(word.charAt(0));
        return word.length()==upperCase;
    }
}