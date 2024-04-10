package ee.valiit.playpalback.domain.image.userimage;

import ee.valiit.playpalback.domain.user.profile.Profile;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_image", schema = "playpal")
public class UserImage {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "image_data")
    private byte[] imageData;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

}