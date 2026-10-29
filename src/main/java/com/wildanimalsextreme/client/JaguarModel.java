package com.wildanimalsextreme.client;

import com.wildanimalsextreme.WildAnimalsExtreme;
import com.wildanimalsextreme.entity.JaguarEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class JaguarModel extends DefaultedEntityGeoModel<JaguarEntity> {

	public JaguarModel() {
		// Looks for:
		// assets/wild_animals_extreme/geo/jaguar.geo.json
		// assets/wild_animals_extreme/animations/jaguar.animation.json
		// assets/wild_animals_extreme/textures/entity/jaguar.png
		super(ResourceLocation.fromNamespaceAndPath(WildAnimalsExtreme.MOD_ID, "jaguar"));
	}
}
