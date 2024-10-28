package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.filters.RedundancyFilter;
import edu.eci.arsw.blueprints.filters.SubsamplingFilter;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import org.junit.Test;
import static org.junit.Assert.*;

public class BlueprintFiltersTest {

    @Test
    public void testRedundancyFilter() {
        Point[] points = new Point[]{
                new Point(0, 0), new Point(0, 0),
                new Point(10, 10), new Point(10, 10)
        };
        Blueprint bp = new Blueprint("author1", "blueprint1", points);

        RedundancyFilter filter = new RedundancyFilter();
        filter.filter(bp);

        Point[] expectedPoints = new Point[]{
                new Point(0, 0), new Point(10, 10)
        };
        Blueprint expectedBp = new Blueprint("author1", "blueprint1", expectedPoints);

        assertEquals(expectedBp.getPoints().size(), bp.getPoints().size());
        assertEquals(expectedBp.getPoints(), bp.getPoints());
    }

    @Test
    public void testSubsamplingFilter() {
        Point[] points = new Point[]{
                new Point(0, 0), new Point(1, 1),
                new Point(2, 2), new Point(3, 3),
                new Point(4, 4), new Point(5, 5)
        };
        Blueprint bp = new Blueprint("author2", "blueprint2", points);

        SubsamplingFilter filter = new SubsamplingFilter();
        filter.filter(bp);

        Point[] expectedPoints = new Point[]{
                new Point(0, 0), new Point(2, 2), new Point(4, 4)
        };
        Blueprint expectedBp = new Blueprint("author2", "blueprint2", expectedPoints);

        assertEquals(expectedBp.getPoints().size(), bp.getPoints().size());
        assertEquals(expectedBp.getPoints(), bp.getPoints());
    }
}
