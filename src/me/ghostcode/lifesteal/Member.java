package me.ghostcode.lifesteal;

// From a old api, reused in Pofacraft's code
public final class Member {

    private static final ArrayList<Member> members = new ArrayList<>();

    private Member(Player p) {
	player = p;
	members.add(this);
    }
	
    public static ArrayList<Member> getAllRegistedMembers() {
	return members;
    }
	
    public static Member get(Player p) {
	for(Member m : members) {
	    if(m.getPlayer() == p)
		return m;
	}
	return new Member(p);
    }


    public void sendActionBar(String content) {
        getConnection().sendPacket(new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a("{\"text\": \""+ PlaceholderManager.setPlaceholders(getPlayer(), content) +"\"}"), (byte)2));
    } 


    private final Player player;
    public Player getPlayer() {
		return player;
    }
    public CraftPlayer getCraftPlayer() {
	return (CraftPlayer) getPlayer();
    }
    public EntityPlayer getEntityPlayer() {
	return getCraftPlayer().getHandle();
    }
    public PlayerConnection getConnection() {
	return getEntityPlayer().playerConnection;
    }

    protected int timer;
    protected Player lastHit;
    /**
     * I'll probably move this to Main bcs thats
     * very very small... 
     */
    public boolean updateTimer(Player hit) {
        lastHit = hit;
        timer = Main.$Instance.getTimer();
    }
    public void runTimer() {
        new BukkitRunnable() {
             @Override public void run() {
                 if(timer-- < 0) {
                     timer++;
                     sendActionBar("config") //todo
                 } 
             } 
        }.runAsyncTaskTimer(Main.$Instance, 0l, 20l);
    } 
    public int getTimer() {
        return timer;
    }
    public Player getLastHit() {
        return lastHit;
    } 

} 
