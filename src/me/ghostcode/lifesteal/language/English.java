package me.ghostcode.lifesteal.language;

class English extends Language {

	protected static English $Instance;
	
	protected English() {
		$Instance = this;
	}
	
	@Override
	public String languageName() {
		return "english";
	}

	@Override
	public String noLongerInCombat() {
		return "§aYou're no longer in combat";
	}

	@Override
	public String combatTimer() {
		return "§cIn combat for §6$timer$§cs.";
	}

	@Override
	public String playerKilledBy() {
		return "§6$player$ §ewas slain by §6$killer$ §e!";
	}

	@Override
	public String playerDeath() {
		return "§6$player$ §edied !";
	}

}
