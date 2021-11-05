package me.einsluca.anticlearchat;

import me.einsluca.anticlearchat.listener.MessageEvent;
import net.labymod.api.LabyModAddon;
import net.labymod.main.LabyMod;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;

import java.util.List;

public class ClearChatAddon extends LabyModAddon {

    public boolean enabled = true;
    public static ClearChatAddon instance;


    @Override
    public void onEnable() {
        instance = this;

        LabyMod.getInstance().getEventService().registerListener(new MessageEvent());

    }

    @Override
    public void loadConfig() {
        this.enabled = !getConfig().has("enabled") || getConfig().get("enabled").getAsBoolean();

    }

    @Override
    protected void fillSettings(List<SettingsElement> list) {
        BooleanElement booleanElement = new BooleanElement("Enabled", new ControlElement.IconData(Material.GREEN_DYE), new Consumer<Boolean>() {
            @Override
            public void accept(Boolean enableAddon) {
                ClearChatAddon.this.enabled = enableAddon.booleanValue();
                ClearChatAddon.this.getConfig().addProperty("enabled", Boolean.valueOf(ClearChatAddon.this.enabled));
                ClearChatAddon.this.saveConfig();
            }
        }, this.enabled);
        list.add(booleanElement);
    }
}
