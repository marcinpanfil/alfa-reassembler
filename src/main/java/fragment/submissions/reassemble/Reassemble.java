package fragment.submissions.reassemble;

/**
 * Created by Marcin Panfil on 26.02.17.
 */
public class Reassemble {

    public static final String SEMICOLON = ";";
    public static final String BLANK = "";

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
        int overlap = 0;
        for (int i = 0; i < fragments.length - 1; i++) {
            for (int j = i + 1; j < fragments.length; j++) {
                String overlapStr = getOverlapFragment(fragments[i], fragments[j]);
                if (overlap < overlapStr.length()) {
                    firstStringIndex = i;
                    secondStringIndex = j;
                    overlap = overlapStr.length();
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
        if (secondString.startsWith(overlapFragment)) {
            mergeStr = firstString + secondString.replaceAll(overlapFragment, BLANK);
        } else {
            mergeStr = secondString.replace(overlapFragment, BLANK) + firstString;
        }
        return mergeStr;
    }

    private String getOverlapFragment(String firstString, String secondString) {
        String overlapStr = BLANK;
        for (int i = 0; i < secondString.length(); i++) {
            String beginning = secondString.substring(0, i);
            String ending = secondString.substring(i);
            if (firstString.contains(beginning)) {
                if (overlapStr.length() < i) {
                    overlapStr = beginning;
                }
            }
            if (firstString.contains(ending)) {
                if (overlapStr.length() < secondString.length() - i) {
                    overlapStr = ending;
                }
            }
        }
        return overlapStr;
    }
}
