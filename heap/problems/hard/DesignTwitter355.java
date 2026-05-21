package heap.problems.hard;

import java.util.*;


public class DesignTwitter355 {
    public static void main(String[] args) {

    }
}

class Twitter {
    Map<Integer,Set<Integer>> userFolloweeMap;
    Map<Integer,TweetMetaData> userTweetsMap;
    int tweetCount = 0;
    public Twitter() {
        userFolloweeMap = new HashMap<>();
        userTweetsMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        TweetMetaData tweet = new TweetMetaData(tweetId,++tweetCount,userId);
        if(userTweetsMap.containsKey(userId)){
            TweetMetaData prevTweet = userTweetsMap.get(userId);
            tweet.next = prevTweet;
        }
        userTweetsMap.put(userId,tweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> follwerIds = userFolloweeMap.get(userId);
        if(follwerIds == null ) follwerIds = new HashSet<>();
        follwerIds.add(userId);
        return getRecentTweets(follwerIds,10);
    }

    public void follow(int followerId, int followeeId) {
        userFolloweeMap.putIfAbsent(followerId,new HashSet<>());
        userFolloweeMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        userFolloweeMap.getOrDefault(followerId,new HashSet<>()).remove(followeeId);
    }

    public List<Integer> getRecentTweets(Set<Integer> followerIds,int size){
        if(followerIds == null || followerIds.size() == 0) return new ArrayList<>();

        PriorityQueue<TweetMetaData> pq = new PriorityQueue<>((a,b) ->Integer.compare(b.tweetCount,a.tweetCount));
        List<Integer> tweetIds = new ArrayList<>();
        for(int userId : followerIds){
            TweetMetaData tweet = userTweetsMap.getOrDefault(userId,null);
            if(tweet != null) pq.offer(tweet);
        }
        while(!pq.isEmpty()){
            TweetMetaData currTweet = pq.poll();
            tweetIds.add(currTweet.tweetId);
            if(currTweet.next != null) pq.offer(currTweet.next);
            if(tweetIds.size() == size) break;
        }
        return tweetIds;
    }
}


class TweetMetaData{
    int tweetId;
    int tweetCount;
    int userId;
    TweetMetaData next;
    TweetMetaData(int tweetId, int tweetCount, int userId){
        this.tweetId = tweetId;
        this.tweetCount = tweetCount;
        this.userId = userId;
    }
}