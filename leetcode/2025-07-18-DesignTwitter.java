class Tweet implements Comparable<Tweet> // means objects of Tweet can be compared using the compareTo method.
{
    int time; // when the tweet was posted
    int tweetId; // ID of the tweet

    Tweet(int time, int tweetId)
    {
        this.time = time;
        this.tweetId = tweetId;
    }

    public int compareTo(Tweet that)
    {
        return that.time - this.time; // So, this makes tweets sort in descending order of time.
    }
}

class User
{
    int userId;
    HashSet<Integer> followers; // users this user is following
    List<Tweet> tweets; // list of tweets by this user

    User(int userId)
    {
        this.userId = userId;
        followers = new HashSet<>(); // following list
        tweets = new LinkedList<>(); // own tweets
    }

    public void addTweet(Tweet t)
    {
        tweets.add(0, t); // add new tweet at start of the list
    }

    public void addFollower(int followeeId)
    {
        followers.add(followeeId); // add followee in following list
    }

    public void removeFollower(int followeeId)
    {
        followers.remove(followeeId); // remove followee from following list
    }
}

class Twitter {
    HashMap<Integer, User> userMap; // to store all users
    int timeCounter; // keeps increasing for each tweet

    public Twitter() {
        userMap = new HashMap<>(); // initialize user map
        timeCounter = 0; // starting time
    }

    public void postTweet(int userId, int tweetId) {
        timeCounter++; // increase the time so every new tweet gets a different time

        // If this user doesn't exist yet, create the user and add to the map
        if (!userMap.containsKey(userId)) userMap.put(userId, new User(userId));

        User user = userMap.get(userId); // Get the user from the map

        user.addTweet(new Tweet(timeCounter, tweetId)); // Create a new tweet and add it to this user's list of tweets
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!userMap.containsKey(userId)) return new ArrayList<>(); // if user doesn't exist, return empty

        PriorityQueue<Tweet> pq = new PriorityQueue<>(); // min-heap to get latest tweets on top

        User user = userMap.get(userId); // get the current user

        // go through all followees and add their tweets to the priority queue
        for (int followeeId : user.followers)
        {
            int count = 0;
            for (Tweet tweet : userMap.get(followeeId).tweets)
            {
                pq.offer(tweet); // add tweet to heap
                count++;
                if (count >= 10) break; // only latest 10 tweets
            }
        }

        // add own tweets also
        int count = 0;
        for (Tweet tweet : user.tweets)
        {
            pq.offer(tweet); // add tweet to heap
            count++;
            if (count >= 10) break; // only latest 10 tweets
        }

        List<Integer> res = new ArrayList<>(); // result list
        int idx = 0;
        while (!pq.isEmpty() && idx < 10)
        {
            Tweet tweet = pq.poll(); // get top tweet
            res.add(tweet.tweetId); // add tweetId to result
            idx++;
        }

        return res; // return the top 10 tweetIds
    }

    public void follow(int followerId, int followeeId) {
        // if follower doesn't exist, create it
        if (!userMap.containsKey(followerId)) userMap.put(followerId, new User(followerId));

        // if followee doesn't exist, create it
        if (!userMap.containsKey(followeeId)) userMap.put(followeeId, new User(followeeId));

        User user = userMap.get(followerId); // get follower's object

        user.addFollower(followeeId); // add followee in following list
    }

    public void unfollow(int followerId, int followeeId) {
        // if either user doesn't exist, then return
        if (!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) return;

        User user = userMap.get(followerId); // get follower's object

        user.removeFollower(followeeId); // remove followee from following list
    }
}
