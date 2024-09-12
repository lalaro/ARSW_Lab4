package edu.eci.arsw.blueprints.filters;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("SubsamplingFilter")
public class SubsamplingFilter implements BlueprintsFilter {
    @Override
    public Blueprint filter(Blueprint bp) {
        List<Point> oldPoints = bp.getPoints();
        List<Point> sampledPoints = new ArrayList<>();

        for (int i = 0; i < oldPoints.size(); i++) {
            if (i % 2 == 0) {
                sampledPoints.add(oldPoints.get(i));
            }
        }

        // Convert ArrayList to Point array
        Point[] sampledPointsArray = sampledPoints.toArray(new Point[0]);

        return new Blueprint(bp.getAuthor(), bp.getName(), sampledPointsArray);
    }
}
