package com.teamTitan.app;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class App 
{
    private static final Logger LOGGER = Logger.getLogger(App.class);
    public static void main( String[] args )
    {
        BasicConfigurator.configure();
        LOGGER.error( "Hello World!" );
    }
}
//test