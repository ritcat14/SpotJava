package SpotJava.game.states;

import SpotJava.core.graphics.Renderer;
import SpotJava.core.input.Event;
import SpotJava.core.objects.Light;
import SpotJava.core.states.State;
import SpotJava.game.entities.Player;
import SpotJava.game.maps.Map;

import java.util.ArrayList;
import java.util.List;

import static SpotJava.core.states.StateName.GAME;

public class Game extends State {

    private static List<Light> lights = new ArrayList<>();
    private static List<Light> lightsToAdd = new ArrayList<>();
    private static List<Light> lightsToRemove = new ArrayList<>();

    private Map map;

    public Game() {
        super(GAME);
    }

    @Override
    public void init() {
        map = new Map(new Player());
    }

    @Override
    public void update() {
        map.update();
    }

    @Override
    public void render(Renderer renderer) {
        lights.addAll(lightsToAdd);
        lightsToAdd.clear();
        for (Light light : lights) {
            if (light.isRemoved()) {
                lightsToRemove.add(light);
            }
        }
        lights.removeAll(lightsToRemove);
        lightsToRemove.clear();
        map.render(renderer);
        renderer.renderLights(lights);
    }

    @Override
    public void close() {

    }

    @Override
    public void onEvent(Event event) {
        if (map != null) map.onEvent(event);
    }

    public static void addLight(Light light) {
        lightsToAdd.add(light);
    }
}
