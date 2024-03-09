package com.stoon.items;

import com.stoon.Reedlands;
import com.wurmonline.server.behaviours.BehaviourList;
import com.wurmonline.server.bodys.BodyTemplate;
import com.wurmonline.server.items.*;
import com.wurmonline.server.skills.SkillList;
import com.wurmonline.shared.constants.ItemMaterials;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;
import org.tyoda.wurm.Iconzz.Iconzz;
import java.io.IOException;
import java.util.logging.Level;

public class HatConi {
    public static ItemTemplate conihat = null;
    public static void HatConiBuilder() {
        try {
            conihat = new ItemTemplateBuilder("stoon.reedlands.HatConi")
                    .behaviourType(BehaviourList.itemBehaviour)
                    .name("conical hat", "conical hats", "A conical hat made popular in the land of reeds.")
                    .modelName("model.armour.head.hat.conical.")
                    .imageNumber(Iconzz.getInstance().addIcon("mod.stoon.hatconiicon", "mods/icons/hatconiicon.png"))
                    .weightGrams(400)
                    .dimensions(25, 30, 30)
                    .decayTime(3024000L)
                    .value(10000)
                    .material(ItemMaterials.MATERIAL_COTTON)
                    .behaviourType((short) 1)
                    .bodySpaces(new byte[]{BodyTemplate.head, BodyTemplate.secondHead})
                    .primarySkill(SkillList.CLOTHTAILORING)
                    .difficulty(20)
                    .itemTypes(new short[]{
                            ItemTypes.ITEM_TYPE_ARMOUR,
                            ItemTypes.ITEM_TYPE_CLOTH,
                            ItemTypes.ITEM_TYPE_COLORABLE,
                            ItemTypes.ITEM_TYPE_EQUIPMENTSLOT,
                            ItemTypes.ITEM_TYPE_REPAIRABLE,
                            ItemTypes.ITEM_TYPE_NOT_MISSION
                    }).build();

        } catch (IOException e) {
            Reedlands.logger.log(Level.SEVERE, "ERROR BUILDING CONICAL HAT");
        }
        if (conihat != null) {
            AdvancedCreationEntry conihatLogCreation = CreationEntryCreator.createAdvancedEntry(
                    SkillList.CLOTHTAILORING, ItemList.woolYarn, ItemList.needleIron, conihat.getTemplateId(), true, false, 10.0F, false, false, 0, 10, CreationCategories.ARMOUR
            );
            conihatLogCreation.addRequirement(new CreationRequirement(1, ItemList.reedFibre, 4, true));
            conihatLogCreation.addRequirement(new CreationRequirement(2, ItemList.rope, 1, true));
        }
    }
}
