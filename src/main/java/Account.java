public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    /*
    Метод который проверяет возможность печати имени на банковской карте.
    Если имя соответвует условию, то возвращает "true", если нет, то "false"
    Сначала считает количество пробелов в строке и после проверяет условия:
    - в строке не меньше 3 и не больше 19 символов,
    - в строке есть только один пробел,
    - пробел стоит не в начале и не в конце строки.
     */
    public boolean checkNameToEmboss() {
        int spaceCount = 0;

        for (int i = 1; i < name.length(); i++) {
            char symbol = name.charAt(i);
            if (symbol == ' ')
                spaceCount++;
        }
         if (!(name.length() >= 3 && name.length() <= 19)) {
            System.out.println("Некорректное имя! Введите имя в соответствии с условием - в имени не меньше 3 и не больше 19 символов");
            return false;
        } else if (name.startsWith(" ") || name.endsWith(" ")) {
            System.out.println("Некорректное имя! Введите имя в соответствии с условием - пробел стоит не в начале и не в конце имени");
            return false;
        } else if (spaceCount == 0 || spaceCount > 1) {
             System.out.println("Некорректное имя! Введите имя в соответствии с условием - в имени есть один пробел");
             return false;
         }
        System.out.println("Имя введено корректно");
        return true;
    }

}