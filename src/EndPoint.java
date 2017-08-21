
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public abstract class EndPoint {

    protected  Channel channel;
    protected Connection connection;
    protected String endPointName;

    public EndPoint(String endPointName) throws Exception{

        this.endPointName = endPointName;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        this.connection = factory.newConnection();
        this.channel = this.connection.createChannel();
        this.channel.queueDeclare(this.endPointName,false,false,false,null);
    }

    public void close() throws IOException, TimeoutException {
        this.channel.close();
        this.connection.close();
    }

}
