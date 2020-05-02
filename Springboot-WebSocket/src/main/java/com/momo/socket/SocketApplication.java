package com.momo.socket;
import com.momo.socket.model.OutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class SocketApplication {
    @Autowired
    private SimpMessagingTemplate template;
    public static void main(String[] args) {
        SpringApplication.run(SocketApplication.class, args);
    }
    @Scheduled(cron = "0/10 * * * * ?")
    public void sendToTopic() throws InterruptedException {
        for(int i=0;i<100;i++){
            Thread.sleep(1000L);
            System.out.println(i);
            template.convertAndSend("/topic/game_chat01",new OutMessage("666"+i));
        }
    }
}
