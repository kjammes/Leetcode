class Solution {
    public int numofsubstring(String s,int k){
        HashMap<Character,Integer>mp=new HashMap<>();
        int distinct=0;
        int answer=0;
        int release=0;
        for(int acquire=0;acquire<s.length();acquire++){
            char ch=s.charAt(acquire);
            if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)+1);
            }else{
                mp.put(ch,1);
                distinct++;
            }
            
            while(release<=acquire && distinct>k){
                char chr=s.charAt(release);
                mp.put(chr,mp.get(chr)-1);
                if(mp.get(chr)==0){
                    mp.remove(chr);
                    distinct--;
                }
                release++;
            }
            answer+=acquire-release+1;
        }
        return answer;
    }
    public int numberOfSubstrings(String s) {
        return numofsubstring(s,3)-numofsubstring(s,2);
    }
}