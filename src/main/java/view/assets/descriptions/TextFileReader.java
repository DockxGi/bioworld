package view.assets.descriptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Responsible for reading text files.
 */
public class TextFileReader {
    private static TextFileReader textReader;

    public static TextFileReader getInstance() {
        if (textReader == null){
            textReader = new TextFileReader();
        }
        return textReader;
    }

    private String readFromInputSteam(InputStream inputStream){
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        try (bufferedReader){
            return readLines(stringBuilder, bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String readLines(StringBuilder stringBuilder, BufferedReader bufferedReader) throws IOException {
        String textLine = bufferedReader.readLine();

        while (textLine != null){
            stringBuilder.append(textLine);
            stringBuilder.append("\n");
            textLine = bufferedReader.readLine();
        }
        return stringBuilder.toString();
    }

    public String readText(String path){
        InputStream inputStream = TextFileReader.class.getResourceAsStream(path);
        return readFromInputSteam(inputStream);
    }
}
