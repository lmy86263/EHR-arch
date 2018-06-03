package com.zju.edu;

import com.zju.edu.config.PersistenceConfig;
import org.apache.commons.cli.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;


public class PersistenceApp {
    private AnnotationConfigApplicationContext context;

    public PersistenceApp(){
        //
    }

    public static void main( String[] args ) {
        new PersistenceApp().start(args);
    }

    private void start(String[] args){
        Options options = new Options();

        Option help = Option.builder("h").longOpt("help").desc("show help information").build();
        Option adlFile = Option.builder("adl").desc("specify the adl file used to persistence").hasArg().build();
        Option destination = Option.builder("d").longOpt("destination").desc("specify the persistence solutions about the archetypes").hasArg().build();
        Option version = Option.builder("v").longOpt("version").desc("specify the version of the tool").build();

        options.addOption( help );
        options.addOption( adlFile );
        options.addOption( destination );
        options.addOption( version );

        HelpFormatter formatter = new HelpFormatter();
        if (args == null || args.length == 0){
            formatter.printHelp( "persist.sh", options);
            return;
        }

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse( options, args);
            if(cmd.hasOption("h")) {
                formatter.printHelp( "persist.sh", options);
            } else if (cmd.hasOption("v")) {
                InputStream is = this.getClass().getClassLoader().getResourceAsStream("application.properties");
                Properties properties = new Properties();
                properties.load(is);
                System.out.println(properties.getProperty("persistence.version"));
            } else if (cmd.hasOption("adl")){
                // initialize the environment
                init();
                // -------------------
                String adlPath = cmd.getOptionValue("adl");
                byte[] adlBytes = Files.readAllBytes(Paths.get(adlPath));
                String adlContent = new String(adlBytes, StandardCharsets.UTF_8);
                if(cmd.hasOption("d")) {
                    // specify the destination
                    String dest = cmd.getOptionValue("d");

                } else {
                    // use default mode: mysql or postgresql, to be determined

                }

            } else {
                formatter.printHelp( "persist.sh", options);
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }


    private void init(){
        context = new AnnotationConfigApplicationContext();
        context.register(PersistenceConfig.class);
        context.refresh();
    }

}
