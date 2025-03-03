package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MouseAndCheese {
}

enum Direction {
    up, down, right, left
}
interface Mouse {

    /**
     * Moves to one of the directions (left, right, up, down) and returns false if you can't move and true if you can.
     */
    public boolean move(Direction direction);

    /**
     * Returns true if there is a cheese in the current cell.
     */
    public boolean hasCheese();

    /**
     * Should return true and leave the mouse at that location or false if we can't find cheese and return the mouse back to where it started.
     */
    default boolean getCheese() {
        return dfs(0, 0, null);
    }
    Map<Integer, Set<Integer>> visited = new HashMap<>();
    default boolean dfs(int x, int y, Direction lastDir) {
        if (hasCheese()) {
            return true;
        }

        if (!visited.containsKey(x) || !visited.get(x).contains(y)) {
            visited.putIfAbsent(x, new HashSet<>());
            visited.get(x).add(y);

            if (move(Direction.up) && dfs(x, y + 1, Direction.up)) {
                return true;
            }

            if (move(Direction.left) && dfs(x - 1, y, Direction.left)) {
                return true;
            }

            if (move(Direction.down) && dfs(x, y - 1, Direction.down)) {
                return true;
            }

            if (move(Direction.right) && dfs(x + 1, y, Direction.right)) {
                return true;
            }
        }

        // found nothing.
        if (lastDir != null) {
            if (lastDir == Direction.up) {
                move(Direction.down);
            } else if (lastDir == Direction.down) {
                move(Direction.up);
            } else if (lastDir == Direction.left) {
                move(Direction.right);
            } else {
                move(Direction.left);
            }
        }

        return false;
    }
}
