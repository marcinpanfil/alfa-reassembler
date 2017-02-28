package fragment.submissions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Marcin Panfil on 26.02.17.
 */
public class MarcinPanfil {

    public static void main(String[] args) throws IOException {
        Reassemble reassemble = new MarcinPanfil.Reassemble();
        try (BufferedReader in = new BufferedReader(new FileReader(args[0]))) {
            in.lines()
                    .map(reassemble::reassemble)
                    .forEach(System.out::println);
        }
    }

    private static class Reassemble {

        private static final String SEMICOLON = ";";
        private static final String BLANK = "";

        public String reassemble(String line) {
            while (line.contains(SEMICOLON)) {
                line = findTwoBestFragmentsAndMergedThem(line);
            }
            return line;
        }

        private String findTwoBestFragmentsAndMergedThem(String line) {
            String[] fragments = line.split(SEMICOLON);
            int firstStringIndex = -1;
            int secondStringIndex = -1;
            int overlap = -1;
            for (int i = 0; i < fragments.length - 1; i++) {
                if (overlap < fragments.length - i) {
                    for (int j = i + 1; j < fragments.length; j++) {
                        String overlapStr = getOverlapFragment(fragments[i], fragments[j]);
                        if (overlapStr.length() <= fragments[j].length()) {
                            if (overlap < overlapStr.length()) {
                                firstStringIndex = i;
                                secondStringIndex = j;
                                overlap = overlapStr.length();
                            }
                        }
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < fragments.length; i++) {
                if (i == firstStringIndex) {
                    sb.append(merge(fragments[firstStringIndex], fragments[secondStringIndex]));
                    sb.append(SEMICOLON);
                } else if (i != secondStringIndex) {
                    sb.append(fragments[i]);
                    sb.append(SEMICOLON);
                }
            }

            String newLine = sb.toString();
            if (newLine.endsWith(SEMICOLON)) {
                newLine = newLine.substring(0, newLine.lastIndexOf(SEMICOLON));
            }

            return newLine;
        }

        private String merge(String firstString, String secondString) {
            String overlapFragment = getOverlapFragment(firstString, secondString);
            String mergeStr;
            if (firstString.equals(overlapFragment)) {
                return secondString;
            } else if (secondString.equals(overlapFragment)) {
                return firstString;
            }
            if (secondString.startsWith(overlapFragment)) {
                mergeStr = firstString + replaceOnce(secondString, overlapFragment);
            } else {
                mergeStr = replaceOnce(secondString, overlapFragment) + firstString;
            }
            return mergeStr;
        }

        private String replaceOnce(String string, String overlap) {
            int end = string.indexOf(overlap, 0);
            StringBuilder sb = new StringBuilder();
            sb.append(string.substring(0, end));
            sb.append(string.substring(end + overlap.length()));
            return sb.toString();
        }

        private String getOverlapFragment(String firstString, String secondString) {
            String overlapStr = BLANK;
            overlapStr = get(firstString, secondString, overlapStr);
            if (overlapStr.length() != secondString.length()) {
                overlapStr = get(secondString, firstString, overlapStr);
            }

            return overlapStr;
        }

        private String get(String firstString, String secondString, String overlapStr) {
            for (int i = 0; i < firstString.length(); i++) {
                String beginning = firstString.substring(0, i);
                String ending = firstString.substring(i);
                if (secondString.contains(beginning)) {
                    if (overlapStr.length() < i) {
                        overlapStr = beginning;
                    }
                }
                if (secondString.contains(ending)) {
                    if (overlapStr.length() < firstString.length() - i) {
                        overlapStr = ending;
                    }
                }
            }
            return overlapStr;
        }

    }

}
