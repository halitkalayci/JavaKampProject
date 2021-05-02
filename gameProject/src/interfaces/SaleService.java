package interfaces;

import entities.Campaign;
import entities.Game;
import entities.Player;

public interface SaleService {
	   // Method overloading
       void sale(Game game,Player player);
       void sale(Game game,Player player, Campaign campaign);
}
