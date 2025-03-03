package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Clicks {
    static class UserSession {
        String userId;
        int adClicks;
        int startTime;
        int endTime;

        public UserSession(String userId, int adClicks, int startTime, int endTime) {
            this.userId = userId;
            this.adClicks = adClicks;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    static class StreamingProcessor {
        private int currentTime;
        private PriorityQueue<UserSession> activeSessions;
        private int maxClicks;
        private List<String> maxClickUsers;

        public StreamingProcessor() {
            this.currentTime = 0;
            this.activeSessions = new PriorityQueue<>((a, b) -> a.endTime - b.endTime);
            this.maxClicks = 0;
            this.maxClickUsers = new ArrayList<>();
        }

        public void processSession(UserSession session, int t) {

               currentTime = t;

                          // Remove expired sessions
                          while (!activeSessions.isEmpty() && activeSessions.peek().endTime < currentTime) {
                              activeSessions.poll();
                          }

                          // Add new session if active at time t
                          if (session.startTime <= currentTime && session.endTime >= currentTime) {
                              activeSessions.offer(session);
                          }

                          // Recalculate max clicks
                         maxClicks = 0;
                          maxClickUsers.clear();
                          for (UserSession active : activeSessions) {
                              if (active.adClicks > maxClicks) {
                                  maxClicks = active.adClicks;
                                  maxClickUsers.clear();
                                  maxClickUsers.add(active.userId);
                              } else if (active.adClicks == maxClicks) {
                                  maxClickUsers.add(active.userId);
                              }
                          }

        }

        public List<String> getMaxClickUsers() {
            return maxClickUsers;
        }
    }

    public static void main(String[] args) {
        List<UserSession> stream = Arrays.asList(
                new UserSession("user0", 5, 1, 5),
                new UserSession("user0", 3, 7, 9),
                new UserSession("user1", 2, 2, 4),
                new UserSession("user2", 7, 3, 4),
                new UserSession("user3", 7, 2, 6)
        );

        StreamingProcessor processor = new StreamingProcessor();
        int[] times = {3, 6, 9}; // Example times to process

        for (int t : times) {
            System.out.println("Processing time t = " + t);
            for (UserSession session : stream) {
                processor.processSession(session, t);
            }
            System.out.println("User(s) with the highest ad clicks: " + processor.getMaxClickUsers());
        }
    }
}
