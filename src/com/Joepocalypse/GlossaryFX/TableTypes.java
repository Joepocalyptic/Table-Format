package com.Joepocalypse.GlossaryFX;


import java.util.Arrays;
import java.util.regex.PatternSyntaxException;

public class TableTypes {

    public static String tableGen(final String separator, final Tag tableTag, final Tag rowTag, final Tag dataTag, String input, boolean t){
        String tableTagOpen = tableTag.getOpenTag();
        String tableTagClose = tableTag.getCloseTag();

        String rowTagOpen = rowTag.getOpenTag();
        String rowTagClose = rowTag.getCloseTag();

        String dataTagOpen = dataTag.getOpenTag();
        String dataTagClose = dataTag.getCloseTag();

        try {
            StringBuilder table = new StringBuilder();
            String[] lines = input.split("\n");
            if (t) {
                table.append(tableTagOpen);
            }
            Arrays.stream(lines).forEach(line -> {
                if ("".equals(line)) {
                    return;
                }
                table.append(rowTagOpen);
                String[] arr = line.split(separator);
                int[] ct = new int[1];
                ct[0] = 1;
                Arrays.stream(arr).forEach(data -> {
                    if (!"".equals(data)) {
                        table.append(dataTagOpen);
                        table.append(data);
                        table.append(ct[0]);
                        table.append(dataTagClose);
                        ct[0] = ct[0] + 1;
                    }
                });
                table.append(rowTagClose);
            });
            if (t) {
                table.append(tableTagClose);
            }
            return table.toString();
        } catch(PatternSyntaxException e) {

            return "Error! Please use a valid separator with valid input text.";

        }
    }

    public static String compactBBTable(final String separator, String input, boolean t) {
        return tableGen(separator,
                new Tag("[table]", "[/table]"),
                new Tag("[tr]", "[/tr]"),
                new Tag("[td]", "[/td]"),
                input,
                t);
    }

    public static String aestheticBBTable (final String separator, String input, boolean t){
        return tableGen(separator,
                new Tag("[table]\n", "[/table]\n"),
                new Tag("[tr]\n", "[/tr]\n"),
                new Tag("[td]", "[/td]\n"),
                input,
                t);
    }

    public static String compactHTMLTable(final String separator, String input, boolean t) {
        return tableGen(separator,
                new Tag("<table>", "</table>"),
                new Tag("<tr>", "</tr>"),
                new Tag("<tr>", "</td>"),
                input,
                t);
    }
    public static String aestheticHTMLTable (final String separator, String input, boolean t) {
        return tableGen(separator,
                new Tag("<table>\n", "</table>\n"),
                new Tag("<tr>\n", "</tr>\n"),
                new Tag("<td>", "</td>\n"),
                input,
                t);
    }
}
