import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.FileWriter;


public class GUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel label,blank1,blank2;
    private JTextArea textArea;
    //private JOptionPane input;
    private JButton button1,button2;
    private JTextField data,shift,group;
    private  static String vdata,EGdata;
    private static int vshift,vgroup;
    //private String file = "C:\\Users\\santu saha\\IdeaProjects\\Crypto\\texts\\new.txt";
    //private FileWriter fileWriter;
    private JScrollPane scroll;

    public  GUI(){
        Font  f1  = new Font(Font.MONOSPACED,  Font.BOLD, 17);
        Font  f2  = new Font(Font.MONOSPACED,  Font.BOLD, 20);
        Font  f3  = new Font(Font.SERIF,  Font.ROMAN_BASELINE, 15);

        frame= new JFrame("Crypto");
        frame.setPreferredSize(new Dimension(300, 500));
        frame.setFont(f2);



        //input=new JOptionPane();
        //String data=JOptionPane.showInputDialog("Input Data");
        //String shift=JOptionPane.showInputDialog("Input Shift Value");
        //shift=int(shift);
        //String grouping=JOptionPane.showInputDialog("Input Group Value");
        //grouping=int(grouping);

        data=new JTextField("Enter the Data to be Encrypted");
        shift=new JTextField("Enter the shift value");
        group=new JTextField("Enter the grouping value");


        data.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.removeFocusListener(this);
            }
        });


        shift.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.removeFocusListener(this);
            }
        });

        group.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.removeFocusListener(this);
            }
        });



        button1=new JButton("Generate");
        button2=new JButton("Show");
        button1.setFont(f3);
        button2.setFont(f3);
        button1.setBounds(0,0,50,30);
        button2.setBounds(0,0,50,30);


        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                vdata = data.getText();
                vshift=Integer.parseInt(shift.getText());
                vgroup=Integer.parseInt(group.getText());

                //System.out.println(vdata+vshift+vgroup);




                String Ndata=Crypto.NormalizeText(vdata);
                //System.out.println(Ndata);

                String Odata=Crypto.Obify(Ndata);
                //System.out.println(Odata);

                String Edata=Crypto.caesarify(Odata,(int)vshift);
                //System.out.println(Edata);

                EGdata=Crypto.groupify(Edata,(int)vgroup);

                //System.out.println(EGdata);


            }
        });



        blank2=new JLabel("");
        blank1=new JLabel("");
        label=new JLabel("The Encrypted Data is:");
        label.setFont(f1);

        textArea = new JTextArea();
        scroll= new JScrollPane(textArea);

        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                textArea.setText(EGdata);
                textArea.setEditable(false);



            }
        });





        panel=new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,20,10,20));
        panel.setLayout(new GridLayout(10,1));
        panel.setBackground(Color.lightGray);

        panel.add(blank2);
        panel.add(data);
        panel.add(shift);
        panel.add(group);


        panel.add(blank1);
        panel.add(label);
        panel.add(scroll);//you only need to add scroll, cuz scroll already have the textArea


        panel.add(button1);
        panel.add(button2);

        //panel.add(textArea);


        //buttonPanel.add(button1);
        //buttonPanel.add(button2);

        //panel.add(data);
        //panel.add(shift);
        //panel.add(grouping);


        frame.add(panel, BorderLayout.CENTER);
        //frame.add(button1,BorderLayout.PAGE_END);
        //frame.add(button2,BorderLayout.PAGE_END);
        //frame.add(buttonPanel,BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setTitle("Crypto");

        frame.pack();
        frame.setVisible(true);





    }
    public static void main(String[] args){
        new GUI();





    }
}
