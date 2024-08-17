import org.example.actors.Player;
import org.example.game.BattleShipGame;
import org.junit.Test;


public class battleTest {
    Player player1 = new Player("PlayerA");
    Player player2 = new Player("PlayerB");
    BattleShipGame game = new BattleShipGame(player1, player2, 6);

    @Test

    public void testBattleShipGame() throws Exception {
        String errMsg = "coordinates not in battle field";
        try {
            game.AddShip(1, 2, -1,0,1,1);
        } catch (Exception e) {
            assert(errMsg, e.getMessage());
        }

    }
}
