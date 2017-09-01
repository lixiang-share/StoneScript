package stone;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import stone.entity.Token;
import stone.exception.ParseException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		System.out.println(Lexer.patLexer);
		File file = new File("Res/TestScript.txt");
		Lexer lexer = new Lexer(new FileReader(file));
		Token t = null;
		while((t = lexer.read()) != Token.EOF){
			System.out.println(t.getText());
		}
	}

}
