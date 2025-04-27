import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrinttokensTest {

    @org.junit.jupiter.api.Test
    void open_character_stream() {
        Printtokens pt = new Printtokens();
        BufferedReader br = pt.open_character_stream(null);
        assertNotNull(br, "BufferedReader should not be null when input is null");
    }

    @org.junit.jupiter.api.Test
    void get_char() {
    }

    @org.junit.jupiter.api.Test
    void unget_char() {
    }

    @org.junit.jupiter.api.Test
    void open_token_stream() {
    }

    @org.junit.jupiter.api.Test
    void get_token() {
    }

    @org.junit.jupiter.api.Test
    void is_token_end() {
    }

    @org.junit.jupiter.api.Test
    void token_type() {
    }

    @org.junit.jupiter.api.Test
    void print_token() {
    }

    @org.junit.jupiter.api.Test
    void is_comment() {
    }

    @org.junit.jupiter.api.Test
    void is_keyword() {
    }

    @org.junit.jupiter.api.Test
    void is_char_constant() {
    }

    @org.junit.jupiter.api.Test
    void is_num_constant() {
        var numConstant = new Printtokens();
        String str1 = NULL;
        String str2 = '#ab';
        String str3 = '123';
        String str4 = '12a3';
        assertFalse(numConstant.is_num_constant(str1));
        assertFalse(numConstant.is_num_constant(str2));
        assertTrue(numConstant.is_num_constant(str3));
        assertFalse(numConstant.is_num_constant(str4));

    }

    @org.junit.jupiter.api.Test
    void is_str_constant() {
        var strConstant = new Printtokens();
        String str1 = 'abs';
        String str2 = '""';
        String str3 = '"The fox"';
        String str4 = '"No quotes on the right';
        String str5 = ',';
        assertFalse(strConstant.is_str_constant(str1));
        assertTrue(strConstant.is_str_constant(str2));
        assertTrue(strConstant.is_str_constant(str3));
        assertFalse(strConstant.is_str_constant(str4));
        assertFalse(strConstant.is_str_constant(str5));

    }

    @org.junit.jupiter.api.Test
    void is_identifier() {
        assertTrue(Printtokens.is_identifier("identifier"), "'identifier' should be an identifier");
        assertFalse(Printtokens.is_identifier("123"), "'123' should not be an identifier");
    }

    @org.junit.jupiter.api.Test
    void print_spec_symbol() {
        Printtokens.print_spec_symbol("(");
        Printtokens.print_spec_symbol(")");
        Printtokens.print_spec_symbol("[");
        Printtokens.print_spec_symbol("]");
        Printtokens.print_spec_symbol("'");
        Printtokens.print_spec_symbol("`");
        Printtokens.print_spec_symbol("(");
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

    @org.junit.jupiter.api.Test
    void main() {
        var main = new Printtokens();
        assertFalse(Printtokens.main(NULL), "Should print out the statement given");
        assertTrue(Printtokens.main(""), "Should exit out of the system");
        assertTrue(Printtokens.main('a'), "Should exit out of the system");
        assertTrue(Printtokens.main('#filename'), "Should exit out of the system");
    }
}