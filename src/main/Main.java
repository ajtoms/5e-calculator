package main;

import javax.swing.SwingUtilities;
import ui.MainFrame;

/**
 *
 * @author Andrew J Toms II
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String txt = "";
//        do
//        {
//            System.out.print("(1) Index from String\n(2) String from Index\nChoose: ");
//            txt = in.nextLine();
//            try
//            {
//                int choice = Integer.parseInt(txt);
//                switch(choice)
//                {
//                    case 1:
//                        System.out.print("\nString? ");
//                        System.out.println(CRList.indexFromString(in.nextLine()));
//                        break;
//                    case 2:
//                        System.out.print("\nIndex? ");
//                        int index = in.nextInt(); in.nextLine();
//                        System.out.println(CRList.crAtIndex(index));
//                        break;
//                    default:
//                        throw new Exception();
//                }
//            } catch (Exception ex)
//            {
//                System.out.println("\nYou suck.");
//            }
//            
//        } while(!txt.equals("exit"));
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                MainFrame mf = new MainFrame();
            }
        });
    }

}
