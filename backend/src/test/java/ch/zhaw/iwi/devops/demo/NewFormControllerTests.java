package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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

    @Test
    public void testDeleteNewForm() {
        NewFormController controller = new NewFormController();
        NewForm deletedForm = controller.deleteNewForm(1);
        System.out.println("Gelöschtes Formular: " + deletedForm);
        assertNull(controller.getNewForm(1));
    }

    @Test
    public void testUpdateNewForm() {
        NewFormController controller = new NewFormController();
        NewForm originalForm = new NewForm();
        originalForm.setId(1);
        originalForm.setName("Originalname");
        controller.createNewForm(originalForm); 
    
        NewForm updatedForm = new NewForm();
        updatedForm.setId(1);
        updatedForm.setName("Aktualisierter Name");
        controller.updateNewForm(1, updatedForm);
        assertEquals("Aktualisierter Name", controller.getNewForm(1).getName());
    }
}
