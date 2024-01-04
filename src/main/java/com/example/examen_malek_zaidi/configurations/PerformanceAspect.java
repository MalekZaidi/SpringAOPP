package com.example.examen_malek_zaidi.configurations;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class PerformanceAspect {
}

/*
En utilisant Spring AOP implémenter un aspect qui permet d’afficher le temps de réponse
        et les noms de méthodes exécutées ayant le type de retour void
    @Around("execution(void *.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().toShortString();
        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Méthode : " + methodName + " - Temps d'exécution : " + executionTime + "ms");
        return result;
    }
 @Around("execution(void *.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().toShortString();

        // Exécute la méthode interceptée
        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Méthode : " + methodName + " - Temps d'exécution : " + executionTime + "ms");

        return result;
    }
}
@Slf4j
@Aspect
@Configuration
public class PerformanceAspect {



    @Around("execution(* tn.esprit.tpfoyer.service.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime
                +"milliseconds.");
        return obj;
    }
}*/
