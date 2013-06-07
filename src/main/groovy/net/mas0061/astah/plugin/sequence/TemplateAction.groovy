package net.mas0061.astah.plugin.sequence;


import javax.swing.JOptionPane

import com.change_vision.jude.api.inf.AstahAPI
import com.change_vision.jude.api.inf.exception.ProjectNotFoundException
import com.change_vision.jude.api.inf.ui.IPluginActionDelegate
import com.change_vision.jude.api.inf.ui.IWindow
import com.change_vision.jude.api.inf.ui.IPluginActionDelegate.UnExpectedException

class TemplateAction implements IPluginActionDelegate {

  def run(IWindow window) {
      try {
        def projectAccessor = AstahAPI.getAstahAPI().getProjectAccessor();
        projectAccessor.getProject();
        JOptionPane.showMessageDialog(window.getParent(),"Hello");
      } catch (ProjectNotFoundException e) {
        def message = "Project is not opened.Please open the project or create new project.";
        JOptionPane.showMessageDialog(window.getParent(), message, "Warning", JOptionPane.WARNING_MESSAGE);
      } catch (Exception e) {
        JOptionPane.showMessageDialog(window.getParent(), "Unexpected error has occurred.", "Alert", JOptionPane.ERROR_MESSAGE);
        throw new UnExpectedException();
      }
  }


}
