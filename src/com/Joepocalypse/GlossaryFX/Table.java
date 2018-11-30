package com.Joepocalypse.GlossaryFX;

import java.util.Arrays;

public enum Table {
    HTML(
            "<table>", "</table>",
            "<tr>", "</tr>",
            "<td>", "</td>"
    ),
    BBCODE(
            "[table]", "[/table]",
            "[tr]", "[/tr]",
            "[td]", "[/td]"
    );

    private final String tableOpen, tableClose, rowOpen, rowClose, dataOpen, dataClose;
    Table(
            String tableOpen, String tableClose,
            String rowOpen, String rowClose,
            String dataOpen, String dataClose
    ){
        this.tableOpen = tableOpen;
        this.tableClose = tableClose;
        this.rowOpen = rowOpen;
        this.rowClose = rowClose;
        this.dataOpen = dataOpen;
        this.dataClose = dataClose;
    }

    public final String generate(String separator, String input, boolean pretty){
        final StringBuilder builder = new StringBuilder();
        final String[] lines = input.split("\n");
        builder.append(tableOpen);
        if (pretty){
            builder.append("\n");
        }
        Arrays.stream(lines)
                .filter(line -> !line.isEmpty())
                .forEach(line -> {
                    if (pretty){
                        builder.append("\t");
                    }
                    builder.append(rowOpen);
                    if (pretty){
                        builder.append("\n");
                    }
                    final String[] datas = line.split(separator);
                    Arrays.stream(datas)
                            .filter(data -> !data.isEmpty())
                            .forEach(data -> {
                                if (pretty){
                                    builder.append("\t\t");
                                }
                                builder.append(dataOpen);
                                builder.append(data);
                                builder.append(dataClose);
                                if (pretty){
                                    builder.append("\n");
                                }
                            });
                    if (pretty){
                        builder.append("\t");
                    }
                    builder.append(rowClose);
                    if (pretty){
                        builder.append("\n");
                    }
                });
        builder.append(tableClose);
        return builder.toString();
    }

    public final String generate(String separator, String input){
        return generate(separator, input, false);
    }

    public static Table fromString(String in){
        final String checkStr = in.toUpperCase();
        return Arrays.stream(Table.values()).filter(val -> checkStr.equals(val.name())).findFirst().orElse(null);
    }
}
