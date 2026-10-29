package com.wildanimalsextreme.client;

import com.wildanimalsextreme.entity.JaguarEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import com.geckolib.renderer.GeoEntityRenderer;

public class JaguarRenderer extends GeoEntityRenderer<JaguarEntity> {

	public JaguarRenderer(EntityRendererProvider.Context context) {
		super(context, new JaguarModel());
		this.shadowRadius = 0.75f;
	}
}
