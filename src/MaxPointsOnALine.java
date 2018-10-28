
import java.util.HashMap;
import java.util.Map;
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
public class MaxPointsOnALine {
    public static int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        int len = points.length;
        int result = 0;
        for (int i = 0; i < len - 1; i ++) {
            Map<Double, Integer> map = new HashMap<>();
            int sameX = 0;
            int sameP = 0;
            for (int j = i + 1; j < len; j ++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    sameP ++;
                } else if (points[i].x == points[j].x) {
                    sameX ++;
                    continue;
                }
                double slope = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);

                if (map.containsKey(slope)) {
                    map.put(slope, map.get(slope) + 1);
                } else {
                    map.put(slope, 2);
                }
                result = Math.max(result, map.get(slope));
            }
            for (Map.Entry entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
            result = Math.max(result, sameX + 1);
        }
        return result;
    }
    public static void main(String[] args) {
        Point[] points = {
                new Point(2, 3), new Point(3, 3), new Point(-5, 3)
        };
        System.out.println(maxPoints(points));
        System.out.println(0.0 == -0.0);
    }
}
