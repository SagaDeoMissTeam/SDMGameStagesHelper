package net.sixik.sdmgamestageshelper.stages.types;

import net.minecraft.server.level.ServerPlayer;
import net.sixik.sdmgamestageshelper.stages.AbstractPlayerStage;

public class TestType extends AbstractPlayerStage {
    public TestType(String stage) {
        super(stage);
    }

    @Override
    public <T> boolean canUse(T object, ServerPlayer player) {
        return false;
    }

    @Override
    public void execute(ServerPlayer player) {

    }

    @Override
    public boolean add(AbstractPlayerStage someStage) {
        return false;
    }

    @Override
    public String getID() {
        return "testType";
    }

    public static class TestTypeConstructor extends AbstractPlayerStage.Constructor {

        @Override
        public AbstractPlayerStage getDefaultInstance() {
            return new TestType("one");
        }
    }
}
