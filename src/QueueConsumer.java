import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QueueConsumer extends EndPoint implements Runnable, Consumer {
    public QueueConsumer(String endPointName) throws Exception {
        super(endPointName);
    }

    @Override
    public void run() {
        try {
            channel.basicConsume(endPointName,true,this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void handleConsumeOk(String consumerTag) {

        System.out.println("消费者"+consumerTag+"注册");
    }

    @Override
    public void handleCancelOk(String consumerTag) {

    }

    @Override
    public void handleCancel(String consumerTag) throws IOException {

    }

    @Override
    public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {

    }

    @Override
    public void handleRecoverOk(String consumerTag) {

    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

        Map map = (HashMap)SerializationUtils.deserialize(body);

        System.out.println("Message Number "+map.get("message number")+" received");
    }
}
