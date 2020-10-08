package cs.lab;

import java.util.logging.Logger;

public class Observer {

    static final Logger logger = Logger.getLogger(Observer.class.getName());
    
    public Observer() {}

    public void update(boolean status){
        if(status){
            logger.info("Registration complete");
        }
    }

}
