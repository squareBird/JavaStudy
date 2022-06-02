package Calculator;

import java.util.ArrayList;

/**
 * 저장 결과를 Memory에 저장
 * ArrayList<String> 형태로 저장
 */
public class MemoryResultRepository implements ResultRepositoryInterface{

    private static ArrayList<String> store = new ArrayList<>();

    @Override
    public void save(String result) {
        store.add(result);
    }

    @Override
    public ArrayList<String> findAllResult() {
        return store;
    }

}