package de.combit.anticlearchat.listener;/*

 __                           _      _  _   
/  |                         | |    (_)| |  
`| |   ___   ___   _ __ ___  | |__   _ | |_ 
 | |  / __| / _ \ | '_ ` _ \ | '_ \ | || __|
_| |_| (__ | (_) || | | | | || |_) || || |_ 
\___/ \___| \___/ |_| |_| |_||_.__/ |_| \__|

» Class created by 1combit | Luca
» Date: 03.06.2021 | 15:55
» 1combit#8044


 */

import de.combit.anticlearchat.ClearChatAddon;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.events.client.chat.MessageReceiveEvent;

public class MessageEvent {

    @Subscribe
    public void onMessage(MessageReceiveEvent event) {
        if (ClearChatAddon.instance.enabled) {
        if (event.getComponent().getString().trim().isEmpty()) {
            event.setCancelled(true);
        } else {
            event.setCancelled(false);
        }
    }  else {

        }
    }

}
