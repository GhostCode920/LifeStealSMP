package me.ghostcode.lifesteal.language;

final class French extends Language {

	@Override
	public String languageName() {
		return "french";
	}

	@Override
	public String noLongerInCombat() {
		return "§aVous n'êtes plus en combat";
	}

	@Override
	public String combatTimer() {
		return "§cCombat Timer: §6$timer$";
	}

	@Override
	public String playerKilledBy() {
		return "§6$player$ §ea été tué par §6$killer$ §e!";
	}

	@Override
	public String playerDeath() {
		return "§6$player$ §eest mort !";
	}

}
