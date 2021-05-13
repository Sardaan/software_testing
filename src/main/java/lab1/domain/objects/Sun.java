package lab1.domain.objects;

import lab1.domain.actions.Event;
import lab1.domain.actions.EventType;

public class Sun extends PhysicalObject{

    private boolean isBurning;

    public Sun(int objectId, boolean isBurning) {
        super(objectId);
        this.isBurning = isBurning;
    }

    public boolean isBurning() {
        return isBurning;
    }

    @Override
    public String getObjectTypeName() {
        return "Sun";
    }

    public Event burn() {
        isBurning = true;
        return Event.of("Sun number " + this.getId() + " start burning", EventType.BURN, this);
    }

    @Override
    public Event appear() {
        return Event.of("Sun number " + this.getId() + " is appeared", EventType.APPEAR, this);
    }
}
