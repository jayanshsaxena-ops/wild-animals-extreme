package com.wildanimalsextreme.registry;

import com.wildanimalsextreme.WildAnimalsExtreme;
import com.wildanimalsextreme.entity.JaguarEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {

	public static final EntityType<JaguarEntity> JAGUAR = Registry.register(
			BuiltInRegistries.ENTITY_TYPE,
			ResourceLocation.fromNamespaceAndPath(WildAnimalsExtreme.MOD_ID, "jaguar"),
			FabricEntityTypeBuilder.create(MobCategory.CREATURE, JaguarEntity::new)
					.dimensions(EntityDimensions.scalable(1.3f, 1.0f))
					.trackRangeChunks(10)
					.build()
	);

	public static void register() {
		WildAnimalsExtreme.LOGGER.info("Registered entities for {}", WildAnimalsExtreme.MOD_ID);
	}
}
