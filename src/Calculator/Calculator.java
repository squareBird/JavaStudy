package Calculator;

import java.util.ArrayList;
import java.util.Scanner;

// 계산기 기능
public interface Calculator {

    // 계산
    void calculate();

    // 계산 결과 저장
    void save(String result);

    // 모든 결과 조회
    void findAllResult();

}