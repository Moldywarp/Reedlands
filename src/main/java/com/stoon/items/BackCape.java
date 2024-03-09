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


public class BackCape {
    public static void BackCapeBuilder() {
        ItemTemplateBuilder builder = new ItemTemplateBuilder("stoon.reedlands.BackCape")
                .behaviourType(BehaviourList.itemBehaviour)
                .name("cape", "capes", "This simple cape is fashioned from leather.")
                .modelName("model.armour.back.pack.cape.")
                .weightGrams(2000)
                .dimensions(90, 90, 90)
                .decayTime(3024000L)
                .value(10000)
                .material(ItemMaterials.MATERIAL_LEATHER)
                .behaviourType((short) 1)
                .bodySpaces(new byte[]{BodyTemplate.backSlot, BodyTemplate.topBack})
                .primarySkill(SkillList.LEATHERWORKING)
                .difficulty(20)
                .itemTypes(new short[]{
                        ItemTypes.ITEM_TYPE_LEATHER,
                        ItemTypes.ITEM_TYPE_COLORABLE,
                        ItemTypes.ITEM_TYPE_EQUIPMENTSLOT,
                        ItemTypes.ITEM_TYPE_REPAIRABLE,
                        ItemTypes.ITEM_TYPE_NOT_MISSION
                });
        builder.imageNumber(Iconzz.getInstance().addIcon("mod.stoon.backcapeicon", "mods/icons/backcapeicon.png"));
        ItemTemplate backcape = null;
        try {
            backcape = builder.build();
        } catch (IOException e) {
            Reedlands.logger.log(Level.SEVERE, "ERROR BUILDING LEATHER CAPE");
        }
        if (backcape != null) {
            AdvancedCreationEntry backcapeLogCreation = CreationEntryCreator.createAdvancedEntry(
                    SkillList.LEATHERWORKING, ItemList.leather, ItemList.needleIron, backcape.getTemplateId(), true, false, 10.0F, false, false, 0, 10, CreationCategories.CLOTHES
            );
            backcapeLogCreation.addRequirement(new CreationRequirement(1, ItemList.leatherStrip, 1, true));
        }
    }
}


