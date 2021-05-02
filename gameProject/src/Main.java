import java.util.Date;

import classes.CampaignManager;
import classes.EDevletValidationService;
import classes.GameManager;
import classes.PlayerManager;
import classes.SaleManager;
import entities.Campaign;
import entities.Game;
import entities.Player;
import interfaces.CampaignService;
import interfaces.GameService;
import interfaces.PlayerService;
import interfaces.SaleService;

public class Main {

	public static void main(String[] args) {
		Game game = new Game(1,"Call of Duty",250d);
		Game game2 = new Game(2,"Age Of Empires",120d);
        Campaign campaign = new Campaign(1,"Kodlama.io kullanýcýlarýna özel %5 indirim",5);
        Player validPlayer = new Player(1,"Sanchklyc","Halit Enes","Kalaycý", new Date(2000,6,28));
        Player invalidPlayer = new Player(2,"engindemirog","Engin","Demiroð",new Date(2005,6,28));
        
        PlayerService playerService = new PlayerManager(new EDevletValidationService());
        playerService.add(validPlayer);
        playerService.add(invalidPlayer);
        
        GameService gameService = new GameManager();
        gameService.add(game);
        gameService.add(game2);
        gameService.remove(game2);
        
        CampaignService campaignService = new CampaignManager();
        campaignService.add(campaign);
        
        SaleService saleService = new SaleManager();
        saleService.sale(game, validPlayer);
        saleService.sale(game, validPlayer,campaign);
	}

}
