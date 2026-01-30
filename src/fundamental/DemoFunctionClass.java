package fundamental;

public class DemoFunctionClass {

    public static void main(String[] args) {
        InterfaceDemo demo = () -> {
            System.out.println("Hello");
        };

      demo.show();

    }


}
