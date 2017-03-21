
package fshare.files_scheduler;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.lang.Object;
public class scheduler extends JFrame{
    private static JPanel center;
    private static JPanel btnPanel;
    public scheduler(){
        createWindow();
        createIcon("schedulerImages/ftp_icon.png");
        navigationPanel();
        mainPanel();
        createJTable();
        createButtonsPanel();
        addNavsToButtonPanel("Add Folder","addFile","Ok");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt){
                formWindowClosing(evt);
            }
});
    }
    public void formWindowClosing(WindowEvent evt){
        int dialog = JOptionPane.showConfirmDialog
        (this,"Close this Window","fShare",JOptionPane.YES_NO_OPTION);
        if(dialog ==JOptionPane.YES_OPTION){
           Runtime.getRuntime().exit(0);
        }else
            return;
    }
    private void createWindow(){
        setLayout(null);
        setSize(800,700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(102,225,225));
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("fShare");
    }
    private void createIcon(String imagePath){
         setIconImage
        (
                 Toolkit.getDefaultToolkit()
                .getImage(getClass()
                .getResource(imagePath))
         );
    }
    private void navigationPanel(){
        JPanel nav = new JPanel();
        nav.setLayout(null);
        nav.setBounds(0,0,getWidth(),40);
        nav.setBackground(new Color(160,160,160));
        add(nav);
        
    }
    public void  mainPanel(){
        center = new JPanel();
        center.setLayout(null);
        center.setBounds(0,41,getWidth()-200,getHeight()-150);
        center.setBackground(new Color(255,255,255));
        add(center); 
    }
    public  void createJTable() {
        JTable table = new JTable();
        table.setColumnSelectionAllowed(true);
        table.setAutoCreateRowSorter(true);
        table.setBackground(new Color(255,255,255));
        table.setLayout(null);
        table.setModel(new DefaultTableModel(
        new Object [][]{
                {null, null, null},
                {null, null, null}
                
        },        
                new String []{
                    "Directory","Name","Size"
                }
        ));
        JScrollPane pane = new JScrollPane();
        pane.setBounds(5,10,590,530);       
        pane.setViewportView(table);
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        center.add(pane);
    }
    private void createButtonsPanel(){
        btnPanel = new JPanel();
        btnPanel.setLayout(null);
        btnPanel.setBounds(601,41,191,550);
        btnPanel.setBackground(new Color(255,229,204));
        add(btnPanel);
    }
    private void addNavsToButtonPanel(String folder , String file, String ok){
        JButton addFolder = new JButton(folder);        
        addFolder.setBackground(new Color(0,0,204));
        addFolder.setForeground(new Color(255,255,0));
        addFolder.setBounds(20,20,150,30);
        addFolder.setToolTipText("Add multiple files at once.");
        btnPanel.add(addFolder);
        
        JButton addFile = new JButton(file);        
        addFile.setBackground(new Color(0,0,204));
        addFile.setForeground(new Color(255,255,0));
        addFile.setBounds(20,90,150,30);
        addFile.setToolTipText("Add one file at a time.");
        btnPanel.add(addFile);
        
        JButton okay = new JButton(ok);        
        okay.setBackground(new Color(0,0,204));
        okay.setForeground(new Color(255,255,0));
        okay.setBounds(20,160,150,30);
        okay.setToolTipText("Click to start sharing with your friend.");
        btnPanel.add(okay);
        
    }
    public static void main(String [] args){
        UIManager.put("OptionPane.background",new Color(255,255,0));
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                new scheduler();
            }
        });
    }

    
}
