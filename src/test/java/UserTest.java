import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.skypro.User;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    public static final String VALID_LOGIN = "user";
    public static final String INVALID_LOGIN = "";
    public static final String VALID_EMAIL = "email@user.com";
    public static final String INVALID_EMAIL = "user.com";

    @Test
    @DisplayName("Создание объекта с параметрами")
    void shouldCreateUserWithAllArguments() {
        User out = new User(VALID_LOGIN, VALID_EMAIL);
        assertEquals(VALID_LOGIN,out.getLogin());
        assertEquals(VALID_EMAIL,out.getEmail());
    }
    @Test
    @DisplayName("Создание объекта без параметров")
    void shouldCreateUserWithoutArguments() {
        User out = new User();
        assertNull(out.getLogin());
        assertNull(out.getEmail());
    }
    @Test
    @DisplayName("Ошибка создания объекта с некорректным email")
    void shouldCreateUserWithNotValidEmail() {
        assertThrows(IllegalArgumentException.class,()-> new User(VALID_LOGIN,INVALID_EMAIL));
    }
    @Test
    @DisplayName("Ошибка при установке некорректного email")
    void shouldSetInvalidEmail() {
        User out = new User();
        assertThrows(IllegalArgumentException.class,()-> out.setEmail(INVALID_EMAIL));
    }

    @Test
    @DisplayName("Ошибка при установке логина равным email")
    void shouldSetLoginEqualEmail() {
        User out = new User();
        out.setEmail(VALID_EMAIL);
        assertThrows(IllegalArgumentException.class,()-> out.setLogin(VALID_EMAIL));
    }

}
