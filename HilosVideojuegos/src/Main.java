public class Main {
    public static void main(String[] args) {

        for (int i = 0;i <= (Runtime.getRuntime().availableProcessors()*2);i++){
            Thread h1 = new Thread(new IA(i));
            h1.start();
            try{
                h1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Acabao");
    }
}
