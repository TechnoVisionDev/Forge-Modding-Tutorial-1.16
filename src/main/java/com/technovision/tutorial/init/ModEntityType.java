package com.technovision.tutorial.init;

import com.technovision.tutorial.Tutorial;
import com.technovision.tutorial.entities.HogEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityType {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Tutorial.MOD_ID);

    // Entity Types
    public static final RegistryObject<EntityType<HogEntity>> GOAT = ENTITY_TYPES.register("goat",
            () -> EntityType.Builder.create(HogEntity::new, EntityClassification.CREATURE)
                    .size(1.0f, 1.0f) // Hitbox
                    .build(new ResourceLocation(Tutorial.MOD_ID, "goat").toString()));
}
