package com.wildanimalsextreme.client;

import com.wildanimalsextreme.WildAnimalsExtreme;
import com.wildanimalsextreme.entity.JaguarEntity;
import net.minecraft.resources.ResourceLocation;
import com.geckolib.model.DefaultedEntityGeoModel;

public class JaguarModel extends DefaultedEntityGeoModel<JaguarEntity> {

	public JaguarModel() {
		super(ResourceLocation.fromNamespaceAndPath(WildAnimalsExtreme.MOD_ID, "jaguar"));
	}
}
