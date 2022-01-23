package me.einsluca.anticlearchat.listener;

import me.einsluca.anticlearchat.ClearChatAddon;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.chat.MessageReceiveEvent;

public class MessageEvent {

    @Subscribe
    public void onMessage(MessageReceiveEvent event) {
        if (ClearChatAddon.getInstance().isEnabled() && event.getComponent().getString().trim().isEmpty()) {
            event.setCancelled(true);
        }
    }
}
