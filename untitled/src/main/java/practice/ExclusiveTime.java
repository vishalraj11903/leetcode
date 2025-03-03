package practice;

import java.util.*;

public class ExclusiveTime {
    public static void main(String[] arg) {
        List<Event> events = Arrays.asList(
                new Event("main", "start", 0),
                new Event("foo", "start", 3),
                new Event("foo", "end", 7),
                new Event("zoo", "start", 10),
                new Event("zoo", "end", 13),
                new Event("moo", "start", 15),
                new Event("foo", "start", 17),
                new Event("foo", "end", 18),
                new Event("moo", "end", 20),
                new Event("main", "end", 22)
        );

        Stack<Aux> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();
        for (Event event : events) {
            /*if ("start".equals(event.type)) {
                if (!stack.isEmpty()) {
                    Aux peek = stack.peek();
                    peek.sum += event.time - peek.lastTime;
                }
                stack.push(new Aux(event.name,0, event.time));
            } else {
                Aux top = stack.pop();
                int diff = event.time - top.lastTime;
                map.put(event.name, map.getOrDefault(event.name, 0) + diff + top.sum);
                if (!stack.isEmpty()) {
                    stack.peek().lastTime = event.time;
                }
            }*/
           if ("start".equals(event.type)) {
               stack.push(new Aux(event.name, 0, event.time));
           } else {
               Aux top = stack.pop();
               int diff = event.time - top.time;
               map.put(event.name, map.getOrDefault(event.name, 0) + diff - top.child);
               if (!stack.isEmpty()) {
                   stack.peek().child += diff;
               }
           }
        }

        System.out.println(map);
    }

    static class Aux {
        int child;
        int time;
        String name;
        Aux(String name, int child, int last) {
            this.child = child;
            this.name = name;
            this.time = last;
        }

        @Override
        public String toString() {
            return "Name " + name + " sum " + child + " lastTime " + time;
        }
    }
    static class Event {
        String name;
        String type;
        int time;

        Event(String name, String type, int time) {
            this.name = name;
            this.type = type;
            this.time = time;
        }
    }
}
