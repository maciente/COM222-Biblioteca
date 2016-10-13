package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cadastrarAssociado_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Cadastrar Associado</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h3>Dados do Associado</h3>\n");
      out.write("        <form method = \"get\" action = \"/Biblioteca/CadastrarAssociado\">\n");
      out.write("            <p>Código: <input type = \"text\" name = \"codigo\" size = \"11\"></p>\n");
      out.write("            <p>Nome: <input type = \"text\" name = \"nome\" size = \"30\"></p>\n");
      out.write("            <p>Senha: <input type = \"password\" name = \"senha\" size = \"12\"></p>\n");
      out.write("            <p>Email: <input type = \"text\" name = \"email\" size = \"40\"></p>\n");
      out.write("            <p>Endereço: <input type = \"text\" name = \"endereco\" size = \"50\"></p>\n");
      out.write("            <p>Tipo: </p>\n");
      out.write("            <p>\n");
      out.write("                <input type=\"radio\" name=\"tipo\" value=\"Grad\" checked> Aluno de graduação<br>\n");
      out.write("                <input type=\"radio\" name=\"tipo\" value=\"Posgrad\"> Aluno de pós-graduação<br>\n");
      out.write("                <input type=\"radio\" name=\"tipo\" value=\"Prof\"> professor \n");
      out.write("            </p>\n");
      out.write("            <p>\n");
      out.write("                <input type = \"submit\" name = \"Submit\" value = \"Submit\">\n");
      out.write("                <input type = \"reset\" value = \"Reset\">\n");
      out.write("            </p>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
