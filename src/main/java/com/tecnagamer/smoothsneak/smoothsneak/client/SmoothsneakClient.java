package com.tecnagamer.smoothsneak.smoothsneak.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class SmoothsneakClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
    System.out.println("SmoothSneak is a go!");
    }
}
