package fragment.submissions;

import fragment.submissions.reassemble.Reassemble;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Marcin Panfil on 26.02.17.
 */
public class MarcinPanfil {

    public static void main(String[] args) throws IOException {
        Reassemble reassemble = new Reassemble();
        try (BufferedReader in = new BufferedReader(new FileReader(args[0]))) {
            in.lines()
                    .map(reassemble::reassemble)
                    .forEach(System.out::println);
        }
    }

}
