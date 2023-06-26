package mateusz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserFxTest {
    UserFx user;


    @BeforeEach
    void setUp() {
        user = new UserFx("Jan", "Kowalski", "666446464",
                "mateusz@wp.pl", "204543333", "polna6");
    }

    @Test
    void getPhone() {
    }

    @Test
    void setMail() {
        assertEquals("mateusz@wp.pl", user.getMail());
        try {
            user.setMail("mateusz.wp.pl");
        } catch (Exception e) {
            //      fail();
            System.out.println(e.getMessage());
        }
        assertEquals("mateusz@wp.pl", user.getMail());
    }

    @Test
    void getPesel() {

    }

    @Test
    @DisplayName("test funkcji ToSTring")
    void testToString() {
        assertEquals("Jan Kowalski (666446464)", user.toString());
    }
}