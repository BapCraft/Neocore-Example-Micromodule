package io.neocore.examplemicromodule;

import io.neocore.api.NeocoreAPI;
import io.neocore.api.host.broadcast.BroadcastService;
import io.neocore.api.host.chat.ChatEvent;
import io.neocore.api.listeners.SimpleListener;
import io.neocore.api.module.Module;

public class ChatListener implements SimpleListener<ChatEvent> {

	private ExampleMicromodule module;
	
	public ChatListener(ExampleMicromodule exMm) {
		this.module = exMm;
	}
	
	@Override
	public Module getModule() {
		return this.module;
	}
	
	@Override
	public void accept(ChatEvent t) {
		
		String message = t.getMessage();
		String msgLc = message.toLowerCase();
		
		// Get the broadcast service and send the message, if applicable.
		BroadcastService serv = NeocoreAPI.getAgent().getServiceManager().getService(BroadcastService.class);
		if (msgLc.contains("hello") || msgLc.contains("hi")) serv.broadcast("Hello " + t.getPlayer().getUsername() + "!");
		
	}
	
}
