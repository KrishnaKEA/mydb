package ongoing.carrus.error;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest request, ErrorAttributeOptions options) {
        // Let Spring handle the error first, we will modify later :)
        Map<String, Object> errorAttributes = super.getErrorAttributes(request, options );

        errorAttributes.remove("timestamp"); //Get rid of the timestamp
        return errorAttributes;
    }

}
