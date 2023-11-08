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

    List<Rating> ratings= Arrays.asList(new Rating("pr1","3"),
            new Rating("pr2","4"),
            new Rating("pr3","2"),
            new Rating("pr4","5"),
            new Rating("pr5","4"),
            new Rating("pr6","1"));

    @RequestMapping("/{productId}")
    public Rating getRating(@PathVariable("productId") String productId) {

      Rating ratingValue = ratings.stream().filter(rating -> rating.getProductId().equalsIgnoreCase(productId)).findFirst().orElse(new Rating(productId,"no Rating"));
        return ratingValue;
    }

    @RequestMapping("users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId){
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }
}