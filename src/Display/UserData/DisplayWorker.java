package Display.UserData;

public class DisplayWorker {

    private final DisplayEmployee displayEmployee;

    public DisplayWorker(DisplayEmployee displayEmployee) {
        this.displayEmployee = displayEmployee;
    }

    public void jobTitle(){
        System.out.println("Введите должность");
    }

    public void department(){
        System.out.println("Введите отдел");
    }

    public void salary(){
        System.out.println("Укажите зарплату");
    }

    public void choiceParam(){
        displayEmployee.params();
        String [] params = {"7. Название должности","8. Отдел","9. Зарплата",
                "10. Дата приема на работу","11. Является ли начальником"};
        for (String s: params) {
            System.out.println(s);
        }
    }
}
