package Response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreatePlanResponse {
    private String status;
    private String message;
}
