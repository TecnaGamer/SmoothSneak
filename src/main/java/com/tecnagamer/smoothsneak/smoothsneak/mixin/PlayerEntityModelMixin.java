package com.tecnagamer.smoothsneak.smoothsneak.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;

@Mixin(BipedEntityModel.class)
public class PlayerEntityModelMixin<T extends LivingEntity> {

    @Shadow
    public ModelPart rightArm;
    @Shadow
    public ModelPart leftArm;

    @Shadow public ModelPart torso;

    @Shadow public ModelPart rightLeg;

    @Shadow public ModelPart leftLeg;

    @Shadow public ModelPart head;

    @Shadow public boolean sneaking;

    @Inject(method = "setAngles", at = @At("TAIL"))
    public void changeHandPosition(final CallbackInfo info) {

        if (this.sneaking) {
            System.out.println("Sneaking!");
            //float arm2 = 1.4F;
            //arm2 += 0.1F;
            //float arm = 1.4F;
            // arm += arm2;
            this.torso.pitch = 0.5F;
            this.rightArm.pitch += 3.1F;
            this.leftArm.pitch += 1.1F;
            this.rightLeg.pivotZ = 4.0F;
            this.leftLeg.pivotZ = 4.0F;
            this.rightLeg.pivotY = 12.2F;
            this.leftLeg.pivotY = 12.2F;
            this.head.pivotY = 4.2F;
            this.torso.pivotY = 3.2F;
            this.leftArm.pivotY = 5.2F;
            this.rightArm.pivotY = 5.2F;
        } else {
            this.torso.pitch = 0.0F;
            this.rightLeg.pivotZ = 0.1F;
            this.leftLeg.pivotZ = 0.1F;
            this.rightLeg.pivotY = 12.0F;
            this.leftLeg.pivotY = 12.0F;
            this.head.pivotY = 0.0F;
            this.torso.pivotY = 0.0F;
            this.leftArm.pivotY = 1.0F;
            this.rightArm.pivotY = 2.0F;
        }

    }









}
















