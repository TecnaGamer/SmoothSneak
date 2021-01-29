/*
 * MIT License
 *
 * Copyright (c) 2020 i509VCB
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package me.i509.fabric.libbipedmodel;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;

/**
 * Note this is only accessible from the Client.</p>
 */
@Environment(EnvType.CLIENT)
public class LibBipedModel implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Example Code: Register an event for example
		// BipedModelCallback.EVENT.register(this::tPose);
	}

	private void tPose(BipedEntityModel<LivingEntity> bipedEntityModel, LivingEntity entity, float limbAngle, float limbDistance, float customAngle, float headYaw, float headPitch) {
		/*
		 * Check your condition, DO NOT JUST MODIFY THE POSITIONS LIKE A JACKASS. and then transform if you feel the need to.
		 * If you need a player for example, you can instanceof check the LivingEntity, please use AbstractClientPlayerEntity if you use a player
		 * You can also cast up the bipedEntityModel to a PlayerEntityModel for example.
		 *
		 * This code below checks if the entity has a Diamond Block in either of their hands, if the entity does, adjust the entityModel so the entity will T-Pose.
		*/
		if (entity.getMainHandStack().getItem() == Items.DIAMOND_BLOCK || entity.getOffHandStack().getItem() == Items.DIAMOND_BLOCK) {
			bipedEntityModel.leftArm.roll = bipedEntityModel.leftArm.roll - 1.75F;
			bipedEntityModel.leftArm.yaw = bipedEntityModel.leftArm.yaw + 0.35F;
			bipedEntityModel.rightArm.roll = bipedEntityModel.rightArm.roll + 1.75F;
			bipedEntityModel.rightArm.yaw = bipedEntityModel.rightArm.yaw + 0.35F;
		}
	}
}
