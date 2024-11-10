package net.exmo.exmodifierextra.content.ModifierExtra.Entrtys;

import net.exmo.exmodifier.content.helper.register.ModifierAttriGetherCreateHelper;
import net.exmo.exmodifier.content.helper.register.ModifierCreateHelper;
import net.exmo.exmodifier.content.modifier.ModifierAttriGether;
import net.exmo.exmodifier.content.modifier.ModifierEntry;
import net.exmo.exmodifier.events.ExAddEntryAttrigetherEvent;
import net.exmo.exmodifier.init.ExAttribute;
import net.exmo.exmodifierextra.init.ExModifierExtraAttributes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Backstab extends ModifierEntry {
    public Backstab() {
        this.maxLevel = 3;
        this.type = Type.ATTACKABLE;
        this.weight = 3;
        this.id = "ATbackstab ";
        ModifierAttriGether e =new  ModifierAttriGetherCreateHelper(0).setWeight(3).setModifierCreateHelper(ExAttribute.BEHIND_DAMAGE.get(), 0.1,AttributeModifier.Operation.MULTIPLY_BASE,"auto").setName("behind_entry_damage0").finish();
                //new ModifierAttriGether(ExAttribute.BEHIND_DAMAGE.get(), new AttributeModifier("behind_damage", 0.1, AttributeModifier.Operation.MULTIPLY_BASE)).setExpression("level");
        e.setExpression("level*0.1");
        this.attriGether.add(e);
        this.localDescription = "modifier.entry.description.backstab";
    }
}
