package net.exmo.exmodifierextra.content.ModifierExtra;

import net.exmo.exmodifier.content.modifier.ModifierEntry;
import net.exmo.exmodifier.content.modifier.ModifierHandle;
import net.exmo.exmodifier.events.ExEntryTooltipEvent;
import net.exmo.exmodifierextra.Exmodifierextra;
import net.exmo.exmodifierextra.content.ModifierExtra.Entrtys.Backstab;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExModifierHandle {
    public static Map<String, ExModifierEntry> modifierMap = new HashMap<>();

    public static void RegisterExEntry(ExModifierEntry entry) {
        modifierMap.put(entry.getId(), entry);
        ModifierHandle.RegisterModifierEntry(entry);

    }

    public static ExModifierEntry getExModifierEntry(ModifierEntry e) {
        return modifierMap.get(e.getId());
    }
    public static void init() {
        RegisterExEntry(new Backstab());

    }
    public static double getItemModifierLevel(ItemStack stack, String id) {
        if (stack.getTag() != null) {
            return stack.getTag().getDouble(id + "Level");
        }
        return 0;
    }
    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event){
        init();
    }

    @Mod.EventBusSubscriber
    public static   class CommonEvents {
        @SubscribeEvent
        public static void TooltipsChange(ExEntryTooltipEvent event) {
            ExModifierEntry exmod = getExModifierEntry(event.getModifierEntry());
            //Exmodifierextra.LOGGER.debug("test a");
            if (exmod != null) {
                List<Component> tooltip = new ArrayList<>();
                tooltip.add(event.getTooltip().get(0));
                tooltip.add(exmod.description);

                for (int i = 1; i < event.getTooltip().size(); i++) {
                    tooltip.add(event.getTooltip().get(i));
                }
                event.setTooltip(tooltip);
            }

        }

        @SubscribeEvent
        public static void addReloadListener(AddReloadListenerEvent event) {
            init();
        }
    }
}
