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

public class HairKnot {
    public static ItemTemplate knothair = null;

    public static void HairKnotBuilder() {
        try {
            knothair = new ItemTemplateBuilder("stoon.reedlands.HairKnot")
                    .behaviourType(BehaviourList.itemBehaviour)
                    .name("topknot wig", "topknot wigs", "A popular hairstyle in the land of reeds.")
                    .modelName("model.armour.head.wig.topknot.")
                    .imageNumber(Iconzz.getInstance().addIcon("mod.stoon.hairknoticon", "mods/icons/hairknoticon.png"))
                    .weightGrams(400)
                    .dimensions(25, 30, 30)
                    .decayTime(3024000L)
                    .value(10000)
                    .material(ItemMaterials.MATERIAL_WOOL)
                    .behaviourType((short) 1)
                    .bodySpaces(new byte[]{BodyTemplate.head, BodyTemplate.secondHead})
                    .primarySkill(SkillList.CLOTHTAILORING)
                    .difficulty(50)
                    .itemTypes(new short[]{
                            ItemTypes.ITEM_TYPE_ARMOUR,
                            ItemTypes.ITEM_TYPE_CLOTH,
                            ItemTypes.ITEM_TYPE_COLORABLE,
                            ItemTypes.ITEM_TYPE_EQUIPMENTSLOT,
                            ItemTypes.ITEM_TYPE_REPAIRABLE,
                            ItemTypes.ITEM_TYPE_NOT_MISSION
                    }).build();

        } catch (IOException e) {
            Reedlands.logger.log(Level.SEVERE, "ERROR BUILDING TOPKNOT WIG");
        }
        if (knothair != null) {
            AdvancedCreationEntry knothairLogCreation = CreationEntryCreator.createAdvancedEntry(
                    SkillList.CLOTHTAILORING, ItemList.wool, ItemList.scissors, knothair.getTemplateId(), true, false, 10.0F, false, false, 0, 50, CreationCategories.ARMOUR
            );
            knothairLogCreation.addRequirement(new CreationRequirement(1, ItemList.clothHoodWhite, 1, true));
            knothairLogCreation.addRequirement(new CreationRequirement(2, ItemList.wool, 5, true));
        }
    }
}