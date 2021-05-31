package Lessons.AOP.AfterAdvices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(public int Lessons.AOP.AfterAdvices.Divider.divide(int, int))")
    private void publicIntDivideMethod() {};

    @Before("publicIntDivideMethod()")
    private void beforeDivideAdvice(JoinPoint jp) {
        Object[] params = jp.getArgs();
        System.out.println("BEFORE:");
        System.out.println("---------------------------------------");
        System.out.println("Input params:");
        Arrays.stream(params).forEach(System.out::println);
        System.out.println("---------------------------------------");
    }

    @After("publicIntDivideMethod()")
    private void afterDivideAdvice() {
        System.out.println("AFTER:");
        System.out.println("---------------------------------------");
        System.out.println("Method executed.");
        System.out.println("---------------------------------------");
    }

    @AfterReturning(pointcut = "publicIntDivideMethod()", returning = "result")
    private void afterReturningDivideAdvice(double result) {
        System.out.println("AFTER RETURNING:");
        System.out.println("---------------------------------------");
        System.out.println("Result: " + result );
        System.out.println("---------------------------------------");
    }

    @AfterThrowing(pointcut = "publicIntDivideMethod()", throwing = "exception")
    private void afterThrowingDivideAdvice(Throwable exception) {
        System.out.println("AFTER THROWING:");
        System.out.println("---------------------------------------");
        System.out.println("Exception type: " + exception.toString() );
        System.out.println("---------------------------------------");
    }


}
