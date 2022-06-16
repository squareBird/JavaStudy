package Calculator;

import java.util.ArrayList;

/**
 * 계산 결과를 저장하기 위한 기능을 하는 인터페이스
 * 저장과 모든결과 조회 기능을 제공
 */
public interface ResultRepository {

    void save(String result);
    ArrayList<String> findAllResult();

}
