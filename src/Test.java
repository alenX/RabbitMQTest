import java.util.HashMap;

public class Test {
    public static void main(String[] args) throws Exception  {

        new Test().init();
    }

    public void init() throws Exception{
        QueueConsumer consumer = new QueueConsumer("queue");
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();


        Producer producer = new Producer("queue");
        for (int i = 0;i<10;i++){
            HashMap message = new HashMap();
            message.put("message number",i);
            producer.sendMessage(message);
            System.out.println("Message Number"+i+"send message");
        }
    }
}
