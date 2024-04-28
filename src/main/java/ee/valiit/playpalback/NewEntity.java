package ee.valiit.playpalback;

import ee.valiit.playpalback.domain.event.event.Event;
import ee.valiit.playpalback.domain.participant.participant.Participant;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class NewEntity extends Event {
    @ManyToMany
    @JoinTable(name = "null_participants",
            joinColumns = @JoinColumn(name = "newEntity_id"))
    private List<Participant> participants = new ArrayList<>();

}