package com.exchange.bbs.log;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author gan
 * @date 2018/11/28 11:28 AM
 */

@Configuration
public class Cofigig {

    @Bean
//    @Scope("prototype")
    public A a(){
        return new A();
    }

    @Bean
    public B b(){
        B b = new B();
        b.setA(a());
        return b;
    }

    @Bean
    public C c(){
        C c = new C();
        c.setB(b());
        c.setA(a());
        return c;
    }

}

class A{
    public A(){
        System.out.println("A==========================");
    }
}

@Data
class B{
    private A a;

    public B(){
        System.out.println("Ｂ=========================");
    }
}

@Data
class C{
    private A a;
    private B b;
    public C(){
        System.out.println("c===================");
    }
}
