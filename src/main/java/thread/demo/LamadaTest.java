package thread.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author yumingxiao1
 * @Date 2019/12/20
 * @since 1.0.0
 */
public class LamadaTest {

    public static void main(String[] args){
        List<LamadaClass> lamadaClasses=new ArrayList<>();
        LamadaClass lamadaClass=new LamadaClass();
        lamadaClass.setCode("sada");
        lamadaClass.setName("name01");
        lamadaClasses.add(lamadaClass);

        lamadaClass=new LamadaClass();
        lamadaClass.setCode("sada1");
        lamadaClass.setName("name02");
        lamadaClasses.add(lamadaClass);

        List<String> a=lamadaClasses.stream().map(LamadaClass::getName).collect(Collectors.toList());
        System.out.println(a.size());
    }



}
