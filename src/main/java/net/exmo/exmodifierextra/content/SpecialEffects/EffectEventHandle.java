package net.exmo.exmodifierextra.content.SpecialEffects;

import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EffectEventHandle {
//    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
//    public void onLivingHurtEvent(LivingHurtEvent event) {
//        if (event.getEntity() != null && event.getSource().getEntity() != null) {
//            if (event.getSource().getEntity() instanceof LivingEntity attacker) {
//               LivingEntity victim = event.getEntity();
////            Entity attacker = event.getSource().getEntity();
//
//                    Vec3 viewVector = victim.getViewVector(1.0F);
//                    float dotProduct = getDotProduct(viewVector, attacker, victim);
//
//                    // If dot product is less than 0, the attacker is behind the victim
//                    if (dotProduct < 0) {
//                        // Logic for when the attack comes from behind
//                        if (attacker.getAttribute(ExModifierExtraAttributes.BEHIND_DAMAGE.get())!=null){
//                            event.setAmount((float) (event.getAmount()*attacker.getAttribute(ExModifierExtraAttributes.BEHIND_DAMAGE.get()).getValue()));
//                        }
//                        System.out.println("Entity was attacked from behind!");
//                    }
//                }
//
//        }
//    }
//
//    private static float getDotProduct(Vec3 viewVector, Entity attacker, Entity victim) {
//        Vector3f victimLookVec = new Vector3f((float) viewVector.x, (float) viewVector.y, (float) viewVector.z);
//        Vector3f attackerPosVec = new Vector3f((float) (attacker.getX() - victim.getX()),
//                (float) (attacker.getY() - victim.getY()),
//                (float) (attacker.getZ() - victim.getZ()));
//
//        victimLookVec.normalize();
//        attackerPosVec.normalize();
//
//        // Calculate the dot product
//        float dotProduct = victimLookVec.dot(attackerPosVec);
//        return dotProduct;
//    }
}
