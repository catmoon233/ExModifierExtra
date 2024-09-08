package net.exmo.exmodifierextra.content.ModifierExtra;

import net.exmo.exmodifier.content.modifier.ModifierEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.eventbus.api.Event;

import java.util.ArrayList;
import java.util.List;

public class ExModifierEntry extends ModifierEntry {
    public double maxLevel;
    public List<Attribute> xLevelAttributes = new ArrayList<>();
    public ExModifierEntry(){

    }
    public Component description;

}
