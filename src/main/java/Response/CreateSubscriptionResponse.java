package Response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreateSubscriptionResponse {
    private String status;
    private String message;
    private String subReferenceId;
    private String authLink;
    private String subStatus;
}
