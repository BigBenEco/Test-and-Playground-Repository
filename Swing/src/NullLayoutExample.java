import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class NullLayoutExample

{
   private JFrame app;
   private JPanel mainPanel;
   private JMenuBar jb;
   private JLabel first, last;
   private JTextField tfFirst, tfLast;
   private JCheckBox cosmo, cpu, si;
   private JRadioButton male, female;
   private ButtonGroup gender;
   
   NullLayoutExample()
   {
       app = new JFrame("Ind/Bus app");
       //Setting up the windowListener
       app.addWindowListener(new WindowAdapter(){
         public void windowClosing(WindowEvent ev)
         {
            System.out.println("goodbye");
            System.exit(0);
          }
         });  
       mainPanel = new JPanel();
       jb = setupMenuBar();
       setupMenuBar();
       app.setJMenuBar(jb);
       setupIndividual();
       app.getContentPane().add(mainPanel, BorderLayout.CENTER);
       app.setSize(640,480);
       app.setVisible(true);
    }
    private JMenuBar setupMenuBar()
    {
       JMenuBar subBar = new JMenuBar();
       JMenu menu = new JMenu("Topic");
       JMenuItem iBus = new JMenuItem("Business");
       JMenuItem iInd = new JMenuItem ("Individual");
       iInd.addActionListener(new myHandler());
       iBus.addActionListener(new myHandler());
       menu.add(iBus);
       menu.add(iInd);
       subBar.add(menu);
       return subBar;
    }
    
    private void setupIndividual()
    {
      mainPanel.setLayout(null);
      
      first = new JLabel("First");
      last = new JLabel("Last");
      tfFirst = new JTextField(); 
      tfLast = new JTextField();
      //first row
      first.setBounds(20, 10, 30, 20);
      tfFirst.setBounds(55, 10, 60,  20);
      //second row
      last.setBounds(20, 35, 30, 20);
      tfLast.setBounds(55, 35, 60, 20);
      //create the radio buttons and then put them together in a group
      //third row
      male = new JRadioButton("Male"); 
      male.setBounds( 20, 60,60, 20);
      female = new JRadioButton("Female");
      female.setBounds(55, 60, 60, 20);
      gender = new ButtonGroup();
      gender.add(male);
      gender.add(female);
       //fourth row
      //Create the check boxes
      cosmo= new JCheckBox("Cosmopolitan");
      cpu = new JCheckBox("CPU"); 
      si = new JCheckBox("Sports Illustrated");
       cosmo.setBounds(20, 95, 60, 20);
       cpu.setBounds(85, 95, 60, 20);
       si.setBounds(150, 95, 60, 20);
      //add everything to the main panel
      mainPanel.add(first);
      mainPanel.add(tfFirst);
      mainPanel.add(last);
      mainPanel.add(tfLast);
      mainPanel.add(male);
      mainPanel.add(female);
      mainPanel.add(cosmo);
      mainPanel.add(cpu);
      mainPanel.add(si);
    }
    private void setupBusiness(){}
    private void clear(){}
class myHandler implements ActionListener
{
              public void actionPerformed(ActionEvent e)
              {
                 String same = e.getActionCommand();
                 if(same.equals("Individual"))
                 {
                    clear();
                    setupIndividual();
                 }
                 else if(same.equals("Business"))
                 {
                    clear();
                    setupBusiness();
                 }
                 
              }
}

    public static void main(String [] args)
    {
       NullLayoutExample today = new NullLayoutExample();
       
    }
}
