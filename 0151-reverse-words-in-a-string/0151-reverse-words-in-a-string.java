class Solution {
    public String reverseWords(String s) {
      if(s == null)
        return s;

      s = s.trim();
      StringBuilder sb = new StringBuilder();
      List<String> tokens = new ArrayList<>();
      for(int i = 0; i < s.length();) {
        if(s.charAt(i) == ' ') {
          System.out.println(sb);
          tokens.add(sb.toString());
          sb = new StringBuilder("");
          while(s.charAt(i) == ' ')
            i++;
        }
        sb.append(s.charAt(i++));
      }
      System.out.println(sb);
      if(tokens.size() == 0)
        return sb.toString();

      for(int i = tokens.size() - 1; i >= 0; i--) {
        sb.append(" " + tokens.get(i));
      }

      return sb.toString();
    }
}