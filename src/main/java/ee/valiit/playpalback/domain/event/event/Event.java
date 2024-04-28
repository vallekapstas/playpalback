package ee.valiit.playpalback.domain.event.event;

import ee.valiit.playpalback.domain.event.skill.Skill;
import ee.valiit.playpalback.domain.location.location.Location;
import ee.valiit.playpalback.domain.user.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "event", schema = "playpal")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 255)
    @NotNull
    @Column(name = "venue", nullable = false)
    private String venue;

    @NotNull
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @NotNull
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @NotNull
    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @NotNull
    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @Column(name = "min_players")
    private Integer minPlayers;

    @Column(name = "max_players")
    private Integer maxPlayers;

    @Column(name = "min_age")
    private Integer minAge;

    @Column(name = "max_age")
    private Integer maxAge;

    @Column(name = "fee", precision = 6, scale = 2)
    private BigDecimal fee;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @NotNull
    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

    @NotNull
    @Column(name = "event_description", nullable = false)
    private String eventDescription;


    // ADDITIONAL LOGIC FOR FILTERING AND SORTING

//    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Participant> participants = new HashSet<>();

//    @Transient
//    private String statusCondition;
//
//    @Transient
//    private String sortDirection;
//
//    @Transient
//    private String sortParameter;
//
//    @Transient
//    private Boolean isParticipant;
//
//    @Transient
//    private Boolean isHost;
//
//    @Transient
//    private Float minFee;
//
//    @Transient
//    private Float maxFee;
//
//    @Transient
//    private Integer minJoinedPlayers;
//
//    @Transient
//    private Integer maxJoinedPlayers;

}