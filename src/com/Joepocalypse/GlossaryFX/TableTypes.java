package com.Joepocalypse.GlossaryFX;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class TableTypes {

    public static String compactBBTable(final String separator, String input, boolean t) {
        try {
            if (t == false) {
                StringBuilder table = new StringBuilder();
                String[] lines = input.split("\n");
                Arrays.stream(lines).forEach(line -> {
                    if ("".equals(line)) {
                        return;
                    }
                    table.append("[tr]");
                    String[] arr = line.split(separator);
                    Arrays.stream(arr).forEach(row -> {
                        if (!"".equals(row)) {
                            table.append("[td]");
                            table.append(row);
                            table.append("[/td]");
                        }
                    });
                    table.append("[/tr]");
                });
                return table.toString();
            } else if (t) {
                StringBuilder table2 = new StringBuilder();
                String[] lines = input.split("\n");
                table2.append("[table]");
                Arrays.stream(lines).forEach(line -> {
                    if ("".equals(line)) {
                        return;
                    }
                    table2.append("[tr]");
                    String[] arr = line.split(separator);
                    Arrays.stream(arr).forEach(row -> {
                        if (!"".equals(row)) {
                            table2.append("[td]");
                            table2.append(row);
                            table2.append("[/td]");
                        }
                    });

                    table2.append("[/tr]");
                });
                table2.append("[/table]");
                return table2.toString();

            }
            return "Error!";
        } catch (PatternSyntaxException e) {
            return "Error! Please use a valid separator with valid input text.";
        }
    }
    public static String aestheticBBTable (final String separator, String input, boolean t){
        try {
            if (t == false) {
                StringBuilder table = new StringBuilder();
                String[] lines = input.split("\n");
                Arrays.stream(lines).forEach(line -> {
                    if ("".equals(line)) {
                        return;
                    }
                    table.append("[tr]").append("\n");
                    String[] arr = line.split(separator);
                    Arrays.stream(arr).forEach(row -> {
                        if (!"".equals(row)) {
                            table.append("    ").append("[td]");
                            table.append(row);
                            table.append("[/td]").append("\n");
                        }
                    });

                    table.append("[/tr]").append("\n");
                });
                return table.toString();
            } else if (t) {
                StringBuilder table2 = new StringBuilder();
                String[] lines = input.split("\n");
                table2.append("[table]").append("\n");
                Arrays.stream(lines).forEach(line -> {
                    if ("".equals(line)) {
                        return;
                    }
                    table2.append("[tr]").append("\n");
                    String[] arr = line.split(separator);
                    Arrays.stream(arr).forEach(row -> {
                        if (!"".equals(row)) {
                            table2.append("    ").append("[td]");
                            table2.append(row);
                            table2.append("[/td]").append("\n");
                        }
                    });

                    table2.append("[/tr]").append("\n");
                });
                table2.append("[/table]").append("\n");
                return table2.toString();
            }
            return "Error!";
        } catch(PatternSyntaxException e) {
            return "Error! Please use a valid separator with valid input text.";
        }
    }
    public static String compactHTMLTable(final String separator, String input, boolean t) {
        try {
            if (t == false) {
                StringBuilder table = new StringBuilder();
                String[] lines = input.split("\n");
                Arrays.stream(lines).forEach(line -> {
                    if ("".equals(line)) {
                        return;
                    }
                    table.append("<tr>");
                    String[] arr = line.split(separator);
                    Arrays.stream(arr).forEach(row -> {
                        if (!"".equals(row)) {
                            table.append("<td>");
                            table.append(row);
                            table.append("</td>");
                        }
                    });
                    table.append("</tr>");
                });
                return table.toString();
            } else if (t) {
                StringBuilder table2 = new StringBuilder();
                String[] lines = input.split("\n");
                table2.append("<table>");
                Arrays.stream(lines).forEach(line -> {
                    if ("".equals(line)) {
                        return;
                    }
                    table2.append("<tr>");
                    String[] arr = line.split(separator);
                    Arrays.stream(arr).forEach(row -> {
                        if (!"".equals(row)) {
                            table2.append("<td>");
                            table2.append(row);
                            table2.append("</td>");
                        }
                    });
                    table2.append("</tr>");
                });
                table2.append("</table>");
                return table2.toString();

            }
            return "Error!";
        } catch(PatternSyntaxException e) {

            return "Error! Please use a valid separator with valid input text.";

        }
    }
    public static String aestheticHTMLTable (final String separator, String input, boolean t) {
        try {
            if (t == false) {
                StringBuilder table = new StringBuilder();
                String[] lines = input.split("\n");
                Arrays.stream(lines).forEach(line -> {
                    if ("".equals(line)) {
                        return;
                    }
                    table.append("<tr>").append("\n");
                    String[] arr = line.split(separator);
                    Arrays.stream(arr).forEach(row -> {
                        if (!"".equals(row)) {
                            table.append("    ").append("<td>");
                            table.append(row);
                            table.append("</td>").append("\n");
                        }
                    });

                    table.append("</tr>").append("\n");
                });
                return table.toString();
            } else if (t) {
                StringBuilder table2 = new StringBuilder();
                String[] lines = input.split("\n");
                table2.append("<table>").append("\n");
                Arrays.stream(lines).forEach(line -> {
                    if ("".equals(line)) {
                        return;
                    }
                    table2.append("<tr>").append("\n");
                    String[] arr = line.split(separator);
                    Arrays.stream(arr).forEach(row -> {
                        if (!"".equals(row)) {
                            table2.append("    ").append("<td>");
                            table2.append(row);
                            table2.append("</td>").append("\n");
                        }
                    });

                    table2.append("</tr>").append("\n");
                });
                table2.append("</table>").append("\n");
                return table2.toString();
            }
            return "Error!";
        } catch (PatternSyntaxException e) {

            return "Error! Please use a valid separator with valid input text.";

        }
    }
}
