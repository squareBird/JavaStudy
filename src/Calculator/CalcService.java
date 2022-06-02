package Calculator;

import java.util.Scanner;

public class CalcService {

    private final CalculatorInterface calculator;

    CalcService(CalculatorInterface calculator) {
        this.calculator = calculator;
    }

    public static void main(String[] args) {

        // 객체 주입
        CalcService calcService = new CalcService(
                new ConsoleCalculator(
                        new MemoryResultRepository()));

        // 메뉴
        calcService.menu();

    }

    void menu() {

        Scanner scan = new Scanner(System.in);

        while(true) {

            int choice = 0;

            System.out.println("1. 조회");
            System.out.println("2. 계산");
            System.out.println("0. 종료");

            choice = scan.nextInt();

            switch(choice) {
                case 1:
                    calculator.findAllResult();
                    break;
                case 2:
                    calculator.calculation(scan);
                    break;
                case 0:
                    System.out.println("종료");
                    break;
                default:
                    System.out.println("잘못된 입력");
                    break;
            }

            if(choice==0) break;

        }

    }

}