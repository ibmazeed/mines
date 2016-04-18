package minesweeper;

import org.apache.log4j.*;
import org.apache.log4j.PropertyConfigurator;


public class Main {
     
     
     public static void main(String[] args) {
         Logger logger = Logger.getLogger("Main");
         PropertyConfigurator.configure("src/minesweeper/log4j.properties");
//Frame mineSweeper = new Frame();
        //mineSweeper.showIt();
        logger.info("Start app");
        lang Lang = new lang();
        
        
    }

}
