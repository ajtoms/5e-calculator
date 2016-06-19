package ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import datalookup.CRList;

/**
 *
 * @author Andrew J Toms II
 */
public class CRPanel extends JPanel 
{

    private String crValue;
    
    private JPanel containerUI;
    private JButton addButton;
    private JLabel crLabel;
    private JTextField numField;
    private JButton subButton;
    
    public CRPanel(String crValue)
    {
        this.crValue = crValue;
        crLabel = new JLabel(crValue);
        
        numField = new JTextField("0");
        numField.setEditable(false);
        addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int currNum = Integer.parseInt(numField.getText());
                numField.setText(String.format("%d", ++currNum));
            }
        });
        subButton = new JButton("-");
        subButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int currNum = Integer.parseInt(numField.getText());
                if(currNum > 0)
                    numField.setText(String.format("%d", --currNum));
            }
        });
        
        setLayout(new GridLayout(2,1));
        
        containerUI = new JPanel();
        containerUI.setLayout(new GridLayout(1,3));
        
        containerUI.add(addButton);
        containerUI.add(numField);
        containerUI.add(subButton);
        
        add(crLabel);
        add(containerUI);
        
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    public int getNumber()
    {
        return Integer.parseInt(numField.getText());
    }
    
    public String getCR()
    {
        return crValue;
    }
    
}
