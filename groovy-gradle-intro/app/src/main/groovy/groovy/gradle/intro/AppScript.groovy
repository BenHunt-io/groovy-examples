import java.util.stream.*;


/**
 * This script gets converted into a class with a main method. 
 * args is the argument to the main method.
 *
*/

println("Hello ${Stream.of(args)
    .collect(Collectors.joining(', '))}");