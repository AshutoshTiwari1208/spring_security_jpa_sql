package com.inclined.springsecurityjpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/")
    public String getHomePage() {
        return "<h1>Hey that's the home page...</h1>";
    }

    @GetMapping("/user")
    public String getUserHomePage() {
        return "<h2>Hey that's user's home page</h2>";
    }

    @GetMapping("/admin")
    public String getAdminsHomePage() {
        return "<h4> Welcome Mr.Admin....</h4>";
    }


}
