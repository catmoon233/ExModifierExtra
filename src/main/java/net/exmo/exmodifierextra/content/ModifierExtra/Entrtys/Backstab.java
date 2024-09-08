package net.exmo.exmodifierextra.content.ModifierExtra.Entrtys;

import net.exmo.exmodifier.content.modifier.ModifierAttriGether;
import net.exmo.exmodifier.events.ExAddEntryAttrigetherEvent;
import net.exmo.exmodifierextra.content.ModifierExtra.ExModifierEntry;
import net.exmo.exmodifierextra.content.ModifierExtra.ExModifierHandle;
import net.exmo.exmodifierextra.init.ExModifierExtraAttributes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.exmo.exmodifierextra.content.ModifierExtra.ExModifierHandle.getItemModifierLevel;

@Mod.EventBusSubscriber
public class Backstab extends ExModifierEntry {
    public Backstab() {
        super();
        this.maxLevel = 3;
        this.type = Type.ATTACKABLE;
        this.OnlyWashItems.add("aaa");
        this.id = "Backstab ";
        this.xLevelAttributes.add(ExModifierExtraAttributes.BEHIND_DAMAGE.get());
        this.attriGether.add(new ModifierAttriGether(ExModifierExtraAttributes.BEHIND_DAMAGE.get(), new AttributeModifier("behind_damage", 0.1, AttributeModifier.Operation.MULTIPLY_TOTAL)));
        this.description = Component.literal("exmodifier.entry.description.Backstab");
    }
    @SubscribeEvent
    public static void changeAttrLevel(ExAddEntryAttrigetherEvent event) {
        double level = getItemModifierLevel(event.getStack(), "Backstab");
        // if (ExModifierHandle.modifierMap.get("Backstab").xLevelAttributes.contains(event.getSelectedAttriGether().attribute)){
        if (event.getModifierEntry().id.equals("Backstab")) {
            ModifierAttriGether modifier = event.getSelectedAttriGether();
            event.setSelectedAttriGether(new ModifierAttriGether(modifier.attribute, new AttributeModifier(modifier.modifier.getId(), modifier.modifier.getName(), modifier.modifier.getAmount() * level, modifier.modifier.getOperation())));
            //}
        }
    }
}
