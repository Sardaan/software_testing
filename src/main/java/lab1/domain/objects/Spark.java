package lab1.domain.objects;

import lab1.domain.actions.Event;
import lab1.domain.actions.EventType;

public class Spark extends PhysicalObject{

    public Spark(int objectId) {
        super(objectId);
    }
    @Override
    public String getObjectTypeName() {
        return "Spark";
    }

    @Override
    public Event appear() {
        return Event.of("Spark " + this.getId() + " is appeared", EventType.APPEAR, this);
    }
}
