package wan.leetcode.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Design_Twitter_355 {
	public static class Twitter {
		int timeLine;
		Map<Integer, TwitterUser> userMap;
		Map<Integer, Set<Integer>> followeeMap;

		public Twitter() {
			userMap = new HashMap<Integer, TwitterUser>();
			followeeMap = new HashMap<Integer, Set<Integer>>();
		}

		public void postTweet(int userId, int tweetId) {
			TwitterUser user = this.userMap.get(userId);
			if (user == null) {
				user = new TwitterUser(userId);
				this.userMap.put(userId, user);
			}
			user.tweetQueue.add(new Tweet(timeLine++, tweetId));
		}

		public List<Integer> getNewsFeed(int userId) {
			TwitterUser user = this.userMap.get(userId);
			PriorityQueue<Tweet> tweetQueue = new PriorityQueue<Tweet>(new Comparator<Tweet>() {

				@Override
				public int compare(Tweet o1, Tweet o2) {
					return o2.timeLine - o1.timeLine;
				}
			});
			if (user != null) {
				tweetQueue.addAll(user.tweetQueue);
			}

			Set<Integer> followeeList = this.followeeMap.get(userId);
			if (followeeList != null) {
				for (int followeeId : followeeList) {
					TwitterUser followee = this.userMap.get(followeeId);
					if (followee != null) {
						tweetQueue.addAll(followee.tweetQueue);
					}
				}
			}
			List<Integer> newsFeed = new ArrayList<Integer>();
			while (!tweetQueue.isEmpty() && newsFeed.size() != 10) {
				newsFeed.add(tweetQueue.poll().content);
			}
			return newsFeed;

		}

		public void follow(int followerId, int followeeId) {
			Set<Integer> followeeList = this.followeeMap.get(followerId);
			if (followeeList == null) {
				followeeList = new HashSet<Integer>();
				followeeMap.put(followerId, followeeList);
			}
			followeeList.add(followeeId);
		}

		public void unfollow(int followerId, int followeeId) {
			Set<Integer> followeeList = this.followeeMap.get(followerId);
			if (followeeList == null) {
				return;
			}
			Iterator<Integer> itr = followeeList.iterator();
			while (itr.hasNext()) {
				if (itr.next() == followeeId) {
					itr.remove();
					break;
				}
			}
		}

		private class Tweet {
			int timeLine;
			int content;

			public Tweet(int timeLine, int content) {
				this.timeLine = timeLine;
				this.content = content;
			}
		}

		private class TwitterUser {
			PriorityQueue<Tweet> tweetQueue;

			public TwitterUser(int userId) {
				this.tweetQueue = new PriorityQueue<Tweet>(new Comparator<Tweet>() {

					@Override
					public int compare(Tweet o1, Tweet o2) {
						return o2.timeLine - o1.timeLine;
					}
				});
			}
		}
	}

}
