package util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TextSearchTest {

    String test;

    @Before
    public void setUp() throws Exception {
        test = "This is an example to test Boyer-Moore";
    }

    @Test
    public void booyerMoore() throws Exception {
        assertTrue(TextSearch.BooyerMoore(test, "This"));
        assertTrue(TextSearch.BooyerMoore(test, "is"));
        assertTrue(TextSearch.BooyerMoore(test, "an"));
        assertTrue(TextSearch.BooyerMoore(test, "example"));
        assertTrue(TextSearch.BooyerMoore(test, "to"));
        assertTrue(TextSearch.BooyerMoore(test, "test"));
        assertTrue(TextSearch.BooyerMoore(test, "Boyer"));
        assertTrue(TextSearch.BooyerMoore(test, "Moore"));
        assertTrue(TextSearch.BooyerMoore(test, "This is an example"));
        assertTrue(TextSearch.BooyerMoore(test, "to test Boyer-Moore"));
        assertFalse(TextSearch.BooyerMoore(test, "the"));
        assertFalse(TextSearch.BooyerMoore(test, "string"));
        assertFalse(TextSearch.BooyerMoore(test, "does"));
        assertFalse(TextSearch.BooyerMoore(test, "not"));
        assertFalse(TextSearch.BooyerMoore(test, "contain"));
        assertFalse(TextSearch.BooyerMoore(test, "these"));
    }

}