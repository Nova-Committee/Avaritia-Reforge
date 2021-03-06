package nova.committee.avaritia;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Description:
 * Author: cnlimiter
 * Date: 2022/3/31 11:37
 * Version: 1.0
 */
public class Static {
    public static final String MOD_ID = "avaritia";

    public static final Logger LOGGER = LogManager.getLogger();

    public static ResourceLocation rl(String path) {
        return new ResourceLocation(MOD_ID, path);
    }


    public static boolean isLoad(String name) {
        return ModList.get().isLoaded(name);
    }

}
