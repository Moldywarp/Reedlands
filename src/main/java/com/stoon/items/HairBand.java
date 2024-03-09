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

public class HairBand {
    public static ItemTemplate headband = null;

    public static void HairBandBuilder() {
        try {
            headband = new ItemTemplateBuilder("stoon.reedlands.HairBand")
                    .behaviourType(BehaviourList.itemBehaviour)
                    .name("head band", "head bands", "A head band commonly worn by peasants and travelers from the land of reeds.")
                    .modelName("model.armour.head.wig.headband.")
                    .imageNumber(Iconzz.getInstance().addIcon("mod.stoon.hairbandicon", "mods/icons/hairbandicon.png"))
                    .weightGrams(300)
                    .dimensions(25, 30, 30)
                    .decayTime(3024000L)
                    .value(10000)
                    .material(ItemMaterials.MATERIAL_COTTON)
                    .behaviourType((short) 1)
                    .bodySpaces(new byte[]{BodyTemplate.head, BodyTemplate.secondHead})
                    .primarySkill(SkillList.CLOTHTAILORING)
                    .difficulty(10)
                    .itemTypes(new short[]{
                            ItemTypes.ITEM_TYPE_ARMOUR,
                            ItemTypes.ITEM_TYPE_CLOTH,
                            ItemTypes.ITEM_TYPE_COLORABLE,
                            ItemTypes.ITEM_TYPE_EQUIPMENTSLOT,
                            ItemTypes.ITEM_TYPE_REPAIRABLE,
                            ItemTypes.ITEM_TYPE_NOT_MISSION
                    }).build();

        } catch (IOException e) {
            Reedlands.logger.log(Level.SEVERE, "ERROR BUILDING HEAD BAND");
        }
        if (headband != null) {
            AdvancedCreationEntry headbandLogCreation = CreationEntryCreator.createAdvancedEntry(
                    SkillList.CLOTHTAILORING, ItemList.clothYard, ItemList.needleIron, headband.getTemplateId(), true, false, 10.0F, false, false, 0, 10, CreationCategories.ARMOUR
            );
            headbandLogCreation.addRequirement(new CreationRequirement(1, ItemList.clothString, 1, true));
        }
    }
}