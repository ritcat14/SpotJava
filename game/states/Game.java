package SpotJava.game.states;

import SpotJava.core.graphics.Renderer;
import SpotJava.core.input.Event;
import SpotJava.core.objects.Light;
import SpotJava.core.states.State;
import SpotJava.game.entities.Player;
import SpotJava.game.maps.StartMap;
import SpotJava.core.maps.Map;

import java.util.ArrayList;
import java.util.List;

import static SpotJava.core.states.StateName.GAME;

public class Game extends State {

    private Map map;

    public Game() {
        super(GAME);
    }

    @Override
    public void init() {
        map = new StartMap(new Player());
    }

    @Override
    public void update() {
        map.update();
    }

    @Override
    public void render(Renderer renderer) {
        map.render(renderer);
    }

    @Override
    public void close() {

    }

    @Override
    public void onEvent(Event event) {
        if (map != null) map.onEvent(event);
    }
}
