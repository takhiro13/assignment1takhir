package models;

import java.util.ArrayList;

public class Shape {
    ArrayList<Point> points = new ArrayList<>();

    public void addPoint(Point point){
        points.add(point);
    }

    public double calculatePerimeter() {
        double perimeter = 0;
        int size = points.size();

        for (int i = 0; i < size; i++) {
            Point currentPoint = points.get(i);
            Point nextPoint = points.get((i + 1) % size);

            perimeter += currentPoint.distance(nextPoint);
        }

        return perimeter;
    }

    public double getAverageSide() {
        int size = points.size();
        if (size == 0) {
            return 0;
        }

        return calculatePerimeter() / size;
    }

    public double getLongestSide() {
        double longestSide = 0;

        for (int i = 0; i < points.size(); i++) {
            Point currentPoint = points.get(i);
            Point nextPoint = points.get((i + 1) % points.size());

            double currentSide = currentPoint.distance(nextPoint);
            if (currentSide > longestSide) {
                longestSide = currentSide;
            }
        }

        return longestSide;
    }
}

