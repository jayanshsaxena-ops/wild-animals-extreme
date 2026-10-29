package com.wildanimalsextreme;

import com.wildanimalsextreme.registry.ModEntities;
import com.wildanimalsextreme.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WildAnimalsExtreme implements ModInitializer {
	public static final String MOD_ID = "wild_animals_extreme";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Wild Animals Extreme loading...");

		ModEntities.register();
		ModItems.register();

		FabricDefaultAttributeRegistry.register(ModEntities.JAGUAR, com.wildanimalsextreme.entity.JaguarEntity.createAttributes());
	}
}
