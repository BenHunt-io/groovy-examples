import groovy.util.Eval;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.time.*;

public class GroovyIntegrations {

    @Test
    void executeGroovyDynamically(){

        assertEquals('DYNAMICALLY EXECUTED GROOVY SCRIPT',
            Eval.me('"dynamically executed groovy script".toUpperCase()'));
    }

    @Test
    void shareDataBetweenScriptAndApplication(){
        var sharedData = new Binding();
        var shell = new GroovyShell(sharedData);

        sharedData.setProperty("token", "SKJDJ512A");
        sharedData.setProperty("year", 2022);


        var result = shell.evaluate('"Token: $token, Year: ${year}"');
        
        assertEquals("Token: SKJDJ512A, Year: 2022", result.toString());

    }
    
}
