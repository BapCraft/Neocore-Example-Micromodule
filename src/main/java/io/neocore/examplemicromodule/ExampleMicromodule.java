package io.neocore.examplemicromodule;

import io.neocore.api.module.JavaMicromodule;

public class ExampleMicromodule extends JavaMicromodule {
	
	protected ExampleMicromodule inst;
	
	@Override
	public void onEnable() {
		
		inst = this;
		
	}
	
	@Override
	public void onDisable() {
		
		inst = null;
		
	}
	
}
