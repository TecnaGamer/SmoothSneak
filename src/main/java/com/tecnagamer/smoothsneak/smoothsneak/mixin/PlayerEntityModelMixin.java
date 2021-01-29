package com.tecnagamer.smoothsneak.smoothsneak.mixin;

import net.minecraft.entity.EquipmentSlot;
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
    float torsop = 0.0F;
    float torsoy = 0.0F;
    float armY = 2.0F;
    float armp = 0.0F;
    float heady = 0.0F;
    float legz = 0.1F;
    float legy = 12.0F;


    @Shadow
    public ModelPart rightArm;
    @Shadow
    public ModelPart leftArm;

    @Shadow public ModelPart torso;

    @Shadow public ModelPart rightLeg;

    @Shadow public ModelPart leftLeg;

    @Shadow public ModelPart head;

    @Shadow public boolean sneaking;

    @Shadow public ModelPart helmet;

    @Inject(method = "setAngles", at = @At("TAIL"))

    public void setAngles(final CallbackInfo info) {
        ModelPart var10000;
        if (this.sneaking) {
            if (armY < 5.2F) {
                armY += 0.52F;
            } else {
                armY = 5.2F;
            }
            if (armp < 0.4F) {
                armp += 0.04F;
            } else {
                armp = 0.4F;
            }
            if (torsop < 0.5F) {
                torsop += 0.05F;
            }   else {
                torsop = 0.5F;
            }
            if (torsoy < 3.2F) {
                torsoy += 0.32F;
            } else {
                torsoy = 3.2F;
            }
            if (heady < 4.2F) {
                heady += 0.42F;
            } else {
                heady = 4.2F;
            }
            if (legz < 4.0F) {
                legz += 0.39;
            } else {
                legz = 4.0F;
            }
            if (legy < 12.2F) {
                legy += 0.02F;
            } else {
                legy = 12.2F;
            }

            var10000 = this.rightArm;
            var10000.pitch -= 0.4F;
            var10000 = this.leftArm;
            var10000.pitch -= 0.4F;

        } else {
            if (armY > 2.0F) {
              armY -= 0.52F;
            } else {
                armY = 2.0F;
            }
            if (armp > 0.0F) {
                armp -= 0.04F;
            } else {
                armp = 0.0F;
            }
            if (torsop > 0.0F) {
                torsop -= 0.05F;
            }   else {
                torsop = 0.0F;
            }
            if (torsoy > 0.0F) {
                torsoy -= 0.32F;
            } else {
                torsoy = 0.0F;
            }
            if (heady > 0.0F) {
                heady -= 0.42F;
            } else {
                heady = 0.0F;
            }
            if (legz > 0.1F) {
                legz -= 0.39;
            } else {
                legz = 0.1F;
            }
            if (legy > 12.0F) {
                legy -= 0.02F;
            } else {
                legy = 12.0F;
            }
        }
            this.torso.pitch = torsop;
            this.torso.pivotY = torsoy;
            this.rightArm.pivotY = armY;
            this.leftArm.pivotY = armY;
            var10000 = this.rightArm;
            var10000.pitch += armp;
            var10000 = this.leftArm;
            var10000.pitch += armp;
            this.head.pivotY = heady;
            this.helmet.pivotY = heady;
            this.rightLeg.pivotZ = legz;
            this.leftLeg.pivotZ = legz;
            
    }









}
















