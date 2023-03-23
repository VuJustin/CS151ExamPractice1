package mvc;

import tools.SafeFrame;
import tools.Utilities;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * This is the MVC controller.
    - AppPanel is missing implementation of PropertyChangeListener
    * What do we include in propertyChange method? Revalidate()? repaint()?
 */

public class AppPanel extends JPanel implements ActionListener, PropertyChangeListener {
    protected Model model;
    protected JPanel controlPanel;
    private View view;
    private AppFactory appFactory;
    private SafeFrame frame;
    private static int WIDTH = 600;
    private static int HEIGHT = 362;

    public AppPanel(AppFactory factory) {
        appFactory = factory;
        // create model, install controls & view
        model = appFactory.makeModel();
        model.addPropertyChangeListener(this);
        // Setting the name of model
        view = appFactory.makeView(model);
        view.setBackground(Color.GRAY);
        // Control Panel created
        controlPanel = new JPanel();
        controlPanel.setBackground(Color.PINK);
        controlPanel.setLayout((new GridLayout (4,2)));
        // Setting layout to have controlPanel & View
        setLayout((new GridLayout(1,2)));
        add(controlPanel);
        add(view);
        // create my frame with menus and display it
        frame = new SafeFrame();
        frame.setTitle(appFactory.getTitle());
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(this.createMenuBar());
        frame.setSize(WIDTH, HEIGHT);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[] { "New", "Save", "Save As", "Open", "Quit" }, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", appFactory.getEditCommands(), this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[] { "About", "Help" }, this);
        result.add(helpMenu);
        return result;
    }

    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        try {

            // How to execute other commands?
            switch (cmmd) {
                case "Save": {
                    save();
                    break;
                }

                case "Save As": {
                    saveAs();
                    break;
                }

                case "Open": {

                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!")) {
                        String fName = Utilities.getFileName((String) null, true);
                        ObjectInputStream is = new ObjectInputStream(new FileInputStream(fName));
                        model = (Model) is.readObject();
                        // need View class to be done
                        view.setModel(model);
                        is.close();

                    }

                    break;

                }

                case "New": {
                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!")) {
                        model = appFactory.makeModel();
                        view.setModel(model);
                    }
                    break;
                }

                case "Quit": {
                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!"))
                        System.exit(0);
                    break;
                }

                case "About": {
                    Utilities.inform(appFactory.about());
                    break;
                }

                case "Help": {
                    String[] cmmds = appFactory.getHelp();
                    Utilities.inform(cmmds);
                    break;

                }
                default: {
                    // throw new Exception("Unrecognized command: " + cmmd);
                    Command command = appFactory.makeEditCommand(model, cmmd, this);
                    command.execute();
                }
            }

        } catch (Exception ex) {
            handleException(ex);
        }

    }

    protected void handleException(Exception e) {
        Utilities.error(e);
    }

    private void saveAs() throws Exception {
        String fName = Utilities.getFileName((String) null, false);
        this.model.setFileName(fName);
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
        os.writeObject(this.model);
        os.close();
    }

    private void save() throws Exception {

        if (model.getFileName() == null) {
            saveAs();
        } else {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(model.getFileName()));
            os.writeObject(model);
            os.close();
        }
    }

    public void display() {
        frame.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        revalidate();
    }
}
