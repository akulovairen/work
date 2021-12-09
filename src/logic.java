import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class logic {


    public static void main(String[] args) throws FileNotFoundException {
        FileReader empl = new FileReader("D:\\загрузка\\data.txt");
        BufferedReader bufferedReader = (BufferedReader) new BufferedReader(empl);
        EmailSender emailSender=new EmailSender();
        List<Employee> employeesList = bufferedReader.lines()
                .map(s -> {
                    String[] strArrray = s.split(",");
                    return new Employee(strArrray[0], strArrray[1], Integer.parseInt(strArrray[2]), strArrray[3]);
                })
                .collect(Collectors.toList());
        List<Employee> employeeList = employeesList
                .stream()
                .filter(employee -> employee.getExperience() > 3)
                .filter(employee -> employee.getPosition().equals("Тестировщик") || employee.getPosition().equals("Разработчик"))
                .collect(Collectors.toList());
        employeeList
                .stream()
                .forEach(employee -> {
                    emailSender.send(employee.getEmail(),"вам нужно пройти переквалификацию");
                });
    }

    }
