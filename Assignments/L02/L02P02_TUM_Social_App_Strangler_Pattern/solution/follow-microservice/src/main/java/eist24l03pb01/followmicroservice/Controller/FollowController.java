package eist24l03pb01.followmicroservice.Controller;

import eist24l03pb01.followmicroservice.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/follow")
public class FollowController {
    // Move methods: sendTweet() and deleteTweet() from LoginController
    @PostMapping(value = "/follow")
    public String follow(@RequestBody User user) { return user.getUserName() + " is followed!"; }

    @DeleteMapping(value = "/unfollow")
    public String unfollow(@RequestBody User user) { return user.getUserName() + " is unfollowed!"; }
}