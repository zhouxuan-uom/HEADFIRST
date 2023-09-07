package spring.circular_dependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhouxuan on 2023/9/7
 *
 * @Author: zhouxuan
 * @Date: 2023/9/7
 */
@Component
public class ConstructorA {
    private ConstructorB constructorB;

    @Autowired
    public ConstructorA(ConstructorB constructorB) {
        this.constructorB = constructorB;
    }

    public void m() {
        constructorB.p();
    }

    public void p() {
        System.out.println("I'm ConstructorA");
    }
}
