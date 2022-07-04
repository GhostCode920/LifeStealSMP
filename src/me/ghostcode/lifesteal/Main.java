package me.ghostcode.lifesteal;

// Im gonna do the complete code tomorrow, im on phone so i cant
public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(this, this);
    } 

    @EventHandler
    public void onDeath(***) {

        //if(!(e.getEntity() instanceof Player)) return;
        //I need to check if event is PlayerDeath or EntityDeath
        Player p = (Player) e.getEntity();
        Member m = Member.get(p)

// i'll check if i not already did a code like that

    } 

} 
