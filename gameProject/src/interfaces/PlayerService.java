package interfaces;

import java.util.*;

import entities.Player;

public interface PlayerService {
      void add(Player player);
      void remove(Player player);
      void update(Player player);
      List<Player> getAll();
}
