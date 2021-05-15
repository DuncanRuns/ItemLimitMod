package me.duncanruns.itemlimitmod.mixin;

import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Inject(at=@At("RETURN"),method="getMaxCount",cancellable = true)
    private void getMaxCountMixin(CallbackInfoReturnable<Integer> info){
        if(info.getReturnValue() > 5){
            info.setReturnValue(5);
        }
    }
}
