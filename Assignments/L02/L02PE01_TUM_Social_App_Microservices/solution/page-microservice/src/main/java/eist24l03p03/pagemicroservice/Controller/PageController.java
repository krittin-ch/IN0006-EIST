package eist24l03p03.pagemicroservice.Controller;

import eist24l03p03.pagemicroservice.User;
import eist24l03p03.pagemicroservice.Tweet;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/page")
public class PageController {

    private static final String getActivityURL = "http://localhost:8084/activity/getActivity/";
    private static final String getFollowedListURL = "http://localhost:8084/activity/getFollowedList/";
    HttpHeaders headers = new HttpHeaders();
    // TODO: implement the methods of this class. Make a use of the provided data structures
    private RestTemplate restTemplate = new RestTemplate();

    // page of one user
    @GetMapping("/getTimeLine/{id}")
    public List<Tweet> getTimeLine(@PathVariable("id") int userID) {
        String url = getActivityURL + userID;

        // Sends an HTTP GET request to the specified URL and expects a response containing a List of Tweet objects.
        ResponseEntity<List<Tweet>> response = restTemplate.exchange(
                url, // the URL to send the request to (e.g., "http://localhost:8084/activity/getActivity/123")
                HttpMethod.GET, // the HTTP method to use; in this case, it's a GET request.
                null, // the request entity (headers/body); null here means no headers or body are needed for this GET request.
                new ParameterizedTypeReference<List<Tweet>>() {} // the expected response type. This tells Spring we expect a List of Tweet objects in the response body.
        );

        return response.getBody();
    }

    // // pages of the followed users, i.g. feed
    // @GetMapping("/getHomePage/{id}")
    // public List<Tweet> getHomePage(@PathVariable("id") int userID) {
    //     String url = getFollowedListURL + userID;
    //
    //     // Set Content-Type header
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.APPLICATION_JSON);
    //
    //     HttpEntity<String> entity = new HttpEntity<>(headers);
    //
    //     // Call activity service to get the list of followed users
    //     ResponseEntity<List<User>> response = restTemplate.exchange(
    //             url,
    //             HttpMethod.GET,
    //             entity,
    //             new ParameterizedTypeReference<List<User>>() {}
    //     );
    //
    //     List<User> followedUsers = response.getBody();
    //     List<Tweet> homePageTweets = new ArrayList<>();
    //
    //     if (followedUsers != null) {
    //         for (User followed: followedUsers) {
    //             int followedUserID = followed.getUserID();
    //             List<Tweet> tweetList = getTimeLine(followedUserID);
    //
    //             if (tweetList != null) {
    //                 homePageTweets.addAll(tweetList);
    //             }
    //         }
    //     }
    //
    //     return homePageTweets;
    // }

    @GetMapping("/getHomePage/{id}")
    public List<Tweet> getHomePage(@PathVariable("id") int userID) {
        String url = getFollowedListURL + userID;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        List<User> followedUsers;
        try {
            ResponseEntity<List<User>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<List<User>>() {}
            );

            if (response.getStatusCode() != HttpStatus.OK || response.getBody() == null) {
                return Collections.emptyList();
            }

            followedUsers = response.getBody();
        } catch (RestClientException e) {
            // Log error
            return Collections.emptyList();
        }

        List<Tweet> homePageTweets = new ArrayList<>();
        for (User followed : followedUsers) {
            List<Tweet> tweetList = getTimeLine(followed.getUserID());
            if (tweetList != null) {
                homePageTweets.addAll(tweetList);
            }
        }

        return homePageTweets;
    }
}