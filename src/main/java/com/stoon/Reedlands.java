package com.stoon;

import com.stoon.items.*;
import com.wurmonline.server.combat.ArmourTemplate;
import org.gotti.wurmunlimited.modloader.interfaces.ItemTemplatesCreatedListener;
import org.gotti.wurmunlimited.modloader.interfaces.Versioned;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;
import org.gotti.wurmunlimited.modsupport.items.ModItems;

import java.util.logging.Logger;

public class Reedlands implements WurmServerMod, ItemTemplatesCreatedListener, Versioned {
    public static Logger logger = Logger.getLogger(Reedlands.class.getName());
    @Override
    public void onItemTemplatesCreated() {
        ModItems.init();
        BackCloa.BackCloaBuilder();
        BackCape.BackCapeBuilder();
        BackShol.BackSholBuilder();
        BackRoni.BackRoniBuilder();
        HairBand.HairBandBuilder();
        HairKnot.HairKnotBuilder();
        HatConi.HatConiBuilder();
        HelmKabu.HelmKabuBuilder();
        MaskSamu.MaskSamuBuilder();
        MaskLion.MaskLionBuilder();
        MaskPipe.MaskPipeBuilder();
        WeapFist.WeapFistBuilder();
        WeapKata.WeapKataBuilder();
        DecoFold.DecoFoldBuilder();

        new ArmourTemplate(HelmKabu.kabutohelm.getTemplateId(), ArmourTemplate.ARMOUR_TYPE_PLATE, 0.025f);
        new ArmourTemplate(HatConi.conihat.getTemplateId(), ArmourTemplate.ARMOUR_TYPE_CLOTH, 0.000f);
        new ArmourTemplate(HairBand.headband.getTemplateId(), ArmourTemplate.ARMOUR_TYPE_CLOTH, 0.000f);
        new ArmourTemplate(HairKnot.knothair.getTemplateId(), ArmourTemplate.ARMOUR_TYPE_CLOTH, 0.000f);
    }


    @Override
    public String getVersion() {
        return "1.0";
    }
}
