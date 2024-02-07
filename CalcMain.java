import javax.swing.*;

public class CalcMain extends JFrame {
    public CalcMain(){

        //methods for initializing the JFrame where the CalcPanel will be displayed
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Java Calculator");
        this.add(new CalcPanel());
        this.pack();
        this.setVisible(true);
        this.setResizable(false);


    }//End of constructor

    public static void main (String[]args){

        new CalcMain();
    }
}
