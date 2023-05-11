import javax.swing.*;

import java.awt.Cursor;
import java.awt.event.*;
@SuppressWarnings("serial")
public class RotateButton  extends JButton implements ActionListener {
    protected JPanel drawingPanel;
    protected View view;
    private MouseHandler mouseHandler;
    private RotateCommand rotateCommand;
    private UndoManager undoManager;
    public RotateButton(UndoManager undoManager, View jFrame, JPanel jPanel) {
        super("Rotate");
        addActionListener(this);
        view = jFrame;
        drawingPanel = jPanel;
        this.undoManager = undoManager;
        mouseHandler = new MouseHandler();
    }
    public void actionPerformed(ActionEvent event) {
        rotateCommand = new RotateCommand();
        view.refresh();
        drawingPanel.addMouseListener(mouseHandler);
        undoManager.beginCommand(rotateCommand);
    }
    private class MouseHandler extends MouseAdapter {
    	//at current mouse location
        public void mouseClicked(MouseEvent event) {
            if (rotateCommand.setPoint(View.mapPoint(event.getPoint())))
     	   {
     		drawingPanel.removeMouseListener(this);
     		undoManager.endCommand(rotateCommand);
                rotateCommand.rotate(View.mapPoint(event.getPoint()));
                rotateCommand.rotate(View.mapPoint(event.getPoint()));
                drawingPanel.removeMouseListener(this);
     	   }
     		else {
     		undoManager.cancelCommand();
            }
        
        }
    }
}
    
