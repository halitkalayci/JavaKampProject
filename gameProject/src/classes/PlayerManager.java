package classes;

import java.util.ArrayList;
import java.util.List;

import entities.Player;
import interfaces.PlayerService;
import interfaces.PlayerValidationService;

public class PlayerManager implements PlayerService{
	private PlayerValidationService validationService;
	
	public PlayerManager(PlayerValidationService validationService) {
		this.validationService = validationService;
	}

	private List<Player> players = new ArrayList<Player>();
	
	@Override
	public void add(Player player) {
		if(validationService.isPlayerValid(player)) {
			players.add(player);
			System.out.println(player.getUserName() + " kullanýcý adlý oyuncu eklendi.");
		}else {
			System.out.println("Kullanýcý doðrulanamadý!");
		}
	}

	@Override
	public void remove(Player player) {
		players.removeIf(obj-> obj.getId() == player.getId());
		System.out.println(player.getUserName() + " kullanýcý adlý oyuncu silindi.");
	}

	@Override
	public void update(Player player) {
		//TO DO : Iterate all objects, find one with matching id and update? 
		//It was easy in .NET with Linq but couldn't manage to do it here :)
		System.out.println(player.getUserName() + " kullanýcý adlý oyuncu güncellendi.");
	}

	@Override
	public List<Player> getAll() {
		return this.players;
	}

}
