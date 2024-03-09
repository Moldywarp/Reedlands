package com.stoon.items;


import com.wurmonline.server.combat.Weapon;
import com.wurmonline.server.items.*;
import com.wurmonline.server.skills.SkillList;
import com.wurmonline.shared.constants.ItemMaterials;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;
import org.tyoda.wurm.Iconzz.Iconzz;

import java.io.IOException;

import static com.wurmonline.server.items.CreationEntryCreator.createSimpleEntry;

public class WeapKata {
    public static void WeapKataBuilder() {
        ItemTemplate katana;
        try {
            katana = new ItemTemplateBuilder("stoon.katana")
                    .name("katana", "katanas", "An elegant but fragile weapon wielded by skilled swordsman in the land of reeds.")
                    .behaviourType((short) 1)
                    .imageNumber(Iconzz.getInstance().addIcon("mod.stoon.weapkataicon", "mods/icons/weapkataicon.png"))
                    .combatDamage(28)
                    .decayTime(3024000L)
                    .weightGrams(3600)
                    .dimensions(5, 10, 80)
                    .primarySkill(SkillList.SWORD_TWOHANDED)
                    .difficulty(10)
                    .value(20000)
                    .itemTypes(new short[]{
                            ItemTypes.ITEM_TYPE_NAMED,
                            ItemTypes.ITEM_TYPE_REPAIRABLE,
                            ItemTypes.ITEM_TYPE_METAL,
                            ItemTypes.ITEM_TYPE_WEAPON,
                            ItemTypes.ITEM_TYPE_WEAPON_MELEE,
                            ItemTypes.ITEM_TYPE_WEAPON_SLASH,
                            ItemTypes.ITEM_TYPE_WEAPON_SWORD,
                            ItemTypes.ITEM_TYPE_TWOHANDED,
                            ItemTypes.ITEM_TYPE_COLORABLE
                    })
                    .material(ItemMaterials.MATERIAL_IRON)
                    .modelName("model.weapon.sword.katana.")
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        new Weapon(katana.getTemplateId(), 9.1f, 5.0f, 0.05f, 4, 3, 1.0f, 0.0);

        createSimpleEntry(10010, ItemList.handlePadded, ItemList.swordBladeTwoHanded, katana.getTemplateId(), true, true, 0.0f, false, false, CreationCategories.WEAPONS);
    }
}