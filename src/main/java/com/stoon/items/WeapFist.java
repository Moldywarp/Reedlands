package com.stoon.items;


import com.wurmonline.server.combat.Weapon;
import com.wurmonline.server.items.*;
import com.wurmonline.server.skills.SkillList;
import com.wurmonline.shared.constants.ItemMaterials;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;
import org.tyoda.wurm.Iconzz.Iconzz;

import java.io.IOException;

import static com.wurmonline.server.items.CreationEntryCreator.createSimpleEntry;

public class WeapFist {
    public static void WeapFistBuilder() {
        ItemTemplate fist;
        try {
            fist = new ItemTemplateBuilder("stoon.fist")
                    .name("tekko", "tekkos", "A horseshoe converted into a deadly fist weapon popularized by monks who were not allowed to train combat arts.")
                    .behaviourType((short) 1)
                    .imageNumber(Iconzz.getInstance().addIcon("mod.stoon.weapfisticon", "mods/icons/weapfisticon.png"))
                    .combatDamage(25)
                    .decayTime(3024000L)
                    .weightGrams(500)
                    .dimensions(5, 10, 80)
                    .primarySkill(SkillList.WEAPONLESS_FIGHTING)
                    .difficulty(0)
                    .value(100)
                    .itemTypes(new short[]{
                            ItemTypes.ITEM_TYPE_NAMED,
                            ItemTypes.ITEM_TYPE_REPAIRABLE,
                            ItemTypes.ITEM_TYPE_METAL,
                            ItemTypes.ITEM_TYPE_WEAPON,
                            ItemTypes.ITEM_TYPE_WEAPON_MELEE,
                            ItemTypes.ITEM_TYPE_WEAPON_CRUSH,
                            ItemTypes.ITEM_TYPE_COLORABLE,
                    })
                    .material(ItemMaterials.MATERIAL_IRON)
                    .modelName("model.weapon.weaponless.fist.")
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        new Weapon(fist.getTemplateId(), 4.5f, 3.0f, 0.05f, 3, 1, 0.25f, 0.0);

        createSimpleEntry(10011, ItemList.woodenHandleSword, ItemList.horseShoe, fist.getTemplateId(), true, true, 0.0f, false, false, CreationCategories.WEAPONS);
    }
}