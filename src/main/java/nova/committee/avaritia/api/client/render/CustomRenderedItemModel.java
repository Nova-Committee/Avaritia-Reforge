package nova.committee.avaritia.api.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.BlockModelRotation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.model.BakedModelWrapper;
import net.minecraftforge.client.model.ForgeModelBakery;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Description:
 * Author: cnlimiter
 * Date: 2022/6/4 11:28
 * Version: 1.0
 */
public class CustomRenderedItemModel extends BakedModelWrapper<BakedModel> {
    protected String namespace;
    protected String basePath;
    protected Map<String, BakedModel> partials = new HashMap<>();

    public CustomRenderedItemModel(BakedModel template, String namespace, String basePath) {
        super(template);
        this.namespace = namespace;
        this.basePath = basePath;
    }

    @Override
    public boolean isCustomRenderer() {
        return true;
    }

    @Override
    public @NotNull BakedModel handlePerspective(ItemTransforms.TransformType cameraTransformType, PoseStack mat) {
        // Super call returns originalModel, but we want to return this, else ISTER
        // won't be used.
        super.handlePerspective(cameraTransformType, mat);
        return this;
    }

    public final BakedModel getOriginalModel() {
        return originalModel;
    }

    public BakedModel getPartial(String name) {
        return partials.get(name);
    }

    public final List<ResourceLocation> getModelLocations() {
        return partials.keySet().stream().map(this::getPartialModelLocation).collect(Collectors.toList());
    }

    protected void addPartials(String... partials) {
        for (String name : partials)
            this.partials.put(name, null);
    }

    public void loadPartials(ModelBakeEvent event) {
        ForgeModelBakery modelLoader = event.getModelLoader();
        partials.replaceAll((n, v) -> loadPartial(modelLoader, n));
    }

    @SuppressWarnings("deprecation")
    protected BakedModel loadPartial(ForgeModelBakery modelLoader, String name) {
        return modelLoader.bake(getPartialModelLocation(name), BlockModelRotation.X0_Y0);
    }

    protected ResourceLocation getPartialModelLocation(String name) {
        return new ResourceLocation(namespace, "item/" + basePath + "/" + name);
    }

}
