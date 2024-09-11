package net.sixik.sdmgamestageshelper.stages;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.util.INBTSerializable;

public abstract class AbstractPlayerStage implements INBTSerializable<CompoundTag> {

    public String stage;

    public AbstractPlayerStage(String stage){
        this.stage = stage;
    }

    public String getStage() {
        return stage;
    }

    public abstract<T>  boolean canUse(T object, ServerPlayer player);
    public abstract void execute(ServerPlayer player);
    public abstract boolean add(AbstractPlayerStage someStage);

    public abstract String getID();

    @Override
    public CompoundTag serializeNBT() {
        return new CompoundTag();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {

    }

    public static abstract class Constructor {
        public abstract AbstractPlayerStage getDefaultInstance();
    }
}
