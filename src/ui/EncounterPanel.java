package ui;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import datalookup.CRList;
import datalookup.ExperienceByCR;
import datalookup.ModifierByMonsterNumber;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;

/**
 *
 * @author Andrew J Toms II
 */
public class EncounterPanel extends JPanel
{
 
    private final String difficultyPrefix = "Encounter Difficulty:\n";
    private final String awardedPrefix = "EXP to Award:\n";
    private final String modifiedPrefix = "Modified EXP:\n";
    
    private JButton calculateButton;
    private JLabel difficultyLabel;
    private JLabel awardedEXP;
    private JLabel modifiedEXP;
    private CRPanel[] allCRPanels = new CRPanel[CRList.allCR.length];
    PartyPanel party = new PartyPanel();
    
    public EncounterPanel()
    {
        super();
        
        setLayout(new BorderLayout());
        
        JPanel crInventory = new JPanel();
        crInventory.setLayout(new GridLayout(11,3));
        for(int i = 0; i < allCRPanels.length; i++)
        {
            allCRPanels[i] = new CRPanel(CRList.crAtIndex(i));
            crInventory.add(allCRPanels[i]);
        }
        
        JPanel results = new JPanel();
        results.setLayout(new BorderLayout());
        JPanel resultsInner = new JPanel();
        resultsInner.setLayout(new BoxLayout(resultsInner, BoxLayout.PAGE_AXIS));
        difficultyLabel = new JLabel(difficultyPrefix);
        awardedEXP = new JLabel(awardedPrefix);
        modifiedEXP = new JLabel(modifiedPrefix);
        resultsInner.add(difficultyLabel);
        resultsInner.add(awardedEXP);
        resultsInner.add(modifiedEXP);
        results.add(resultsInner, BorderLayout.CENTER);
        results.add(new JPanel(), BorderLayout.WEST);
        results.add(new JPanel(), BorderLayout.EAST);
        
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                
                int totalEXP = 0;
                int totalMonsters = 0;
                for(CRPanel crp : allCRPanels)
                {
                    totalMonsters += crp.getNumber();
                    totalEXP += ExperienceByCR.forCR(crp.getCR())*crp.getNumber();
                }
                
                int modExp = (int)(totalEXP*ModifierByMonsterNumber.getMultiplier(totalMonsters, party.getPartySize()));
                int[] thresholds = party.getExpThresholds();
                if(modExp > thresholds[3])
                {
                    difficultyLabel.setText(difficultyPrefix + "Deadly");
                } 
                else if(modExp > thresholds[2])
                {
                    difficultyLabel.setText(difficultyPrefix + "Hard");
                } 
                else if(modExp > thresholds[1])
                {
                    difficultyLabel.setText(difficultyPrefix + "Medium");
                } 
                else if(modExp > thresholds[0])
                {
                    difficultyLabel.setText(difficultyPrefix + "Easy");
                } 
                else 
                {
                    difficultyLabel.setText(difficultyPrefix + "Trivial");
                }
                
                
                awardedEXP.setText(awardedPrefix + totalEXP);
                modifiedEXP.setText(modifiedPrefix + modExp);
            }
        });

        add(crInventory, BorderLayout.CENTER);
        add(results, BorderLayout.EAST);
        add(party, BorderLayout.WEST);
        add(calculateButton, BorderLayout.SOUTH);
    }
    
}
