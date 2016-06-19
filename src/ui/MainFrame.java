package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Andrew J Toms II
 */
public class MainFrame extends JFrame 
{

    private JTabbedPane tabs;
    
    public MainFrame()
    {
        super("5E - Encounter Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        tabs = new JTabbedPane();
        tabs.addTab("Encounter Calculator", null, new EncounterPanel());
        tabs.addTab("Monster CR Calculator", null, new JLabel("TODO"));
        
        getContentPane().add(tabs);
        
//        setSize(960, 720);
        pack();
        setVisible(true);
    }
    
}
