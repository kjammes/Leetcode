class Tweet {
    int timestamp;
    int id;
    int followeeId;
    int idx;
    
    Tweet(int id, int timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    Tweet(int id, int timestamp, int followeeId, int idx) {
      this.id = id;
      this.timestamp = timestamp;
      this.followeeId = followeeId;
      this.idx = idx;
  }
}

class Twitter {
    
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<Tweet>> tweetMap;
    int count;

    public Twitter() {
        this.followMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        List<Tweet> tweets = tweetMap.getOrDefault(userId, new ArrayList<>());
        tweets.add(new Tweet(tweetId, count++));
        tweetMap.put(userId, tweets);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.timestamp, a.timestamp));
        
        followMap.computeIfAbsent(userId,
            k -> new HashSet<>()
        );
        followMap.get(userId).add(userId);
        
        for (int uId: followMap.get(userId)) {
            if (!tweetMap.containsKey(uId))
              continue;
            int i = tweetMap.get(uId).size() - 1;
            Tweet tweet = tweetMap.get(uId).get(i);
            pq.offer(new Tweet(tweet.id, tweet.timestamp, uId, --i));
        }
        
        while (!pq.isEmpty() && res.size() < 10) {
            Tweet data = pq.poll();
            res.add(data.id);

            if (data.idx >= 0) {
                Tweet tweetToOffer = tweetMap.get(data.followeeId).get(data.idx);
                pq.offer(new Tweet(tweetToOffer.id, tweetToOffer.timestamp, data.followeeId, --data.idx));
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> set = followMap.getOrDefault(followerId, new HashSet<>());
        set.add(followeeId);
        followMap.put(followerId, set);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = followMap.getOrDefault(followerId, new HashSet<>());
        if (set.contains(followeeId))  set.remove(followeeId);
        followMap.put(followerId, set);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */