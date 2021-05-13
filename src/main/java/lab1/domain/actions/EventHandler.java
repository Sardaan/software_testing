package lab1.domain.actions;

import lab1.domain.objects.PhysicalObject;

public class EventHandler {
    String handleEvent(Event event){
        if (event == null) throw new IllegalArgumentException("Argument should not be null");
        final String subjectMsg = event.getPhysicalObject().map(PhysicalObject::getObjectTypeName).orElse("[No subject]");
        return String.format("[Event - %s] => Subject: %s; Description: %s",
                event.getEventType(),
                subjectMsg,
                event.getDescription());
    }
}
