package customException;

public class DataStructuresExeption extends Exception{

    public DataStructuresExeption(String message){
        super(message);
    }

    public DataStructuresExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
