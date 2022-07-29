
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JavaDifferencesTest {

    // Is not package private
    String testField = "testAutomaticGetter"

    // {} are reserved for groovy closures
    @Test
    public void arrayInitializers(){
        int[] nums = [1,2,3,4,5];
        assertArrayEquals((int[]) [1,2,3,4,5], nums);
    }


    // Groovy has getters/setters built in
    @Test
    public void packageScopeVisibility(){
        assertEquals("testAutomaticGetter", getTestField());
    }

    @Test
    public void armBlocks(){
        ArrayList<String> lines = new ArrayList<>();
        new File(getClass().getClassLoader().getResource("sample-data.txt").getFile()).eachLine('UTF-8') {
            lines.add(it);
        }

        assertEquals(List.of("The brown fox.", "The yellow cat."), lines);
    }

    @Test
    public void lamdaExpression(){
        // Runnable run = () -> System.out.println("Run");  // Java
        Runnable run = {println 'run'};
    }

    @Test
    public void methodReference(){
        var list = List.of(1,2,3);
        var result = new ArrayList<Integer>();
        list.each {result.add(it)}

        assertEquals(List.of(1,2,3), result);
    }

    @Test
    public void gStrings(){
        assertTrue(GString.class.isAssignableFrom("c${1}".getClass()));
    }

    @Test
    public void equality(){
        assertTrue(List.of(1,2) == List.of(1,2));
    }

}