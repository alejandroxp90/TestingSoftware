package org.testerA.basico;

import org.testng.annotations.*;

public class NivelJerarquiaTestNG {

    @BeforeSuite
    public void BeforeSuit(){
        System.out.println("Aqui se inicia BeforeSuit");
    }
    @BeforeTest
    public void BeforeTest(){
        System.out.println("Aqui se inicia BeforeTest");
    }
    @BeforeClass
    public void BeforeClass(){
        System.out.println("Aqui se inicia BeforeClass");
    }
    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("Aqui se inicia BeforeMethod");
    }

    @Test
    public void startTest1(){
        System.out.println("Inicio del Test 1");
    }

    @Test
    public void startTest2(){
        System.out.println("Inicio del Test 2");
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("Aqui se inicia AfterMethod");
    }
    @AfterClass
    public void AfterClass(){
        System.out.println("Aqui se inicia AfterClass");
    }
    @AfterTest
    public void AfterTest(){
        System.out.println("Aqui se inicia AfterTest");
    }
    @AfterSuite
    public void AfterSuit(){
        System.out.println("Aqui se inicia AfterSuit");
    }



    @AfterGroups
    public void AfterGroups(){
        System.out.println("Aqui se inicia AfterGroups");
    }
    @BeforeGroups
    public void BeforeGroups(){
        System.out.println("Aqui se inicia BeforeGroups");
    }




}
