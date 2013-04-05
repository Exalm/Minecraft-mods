package net.minecraft.src;

import java.util.HashMap;

public class ThreadTextures extends Thread{
    public static final HashMap<String, Integer> terrainIndexMap;
    public static final HashMap<String, Integer> itemsIndexMap;
    private static int fillingMap = 0;

    public ThreadTextures(){}

    @Override
    public void run(){
        Icon[] icons = getTerrainIcons();
        for (Icon i : icons){
            if (i == null){
                continue;
            }
            mod_OldDays.texman.copyIconFromSheet(i, "/terrain.png", terrainIndexMap);
        }
        icons = getItemIcons();
        for (Icon i : icons){
            if (i == null){
                continue;
            }
            mod_OldDays.texman.copyIconFromSheet(i, "/gui/items.png", itemsIndexMap);
        }
    }

    private static Icon getIcon(int i, String str, Icon icon){
        if (fillingMap == 1){
            terrainIndexMap.put(str, i);
        }
        if (fillingMap == 2){
            itemsIndexMap.put(str, i);
        }
        return icon;
    }

    private static Icon[] getTerrainIcons(){
        Icon[] icons = new Icon[256];
        try{
            Icon[][] leavesIcons = (Icon[][])(mod_OldDays.getField(BlockLeaves.class, Block.leaves, 3));
            Icon[] doorIcons = (Icon[])(mod_OldDays.getField(BlockDoor.class, Block.doorWood, 2));

            icons[0] = getIcon(0, "grass_top", (Icon)(mod_OldDays.getField(BlockGrass.class, Block.grass, 0)));
            icons[1] = getIcon(1, "stone", Block.stone.getBlockTextureFromSide(0));
            icons[2] = getIcon(2, "dirt", Block.dirt.getBlockTextureFromSide(0));
            icons[3] = getIcon(3, "grass_side", (Icon)(mod_OldDays.getField(Block.class, Block.grass, 195)));
            icons[4] = getIcon(4, "wood", Block.planks.getBlockTextureFromSide(0));
            icons[5] = getIcon(5, "stoneslab_side", Block.stoneSingleSlab.getBlockTextureFromSideAndMetadata(2, 0));
            icons[6] = getIcon(6, "stoneslab_top", Block.stoneSingleSlab.getBlockTextureFromSideAndMetadata(0, 0));
            icons[7] = getIcon(7, "brick", Block.brick.getBlockTextureFromSide(0));
            icons[8] = getIcon(8, "tnt_side", Block.tnt.getBlockTextureFromSide(2));
            icons[9] = getIcon(9, "tnt_top", Block.tnt.getBlockTextureFromSide(1));
            icons[10] = getIcon(10, "tnt_bottom", Block.tnt.getBlockTextureFromSide(0));
            icons[11] = getIcon(11, "web", Block.web.getBlockTextureFromSide(0));
            icons[12] = getIcon(12, "rose", Block.plantRed.getBlockTextureFromSide(0));
            icons[13] = getIcon(13, "flower", Block.plantYellow.getBlockTextureFromSide(0));
            //14 is animated
            icons[15] = getIcon(15, "sapling", Block.sapling.getBlockTextureFromSide(0));
            icons[16] = getIcon(16, "stonebrick", Block.cobblestone.getBlockTextureFromSide(0));
            icons[17] = getIcon(17, "bedrock", Block.bedrock.getBlockTextureFromSide(0));
            icons[18] = getIcon(18, "sand", Block.sand.getBlockTextureFromSide(0));
            icons[19] = getIcon(19, "gravel", Block.gravel.getBlockTextureFromSide(0));
            icons[20] = getIcon(20, "tree_side", Block.wood.getBlockTextureFromSideAndMetadata(2, 0));
            icons[21] = getIcon(21, "tree_top", Block.wood.getBlockTextureFromSideAndMetadata(0, 0));
            icons[22] = getIcon(22, "blockIron", Block.blockSteel.getBlockTextureFromSide(1));
            icons[23] = getIcon(23, "blockGold", Block.blockGold.getBlockTextureFromSide(1));
            icons[24] = getIcon(24, "blockDiamond", Block.blockDiamond.getBlockTextureFromSide(1));
            icons[25] = getIcon(25, "blockEmerald", Block.blockEmerald.getBlockTextureFromSide(1));
            icons[28] = getIcon(28, "mushroom_red", Block.mushroomRed.getBlockTextureFromSide(0));
            icons[29] = getIcon(29, "mushroom_brown", Block.mushroomBrown.getBlockTextureFromSide(0));
            icons[30] = getIcon(30, "sapling_jungle", Block.sapling.getBlockTextureFromSideAndMetadata(0, 3));
            //31 is animated
            icons[32] = getIcon(32, "oreGold", Block.oreGold.getBlockTextureFromSide(0));
            icons[33] = getIcon(33, "oreIron", Block.oreIron.getBlockTextureFromSide(0));
            icons[34] = getIcon(34, "oreCoal", Block.oreCoal.getBlockTextureFromSide(0));
            icons[35] = getIcon(35, "bookshelf", Block.bookShelf.getBlockTextureFromSide(2));
            icons[36] = getIcon(36, "stoneMoss", Block.cobblestoneMossy.getBlockTextureFromSide(0));
            icons[37] = getIcon(37, "obsidian", Block.obsidian.getBlockTextureFromSide(0));
            icons[38] = getIcon(38, "grass_side_overlay", (Icon)(mod_OldDays.getField(BlockGrass.class, Block.grass, 2)));
            icons[39] = getIcon(39, "tallgrass", Block.tallGrass.getBlockTextureFromSideAndMetadata(0, 1));
            //40 is unused
            icons[41] = getIcon(41, "beacon", Block.beacon.func_94446_i());
            icons[43] = getIcon(43, "workbench_top", Block.workbench.getBlockTextureFromSide(1));
            icons[44] = getIcon(44, "furnace_front", Block.furnaceIdle.getBlockTextureFromSideAndMetadata(2, 2));
            icons[45] = getIcon(45, "furnace_side", Block.furnaceIdle.getBlockTextureFromSideAndMetadata(3, 2));
            icons[46] = getIcon(46, "dispenser_front", Block.dispenser.getBlockTextureFromSide(2));
            //47 is animated
            icons[48] = getIcon(48, "sponge", Block.sponge.getBlockTextureFromSide(0));
            icons[49] = getIcon(49, "glass", Block.glass.getBlockTextureFromSide(0));
            icons[50] = getIcon(50, "oreDiamond", Block.oreDiamond.getBlockTextureFromSide(0));
            icons[51] = getIcon(51, "oreRedstone", Block.oreRedstone.getBlockTextureFromSide(0));
            icons[52] = getIcon(52, "leaves", leavesIcons[0][0]);
            icons[53] = getIcon(53, "leaves_opaque", leavesIcons[1][0]);
            icons[54] = getIcon(54, "stonebricksmooth", Block.stoneBrick.getBlockTextureFromSide(0));
            icons[55] = getIcon(55, "deadbush", Block.tallGrass.getBlockTextureFromSideAndMetadata(0, 0));
            icons[56] = getIcon(56, "fern", Block.tallGrass.getBlockTextureFromSideAndMetadata(0, 2));
            icons[59] = getIcon(59, "workbench_side", Block.workbench.getBlockTextureFromSide(3));
            icons[60] = getIcon(60, "workbench_front", Block.workbench.getBlockTextureFromSide(2));
            icons[61] = getIcon(61, "furnace_front_lit", Block.furnaceBurning.getBlockTextureFromSideAndMetadata(2, 2));
            icons[62] = getIcon(62, "furnace_top", Block.furnaceIdle.getBlockTextureFromSide(0));
            icons[63] = getIcon(63, "sapling_spruce", Block.sapling.getBlockTextureFromSideAndMetadata(0, 2));
            icons[64] = getIcon(64, "cloth_0", Block.cloth.getBlockTextureFromSideAndMetadata(0, 0));
            icons[65] = getIcon(65, "mobSpawner", Block.mobSpawner.getBlockTextureFromSide(0));
            icons[66] = getIcon(66, "snow", Block.blockSnow.getBlockTextureFromSide(0));
            icons[67] = getIcon(67, "ice", Block.ice.getBlockTextureFromSide(0));
            icons[68] = getIcon(68, "snow_side", (Icon)(mod_OldDays.getField(BlockGrass.class, Block.grass, 3)));
            icons[69] = getIcon(69, "cactus_top", Block.cactus.getBlockTextureFromSide(1));
            icons[70] = getIcon(70, "cactus_side", Block.cactus.getBlockTextureFromSide(2));
            icons[71] = getIcon(71, "cactus_bottom", Block.cactus.getBlockTextureFromSide(0));
            icons[72] = getIcon(72, "clay", Block.blockClay.getBlockTextureFromSide(0));
            icons[73] = getIcon(73, "reeds", Block.reed.getBlockTextureFromSide(0));
            icons[74] = getIcon(74, "musicBlock", Block.jukebox.getBlockTextureFromSide(2));
            icons[75] = getIcon(75, "jukebox_top", Block.jukebox.getBlockTextureFromSide(1));
            icons[76] = getIcon(76, "waterlily", Block.waterlily.getBlockTextureFromSide(0));
            icons[77] = getIcon(77, "mycel_side", Block.mycelium.getBlockTextureFromSide(2));
            icons[78] = getIcon(78, "mycel_top", Block.mycelium.getBlockTextureFromSide(1));
            icons[79] = getIcon(79, "sapling_birch", Block.sapling.getBlockTextureFromSideAndMetadata(0, 1));
            icons[80] = getIcon(80, "torch", Block.torchWood.getBlockTextureFromSide(0));
            icons[81] = getIcon(81, "doorWood_upper", doorIcons[1]);
            icons[82] = getIcon(82, "doorIron_upper", doorIcons[3]);
            icons[83] = getIcon(83, "ladder", Block.ladder.getBlockTextureFromSide(0));
            icons[84] = getIcon(84, "trapdoor", Block.trapdoor.getBlockTextureFromSide(0));
            icons[85] = getIcon(85, "fenceIron", Block.fenceIron.getBlockTextureFromSide(0));

            icons[97] = getIcon(97, "doorWood_lower", doorIcons[0]);
            icons[98] = getIcon(98, "doorIron_lower", doorIcons[2]);

            icons[116] = getIcon(116, "tree_spruce", Block.wood.getBlockTextureFromSideAndMetadata(2, 1));
            icons[117] = getIcon(117, "tree_birch", Block.wood.getBlockTextureFromSideAndMetadata(2, 2));

            icons[153] = getIcon(153, "tree_jungle", Block.wood.getBlockTextureFromSideAndMetadata(2, 3));
        }catch(Exception e){}
        return icons;
    }

    private static Icon[] getItemIcons(){
        Icon[] icons = new Icon[256];
        try{
        }catch(Exception e){}
        return icons;
    }

    static{
        terrainIndexMap = new HashMap<String, Integer>();
        fillingMap = 1;
        getTerrainIcons();
        fillingMap = 2;
        getItemIcons();
        fillingMap = 0;
        itemsIndexMap = new HashMap<String, Integer>();
    }
}