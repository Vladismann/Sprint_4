import java.util.regex.Pattern;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }
    /*
    Метод который проверяет возможность печати имени на банковской карте.
    Если имя соответвует условию, то возвращает "true", если нет, то "false".
    Условия:
    - в строке не меньше 3 и не больше 19 символов,
    - в строке есть только один пробел,
    - пробел стоит не в начале и не в конце строки.
     */
    public boolean checkNameToEmboss(){
        final String PATTERN = "(?=.{3,19}$)^[a-zA-Zа-яА-ЯёЁ]+[\\s][a-zA-Zа-яА-ЯёЁ]+$";
        if(name == null){
            return false;
        }
        return Pattern.matches(PATTERN, name);
    }

}