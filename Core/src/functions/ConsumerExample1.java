package functions;

import java.util.function.Consumer;  
public class ConsumerExample1 {
	static void printMessage(String name){  
        System.out.println("Hello "+name);  
    }  
    static void printValue(int val){  
        System.out.println(val);  
    }  
    public static void main(String[] args) {  
        // Referring method to String type Consumer interface   
        Consumer<String> consumer1 = ConsumerExample1::printMessage;  
        consumer1.accept("John");   // Calling Consumer method  
        // Referring method to Integer type Consumer interface  
        Consumer<Integer> consumer2 = ConsumerExample1::printValue;  
        consumer2.accept(12);   // Calling Consumer method  
    }  
}
