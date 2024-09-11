package net.sixik.sdmgamestageshelper.register;

import net.sixik.sdmgamestageshelper.stages.AbstractPlayerStage;
import net.sixik.sdmgamestageshelper.stages.types.TestType;

import java.util.HashMap;

public interface StageTypeRegister {

    HashMap<String, AbstractPlayerStage.Constructor> TYPES = new HashMap<>();

    static void register(AbstractPlayerStage.Constructor constructor) {
        if(TYPES.containsKey(constructor.getDefaultInstance().getID())) return;

        TYPES.put(constructor.getDefaultInstance().getID(), constructor);
    }

    static void init(){
    }
}
