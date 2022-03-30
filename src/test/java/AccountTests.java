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
    //Тестовые параметры:
    @Parameterized.Parameters(name = "Check the name: {0}")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"Семён Свалов", true}, //1. Корректное имя
                {"Л И", true}, //2. Имя из трех символов (граничное значение)
                {"Семен Сваловввввввв", true}, //3. Имя из девадтнадцати символов (граничное значение)
                {"Л Ии", true}, //4. Имя из четырех символов (внутреннее граничное значение)
                {"Семен Сваловвввввв", true}, //5. Имя из восемнадцати символов (внутреннее граничное значение)
                {" Семён Свалов", false}, //6. Имя с пробелом в начале
                {"Семён Свалов ", false}, //7. Имя с пробелом в конце
                {"Ли", false}, //8. Имя меньше трех символов
                {"Семён Сваловвввввввв", false}, //9. Имя больше девятнадцати символов
                {"", false}, //10. Пустая строка
                {null, false}, //11. Имя = null
                {"Семён  Свалов", false}, //12. Имя без пробелов
                {"СемёнСвалов", false} //13. Имя с двумя пробелами
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
