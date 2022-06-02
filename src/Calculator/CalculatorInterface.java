package Calculator;

import java.util.ArrayList;
import java.util.Scanner;

// 계산기 기능
public interface CalculatorInterface {

    // 계산
    void calculation(Scanner scan);

    // 계산 결과 저장
    void save(String result);

    // 모든 결과 조회
    void findAllResult();

}