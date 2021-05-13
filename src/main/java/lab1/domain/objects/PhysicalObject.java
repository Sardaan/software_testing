package lab1.domain.objects;

import lab1.domain.actions.Event;
import lab1.domain.actions.EventType;

import java.util.Objects;

public class PhysicalObject {
    private final int id;

    public PhysicalObject(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Event appear() {
        return Event.of("Physical object appeared", EventType.APPEAR, this);
    }

    public String getObjectTypeName() {
        return "Physical object";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhysicalObject that = (PhysicalObject) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
