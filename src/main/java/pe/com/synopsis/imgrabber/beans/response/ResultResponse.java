
package pe.com.synopsis.imgrabber.beans.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(includeFieldNames = true)
public class ResultResponse extends Response<String>
{

    @Getter
    @Setter
    private boolean result;

}
