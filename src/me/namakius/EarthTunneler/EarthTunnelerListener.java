package me.namakius.EarthTunneler;

import com.projectkorra.projectkorra.BendingPlayer;
import com.projectkorra.projectkorra.ability.CoreAbility;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class EarthTunnelerListener
  implements Listener
{
  @EventHandler
  public void OnSneak(PlayerToggleSneakEvent e)
  {
    if (e.getPlayer().isSneaking()) {
      return;
    }
    if (canBend(e.getPlayer())) {
      new EarthTunneler(e.getPlayer());
    }
  }
  
  private boolean canBend(Player p)
  {
    BendingPlayer bp = BendingPlayer.getBendingPlayer(p.getName());
    return bp.canBend(CoreAbility.getAbility("EarthTunneler"));
  }
}
