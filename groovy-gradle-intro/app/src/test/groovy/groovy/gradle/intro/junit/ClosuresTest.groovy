
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClosuresTest {


    @Test
    public void addClosure(){
        // types are optional
        Closure add = { addend, augend -> return addend + augend };
        assertEquals(5, add(2,3));
    }

    @Test
    public void defaultParameter(){
        // basically a function that returns the argument you pass in
        Closure identity = {return it};
        assertEquals(5, identity(5));
    }
    

    class Inner {
        Closure parentClosure = {
            Closure retrieveOwner = {
                return owner;
            }
            return retrieveOwner();
        }
    }

    // owner very similar to "this" in Java. It returns the direct enclosing object
    // Could be nested closure, inner class, outer class etc.
    @Test
    public void ownerInClosure(){
        Inner inner = new Inner();
        assertEquals(inner.parentClosure, inner.parentClosure())
    }


    class Mustang {
        String name = "mustang";
    }

    class Corvette {
        String name = "corvette";
    }

    @Test
    public void changeClosureDelegate(){
        
        Closure getName = {getName()};
        getName.delegate = new Mustang();

        assertEquals("mustang", getName());
        getName.delegate = new Corvette();
        assertEquals("corvette", getName());

    }
}