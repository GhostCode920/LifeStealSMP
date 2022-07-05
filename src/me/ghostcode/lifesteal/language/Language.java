package me.ghostcode.lifesteal.language;

import me.ghostcode.lifesteal.Main;

public abstract class Language {
	
	private static Language $Instance;
	public static Language get() {
		if($Instance == null) {
			String set = Main.getInstance().getConfig().getString("language.set", "english");
			for(Language l : new Language[] {new Custom(), new English(), new French()})
				if(l.languageName().equalsIgnoreCase(set))
					return $Instance = l;
			return $Instance = new English();
		}
		return $Instance;
	}
	
	public abstract String languageName();
	
	public abstract String noLongerInCombat();
	
	/**
	 * $timer$ = timer before no longer in combat
	 */
	public abstract String combatTimer();
	
	/**
	 * $player$ = player who got killed
	 * $killer$ = player who killed
	 */
	public abstract String playerKilledBy();
	
	/**
	 * $player$ = player who died
	 */
	public abstract String playerDeath();

}
