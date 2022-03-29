import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AccountTests {

    private final String name;
    private final boolean expectedResult;

    public AccountTests(String name, boolean expectedResult) {
        this.name = name;
        this.expectedResult = expectedResult;
    }
    /*Тестовые параметры:
    1. Корректное имя
    2. Имя из трех символов (граничное значение)
    3. Имя из девадтнадцати символов (граничное значение)
    4. Имя из четырех символов (внутреннее граничное значение)
    5. Имя из восемнадцати символов (внутреннее граничное значение)
    6. Имя с пробелом в начале
    7. Имя с пробелом в конце
    8. Имя меньше трех символов
    9. Имя больше девятнадцати символов
    10. Пустая строка
    11. Имя = null
    12. Имя без пробелов
    13. Имя с двумя пробелами
     */
    @Parameterized.Parameters(name = "Check the name: {0}")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"Семён Свалов", true},
                {"Л И", true},
                {"Семен Сваловввввввв", true},
                {"Л Ии", true},
                {"Семен Сваловвввввв", true},
                {" Семён Свалов", false},
                {"Семён Свалов ", false},
                {"Ли", false},
                {"Семён Сваловвввввввв", false},
                {"", false},
                {null, false},
                {"Семён  Свалов", false},
                {"СемёнСвалов", false}
        };
    }
    @Test
    @DisplayName("Check the name for a bank card")
    public void checkTheName() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        Assert.assertEquals("Проверьте корректность работы фильтрации допустимых значений",
                actual, expectedResult);
    }

}
