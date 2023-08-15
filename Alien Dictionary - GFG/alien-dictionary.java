//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        
        List<Integer>[] graph = new List[K];
        for (int i = 0; i < K; i++) { graph[i] = new ArrayList<>(); }
        
        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i], s2 = dict[i + 1];
            int minLen = Math.min(s1.length(), s2.length());
            for (int idx = 0; idx < minLen; idx++) {
                char c1 = s1.charAt(idx), c2 = s2.charAt(idx);
                if (c1 != c2) {
                    graph[c1 - 'a'].add(c2 - 'a');
                    break;
                }
            }
        }
        
        List<Character> charList = topoSort(graph, N, K);
        
        return listToString(charList);
    }
    
    private List<Character> topoSort(List<Integer>[] graph, int N, int K) {
        int[] inorder = new int[K];
        for (int character = 0; character < K; character++) {
            for (int ng: graph[character]) {
                inorder[ng]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int character = 0; character < K; character++) {
            if (inorder[character] == 0) {
                q.offer(character);
            }
        }
        
        List<Character> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add((char) (node + (int)'a'));
            for (int ng: graph[node]) {
                inorder[ng]--;
                if (inorder[ng] == 0)
                    q.offer(ng);
            }
        }
        
        return res;
    }
    
    public static String listToString(List<Character> charList) {
        StringBuilder stringBuilder = new StringBuilder(charList.size());

        for (Character c : charList) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }
}

















