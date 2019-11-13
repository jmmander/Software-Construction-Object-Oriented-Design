package filters.test;

import filters.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test the parser.
 */
public class TestParser {
    @Test
    public void testBasic() throws SyntaxError {
        Filter f = new Parser("trump").parse();
        assertTrue(f instanceof BasicFilter);
        assertTrue(((BasicFilter) f).getWord().equals("trump"));
    }

    @Test
    public void testHairy() throws SyntaxError {
        Filter x = new Parser("trump and (evil or blue) and red or green and not not purple").parse();
        assertTrue(x.toString().equals("(((trump and (evil or blue)) and red) or (green and not not purple))"));
    }


    @Test
    public void testOrAnd() throws SyntaxError {
        Filter r = new Parser("elephants and dogs or cats").parse();
        assertTrue(r.toString().equals("((elephants and dogs) or cats)"));
    }

    @Test
    public void testOrNot() throws SyntaxError {
        Filter k = new Parser("elephants or not dogs").parse();
        assertTrue(k.toString().equals("(elephants or not dogs)"));
    }

    @Test
    public void testAndNot() throws SyntaxError {
        Filter p = new Parser("elephants and not dogs").parse();
        assertTrue(p.toString().equals("(elephants and not dogs)"));
    }

    @Test
    public void testOrAndNot() throws SyntaxError {
        Filter e = new Parser("elephants and not dogs or not cats and mice").parse();
        assertTrue(e.toString().equals("((elephants and not dogs) or (not cats and mice))"));
        Filter o = new Parser("(elephants and dogs) or yellow and purple").parse();
        assertEquals("((elephants and dogs) or (yellow and purple))", o.toString());
    }
}

