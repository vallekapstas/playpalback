package ee.valiit.playpalback.business.Participant.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Setter
@Getter
public class ParticipantCountInfo {

    private Integer eventId;
    private long participantCount;

    public ParticipantCountInfo(Integer eventId, long participantCount) {
        this.eventId = eventId;
        this.participantCount = participantCount;
    }

}

