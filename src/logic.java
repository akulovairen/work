import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class logic {


    public static void main(String[] args) throws FileNotFoundException {
        List<Employee> employeesList = readEmployeesFromFile("D:\\загрузка\\data.txt");
        List<Employee> employeeList = filterEmployeesByExperienceAndPosition(employeesList, 3, "Тестировщик", "Разрабочик");
        sendEmails(employeeList);
    }

    private static void sendEmails(List<Employee> employeeList) {
        EmailSender emailSender=new EmailSender();
        employeeList
                .forEach(employee -> {
                    emailSender.send(employee.getEmail(),"вам нужно пройти переквалификацию");
                });
    }

    private static List<Employee> filterEmployeesByExperienceAndPosition(List<Employee> employeesList, int experience, String ... positions) {
        return employeesList
                .stream()
                .filter(employee -> employee.getExperience() > experience)
                .filter(employee -> employee.getPosition().equals(positions[0]) || employee.getPosition().equals(positions[1]))
                .collect(Collectors.toList());
    }

    private static List<Employee> readEmployeesFromFile(String path) throws FileNotFoundException {
        FileReader empl = new FileReader(path);
        BufferedReader bufferedReader = (BufferedReader) new BufferedReader(empl);
        return bufferedReader.lines()
                .map(s -> {
                    String[] strArrray = s.split(",");
                    return new Employee(strArrray[0], strArrray[1], Integer.parseInt(strArrray[2]), strArrray[3]);
                })
                .collect(Collectors.toList());
    }

}
