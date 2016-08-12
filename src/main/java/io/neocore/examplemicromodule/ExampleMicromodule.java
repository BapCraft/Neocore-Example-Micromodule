package io.neocore.examplemicromodule;

import io.neocore.api.NeocoreAPI;
import io.neocore.api.event.EventManager;
import io.neocore.api.host.chat.ChatEvent;
import io.neocore.api.host.login.PostLoginEvent;
import io.neocore.api.module.JavaMicromodule;

public class ExampleMicromodule extends JavaMicromodule {
	
	protected ExampleMicromodule inst;
	
	@Override
	public void onEnable() {
		
		inst = this;
		
		// Get the manager
		EventManager em = NeocoreAPI.getAgent().getEventManager();
		
		// Register the listeners
		em.registerListener(this, ChatEvent.class, new ChatListener(this), 0);
		em.registerListener(this, PostLoginEvent.class, new LoginListener(this), 0);
		
	}
	
	@Override
	public void onDisable() {
		
		inst = null;
		
	}
	
}
