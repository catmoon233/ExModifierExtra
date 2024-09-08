/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.exmo.exmodifierextra.init;

import net.exmo.exmodifierextra.Exmodifierextra;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExModifierExtraAttributes {
	public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, Exmodifierextra.MODID);
	public static final RegistryObject<Attribute> BEHIND_DAMAGE = ATTRIBUTES.register("behind_damage", () -> (new RangedAttribute("attribute." + Exmodifierextra.MODID + ".behind_damage", 1, -100000000, 100000000)).setSyncable(true));

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ATTRIBUTES.register(FMLJavaModLoadingContext.get().getModEventBus());
		});
	}

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		List<EntityType<? extends LivingEntity>> entityTypes = event.getTypes();
		entityTypes.forEach((e) -> {
			Class<? extends Entity> baseClass = e.getBaseClass();
			if (baseClass.isAssignableFrom(Mob.class)) {
				event.add(e, BEHIND_DAMAGE.get());
			}
		});

	}

	@Mod.EventBusSubscriber
	private class Utils {
		@SubscribeEvent
		public static void persistAttributes(PlayerEvent.Clone event) {
			Player oldP = event.getOriginal();
			Player newP = (Player) event.getEntity();
			newP.getAttribute(BEHIND_DAMAGE.get()).setBaseValue(oldP.getAttribute(BEHIND_DAMAGE.get()).getBaseValue());

		}
	}
}
