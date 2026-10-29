package com.wildanimalsextreme.client;

import com.wildanimalsextreme.registry.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class WildAnimalsExtremeClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(ModEntities.JAGUAR, JaguarRenderer::new);
	}
}
