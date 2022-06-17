package Calculator;

import java.util.*;

public class ConsoleCalculator implements Calculator{

    private final ResultRepository repository;
    private final String PLUS = "+";
    private final String MINUS = "-";
    private final String MULTIPLY = "*";
    private final String DIVIDE = "/";

    ConsoleCalculator(ResultRepository repository) {
        this.repository = repository;
    }
    @Override
    public void calculate() {

        System.out.println("계산식 입력 (숫자, 연산부호 구분 띄어쓰기)");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        ArrayList<String> list = new ArrayList<>(Arrays.asList(input.split("(?<=[*/+-])|(?=[*/+-])")));

        while(true) {

            // list의 모든 계산을 마쳐서 하나의 값이 남으면 끝
            if(list.size()==1) break;

            // 가장 먼저 계산해야할 부호가 위치한 곳을 찾음
            // 앞의꺼랑 뒤에꺼랑 Operater이용해 계산 후 뒤, 앞 순으로 ArrayList에서 제거
            int index = findIndex(list);
            int pre = Integer.parseInt(list.get(index-1));
            int next = Integer.parseInt(list.get(index+1));

            Operater operater = Operater.of(list.get(index));

            list.set(index, Integer.toString(operater.caculate(pre,next)));
            list.remove(index+1);
            list.remove(index-1);

        }

        System.out.println(list.get(0));

        save(input+"="+list.get(0));

    }

    int findIndex(ArrayList<String> list) {

        // 부호별로 제일 앞에있는거 확인
        int multiple = list.indexOf(MULTIPLY);
        int divide = list.indexOf(DIVIDE);

        // 곱셈이나 나눗셈중에 하나라도 -1이 아니면 그 값을 옮김
        if(multiple!=-1 || divide!=-1) {
            // 최초에 min값이 -1이면 다른 하나가 -1이 아니라는 소리 max로 return
            if(Math.min(list.indexOf(MULTIPLY),list.indexOf(DIVIDE))==-1) {
                return Math.max(list.indexOf(MULTIPLY),list.indexOf(DIVIDE));
            }
            return Math.min(list.indexOf(MULTIPLY),list.indexOf(DIVIDE));
        }

        if(Math.min(list.indexOf(PLUS), list.indexOf(MINUS))==-1) {
            return Math.max(list.indexOf(PLUS), list.indexOf(MINUS));
        }
        return Math.min(list.indexOf(PLUS), list.indexOf(MINUS));

    }

    // repository에 저장
    @Override
    public void save(String result) {
        repository.save(result);
    }

    // 모든 결과 조회
    @Override
    public void  findAllResult() {

        ArrayList<String> result = repository.findAllResult();

        if(result.size()==0) {
            System.out.println("조회 결과 없음");
        } else {
            for (String s : result) {
                System.out.println(s);
            }
        }

    }

}
