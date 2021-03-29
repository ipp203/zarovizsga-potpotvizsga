package hu.nive.ujratervezes.zarovizsga.countchars;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DaVinciCode {
    private List<Character> chars = Arrays.asList('0', '1', 'x');

    public int encode(String filepath, char findChar) {
        inputValidator(filepath, findChar);
        Path path = Path.of(filepath);
        try (Stream<String> stream = Files.lines(path)) {

//            return (int) stream
//                    .flatMapToInt(String::chars)
//                    .filter(c -> c == (int) findChar)
//                    .count();

            return (int) stream
                    .map(String::toCharArray)
                    .map(this::charArrayToCharacterArray)
                    .flatMap(Arrays::stream)
                    .filter(c -> c == findChar)
                    .count();


//        try (BufferedReader br = Files.newBufferedReader(path)) {
//            return processLines(findChar, br);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file " + filepath, ioe);
        }
    }

    private Character[] charArrayToCharacterArray(char[] chars){
        Character[] result= new Character[chars.length];
        int i = 0;
        for (char c:chars ) {
            result[i]=c;
            i++;
        }
        return result;
    }

    private int processLines(char findChar, BufferedReader br) throws IOException {
        int counter = 0;
        String line;
        while ((line = br.readLine()) != null) {
            for (char c : line.toCharArray()) {
                if (c == findChar) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private void inputValidator(String filepath, char findChar) {
        if (filepath == null || filepath.isBlank()) {
            throw new IllegalArgumentException("FilePath is null or emprty");
        }
        if (!chars.contains(findChar)) {
            throw new IllegalArgumentException("FindChar must be '0' or '1' or 'x', but was " + findChar);
        }
    }
}
