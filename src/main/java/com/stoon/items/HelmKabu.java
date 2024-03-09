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

import static com.wurmonline.server.items.CreationEntryCreator.createSimpleEntry;

public class HelmKabu {
    public static ItemTemplate kabutohelm = null;
    public static void HelmKabuBuilder() {
        try {
            kabutohelm = new ItemTemplateBuilder("stoon.reedlands.kabuto")
                    .behaviourType(BehaviourList.itemBehaviour)
                    .name("kabuto", "kabutos", "A decorative helmet made popular in the land of reeds.")
                    .imageNumber(Iconzz.getInstance().addIcon("mod.stoon.helmkabu", "mods/icons/helmkabuicon.png"))
                    .modelName("model.armour.head.helm.kabuto.")
                    .weightGrams(1400)
                    .dimensions(25, 30, 30)
                    .decayTime(3024000L)
                    .value(10000)
                    .material(ItemMaterials.MATERIAL_IRON)
                    .behaviourType((short) 1)
                    .bodySpaces(new byte[]{BodyTemplate.head, BodyTemplate.secondHead})
                    .primarySkill(SkillList.SMITHING_BLACKSMITHING)
                    .difficulty(50)
                    .itemTypes(new short[]{
                            ItemTypes.ITEM_TYPE_ARMOUR,
                            ItemTypes.ITEM_TYPE_METAL,
                            ItemTypes.ITEM_TYPE_COLORABLE,
                            ItemTypes.ITEM_TYPE_IMPROVE_USES_TYPE_AS_MATERIAL,
                            ItemTypes.ITEM_TYPE_IMPROVEITEM,
                            ItemTypes.ITEM_TYPE_EQUIPMENTSLOT,
                            ItemTypes.ITEM_TYPE_REPAIRABLE,
                            ItemTypes.ITEM_TYPE_NOT_MISSION
                    }).build();

            } catch (IOException e) {
            Reedlands.logger.log(Level.SEVERE, "ERROR BUILDING KABUTO HELM");
            }
        assert kabutohelm != null;
        createSimpleEntry( SkillList.SMITHING_ARMOUR_PLATE, ItemList.anvilLarge, ItemList.ironBar, kabutohelm.getTemplateId(), false, true, 10.0f, false, false, CreationCategories.ARMOUR
                );
            }
        }
