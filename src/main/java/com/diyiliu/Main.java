package com.diyiliu;

import org.apache.commons.cli.*;

import java.util.Date;

/**
 * Description: Main
 * Author: DIYILIU
 * Update: 2016-01-05 11:25
 */
public class Main {
    public static void main(String[] args) {
        try {
            // ①  创建一个Options：
            Options options = new Options();
            options.addOption("h", false, "help");
            options.addOption("t", false, "current time");
            options.addOption("w", "welcome", true, "first meet");

            // ② 创建一个解析器，分析输入：
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd;

            for (String arg : args) {
                System.out.println(arg);
            }

            cmd = parser.parse(options, new String[]{"-h"});

            // ③ 最后就可以根据用户的输入，采取相应的操作：
            if (cmd.hasOption("t")) {

                System.out.println("current time: " + new Date());
            }

            if (cmd.hasOption("w")) {
                System.out.println("Nice to meet you: " +
                        cmd.getOptionValue('w'));
            }

            if (cmd.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("help", options);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
