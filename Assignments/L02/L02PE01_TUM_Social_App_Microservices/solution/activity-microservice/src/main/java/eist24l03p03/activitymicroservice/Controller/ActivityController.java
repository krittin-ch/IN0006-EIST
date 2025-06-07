package eist24l03p03.activitymicroservice.Controller;

import eist24l03p03.activitymicroservice.FollowRequest;
import eist24l03p03.activitymicroservice.Tweet;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import eist24l03p03.activitymicroservice.User;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    // TODO: implement the methods of this class. Make a use of the provided data structures
    private Map<Integer, List<Tweet>> userActivityMap = new HashMap<>();
    private Map<Integer, List<User>> userFollowedMap = new HashMap<>();

    @GetMapping("/getActivity/{id}")
    public List<Tweet> getActivity(@PathVariable("id") int userID) {
        return userActivityMap.getOrDefault(userID, new ArrayList<>()); // either return the list of tweets or empty list
    }

    @PostMapping("/addActivity")
    public void addActivity(@RequestBody Tweet tweet) {
        int userID = tweet.getUser().getUserID();
        userActivityMap.putIfAbsent(userID, new ArrayList<>()); // if a user's tweet has not been initialized
        userActivityMap.get(userID).add(tweet);
    }

    @PostMapping("/addFollower")
    public void addFollower(@RequestBody FollowRequest followRequest) {
        // The goal is to add a new follower to each other
        User followerUser = followRequest.getFollower();
        User followedUser = followRequest.getFollowed();

        // Add a follower to a followed user's list
        userFollowedMap.putIfAbsent(followedUser.getUserID(), new ArrayList<>());
        userFollowedMap.get(followedUser.getUserID()).add(followerUser);

        // Add a followed user to a follower's list
        userFollowedMap.putIfAbsent(followerUser.getUserID(), new ArrayList<>());
        userFollowedMap.get(followerUser.getUserID()).add(followedUser);
    }

    @DeleteMapping("/deleteActivity")
    public void deleteActivity(@RequestBody Tweet tweet) {
        int userID = tweet.getUser().getUserID();
        List<Tweet> activities = userActivityMap.get(userID);

        if (activities != null) {
            // activities.remove(tweet); // rely on the whole Tweet object
            activities.removeIf(t -> t.getTweetID() == tweet.getTweetID()); // rely on only Tweet ID, imporving flexibility
        }
    }

    @DeleteMapping("/deleteFollower")
    public void deleteFollower(@RequestBody FollowRequest followRequest) {
        User followerUser = followRequest.getFollower();
        User followedUser = followRequest.getFollowed();

        // Remove followedUser from followerUser's followed list
        List<User> followedList = userFollowedMap.get(followerUser.getUserID());
        if (followedList != null) {
            followedList.removeIf(u -> u.getUserID() == followedUser.getUserID());
        }

        // Remove followerUser from followedUser's followers list
        List<User> followerList = userFollowedMap.get(followedUser.getUserID());
        if (followerList != null) {
            followerList.removeIf(u -> u.getUserID() == followerUser.getUserID());
        }
    }

    @GetMapping("/getFollowedList/{id}")
    public List<User> getFollowedList(@PathVariable("id") int userID) {
        // TODO: this method is also not complete, so you have to implement it accordingly :)
        return userFollowedMap.getOrDefault(userID, new ArrayList<>());
    }
}