package junit5tests;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.MethodName.class)//MethodOrderer.DisplayName.class, MethodOrderer.Random.class
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderTestClass1 {
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
    @Test
    //@Order(1) <- order method to run @Order(int)
    @DisplayName("Third test method")
    void thirdMethod(){
        System.out.println("Third test method");
    }

}
