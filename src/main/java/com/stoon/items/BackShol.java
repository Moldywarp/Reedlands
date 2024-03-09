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


public class BackShol {
    public static void BackSholBuilder() {
        ItemTemplateBuilder builder = new ItemTemplateBuilder("stoon.reedlands.BackShol")
                .behaviourType(BehaviourList.itemBehaviour)
                .name("shoulder cloak", "shoulder cloaks", "This cloak is cut closer to the shoulders. A long cloak is often a display of opulence, this cloak makes a simpler statement.")
                .modelName("model.armour.back.pack.shoulder.")
                .weightGrams(2000)
                .dimensions(70, 70, 70)
                .decayTime(3024000L)
                .value(10000)
                .material(ItemMaterials.MATERIAL_WOOL)
                .behaviourType((short) 1)
                .bodySpaces(new byte[]{BodyTemplate.backSlot, BodyTemplate.topBack})
                .primarySkill(SkillList.CLOTHTAILORING)
                .difficulty(30)
                .itemTypes(new short[]{
                        ItemTypes.ITEM_TYPE_CLOTH,
                        ItemTypes.ITEM_TYPE_COLORABLE,
                        ItemTypes.ITEM_TYPE_EQUIPMENTSLOT,
                        ItemTypes.ITEM_TYPE_REPAIRABLE,
                        ItemTypes.ITEM_TYPE_NOT_MISSION
                });
        builder.imageNumber(Iconzz.getInstance().addIcon("mod.stoon.backsholicon", "mods/icons/backsholicon.png"));
        ItemTemplate backshol = null;
        try {
            backshol = builder.build();
        } catch (IOException e) {
            Reedlands.logger.log(Level.SEVERE, "ERROR BUILDING SHOULDER CLOAK");
        }
        if (backshol != null) {
            AdvancedCreationEntry BackSholLogCreation = CreationEntryCreator.createAdvancedEntry(
                    SkillList.CLOTHTAILORING, ItemList.clothYardWool, ItemList.needleIron, backshol.getTemplateId(), true, false, 10.0F, false, false, 0, 10, CreationCategories.CLOTHES
            );
            BackSholLogCreation.addRequirement(new CreationRequirement(1, ItemList.clothString, 1, true));
            BackSholLogCreation.addRequirement(new CreationRequirement(2, ItemList.clothYard, 1, true));
        }
    }
}


