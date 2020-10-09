package com.dfsek.terra.command.structure;

import com.dfsek.terra.command.type.DebugCommand;
import com.dfsek.terra.command.type.WorldCommand;
import com.dfsek.terra.structure.StructureSpawnRequirement;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class SpawnCommand extends WorldCommand implements DebugCommand {
    @Override
    public boolean execute(@NotNull Player sender, @NotNull Command command, @NotNull String label, @NotNull String[] args, World world) {
        Location p = sender.getLocation();
        int x = p.getBlockX();
        int y = p.getBlockY();
        int z = p.getBlockZ();
        boolean air = StructureSpawnRequirement.AIR.matches(world, x, y, z);
        boolean ground = StructureSpawnRequirement.LAND.matches(world, x, y, z);
        boolean sea = StructureSpawnRequirement.OCEAN.matches(world, x, y, z);

        sender.sendMessage("AIR: " + air + "\nLAND: " + ground + "\nOCEAN: " + sea);
        return true;
    }

    @Override
    public String getName() {
        return "spawn";
    }

    @Override
    public List<com.dfsek.terra.command.type.Command> getSubCommands() {
        return Collections.emptyList();
    }

    @Override
    public int arguments() {
        return 0;
    }

    @Override
    public List<String> getTabCompletions(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) {
        return Collections.emptyList();
    }
}