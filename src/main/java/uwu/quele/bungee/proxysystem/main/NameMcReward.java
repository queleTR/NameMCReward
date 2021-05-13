package uwu.quele.bungee.proxysystem.main;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;
import uwu.quele.bungee.proxysystem.commands.NameMCCheckCommand;

/*
 * Author: quele
 * problems? add me on discord
 * discord: quele#0001
 */

public class NameMcReward extends Plugin {
    private static NameMcReward instance;

    @Override
    public void onEnable() {
        instance = this;
        this.initCommands();
    }

    @Override
    public void onDisable() {
    }

    private void initCommands() {
        PluginManager pluginManager = this.getProxy().getPluginManager();
        pluginManager.registerCommand(this, new NameMCCheckCommand());
    }

    public static NameMcReward getInstance() {
        return instance;
    }

    public String getPrefix() {
        return "PREFIX ";
    }
}
