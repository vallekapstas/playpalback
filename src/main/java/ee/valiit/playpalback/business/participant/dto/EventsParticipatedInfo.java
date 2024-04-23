package ee.valiit.playpalback.business.participant.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EventsParticipatedInfo {
    private Integer userId;
    private long participantCountByUserId;

    public EventsParticipatedInfo(Integer userId, long participantCountByUserId) {
        this.userId = userId;
        this.participantCountByUserId = participantCountByUserId;
    }

}
