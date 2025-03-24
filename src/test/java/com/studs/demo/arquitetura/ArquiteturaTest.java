package com.studs.demo.arquitetura;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.web.bind.annotation.RestController;

@AnalyzeClasses(packages = "com.studs.demo")
public class ArquiteturaTest {

    @ArchTest
    public final ArchRule controllerTest = ArchRuleDefinition.classes()
            .that().areAnnotatedWith(RestController.class)
            .should().resideInAPackage("..controller..")
            .andShould().haveSimpleNameEndingWith("Controller")
            .andShould().haveSimpleNameNotEndingWith("RestController");

    //Validar que controller nao esteja chamando repository

    @ArchTest
    public final ArchRule controllerNaoChamarRepositoryTest = ArchRuleDefinition.noClasses()
            .that().resideInAPackage("..controller..")
            .should().dependOnClassesThat().resideInAPackage("..repository..")
            .as("Controller nao deve chamar repository");

    //Verificar se a service esta sendo chamado somente pelo controller ou um service chamando o outro (OK)

//    @ArchTest
//    public final ArchRule serviceTest = ArchRuleDefinition.classes()
//            .that().resideInAPackage("..service..")
//            .should().onlyBeAccessed().byAnyPackage("..controller..", "..service..");
}




