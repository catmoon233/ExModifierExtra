package net.exmo.exmodifierextra.content.ModifierExtra;

import net.exmo.exmodifier.content.helper.register.ModifierCreateHelper;
import net.exmo.exmodifier.content.modifier.ModifierEntry;
import net.exmo.exmodifier.content.modifier.ModifierHandle;
import net.exmo.exmodifier.events.ExEntryRegistryEvent;
import net.exmo.exmodifier.events.ExEntryTooltipEvent;
import net.exmo.exmodifier.init.ExAttribute;
import net.exmo.exmodifierextra.Exmodifierextra;
import net.exmo.exmodifierextra.content.ModifierExtra.Entrtys.Backstab;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mod.EventBusSubscriber
public class ExModifierHandle {
    public static ModifierEntry backstab ;

    @SubscribeEvent
    public static void registerEntry(ExEntryRegistryEvent event){
       backstab = ModifierCreateHelper
                .CreateNew("backstab", ModifierEntry.Type.ATTACKABLE).setLocalDescription("modifier.entry.description.backstab")
               .weight(3)
               .setMaxLevel(3)
               .cantSelect(true)
                .addModifierAttriGether().setModifierCreateHelper(ExAttribute.BEHIND_DAMAGE.get()
                        , 0.1, AttributeModifier.Operation.MULTIPLY_BASE,"auto").setExpression("level *0.1").finish_add()
                .finish();
        event.register(backstab);
    }
}
