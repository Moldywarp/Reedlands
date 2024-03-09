package com.stoon.items;

import com.stoon.Reedlands;
import com.wurmonline.server.behaviours.BehaviourList;
import com.wurmonline.server.items.*;
import com.wurmonline.server.skills.SkillList;
import com.wurmonline.shared.constants.ItemMaterials;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;
import org.tyoda.wurm.Iconzz.Iconzz;
import java.io.IOException;
import java.util.logging.Level;

public class DecoFold {
    public static ItemTemplate decofold = null;
    public static void DecoFoldBuilder() {
        try {
            decofold = new ItemTemplateBuilder("stoon.reedlands.DecoFold")
                    .behaviourType(BehaviourList.itemBehaviour)
                    .name("folding screen", "folding screens", "A folding screen from the land of reeds, often used to obscure part of a room for discretionary purposes.")
                    .imageNumber(Iconzz.getInstance().addIcon("mod.stoon.decofoldicon", "mods/icons/decofoldicon.png"))
                    .modelName("model.decoration.foldingscreen.")
                    .weightGrams(2000)
                    .dimensions(100, 100, 100)
                    .decayTime(3024000L)
                    .value(10000)
                    .material(ItemMaterials.MATERIAL_WOOD_BIRCH)
                    .behaviourType((short) 1)
                    .primarySkill(SkillList.CARPENTRY_FINE)
                    .difficulty(10)
                    .itemTypes(new short[]{
                            ItemTypes.ITEM_TYPE_DECORATION,
                            ItemTypes.ITEM_TYPE_NOT_MISSION,
                            ItemTypes.ITEM_TYPE_REPAIRABLE

                    }).build();

        } catch (IOException e) {
            Reedlands.logger.log(Level.SEVERE, "ERROR BUILDING FOLDING SCREEN");
        }
        if (decofold != null) {
            AdvancedCreationEntry decofoldLogCreation = CreationEntryCreator.createAdvancedEntry(
                    SkillList.CARPENTRY_FINE, ItemList.plank, ItemList.saw, decofold.getTemplateId(), true, false, 10.0F, false, false, 0, 10, CreationCategories.FURNITURE
            );
            decofoldLogCreation.addRequirement(new CreationRequirement(1, ItemList.papyrusSheet, 4, true));
            decofoldLogCreation.addRequirement(new CreationRequirement(2, ItemList.metalRivet, 1, true));
        }
    }
}
