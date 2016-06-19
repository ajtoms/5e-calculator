package ui;

import datalookup.ExperienceThresholds;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Andrew J Toms II
 */
public class PartyPanel extends JPanel{

    private int numPartyRows = 1;
    private Stack<PartyRow> allPartyRows = new Stack<>();
    
    JPanel partyListPanel;
    
    public PartyPanel()
    {
        super();
        
        partyListPanel = new JPanel();
        partyListPanel.setLayout(new BoxLayout(partyListPanel, BoxLayout.PAGE_AXIS));
        PartyRow pr = new PartyRow();
        allPartyRows.add(pr);
        partyListPanel.add(pr);
        
        JButton addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                PartyRow pr = new PartyRow();
                allPartyRows.add(pr);
                partyListPanel.add(pr);
                partyListPanel.revalidate();
            }
        });
        JButton subButton = new JButton("-");
        subButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(allPartyRows.size() > 1)
                {
                    PartyRow pr = allPartyRows.pop();
                    partyListPanel.remove(pr);
                    partyListPanel.revalidate();
                }
            }
        });
        
        
        JPanel buttonPositioner = new JPanel();
        buttonPositioner.setLayout(new GridLayout(1,5));
        buttonPositioner.add(addButton);
        buttonPositioner.add(subButton);
        for(int i = 0; i < 3; i++){
            buttonPositioner.add(new JPanel());
        }
        
        setLayout(new BorderLayout());
        add(partyListPanel, BorderLayout.CENTER);
        add(buttonPositioner, BorderLayout.NORTH);
    }
    
    public int[] getExpThresholds()
    {
        int[] finalThresholds = new int[]{0,0,0,0};
        for(PartyRow pr : allPartyRows)
        {
            finalThresholds[0] += ExperienceThresholds.forLevel(pr.getLevelOf())[0] * pr.getNumOf();
            finalThresholds[1] += ExperienceThresholds.forLevel(pr.getLevelOf())[1] * pr.getNumOf();
            finalThresholds[2] += ExperienceThresholds.forLevel(pr.getLevelOf())[2] * pr.getNumOf();
            finalThresholds[3] += ExperienceThresholds.forLevel(pr.getLevelOf())[3] * pr.getNumOf();
        }
        return finalThresholds;
    }
    
    public int getPartySize()
    {
        int total = 0;
        for(PartyRow pr: allPartyRows)
        {
            total += pr.getNumOf();
        }
        return total;
    }
    
    private class PartyRow extends JPanel
    {
        JTextField numOf = new JTextField("0");
        JTextField levelOf = new JTextField("0");
        
        public PartyRow()
        {
            super();
            setLayout(new GridLayout(1,2));
            add(numOf);
            add(levelOf);
        }
        
        public int getNumOf()
        {
            return Integer.parseInt(numOf.getText());
        }
        
        public int getLevelOf()
        {
            return Integer.parseInt(levelOf.getText());
        }
        
    }
    
}
