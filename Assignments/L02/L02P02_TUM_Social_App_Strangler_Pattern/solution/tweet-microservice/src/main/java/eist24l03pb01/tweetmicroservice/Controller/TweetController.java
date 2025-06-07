package eist24l03pb01.tweetmicroservice.Controller;

import eist24l03pb01.tweetmicroservice.Tweet;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tweet")
public class TweetController {
    // Move methods: sendTweet() and deleteTweet() from LoginController
    @PostMapping(value = "/send")
    public String sendTweet(@RequestBody Tweet tweet) { return "The tweet is sent"; }

    @DeleteMapping(value = "/delete")
    public String deleteTweet(@RequestBody Tweet tweet) {
        return "The tweet: \n'''" + tweet.getBody() + "'''\nis deleted";
    }
}
