import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcPanel extends JPanel implements ActionListener {
   JTextField DisplayField;
   JPanel panel1 ;
    JButton clearbutton;



    public CalcPanel(){


        //Methods for defining the textfield for displaying data
        DisplayField = new JTextField();
        DisplayField.setBounds(3,4,340,50);
        DisplayField.setBackground(Color.LIGHT_GRAY);
        DisplayField.setEditable(false);
        DisplayField.setFont(new Font("verdana",Font.BOLD,15));


//These are the methods for initializing and formatting the clear button
        clearbutton  = new JButton("Clear");
        clearbutton.setBounds(268,45,75,20);
        clearbutton.setBackground(Color.blue);
        clearbutton.setForeground(Color.green);
        clearbutton.addActionListener(this);
        clearbutton.setFocusable(false);
        clearbutton.setFont(new Font("mv boli",Font.BOLD,15));




        this.add(clearbutton);
        this.add(DisplayField);
        this.setPreferredSize(new Dimension(350,500));
        this.setLayout(null);
        this.setBackground(Color.DARK_GRAY);



        panel1 = new JPanel();

        //This block of code defines and initializes a String array that will hold all the labels of the calculator buttons ,
        //excluding the clear button
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };


        //This is a for loop used to add the buttons on panel1 and then add panel1 to the main calculator panel
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFocusable(false);
            String text = button.getActionCommand();


            if(text=="."||text=="="||text=="+"||text=="/"||text=="*"||text=="-"){

                //This if block is for defining the font color for calculator buttons with sign labels
                button.setForeground(Color.RED);
                button.addActionListener(this);

            }else{

                //The else block below is for defining the font color for the calculator buttons with numbered labels
                button.setBackground(Color.black);
                button.setForeground(Color.green);
                button.setFont(new Font("mv boli",Font.PLAIN,20));
                button.addActionListener(this);
            }

            panel1.add(button);//Adding each button to panel1


        }//End of the for loop





       panel1.setLayout(new GridLayout(4, 4));   //setting the Layout manager for the panel
       panel1.setBounds(5,65,340,450);   //setting the location of panel1 on the main panel and defining its size
       panel1.setBackground(Color.black);

        this.add(panel1);                     //Adding panel1 to the main calculator panel


    }//End of the CalcPanel constructor


    //This method reads the content of the Display Text field and passes it as a string argument to the Calculate() method
    private void fieldReader() {
        String expression = DisplayField.getText();
        try {

            double result = Calculate(expression);

          DisplayField.setText("Answer = "+Double.toString(result));
        } catch (NumberFormatException | ArithmeticException ex) {
           DisplayField.setText("Error");
        }
    }

    //The calculate method below splits the string passed to it by the fieldReader method and converts into operands and operator for calculation
    //It also does the calculation with respect to the operator and returns the results
    private double Calculate(String exp) {
       String  txt = exp;
        double  second = 0;
        double  first = 0;
        double result=1;
       String[]tokens = txt.split("(?<=[-+*/])|(?=[-+*/])"); //splitting the string into operators and operands
        first = Double.parseDouble(tokens[0]);                     //assigning the first token to the first operand
        second = Double.parseDouble(tokens[2]);                     //assigning the second token to the second operand
        char operator  = tokens[1].charAt(0);                       //extracting the operator

switch(operator) {
    case '+':
    result = first + second;
    break;
    case '-':
         result = first - second;
         break;
    case '*':
        result = first*second;
        break;
    case '/':
        result = first/second;
        break;
    default:
        break;


}//End of the switch statement
        return result;
    }



    public void actionPerformed(ActionEvent e){

   if(!(e.getActionCommand().equals("="))){
       //This block of code triggers the calculation to be performed after the '=' button is pressed
            JButton clickedButton = (JButton) e.getSource();
            String buttonText = clickedButton.getText();
            String fieldText = buttonText;
            DisplayField.setText(DisplayField.getText() + buttonText);
        }else{
    fieldReader();

        }

   //if statement for clearing the Display text field after the clear button is clicked
   if(e.getSource()==clearbutton){
    DisplayField.setText("");
}




        }

}//End of the CalcPanel Class


