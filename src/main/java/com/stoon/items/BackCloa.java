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


public class BackCloa {
    public static void BackCloaBuilder() {
        ItemTemplateBuilder builder = new ItemTemplateBuilder("stoon.reedlands.BackCloa")
                .behaviourType(BehaviourList.itemBehaviour)
                .name("cloak", "cloaks", "This cloak is woven from fine wool.")
                .modelName("model.armour.back.pack.cloak.")
                .weightGrams(1000)
                .dimensions(70, 70, 70)
                .decayTime(3024000L)
                .value(10000)
                .material(ItemMaterials.MATERIAL_WOOL)
                .behaviourType((short) 1)
                .bodySpaces(new byte[]{BodyTemplate.backSlot, BodyTemplate.topBack})
                .primarySkill(SkillList.CLOTHTAILORING)
                .difficulty(20)
                .itemTypes(new short[]{
                        ItemTypes.ITEM_TYPE_CLOTH,
                        ItemTypes.ITEM_TYPE_COLORABLE,
                        ItemTypes.ITEM_TYPE_EQUIPMENTSLOT,
                        ItemTypes.ITEM_TYPE_REPAIRABLE,
                        ItemTypes.ITEM_TYPE_NOT_MISSION
                });
        builder.imageNumber(Iconzz.getInstance().addIcon("mod.stoon.backcloaicon", "mods/icons/backcloaicon.png"));
        ItemTemplate backcloa = null;
        try {
            backcloa = builder.build();
        } catch (IOException e) {
            Reedlands.logger.log(Level.SEVERE, "ERROR BUILDING CLOAK");
        }
        if (backcloa != null) {
            AdvancedCreationEntry backcloaLogCreation = CreationEntryCreator.createAdvancedEntry(
                    SkillList.CLOTHTAILORING, ItemList.clothYardWool, ItemList.needleIron, backcloa.getTemplateId(), true, false, 10.0F, false, false, 0, 10, CreationCategories.CLOTHES
            );
            backcloaLogCreation.addRequirement(new CreationRequirement(1, ItemList.clothString, 1, true));
        }
    }
}


