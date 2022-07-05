package me.ghostcode.lifesteal.language;

import me.ghostcode.lifesteal.Main;

final class Custom extends Language {

	@Override
	public String languageName() {
		return "custom";
	}
	
	private String config(String path, String def) {
		return Main.getInstance().getConfig().getString("language.custom."+path, def);
	}

	@Override
	public String noLongerInCombat() {
		return config("nolongerincombat", English.$Instance.noLongerInCombat());
	}

	@Override
	public String combatTimer() {
		return config("timer", English.$Instance.combatTimer());
	}

	@Override
	public String playerKilledBy() {
		return config("playerkilledby", English.$Instance.playerKilledBy());
	}

	@Override
	public String playerDeath() {
		return config("playerdeath", English.$Instance.playerDeath());
	}

}
