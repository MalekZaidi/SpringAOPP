package com.example.examen_malek_zaidi.configurations;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
/*
    @AfterReturning(pointcut = "execution(* com.example.examen_malek_zaidi.services.*.ajouter*(..))", returning = "result")
    public void logAjouterMethodSuccess(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        log.info("Method '{}' executed successfully. C’est une méthode d’ajout.", methodName);
    }

    @AfterReturning(pointcut = "execution(* com.example.examen_malek_zaidi.services.*.affecter*(..))", returning = "result")
    public void logAffecterMethodSuccess(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        log.info("Method '{}' executed successfully. C’est une méthode d’affectation.", methodName);
    }
    @After("execution(* com.example.examen_malek_zaidi.services.*.get*(..))")
    public void logGetMethods(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        LocalDateTime currentTime = LocalDateTime.now();

        System.out.println("Method '" + methodName + "' of class '" + className + "' called at: " + currentTime);
    }

    @Around("execution(* com.example.service..*(java.lang.String))")
    public Object logServiceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("La méthode " + joinPoint.getSignature().getName() + " a été exécutée.");
        Object result = joinPoint.proceed();
        return result;
    }
    */
}
/*
    Toutes les secondes :
@Scheduled(cron = "* * * * * *")

Toutes les minutes :
@Scheduled(cron = "0 * * * * *")

Toutes les heures à la minute 30 :
@Scheduled(cron = "0 30 * * * *")

Tous les jours à minuit :
@Scheduled(cron = "0 0 0 * * *")

Le dernier jour du mois à minuit :
@Scheduled(cron = "0 0 0 L * *")

Tous les lundis à 9h :
@Scheduled(cron = "0 0 9 ? * MON")

Les six champs d'une expression Cron :
Secondes (de 0 à 59) :
Permet de spécifier l'exécution à une seconde précise. Exemple : 0, 30.

Minutes (de 0 à 59) :
Définit l'exécution à une minute précise. Exemple : 0, 15, 30, 45.
Heures (de 0 à 23) :

Spécifie l'heure de l'exécution. Exemple : 0 pour minuit, 12 pour midi.
Jours du mois (de 1 à 31) :

Détermine les jours spécifiques du mois où la tâche doit s'exécuter. Exemple : 1, 15, 31.
Mois (de 1 à 12 ou par abréviations JAN-DEC) :

Spécifie les mois de l'année pour lesquels la tâche est planifiée. Exemple : 1 pour janvier, 12 pour décembre, ou JAN, DEC.
Jours de la semaine (de 0 à 7 ou par abréviations SUN-SAT) :

Indique les jours de la semaine où la tâche doit être exécutée. 0 et 7 représentent tous les deux le dimanche. Exemple : 1 pour lundi, 7 pour dimanche, ou MON, SUN.



@Around : Permet d'exécuter du code avant et après l'appel à une méthode.

@AfterReturning : Exécute un conseil après le retour d'une méthode sans erreur.

@AfterThrowing : Exécute un conseil après le lancement d'une exception dans une méthode.
*/