import functions.*;

public class Main {
 public static void main(String[] args) throws FunctionPointIndexOutOfBoundsException, InappropriateFunctionPointException, IllegalArgumentException {
        //f(x) = x^2 на интервале [0, 4]
        double[] values = {1, 3, 4, 9, 16};

    System.out.println("Использование ArrayTabulatedFunction:");

        TabulatedFunction function = new ArrayTabulatedFunction(0, 4, values);
        
        System.out.println("Исходная функция:");
        printFunctionInfo(function);
        
        
        System.out.println("\nЗначения функции в различных точках:");
        testFuncVal(function);
        
        
        System.out.println("\nПосле изменения точек:");
        test(function);
        
        
        System.out.println("\nПосле добавления и удаления точек:");
        testAddDel(function);

    System.out.println("Использование LinkenListTabulatedFunction:");

    TabulatedFunction linkfunction = new LinkedListTabulatedFunction(0, 4, values);

    System.out.println("Исходная функция:");
        printFunctionInfo(linkfunction);
        
        
        System.out.println("\nЗначения функции в различных точках:");
        testFuncVal(linkfunction);
        
        
        System.out.println("\nПосле изменения точек:");
        test(linkfunction);
        
        
        System.out.println("\nПосле добавления и удаления точек:");
        testAddDel(linkfunction);

    System.out.println("Использование LinkenListTabulatedFunction:");
    }
    
    private static void printFunctionInfo(TabulatedFunction function) {
        System.out.printf("Область определения: [%.1f, %.1f]\n", 
            function.getLeftDomainBorder(), function.getRightDomainBorder());
        System.out.println("Количество точек: " + function.getPointsCount());
        
        for (int i = 0; i < function.getPointsCount(); i++) {
            FunctionPoint point = function.getPoint(i);
            System.out.printf("Точка %d: (%.1f, %.1f)\n", i, point.getX(), point.getY());
        }
    }
    
    private static void testFuncVal(TabulatedFunction function) {
             double x = 3.3;
        double y = function.getFunctionValue(x);
        System.out.println("Значение функции X = " + x + " Y = " + y);
    }
    
    private static void test(TabulatedFunction function) {
        
        function.setPointY(3, 8);
        System.out.println("После изменения y в точке 3 на 8.0:");
        printFunctionInfo(function);
        
        
        try { 
            function.setPointX(3, 3.5);
        } catch (InappropriateFunctionPointException mes) {  
            System.out.println("\nОшибка при измненени точки :"+ mes.getMessage()); 
        }
        System.out.println("После изменения x в точке 3 на 3.5:");
        printFunctionInfo(function);
    }
    
    private static void testAddDel(TabulatedFunction function) {

        try { 
            function.addPoint(new FunctionPoint(3, 3.5));
        } catch (InappropriateFunctionPointException mes) {  
            System.out.println("\nОшибка при измненени точки :"+ mes.getMessage()); 
        }
        System.out.println("После добавления x в точке 3 на 3.5:");
        printFunctionInfo(function);

        try { 
            function.deletePoint(3);
        } catch (InappropriateFunctionPointException mes) {  
            System.out.println("После удаления точки с индексом 3:"+ mes.getMessage()); 
        }
        System.out.println("После удаления точки с индексом 3:");
        printFunctionInfo(function);
    }
}