package fi.istrange.traveler.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by aleksandr on 8.5.2017.
 */
public class EvaluatedCardRes {
    private Long cardId;
    private boolean liked;

    public EvaluatedCardRes(
            Long cardId,
            boolean liked
    ) {
        this.cardId = cardId;
        this.liked = liked;
    }

    @JsonProperty
    public Long getCardId() { return this.cardId; }

    @JsonProperty
    public boolean isLiked() { return this.liked; }

    public static EvaluatedCardRes fromEntity(Long cardId, boolean liked) {
        return new EvaluatedCardRes(
                cardId,
                liked
        );
    }
}
