package com.example.drove;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.drove.item.DroneControllerItem;
import com.example.drove.item.DroneItem;
import com.example.drove.block.DroneCrateBlock;

public class DroveMod implements ModInitializer {
    public static final String MOD_ID = "mc-drove";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final Item DRONE_CONTROLLER = new DroneControllerItem(new Item.Settings());
    public static final Item DRONE_ITEM = new DroneItem(new Item.Settings());
    public static final Block DRONE_CRATE = new DroneCrateBlock(net.minecraft.block.AbstractBlock.Settings.create().strength(3.0f));

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing mc-drove mod!");

        Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "drone_controller"), DRONE_CONTROLLER);
        Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "drone"), DRONE_ITEM);
        Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, "drone_crate"), DRONE_CRATE);
        Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "drone_crate"), new Item(new Item.Settings().ruptedException(null).mapBlock(DRONE_CRATE)));
    }
}
