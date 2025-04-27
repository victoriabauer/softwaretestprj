import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class PrinttokensTest {

    @org.junit.jupiter.api.Test
    void open_character_stream() {

    }

    @org.junit.jupiter.api.Test
    void get_char() {
    }

    @org.junit.jupiter.api.Test
    void unget_char() {
        Printtokens t = new Printtokens();
        assertEquals(0,t.unget_char(97,t.open_token_stream(null)));
    }

    @org.junit.jupiter.api.Test
    void open_token_stream_txtfile() throws FileNotFoundException {
        Printtokens t = new Printtokens();
        assertNotNull(t.open_token_stream("testfile1.txt"),"BufferedReader should not be null");
    }

    @org.junit.jupiter.api.Test
    void open_token_stream_nullfile() throws FileNotFoundException {
        Printtokens t = new Printtokens();
        assertNotNull(t.open_token_stream(null),"BufferedReader should not be null");
    }

    @org.junit.jupiter.api.Test
    void get_token() {
        //complicated method 5
    }

    @org.junit.jupiter.api.Test
    void is_token_end() {
    }

    @org.junit.jupiter.api.Test
    void token_type_keyword() {
        String tok = "and";
        assertEquals(1,Printtokens.token_type(tok));
    }
    @org.junit.jupiter.api.Test
    void token_type_spec_symbol() {
        String tok = "(";
        assertEquals(2,Printtokens.token_type(tok));
    }
    @org.junit.jupiter.api.Test
    void token_type_identifier() {
        String tok = "aa";
        assertEquals(3,Printtokens.token_type(tok));
    }
    @org.junit.jupiter.api.Test
    void token_type_num_constant() {
        String tok = "123";
        assertEquals(41,Printtokens.token_type(tok));
    }
    @org.junit.jupiter.api.Test
    void token_type_str_constant() {
        String tok = "\"a3\"";
        assertEquals(42,Printtokens.token_type(tok));
    }
    @org.junit.jupiter.api.Test
    void token_type_char_constant() {
        String tok = "#a";
        assertEquals(43,Printtokens.token_type(tok));
    }
    @org.junit.jupiter.api.Test
    void token_type_comment() {
        String tok = ";test";
        assertEquals(5,Printtokens.token_type(tok));
    }
    @org.junit.jupiter.api.Test
    void token_type_error() {
        String tok = null;
        assertEquals(0,Printtokens.token_type(tok));
    }

    @org.junit.jupiter.api.Test
    void print_token_error() {
        String tok = null;
        Printtokens t = new Printtokens();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        t.print_token(tok);
        assertEquals("error,\"" + tok + "\".\n", outContent.toString());
        System.setOut(System.out); //clears system.out
    }
    @org.junit.jupiter.api.Test
    void print_token_keyword() {
        String tok = "and";
        Printtokens t = new Printtokens();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        t.print_token(tok);
        assertEquals("keyword,\"" + tok + "\".\n", outContent.toString());
        System.setOut(System.out); //clears system.out
    }
    @org.junit.jupiter.api.Test
    void print_token_spec_symbol() {
        String tok = "(";
        Printtokens t = new Printtokens();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        t.print_token(tok);
        assertEquals("lparen.\n", outContent.toString());
        System.setOut(System.out); //clears system.out
    }
    @org.junit.jupiter.api.Test
    void print_token_identifier() {
        String tok = "aa";
        Printtokens t = new Printtokens();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        t.print_token(tok);
        assertEquals("identifier,\"" + tok + "\".\n", outContent.toString());
        System.setOut(System.out); //clears system.out
    }
    @org.junit.jupiter.api.Test
    void print_token_num_constant() {
        String tok = "123";
        Printtokens t = new Printtokens();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        t.print_token(tok);
        assertEquals("numeric," + tok + ".\n", outContent.toString());
        System.setOut(System.out); //clears system.out
    }
    @org.junit.jupiter.api.Test
    void print_token_str_constant() {
        String tok = "\"a3\"";
        Printtokens t = new Printtokens();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        t.print_token(tok);
        assertEquals("string," + tok + ".\n", outContent.toString());
        System.setOut(System.out); //clears system.out
    }
    @org.junit.jupiter.api.Test
    void print_token_char_constant() {
        String tok = "#a";
        Printtokens t = new Printtokens();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        t.print_token(tok);
        assertEquals("character,\"" + tok.charAt(1) + "\".\n", outContent.toString());
        System.setOut(System.out); //clears system.out
    }
    @org.junit.jupiter.api.Test
    void print_token_comment() {
        String tok = ";test";
        Printtokens t = new Printtokens();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        t.print_token(tok);
        assertEquals("comment,\"" + tok + "\".\n", outContent.toString());
        System.setOut(System.out); //clears system.out

    }

    @org.junit.jupiter.api.Test
    void is_comment_true() {
        assertTrue(Printtokens.is_comment(";test"));
    }
    @org.junit.jupiter.api.Test
    void is_comment_false() {
        assertFalse(Printtokens.is_comment("test"));
    }

    @org.junit.jupiter.api.Test
    void is_keyword_true() {
        assertTrue(Printtokens.is_keyword("and"));
    }
    @org.junit.jupiter.api.Test
    void is_keyword_false() {
        assertFalse(Printtokens.is_keyword("test"));
    }

    @org.junit.jupiter.api.Test
    void is_char_constant_true() {
        assertTrue(Printtokens.is_keyword("#a"));
    }
    @org.junit.jupiter.api.Test
    void is_char_constant_false() {
        assertFalse(Printtokens.is_keyword("#3"));
    }

    @org.junit.jupiter.api.Test
    void is_num_constant() {
    }

    @org.junit.jupiter.api.Test
    void is_str_constant() {
    }

    @org.junit.jupiter.api.Test
    void is_identifier() {
    }

    @org.junit.jupiter.api.Test
    void print_spec_symbol() {
    }

    @org.junit.jupiter.api.Test
    void is_spec_symbol() {
    }

    @org.junit.jupiter.api.Test
    void main_test() {
    }
}