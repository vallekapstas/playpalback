package ee.valiit.playpalback.domain.image.eventimage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link EventImage}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventImageDto implements Serializable {
    private byte[] imageData;
}