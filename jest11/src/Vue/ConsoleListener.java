package Vue;
import java.util.HashMap;
import java.util.Scanner;

public class ConsoleListener {
    HashMap<String, Action> answers = new HashMap<String, ConsoleListener.Action>();
    Scanner scanner;
    Action defaultAction;
    volatile boolean cancelled=false;
    /**
     * Add an action for a message.
     * @param message
     * message A string trimed. Ignore case. It has no inner space sequence of two spaces or more.Example:"close connection"
     * @param action 
     * The method action.act() will be called when scanner get the message.
     */
    public void addAction(String message, Action action) {
        answers.put(message.toLowerCase(), action);
    }

    /**
     * Controler par entrer les commandes en ligne
     * @param scanner 
     * Usually new Scanner(System.in). Will not be closed after listening.
     * @param defaultAction 
     * The defaultAction.act() method will be called if an action is not added for a message.
     */
    public ConsoleListener(Scanner scanner, Action defaultAction) {
        this.scanner = scanner;
        this.defaultAction = defaultAction;
        if (scanner == null || defaultAction == null) {
            throw new NullPointerException("null params for ConsoleListener");
        }
    }

    /**
     * retirer l'action
     * @param message
     * la message
     * @param action
     * l'action a retirer
     */
    public void removeAction(String message, Action action) {
        answers.remove(message, action);
    }

    /**
     * remplacer l'action 
     * @param message
     * la message
     * @param action
     * l'action a remplacer
     * @return answers.replace(message, action);
     * l'action remplace l'action précédent
     */
    public Action replaceAction(String message, Action action) {
        return answers.replace(message, action);
    }

    /**
     * nouvel Thread pour ecouter
     */
    public void listenInNewThread() {
        Thread t = new Thread() {
            public void run() {
            	while (!cancelled) {
            		listen();
            	}
            }
        };
        t.start();
    }
    
    /**
     * Use listenInNewThread() instead.
     * Listen to console input in current thread. It blocks the thread.
     */
    public void listen() {
        while (true) {
            String line = scanner.nextLine();
            String msg = line.replaceAll("[\\s]+", " ");
            msg = msg.trim().toLowerCase();
            Action action = answers.get(msg);
            if (action == null) {
                action = defaultAction;
            }
            action.act(line);
        }
    }
    
    /**
     * setter le cancelled false
     */
    public void cancel() {
    	this.cancelled=false;
    }
    
    /**
     * ecouter l'action sur le clavier
     */
    public static interface Action {
        public void act(String msg);
    }
} 

