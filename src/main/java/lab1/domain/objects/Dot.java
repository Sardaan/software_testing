package lab1.domain.objects;

import lab1.domain.actions.Event;
import lab1.domain.actions.EventType;

public class Dot extends PhysicalObject{

    public Dot(int objectId) {
        super(objectId);
    }
    @Override
    public String getObjectTypeName() {
        return "Dot";
    }
    @Override
    public Event appear() {
        return Event.of("Dot number " + this.getId() + " is appeared", EventType.APPEAR, this);
    }
}
