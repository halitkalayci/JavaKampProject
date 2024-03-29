package classes;

import entities.Campaign;
import entities.Game;
import entities.Player;
import interfaces.SaleService;

public class SaleManager implements SaleService{

	@Override
	public void sale(Game game, Player player) {
		System.out.println(game.getName() + " isimli oyun " + player.getUserName() + " kullan�c� isimli oyuncuya sat�ld�.");
	}

	@Override
	public void sale(Game game, Player player, Campaign campaign) {
		
		double newPrice = game.getPrice() - ( game.getPrice() * ((double) campaign.getDiscount() / 100));
		System.out.println(game.getName() + " isimli oyun " + player.getUserName() + " kullan�c� isimli oyuncuya " + campaign.getCampaignName() +" kampanyas� ile " + newPrice +"TL'ye sat�ld�.");
	}

}
