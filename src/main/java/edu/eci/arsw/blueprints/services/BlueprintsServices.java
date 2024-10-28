import edu.eci.arsw.blueprints.filters.BlueprintsFilter;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hcadavid
 */
@Service
public class BlueprintsServices {

    private final BlueprintsPersistence bpp;
    private final BlueprintsFilter filter;

    @Autowired
    public BlueprintsServices(BlueprintsPersistence bpp, BlueprintsFilter filter) {
        this.bpp = bpp;
        this.filter = filter;
    }

    public void addNewBlueprint(Blueprint bp) throws BlueprintPersistenceException {
        bpp.saveBlueprint(bp);
    }

    public List<String> getAllBlueprints() {
        List<String> val = new ArrayList<>();
        for (Blueprint b : bpp.getAllBlueprints()) {
            val.add(b.toString());
        }
        return val;
    }

    /**
     *
     * @param author blueprint's author
     * @param name blueprint's name
     * @return the blueprint of the given name created by the given author
     * @throws BlueprintNotFoundException if there is no such blueprint
     */
    public Blueprint getBlueprint(String author, String name) throws BlueprintNotFoundException {
        Blueprint blueprint = bpp.getBlueprint(author, name);
        filter.filter(blueprint); // Aplicar filtro antes de retornar el plano
        return blueprint;
    }

    /**
     *
     * @param author blueprint's author
     * @return all the blueprints of the given author
     * @throws BlueprintNotFoundException if the given author doesn't exist
     */
    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException {
        Set<Blueprint> blueprints = bpp.getBlueprintsByAuthor(author);
        for (Blueprint bp : blueprints) {
            filter.filter(bp);
        }
        return blueprints;
    }
}
