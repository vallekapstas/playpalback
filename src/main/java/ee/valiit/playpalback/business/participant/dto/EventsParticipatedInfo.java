package ee.valiit.playpalback.business.participant.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EventsParticipatedInfo {
    private Integer userId;
    private long eventCount;

    public EventsParticipatedInfo(Integer userId, long participantCountByUserId) {
        this.userId = userId;
        this.eventCount = participantCountByUserId;
    }

}
