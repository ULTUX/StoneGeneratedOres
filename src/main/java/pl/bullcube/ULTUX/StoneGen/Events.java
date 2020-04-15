package pl.bullcube.ULTUX.StoneGen;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

public class Events implements Listener {
    @EventHandler
    public void BlockFromToEvent(final BlockFromToEvent e){
        final boolean isDiamond, isCoal, isLapis, isRedstone, isEmerald, isIron, isGold,  isQuartz;
        if (e.getBlock().getType().equals(Material.WATER) || e.getBlock().getType().equals(Material.LAVA)){
            if (e.getToBlock().getType().equals(Material.AIR)){
                if (isGenerating(e.getBlock().getType(), e.getToBlock())){
                    isCoal = chance(0.003);
                    isIron = chance(0.002);
                    isQuartz = chance(0.0015);
                    isGold = chance(0.0001);
                    isLapis = chance(0.0007);
                    isRedstone = chance(0.0007);
                    isEmerald = chance(0.0004);
                    isDiamond = chance(0.0004);
                    Material block = Material.STONE;
                    if (isCoal) block = Material.COAL_ORE;
                    if (isIron) block = Material.IRON_ORE;
                    if (isQuartz) block = Material.NETHER_QUARTZ_ORE;
                    if (isGold) block = Material.GOLD_ORE;
                    if (isLapis) block = Material.LAPIS_ORE;
                    if (isRedstone) block = Material.REDSTONE_ORE;
                    if (isEmerald) block = Material.EMERALD_ORE;
                    if (isDiamond) block = Material.DIAMOND_ORE;
                    final Material finalBlock = block;
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                        public void run() {
                            if (!finalBlock.equals(Material.STONE)) e.getToBlock().setType(finalBlock);
                        }
                    },1);
                }
            }
        }
    }
    private static boolean chance(double prec){
        if (Math.random() <= prec) return true;
        return false;
    }

    private static boolean isGenerating(Material type, Block b){
        Material material = (type == Material.LAVA) ? Material.WATER : Material.LAVA;
            for (int i = -1; i < 2; i++){
                for (int j = -1; j < 2; j++){
                    for (int k = -1; k < 2; k++){
                        if ( (i != 0 && j == 0 && k != 0) || (i == 0 && j != 0 && k != 0) || (i != 0 && j != 0 && k == 0)) {
                            if (b.getWorld().getBlockAt(b.getX() + i, b.getY()+k, b.getZ() + j).getType() == material) return true;
                        }
                    }
                }
            }
            return false;
    }
}
