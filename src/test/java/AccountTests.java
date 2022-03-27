import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class AccountTests {

    private Account account;
    //корректное Имя клиента
    String correctName = "Семён Свалов";
    //Имя с пробелом в начале
    String nameWithSpaceAtTheBeginning = " Семён Свалов";
    //Имя с пробелом в конце
    String nameWithSpaceInTheEnd = "Семён Свалов ";
    //Имя меньше трех символов
    String nameLessThanThreeSymbols = "Ли";
    //Имя больше девятнадцати символов
    String nameMoreThanNineteenSymbols = "Семён Сваловвввввввв";
    //Имя с двумя пробелами
    String nameWithTwoSpaces = "Семён  Свалов";
    //Имя без пробелов
    String nameWithoutAnySpaces = "СемёнСвалов";

    //Проверяем, что корректное имя возвращает true
    @Test
    @DisplayName("Check the correct name for a bank card")
    public void checkCorrectName(){
        account = new Account(correctName);
        boolean actual = account.checkNameToEmboss();
        Assert.assertTrue(actual);
    }
    //Проверяем, что имя c пробелом в начале возвращает false
    @Test
    @DisplayName("Check the name with space at the beginning for a bank card")
    public void checkNameWithSpaceAtTheBeginning(){
        account = new Account(nameWithSpaceAtTheBeginning);
        boolean actual = account.checkNameToEmboss();
        Assert.assertFalse(actual);
    }
    //Проверяем, что имя c пробелом в конце возвращает false
    @Test
    @DisplayName("Check the name with space in the end for a bank card")
    public void checkNameWithSpaceInTheEnd(){
        account = new Account(nameWithSpaceInTheEnd);
        boolean actual = account.checkNameToEmboss();
        Assert.assertFalse(actual);
    }
    //Проверяем, что имя меньше трех символов возвращает false
    @Test
    @DisplayName("Check the name less than three symbols for a bank card")
    public void checkNameLessThanThreeSymbols(){
        account = new Account(nameLessThanThreeSymbols);
        boolean actual = account.checkNameToEmboss();
        Assert.assertFalse(actual);
    }
    //Проверяем, что имя больше девятнадцати символов возвращает false
    @Test
    @DisplayName("Check the name more than nineteen symbols for a bank card")
    public void checkNameMoreThanNineteenSymbols(){
        account = new Account(nameMoreThanNineteenSymbols);
        boolean actual = account.checkNameToEmboss();
        Assert.assertFalse(actual);
    }
    //Проверяем, что имя с двумя пробелами возвращает false
    @Test
    @DisplayName("Check the name with two spaces for a bank card")
    public void checkNameWithTwoSpaces(){
        account = new Account(nameWithTwoSpaces);
        boolean actual = account.checkNameToEmboss();
        Assert.assertFalse(actual);
    }
    //Проверяем, что имя без пробелов возвращает false
    @Test
    @DisplayName("Check the name without any spaces for a bank card")
    public void checkNameWithoutAnySpaces(){
        account = new Account(nameWithoutAnySpaces);
        boolean actual = account.checkNameToEmboss();
        Assert.assertFalse(actual);
    }

}
