package pro.stevendev.adclickeventservice.dto;

import lombok.Data;
import lombok.ToString;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@ToString
public class AdClickEventReceiverDTO {
    UUID userId;
    UUID adId;
    Integer countryCode;
    OffsetDateTime clickedTimestamp;
}
