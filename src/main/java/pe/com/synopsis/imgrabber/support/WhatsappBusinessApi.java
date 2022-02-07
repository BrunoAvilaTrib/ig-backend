
package pe.com.synopsis.imgrabber.support;

import org.springframework.stereotype.Component;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import pe.com.synopsis.imgrabber.beans.request.RegisterMessageRequest;
import pe.com.synopsis.imgrabber.beans.response.Response;
import pe.com.synopsis.imgrabber.enumeration.StatusEnum;

@Component
public class WhatsappBusinessApi
{

    // Replace these placeholders with your Account Sid and Auth Token
    public static final String ACCOUNT_SID = "ACf9720421ecbb5e4ee667d8e8b75b5bd8";
    public static final String AUTH_TOKEN = "d17700c46a7b464a7a89a5793abd4755";
    public static final String SID = "SM3180a190c8554400bb272fa9756c3a20";

    public Response<String> send(RegisterMessageRequest requestMessage)
    {

        Response<String> response = new Response<String>();
        /* Twilio.init(ACCOUNT_SID, AUTH_TOKEN, SID); */
        try
        {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

            String numero = requestMessage.getChatMobile();
            numero = "whatsapp:+51" + numero;
            Message message = Message
                    .creator(new com.twilio.type.PhoneNumber(numero),
                            new com.twilio.type.PhoneNumber("whatsapp:+14155238886"), requestMessage.getMsgText())
                    .create();
            response.setData(message.toString());
            response.setStatus(StatusEnum.STATUS_SUCCESSFULL.create());
        }
        catch (Exception e)
        {
            response.setStatus(StatusEnum.STATUS_FAIL.create());
        }
        return response;
    }
}
