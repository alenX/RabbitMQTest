import org.apache.commons.lang.SerializationUtils;

import java.io.Serializable;

public class Producer extends EndPoint {
    public Producer(String endPointName) throws Exception {
        super(endPointName);
    }

    public void sendMessage(Serializable object) throws Exception{
        channel.basicPublish("",endPointName,null, SerializationUtils.serialize(object));
    }
}
