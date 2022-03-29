package junit5tests;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstTestClass {
//    accessModifier returnType nameOfMethod(params)

    @BeforeAll
    void beforeAll(){
        System.out.println("Before all method");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Before each method");
    }

    @AfterAll
    void afterAll(){
        System.out.println("After all method");
    }

    @AfterEach
    void afterEach(){
        System.out.println("After each method");
    }

    @Test
    @DisplayName("First test method")
    void firstMethod(){
        System.out.println("First test method");
    }
    @Test
    @DisplayName("Second test method")
    void secondMethod(){
        System.out.println("Second test method");
    }

}
