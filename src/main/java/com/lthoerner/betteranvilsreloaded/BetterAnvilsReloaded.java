package com.lthoerner.betteranvilsreloaded;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.lthoerner.betteranvilsreloaded.Config;

public class BetterAnvilsReloaded implements ModInitializer {
	public static final Config CONFIG = Config.createAndLoad();
    public static final Logger LOGGER = LoggerFactory.getLogger("betteranvils-reloaded");

	@Override
	public void onInitialize() {
		LOGGER.info("BetterAnvils Reloaded v0.0.1");
	}
}
