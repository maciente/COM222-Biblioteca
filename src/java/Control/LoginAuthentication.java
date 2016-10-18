package Control;

import Model.Associado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAuthentication extends HttpServlet {

    private String senha;
    private int codigo;
    private Associado associado;
    private AssociadoDao dao;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            codigo = Integer.parseInt(request.getParameter("codigo"));
            senha = request.getParameter("senha");
            dao = new AssociadoDao();
            associado = dao.login(codigo, senha);
            if (associado.getCodigo() == codigo) {
                out.println("Bem-vindo " + associado.getNome());
            } else {
                out.println("Não existe usuário com o código <b>" + codigo + "</b> ou a senha está incorreta ");
                out.println("<a href='login.jsp'><br>Tente Novamente</a>");
            }
        } catch (Exception ex) {
            out.println("Error: " + ex.getMessage());
            return;
        }
    }
}
