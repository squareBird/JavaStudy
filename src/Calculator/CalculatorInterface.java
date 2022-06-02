package Calculator;

import java.util.ArrayList;
import java.util.Scanner;

public interface CalculatorInterface {

    void calculation(Scanner scan);

    void save(String result);

    ArrayList<String> findAllResult();

}