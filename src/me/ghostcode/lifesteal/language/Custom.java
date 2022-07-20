package me.ghostcode.lifesteal.language;

import me.ghostcode.lifesteal.LifeSteal;

final class Custom extends Language {

	@Override
	public String languageName() {
		return "custom";
	}

	protected Custom() {
		str = new String[] {
			config("nolongerincombat", English.$Instance.noLongerInCombat(),
			config("timer", English.$Instance.combatTimer()),
			config("playerkilledby", English.$Instance.playerKilledBy()),
			config("playerdeath", English.$Instance.playerDeath())
		}
	}

	
	private String config(String path, String def) {
		return LifeSteal.getInstance().getConfig().getString("language.custom."+path, def);
	}

	@Override
	public String noLongerInCombat() {
		return str[0];
	}

	@Override
	public String combatTimer() {
		return str[1];
	}

	@Override
	public String playerKilledBy() {
		return str[2];
	}

	@Override
	public String playerDeath() {
		return str[3];
	}

}
