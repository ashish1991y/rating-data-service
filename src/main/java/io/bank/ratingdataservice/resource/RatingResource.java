package io.bank.ratingdataservice.resource;

import io.bank.ratingdataservice.model.Rating;
import io.bank.ratingdataservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

    @RequestMapping("/{productId}")
    public Rating getRating(@PathVariable("productId") String productId) {
        return new Rating(productId, "4");
    }

    @RequestMapping("users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId){
        List<Rating> ratings= Arrays.asList(new Rating("pr1","3"),
                new Rating("pr2","4"));

        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }
}