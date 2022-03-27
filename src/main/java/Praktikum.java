public class Praktikum {

    public static void main(String[] args) {
        //Тестируемое имя
        String name = "Семён Свалов";
        //Создание экземляра класса Account
        Account account = new Account(name);
        //Запуска метода проверки имени
        account.checkNameToEmboss();
    }

}