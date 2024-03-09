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


public class BackRoni {
    public static void BackRoniBuilder() {
        ItemTemplateBuilder builder = new ItemTemplateBuilder("stoon.reedlands.BackRoni")
                .behaviourType(BehaviourList.itemBehaviour)
                .name("ronin cloak", "ronin cloaks", "A cloak worn by ronin warriors from the land of reeds.")
                .modelName("model.armour.back.pack.ronin.")
                .weightGrams(1000)
                .dimensions(70, 70, 70)
                .decayTime(3024000L)
                .value(10000)
                .material(ItemMaterials.MATERIAL_WOOL)
                .behaviourType((short) 1)
                .bodySpaces(new byte[]{BodyTemplate.backSlot, BodyTemplate.topBack})
                .primarySkill(SkillList.CLOTHTAILORING)
                .difficulty(50)
                .itemTypes(new short[]{
                        ItemTypes.ITEM_TYPE_CLOTH,
                        ItemTypes.ITEM_TYPE_COLORABLE,
                        ItemTypes.ITEM_TYPE_EQUIPMENTSLOT,
                        ItemTypes.ITEM_TYPE_REPAIRABLE,
                        ItemTypes.ITEM_TYPE_NOT_MISSION
                });
        builder.imageNumber(Iconzz.getInstance().addIcon("mod.stoon.backroniicon", "mods/icons/backroniicon.png"));
        ItemTemplate backroni = null;
        try {
            backroni = builder.build();
        } catch (IOException e) {
            Reedlands.logger.log(Level.SEVERE, "ERROR BUILDING RONIN CLOAK");
        }
        if (backroni != null) {
            AdvancedCreationEntry backroniLogCreation = CreationEntryCreator.createAdvancedEntry(
                    SkillList.CLOTHTAILORING, ItemList.clothYardWool, ItemList.needleIron, backroni.getTemplateId(), true, false, 10.0F, false, false, 0, 40, CreationCategories.CLOTHES
            );
            backroniLogCreation.addRequirement(new CreationRequirement(1, ItemList.reedFibre, 8, true));
            backroniLogCreation.addRequirement(new CreationRequirement(2, ItemList.rope, 1, true));
            backroniLogCreation.addRequirement(new CreationRequirement(3, ItemList.flaskPottery, 1, true));
        }
    }
}


