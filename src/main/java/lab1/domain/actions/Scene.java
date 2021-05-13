package lab1.domain.actions;

import java.util.LinkedList;

public class Scene {
    private final String title;

    private final LinkedList<Event> events = new LinkedList<>();
    private EventHandler eventHandler = new EventHandler();

    public Scene(String title){
        this.title = title;
    }

    public void applyAction(Action action){
        events.add(action.run());
    }

    public LinkedList<Event> getEvents(){
        return events;
    }

    public String sceneDescription(){
        return String.format("Scene : %s\n--------------------\n%s", title, events.stream()
                .map(eventHandler::handleEvent)
                .reduce((m1, m2) -> String.format("%s\n%s", m1, m2))
                .orElse("No events"));
    }

    public void setEventHandler(EventHandler eventHandler){
        this.eventHandler = eventHandler;
    }

    public String getTitle() {
        return title;
    }
}
