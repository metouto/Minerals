
package org.terasology.minerals.generation.oreproviders;

import org.terasology.minerals.generation.OreFacet;
import org.terasology.minerals.generation.OreProvider;
import org.terasology.utilities.procedural.SimplexNoise;
import org.terasology.world.generation.Border3D;
import org.terasology.world.generation.GeneratingRegion;
import org.terasology.world.generation.Produces;
import org.terasology.world.generator.plugin.RegisterPlugin;

@RegisterPlugin
@Produces(OreFacet.Limonite.class)
public class Limonite extends OreProvider {
    protected int index = 10;
    
    @Override
    public void process(GeneratingRegion region) {
        Border3D border = region.getBorderForFacet(OreFacet.Limonite.class);
        OreFacet facet = baseProcess(region, border, index);
        OreFacet.Limonite classFacet = facet.new Limonite(region.getRegion(), border);
        classFacet.set(facet.getInternal());
        region.setRegionFacet(OreFacet.Limonite.class, classFacet);
    }

    @Override
    public void setSeed(long seed) {
        oreNoise = new SimplexNoise(seed + index*57);
    }
}
