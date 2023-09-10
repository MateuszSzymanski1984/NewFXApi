package mateusz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserFxTest {
    private UserFx user;

    @BeforeEach
    void setUp() {
        user = new UserFx("Jan", "Kowalski", "666446464",
                "mateusz@wp.pl", "204543333", "polna6");
    }

    @Test
    void getPhone() {
        assertEquals("666446464", user.getPhone());
    }

    @Test
    void setPhone() {
        assertEquals("6664464", user.getPhone());

        // Ustaw nowy numer telefonu (9 znaków)
        user.setPhone("777777777");

        // Sprawdź, czy numer telefonu został ustawiony poprawnie
        assertEquals("777777777", user.getPhone());

        // Próba ustawienia numeru telefonu o niepoprawnej długości (mniej niż 9 znaków)
        assertThrows(IllegalArgumentException.class, () -> user.setPhone("12345"));

        // Próba ustawienia numeru telefonu o niepoprawnej długości (więcej niż 9 znaków)
        assertThrows(IllegalArgumentException.class, () -> user.setPhone("1234567890"));
    }

    @Test
    void setMail() {
        assertEquals("mateusz@wp.pl", user.getMail());
        try {
            user.setMail("mateusz.wp.pl");
        } catch (Exception e) {
            // fail();
            System.out.println(e.getMessage());
        }
        assertEquals("mateusz@wp.pl", user.getMail());
    }

    @Test
    void getPesel() {
        assertEquals("204543333", user.getPesel());
    }

    @Test
    @DisplayName("test funkcji ToString")
    void testToString() {
        assertEquals("Jan Kowalski (666446464)", user.toString());
    }
}
