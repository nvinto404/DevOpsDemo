package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class NewFormControllerTests {
    @Test
    public void testCreateNewFormWithoutTitle() {
        NewFormController controller = new NewFormController();
        NewForm newForm = new NewForm(1, null, "Description", "2024-01-01", "2024-12-31");
        controller.createNewForm(newForm);

        assertEquals(1, controller.getNewForms().size());
        assertNotNull(controller.getNewForm(1));
        assertEquals("Description", controller.getNewForm(1).getDescription());
        assertEquals("2024-01-01", controller.getNewForm(1).getStartDate());
        assertEquals("2024-12-31", controller.getNewForm(1).getEndDate());
    }

    @Test
    public void testGetNewForms() {
        NewFormController controller = new NewFormController();
        int initialSize = controller.getNewForms().size();
        assertEquals(0, initialSize);
    }

}
