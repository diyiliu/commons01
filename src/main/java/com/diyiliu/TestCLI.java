package com.diyiliu;

import org.apache.commons.cli.*;

import java.util.Date;
import java.util.Scanner;

/**
 * Description: TestCLI
 * Author: DIYILIU
 * Update: 2015-09-25 9:33
 */
public class TestCLI extends Thread {

    @Override
    public void run() {
        // ①  创建一个Options：
        Options options = new Options();
        // 简写，全名，是否需要参数，描述。
        options.addOption("h", false, "help information");
        options.addOption("t", false, "current time");
        options.addOption("w", "welcome", true, "first meet");

        // ② 创建一个解析器，分析输入：
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        for (; ; ) {
            try {
                Scanner scanner = new Scanner(System.in);

                String in = scanner.nextLine();
                //System.out.println("CMD:" + in);

                cmd = parser.parse(options, new String[]{in});

                // ③ 最后就可以根据用户的输入，采取相应的操作：
                if (cmd.hasOption("h")) {

                    HelpFormatter formatter = new HelpFormatter();
                    formatter.printHelp("help", options);
                } else if (cmd.hasOption("t")) {

                    System.out.println("current time: " + new Date());
                } else if (cmd.hasOption("w")) {

                    System.out.println("Nice to meet you: " + cmd.getOptionValue('w'));
                } else {

                    HelpFormatter formatter = new HelpFormatter();
                    formatter.printHelp("cmd error", options);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        new TestCLI().start();
    }
}
