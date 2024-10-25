package pro.stevendev.rawdatawriterservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.UUID;

@Table("click_events")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdClickEventModel {
    @PrimaryKey
    private UUID id = UUID.randomUUID();;
    private UUID userId;
    private UUID adId;
    private Integer countryCode;
    private Instant clickedTimestamp;
}
