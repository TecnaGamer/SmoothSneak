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
    float chest = 0.0F;
    float arm = 0.5F;

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

    public void setAngles(final CallbackInfo info) {
       // float smooth = 0.1F;
        //arm += smooth;

        if (this.sneaking) {
            arm = 10.0F;
            chest += 0.01F;
            System.out.println(chest);
          //  System.out.println(smooth);
            this.torso.pitch = chest;
            this.rightArm.pitch += 0.0F;
            //this.leftArm.pitch += 0.0F;
            this.rightLeg.pivotZ = 4.0F;
            this.leftLeg.pivotZ = 4.0F;
            this.rightLeg.pivotY = 12.2F;
            this.leftLeg.pivotY = 12.2F;
            this.head.pivotY = 4.2F;
            this.torso.pivotY = 3.2F;
            //this.leftArm.pivotY = 5.2F;
            this.rightArm.pivotY = 5.2F;
        } else {
            arm = 0.5F;
            chest = 0.0F;
            this.torso.pitch = 0.0F;
            this.rightLeg.pivotZ = 0.1F;
            this.leftLeg.pivotZ = 0.1F;
            this.rightLeg.pivotY = 12.0F;
            this.leftLeg.pivotY = 12.0F;
            this.head.pivotY = 0.0F;
            this.torso.pivotY = 0.0F;
            //this.leftArm.pivotY = 1.0F;
            this.rightArm.pivotY = 2.0F;
        }
            this.leftArm.pitch = arm;
            this.leftArm.pivotY = arm;

    }









}
















