class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> tempIPs = new ArrayList<>();
        List<String> IPs = new ArrayList<>();
        f(s, tempIPs, IPs, 0);
        return IPs;
    }
    
    private void f(String s, List<String> tempIPs, List<String> IPs, int idx) {
        if (tempIPs.size() == 4 && idx == s.length()) {
            IPs.add(String.join(".", tempIPs));
            return;
        }
        
        for(int i = idx + 1; i <= idx + 3 && i <= s.length(); i++) {
            String curIP = s.substring(idx, i);
            
            if (Integer.parseInt(curIP) <= 255 && ( curIP.equals("0") || !curIP.startsWith("0") )) {
                tempIPs.add(curIP);
                f(s, tempIPs, IPs, i);
                tempIPs.remove(tempIPs.size() - 1);
            }
        }
    }
}