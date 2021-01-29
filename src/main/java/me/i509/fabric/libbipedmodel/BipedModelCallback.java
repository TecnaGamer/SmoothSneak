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

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.model.ArmorStandArmorEntityModel;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;

/**
 * Represents a callback which allows adjustment of a {@link BipedEntityModel}.
 *
 * <p>Note this is only accessible from the Client.</p>
 *
 * <p>This includes:
 * <table>
 *	<tr>ArmorStands</tr>
 *  <tr>{@link ArmorStandArmorEntityModel Armor on ArmorStands}</tr>
 *	<tr>Drowned</tr>
 *	<tr>Endermen</tr>
 *	<tr>Giants</tr>
 *	<tr>{@link AbstractClientPlayerEntity Players}</tr>
 *  <tr>Skeletons [and Wither Skeletons]</tr>
 *  <tr>Vex</tr>
 *  <tr>Zombies [and Husks]</tr>
 * </table>
 */
@Environment(EnvType.CLIENT)
public interface BipedModelCallback {
	Event<BipedModelCallback> EVENT = EventFactory.createArrayBacked(BipedModelCallback.class, (callbacks) -> ((bipedEntityModel, entity, limbAngle, limbDistance, customAngle, headYaw, headPitch) -> {
		for (BipedModelCallback callback : callbacks) {
			callback.adjustModel(bipedEntityModel, entity, limbAngle, limbDistance, customAngle, headYaw, headPitch);
		}
	}));

	/**
	 * Adjusts the BipedEntityModel before rendering.
	 * @param bipedEntityModel The BipedEntityModel to be rendered.
	 * @param entity The entity which is used as the context for rendering the BipedEntityModel.
	 * @param limbAngle
	 * @param limbDistance
	 * @param customAngle
	 * @param headYaw The yaw of the entity's head.
	 * @param headPitch The pitch of the entity's head.
	 */
	void adjustModel(BipedEntityModel<LivingEntity> bipedEntityModel, LivingEntity entity, float limbAngle, float limbDistance, float customAngle, float headYaw, float headPitch);
}
