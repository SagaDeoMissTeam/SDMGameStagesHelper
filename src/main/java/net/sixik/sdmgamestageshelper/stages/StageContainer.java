package net.sixik.sdmgamestageshelper.stages;

import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.sixik.sdmgamestageshelper.register.StageTypeRegister;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class StageContainer extends SimplePreparableReloadListener<Void> {

    public static StageContainer INSTANCE = new StageContainer();

    public HashMap<String, List<AbstractPlayerStage>> STAGES = new HashMap<>();

    public void create(){
        STAGES.clear();

        for (String s : StageTypeRegister.TYPES.keySet()) {
            STAGES.put(s, new ArrayList<>());
        }
    }

    public void put(AbstractPlayerStage stage) {
        List<AbstractPlayerStage> players = STAGES.getOrDefault(stage.getID(), new ArrayList<>());
        for (AbstractPlayerStage player : players) {
            if(player.add(stage)){
                return;
            }
        }

        players.add(stage);
    }

    public List<? extends AbstractPlayerStage> getKeys(AbstractPlayerStage.Constructor typeClass) {
        return STAGES.get(typeClass.getDefaultInstance().getID()).stream()
                .filter(stage -> stage.getClass().equals(typeClass.getDefaultInstance().getClass()))
                .map(stage -> typeClass.getDefaultInstance().getClass().cast(stage))
                .collect(Collectors.toList());
    }

    @Nullable
    public List<AbstractPlayerStage> getStage(String id) {
        return STAGES.get(id);
    }

    @Override
    protected Void prepare(ResourceManager p_10796_, ProfilerFiller p_10797_) {
        return null;
    }

    @Override
    protected void apply(Void p_10793_, ResourceManager p_10794_, ProfilerFiller p_10795_) {
        create();
    }
}
