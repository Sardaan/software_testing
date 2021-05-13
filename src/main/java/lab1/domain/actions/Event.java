package lab1.domain.actions;

import lab1.domain.objects.PhysicalObject;
import java.util.Optional;

public class Event {
    private final String description;
    private final EventType eventType;
    private PhysicalObject physicalObject;

    public Event(String description, EventType eventType){
        this.description = description;
        this.eventType = eventType;
    }

    public Event(String description, EventType eventType, PhysicalObject physicalObject){
        this.description = description;
        this.eventType = eventType;
        this.physicalObject = physicalObject;
    }
    public String getDescription() {
        return description;
    }

    public EventType getEventType() {
        return eventType;
    }

    public Optional<PhysicalObject> getPhysicalObject() {
        return Optional.ofNullable(physicalObject);
    }

    public static Event of(String description, EventType eventType){
        return new Event(description, eventType);
    }

    public static Event of(String description, EventType eventType, PhysicalObject physicalObject) {
        return new Event(description, eventType, physicalObject);
    }
}
