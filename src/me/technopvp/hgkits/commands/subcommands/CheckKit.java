package me.technopvp.hgkits.commands.subcommands;

import me.technopvp.common.managers.MessageManager;
import me.technopvp.hgkits.utilities.enums.CommandType;
import me.technopvp.hgkits.utilities.user.UserUtils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CheckKit extends SubCommand {

	@SuppressWarnings("deprecation")
	public boolean onCommand(Player player, String[] args) {
		if (args.length == 0) {
			MessageManager.message(true, player, getSubCommandUsage());
			return true;
		}
		if (args.length == 1) {
			Player target = Bukkit.getPlayer(args[0]);

			if (target == null) {
				MessageManager.message(true, player, "Player '&6" + args[0] + "&a' is not currently online.");
				return true;
			}

			/* If the player has a kit, return the kit. If they don't tell them */
			MessageManager.message(true, player, "&a" + (UserUtils.userHasKit(target.getName()) == true
					? target.getName() + "'s kit: " + UserUtils.getUserKit(target.getName())
					: target.getName() + " does not have a kit."));
			return true;
		}
		return true;
	}

	public CheckKit() {
		super(CommandType.DEFAULT,  "check <player>", "Check a players kit", "check");
	}

}
