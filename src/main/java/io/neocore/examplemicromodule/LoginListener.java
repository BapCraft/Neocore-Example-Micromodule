package io.neocore.examplemicromodule;

import java.util.function.Consumer;

import io.neocore.api.NeocoreAPI;
import io.neocore.api.host.broadcast.BroadcastService;
import io.neocore.api.host.login.PostLoginEvent;
import io.neocore.api.listeners.SimpleListener;
import io.neocore.api.module.Module;

public class LoginListener implements SimpleListener, Consumer<PostLoginEvent> {

	private ExampleMicromodule module;
	
	public LoginListener(ExampleMicromodule exMm) {
		this.module = exMm;
	}
	
	@Override
	public Module getModule() {
		return this.module;
	}
	
	@Override
	public void accept(PostLoginEvent t) {
		
		// Get the name of the player and send the greeting.
		BroadcastService serv = NeocoreAPI.getAgent().getServiceManager().getService(BroadcastService.class);
		serv.broadcast("Greetings, " + t.getPlayer().getUsername() + "!");
		
	}

}
