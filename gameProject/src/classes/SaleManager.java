package classes;

import entities.Campaign;
import entities.Game;
import entities.Player;
import interfaces.SaleService;

public class SaleManager implements SaleService{

	@Override
	public void sale(Game game, Player player) {
		System.out.println(game.getName() + " isimli oyun " + player.getUserName() + " kullanýcý isimli oyuncuya satýldý.");
	}

	@Override
	public void sale(Game game, Player player, Campaign campaign) {
		
		double newPrice = game.getPrice() - ( game.getPrice() * ((double) campaign.getDiscount() / 100));
		System.out.println(game.getName() + " isimli oyun " + player.getUserName() + " kullanýcý isimli oyuncuya " + campaign.getCampaignName() +" kampanyasý ile " + newPrice +"TL'ye satýldý.");
	}

}
