package com.momo.socket.controller.v1;

import com.momo.socket.model.InMessage;
import com.momo.socket.model.OutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class GameInfoController {
	@MessageMapping("/controller/chat")//接收浏览器的消息
	@SendTo("/topic/game_chat")//对服务端来说是发布,对浏览器来说是订阅
	public OutMessage gameInfo(InMessage message){
		return new OutMessage(message.getContent());
	}
}



