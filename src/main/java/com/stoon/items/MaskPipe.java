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

public class MaskPipe {
    public static void MaskPipeBuilder() {
        ItemTemplateBuilder builder = new ItemTemplateBuilder("stoon.reedlands.MaskPipe")
                .behaviourType(BehaviourList.itemBehaviour)
                .name("smoking pipe", "smoking pipes", "A smoking pipe carved of wood and stuffed with herbs or tobacco.")
                .modelName("model.armour.head.mask.pipe.")
                .weightGrams(1000)
                .dimensions(15, 20, 20)
                .decayTime(3024000L)
                .value(10000)
                .material(ItemMaterials.MATERIAL_WOOD_OAK)
                .behaviourType((short) 1)
                .bodySpaces(new byte[]{BodyTemplate.face, BodyTemplate.secondHead})
                .primarySkill(SkillList.CARPENTRY_FINE)
                .difficulty(10)
                .itemTypes(new short[]{
                        ItemTypes.ITEM_TYPE_ARMOUR,
                        ItemTypes.ITEM_TYPE_WOOD,
                        ItemTypes.ITEM_TYPE_COLORABLE,
                        ItemTypes.ITEM_TYPE_EQUIPMENTSLOT,
                        ItemTypes.ITEM_TYPE_REPAIRABLE,
                        ItemTypes.ITEM_TYPE_NOT_MISSION
                });
        builder.imageNumber(Iconzz.getInstance().addIcon("mod.stoon.maskpipeicon", "mods/icons/maskpipeicon.png"));
        ItemTemplate template = null;
        try {
            template = builder.build();
        } catch (IOException e) {
            Reedlands.logger.log(Level.SEVERE, "ERROR BUILDING SMOKING PIPE");
        }
        if(template != null) {
        }
    }
}

