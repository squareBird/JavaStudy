package Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ConsoleCalculator implements CalculatorInterface{

    private final ResultRepositoryInterface repository;

    ConsoleCalculator(ResultRepositoryInterface repository) {
        this.repository = repository;
    }
    @Override
    public void calculation(Scanner scan) {

        System.out.println("계산식 입력 (숫자, 연산부호 구분 띄어쓰기)");

        scan.nextLine();
        String input = scan.nextLine();

        // 예외처리
        // 1. 앞에 부호가-일 경우
        ArrayList<String> list = new ArrayList<>(Arrays.asList(input.split("(?<=[*/+-])|(?=[*/+-])")));

        System.out.println(list);

        multiply(list);
        divide(list);
        plus(list);
        subtract(list);

        System.out.println(list.get(0));

        save(input+"="+list.get(0));

    }

    void multiply(ArrayList<String> list) {
        while(true) {
            if(list.indexOf("*")==-1)
                break;

            int index = list.indexOf("*");
            int pre = Integer.parseInt(list.get(index-1));
            int next = Integer.parseInt(list.get(index+1));
            int result = pre*next;

            list.set(index, Integer.toString(result));
            list.remove(index+1);
            list.remove(index-1);
        }

    }

    void divide(ArrayList<String> list) {
        while(true) {
            if(list.indexOf("/")==-1)
                break;

            int index = list.indexOf("/");
            int pre = Integer.parseInt(list.get(index-1));
            int next = Integer.parseInt(list.get(index+1));
            int result = pre/next;

            list.set(index, Integer.toString(result));
            list.remove(index+1);
            list.remove(index-1);
        }



    }

    void plus(ArrayList<String> list) {
        while(true) {
            if(list.indexOf("+")==-1)
                break;

            int index = list.indexOf("+");
            int pre = Integer.parseInt(list.get(index-1));
            int next = Integer.parseInt(list.get(index+1));
            int result = pre+next;

            list.set(index, Integer.toString(result));
            list.remove(index+1);
            list.remove(index-1);
        }


    }

    void subtract(ArrayList<String> list) {
        while(true) {
            if(list.indexOf("-")==-1)
                break;

            int index = list.indexOf("-");
            int pre = Integer.parseInt(list.get(index-1));
            int next = Integer.parseInt(list.get(index+1));
            int result = pre-next;

            list.set(index, Integer.toString(result));
            list.remove(index+1);
            list.remove(index-1);
        }
    }

    @Override
    public void save(String result) {
        repository.save(result);
    }

    @Override
    public ArrayList<String> findAllResult() {
        return repository.findAllResult();
    }

}
