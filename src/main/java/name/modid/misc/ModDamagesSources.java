package name.modid.misc;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.entry.RegistryEntry;

public class ModDamagesSources {

    public static final DamageSource BIC_PROJECTILE = registerDamageSource("bic_crystal_entity", 1f);
    public static DamageSource registerDamageSource(String msgID, float exhaustion) {
        return new DamageSource(RegistryEntry.of(new DamageType(msgID, exhaustion)));
    }
}
