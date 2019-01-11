package MeetingSystem.Builders;

import MeetingSystem.Event;
import MeetingSystem.Place;
import MeetingSystem.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class EventBuilderTest {

    @Test
    void build() {
        String name = "a";
        String desc = "b";
        Place p = new Place("wro","plac","na pwr");
        String theme = "t";
        String time = "jutro";
        int minSlots = 1;
        int maxSlots = 10;

        EventBuilder builder = new EventBuilder(name,new User(),minSlots,maxSlots,time);
        builder.setDescription(desc);
        builder.setPlace(p);
        builder.setTheme(theme);
        Event e = builder.build();

        assertTrue(e.getName().equals(name) && e.getDescription().equals(desc) && e.getTheme().equals(theme) && e.getTime().equals(time) && minSlots==e.getMinSlots() && maxSlots==e.getMaxSlots() && e.getPlace().equals(p));

    }
}