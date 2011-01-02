import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.EventObject;

public class Fibo extends Applet implements ActionListener
{
	private Button okButton;
	private TextField inputField;
    private Label outputLabel;
	
	public void init()
	{
		setLayout(null);
		okButton = new Button("find out");
		inputField = new TextField("index no.",100);
        outputLabel = new Label("feibonaqi");

		inputField.setBounds(20,20,100,40);
		outputLabel.setBounds(20,70,100,40);
		okButton.setBounds(20,120,100,30);
        okButton.addActionListener(this);
	
		add(inputField);
        add(outputLabel);
		add(okButton);
	}

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == okButton) {
            String index = inputField.getText();
            int i,fiNum;
            try {
                i = Integer.parseInt(index);
                fiNum = Fibonacci.getFibonacci(i);
            }
            catch (Exception e) {
                outputLabel.setText("Error");
                return;
            }
            outputLabel.setText("" + fiNum);
        }
    }
	
}

class Fibonacci {
    public static int getFibonacci(int n) throws Exception {
        int i = 3;
        int x = 1;
        int y = 1;
        int ans = 1;
        if(n <= 0) {
            throw new Exception();
        }
        if(n == 1 || n == 2) {
            return ans;
        }
        while(i++ <= n) {
            if(x > y) {
                y = x+y;
                ans = y;
            }
            else {
                x = x+y;
                ans = x;
            }
        }
        return ans;
    }
}
