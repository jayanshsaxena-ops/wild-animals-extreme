package com.wildanimalsextreme.registry;

import com.wildanimalsextreme.WildAnimalsExtreme;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;

public class ModItems {

	public static final Item JAGUAR_SPAWN_EGG = Registry.register(
			BuiltInRegistries.ITEM,
			ResourceLocation.fromNamespaceAndPath(WildAnimalsExtreme.MOD_ID, "jaguar_spawn_egg"),
			new SpawnEggItem(ModEntities.JAGUAR, new Item.Properties())
	);

	public static void register() {
		WildAnimalsExtreme.LOGGER.info("Registered items for {}", WildAnimalsExtreme.MOD_ID);

		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS).register(entries -> {
			entries.accept(JAGUAR_SPAWN_EGG);
		});
	}
}
