package ch.zhaw.iwi.devops.demo;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/services/newform") 

public class NewFormController {

    private static final String START_DATE = "2024-01-01";
    private static final String END_DATE = "2024-12-31";

    private Map<Integer, NewForm> newForms = new HashMap<>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        newForms.put(1, new NewForm(1, "Neue Kachel 1", "Beschreibung 1", START_DATE, END_DATE));
        newForms.put(2, new NewForm(2, "Neue Kachel 2", "Beschreibung 2", START_DATE, END_DATE));
        newForms.put(3, new NewForm(3, "Neue Kachel 3", "Beschreibung 3", START_DATE, END_DATE));
        System.out.println("Init Data for NewForms");
    }

    @GetMapping
    public List<NewForm> getNewForms() {
        return new ArrayList<>(newForms.values());
    }

    @GetMapping("/{id}")
    public NewForm getNewForm(@PathVariable Integer id) {
        return newForms.get(id);
    }

    @PostMapping
    public void createNewForm(@RequestBody NewForm newForm) {
        int newId = generateNewId();
        newForm.setId(newId);
        newForms.put(newId, newForm);
    }

    @PutMapping("/{id}")
    public void updateNewForm(@PathVariable Integer id, @RequestBody NewForm newForm) {
        newForm.setId(id);
        newForms.put(id, newForm);
    }

    @DeleteMapping("/{id}")
    public NewForm deleteNewForm(@PathVariable Integer id) {
        return newForms.remove(id);
    }

    private int generateNewId() {
        return newForms.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
    }
}
