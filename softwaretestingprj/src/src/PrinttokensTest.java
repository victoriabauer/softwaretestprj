import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class PrinttokensTest {

    @org.junit.jupiter.api.Test
    void open_character_stream() {
        Printtokens pt = new Printtokens();
        BufferedReader br = pt.open_character_stream("testfile1.txt");
        assertNotNull(br, "BufferedReader should not be null when input is null");

    }

    @org.junit.jupiter.api.Test
    void get_char() {
        Printtokens pt = new Printtokens();
        BufferedReader br = new BufferedReader(new StringReader("testing"));
        assertEquals('t', pt.get_char(br), "Should return the first character 't'");
        assertEquals('e', pt.get_char(br), "Should return the second character 'e'");
        assertEquals('s', pt.get_char(br), "Should return the third character 's'");
        assertEquals('t', pt.get_char(br), "Should return the fourth character 't'");
        assertEquals('i', pt.get_char(br), "Should return the second character 'i'");
        assertEquals('n', pt.get_char(br), "Should return the third character 'n'");
        assertEquals('g', pt.get_char(br), "Should return the fourth character 'g'");
        assertEquals(-1, pt.get_char(br), "Should return -1 for EOF");

    }

    @org.junit.jupiter.api.Test
    void unget_char() {
        Printtokens t = new Printtokens();
        assertEquals(0,t.unget_char(97,t.open_token_stream(null)));
    }

    @org.junit.jupiter.api.Test
    void open_token_stream_txtfile() throws FileNotFoundException {
        Printtokens t = new Printtokens();
        assertNotNull(t.open_token_stream("softwaretestingprj/Resources/testfile1.txt"),"BufferedReader should not be null");
    }

    @org.junit.jupiter.api.Test
    void open_token_stream_nullfile() throws FileNotFoundException {
        Printtokens t = new Printtokens();
        assertNotNull(t.open_token_stream(null),"BufferedReader should not be null");
    }

    @org.junit.jupiter.api.Test
    void get_token_emptyfile() {
        Printtokens t = new Printtokens();
        BufferedReader br = t.open_token_stream("softwaretestingprj/Resources/gettoktest1.txt");	/* open token stream */
        assertNull(t.get_token(br));

    }
    @org.junit.jupiter.api.Test
    void get_token_newline_empty() {
        Printtokens t = new Printtokens();
        BufferedReader br = t.open_token_stream("softwaretestingprj/Resources/gettoktest2.txt");	/* open token stream */
        assertNull(t.get_token(br));

    }
    @org.junit.jupiter.api.Test
    void get_token_lpren() {
        Printtokens t = new Printtokens();
        BufferedReader br = t.open_token_stream("softwaretestingprj/Resources/gettoktest3.txt");	/* open token stream */
        assertEquals("(",t.get_token(br));

    }
    @org.junit.jupiter.api.Test
    void get_token_one_letter() {
        Printtokens t = new Printtokens();
        BufferedReader br = t.open_token_stream("softwaretestingprj/Resources/gettoktest4.txt");	/* open token stream */
        assertEquals("a",t.get_token(br));

    }
    @org.junit.jupiter.api.Test
    void get_token_and_plain() {
        Printtokens t = new Printtokens();
        BufferedReader br = t.open_token_stream("softwaretestingprj/Resources/gettoktest5.txt");	/* open token stream */
        assertEquals("and",t.get_token(br));

    }
    @org.junit.jupiter.api.Test
    void get_token_and_rpren() {
        Printtokens t = new Printtokens();
        BufferedReader br = t.open_token_stream("softwaretestingprj/Resources/gettoktest6.txt");	/* open token stream */
        assertEquals("and)",t.get_token(br));

    }
    @org.junit.jupiter.api.Test
    void get_token_and_beginquote() {
        Printtokens t = new Printtokens();
        BufferedReader br = t.open_token_stream("softwaretestingprj/Resources/gettoktest7.txt");	/* open token stream */
        assertEquals("\"and",t.get_token(br));

    }
    @org.junit.jupiter.api.Test
    void get_token_string() {
        Printtokens t = new Printtokens();
        BufferedReader br = t.open_token_stream("softwaretestingprj/Resources/gettoktest8.txt");	/* open token stream */
        assertEquals("\"and\"",t.get_token(br));

    }
    @org.junit.jupiter.api.Test
    void get_token_and_endcolon() {
        Printtokens t = new Printtokens();
        BufferedReader br = t.open_token_stream("softwaretestingprj/Resources/gettoktest9.txt");	/* open token stream */
        assertEquals("and;",t.get_token(br));

    }
    @org.junit.jupiter.api.Test
    void get_token_comment() {
        Printtokens t = new Printtokens();
        BufferedReader br = t.open_token_stream("softwaretestingprj/Resources/gettoktest10.txt");	/* open token stream */
        assertEquals(";and",t.get_token(br));

    }

    @org.junit.jupiter.api.Test
    void is_token_end_eof() {
        int str_com_id = 1;
        int res = -1;
        assertTrue(Printtokens.is_token_end(str_com_id,res));
    }
    @org.junit.jupiter.api.Test
    void is_token_end_stspace() {
        int str_com_id = 0;
        char c = '\t';
        int res = (int)c;
        assertTrue(Printtokens.is_token_end(str_com_id,res));
    }
    @org.junit.jupiter.api.Test
    void is_token_end_sfspace() {
        int str_com_id = 1;
        int res = 97;
        assertFalse(Printtokens.is_token_end(str_com_id,res));
    }
    @org.junit.jupiter.api.Test
    void is_token_end_ctspace() {
        int str_com_id = 2;
        char c = '\n';
        int res = (int)c;
        assertTrue(Printtokens.is_token_end(str_com_id,res));
    }
    @org.junit.jupiter.api.Test
    void is_token_end_cfspace() {
        int str_com_id = 2;
        int res = 97;
        assertFalse(Printtokens.is_token_end(str_com_id,res));
    }
    @org.junit.jupiter.api.Test
    void is_token_end_spec_symbol() {
        int str_com_id = 0;
        int res = 40;
        assertTrue(Printtokens.is_token_end(str_com_id,res));
    }
    @org.junit.jupiter.api.Test
    void is_token_end_space59() {
        int str_com_id = 0;
        int res = 59;
        assertTrue(Printtokens.is_token_end(str_com_id,res));
    }
    @org.junit.jupiter.api.Test
    void is_token_end_returnfalse() {
        int str_com_id = 0;
        int res = 97;
        assertFalse(Printtokens.is_token_end(str_com_id,res));
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
        String str2 = "#ab";
        String str3 = "123";
        String str4 = "1a3";

        assertFalse(Printtokens.is_num_constant(str2));
        assertTrue(Printtokens.is_num_constant(str3));
        assertFalse(Printtokens.is_num_constant(str4));
        assertFalse(Printtokens.is_num_constant(null));
    }

    @org.junit.jupiter.api.Test
    void is_str_constant() {
        String str1 = "abs";
        String str2 = "\"\"";
        String str3 = "\"The fox\"";
        String str4 = "\"No quotes on the right";
        String str5 = ",";
        assertFalse(Printtokens.is_str_constant(str1));
        assertTrue(Printtokens.is_str_constant(str2));
        assertTrue(Printtokens.is_str_constant(str3));
        assertFalse(Printtokens.is_str_constant(str4));
        assertFalse(Printtokens.is_str_constant(str5));
    }

    @org.junit.jupiter.api.Test
    void is_identifier() {
        assertTrue(Printtokens.is_identifier("a"), "'a' should be an identifier");
        assertTrue(Printtokens.is_identifier("a"), "'a' should be an identifier");
        assertFalse(Printtokens.is_identifier("#ab"), "'#ab' should be an identifier");
        assertFalse(Printtokens.is_identifier("#ab"), "'#ab' should be an identifier");
        assertFalse(Printtokens.is_identifier(null), "'null' should not be an identifier");
    }

    @org.junit.jupiter.api.Test
    void print_spec_symbol() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Printtokens.print_spec_symbol("(");
        assertEquals("lparen.\n", outContent.toString());
        outContent.reset();

        Printtokens.print_spec_symbol(")");
        assertEquals("rparen.\n", outContent.toString());
        outContent.reset();

        Printtokens.print_spec_symbol("[");
        assertEquals("lsquare.\n", outContent.toString());
        outContent.reset();

        Printtokens.print_spec_symbol("]");
        assertEquals("rsquare.\n", outContent.toString());
        outContent.reset();

        Printtokens.print_spec_symbol("'");
        assertEquals("quote.\n", outContent.toString());
        outContent.reset();

        Printtokens.print_spec_symbol("`");
        assertEquals("bquote.\n", outContent.toString());
        outContent.reset();

        Printtokens.print_spec_symbol(",");
        assertEquals("comma.\n", outContent.toString());

        System.setOut(System.out);
    }

    @org.junit.jupiter.api.Test
    void is_spec_symbol() {
        assertTrue(Printtokens.is_spec_symbol('('), " '(' should be a special symbol");
        assertTrue(Printtokens.is_spec_symbol(')'), " ')' should be a special symbol");
        assertTrue(Printtokens.is_spec_symbol('['), " '[' should be a special symbol");
        assertTrue(Printtokens.is_spec_symbol(']'), " ']' should be a special symbol");
        assertTrue(Printtokens.is_spec_symbol('/'), " '/' should be a special symbol");
        assertTrue(Printtokens.is_spec_symbol('`'), " '`' should be a special symbol");
        assertTrue(Printtokens.is_spec_symbol(','), " ',' should be a special symbol");
        assertFalse(Printtokens.is_spec_symbol('#'), " '#' should not be a special symbol");
    }
    /*
    @org.junit.jupiter.api.Test
    void main_test() {

        PrintStream initialOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Printtokens.main(new String[]{});
        assertTrue(outContent.toString().contains("BufferedReader should not be null"));
        outContent.reset();

        Printtokens.main(new String[]{"a"});
        assertTrue(outContent.toString().contains("BufferedReader should not be null"));
        outContent.reset();


        Printtokens.main(new String[]{""});
        assertTrue(outContent.toString().contains("BufferedReader should not be null"));
        outContent.reset();


        Printtokens.main(new String[]{"testfile1.java"});
        assertTrue(outContent.toString().contains("BufferedReader should not be null"));

        System.setOut(initialOut);
    }

     */
}