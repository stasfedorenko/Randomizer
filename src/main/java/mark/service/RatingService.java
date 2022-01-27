package mark.service;

import mark.entity.Rating;
import mark.repository.RatingRepository;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }
    public void addRating(Rating rating){
        ratingRepository.save(rating);
    }
}
