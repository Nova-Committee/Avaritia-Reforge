package nova.committee.avaritia;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import nova.committee.avaritia.common.item.EndestPearlItem;
import nova.committee.avaritia.init.config.ModConfig;
import nova.committee.avaritia.init.handler.SingularityRegistryHandler;
import nova.committee.avaritia.init.proxy.ClientProxy;
import nova.committee.avaritia.init.proxy.IProxy;
import nova.committee.avaritia.init.proxy.ServerProxy;
import nova.committee.avaritia.init.registry.*;

/**
 * Description:
 * Author: cnlimiter
 * Date: 2022/5/15 10:10
 * Version: 1.0
 */
@Mod(Static.MOD_ID)
public class Avaritia {
    public static final IProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);

    public Avaritia() {
        ModConfig.register();

        ModBlocks.init();
        ModEntities.init();
        ModItems.init();
        ModMenus.init();
        ModRecipeTypes.init();
        ModTileEntities.init();

        proxy.init();
    }

    @SubscribeEvent
    public void setup(final FMLCommonSetupEvent event) {
        SingularityRegistryHandler.getInstance().writeDefaultSingularityFiles();
        event.enqueueWork(EndestPearlItem::registerDispenser);
    }


}
