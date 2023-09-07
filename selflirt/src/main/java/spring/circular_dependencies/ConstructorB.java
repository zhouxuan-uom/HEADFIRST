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
public class ConstructorB {
    private ConstructorA constructorA;

    @Autowired
    public ConstructorB(ConstructorA constructorA) {
        this.constructorA = constructorA;
    }

    public void m() {
        constructorA.p();
    }

    public void p() {
        System.out.println("I'm ConstructorB");
    }
}
